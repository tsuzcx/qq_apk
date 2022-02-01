package com.tencent.wcdb.database;

import android.os.SystemClock;
import android.util.Printer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.CancellationSignal.OnCancelListener;
import com.tencent.wcdb.support.Log;
import com.tencent.wcdb.support.OperationCanceledException;
import com.tencent.wcdb.support.PrefixPrinter;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;
import org.json.JSONArray;
import org.json.JSONObject;

public final class SQLiteConnectionPool
  implements Closeable
{
  public static final int CONNECTION_FLAG_INTERACTIVE = 4;
  public static final int CONNECTION_FLAG_PRIMARY_CONNECTION_AFFINITY = 2;
  public static final int CONNECTION_FLAG_READ_ONLY = 1;
  private static final long CONNECTION_POOL_BUSY_MILLIS = 3000L;
  private static final int OPEN_FLAG_REOPEN_MASK = 268435473;
  private static final String TAG = "WCDB.SQLiteConnectionPool";
  private final WeakHashMap<SQLiteConnection, SQLiteConnectionPool.AcquiredConnectionStatus> mAcquiredConnections;
  private final ArrayList<SQLiteConnection> mAvailableNonPrimaryConnections;
  private SQLiteConnection mAvailablePrimaryConnection;
  private volatile SQLiteChangeListener mChangeListener;
  private volatile SQLiteCheckpointListener mCheckpointListener;
  private SQLiteCipherSpec mCipher;
  private final SQLiteDatabaseConfiguration mConfiguration;
  private final AtomicBoolean mConnectionLeaked;
  private ConnectionWaiter mConnectionWaiterPool;
  private ConnectionWaiter mConnectionWaiterQueue;
  private final WeakReference<SQLiteDatabase> mDB;
  private boolean mIsOpen;
  private final Object mLock;
  private int mMaxConnectionPoolSize;
  private int mNextConnectionId;
  private byte[] mPassword;
  private volatile SQLiteTrace mTraceCallback;
  
  static
  {
    AppMethodBeat.i(3088);
    if (!SQLiteConnectionPool.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(3088);
      return;
    }
  }
  
  private SQLiteConnectionPool(SQLiteDatabase paramSQLiteDatabase, SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, int paramInt)
  {
    AppMethodBeat.i(3045);
    this.mLock = new Object();
    this.mConnectionLeaked = new AtomicBoolean();
    this.mAvailableNonPrimaryConnections = new ArrayList();
    this.mAcquiredConnections = new WeakHashMap();
    this.mDB = new WeakReference(paramSQLiteDatabase);
    this.mConfiguration = new SQLiteDatabaseConfiguration(paramSQLiteDatabaseConfiguration);
    setMaxConnectionPoolSizeLocked(paramInt);
    AppMethodBeat.o(3045);
  }
  
  private void cancelConnectionWaiterLocked(ConnectionWaiter paramConnectionWaiter)
  {
    AppMethodBeat.i(3068);
    if ((paramConnectionWaiter.mAssignedConnection != null) || (paramConnectionWaiter.mException != null))
    {
      AppMethodBeat.o(3068);
      return;
    }
    Object localObject1 = this.mConnectionWaiterQueue;
    Object localObject2 = null;
    while (localObject1 != paramConnectionWaiter)
    {
      if ((!$assertionsDisabled) && (localObject1 == null))
      {
        paramConnectionWaiter = new AssertionError();
        AppMethodBeat.o(3068);
        throw paramConnectionWaiter;
      }
      ConnectionWaiter localConnectionWaiter = ((ConnectionWaiter)localObject1).mNext;
      localObject2 = localObject1;
      localObject1 = localConnectionWaiter;
    }
    if (localObject2 != null) {
      localObject2.mNext = paramConnectionWaiter.mNext;
    }
    for (;;)
    {
      paramConnectionWaiter.mException = new OperationCanceledException();
      LockSupport.unpark(paramConnectionWaiter.mThread);
      wakeConnectionWaitersLocked();
      AppMethodBeat.o(3068);
      return;
      this.mConnectionWaiterQueue = paramConnectionWaiter.mNext;
    }
  }
  
  private void closeAvailableConnectionsAndLogExceptionsLocked()
  {
    AppMethodBeat.i(3060);
    closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked();
    if (this.mAvailablePrimaryConnection != null)
    {
      closeConnectionAndLogExceptionsLocked(this.mAvailablePrimaryConnection);
      this.mAvailablePrimaryConnection = null;
    }
    AppMethodBeat.o(3060);
  }
  
  private void closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked()
  {
    AppMethodBeat.i(3061);
    int j = this.mAvailableNonPrimaryConnections.size();
    int i = 0;
    while (i < j)
    {
      closeConnectionAndLogExceptionsLocked((SQLiteConnection)this.mAvailableNonPrimaryConnections.get(i));
      i += 1;
    }
    this.mAvailableNonPrimaryConnections.clear();
    AppMethodBeat.o(3061);
  }
  
  private void closeConnectionAndLogExceptionsLocked(SQLiteConnection paramSQLiteConnection)
  {
    AppMethodBeat.i(3063);
    try
    {
      paramSQLiteConnection.close();
      AppMethodBeat.o(3063);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.e("WCDB.SQLiteConnectionPool", "Failed to close connection, its fate is now in the hands of the merciful GC: " + paramSQLiteConnection + localRuntimeException.getMessage());
      AppMethodBeat.o(3063);
    }
  }
  
  private void closeExcessConnectionsAndLogExceptionsLocked()
  {
    AppMethodBeat.i(3062);
    int j;
    for (int i = this.mAvailableNonPrimaryConnections.size();; i = j)
    {
      j = i - 1;
      if (i <= this.mMaxConnectionPoolSize - 1) {
        break;
      }
      closeConnectionAndLogExceptionsLocked((SQLiteConnection)this.mAvailableNonPrimaryConnections.remove(j));
    }
    AppMethodBeat.o(3062);
  }
  
  private void discardAcquiredConnectionsLocked()
  {
    AppMethodBeat.i(3064);
    markAcquiredConnectionsLocked(SQLiteConnectionPool.AcquiredConnectionStatus.DISCARD);
    AppMethodBeat.o(3064);
  }
  
  private void dispose(boolean paramBoolean)
  {
    AppMethodBeat.i(3051);
    if (!paramBoolean) {
      synchronized (this.mLock)
      {
        throwIfClosedLocked();
        this.mIsOpen = false;
        closeAvailableConnectionsAndLogExceptionsLocked();
        int i = this.mAcquiredConnections.size();
        if (i != 0) {
          Log.i("WCDB.SQLiteConnectionPool", "The connection pool for " + this.mConfiguration.label + " has been closed but there are still " + i + " connections in use.  They will be closed as they are released back to the pool.");
        }
        wakeConnectionWaitersLocked();
        AppMethodBeat.o(3051);
        return;
      }
    }
    AppMethodBeat.o(3051);
  }
  
  private void finishAcquireConnectionLocked(SQLiteConnection paramSQLiteConnection, int paramInt)
  {
    AppMethodBeat.i(3074);
    if ((paramInt & 0x1) != 0) {}
    for (boolean bool = true;; bool = false) {
      try
      {
        paramSQLiteConnection.setOnlyAllowReadOnlyOperations(bool);
        this.mAcquiredConnections.put(paramSQLiteConnection, SQLiteConnectionPool.AcquiredConnectionStatus.NORMAL);
        AppMethodBeat.o(3074);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        Log.e("WCDB.SQLiteConnectionPool", "Failed to prepare acquired connection for session, closing it: " + paramSQLiteConnection + ", connectionFlags=" + paramInt);
        closeConnectionAndLogExceptionsLocked(paramSQLiteConnection);
        AppMethodBeat.o(3074);
        throw localRuntimeException;
      }
    }
  }
  
  private ConnectionPoolBusyInfo gatherConnectionPoolBusyInfoLocked()
  {
    AppMethodBeat.i(3070);
    ConnectionPoolBusyInfo localConnectionPoolBusyInfo = new ConnectionPoolBusyInfo(null);
    localConnectionPoolBusyInfo.activeConnections = 0;
    localConnectionPoolBusyInfo.idleConnections = 0;
    if (!this.mAcquiredConnections.isEmpty())
    {
      Iterator localIterator = this.mAcquiredConnections.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (SQLiteConnection)localIterator.next();
        SQLiteTrace.TraceInfo localTraceInfo = ((SQLiteConnection)localObject).tracePersistAcquisitionUnsafe();
        if (localTraceInfo != null) {
          localConnectionPoolBusyInfo.activeTransactions.add(localTraceInfo);
        }
        localTraceInfo = ((SQLiteConnection)localObject).traceCurrentOperationUnsafe();
        if (localTraceInfo != null)
        {
          localConnectionPoolBusyInfo.activeSql.add(localTraceInfo);
          localObject = ((SQLiteConnection)localObject).describeCurrentOperationUnsafe();
          if (localObject != null) {
            localConnectionPoolBusyInfo.activeOperationDescriptions.add(localObject);
          }
          localConnectionPoolBusyInfo.activeConnections += 1;
        }
        else
        {
          localConnectionPoolBusyInfo.idleConnections += 1;
        }
      }
    }
    localConnectionPoolBusyInfo.availableConnections = this.mAvailableNonPrimaryConnections.size();
    if (this.mAvailablePrimaryConnection != null) {
      localConnectionPoolBusyInfo.availableConnections += 1;
    }
    AppMethodBeat.o(3070);
    return localConnectionPoolBusyInfo;
  }
  
  private static int getPriority(int paramInt)
  {
    if ((paramInt & 0x4) != 0) {
      return 1;
    }
    return 0;
  }
  
  private boolean isSessionBlockingImportantConnectionWaitersLocked(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(3075);
    Object localObject = this.mConnectionWaiterQueue;
    if (localObject != null)
    {
      paramInt = getPriority(paramInt);
      ConnectionWaiter localConnectionWaiter;
      do
      {
        if (paramInt > ((ConnectionWaiter)localObject).mPriority) {
          break;
        }
        if ((paramBoolean) || (!((ConnectionWaiter)localObject).mWantPrimaryConnection))
        {
          AppMethodBeat.o(3075);
          return true;
        }
        localConnectionWaiter = ((ConnectionWaiter)localObject).mNext;
        localObject = localConnectionWaiter;
      } while (localConnectionWaiter != null);
    }
    AppMethodBeat.o(3075);
    return false;
  }
  
  private void logConnectionPoolBusy(ConnectionPoolBusyInfo paramConnectionPoolBusyInfo, long paramLong, int paramInt)
  {
    AppMethodBeat.i(3069);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject;
    if (paramLong != 0L)
    {
      localObject = Thread.currentThread();
      localStringBuilder.append("The connection pool for database '").append(paramConnectionPoolBusyInfo.label);
      localStringBuilder.append("' has been unable to grant a connection to thread ");
      localStringBuilder.append(((Thread)localObject).getId()).append(" (").append(((Thread)localObject).getName()).append(") ");
      localStringBuilder.append("with flags 0x").append(Integer.toHexString(paramInt));
      localStringBuilder.append(" for ").append((float)paramLong * 0.001F).append(" seconds.\n");
    }
    localStringBuilder.append("Connections: ").append(paramConnectionPoolBusyInfo.activeConnections).append(" active, ");
    localStringBuilder.append(paramConnectionPoolBusyInfo.idleConnections).append(" idle, ");
    localStringBuilder.append(paramConnectionPoolBusyInfo.availableConnections).append(" available.\n");
    if (!paramConnectionPoolBusyInfo.activeOperationDescriptions.isEmpty())
    {
      localStringBuilder.append("\nRequests in progress:\n");
      paramConnectionPoolBusyInfo = paramConnectionPoolBusyInfo.activeOperationDescriptions.iterator();
      while (paramConnectionPoolBusyInfo.hasNext())
      {
        localObject = (String)paramConnectionPoolBusyInfo.next();
        localStringBuilder.append("  ").append((String)localObject).append("\n");
      }
    }
    Log.w("WCDB.SQLiteConnectionPool", localStringBuilder.toString());
    AppMethodBeat.o(3069);
  }
  
  private void markAcquiredConnectionsLocked(SQLiteConnectionPool.AcquiredConnectionStatus paramAcquiredConnectionStatus)
  {
    AppMethodBeat.i(3066);
    if (!this.mAcquiredConnections.isEmpty())
    {
      ArrayList localArrayList = new ArrayList(this.mAcquiredConnections.size());
      Iterator localIterator = this.mAcquiredConnections.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        SQLiteConnectionPool.AcquiredConnectionStatus localAcquiredConnectionStatus = (SQLiteConnectionPool.AcquiredConnectionStatus)localEntry.getValue();
        if ((paramAcquiredConnectionStatus != localAcquiredConnectionStatus) && (localAcquiredConnectionStatus != SQLiteConnectionPool.AcquiredConnectionStatus.DISCARD)) {
          localArrayList.add(localEntry.getKey());
        }
      }
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        this.mAcquiredConnections.put(localArrayList.get(i), paramAcquiredConnectionStatus);
        i += 1;
      }
    }
    AppMethodBeat.o(3066);
  }
  
  private ConnectionWaiter obtainConnectionWaiterLocked(Thread paramThread, long paramLong, int paramInt1, boolean paramBoolean, String paramString, int paramInt2)
  {
    AppMethodBeat.i(3078);
    ConnectionWaiter localConnectionWaiter = this.mConnectionWaiterPool;
    if (localConnectionWaiter != null)
    {
      this.mConnectionWaiterPool = localConnectionWaiter.mNext;
      localConnectionWaiter.mNext = null;
    }
    for (;;)
    {
      localConnectionWaiter.mThread = paramThread;
      localConnectionWaiter.mStartTime = paramLong;
      localConnectionWaiter.mPriority = paramInt1;
      localConnectionWaiter.mWantPrimaryConnection = paramBoolean;
      localConnectionWaiter.mSql = paramString;
      localConnectionWaiter.mConnectionFlags = paramInt2;
      AppMethodBeat.o(3078);
      return localConnectionWaiter;
      localConnectionWaiter = new ConnectionWaiter(null);
    }
  }
  
  public static SQLiteConnectionPool open(SQLiteDatabase paramSQLiteDatabase, SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec)
  {
    AppMethodBeat.i(3047);
    paramSQLiteDatabase = open(paramSQLiteDatabase, paramSQLiteDatabaseConfiguration, paramArrayOfByte, paramSQLiteCipherSpec, 1);
    AppMethodBeat.o(3047);
    return paramSQLiteDatabase;
  }
  
  public static SQLiteConnectionPool open(SQLiteDatabase paramSQLiteDatabase, SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, int paramInt)
  {
    AppMethodBeat.i(3048);
    if (paramSQLiteDatabaseConfiguration == null)
    {
      paramSQLiteDatabase = new IllegalArgumentException("configuration must not be null.");
      AppMethodBeat.o(3048);
      throw paramSQLiteDatabase;
    }
    paramSQLiteDatabaseConfiguration = new SQLiteConnectionPool(paramSQLiteDatabase, paramSQLiteDatabaseConfiguration, paramInt);
    paramSQLiteDatabaseConfiguration.mPassword = paramArrayOfByte;
    if (paramSQLiteCipherSpec == null) {}
    for (paramSQLiteDatabase = null;; paramSQLiteDatabase = new SQLiteCipherSpec(paramSQLiteCipherSpec))
    {
      paramSQLiteDatabaseConfiguration.mCipher = paramSQLiteDatabase;
      paramSQLiteDatabaseConfiguration.open();
      AppMethodBeat.o(3048);
      return paramSQLiteDatabaseConfiguration;
    }
  }
  
  private void open()
  {
    AppMethodBeat.i(3049);
    this.mAvailablePrimaryConnection = openConnectionLocked(this.mConfiguration, true);
    this.mIsOpen = true;
    AppMethodBeat.o(3049);
  }
  
  private SQLiteConnection openConnectionLocked(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, boolean paramBoolean)
  {
    AppMethodBeat.i(3058);
    int i = this.mNextConnectionId;
    this.mNextConnectionId = (i + 1);
    paramSQLiteDatabaseConfiguration = SQLiteConnection.open(this, paramSQLiteDatabaseConfiguration, i, paramBoolean, this.mPassword, this.mCipher);
    AppMethodBeat.o(3058);
    return paramSQLiteDatabaseConfiguration;
  }
  
  private void reconfigureAllConnectionsLocked()
  {
    AppMethodBeat.i(3065);
    if (this.mAvailablePrimaryConnection != null) {}
    try
    {
      this.mAvailablePrimaryConnection.reconfigure(this.mConfiguration);
      j = this.mAvailableNonPrimaryConnections.size();
      i = 0;
      if (i < j) {
        localSQLiteConnection = (SQLiteConnection)this.mAvailableNonPrimaryConnections.get(i);
      }
    }
    catch (RuntimeException localRuntimeException1)
    {
      try
      {
        for (;;)
        {
          SQLiteConnection localSQLiteConnection;
          localSQLiteConnection.reconfigure(this.mConfiguration);
          i += 1;
        }
        localRuntimeException1 = localRuntimeException1;
        Log.e("WCDB.SQLiteConnectionPool", "Failed to reconfigure available primary connection, closing it: " + this.mAvailablePrimaryConnection, new Object[] { localRuntimeException1 });
        closeConnectionAndLogExceptionsLocked(this.mAvailablePrimaryConnection);
        this.mAvailablePrimaryConnection = null;
      }
      catch (RuntimeException localRuntimeException2)
      {
        for (;;)
        {
          int j;
          Log.e("WCDB.SQLiteConnectionPool", "Failed to reconfigure available non-primary connection, closing it: ".concat(String.valueOf(localRuntimeException1)), new Object[] { localRuntimeException2 });
          closeConnectionAndLogExceptionsLocked(localRuntimeException1);
          ArrayList localArrayList = this.mAvailableNonPrimaryConnections;
          int k = i - 1;
          localArrayList.remove(i);
          j -= 1;
          int i = k;
        }
      }
      markAcquiredConnectionsLocked(SQLiteConnectionPool.AcquiredConnectionStatus.RECONFIGURE);
      AppMethodBeat.o(3065);
    }
  }
  
  private boolean recycleConnectionLocked(SQLiteConnection paramSQLiteConnection, SQLiteConnectionPool.AcquiredConnectionStatus paramAcquiredConnectionStatus)
  {
    AppMethodBeat.i(3055);
    SQLiteConnectionPool.AcquiredConnectionStatus localAcquiredConnectionStatus = paramAcquiredConnectionStatus;
    if (paramAcquiredConnectionStatus == SQLiteConnectionPool.AcquiredConnectionStatus.RECONFIGURE) {}
    try
    {
      paramSQLiteConnection.reconfigure(this.mConfiguration);
      localAcquiredConnectionStatus = paramAcquiredConnectionStatus;
    }
    catch (RuntimeException paramAcquiredConnectionStatus)
    {
      for (;;)
      {
        Log.e("WCDB.SQLiteConnectionPool", "Failed to reconfigure released connection, closing it: ".concat(String.valueOf(paramSQLiteConnection)), new Object[] { paramAcquiredConnectionStatus });
        localAcquiredConnectionStatus = SQLiteConnectionPool.AcquiredConnectionStatus.DISCARD;
      }
      AppMethodBeat.o(3055);
    }
    if (localAcquiredConnectionStatus == SQLiteConnectionPool.AcquiredConnectionStatus.DISCARD)
    {
      closeConnectionAndLogExceptionsLocked(paramSQLiteConnection);
      AppMethodBeat.o(3055);
      return false;
    }
    return true;
  }
  
  private void recycleConnectionWaiterLocked(ConnectionWaiter paramConnectionWaiter)
  {
    paramConnectionWaiter.mNext = this.mConnectionWaiterPool;
    paramConnectionWaiter.mThread = null;
    paramConnectionWaiter.mSql = null;
    paramConnectionWaiter.mAssignedConnection = null;
    paramConnectionWaiter.mException = null;
    paramConnectionWaiter.mNonce += 1;
    this.mConnectionWaiterPool = paramConnectionWaiter;
  }
  
  private void setMaxConnectionPoolSizeLocked(int paramInt)
  {
    AppMethodBeat.i(3076);
    int i = paramInt;
    if (paramInt <= 0) {
      if ((this.mConfiguration.openFlags & 0x20000000) == 0) {
        break label62;
      }
    }
    label62:
    for (i = 4;; i = 1)
    {
      this.mMaxConnectionPoolSize = i;
      Log.i("WCDB.SQLiteConnectionPool", "Max connection pool size is %d.", new Object[] { Integer.valueOf(this.mMaxConnectionPoolSize) });
      AppMethodBeat.o(3076);
      return;
    }
  }
  
  private void throwIfClosedLocked()
  {
    AppMethodBeat.i(3077);
    if (!this.mIsOpen)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Cannot perform this operation because the connection pool has been closed.");
      AppMethodBeat.o(3077);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(3077);
  }
  
  private SQLiteConnection tryAcquireNonPrimaryConnectionLocked(String paramString, int paramInt)
  {
    AppMethodBeat.i(3073);
    int j = this.mAvailableNonPrimaryConnections.size();
    if ((j > 1) && (paramString != null))
    {
      i = 0;
      while (i < j)
      {
        SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.mAvailableNonPrimaryConnections.get(i);
        if (localSQLiteConnection.isPreparedStatementInCache(paramString))
        {
          this.mAvailableNonPrimaryConnections.remove(i);
          finishAcquireConnectionLocked(localSQLiteConnection, paramInt);
          AppMethodBeat.o(3073);
          return localSQLiteConnection;
        }
        i += 1;
      }
    }
    if (j > 0)
    {
      paramString = (SQLiteConnection)this.mAvailableNonPrimaryConnections.remove(j - 1);
      finishAcquireConnectionLocked(paramString, paramInt);
      AppMethodBeat.o(3073);
      return paramString;
    }
    j = this.mAcquiredConnections.size();
    int i = j;
    if (this.mAvailablePrimaryConnection != null) {
      i = j + 1;
    }
    if (i >= this.mMaxConnectionPoolSize)
    {
      AppMethodBeat.o(3073);
      return null;
    }
    paramString = openConnectionLocked(this.mConfiguration, false);
    finishAcquireConnectionLocked(paramString, paramInt);
    AppMethodBeat.o(3073);
    return paramString;
  }
  
  private SQLiteConnection tryAcquirePrimaryConnectionLocked(int paramInt)
  {
    AppMethodBeat.i(3072);
    Object localObject = this.mAvailablePrimaryConnection;
    if (localObject != null)
    {
      this.mAvailablePrimaryConnection = null;
      finishAcquireConnectionLocked((SQLiteConnection)localObject, paramInt);
      AppMethodBeat.o(3072);
      return localObject;
    }
    localObject = this.mAcquiredConnections.keySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((SQLiteConnection)((Iterator)localObject).next()).isPrimaryConnection())
      {
        AppMethodBeat.o(3072);
        return null;
      }
    }
    localObject = openConnectionLocked(this.mConfiguration, true);
    finishAcquireConnectionLocked((SQLiteConnection)localObject, paramInt);
    AppMethodBeat.o(3072);
    return localObject;
  }
  
  /* Error */
  private SQLiteConnection waitForConnection(String paramString, int paramInt, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: sipush 3067
    //   3: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_2
    //   7: iconst_2
    //   8: iand
    //   9: ifeq +76 -> 85
    //   12: iconst_1
    //   13: istore 5
    //   15: aload_0
    //   16: getfield 94	com/tencent/wcdb/database/SQLiteConnectionPool:mLock	Ljava/lang/Object;
    //   19: astore 16
    //   21: aload 16
    //   23: monitorenter
    //   24: aload_0
    //   25: invokespecial 240	com/tencent/wcdb/database/SQLiteConnectionPool:throwIfClosedLocked	()V
    //   28: aload_3
    //   29: ifnull +7 -> 36
    //   32: aload_3
    //   33: invokevirtual 536	com/tencent/wcdb/support/CancellationSignal:throwIfCanceled	()V
    //   36: aconst_null
    //   37: astore 12
    //   39: iload 5
    //   41: ifne +11 -> 52
    //   44: aload_0
    //   45: aload_1
    //   46: iload_2
    //   47: invokespecial 538	com/tencent/wcdb/database/SQLiteConnectionPool:tryAcquireNonPrimaryConnectionLocked	(Ljava/lang/String;I)Lcom/tencent/wcdb/database/SQLiteConnection;
    //   50: astore 12
    //   52: aload 12
    //   54: astore 13
    //   56: aload 12
    //   58: ifnonnull +10 -> 68
    //   61: aload_0
    //   62: iload_2
    //   63: invokespecial 540	com/tencent/wcdb/database/SQLiteConnectionPool:tryAcquirePrimaryConnectionLocked	(I)Lcom/tencent/wcdb/database/SQLiteConnection;
    //   66: astore 13
    //   68: aload 13
    //   70: ifnull +21 -> 91
    //   73: aload 16
    //   75: monitorexit
    //   76: sipush 3067
    //   79: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload 13
    //   84: areturn
    //   85: iconst_0
    //   86: istore 5
    //   88: goto -73 -> 15
    //   91: iload_2
    //   92: invokestatic 340	com/tencent/wcdb/database/SQLiteConnectionPool:getPriority	(I)I
    //   95: istore 4
    //   97: invokestatic 545	android/os/SystemClock:uptimeMillis	()J
    //   100: lstore 6
    //   102: aload_0
    //   103: invokestatic 355	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   106: lload 6
    //   108: iload 4
    //   110: iload 5
    //   112: aload_1
    //   113: iload_2
    //   114: invokespecial 547	com/tencent/wcdb/database/SQLiteConnectionPool:obtainConnectionWaiterLocked	(Ljava/lang/Thread;JIZLjava/lang/String;I)Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter;
    //   117: astore 15
    //   119: aload_0
    //   120: getfield 143	com/tencent/wcdb/database/SQLiteConnectionPool:mConnectionWaiterQueue	Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter;
    //   123: astore 12
    //   125: aconst_null
    //   126: astore 13
    //   128: aload 12
    //   130: ifnull +20 -> 150
    //   133: iload 4
    //   135: aload 12
    //   137: getfield 343	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter:mPriority	I
    //   140: if_icmple +178 -> 318
    //   143: aload 15
    //   145: aload 12
    //   147: putfield 149	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter:mNext	Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter;
    //   150: aload 13
    //   152: ifnull +184 -> 336
    //   155: aload 13
    //   157: aload 15
    //   159: putfield 149	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter:mNext	Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter;
    //   162: aload 15
    //   164: getfield 500	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter:mNonce	I
    //   167: istore 4
    //   169: aload 16
    //   171: monitorexit
    //   172: aload_3
    //   173: ifnull +19 -> 192
    //   176: aload_3
    //   177: new 8	com/tencent/wcdb/database/SQLiteConnectionPool$1
    //   180: dup
    //   181: aload_0
    //   182: aload 15
    //   184: iload 4
    //   186: invokespecial 550	com/tencent/wcdb/database/SQLiteConnectionPool$1:<init>	(Lcom/tencent/wcdb/database/SQLiteConnectionPool;Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter;I)V
    //   189: invokevirtual 554	com/tencent/wcdb/support/CancellationSignal:setOnCancelListener	(Lcom/tencent/wcdb/support/CancellationSignal$OnCancelListener;)V
    //   192: ldc2_w 28
    //   195: lstore 6
    //   197: aload 15
    //   199: getfield 431	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter:mStartTime	J
    //   202: ldc2_w 28
    //   205: ladd
    //   206: lstore 8
    //   208: aload_0
    //   209: getfield 99	com/tencent/wcdb/database/SQLiteConnectionPool:mConnectionLeaked	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   212: iconst_1
    //   213: iconst_0
    //   214: invokevirtual 558	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   217: ifeq +19 -> 236
    //   220: aload_0
    //   221: getfield 94	com/tencent/wcdb/database/SQLiteConnectionPool:mLock	Ljava/lang/Object;
    //   224: astore 12
    //   226: aload 12
    //   228: monitorenter
    //   229: aload_0
    //   230: invokespecial 165	com/tencent/wcdb/database/SQLiteConnectionPool:wakeConnectionWaitersLocked	()V
    //   233: aload 12
    //   235: monitorexit
    //   236: ldc2_w 559
    //   239: lload 6
    //   241: lmul
    //   242: invokestatic 564	java/util/concurrent/locks/LockSupport:parkNanos	(J)V
    //   245: invokestatic 567	java/lang/Thread:interrupted	()Z
    //   248: pop
    //   249: aload_0
    //   250: getfield 94	com/tencent/wcdb/database/SQLiteConnectionPool:mLock	Ljava/lang/Object;
    //   253: astore 13
    //   255: aload 13
    //   257: monitorenter
    //   258: aload_0
    //   259: invokespecial 240	com/tencent/wcdb/database/SQLiteConnectionPool:throwIfClosedLocked	()V
    //   262: aload 15
    //   264: getfield 137	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter:mAssignedConnection	Lcom/tencent/wcdb/database/SQLiteConnection;
    //   267: astore 12
    //   269: aload 15
    //   271: getfield 141	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter:mException	Ljava/lang/RuntimeException;
    //   274: astore 14
    //   276: aload 12
    //   278: ifnonnull +8 -> 286
    //   281: aload 14
    //   283: ifnull +125 -> 408
    //   286: aload_0
    //   287: aload 15
    //   289: invokespecial 569	com/tencent/wcdb/database/SQLiteConnectionPool:recycleConnectionWaiterLocked	(Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter;)V
    //   292: aload 12
    //   294: ifnull +93 -> 387
    //   297: aload 13
    //   299: monitorexit
    //   300: aload_3
    //   301: ifnull +8 -> 309
    //   304: aload_3
    //   305: aconst_null
    //   306: invokevirtual 554	com/tencent/wcdb/support/CancellationSignal:setOnCancelListener	(Lcom/tencent/wcdb/support/CancellationSignal$OnCancelListener;)V
    //   309: sipush 3067
    //   312: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   315: aload 12
    //   317: areturn
    //   318: aload 12
    //   320: getfield 149	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter:mNext	Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter;
    //   323: astore 14
    //   325: aload 12
    //   327: astore 13
    //   329: aload 14
    //   331: astore 12
    //   333: goto -205 -> 128
    //   336: aload_0
    //   337: aload 15
    //   339: putfield 143	com/tencent/wcdb/database/SQLiteConnectionPool:mConnectionWaiterQueue	Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter;
    //   342: goto -180 -> 162
    //   345: astore_1
    //   346: aload 16
    //   348: monitorexit
    //   349: sipush 3067
    //   352: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   355: aload_1
    //   356: athrow
    //   357: astore_1
    //   358: aload 12
    //   360: monitorexit
    //   361: sipush 3067
    //   364: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   367: aload_1
    //   368: athrow
    //   369: astore_1
    //   370: aload_3
    //   371: ifnull +8 -> 379
    //   374: aload_3
    //   375: aconst_null
    //   376: invokevirtual 554	com/tencent/wcdb/support/CancellationSignal:setOnCancelListener	(Lcom/tencent/wcdb/support/CancellationSignal$OnCancelListener;)V
    //   379: sipush 3067
    //   382: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   385: aload_1
    //   386: athrow
    //   387: sipush 3067
    //   390: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   393: aload 14
    //   395: athrow
    //   396: astore_1
    //   397: aload 13
    //   399: monitorexit
    //   400: sipush 3067
    //   403: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   406: aload_1
    //   407: athrow
    //   408: invokestatic 545	android/os/SystemClock:uptimeMillis	()J
    //   411: lstore 10
    //   413: lload 10
    //   415: lload 8
    //   417: lcmp
    //   418: ifge +95 -> 513
    //   421: lload 10
    //   423: lload 8
    //   425: lsub
    //   426: lstore 6
    //   428: aconst_null
    //   429: astore 12
    //   431: aload 13
    //   433: monitorexit
    //   434: aload 12
    //   436: ifnull +74 -> 510
    //   439: lload 10
    //   441: aload 15
    //   443: getfield 431	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter:mStartTime	J
    //   446: lsub
    //   447: lstore 10
    //   449: aload_0
    //   450: aload 12
    //   452: lload 10
    //   454: iload_2
    //   455: invokespecial 571	com/tencent/wcdb/database/SQLiteConnectionPool:logConnectionPoolBusy	(Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionPoolBusyInfo;JI)V
    //   458: aload_0
    //   459: getfield 116	com/tencent/wcdb/database/SQLiteConnectionPool:mDB	Ljava/lang/ref/WeakReference;
    //   462: invokevirtual 573	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   465: checkcast 575	com/tencent/wcdb/database/SQLiteDatabase
    //   468: astore 13
    //   470: aload_0
    //   471: getfield 577	com/tencent/wcdb/database/SQLiteConnectionPool:mTraceCallback	Lcom/tencent/wcdb/database/SQLiteTrace;
    //   474: astore 14
    //   476: aload 13
    //   478: ifnull +32 -> 510
    //   481: aload 14
    //   483: ifnull +27 -> 510
    //   486: aload 14
    //   488: aload 13
    //   490: aload_1
    //   491: lload 10
    //   493: iload 5
    //   495: aload 12
    //   497: getfield 325	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionPoolBusyInfo:activeSql	Ljava/util/ArrayList;
    //   500: aload 12
    //   502: getfield 315	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionPoolBusyInfo:activeTransactions	Ljava/util/ArrayList;
    //   505: invokeinterface 583 8 0
    //   510: goto -302 -> 208
    //   513: aload_0
    //   514: invokespecial 585	com/tencent/wcdb/database/SQLiteConnectionPool:gatherConnectionPoolBusyInfoLocked	()Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionPoolBusyInfo;
    //   517: astore 12
    //   519: ldc2_w 28
    //   522: lstore 6
    //   524: ldc2_w 28
    //   527: lload 10
    //   529: ladd
    //   530: lstore 8
    //   532: goto -101 -> 431
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	535	0	this	SQLiteConnectionPool
    //   0	535	1	paramString	String
    //   0	535	2	paramInt	int
    //   0	535	3	paramCancellationSignal	CancellationSignal
    //   95	90	4	i	int
    //   13	481	5	bool	boolean
    //   100	423	6	l1	long
    //   206	325	8	l2	long
    //   411	117	10	l3	long
    //   274	213	14	localObject3	Object
    //   117	325	15	localConnectionWaiter	ConnectionWaiter
    //   19	328	16	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   24	28	345	finally
    //   32	36	345	finally
    //   44	52	345	finally
    //   61	68	345	finally
    //   73	76	345	finally
    //   91	125	345	finally
    //   133	150	345	finally
    //   155	162	345	finally
    //   162	172	345	finally
    //   318	325	345	finally
    //   336	342	345	finally
    //   229	236	357	finally
    //   197	208	369	finally
    //   208	229	369	finally
    //   236	258	369	finally
    //   358	369	369	finally
    //   397	408	369	finally
    //   439	476	369	finally
    //   486	510	369	finally
    //   258	276	396	finally
    //   286	292	396	finally
    //   297	300	396	finally
    //   387	396	396	finally
    //   408	413	396	finally
    //   431	434	396	finally
    //   513	519	396	finally
  }
  
  private void wakeConnectionWaitersLocked()
  {
    AppMethodBeat.i(3071);
    Object localObject1 = this.mConnectionWaiterQueue;
    int j = 0;
    int i = 0;
    Object localObject4 = null;
    int m;
    int k;
    Object localObject2;
    label62:
    label76:
    int n;
    for (;;)
    {
      if (localObject1 != null) {
        if (!this.mIsOpen)
        {
          m = 1;
          k = i;
          i = m;
          localObject2 = ((ConnectionWaiter)localObject1).mNext;
          if (i == 0) {
            break label267;
          }
          if (localObject4 != null)
          {
            localObject4.mNext = ((ConnectionWaiter)localObject2);
            ((ConnectionWaiter)localObject1).mNext = null;
            LockSupport.unpark(((ConnectionWaiter)localObject1).mThread);
            localObject1 = localObject2;
            i = k;
          }
        }
        else
        {
          n = j;
          m = i;
        }
      }
    }
    for (;;)
    {
      try
      {
        if ((((ConnectionWaiter)localObject1).mWantPrimaryConnection) || (j != 0)) {
          break label281;
        }
        n = j;
        m = i;
        Object localObject5 = tryAcquireNonPrimaryConnectionLocked(((ConnectionWaiter)localObject1).mSql, ((ConnectionWaiter)localObject1).mConnectionFlags);
        localObject2 = localObject5;
        if (localObject5 == null)
        {
          j = 1;
          localObject2 = localObject5;
        }
        localObject5 = localObject2;
        k = i;
        if (localObject2 == null)
        {
          localObject5 = localObject2;
          k = i;
          if (i == 0)
          {
            n = j;
            m = i;
            localObject2 = tryAcquirePrimaryConnectionLocked(((ConnectionWaiter)localObject1).mConnectionFlags);
            localObject5 = localObject2;
            k = i;
            if (localObject2 == null)
            {
              k = 1;
              localObject5 = localObject2;
            }
          }
        }
        if (localObject5 != null)
        {
          n = j;
          m = k;
          ((ConnectionWaiter)localObject1).mAssignedConnection = ((SQLiteConnection)localObject5);
          i = 1;
          break;
        }
        if ((j != 0) && (k != 0))
        {
          AppMethodBeat.o(3071);
          return;
        }
        i = 0;
      }
      catch (RuntimeException localRuntimeException)
      {
        ((ConnectionWaiter)localObject1).mException = localRuntimeException;
        i = 1;
        j = n;
        k = m;
      }
      break;
      this.mConnectionWaiterQueue = localRuntimeException;
      break label62;
      label267:
      localObject4 = localObject1;
      break label76;
      AppMethodBeat.o(3071);
      return;
      label281:
      Object localObject3 = null;
    }
  }
  
  public final SQLiteConnection acquireConnection(String paramString, int paramInt, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3053);
    long l1 = SystemClock.uptimeMillis();
    paramCancellationSignal = waitForConnection(paramString, paramInt, paramCancellationSignal);
    SQLiteTrace localSQLiteTrace = this.mTraceCallback;
    long l2;
    SQLiteDatabase localSQLiteDatabase;
    if (localSQLiteTrace != null)
    {
      l2 = SystemClock.uptimeMillis();
      localSQLiteDatabase = (SQLiteDatabase)this.mDB.get();
      if (localSQLiteDatabase != null) {
        if ((paramInt & 0x2) == 0) {
          break label86;
        }
      }
    }
    label86:
    for (boolean bool = true;; bool = false)
    {
      localSQLiteTrace.onConnectionObtained(localSQLiteDatabase, paramString, l2 - l1, bool);
      AppMethodBeat.o(3053);
      return paramCancellationSignal;
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(3050);
    dispose(false);
    AppMethodBeat.o(3050);
  }
  
  public final void collectDbStats(ArrayList<SQLiteDebug.DbStats> paramArrayList)
  {
    AppMethodBeat.i(3057);
    synchronized (this.mLock)
    {
      if (this.mAvailablePrimaryConnection != null) {
        this.mAvailablePrimaryConnection.collectDbStats(paramArrayList);
      }
      localIterator = this.mAvailableNonPrimaryConnections.iterator();
      if (localIterator.hasNext()) {
        ((SQLiteConnection)localIterator.next()).collectDbStats(paramArrayList);
      }
    }
    Iterator localIterator = this.mAcquiredConnections.keySet().iterator();
    while (localIterator.hasNext()) {
      ((SQLiteConnection)localIterator.next()).collectDbStatsUnsafe(paramArrayList);
    }
    AppMethodBeat.o(3057);
  }
  
  final void dump(Printer paramPrinter, boolean paramBoolean)
  {
    AppMethodBeat.i(3084);
    Printer localPrinter = PrefixPrinter.create(paramPrinter, "    ");
    int i;
    synchronized (this.mLock)
    {
      paramPrinter.println("Connection pool for " + this.mConfiguration.path + ":");
      paramPrinter.println("  Open: " + this.mIsOpen);
      paramPrinter.println("  Max connections: " + this.mMaxConnectionPoolSize);
      paramPrinter.println("  Available primary connection:");
      if (this.mAvailablePrimaryConnection != null)
      {
        this.mAvailablePrimaryConnection.dump(localPrinter, paramBoolean);
        paramPrinter.println("  Available non-primary connections:");
        if (!this.mAvailableNonPrimaryConnections.isEmpty())
        {
          int j = this.mAvailableNonPrimaryConnections.size();
          i = 0;
          while (i < j)
          {
            ((SQLiteConnection)this.mAvailableNonPrimaryConnections.get(i)).dump(localPrinter, paramBoolean);
            i += 1;
          }
        }
      }
      else
      {
        localPrinter.println("<none>");
      }
    }
    localPrinter.println("<none>");
    paramPrinter.println("  Acquired connections:");
    if (!this.mAcquiredConnections.isEmpty())
    {
      Iterator localIterator = this.mAcquiredConnections.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ((SQLiteConnection)localEntry.getKey()).dump(localPrinter, paramBoolean);
        localPrinter.println("  Status: " + localEntry.getValue());
      }
    }
    localPrinter.println("<none>");
    paramPrinter.println("  Connection waiters:");
    if (this.mConnectionWaiterQueue != null)
    {
      long l = SystemClock.uptimeMillis();
      paramPrinter = this.mConnectionWaiterQueue;
      i = 0;
      while (paramPrinter != null)
      {
        localPrinter.println(i + ": waited for " + (l - paramPrinter.mStartTime) + " ms - thread=" + paramPrinter.mThread + ", priority=" + paramPrinter.mPriority + ", sql='" + paramPrinter.mSql + "'");
        paramPrinter = paramPrinter.mNext;
        i += 1;
      }
    }
    localPrinter.println("<none>");
    AppMethodBeat.o(3084);
  }
  
  final JSONObject dumpJSON(boolean paramBoolean)
  {
    AppMethodBeat.i(3085);
    JSONArray localJSONArray2;
    JSONObject localJSONObject;
    Object localObject4;
    synchronized (this.mLock)
    {
      localObject3 = new JSONArray();
      JSONArray localJSONArray1 = new JSONArray();
      localJSONArray2 = new JSONArray();
      localJSONObject = new JSONObject().put("path", this.mConfiguration.path).put("open", this.mIsOpen).put("maxConn", this.mMaxConnectionPoolSize).put("availablePrimary", null).put("availableNonPrimary", localObject3).put("acquired", localJSONArray1).put("waiters", localJSONArray2);
      localObject4 = this.mAvailableNonPrimaryConnections.iterator();
      if (((Iterator)localObject4).hasNext()) {
        ((JSONArray)localObject3).put(((SQLiteConnection)((Iterator)localObject4).next()).dumpJSON(paramBoolean));
      }
    }
    Object localObject3 = this.mAcquiredConnections.entrySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Map.Entry)((Iterator)localObject3).next();
      localObject1.put(((SQLiteConnection)((Map.Entry)localObject4).getKey()).dumpJSON(paramBoolean).put("status", ((SQLiteConnectionPool.AcquiredConnectionStatus)((Map.Entry)localObject4).getValue()).toString()));
    }
    for (ConnectionWaiter localConnectionWaiter = this.mConnectionWaiterQueue; localConnectionWaiter != null; localConnectionWaiter = localConnectionWaiter.mNext)
    {
      long l = SystemClock.uptimeMillis();
      localJSONArray2.put(new JSONObject().put("duration", l - localConnectionWaiter.mStartTime).put("thread", localConnectionWaiter.mThread.toString()).put("priority", localConnectionWaiter.mPriority).put("sql", localConnectionWaiter.mSql));
    }
    AppMethodBeat.o(3085);
    return localJSONObject;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(3046);
    try
    {
      dispose(true);
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(3046);
    }
  }
  
  final SQLiteChangeListener getChangeListener()
  {
    return this.mChangeListener;
  }
  
  final SQLiteCheckpointListener getCheckpointListener()
  {
    return this.mCheckpointListener;
  }
  
  final SQLiteTrace getTraceCallback()
  {
    return this.mTraceCallback;
  }
  
  final void notifyChanges(String paramString1, String paramString2, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    AppMethodBeat.i(3080);
    SQLiteDatabase localSQLiteDatabase = (SQLiteDatabase)this.mDB.get();
    SQLiteChangeListener localSQLiteChangeListener = this.mChangeListener;
    if ((localSQLiteChangeListener == null) || (localSQLiteDatabase == null))
    {
      AppMethodBeat.o(3080);
      return;
    }
    localSQLiteChangeListener.onChange(localSQLiteDatabase, paramString1, paramString2, paramArrayOfLong1, paramArrayOfLong2, paramArrayOfLong3);
    AppMethodBeat.o(3080);
  }
  
  final void notifyCheckpoint(String paramString, int paramInt)
  {
    AppMethodBeat.i(3083);
    SQLiteDatabase localSQLiteDatabase = (SQLiteDatabase)this.mDB.get();
    SQLiteCheckpointListener localSQLiteCheckpointListener = this.mCheckpointListener;
    if ((localSQLiteCheckpointListener == null) || (localSQLiteDatabase == null))
    {
      AppMethodBeat.o(3083);
      return;
    }
    localSQLiteCheckpointListener.onWALCommit(localSQLiteDatabase, paramString, paramInt);
    AppMethodBeat.o(3083);
  }
  
  final void onConnectionLeaked()
  {
    AppMethodBeat.i(3059);
    Log.w("WCDB.SQLiteConnectionPool", "A SQLiteConnection object for database '" + this.mConfiguration.label + "' was leaked!  Please fix your application to end transactions in progress properly and to close the database when it is no longer needed.");
    this.mConnectionLeaked.set(true);
    AppMethodBeat.o(3059);
  }
  
  public final void reconfigure(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
    int j = 1;
    AppMethodBeat.i(3052);
    if (paramSQLiteDatabaseConfiguration == null)
    {
      paramSQLiteDatabaseConfiguration = new IllegalArgumentException("configuration must not be null.");
      AppMethodBeat.o(3052);
      throw paramSQLiteDatabaseConfiguration;
    }
    int i;
    for (;;)
    {
      synchronized (this.mLock)
      {
        throwIfClosedLocked();
        if (((paramSQLiteDatabaseConfiguration.openFlags ^ this.mConfiguration.openFlags) & 0x20000000) != 0)
        {
          i = 1;
          if (i == 0) {
            break label119;
          }
          if (this.mAcquiredConnections.isEmpty()) {
            break;
          }
          paramSQLiteDatabaseConfiguration = new IllegalStateException("Write Ahead Logging (WAL) mode cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");
          AppMethodBeat.o(3052);
          throw paramSQLiteDatabaseConfiguration;
        }
      }
      i = 0;
    }
    closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked();
    label119:
    if (paramSQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled != this.mConfiguration.foreignKeyConstraintsEnabled) {}
    for (;;)
    {
      if ((j != 0) && (!this.mAcquiredConnections.isEmpty()))
      {
        paramSQLiteDatabaseConfiguration = new IllegalStateException("Foreign Key Constraints cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");
        AppMethodBeat.o(3052);
        throw paramSQLiteDatabaseConfiguration;
      }
      if ((((this.mConfiguration.openFlags ^ paramSQLiteDatabaseConfiguration.openFlags) & 0x10000011) != 0) || (!DatabaseUtils.objectEquals(this.mConfiguration.vfsName, paramSQLiteDatabaseConfiguration.vfsName)) || (!paramSQLiteDatabaseConfiguration.extensions.containsAll(this.mConfiguration.extensions)))
      {
        if (i != 0) {
          closeAvailableConnectionsAndLogExceptionsLocked();
        }
        SQLiteConnection localSQLiteConnection = openConnectionLocked(paramSQLiteDatabaseConfiguration, true);
        closeAvailableConnectionsAndLogExceptionsLocked();
        discardAcquiredConnectionsLocked();
        this.mAvailablePrimaryConnection = localSQLiteConnection;
        this.mConfiguration.updateParametersFrom(paramSQLiteDatabaseConfiguration);
        setMaxConnectionPoolSizeLocked(0);
      }
      for (;;)
      {
        wakeConnectionWaitersLocked();
        AppMethodBeat.o(3052);
        return;
        this.mConfiguration.updateParametersFrom(paramSQLiteDatabaseConfiguration);
        setMaxConnectionPoolSizeLocked(0);
        closeExcessConnectionsAndLogExceptionsLocked();
        reconfigureAllConnectionsLocked();
      }
      j = 0;
    }
  }
  
  public final void releaseConnection(SQLiteConnection paramSQLiteConnection)
  {
    AppMethodBeat.i(3054);
    SQLiteConnectionPool.AcquiredConnectionStatus localAcquiredConnectionStatus;
    synchronized (this.mLock)
    {
      localAcquiredConnectionStatus = (SQLiteConnectionPool.AcquiredConnectionStatus)this.mAcquiredConnections.remove(paramSQLiteConnection);
      if (localAcquiredConnectionStatus == null)
      {
        paramSQLiteConnection = new IllegalStateException("Cannot perform this operation because the specified connection was not acquired from this pool or has already been released.");
        AppMethodBeat.o(3054);
        throw paramSQLiteConnection;
      }
    }
    if (!this.mIsOpen) {
      closeConnectionAndLogExceptionsLocked(paramSQLiteConnection);
    }
    for (;;)
    {
      AppMethodBeat.o(3054);
      return;
      if (paramSQLiteConnection.isPrimaryConnection())
      {
        if (recycleConnectionLocked(paramSQLiteConnection, localAcquiredConnectionStatus))
        {
          if ((!$assertionsDisabled) && (this.mAvailablePrimaryConnection != null))
          {
            paramSQLiteConnection = new AssertionError();
            AppMethodBeat.o(3054);
            throw paramSQLiteConnection;
          }
          this.mAvailablePrimaryConnection = paramSQLiteConnection;
        }
        wakeConnectionWaitersLocked();
      }
      else if (this.mAvailableNonPrimaryConnections.size() >= this.mMaxConnectionPoolSize - 1)
      {
        closeConnectionAndLogExceptionsLocked(paramSQLiteConnection);
      }
      else
      {
        if (recycleConnectionLocked(paramSQLiteConnection, localAcquiredConnectionStatus)) {
          this.mAvailableNonPrimaryConnections.add(paramSQLiteConnection);
        }
        wakeConnectionWaitersLocked();
      }
    }
  }
  
  final void setChangeListener(SQLiteChangeListener paramSQLiteChangeListener, boolean paramBoolean)
  {
    AppMethodBeat.i(3079);
    boolean bool;
    if (paramSQLiteChangeListener != null) {
      bool = true;
    }
    for (;;)
    {
      if (!bool) {
        paramBoolean = false;
      }
      synchronized (this.mLock)
      {
        if ((this.mConfiguration.updateNotificationEnabled != bool) || (this.mConfiguration.updateNotificationRowID != paramBoolean))
        {
          this.mConfiguration.updateNotificationEnabled = bool;
          this.mConfiguration.updateNotificationRowID = paramBoolean;
          closeExcessConnectionsAndLogExceptionsLocked();
          reconfigureAllConnectionsLocked();
        }
        this.mChangeListener = paramSQLiteChangeListener;
        AppMethodBeat.o(3079);
        return;
        bool = false;
      }
    }
  }
  
  final void setCheckpointListener(SQLiteCheckpointListener paramSQLiteCheckpointListener)
  {
    AppMethodBeat.i(3082);
    SQLiteDatabase localSQLiteDatabase = (SQLiteDatabase)this.mDB.get();
    if (this.mCheckpointListener != null) {
      this.mCheckpointListener.onDetach(localSQLiteDatabase);
    }
    this.mCheckpointListener = paramSQLiteCheckpointListener;
    if (this.mCheckpointListener != null) {
      this.mCheckpointListener.onAttach(localSQLiteDatabase);
    }
    AppMethodBeat.o(3082);
  }
  
  final void setTraceCallback(SQLiteTrace paramSQLiteTrace)
  {
    this.mTraceCallback = paramSQLiteTrace;
  }
  
  public final boolean shouldYieldConnection(SQLiteConnection paramSQLiteConnection, int paramInt)
  {
    AppMethodBeat.i(3056);
    synchronized (this.mLock)
    {
      if (!this.mAcquiredConnections.containsKey(paramSQLiteConnection))
      {
        paramSQLiteConnection = new IllegalStateException("Cannot perform this operation because the specified connection was not acquired from this pool or has already been released.");
        AppMethodBeat.o(3056);
        throw paramSQLiteConnection;
      }
    }
    if (!this.mIsOpen)
    {
      AppMethodBeat.o(3056);
      return false;
    }
    boolean bool = isSessionBlockingImportantConnectionWaitersLocked(paramSQLiteConnection.isPrimaryConnection(), paramInt);
    AppMethodBeat.o(3056);
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(3086);
    String str = "SQLiteConnectionPool: " + this.mConfiguration.path;
    AppMethodBeat.o(3086);
    return str;
  }
  
  final void traceExecute(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(3081);
    SQLiteDatabase localSQLiteDatabase = (SQLiteDatabase)this.mDB.get();
    SQLiteTrace localSQLiteTrace = this.mTraceCallback;
    if ((localSQLiteTrace == null) || (localSQLiteDatabase == null))
    {
      AppMethodBeat.o(3081);
      return;
    }
    localSQLiteTrace.onSQLExecuted(localSQLiteDatabase, paramString, paramInt, paramLong);
    AppMethodBeat.o(3081);
  }
  
  static class ConnectionPoolBusyInfo
  {
    int activeConnections;
    ArrayList<String> activeOperationDescriptions;
    ArrayList<SQLiteTrace.TraceInfo<String>> activeSql;
    ArrayList<SQLiteTrace.TraceInfo<StackTraceElement[]>> activeTransactions;
    int availableConnections;
    int idleConnections;
    String label;
    
    private ConnectionPoolBusyInfo()
    {
      AppMethodBeat.i(3044);
      this.activeOperationDescriptions = new ArrayList();
      this.activeSql = new ArrayList();
      this.activeTransactions = new ArrayList();
      AppMethodBeat.o(3044);
    }
  }
  
  static final class ConnectionWaiter
  {
    public SQLiteConnection mAssignedConnection;
    public int mConnectionFlags;
    public RuntimeException mException;
    public ConnectionWaiter mNext;
    public int mNonce;
    public int mPriority;
    public String mSql;
    public long mStartTime;
    public Thread mThread;
    public boolean mWantPrimaryConnection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteConnectionPool
 * JD-Core Version:    0.7.0.1
 */