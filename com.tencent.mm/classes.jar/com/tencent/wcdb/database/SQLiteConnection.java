package com.tencent.wcdb.database;

import android.annotation.SuppressLint;
import android.util.Pair;
import android.util.Printer;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.CancellationSignal.OnCancelListener;
import com.tencent.wcdb.support.Log;
import com.tencent.wcdb.support.LruCache;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SQLiteConnection
  implements CancellationSignal.OnCancelListener
{
  private static final boolean DEBUG = false;
  private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  private static final String[] EMPTY_STRING_ARRAY = new String[0];
  private static final String TAG = "WCDB.SQLiteConnection";
  private static final Pattern TRIM_SQL_PATTERN = Pattern.compile("[\\s]*\\n+[\\s]*");
  private Thread mAcquiredThread;
  private int mAcquiredTid;
  private int mCancellationSignalAttachCount;
  private SQLiteCipherSpec mCipher;
  private final SQLiteDatabaseConfiguration mConfiguration;
  private final int mConnectionId;
  private long mConnectionPtr;
  private final boolean mIsPrimaryConnection;
  private final boolean mIsReadOnlyConnection;
  private int mNativeHandleCount;
  private Operation mNativeOperation;
  private boolean mOnlyAllowReadOnlyOperations;
  private byte[] mPassword;
  private final SQLiteConnectionPool mPool;
  private final PreparedStatementCache mPreparedStatementCache;
  private PreparedStatement mPreparedStatementPool;
  private final OperationLog mRecentOperations = new OperationLog(null);
  
  private SQLiteConnection(SQLiteConnectionPool paramSQLiteConnectionPool, SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, int paramInt, boolean paramBoolean, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec)
  {
    this.mPassword = paramArrayOfByte;
    if (paramSQLiteCipherSpec == null)
    {
      paramArrayOfByte = localObject;
      this.mCipher = paramArrayOfByte;
      this.mPool = paramSQLiteConnectionPool;
      this.mConfiguration = new SQLiteDatabaseConfiguration(paramSQLiteDatabaseConfiguration);
      this.mConnectionId = paramInt;
      this.mIsPrimaryConnection = paramBoolean;
      if ((paramSQLiteDatabaseConfiguration.openFlags & 0x1) == 0) {
        break label121;
      }
    }
    label121:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.mIsReadOnlyConnection = paramBoolean;
      this.mPreparedStatementCache = new PreparedStatementCache(this.mConfiguration.maxSqlCacheSize);
      return;
      paramArrayOfByte = new SQLiteCipherSpec(paramSQLiteCipherSpec);
      break;
    }
  }
  
  private void applyBlockGuardPolicy(PreparedStatement paramPreparedStatement) {}
  
  private void attachCancellationSignal(CancellationSignal paramCancellationSignal)
  {
    if (paramCancellationSignal != null)
    {
      paramCancellationSignal.throwIfCanceled();
      this.mCancellationSignalAttachCount += 1;
      if (this.mCancellationSignalAttachCount == 1)
      {
        nativeResetCancel(this.mConnectionPtr, true);
        paramCancellationSignal.setOnCancelListener(this);
      }
    }
  }
  
  private void bindArguments(PreparedStatement paramPreparedStatement, Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject != null) {}
    for (int i = paramArrayOfObject.length; i != paramPreparedStatement.mNumParameters; i = 0) {
      throw new SQLiteBindOrColumnIndexOutOfRangeException("Expected " + paramPreparedStatement.mNumParameters + " bind arguments but " + i + " were provided.");
    }
    if (i == 0) {}
    long l2;
    int j;
    do
    {
      return;
      l2 = paramPreparedStatement.getPtr();
      j = 0;
    } while (j >= i);
    paramPreparedStatement = paramArrayOfObject[j];
    long l1;
    switch (DatabaseUtils.getTypeOfObject(paramPreparedStatement))
    {
    case 3: 
    default: 
      if ((paramPreparedStatement instanceof Boolean))
      {
        long l3 = this.mConnectionPtr;
        if (((Boolean)paramPreparedStatement).booleanValue())
        {
          l1 = 1L;
          label150:
          nativeBindLong(l3, l2, j + 1, l1);
        }
      }
      break;
    }
    for (;;)
    {
      j += 1;
      break;
      nativeBindNull(this.mConnectionPtr, l2, j + 1);
      continue;
      nativeBindLong(this.mConnectionPtr, l2, j + 1, ((Number)paramPreparedStatement).longValue());
      continue;
      nativeBindDouble(this.mConnectionPtr, l2, j + 1, ((Number)paramPreparedStatement).doubleValue());
      continue;
      nativeBindBlob(this.mConnectionPtr, l2, j + 1, (byte[])paramPreparedStatement);
      continue;
      l1 = 0L;
      break label150;
      nativeBindString(this.mConnectionPtr, l2, j + 1, paramPreparedStatement.toString());
    }
  }
  
  private void detachCancellationSignal(CancellationSignal paramCancellationSignal)
  {
    if (paramCancellationSignal != null)
    {
      this.mCancellationSignalAttachCount -= 1;
      if (this.mCancellationSignalAttachCount == 0)
      {
        paramCancellationSignal.setOnCancelListener(null);
        nativeResetCancel(this.mConnectionPtr, false);
      }
    }
  }
  
  private void dispose(boolean paramBoolean)
  {
    int i;
    if (this.mConnectionPtr != 0L) {
      i = this.mRecentOperations.beginOperation("close", null, null).mCookie;
    }
    try
    {
      this.mPreparedStatementCache.evictAll();
      nativeClose(this.mConnectionPtr);
      this.mConnectionPtr = 0L;
      return;
    }
    finally
    {
      this.mRecentOperations.endOperation(i);
    }
  }
  
  private void finalizePreparedStatement(PreparedStatement paramPreparedStatement)
  {
    nativeFinalizeStatement(this.mConnectionPtr, paramPreparedStatement.getPtr());
    recyclePreparedStatement(paramPreparedStatement);
  }
  
  private SQLiteDebug.DbStats getMainDbStatsUnsafe(int paramInt, long paramLong1, long paramLong2)
  {
    String str2 = this.mConfiguration.path;
    String str1 = str2;
    if (!this.mIsPrimaryConnection) {
      str1 = str2 + " (" + this.mConnectionId + ")";
    }
    return new SQLiteDebug.DbStats(str1, paramLong1, paramLong2, paramInt, this.mPreparedStatementCache.hitCount(), this.mPreparedStatementCache.missCount(), this.mPreparedStatementCache.size());
  }
  
  private static boolean isCacheable(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 1);
  }
  
  private static native void nativeBindBlob(long paramLong1, long paramLong2, int paramInt, byte[] paramArrayOfByte);
  
  private static native void nativeBindDouble(long paramLong1, long paramLong2, int paramInt, double paramDouble);
  
  private static native void nativeBindLong(long paramLong1, long paramLong2, int paramInt, long paramLong3);
  
  private static native void nativeBindNull(long paramLong1, long paramLong2, int paramInt);
  
  private static native void nativeBindString(long paramLong1, long paramLong2, int paramInt, String paramString);
  
  private static native void nativeCancel(long paramLong);
  
  private static native void nativeClose(long paramLong);
  
  private static native void nativeExecute(long paramLong1, long paramLong2);
  
  private static native int nativeExecuteForChangedRowCount(long paramLong1, long paramLong2);
  
  private static native long nativeExecuteForCursorWindow(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, boolean paramBoolean);
  
  private static native long nativeExecuteForLastInsertedRowId(long paramLong1, long paramLong2);
  
  private static native long nativeExecuteForLong(long paramLong1, long paramLong2);
  
  private static native String nativeExecuteForString(long paramLong1, long paramLong2);
  
  private static native void nativeFinalizeStatement(long paramLong1, long paramLong2);
  
  private static native int nativeGetColumnCount(long paramLong1, long paramLong2);
  
  private static native String nativeGetColumnName(long paramLong1, long paramLong2, int paramInt);
  
  private static native int nativeGetDbLookaside(long paramLong);
  
  private static native int nativeGetParameterCount(long paramLong1, long paramLong2);
  
  private static native boolean nativeIsReadOnly(long paramLong1, long paramLong2);
  
  private native long nativeOpen(String paramString1, int paramInt, String paramString2);
  
  private static native long nativePrepareStatement(long paramLong, String paramString);
  
  private static native void nativeRegisterCustomFunction(long paramLong, SQLiteCustomFunction paramSQLiteCustomFunction);
  
  private static native void nativeRegisterLocalizedCollators(long paramLong, String paramString);
  
  private static native void nativeResetCancel(long paramLong, boolean paramBoolean);
  
  private static native void nativeResetStatement(long paramLong1, long paramLong2, boolean paramBoolean);
  
  private static native long nativeSQLiteHandle(long paramLong, boolean paramBoolean);
  
  private static native void nativeSetKey(long paramLong, byte[] paramArrayOfByte);
  
  private static native void nativeSetUpdateNotification(long paramLong, boolean paramBoolean1, boolean paramBoolean2);
  
  private static native void nativeSetWalHook(long paramLong);
  
  private static native long nativeWalCheckpoint(long paramLong, String paramString);
  
  private void notifyChange(String paramString1, String paramString2, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    this.mPool.notifyChanges(paramString1, paramString2, paramArrayOfLong1, paramArrayOfLong2, paramArrayOfLong3);
  }
  
  private void notifyCheckpoint(String paramString, int paramInt)
  {
    this.mPool.notifyCheckpoint(paramString, paramInt);
  }
  
  private PreparedStatement obtainPreparedStatement(String paramString, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    PreparedStatement localPreparedStatement = this.mPreparedStatementPool;
    if (localPreparedStatement != null)
    {
      this.mPreparedStatementPool = localPreparedStatement.mPoolNext;
      PreparedStatement.access$702(localPreparedStatement, null);
      PreparedStatement.access$502(localPreparedStatement, false);
    }
    for (;;)
    {
      PreparedStatement.access$602(localPreparedStatement, paramString);
      PreparedStatement.access$802(localPreparedStatement, paramLong);
      PreparedStatement.access$202(localPreparedStatement, paramInt1);
      PreparedStatement.access$102(localPreparedStatement, paramInt2);
      PreparedStatement.access$302(localPreparedStatement, paramBoolean);
      return localPreparedStatement;
      localPreparedStatement = new PreparedStatement(this);
    }
  }
  
  static SQLiteConnection open(SQLiteConnectionPool paramSQLiteConnectionPool, SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, int paramInt, boolean paramBoolean, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec)
  {
    paramSQLiteConnectionPool = new SQLiteConnection(paramSQLiteConnectionPool, paramSQLiteDatabaseConfiguration, paramInt, paramBoolean, paramArrayOfByte, paramSQLiteCipherSpec);
    try
    {
      paramSQLiteConnectionPool.open();
      return paramSQLiteConnectionPool;
    }
    catch (SQLiteException paramSQLiteDatabaseConfiguration)
    {
      SQLiteDebug.collectLastIOTraceStats(paramSQLiteConnectionPool);
      paramSQLiteConnectionPool.dispose(false);
      throw paramSQLiteDatabaseConfiguration;
    }
  }
  
  private void open()
  {
    this.mConnectionPtr = nativeOpen(this.mConfiguration.path, this.mConfiguration.openFlags, this.mConfiguration.vfsName);
    if ((this.mPassword != null) && (this.mPassword.length == 0)) {
      this.mPassword = null;
    }
    if (this.mPassword != null)
    {
      nativeSetKey(this.mConnectionPtr, this.mPassword);
      setCipherSpec();
    }
    setPageSize();
    setReadOnlyFromConfiguration();
    setForeignKeyModeFromConfiguration();
    setWalModeFromConfiguration();
    setSyncModeFromConfiguration();
    setJournalSizeLimit();
    setCheckpointStrategy();
    setLocaleFromConfiguration();
    setUpdateNotificationFromConfiguration();
    int j = this.mConfiguration.customFunctions.size();
    int i = 0;
    while (i < j)
    {
      SQLiteCustomFunction localSQLiteCustomFunction = (SQLiteCustomFunction)this.mConfiguration.customFunctions.get(i);
      nativeRegisterCustomFunction(this.mConnectionPtr, localSQLiteCustomFunction);
      i += 1;
    }
  }
  
  private void recyclePreparedStatement(PreparedStatement paramPreparedStatement)
  {
    PreparedStatement.access$602(paramPreparedStatement, null);
    PreparedStatement.access$702(paramPreparedStatement, this.mPreparedStatementPool);
    this.mPreparedStatementPool = paramPreparedStatement;
  }
  
  private void resetStatement(PreparedStatement paramPreparedStatement, boolean paramBoolean)
  {
    nativeResetStatement(this.mConnectionPtr, paramPreparedStatement.getPtr(), paramBoolean);
  }
  
  private void setCheckpointStrategy()
  {
    if ((!this.mConfiguration.isInMemoryDb()) && (!this.mIsReadOnlyConnection))
    {
      if (!this.mConfiguration.customWALHookEnabled) {
        break label35;
      }
      nativeSetWalHook(this.mConnectionPtr);
    }
    label35:
    while (executeForLong("PRAGMA wal_autocheckpoint", null, null) == 100L) {
      return;
    }
    executeForLong("PRAGMA wal_autocheckpoint=100", null, null);
  }
  
  private void setCipherSpec()
  {
    if (this.mCipher != null)
    {
      if (this.mCipher.cipher != null) {
        execute("PRAGMA cipher=" + DatabaseUtils.sqlEscapeString(this.mCipher.cipher), null, null);
      }
      if (this.mCipher.kdfIteration != 0) {
        execute("PRAGMA kdf_iter=" + this.mCipher.kdfIteration, null, null);
      }
      execute("PRAGMA cipher_use_hmac=" + this.mCipher.hmacEnabled, null, null);
    }
  }
  
  private void setForeignKeyModeFromConfiguration()
  {
    if (!this.mIsReadOnlyConnection) {
      if (!this.mConfiguration.foreignKeyConstraintsEnabled) {
        break label57;
      }
    }
    label57:
    for (long l = 1L;; l = 0L)
    {
      if (executeForLong("PRAGMA foreign_keys", null, null) != l) {
        execute("PRAGMA foreign_keys=" + l, null, null);
      }
      return;
    }
  }
  
  private void setJournalMode(String paramString)
  {
    String str = executeForString("PRAGMA journal_mode", null, null);
    if (!str.equalsIgnoreCase(paramString)) {}
    try
    {
      boolean bool = executeForString("PRAGMA journal_mode=" + paramString, null, null).equalsIgnoreCase(paramString);
      if (bool) {
        return;
      }
    }
    catch (SQLiteDatabaseLockedException localSQLiteDatabaseLockedException)
    {
      Log.w("WCDB.SQLiteConnection", "Could not change the database journal mode of '" + this.mConfiguration.label + "' from '" + str + "' to '" + paramString + "' because the database is locked.  This usually means that there are other open connections to the database which prevents the database from enabling or disabling write-ahead logging mode.  Proceeding without changing the journal mode.");
    }
  }
  
  private void setJournalSizeLimit()
  {
    if ((!this.mConfiguration.isInMemoryDb()) && (!this.mIsReadOnlyConnection) && (executeForLong("PRAGMA journal_size_limit", null, null) != 524288L)) {
      executeForLong("PRAGMA journal_size_limit=524288", null, null);
    }
  }
  
  /* Error */
  private void setLocaleFromConfiguration()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 101	com/tencent/wcdb/database/SQLiteConnection:mConfiguration	Lcom/tencent/wcdb/database/SQLiteDatabaseConfiguration;
    //   4: astore_1
    //   5: aload_1
    //   6: aload_1
    //   7: getfield 108	com/tencent/wcdb/database/SQLiteDatabaseConfiguration:openFlags	I
    //   10: bipush 16
    //   12: ior
    //   13: putfield 108	com/tencent/wcdb/database/SQLiteDatabaseConfiguration:openFlags	I
    //   16: aload_0
    //   17: getfield 101	com/tencent/wcdb/database/SQLiteConnection:mConfiguration	Lcom/tencent/wcdb/database/SQLiteDatabaseConfiguration;
    //   20: getfield 108	com/tencent/wcdb/database/SQLiteDatabaseConfiguration:openFlags	I
    //   23: bipush 16
    //   25: iand
    //   26: ifeq +4 -> 30
    //   29: return
    //   30: aload_0
    //   31: getfield 101	com/tencent/wcdb/database/SQLiteConnection:mConfiguration	Lcom/tencent/wcdb/database/SQLiteDatabaseConfiguration;
    //   34: getfield 567	com/tencent/wcdb/database/SQLiteDatabaseConfiguration:locale	Ljava/util/Locale;
    //   37: invokevirtual 570	java/util/Locale:toString	()Ljava/lang/String;
    //   40: astore_1
    //   41: aload_0
    //   42: getfield 176	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   45: aload_1
    //   46: invokestatic 572	com/tencent/wcdb/database/SQLiteConnection:nativeRegisterLocalizedCollators	(JLjava/lang/String;)V
    //   49: aload_0
    //   50: getfield 110	com/tencent/wcdb/database/SQLiteConnection:mIsReadOnlyConnection	Z
    //   53: ifne -24 -> 29
    //   56: aload_0
    //   57: ldc_w 574
    //   60: aconst_null
    //   61: aconst_null
    //   62: invokevirtual 500	com/tencent/wcdb/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   65: aload_0
    //   66: ldc_w 576
    //   69: aconst_null
    //   70: aconst_null
    //   71: invokevirtual 532	com/tencent/wcdb/database/SQLiteConnection:executeForString	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)Ljava/lang/String;
    //   74: astore_2
    //   75: aload_2
    //   76: ifnull +11 -> 87
    //   79: aload_2
    //   80: aload_1
    //   81: invokevirtual 580	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifne -55 -> 29
    //   87: aload_0
    //   88: ldc_w 582
    //   91: aconst_null
    //   92: aconst_null
    //   93: invokevirtual 500	com/tencent/wcdb/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   96: aload_0
    //   97: ldc_w 584
    //   100: aconst_null
    //   101: aconst_null
    //   102: invokevirtual 500	com/tencent/wcdb/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   105: aload_0
    //   106: ldc_w 586
    //   109: iconst_1
    //   110: anewarray 4	java/lang/Object
    //   113: dup
    //   114: iconst_0
    //   115: aload_1
    //   116: aastore
    //   117: aconst_null
    //   118: invokevirtual 500	com/tencent/wcdb/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   121: aload_0
    //   122: ldc_w 588
    //   125: aconst_null
    //   126: aconst_null
    //   127: invokevirtual 500	com/tencent/wcdb/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   130: aload_0
    //   131: ldc_w 590
    //   134: aconst_null
    //   135: aconst_null
    //   136: invokevirtual 500	com/tencent/wcdb/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   139: return
    //   140: astore_2
    //   141: new 405	com/tencent/wcdb/database/SQLiteException
    //   144: dup
    //   145: new 192	java/lang/StringBuilder
    //   148: dup
    //   149: ldc_w 592
    //   152: invokespecial 197	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   155: aload_0
    //   156: getfield 101	com/tencent/wcdb/database/SQLiteConnection:mConfiguration	Lcom/tencent/wcdb/database/SQLiteDatabaseConfiguration;
    //   159: getfield 543	com/tencent/wcdb/database/SQLiteDatabaseConfiguration:label	Ljava/lang/String;
    //   162: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc_w 547
    //   168: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_1
    //   172: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: ldc_w 594
    //   178: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: aload_2
    //   185: invokespecial 597	com/tencent/wcdb/database/SQLiteException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   188: athrow
    //   189: astore_2
    //   190: aload_0
    //   191: ldc_w 599
    //   194: aconst_null
    //   195: aconst_null
    //   196: invokevirtual 500	com/tencent/wcdb/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   199: aload_2
    //   200: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	SQLiteConnection
    //   4	168	1	localObject1	Object
    //   74	6	2	str	String
    //   140	45	2	localRuntimeException	RuntimeException
    //   189	11	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   56	75	140	java/lang/RuntimeException
    //   79	87	140	java/lang/RuntimeException
    //   87	96	140	java/lang/RuntimeException
    //   130	139	140	java/lang/RuntimeException
    //   190	201	140	java/lang/RuntimeException
    //   96	130	189	finally
  }
  
  private void setPageSize()
  {
    String str;
    long l;
    if (!this.mConfiguration.isInMemoryDb())
    {
      if (this.mPassword == null) {
        break label98;
      }
      str = "PRAGMA cipher_page_size";
      if ((this.mCipher != null) && (this.mCipher.pageSize > 0)) {
        break label86;
      }
      l = SQLiteGlobal.defaultPageSize;
    }
    for (;;)
    {
      if (executeForLong(str, null, null) != l) {
        execute(str + "=" + l, null, null);
      }
      return;
      label86:
      l = this.mCipher.pageSize;
      continue;
      label98:
      str = "PRAGMA page_size";
      l = SQLiteGlobal.defaultPageSize;
    }
  }
  
  private void setReadOnlyFromConfiguration()
  {
    if (this.mIsReadOnlyConnection) {
      execute("PRAGMA query_only = 1", null, null);
    }
  }
  
  private void setSyncModeFromConfiguration()
  {
    int i = this.mConfiguration.synchronousMode;
    execute("PRAGMA synchronous=" + i, null, null);
  }
  
  private void setUpdateNotificationFromConfiguration()
  {
    nativeSetUpdateNotification(this.mConnectionPtr, this.mConfiguration.updateNotificationEnabled, this.mConfiguration.updateNotificationRowID);
  }
  
  private void setWalModeFromConfiguration()
  {
    if ((!this.mConfiguration.isInMemoryDb()) && (!this.mIsReadOnlyConnection)) {
      if ((this.mConfiguration.openFlags & 0x20000000) == 0) {
        break label41;
      }
    }
    label41:
    for (String str = "WAL";; str = "PERSIST")
    {
      setJournalMode(str);
      return;
    }
  }
  
  private void throwIfStatementForbidden(PreparedStatement paramPreparedStatement)
  {
    if ((this.mOnlyAllowReadOnlyOperations) && (!paramPreparedStatement.mReadOnly)) {
      throw new SQLiteException("Cannot execute this statement because it might modify the database but the connection is read-only.");
    }
  }
  
  private static String trimSqlForDisplay(String paramString)
  {
    return TRIM_SQL_PATTERN.matcher(paramString).replaceAll(" ");
  }
  
  final PreparedStatement acquirePreparedStatement(String paramString)
  {
    PreparedStatement localPreparedStatement2 = (PreparedStatement)this.mPreparedStatementCache.get(paramString);
    if (localPreparedStatement2 != null) {
      if (!localPreparedStatement2.mInUse)
      {
        PreparedStatement.access$402(localPreparedStatement2, true);
        return localPreparedStatement2;
      }
    }
    for (int i = 1;; i = 0)
    {
      long l = nativePrepareStatement(this.mConnectionPtr, paramString);
      PreparedStatement localPreparedStatement1 = localPreparedStatement2;
      try
      {
        int j = nativeGetParameterCount(this.mConnectionPtr, l);
        localPreparedStatement1 = localPreparedStatement2;
        int k = DatabaseUtils.getSqlStatementType(paramString);
        localPreparedStatement1 = localPreparedStatement2;
        localPreparedStatement2 = obtainPreparedStatement(paramString, l, j, k, nativeIsReadOnly(this.mConnectionPtr, l));
        if (i == 0)
        {
          localPreparedStatement1 = localPreparedStatement2;
          if (isCacheable(k))
          {
            localPreparedStatement1 = localPreparedStatement2;
            this.mPreparedStatementCache.put(paramString, localPreparedStatement2);
            localPreparedStatement1 = localPreparedStatement2;
            PreparedStatement.access$502(localPreparedStatement2, true);
          }
        }
        PreparedStatement.access$402(localPreparedStatement2, true);
        return localPreparedStatement2;
      }
      catch (RuntimeException paramString)
      {
        if ((localPreparedStatement1 == null) || (!localPreparedStatement1.mInCache)) {
          nativeFinalizeStatement(this.mConnectionPtr, l);
        }
        throw paramString;
      }
    }
  }
  
  final void close()
  {
    dispose(false);
  }
  
  final void collectDbStats(ArrayList<SQLiteDebug.DbStats> paramArrayList)
  {
    int i = nativeGetDbLookaside(this.mConnectionPtr);
    long l1 = 0L;
    long l3 = 0L;
    try
    {
      l2 = executeForLong("PRAGMA page_count;", null, null);
      l1 = l2;
      l4 = executeForLong("PRAGMA page_size;", null, null);
      l3 = l4;
      l1 = l2;
    }
    catch (SQLiteException localSQLiteException1)
    {
      long l2;
      long l4;
      label45:
      CursorWindow localCursorWindow;
      label288:
      break label45;
    }
    paramArrayList.add(getMainDbStatsUnsafe(i, l1, l3));
    localCursorWindow = new CursorWindow("collectDbStats");
    try
    {
      executeForCursorWindow("PRAGMA database_list;", null, localCursorWindow, 0, 0, false, null);
      i = 1;
      for (;;)
      {
        if (i >= localCursorWindow.getNumRows()) {
          break label288;
        }
        Object localObject = localCursorWindow.getString(i, 1);
        String str2 = localCursorWindow.getString(i, 2);
        l1 = 0L;
        l3 = 0L;
        try
        {
          l2 = executeForLong("PRAGMA " + (String)localObject + ".page_count;", null, null);
          l1 = l2;
          l4 = executeForLong("PRAGMA " + (String)localObject + ".page_size;", null, null);
          l1 = l4;
        }
        catch (SQLiteException localSQLiteException2)
        {
          for (;;)
          {
            String str1;
            l2 = l1;
            l1 = l3;
          }
        }
        str1 = "  (attached) " + (String)localObject;
        localObject = str1;
        if (str2.length() != 0) {
          localObject = str1 + ": " + str2;
        }
        paramArrayList.add(new SQLiteDebug.DbStats((String)localObject, l2, l1, 0, 0, 0, 0));
        i += 1;
      }
      return;
    }
    catch (SQLiteException paramArrayList) {}finally
    {
      localCursorWindow.close();
    }
  }
  
  final void collectDbStatsUnsafe(ArrayList<SQLiteDebug.DbStats> paramArrayList)
  {
    paramArrayList.add(getMainDbStatsUnsafe(0, 0L, 0L));
  }
  
  final String describeCurrentOperationUnsafe()
  {
    return this.mRecentOperations.describeCurrentOperation();
  }
  
  public final void dump(Printer paramPrinter, boolean paramBoolean)
  {
    dumpUnsafe(paramPrinter, paramBoolean);
  }
  
  final void dumpUnsafe(Printer paramPrinter, boolean paramBoolean)
  {
    paramPrinter.println("Connection #" + this.mConnectionId + ":");
    if (paramBoolean) {
      paramPrinter.println("  connectionPtr: 0x" + Long.toHexString(this.mConnectionPtr));
    }
    paramPrinter.println("  isPrimaryConnection: " + this.mIsPrimaryConnection);
    paramPrinter.println("  onlyAllowReadOnlyOperations: " + this.mOnlyAllowReadOnlyOperations);
    if (this.mAcquiredThread != null) {
      paramPrinter.println("  acquiredThread: " + this.mAcquiredThread + " (tid: " + this.mAcquiredTid + ")");
    }
    this.mRecentOperations.dump(paramPrinter, paramBoolean);
    if (paramBoolean) {
      this.mPreparedStatementCache.dump(paramPrinter);
    }
  }
  
  final void endNativeHandle(Exception paramException)
  {
    int i = this.mNativeHandleCount - 1;
    this.mNativeHandleCount = i;
    if ((i == 0) && (this.mNativeOperation != null))
    {
      nativeSQLiteHandle(this.mConnectionPtr, false);
      if (paramException != null) {
        break label57;
      }
      this.mRecentOperations.endOperationDeferLog(this.mNativeOperation.mCookie);
    }
    for (;;)
    {
      this.mNativeOperation = null;
      return;
      label57:
      this.mRecentOperations.failOperation(this.mNativeOperation.mCookie, paramException);
    }
  }
  
  /* Error */
  public final void execute(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: new 797	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 799
    //   11: invokespecial 800	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aload_0
    //   16: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   19: ldc_w 801
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual 268	com/tencent/wcdb/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   27: astore 6
    //   29: aload 6
    //   31: getfield 271	com/tencent/wcdb/database/SQLiteConnection$Operation:mCookie	I
    //   34: istore 4
    //   36: aload_0
    //   37: aload_1
    //   38: invokevirtual 803	com/tencent/wcdb/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   41: astore 5
    //   43: aload 6
    //   45: aload 5
    //   47: invokestatic 806	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:access$100	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   50: putfield 809	com/tencent/wcdb/database/SQLiteConnection$Operation:mType	I
    //   53: aload_0
    //   54: aload 5
    //   56: invokespecial 811	com/tencent/wcdb/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   59: aload_0
    //   60: aload 5
    //   62: aload_2
    //   63: invokespecial 166	com/tencent/wcdb/database/SQLiteConnection:bindArguments	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   66: aload_0
    //   67: aload 5
    //   69: invokespecial 813	com/tencent/wcdb/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   72: aload_0
    //   73: aload_3
    //   74: invokespecial 135	com/tencent/wcdb/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   77: aload_0
    //   78: getfield 176	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   81: aload 5
    //   83: invokevirtual 217	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:getPtr	()J
    //   86: invokestatic 815	com/tencent/wcdb/database/SQLiteConnection:nativeExecute	(JJ)V
    //   89: aload_0
    //   90: aload_3
    //   91: invokespecial 139	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   94: aload_0
    //   95: aload 5
    //   97: invokevirtual 818	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   100: aload_0
    //   101: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   104: iload 4
    //   106: invokevirtual 282	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   109: return
    //   110: astore_2
    //   111: aload_0
    //   112: aload_3
    //   113: invokespecial 139	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   116: aload_2
    //   117: athrow
    //   118: astore_2
    //   119: aload_0
    //   120: aload 5
    //   122: invokevirtual 818	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   125: aload_2
    //   126: athrow
    //   127: astore_2
    //   128: aload_2
    //   129: instanceof 526
    //   132: ifne +10 -> 142
    //   135: aload_2
    //   136: instanceof 820
    //   139: ifeq +18 -> 157
    //   142: aload_0
    //   143: getfield 94	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   146: ifnull +11 -> 157
    //   149: aload_0
    //   150: getfield 94	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   153: aload_1
    //   154: invokevirtual 823	com/tencent/wcdb/database/SQLiteConnectionPool:logConnectionPoolBusy	(Ljava/lang/String;)V
    //   157: aload_0
    //   158: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   161: iload 4
    //   163: aload_2
    //   164: invokevirtual 795	com/tencent/wcdb/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   167: aload_2
    //   168: athrow
    //   169: astore_1
    //   170: aload_0
    //   171: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   174: iload 4
    //   176: invokevirtual 282	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   179: aload_1
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	SQLiteConnection
    //   0	181	1	paramString	String
    //   0	181	2	paramArrayOfObject	Object[]
    //   0	181	3	paramCancellationSignal	CancellationSignal
    //   34	141	4	i	int
    //   41	80	5	localPreparedStatement	PreparedStatement
    //   27	17	6	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   77	89	110	finally
    //   53	77	118	finally
    //   89	94	118	finally
    //   111	118	118	finally
    //   36	53	127	java/lang/RuntimeException
    //   94	100	127	java/lang/RuntimeException
    //   119	127	127	java/lang/RuntimeException
    //   36	53	169	finally
    //   94	100	169	finally
    //   119	127	169	finally
    //   128	142	169	finally
    //   142	157	169	finally
    //   157	169	169	finally
  }
  
  /* Error */
  public final int executeForChangedRowCount(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: new 797	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 799
    //   11: invokespecial 800	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: iconst_0
    //   16: istore 6
    //   18: iconst_0
    //   19: istore 8
    //   21: iconst_0
    //   22: istore 7
    //   24: aload_0
    //   25: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   28: ldc_w 826
    //   31: aload_1
    //   32: aload_2
    //   33: invokevirtual 268	com/tencent/wcdb/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   36: astore 11
    //   38: aload 11
    //   40: getfield 271	com/tencent/wcdb/database/SQLiteConnection$Operation:mCookie	I
    //   43: istore 9
    //   45: iload 6
    //   47: istore 4
    //   49: iload 8
    //   51: istore 5
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 803	com/tencent/wcdb/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   58: astore 10
    //   60: iload 6
    //   62: istore 4
    //   64: iload 8
    //   66: istore 5
    //   68: aload 11
    //   70: aload 10
    //   72: invokestatic 806	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:access$100	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   75: putfield 809	com/tencent/wcdb/database/SQLiteConnection$Operation:mType	I
    //   78: iload 7
    //   80: istore 6
    //   82: aload_0
    //   83: aload 10
    //   85: invokespecial 811	com/tencent/wcdb/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   88: iload 7
    //   90: istore 6
    //   92: aload_0
    //   93: aload 10
    //   95: aload_2
    //   96: invokespecial 166	com/tencent/wcdb/database/SQLiteConnection:bindArguments	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   99: iload 7
    //   101: istore 6
    //   103: aload_0
    //   104: aload 10
    //   106: invokespecial 813	com/tencent/wcdb/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   109: iload 7
    //   111: istore 6
    //   113: aload_0
    //   114: aload_3
    //   115: invokespecial 135	com/tencent/wcdb/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   118: aload_0
    //   119: getfield 176	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   122: aload 10
    //   124: invokevirtual 217	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:getPtr	()J
    //   127: invokestatic 828	com/tencent/wcdb/database/SQLiteConnection:nativeExecuteForChangedRowCount	(JJ)I
    //   130: istore 4
    //   132: iload 4
    //   134: istore 7
    //   136: iload 7
    //   138: istore 6
    //   140: aload_0
    //   141: aload_3
    //   142: invokespecial 139	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   145: iload 7
    //   147: istore 4
    //   149: iload 7
    //   151: istore 5
    //   153: aload_0
    //   154: aload 10
    //   156: invokevirtual 818	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   159: aload_0
    //   160: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   163: iload 9
    //   165: invokevirtual 791	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperationDeferLog	(I)Z
    //   168: ifeq +30 -> 198
    //   171: aload_0
    //   172: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   175: iload 9
    //   177: new 192	java/lang/StringBuilder
    //   180: dup
    //   181: ldc_w 830
    //   184: invokespecial 197	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   187: iload 7
    //   189: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   192: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokevirtual 834	com/tencent/wcdb/database/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   198: iload 7
    //   200: ireturn
    //   201: astore_2
    //   202: iload 7
    //   204: istore 6
    //   206: aload_0
    //   207: aload_3
    //   208: invokespecial 139	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   211: iload 7
    //   213: istore 6
    //   215: aload_2
    //   216: athrow
    //   217: astore_2
    //   218: iload 6
    //   220: istore 4
    //   222: iload 6
    //   224: istore 5
    //   226: aload_0
    //   227: aload 10
    //   229: invokevirtual 818	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   232: iload 6
    //   234: istore 4
    //   236: iload 6
    //   238: istore 5
    //   240: aload_2
    //   241: athrow
    //   242: astore_2
    //   243: iload 4
    //   245: istore 5
    //   247: aload_2
    //   248: instanceof 526
    //   251: ifne +14 -> 265
    //   254: iload 4
    //   256: istore 5
    //   258: aload_2
    //   259: instanceof 820
    //   262: ifeq +26 -> 288
    //   265: iload 4
    //   267: istore 5
    //   269: aload_0
    //   270: getfield 94	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   273: ifnull +15 -> 288
    //   276: iload 4
    //   278: istore 5
    //   280: aload_0
    //   281: getfield 94	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   284: aload_1
    //   285: invokevirtual 823	com/tencent/wcdb/database/SQLiteConnectionPool:logConnectionPoolBusy	(Ljava/lang/String;)V
    //   288: iload 4
    //   290: istore 5
    //   292: aload_0
    //   293: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   296: iload 9
    //   298: aload_2
    //   299: invokevirtual 795	com/tencent/wcdb/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   302: iload 4
    //   304: istore 5
    //   306: aload_2
    //   307: athrow
    //   308: astore_1
    //   309: aload_0
    //   310: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   313: iload 9
    //   315: invokevirtual 791	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperationDeferLog	(I)Z
    //   318: ifeq +30 -> 348
    //   321: aload_0
    //   322: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   325: iload 9
    //   327: new 192	java/lang/StringBuilder
    //   330: dup
    //   331: ldc_w 830
    //   334: invokespecial 197	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   337: iload 5
    //   339: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   342: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokevirtual 834	com/tencent/wcdb/database/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   348: aload_1
    //   349: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	this	SQLiteConnection
    //   0	350	1	paramString	String
    //   0	350	2	paramArrayOfObject	Object[]
    //   0	350	3	paramCancellationSignal	CancellationSignal
    //   47	256	4	i	int
    //   51	287	5	j	int
    //   16	221	6	k	int
    //   22	190	7	m	int
    //   19	46	8	n	int
    //   43	283	9	i1	int
    //   58	170	10	localPreparedStatement	PreparedStatement
    //   36	33	11	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   118	132	201	finally
    //   82	88	217	finally
    //   92	99	217	finally
    //   103	109	217	finally
    //   113	118	217	finally
    //   140	145	217	finally
    //   206	211	217	finally
    //   215	217	217	finally
    //   53	60	242	java/lang/RuntimeException
    //   68	78	242	java/lang/RuntimeException
    //   153	159	242	java/lang/RuntimeException
    //   226	232	242	java/lang/RuntimeException
    //   240	242	242	java/lang/RuntimeException
    //   53	60	308	finally
    //   68	78	308	finally
    //   153	159	308	finally
    //   226	232	308	finally
    //   240	242	308	finally
    //   247	254	308	finally
    //   258	265	308	finally
    //   269	276	308	finally
    //   280	288	308	finally
    //   292	302	308	finally
    //   306	308	308	finally
  }
  
  /* Error */
  public final int executeForCursorWindow(String paramString, Object[] paramArrayOfObject, CursorWindow paramCursorWindow, int paramInt1, int paramInt2, boolean paramBoolean, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: new 797	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 799
    //   11: invokespecial 800	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aload_3
    //   16: ifnonnull +14 -> 30
    //   19: new 797	java/lang/IllegalArgumentException
    //   22: dup
    //   23: ldc_w 836
    //   26: invokespecial 800	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   29: athrow
    //   30: aload_3
    //   31: invokevirtual 839	com/tencent/wcdb/CursorWindow:acquireReference	()V
    //   34: iconst_m1
    //   35: istore 12
    //   37: iconst_m1
    //   38: istore 11
    //   40: iconst_m1
    //   41: istore 16
    //   43: aload_0
    //   44: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   47: ldc_w 840
    //   50: aload_1
    //   51: aload_2
    //   52: invokevirtual 268	com/tencent/wcdb/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   55: astore 21
    //   57: aload 21
    //   59: getfield 271	com/tencent/wcdb/database/SQLiteConnection$Operation:mCookie	I
    //   62: istore 17
    //   64: iload 16
    //   66: istore 13
    //   68: iload 11
    //   70: istore 14
    //   72: iload 12
    //   74: istore 15
    //   76: iload 16
    //   78: istore 8
    //   80: iload 11
    //   82: istore 9
    //   84: iload 12
    //   86: istore 10
    //   88: aload_0
    //   89: aload_1
    //   90: invokevirtual 803	com/tencent/wcdb/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   93: astore 20
    //   95: iload 16
    //   97: istore 13
    //   99: iload 11
    //   101: istore 14
    //   103: iload 12
    //   105: istore 15
    //   107: iload 16
    //   109: istore 8
    //   111: iload 11
    //   113: istore 9
    //   115: iload 12
    //   117: istore 10
    //   119: aload 21
    //   121: aload 20
    //   123: invokestatic 806	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:access$100	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   126: putfield 809	com/tencent/wcdb/database/SQLiteConnection$Operation:mType	I
    //   129: aload_0
    //   130: aload 20
    //   132: invokespecial 811	com/tencent/wcdb/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   135: aload_0
    //   136: aload 20
    //   138: aload_2
    //   139: invokespecial 166	com/tencent/wcdb/database/SQLiteConnection:bindArguments	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   142: aload_0
    //   143: aload 20
    //   145: invokespecial 813	com/tencent/wcdb/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   148: aload_0
    //   149: aload 7
    //   151: invokespecial 135	com/tencent/wcdb/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   154: aload_0
    //   155: getfield 176	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   158: aload 20
    //   160: invokevirtual 217	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:getPtr	()J
    //   163: aload_3
    //   164: getfield 843	com/tencent/wcdb/CursorWindow:mWindowPtr	J
    //   167: iload 4
    //   169: iload 5
    //   171: iload 6
    //   173: invokestatic 845	com/tencent/wcdb/database/SQLiteConnection:nativeExecuteForCursorWindow	(JJJIIZ)J
    //   176: lstore 18
    //   178: lload 18
    //   180: bipush 32
    //   182: lshr
    //   183: l2i
    //   184: istore 8
    //   186: lload 18
    //   188: l2i
    //   189: istore 9
    //   191: aload_3
    //   192: invokevirtual 714	com/tencent/wcdb/CursorWindow:getNumRows	()I
    //   195: istore 5
    //   197: aload_3
    //   198: iload 8
    //   200: invokevirtual 848	com/tencent/wcdb/CursorWindow:setStartPosition	(I)V
    //   203: iload 5
    //   205: istore 12
    //   207: iload 9
    //   209: istore 11
    //   211: iload 8
    //   213: istore 10
    //   215: aload_0
    //   216: aload 7
    //   218: invokespecial 139	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   221: aload_0
    //   222: aload 20
    //   224: invokevirtual 818	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   227: aload_0
    //   228: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   231: iload 17
    //   233: invokevirtual 791	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperationDeferLog	(I)Z
    //   236: ifeq +73 -> 309
    //   239: aload_0
    //   240: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   243: iload 17
    //   245: new 192	java/lang/StringBuilder
    //   248: dup
    //   249: ldc_w 850
    //   252: invokespecial 197	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   255: aload_3
    //   256: invokevirtual 773	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   259: ldc_w 852
    //   262: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: iload 4
    //   267: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   270: ldc_w 854
    //   273: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: iload 8
    //   278: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   281: ldc_w 856
    //   284: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: iload 5
    //   289: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: ldc_w 858
    //   295: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: iload 9
    //   300: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   303: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokevirtual 834	com/tencent/wcdb/database/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   309: aload_3
    //   310: invokevirtual 861	com/tencent/wcdb/CursorWindow:releaseReference	()V
    //   313: iload 9
    //   315: ireturn
    //   316: astore_2
    //   317: iconst_m1
    //   318: istore 5
    //   320: iconst_m1
    //   321: istore 9
    //   323: iconst_m1
    //   324: istore 8
    //   326: iload 5
    //   328: istore 12
    //   330: iload 9
    //   332: istore 11
    //   334: iload 8
    //   336: istore 10
    //   338: aload_0
    //   339: aload 7
    //   341: invokespecial 139	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   344: iload 5
    //   346: istore 12
    //   348: iload 9
    //   350: istore 11
    //   352: iload 8
    //   354: istore 10
    //   356: aload_2
    //   357: athrow
    //   358: astore_2
    //   359: iload 12
    //   361: istore 5
    //   363: iload 10
    //   365: istore 12
    //   367: iload 5
    //   369: istore 13
    //   371: iload 11
    //   373: istore 14
    //   375: iload 12
    //   377: istore 15
    //   379: iload 5
    //   381: istore 8
    //   383: iload 11
    //   385: istore 9
    //   387: iload 12
    //   389: istore 10
    //   391: aload_0
    //   392: aload 20
    //   394: invokevirtual 818	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   397: iload 5
    //   399: istore 13
    //   401: iload 11
    //   403: istore 14
    //   405: iload 12
    //   407: istore 15
    //   409: iload 5
    //   411: istore 8
    //   413: iload 11
    //   415: istore 9
    //   417: iload 12
    //   419: istore 10
    //   421: aload_2
    //   422: athrow
    //   423: astore_2
    //   424: iload 13
    //   426: istore 8
    //   428: iload 14
    //   430: istore 9
    //   432: iload 15
    //   434: istore 10
    //   436: aload_2
    //   437: instanceof 526
    //   440: ifne +22 -> 462
    //   443: iload 13
    //   445: istore 8
    //   447: iload 14
    //   449: istore 9
    //   451: iload 15
    //   453: istore 10
    //   455: aload_2
    //   456: instanceof 820
    //   459: ifeq +42 -> 501
    //   462: iload 13
    //   464: istore 8
    //   466: iload 14
    //   468: istore 9
    //   470: iload 15
    //   472: istore 10
    //   474: aload_0
    //   475: getfield 94	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   478: ifnull +23 -> 501
    //   481: iload 13
    //   483: istore 8
    //   485: iload 14
    //   487: istore 9
    //   489: iload 15
    //   491: istore 10
    //   493: aload_0
    //   494: getfield 94	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   497: aload_1
    //   498: invokevirtual 823	com/tencent/wcdb/database/SQLiteConnectionPool:logConnectionPoolBusy	(Ljava/lang/String;)V
    //   501: iload 13
    //   503: istore 8
    //   505: iload 14
    //   507: istore 9
    //   509: iload 15
    //   511: istore 10
    //   513: aload_0
    //   514: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   517: iload 17
    //   519: aload_2
    //   520: invokevirtual 795	com/tencent/wcdb/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   523: iload 13
    //   525: istore 8
    //   527: iload 14
    //   529: istore 9
    //   531: iload 15
    //   533: istore 10
    //   535: aload_2
    //   536: athrow
    //   537: astore_1
    //   538: aload_0
    //   539: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   542: iload 17
    //   544: invokevirtual 791	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperationDeferLog	(I)Z
    //   547: ifeq +73 -> 620
    //   550: aload_0
    //   551: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   554: iload 17
    //   556: new 192	java/lang/StringBuilder
    //   559: dup
    //   560: ldc_w 850
    //   563: invokespecial 197	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   566: aload_3
    //   567: invokevirtual 773	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   570: ldc_w 852
    //   573: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: iload 4
    //   578: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   581: ldc_w 854
    //   584: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: iload 10
    //   589: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   592: ldc_w 856
    //   595: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: iload 8
    //   600: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   603: ldc_w 858
    //   606: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: iload 9
    //   611: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   614: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   617: invokevirtual 834	com/tencent/wcdb/database/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   620: aload_1
    //   621: athrow
    //   622: astore_1
    //   623: aload_3
    //   624: invokevirtual 861	com/tencent/wcdb/CursorWindow:releaseReference	()V
    //   627: aload_1
    //   628: athrow
    //   629: astore_1
    //   630: iload 8
    //   632: istore 10
    //   634: iload 5
    //   636: istore 8
    //   638: goto -100 -> 538
    //   641: astore_2
    //   642: iload 5
    //   644: istore 13
    //   646: iload 9
    //   648: istore 14
    //   650: iload 8
    //   652: istore 15
    //   654: goto -230 -> 424
    //   657: astore_2
    //   658: iload 16
    //   660: istore 5
    //   662: goto -295 -> 367
    //   665: astore_2
    //   666: iconst_m1
    //   667: istore 5
    //   669: goto -343 -> 326
    //   672: astore_2
    //   673: goto -347 -> 326
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	676	0	this	SQLiteConnection
    //   0	676	1	paramString	String
    //   0	676	2	paramArrayOfObject	Object[]
    //   0	676	3	paramCursorWindow	CursorWindow
    //   0	676	4	paramInt1	int
    //   0	676	5	paramInt2	int
    //   0	676	6	paramBoolean	boolean
    //   0	676	7	paramCancellationSignal	CancellationSignal
    //   78	573	8	i	int
    //   82	565	9	j	int
    //   86	547	10	k	int
    //   38	376	11	m	int
    //   35	383	12	n	int
    //   66	579	13	i1	int
    //   70	579	14	i2	int
    //   74	579	15	i3	int
    //   41	618	16	i4	int
    //   62	493	17	i5	int
    //   176	11	18	l	long
    //   93	300	20	localPreparedStatement	PreparedStatement
    //   55	65	21	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   154	178	316	finally
    //   215	221	358	finally
    //   338	344	358	finally
    //   356	358	358	finally
    //   88	95	423	java/lang/RuntimeException
    //   119	129	423	java/lang/RuntimeException
    //   391	397	423	java/lang/RuntimeException
    //   421	423	423	java/lang/RuntimeException
    //   88	95	537	finally
    //   119	129	537	finally
    //   391	397	537	finally
    //   421	423	537	finally
    //   436	443	537	finally
    //   455	462	537	finally
    //   474	481	537	finally
    //   493	501	537	finally
    //   513	523	537	finally
    //   535	537	537	finally
    //   43	64	622	finally
    //   227	309	622	finally
    //   538	620	622	finally
    //   620	622	622	finally
    //   221	227	629	finally
    //   221	227	641	java/lang/RuntimeException
    //   129	154	657	finally
    //   191	197	665	finally
    //   197	203	672	finally
  }
  
  /* Error */
  public final long executeForLastInsertedRowId(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: new 797	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 799
    //   11: invokespecial 800	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aload_0
    //   16: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   19: ldc_w 863
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual 268	com/tencent/wcdb/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   27: astore 8
    //   29: aload 8
    //   31: getfield 271	com/tencent/wcdb/database/SQLiteConnection$Operation:mCookie	I
    //   34: istore 4
    //   36: aload_0
    //   37: aload_1
    //   38: invokevirtual 803	com/tencent/wcdb/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   41: astore 7
    //   43: aload 8
    //   45: aload 7
    //   47: invokestatic 806	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:access$100	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   50: putfield 809	com/tencent/wcdb/database/SQLiteConnection$Operation:mType	I
    //   53: aload_0
    //   54: aload 7
    //   56: invokespecial 811	com/tencent/wcdb/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   59: aload_0
    //   60: aload 7
    //   62: aload_2
    //   63: invokespecial 166	com/tencent/wcdb/database/SQLiteConnection:bindArguments	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   66: aload_0
    //   67: aload 7
    //   69: invokespecial 813	com/tencent/wcdb/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   72: aload_0
    //   73: aload_3
    //   74: invokespecial 135	com/tencent/wcdb/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   77: aload_0
    //   78: getfield 176	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   81: aload 7
    //   83: invokevirtual 217	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:getPtr	()J
    //   86: invokestatic 865	com/tencent/wcdb/database/SQLiteConnection:nativeExecuteForLastInsertedRowId	(JJ)J
    //   89: lstore 5
    //   91: aload_0
    //   92: aload_3
    //   93: invokespecial 139	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   96: aload_0
    //   97: aload 7
    //   99: invokevirtual 818	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   102: aload_0
    //   103: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   106: iload 4
    //   108: invokevirtual 282	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   111: lload 5
    //   113: lreturn
    //   114: astore_2
    //   115: aload_0
    //   116: aload_3
    //   117: invokespecial 139	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   120: aload_2
    //   121: athrow
    //   122: astore_2
    //   123: aload_0
    //   124: aload 7
    //   126: invokevirtual 818	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   129: aload_2
    //   130: athrow
    //   131: astore_2
    //   132: aload_2
    //   133: instanceof 526
    //   136: ifne +10 -> 146
    //   139: aload_2
    //   140: instanceof 820
    //   143: ifeq +18 -> 161
    //   146: aload_0
    //   147: getfield 94	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   150: ifnull +11 -> 161
    //   153: aload_0
    //   154: getfield 94	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   157: aload_1
    //   158: invokevirtual 823	com/tencent/wcdb/database/SQLiteConnectionPool:logConnectionPoolBusy	(Ljava/lang/String;)V
    //   161: aload_0
    //   162: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   165: iload 4
    //   167: aload_2
    //   168: invokevirtual 795	com/tencent/wcdb/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   171: aload_2
    //   172: athrow
    //   173: astore_1
    //   174: aload_0
    //   175: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   178: iload 4
    //   180: invokevirtual 282	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   183: aload_1
    //   184: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	SQLiteConnection
    //   0	185	1	paramString	String
    //   0	185	2	paramArrayOfObject	Object[]
    //   0	185	3	paramCancellationSignal	CancellationSignal
    //   34	145	4	i	int
    //   89	23	5	l	long
    //   41	84	7	localPreparedStatement	PreparedStatement
    //   27	17	8	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   77	91	114	finally
    //   53	77	122	finally
    //   91	96	122	finally
    //   115	122	122	finally
    //   36	53	131	java/lang/RuntimeException
    //   96	102	131	java/lang/RuntimeException
    //   123	131	131	java/lang/RuntimeException
    //   36	53	173	finally
    //   96	102	173	finally
    //   123	131	173	finally
    //   132	146	173	finally
    //   146	161	173	finally
    //   161	173	173	finally
  }
  
  /* Error */
  public final long executeForLong(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: new 797	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 799
    //   11: invokespecial 800	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aload_0
    //   16: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   19: ldc_w 866
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual 268	com/tencent/wcdb/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   27: astore 8
    //   29: aload 8
    //   31: getfield 271	com/tencent/wcdb/database/SQLiteConnection$Operation:mCookie	I
    //   34: istore 4
    //   36: aload_0
    //   37: aload_1
    //   38: invokevirtual 803	com/tencent/wcdb/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   41: astore 7
    //   43: aload 8
    //   45: aload 7
    //   47: invokestatic 806	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:access$100	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   50: putfield 809	com/tencent/wcdb/database/SQLiteConnection$Operation:mType	I
    //   53: aload_0
    //   54: aload 7
    //   56: invokespecial 811	com/tencent/wcdb/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   59: aload_0
    //   60: aload 7
    //   62: aload_2
    //   63: invokespecial 166	com/tencent/wcdb/database/SQLiteConnection:bindArguments	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   66: aload_0
    //   67: aload 7
    //   69: invokespecial 813	com/tencent/wcdb/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   72: aload_0
    //   73: aload_3
    //   74: invokespecial 135	com/tencent/wcdb/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   77: aload_0
    //   78: getfield 176	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   81: aload 7
    //   83: invokevirtual 217	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:getPtr	()J
    //   86: invokestatic 868	com/tencent/wcdb/database/SQLiteConnection:nativeExecuteForLong	(JJ)J
    //   89: lstore 5
    //   91: aload_0
    //   92: aload_3
    //   93: invokespecial 139	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   96: aload_0
    //   97: aload 7
    //   99: invokevirtual 818	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   102: aload_0
    //   103: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   106: iload 4
    //   108: invokevirtual 282	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   111: lload 5
    //   113: lreturn
    //   114: astore_2
    //   115: aload_0
    //   116: aload_3
    //   117: invokespecial 139	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   120: aload_2
    //   121: athrow
    //   122: astore_2
    //   123: aload_0
    //   124: aload 7
    //   126: invokevirtual 818	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   129: aload_2
    //   130: athrow
    //   131: astore_2
    //   132: aload_2
    //   133: instanceof 526
    //   136: ifne +10 -> 146
    //   139: aload_2
    //   140: instanceof 820
    //   143: ifeq +18 -> 161
    //   146: aload_0
    //   147: getfield 94	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   150: ifnull +11 -> 161
    //   153: aload_0
    //   154: getfield 94	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   157: aload_1
    //   158: invokevirtual 823	com/tencent/wcdb/database/SQLiteConnectionPool:logConnectionPoolBusy	(Ljava/lang/String;)V
    //   161: aload_0
    //   162: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   165: iload 4
    //   167: aload_2
    //   168: invokevirtual 795	com/tencent/wcdb/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   171: aload_2
    //   172: athrow
    //   173: astore_1
    //   174: aload_0
    //   175: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   178: iload 4
    //   180: invokevirtual 282	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   183: aload_1
    //   184: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	SQLiteConnection
    //   0	185	1	paramString	String
    //   0	185	2	paramArrayOfObject	Object[]
    //   0	185	3	paramCancellationSignal	CancellationSignal
    //   34	145	4	i	int
    //   89	23	5	l	long
    //   41	84	7	localPreparedStatement	PreparedStatement
    //   27	17	8	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   77	91	114	finally
    //   53	77	122	finally
    //   91	96	122	finally
    //   115	122	122	finally
    //   36	53	131	java/lang/RuntimeException
    //   96	102	131	java/lang/RuntimeException
    //   123	131	131	java/lang/RuntimeException
    //   36	53	173	finally
    //   96	102	173	finally
    //   123	131	173	finally
    //   132	146	173	finally
    //   146	161	173	finally
    //   161	173	173	finally
  }
  
  /* Error */
  public final String executeForString(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: new 797	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 799
    //   11: invokespecial 800	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aload_0
    //   16: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   19: ldc_w 869
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual 268	com/tencent/wcdb/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   27: astore 6
    //   29: aload 6
    //   31: getfield 271	com/tencent/wcdb/database/SQLiteConnection$Operation:mCookie	I
    //   34: istore 4
    //   36: aload_0
    //   37: aload_1
    //   38: invokevirtual 803	com/tencent/wcdb/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   41: astore 5
    //   43: aload 6
    //   45: aload 5
    //   47: invokestatic 806	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:access$100	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   50: putfield 809	com/tencent/wcdb/database/SQLiteConnection$Operation:mType	I
    //   53: aload_0
    //   54: aload 5
    //   56: invokespecial 811	com/tencent/wcdb/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   59: aload_0
    //   60: aload 5
    //   62: aload_2
    //   63: invokespecial 166	com/tencent/wcdb/database/SQLiteConnection:bindArguments	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   66: aload_0
    //   67: aload 5
    //   69: invokespecial 813	com/tencent/wcdb/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   72: aload_0
    //   73: aload_3
    //   74: invokespecial 135	com/tencent/wcdb/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   77: aload_0
    //   78: getfield 176	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   81: aload 5
    //   83: invokevirtual 217	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:getPtr	()J
    //   86: invokestatic 871	com/tencent/wcdb/database/SQLiteConnection:nativeExecuteForString	(JJ)Ljava/lang/String;
    //   89: astore_2
    //   90: aload_0
    //   91: aload_3
    //   92: invokespecial 139	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   95: aload_0
    //   96: aload 5
    //   98: invokevirtual 818	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   101: aload_0
    //   102: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   105: iload 4
    //   107: invokevirtual 282	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   110: aload_2
    //   111: areturn
    //   112: astore_2
    //   113: aload_0
    //   114: aload_3
    //   115: invokespecial 139	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   118: aload_2
    //   119: athrow
    //   120: astore_2
    //   121: aload_0
    //   122: aload 5
    //   124: invokevirtual 818	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   127: aload_2
    //   128: athrow
    //   129: astore_2
    //   130: aload_2
    //   131: instanceof 526
    //   134: ifne +10 -> 144
    //   137: aload_2
    //   138: instanceof 820
    //   141: ifeq +18 -> 159
    //   144: aload_0
    //   145: getfield 94	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   148: ifnull +11 -> 159
    //   151: aload_0
    //   152: getfield 94	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   155: aload_1
    //   156: invokevirtual 823	com/tencent/wcdb/database/SQLiteConnectionPool:logConnectionPoolBusy	(Ljava/lang/String;)V
    //   159: aload_0
    //   160: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   163: iload 4
    //   165: aload_2
    //   166: invokevirtual 795	com/tencent/wcdb/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   169: aload_2
    //   170: athrow
    //   171: astore_1
    //   172: aload_0
    //   173: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   176: iload 4
    //   178: invokevirtual 282	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   181: aload_1
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	SQLiteConnection
    //   0	183	1	paramString	String
    //   0	183	2	paramArrayOfObject	Object[]
    //   0	183	3	paramCancellationSignal	CancellationSignal
    //   34	143	4	i	int
    //   41	82	5	localPreparedStatement	PreparedStatement
    //   27	17	6	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   77	90	112	finally
    //   53	77	120	finally
    //   90	95	120	finally
    //   113	120	120	finally
    //   36	53	129	java/lang/RuntimeException
    //   95	101	129	java/lang/RuntimeException
    //   121	129	129	java/lang/RuntimeException
    //   36	53	171	finally
    //   95	101	171	finally
    //   121	129	171	finally
    //   130	144	171	finally
    //   144	159	171	finally
    //   159	171	171	finally
  }
  
  protected final void finalize()
  {
    try
    {
      if ((this.mPool != null) && (this.mConnectionPtr != 0L)) {
        this.mPool.onConnectionLeaked();
      }
      dispose(true);
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public final int getConnectionId()
  {
    return this.mConnectionId;
  }
  
  final long getNativeHandle(String paramString)
  {
    if (this.mConnectionPtr == 0L) {
      return 0L;
    }
    if ((paramString != null) && (this.mNativeOperation == null))
    {
      this.mNativeOperation = this.mRecentOperations.beginOperation(paramString, null, null);
      this.mNativeOperation.mType = 99;
    }
    this.mNativeHandleCount += 1;
    return nativeSQLiteHandle(this.mConnectionPtr, true);
  }
  
  final boolean isPreparedStatementInCache(String paramString)
  {
    return this.mPreparedStatementCache.get(paramString) != null;
  }
  
  public final boolean isPrimaryConnection()
  {
    return this.mIsPrimaryConnection;
  }
  
  public final void onCancel()
  {
    nativeCancel(this.mConnectionPtr);
  }
  
  /* Error */
  public final void prepare(String paramString, SQLiteStatementInfo paramSQLiteStatementInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: new 797	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 799
    //   11: invokespecial 800	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aload_0
    //   16: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   19: ldc_w 888
    //   22: aload_1
    //   23: aconst_null
    //   24: invokevirtual 268	com/tencent/wcdb/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   27: astore 7
    //   29: aload 7
    //   31: getfield 271	com/tencent/wcdb/database/SQLiteConnection$Operation:mCookie	I
    //   34: istore 4
    //   36: aload_0
    //   37: aload_1
    //   38: invokevirtual 803	com/tencent/wcdb/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   41: astore 6
    //   43: aload 7
    //   45: aload 6
    //   47: invokestatic 806	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:access$100	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   50: putfield 809	com/tencent/wcdb/database/SQLiteConnection$Operation:mType	I
    //   53: aload_2
    //   54: ifnull +47 -> 101
    //   57: aload_2
    //   58: aload 6
    //   60: invokestatic 188	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:access$200	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   63: putfield 893	com/tencent/wcdb/database/SQLiteStatementInfo:numParameters	I
    //   66: aload_2
    //   67: aload 6
    //   69: invokestatic 642	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:access$300	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)Z
    //   72: putfield 896	com/tencent/wcdb/database/SQLiteStatementInfo:readOnly	Z
    //   75: aload_0
    //   76: getfield 176	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   79: aload 6
    //   81: invokevirtual 217	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:getPtr	()J
    //   84: invokestatic 898	com/tencent/wcdb/database/SQLiteConnection:nativeGetColumnCount	(JJ)I
    //   87: istore 5
    //   89: iload 5
    //   91: ifne +26 -> 117
    //   94: aload_2
    //   95: getstatic 66	com/tencent/wcdb/database/SQLiteConnection:EMPTY_STRING_ARRAY	[Ljava/lang/String;
    //   98: putfield 901	com/tencent/wcdb/database/SQLiteStatementInfo:columnNames	[Ljava/lang/String;
    //   101: aload_0
    //   102: aload 6
    //   104: invokevirtual 818	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   107: aload_0
    //   108: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   111: iload 4
    //   113: invokevirtual 282	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   116: return
    //   117: aload_2
    //   118: iload 5
    //   120: anewarray 64	java/lang/String
    //   123: putfield 901	com/tencent/wcdb/database/SQLiteStatementInfo:columnNames	[Ljava/lang/String;
    //   126: iconst_0
    //   127: istore_3
    //   128: iload_3
    //   129: iload 5
    //   131: if_icmpge -30 -> 101
    //   134: aload_2
    //   135: getfield 901	com/tencent/wcdb/database/SQLiteStatementInfo:columnNames	[Ljava/lang/String;
    //   138: iload_3
    //   139: aload_0
    //   140: getfield 176	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   143: aload 6
    //   145: invokevirtual 217	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:getPtr	()J
    //   148: iload_3
    //   149: invokestatic 903	com/tencent/wcdb/database/SQLiteConnection:nativeGetColumnName	(JJI)Ljava/lang/String;
    //   152: aastore
    //   153: iload_3
    //   154: iconst_1
    //   155: iadd
    //   156: istore_3
    //   157: goto -29 -> 128
    //   160: astore_2
    //   161: aload_0
    //   162: aload 6
    //   164: invokevirtual 818	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   167: aload_2
    //   168: athrow
    //   169: astore_2
    //   170: aload_2
    //   171: instanceof 526
    //   174: ifne +10 -> 184
    //   177: aload_2
    //   178: instanceof 820
    //   181: ifeq +18 -> 199
    //   184: aload_0
    //   185: getfield 94	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   188: ifnull +11 -> 199
    //   191: aload_0
    //   192: getfield 94	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   195: aload_1
    //   196: invokevirtual 823	com/tencent/wcdb/database/SQLiteConnectionPool:logConnectionPoolBusy	(Ljava/lang/String;)V
    //   199: aload_0
    //   200: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   203: iload 4
    //   205: aload_2
    //   206: invokevirtual 795	com/tencent/wcdb/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   209: aload_2
    //   210: athrow
    //   211: astore_1
    //   212: aload_0
    //   213: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   216: iload 4
    //   218: invokevirtual 282	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   221: aload_1
    //   222: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	SQLiteConnection
    //   0	223	1	paramString	String
    //   0	223	2	paramSQLiteStatementInfo	SQLiteStatementInfo
    //   127	30	3	i	int
    //   34	183	4	j	int
    //   87	45	5	k	int
    //   41	122	6	localPreparedStatement	PreparedStatement
    //   27	17	7	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   57	89	160	finally
    //   94	101	160	finally
    //   117	126	160	finally
    //   134	153	160	finally
    //   36	53	169	java/lang/RuntimeException
    //   101	107	169	java/lang/RuntimeException
    //   161	169	169	java/lang/RuntimeException
    //   36	53	211	finally
    //   101	107	211	finally
    //   161	169	211	finally
    //   170	184	211	finally
    //   184	199	211	finally
    //   199	211	211	finally
  }
  
  final void reconfigure(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
    int i1 = 0;
    this.mOnlyAllowReadOnlyOperations = false;
    int j = paramSQLiteDatabaseConfiguration.customFunctions.size();
    int i = 0;
    while (i < j)
    {
      SQLiteCustomFunction localSQLiteCustomFunction = (SQLiteCustomFunction)paramSQLiteDatabaseConfiguration.customFunctions.get(i);
      if (!this.mConfiguration.customFunctions.contains(localSQLiteCustomFunction)) {
        nativeRegisterCustomFunction(this.mConnectionPtr, localSQLiteCustomFunction);
      }
      i += 1;
    }
    label104:
    int k;
    label124:
    int m;
    if (((paramSQLiteDatabaseConfiguration.openFlags ^ this.mConfiguration.openFlags) & 0x20000000) != 0)
    {
      i = 1;
      if (paramSQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled == this.mConfiguration.foreignKeyConstraintsEnabled) {
        break label266;
      }
      j = 1;
      if (paramSQLiteDatabaseConfiguration.locale.equals(this.mConfiguration.locale)) {
        break label271;
      }
      k = 1;
      if (paramSQLiteDatabaseConfiguration.customWALHookEnabled == this.mConfiguration.customWALHookEnabled) {
        break label277;
      }
      m = 1;
      label141:
      if (paramSQLiteDatabaseConfiguration.synchronousMode == this.mConfiguration.synchronousMode) {
        break label283;
      }
    }
    label266:
    label271:
    label277:
    label283:
    for (int n = 1;; n = 0)
    {
      if ((paramSQLiteDatabaseConfiguration.updateNotificationEnabled != this.mConfiguration.updateNotificationEnabled) || (paramSQLiteDatabaseConfiguration.updateNotificationRowID != this.mConfiguration.updateNotificationRowID)) {
        i1 = 1;
      }
      this.mConfiguration.updateParametersFrom(paramSQLiteDatabaseConfiguration);
      this.mPreparedStatementCache.resize(paramSQLiteDatabaseConfiguration.maxSqlCacheSize);
      if (j != 0) {
        setForeignKeyModeFromConfiguration();
      }
      if (i != 0) {
        setWalModeFromConfiguration();
      }
      if (n != 0) {
        setSyncModeFromConfiguration();
      }
      if (m != 0) {
        setCheckpointStrategy();
      }
      if (k != 0) {
        setLocaleFromConfiguration();
      }
      if (i1 != 0) {
        setUpdateNotificationFromConfiguration();
      }
      return;
      i = 0;
      break;
      j = 0;
      break label104;
      k = 0;
      break label124;
      m = 0;
      break label141;
    }
  }
  
  final void releasePreparedStatement(PreparedStatement paramPreparedStatement)
  {
    PreparedStatement.access$402(paramPreparedStatement, false);
    if (paramPreparedStatement.mInCache) {
      try
      {
        resetStatement(paramPreparedStatement, true);
        return;
      }
      catch (SQLiteException localSQLiteException)
      {
        this.mPreparedStatementCache.remove(paramPreparedStatement.mSql);
        return;
      }
    }
    finalizePreparedStatement(paramPreparedStatement);
  }
  
  final void setAcquisitionState(Thread paramThread, int paramInt)
  {
    this.mAcquiredThread = paramThread;
    this.mAcquiredTid = paramInt;
  }
  
  final void setOnlyAllowReadOnlyOperations(boolean paramBoolean)
  {
    this.mOnlyAllowReadOnlyOperations = paramBoolean;
  }
  
  public final String toString()
  {
    return "SQLiteConnection: " + this.mConfiguration.path + " (" + this.mConnectionId + ")";
  }
  
  public final Pair<Integer, Integer> walCheckpoint(String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.isEmpty()) {}
    }
    else
    {
      str = "main";
    }
    long l = nativeWalCheckpoint(this.mConnectionPtr, str);
    return new Pair(Integer.valueOf((int)(l >> 32)), Integer.valueOf((int)(l & 0xFFFFFFFF)));
  }
  
  @SuppressLint({"SimpleDateFormat"})
  private static final class Operation
  {
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    public ArrayList<Object> mBindArgs;
    public int mCookie;
    public long mEndTime;
    public Exception mException;
    public boolean mFinished;
    public String mKind;
    public String mSql;
    public long mStartTime;
    public int mTid;
    public int mType;
    
    private String getFormattedStartTime()
    {
      return sDateFormat.format(new Date(this.mStartTime));
    }
    
    private String getStatus()
    {
      if (!this.mFinished) {
        return "running";
      }
      if (this.mException != null) {
        return "failed";
      }
      return "succeeded";
    }
    
    public final void describe(StringBuilder paramStringBuilder, boolean paramBoolean)
    {
      paramStringBuilder.append(this.mKind);
      int i;
      label143:
      Object localObject;
      if (this.mFinished)
      {
        paramStringBuilder.append(" took ").append(this.mEndTime - this.mStartTime).append("ms");
        paramStringBuilder.append(" - ").append(getStatus());
        if (this.mSql != null) {
          paramStringBuilder.append(", sql=\"").append(SQLiteConnection.trimSqlForDisplay(this.mSql)).append("\"");
        }
        if (this.mTid > 0) {
          paramStringBuilder.append(", tid=").append(this.mTid);
        }
        if ((!paramBoolean) || (this.mBindArgs == null) || (this.mBindArgs.size() == 0)) {
          break label281;
        }
        paramStringBuilder.append(", bindArgs=[");
        int j = this.mBindArgs.size();
        i = 0;
        if (i >= j) {
          break label274;
        }
        localObject = this.mBindArgs.get(i);
        if (i != 0) {
          paramStringBuilder.append(", ");
        }
        if (localObject != null) {
          break label215;
        }
        paramStringBuilder.append("null");
      }
      for (;;)
      {
        i += 1;
        break label143;
        paramStringBuilder.append(" started ").append(System.currentTimeMillis() - this.mStartTime).append("ms ago");
        break;
        label215:
        if ((localObject instanceof byte[])) {
          paramStringBuilder.append("<byte[]>");
        } else if ((localObject instanceof String)) {
          paramStringBuilder.append("\"").append((String)localObject).append("\"");
        } else {
          paramStringBuilder.append(localObject);
        }
      }
      label274:
      paramStringBuilder.append("]");
      label281:
      if ((this.mException != null) && (this.mException.getMessage() != null)) {
        paramStringBuilder.append(", exception=\"").append(this.mException.getMessage()).append("\"");
      }
    }
  }
  
  private final class OperationLog
  {
    private static final int COOKIE_GENERATION_SHIFT = 8;
    private static final int COOKIE_INDEX_MASK = 255;
    private static final int MAX_RECENT_OPERATIONS = 20;
    private int mGeneration;
    private int mIndex;
    private final SQLiteConnection.Operation[] mOperations = new SQLiteConnection.Operation[20];
    
    private OperationLog() {}
    
    private boolean endOperationDeferLogLocked(SQLiteConnection.Operation paramOperation)
    {
      if (paramOperation != null)
      {
        paramOperation.mEndTime = System.currentTimeMillis();
        paramOperation.mFinished = true;
        if ((paramOperation.mException != null) && (paramOperation.mException.getMessage() != null)) {
          return true;
        }
        return SQLiteDebug.shouldLogSlowQuery(paramOperation.mEndTime - paramOperation.mStartTime);
      }
      return false;
    }
    
    private SQLiteConnection.Operation getOperationLocked(int paramInt)
    {
      SQLiteConnection.Operation localOperation = this.mOperations[(paramInt & 0xFF)];
      if (localOperation.mCookie == paramInt) {
        return localOperation;
      }
      return null;
    }
    
    private void logOperationLocked(SQLiteConnection.Operation paramOperation, String paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramOperation.describe(localStringBuilder, false);
      if (paramString != null) {
        localStringBuilder.append(", ").append(paramString);
      }
      Log.i("WCDB.SQLiteConnection", localStringBuilder.toString());
    }
    
    private int newOperationCookieLocked(int paramInt)
    {
      int i = this.mGeneration;
      this.mGeneration = (i + 1);
      return i << 8 | paramInt;
    }
    
    public final SQLiteConnection.Operation beginOperation(String paramString1, String paramString2, Object[] paramArrayOfObject)
    {
      int i = 0;
      for (;;)
      {
        int j;
        SQLiteConnection.Operation localOperation1;
        synchronized (this.mOperations)
        {
          j = (this.mIndex + 1) % 20;
          SQLiteConnection.Operation localOperation2 = this.mOperations[j];
          if (localOperation2 == null)
          {
            localOperation1 = new SQLiteConnection.Operation(null);
            this.mOperations[j] = localOperation1;
            localOperation1.mStartTime = System.currentTimeMillis();
            localOperation1.mKind = paramString1;
            localOperation1.mSql = paramString2;
            if (paramArrayOfObject == null) {
              break label207;
            }
            if (localOperation1.mBindArgs == null)
            {
              localOperation1.mBindArgs = new ArrayList();
              if (i >= paramArrayOfObject.length) {
                break label207;
              }
              paramString1 = paramArrayOfObject[i];
              if ((paramString1 == null) || (!(paramString1 instanceof byte[]))) {
                break label194;
              }
              localOperation1.mBindArgs.add(SQLiteConnection.EMPTY_BYTE_ARRAY);
              break label242;
            }
          }
          else
          {
            localOperation2.mFinished = false;
            localOperation2.mException = null;
            localOperation1 = localOperation2;
            if (localOperation2.mBindArgs == null) {
              continue;
            }
            localOperation2.mBindArgs.clear();
            localOperation1 = localOperation2;
          }
        }
        localOperation1.mBindArgs.clear();
        continue;
        label194:
        localOperation1.mBindArgs.add(paramString1);
        break label242;
        label207:
        localOperation1.mCookie = newOperationCookieLocked(j);
        localOperation1.mTid = SQLiteConnection.this.mAcquiredTid;
        this.mIndex = j;
        return localOperation1;
        label242:
        i += 1;
      }
    }
    
    public final String describeCurrentOperation()
    {
      synchronized (this.mOperations)
      {
        Object localObject1 = this.mOperations[this.mIndex];
        if ((localObject1 != null) && (!((SQLiteConnection.Operation)localObject1).mFinished))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          ((SQLiteConnection.Operation)localObject1).describe(localStringBuilder, false);
          localObject1 = localStringBuilder.toString();
          return localObject1;
        }
        return null;
      }
    }
    
    public final void dump(Printer paramPrinter, boolean paramBoolean)
    {
      for (;;)
      {
        synchronized (this.mOperations)
        {
          paramPrinter.println("  Most recently executed operations:");
          i = this.mIndex;
          SQLiteConnection.Operation localOperation = this.mOperations[i];
          if (localOperation != null)
          {
            int j = 0;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("    ").append(j).append(": [");
            localStringBuilder.append(localOperation.getFormattedStartTime());
            localStringBuilder.append("] ");
            localOperation.describe(localStringBuilder, paramBoolean);
            paramPrinter.println(localStringBuilder.toString());
            if (i <= 0) {
              break label161;
            }
            i -= 1;
            j += 1;
            localOperation = this.mOperations[i];
            if ((localOperation != null) && (j < 20)) {}
          }
          else
          {
            paramPrinter.println("    <none>");
          }
        }
        continue;
        label161:
        int i = 19;
      }
    }
    
    public final void endOperation(int paramInt)
    {
      synchronized (this.mOperations)
      {
        SQLiteConnection.Operation localOperation = getOperationLocked(paramInt);
        if (endOperationDeferLogLocked(localOperation)) {
          logOperationLocked(localOperation, null);
        }
        String str1 = localOperation.mSql;
        String str2 = localOperation.mKind;
        paramInt = localOperation.mType;
        long l1 = localOperation.mEndTime;
        long l2 = localOperation.mStartTime;
        if (!"prepare".equals(str2)) {
          SQLiteConnection.this.mPool.traceExecute(str1, paramInt, l1 - l2);
        }
        return;
      }
    }
    
    public final boolean endOperationDeferLog(int paramInt)
    {
      boolean bool;
      synchronized (this.mOperations)
      {
        SQLiteConnection.Operation localOperation = getOperationLocked(paramInt);
        if (localOperation == null) {
          return false;
        }
        bool = endOperationDeferLogLocked(localOperation);
        String str1 = localOperation.mSql;
        String str2 = localOperation.mKind;
        paramInt = localOperation.mType;
        long l1 = localOperation.mEndTime;
        long l2 = localOperation.mStartTime;
        if (!"prepare".equals(str2))
        {
          SQLiteConnection.this.mPool.traceExecute(str1, paramInt, l1 - l2);
          return bool;
        }
      }
      return bool;
    }
    
    public final void failOperation(int paramInt, Exception paramException)
    {
      synchronized (this.mOperations)
      {
        SQLiteConnection.Operation localOperation = getOperationLocked(paramInt);
        if (localOperation != null) {
          localOperation.mException = paramException;
        }
        return;
      }
    }
    
    public final void logOperation(int paramInt, String paramString)
    {
      synchronized (this.mOperations)
      {
        SQLiteConnection.Operation localOperation = getOperationLocked(paramInt);
        if (localOperation != null) {
          logOperationLocked(localOperation, paramString);
        }
        return;
      }
    }
  }
  
  static final class PreparedStatement
  {
    private WeakReference<SQLiteConnection> mConnection;
    private boolean mInCache;
    private boolean mInUse;
    private int mNumParameters;
    private SQLiteConnection.Operation mOperation;
    private PreparedStatement mPoolNext;
    private boolean mReadOnly;
    private String mSql;
    private long mStatementPtr;
    private int mType;
    
    PreparedStatement(SQLiteConnection paramSQLiteConnection)
    {
      this.mConnection = new WeakReference(paramSQLiteConnection);
    }
    
    public final void attachCancellationSignal(CancellationSignal paramCancellationSignal)
    {
      SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
      if (localSQLiteConnection == null) {
        return;
      }
      localSQLiteConnection.attachCancellationSignal(paramCancellationSignal);
    }
    
    public final void beginOperation(String paramString, Object[] paramArrayOfObject)
    {
      SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
      if (localSQLiteConnection == null) {
        return;
      }
      this.mOperation = localSQLiteConnection.mRecentOperations.beginOperation(paramString, this.mSql, paramArrayOfObject);
      this.mOperation.mType = this.mType;
    }
    
    public final void bindArguments(Object[] paramArrayOfObject)
    {
      SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
      if (localSQLiteConnection == null) {
        return;
      }
      localSQLiteConnection.bindArguments(this, paramArrayOfObject);
    }
    
    public final void detachCancellationSignal(CancellationSignal paramCancellationSignal)
    {
      SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
      if (localSQLiteConnection == null) {
        return;
      }
      localSQLiteConnection.detachCancellationSignal(paramCancellationSignal);
    }
    
    public final void endOperation(String paramString)
    {
      if (this.mOperation == null) {}
      SQLiteConnection localSQLiteConnection;
      do
      {
        return;
        localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
      } while (localSQLiteConnection == null);
      if (localSQLiteConnection.mRecentOperations.endOperationDeferLog(this.mOperation.mCookie)) {
        localSQLiteConnection.mRecentOperations.logOperation(this.mOperation.mCookie, paramString);
      }
      this.mOperation = null;
    }
    
    public final void failOperation(Exception paramException)
    {
      if (this.mOperation == null) {}
      SQLiteConnection localSQLiteConnection;
      do
      {
        return;
        localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
      } while (localSQLiteConnection == null);
      localSQLiteConnection.mRecentOperations.failOperation(this.mOperation.mCookie, paramException);
    }
    
    public final long getPtr()
    {
      return this.mStatementPtr;
    }
    
    public final String getSQL()
    {
      return this.mSql;
    }
    
    public final int getType()
    {
      return this.mType;
    }
    
    public final boolean isReadOnly()
    {
      return this.mReadOnly;
    }
    
    public final void reset(boolean paramBoolean)
    {
      SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
      if (localSQLiteConnection == null) {
        return;
      }
      localSQLiteConnection.resetStatement(this, paramBoolean);
    }
  }
  
  private final class PreparedStatementCache
    extends LruCache<String, SQLiteConnection.PreparedStatement>
  {
    public PreparedStatementCache(int paramInt)
    {
      super();
    }
    
    public final void dump(Printer paramPrinter)
    {
      paramPrinter.println("  Prepared statement cache:");
      Object localObject1 = snapshot();
      if (!((Map)localObject1).isEmpty())
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        int i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          SQLiteConnection.PreparedStatement localPreparedStatement = (SQLiteConnection.PreparedStatement)((Map.Entry)localObject2).getValue();
          if (localPreparedStatement.mInCache)
          {
            localObject2 = (String)((Map.Entry)localObject2).getKey();
            paramPrinter.println("    " + i + ": statementPtr=0x" + Long.toHexString(localPreparedStatement.getPtr()) + ", numParameters=" + localPreparedStatement.mNumParameters + ", type=" + localPreparedStatement.mType + ", readOnly=" + localPreparedStatement.mReadOnly + ", sql=\"" + SQLiteConnection.trimSqlForDisplay((String)localObject2) + "\"");
          }
          i += 1;
        }
      }
      paramPrinter.println("    <none>");
    }
    
    protected final void entryRemoved(boolean paramBoolean, String paramString, SQLiteConnection.PreparedStatement paramPreparedStatement1, SQLiteConnection.PreparedStatement paramPreparedStatement2)
    {
      SQLiteConnection.PreparedStatement.access$502(paramPreparedStatement1, false);
      if (!paramPreparedStatement1.mInUse) {
        SQLiteConnection.this.finalizePreparedStatement(paramPreparedStatement1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteConnection
 * JD-Core Version:    0.7.0.1
 */