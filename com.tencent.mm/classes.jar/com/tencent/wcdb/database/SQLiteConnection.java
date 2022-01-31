package com.tencent.wcdb.database;

import android.annotation.SuppressLint;
import android.os.Process;
import android.util.Pair;
import android.util.Printer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.extension.SQLiteExtension;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.CancellationSignal.OnCancelListener;
import com.tencent.wcdb.support.Log;
import com.tencent.wcdb.support.LruCache;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public final class SQLiteConnection
  implements CancellationSignal.OnCancelListener
{
  private static final boolean DEBUG = false;
  private static final byte[] EMPTY_BYTE_ARRAY;
  private static final String[] EMPTY_STRING_ARRAY;
  private static final String[] HMAC_ALGO_MAPPING;
  private static final String[] PBKDF2_ALGO_MAPPING;
  private static final String TAG = "WCDB.SQLiteConnection";
  private static final Pattern TRIM_SQL_PATTERN;
  private StackTraceElement[] mAcquiredStack;
  private Thread mAcquiredThread;
  private int mAcquiredTid;
  private long mAcquiredTimestamp;
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
  private final OperationLog mRecentOperations;
  
  static
  {
    AppMethodBeat.i(12356);
    EMPTY_STRING_ARRAY = new String[0];
    EMPTY_BYTE_ARRAY = new byte[0];
    TRIM_SQL_PATTERN = Pattern.compile("[\\s]*\\n+[\\s]*");
    HMAC_ALGO_MAPPING = new String[] { "HMAC_SHA1", "HMAC_SHA256", "HMAC_SHA512" };
    PBKDF2_ALGO_MAPPING = new String[] { "PBKDF2_HMAC_SHA1", "PBKDF2_HMAC_SHA256", "PBKDF2_HMAC_SHA512" };
    AppMethodBeat.o(12356);
  }
  
  private SQLiteConnection(SQLiteConnectionPool paramSQLiteConnectionPool, SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, int paramInt, boolean paramBoolean, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec)
  {
    AppMethodBeat.i(12297);
    this.mRecentOperations = new OperationLog(null);
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
        break label133;
      }
    }
    label133:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.mIsReadOnlyConnection = paramBoolean;
      this.mPreparedStatementCache = new PreparedStatementCache(this.mConfiguration.maxSqlCacheSize);
      AppMethodBeat.o(12297);
      return;
      paramArrayOfByte = new SQLiteCipherSpec(paramSQLiteCipherSpec);
      break;
    }
  }
  
  private void applyBlockGuardPolicy(PreparedStatement paramPreparedStatement) {}
  
  private void attachCancellationSignal(CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(12332);
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
    AppMethodBeat.o(12332);
  }
  
  private void bindArguments(PreparedStatement paramPreparedStatement, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(12335);
    if (paramArrayOfObject != null) {}
    for (int i = paramArrayOfObject.length; i != paramPreparedStatement.mNumParameters; i = 0)
    {
      paramPreparedStatement = new SQLiteBindOrColumnIndexOutOfRangeException("Expected " + paramPreparedStatement.mNumParameters + " bind arguments but " + i + " were provided.");
      AppMethodBeat.o(12335);
      throw paramPreparedStatement;
    }
    if (i == 0)
    {
      AppMethodBeat.o(12335);
      return;
    }
    long l2 = paramPreparedStatement.getPtr();
    int j = 0;
    if (j < i)
    {
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
            label170:
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
        break label170;
        nativeBindString(this.mConnectionPtr, l2, j + 1, paramPreparedStatement.toString());
      }
    }
    AppMethodBeat.o(12335);
  }
  
  private void detachCancellationSignal(CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(12333);
    if (paramCancellationSignal != null)
    {
      this.mCancellationSignalAttachCount -= 1;
      if (this.mCancellationSignalAttachCount == 0)
      {
        paramCancellationSignal.setOnCancelListener(null);
        nativeResetCancel(this.mConnectionPtr, false);
      }
    }
    AppMethodBeat.o(12333);
  }
  
  private void dispose(boolean paramBoolean)
  {
    AppMethodBeat.i(12304);
    if (this.mConnectionPtr != 0L)
    {
      int i = this.mRecentOperations.beginOperation("close", null, null).mCookie;
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
        AppMethodBeat.o(12304);
      }
    }
    AppMethodBeat.o(12304);
  }
  
  private void finalizePreparedStatement(PreparedStatement paramPreparedStatement)
  {
    AppMethodBeat.i(12331);
    nativeFinalizeStatement(this.mConnectionPtr, paramPreparedStatement.getPtr());
    recyclePreparedStatement(paramPreparedStatement);
    AppMethodBeat.o(12331);
  }
  
  private SQLiteDebug.DbStats getMainDbStatsUnsafe(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(12345);
    String str = this.mConfiguration.path;
    Object localObject = str;
    if (!this.mIsPrimaryConnection) {
      localObject = str + " (" + this.mConnectionId + ")";
    }
    localObject = new SQLiteDebug.DbStats((String)localObject, paramLong1, paramLong2, paramInt, this.mPreparedStatementCache.hitCount(), this.mPreparedStatementCache.missCount(), this.mPreparedStatementCache.size());
    AppMethodBeat.o(12345);
    return localObject;
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
    AppMethodBeat.i(12316);
    this.mPool.notifyChanges(paramString1, paramString2, paramArrayOfLong1, paramArrayOfLong2, paramArrayOfLong3);
    AppMethodBeat.o(12316);
  }
  
  private void notifyCheckpoint(String paramString, int paramInt)
  {
    AppMethodBeat.i(12307);
    this.mPool.notifyCheckpoint(paramString, paramInt);
    AppMethodBeat.o(12307);
  }
  
  private PreparedStatement obtainPreparedStatement(String paramString, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(12347);
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
      AppMethodBeat.o(12347);
      return localPreparedStatement;
      localPreparedStatement = new PreparedStatement(this);
    }
  }
  
  static SQLiteConnection open(SQLiteConnectionPool paramSQLiteConnectionPool, SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, int paramInt, boolean paramBoolean, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec)
  {
    AppMethodBeat.i(12301);
    paramSQLiteConnectionPool = new SQLiteConnection(paramSQLiteConnectionPool, paramSQLiteDatabaseConfiguration, paramInt, paramBoolean, paramArrayOfByte, paramSQLiteCipherSpec);
    try
    {
      paramSQLiteConnectionPool.open();
      AppMethodBeat.o(12301);
      return paramSQLiteConnectionPool;
    }
    catch (SQLiteException paramSQLiteDatabaseConfiguration)
    {
      SQLiteDebug.collectLastIOTraceStats(paramSQLiteConnectionPool);
      paramSQLiteConnectionPool.dispose(false);
      AppMethodBeat.o(12301);
      throw paramSQLiteDatabaseConfiguration;
    }
  }
  
  private void open()
  {
    AppMethodBeat.i(12303);
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
    long l1 = WCDBInitializationProbe.apiEnv;
    long l2 = nativeSQLiteHandle(this.mConnectionPtr, true);
    try
    {
      Iterator localIterator = this.mConfiguration.extensions.iterator();
      while (localIterator.hasNext()) {
        ((SQLiteExtension)localIterator.next()).initialize(l2, l1);
      }
      nativeSQLiteHandle(this.mConnectionPtr, false);
    }
    finally
    {
      nativeSQLiteHandle(this.mConnectionPtr, false);
      AppMethodBeat.o(12303);
    }
    setUpdateNotificationFromConfiguration();
    AppMethodBeat.o(12303);
  }
  
  private void recyclePreparedStatement(PreparedStatement paramPreparedStatement)
  {
    AppMethodBeat.i(12348);
    PreparedStatement.access$602(paramPreparedStatement, null);
    PreparedStatement.access$702(paramPreparedStatement, this.mPreparedStatementPool);
    this.mPreparedStatementPool = paramPreparedStatement;
    AppMethodBeat.o(12348);
  }
  
  private void resetStatement(PreparedStatement paramPreparedStatement, boolean paramBoolean)
  {
    AppMethodBeat.i(12336);
    nativeResetStatement(this.mConnectionPtr, paramPreparedStatement.getPtr(), paramBoolean);
    AppMethodBeat.o(12336);
  }
  
  private void setCheckpointStrategy()
  {
    AppMethodBeat.i(12308);
    if ((!this.mConfiguration.isInMemoryDb()) && (!this.mIsReadOnlyConnection))
    {
      if (this.mConfiguration.customWALHookEnabled)
      {
        nativeSetWalHook(this.mConnectionPtr);
        AppMethodBeat.o(12308);
        return;
      }
      if (executeForLong("PRAGMA wal_autocheckpoint", null, null) != 100L) {
        executeForLong("PRAGMA wal_autocheckpoint=100", null, null);
      }
    }
    AppMethodBeat.o(12308);
  }
  
  private void setCipherSpec()
  {
    AppMethodBeat.i(12306);
    if (this.mCipher != null)
    {
      if (this.mCipher.kdfIteration != 0) {
        execute("PRAGMA kdf_iter=" + this.mCipher.kdfIteration, null, null);
      }
      execute("PRAGMA cipher_use_hmac=" + this.mCipher.hmacEnabled, null, null);
      if (this.mCipher.hmacAlgorithm != -1) {
        execute("PRAGMA cipher_hmac_algorithm=" + HMAC_ALGO_MAPPING[this.mCipher.hmacAlgorithm], null, null);
      }
      if (this.mCipher.kdfAlgorithm != -1) {
        execute("PRAGMA cipher_kdf_algorithm=" + PBKDF2_ALGO_MAPPING[this.mCipher.kdfAlgorithm], null, null);
      }
    }
    AppMethodBeat.o(12306);
  }
  
  private void setForeignKeyModeFromConfiguration()
  {
    AppMethodBeat.i(12310);
    if (!this.mIsReadOnlyConnection) {
      if (!this.mConfiguration.foreignKeyConstraintsEnabled) {
        break label62;
      }
    }
    label62:
    for (long l = 1L;; l = 0L)
    {
      if (executeForLong("PRAGMA foreign_keys", null, null) != l) {
        execute("PRAGMA foreign_keys=".concat(String.valueOf(l)), null, null);
      }
      AppMethodBeat.o(12310);
      return;
    }
  }
  
  private void setJournalMode(String paramString)
  {
    AppMethodBeat.i(12313);
    String str = executeForString("PRAGMA journal_mode", null, null);
    if (!str.equalsIgnoreCase(paramString)) {
      try
      {
        boolean bool = executeForString("PRAGMA journal_mode=".concat(String.valueOf(paramString)), null, null).equalsIgnoreCase(paramString);
        if (bool)
        {
          AppMethodBeat.o(12313);
          return;
        }
      }
      catch (SQLiteDatabaseLockedException localSQLiteDatabaseLockedException)
      {
        Log.w("WCDB.SQLiteConnection", "Could not change the database journal mode of '" + this.mConfiguration.label + "' from '" + str + "' to '" + paramString + "' because the database is locked.  This usually means that there are other open connections to the database which prevents the database from enabling or disabling write-ahead logging mode.  Proceeding without changing the journal mode.");
      }
    }
    AppMethodBeat.o(12313);
  }
  
  private void setJournalSizeLimit()
  {
    AppMethodBeat.i(12309);
    if ((!this.mConfiguration.isInMemoryDb()) && (!this.mIsReadOnlyConnection) && (executeForLong("PRAGMA journal_size_limit", null, null) != 524288L)) {
      executeForLong("PRAGMA journal_size_limit=524288", null, null);
    }
    AppMethodBeat.o(12309);
  }
  
  /* Error */
  private void setLocaleFromConfiguration()
  {
    // Byte code:
    //   0: sipush 12314
    //   3: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 131	com/tencent/wcdb/database/SQLiteConnection:mConfiguration	Lcom/tencent/wcdb/database/SQLiteDatabaseConfiguration;
    //   10: astore_2
    //   11: aload_2
    //   12: aload_2
    //   13: getfield 138	com/tencent/wcdb/database/SQLiteDatabaseConfiguration:openFlags	I
    //   16: bipush 16
    //   18: ior
    //   19: putfield 138	com/tencent/wcdb/database/SQLiteDatabaseConfiguration:openFlags	I
    //   22: aload_0
    //   23: getfield 131	com/tencent/wcdb/database/SQLiteConnection:mConfiguration	Lcom/tencent/wcdb/database/SQLiteDatabaseConfiguration;
    //   26: getfield 138	com/tencent/wcdb/database/SQLiteDatabaseConfiguration:openFlags	I
    //   29: bipush 16
    //   31: iand
    //   32: ifeq +10 -> 42
    //   35: sipush 12314
    //   38: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: return
    //   42: aload_0
    //   43: getfield 131	com/tencent/wcdb/database/SQLiteConnection:mConfiguration	Lcom/tencent/wcdb/database/SQLiteDatabaseConfiguration;
    //   46: getfield 621	com/tencent/wcdb/database/SQLiteDatabaseConfiguration:locale	Ljava/util/Locale;
    //   49: invokevirtual 624	java/util/Locale:toString	()Ljava/lang/String;
    //   52: astore_2
    //   53: aload_0
    //   54: getfield 206	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   57: aload_2
    //   58: invokestatic 626	com/tencent/wcdb/database/SQLiteConnection:nativeRegisterLocalizedCollators	(JLjava/lang/String;)V
    //   61: aload_0
    //   62: getfield 140	com/tencent/wcdb/database/SQLiteConnection:mIsReadOnlyConnection	Z
    //   65: ifeq +10 -> 75
    //   68: sipush 12314
    //   71: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: return
    //   75: aload_0
    //   76: ldc_w 628
    //   79: aconst_null
    //   80: aconst_null
    //   81: invokevirtual 542	com/tencent/wcdb/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   84: aload_0
    //   85: ldc_w 630
    //   88: aconst_null
    //   89: aconst_null
    //   90: invokevirtual 583	com/tencent/wcdb/database/SQLiteConnection:executeForString	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)Ljava/lang/String;
    //   93: astore_3
    //   94: aload_3
    //   95: ifnull +20 -> 115
    //   98: aload_3
    //   99: aload_2
    //   100: invokevirtual 634	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   103: istore_1
    //   104: iload_1
    //   105: ifeq +10 -> 115
    //   108: sipush 12314
    //   111: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: return
    //   115: aload_0
    //   116: ldc_w 636
    //   119: aconst_null
    //   120: aconst_null
    //   121: invokevirtual 542	com/tencent/wcdb/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   124: aload_0
    //   125: ldc_w 638
    //   128: aconst_null
    //   129: aconst_null
    //   130: invokevirtual 542	com/tencent/wcdb/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   133: aload_0
    //   134: ldc_w 640
    //   137: iconst_1
    //   138: anewarray 4	java/lang/Object
    //   141: dup
    //   142: iconst_0
    //   143: aload_2
    //   144: aastore
    //   145: aconst_null
    //   146: invokevirtual 542	com/tencent/wcdb/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   149: aload_0
    //   150: ldc_w 642
    //   153: aconst_null
    //   154: aconst_null
    //   155: invokevirtual 542	com/tencent/wcdb/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   158: aload_0
    //   159: ldc_w 644
    //   162: aconst_null
    //   163: aconst_null
    //   164: invokevirtual 542	com/tencent/wcdb/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   167: sipush 12314
    //   170: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: return
    //   174: astore_3
    //   175: new 434	com/tencent/wcdb/database/SQLiteException
    //   178: dup
    //   179: new 222	java/lang/StringBuilder
    //   182: dup
    //   183: ldc_w 646
    //   186: invokespecial 227	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   189: aload_0
    //   190: getfield 131	com/tencent/wcdb/database/SQLiteConnection:mConfiguration	Lcom/tencent/wcdb/database/SQLiteDatabaseConfiguration;
    //   193: getfield 597	com/tencent/wcdb/database/SQLiteDatabaseConfiguration:label	Ljava/lang/String;
    //   196: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc_w 601
    //   202: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_2
    //   206: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc_w 648
    //   212: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: aload_3
    //   219: invokespecial 651	com/tencent/wcdb/database/SQLiteException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   222: astore_2
    //   223: sipush 12314
    //   226: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   229: aload_2
    //   230: athrow
    //   231: astore_3
    //   232: aload_0
    //   233: ldc_w 653
    //   236: aconst_null
    //   237: aconst_null
    //   238: invokevirtual 542	com/tencent/wcdb/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   241: sipush 12314
    //   244: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: aload_3
    //   248: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	this	SQLiteConnection
    //   103	2	1	bool	boolean
    //   10	220	2	localObject1	Object
    //   93	6	3	str	String
    //   174	45	3	localRuntimeException	RuntimeException
    //   231	17	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   75	94	174	java/lang/RuntimeException
    //   98	104	174	java/lang/RuntimeException
    //   115	124	174	java/lang/RuntimeException
    //   158	173	174	java/lang/RuntimeException
    //   232	249	174	java/lang/RuntimeException
    //   124	158	231	finally
  }
  
  private void setPageSize()
  {
    AppMethodBeat.i(12305);
    String str;
    long l;
    if (!this.mConfiguration.isInMemoryDb())
    {
      if (this.mPassword == null) {
        break label110;
      }
      str = "PRAGMA cipher_page_size";
      if ((this.mCipher != null) && (this.mCipher.pageSize > 0)) {
        break label98;
      }
      l = SQLiteGlobal.defaultPageSize;
    }
    for (;;)
    {
      if (executeForLong(str, null, null) != l) {
        execute(str + "=" + l, null, null);
      }
      AppMethodBeat.o(12305);
      return;
      label98:
      l = this.mCipher.pageSize;
      continue;
      label110:
      str = "PRAGMA page_size";
      l = SQLiteGlobal.defaultPageSize;
    }
  }
  
  private void setReadOnlyFromConfiguration()
  {
    AppMethodBeat.i(12315);
    if (this.mIsReadOnlyConnection) {
      execute("PRAGMA query_only = 1", null, null);
    }
    AppMethodBeat.o(12315);
  }
  
  private void setSyncModeFromConfiguration()
  {
    AppMethodBeat.i(12312);
    execute("PRAGMA synchronous=".concat(String.valueOf(this.mConfiguration.synchronousMode)), null, null);
    AppMethodBeat.o(12312);
  }
  
  private void setUpdateNotificationFromConfiguration()
  {
    AppMethodBeat.i(12317);
    nativeSetUpdateNotification(this.mConnectionPtr, this.mConfiguration.updateNotificationEnabled, this.mConfiguration.updateNotificationRowID);
    AppMethodBeat.o(12317);
  }
  
  private void setWalModeFromConfiguration()
  {
    AppMethodBeat.i(12311);
    if ((!this.mConfiguration.isInMemoryDb()) && (!this.mIsReadOnlyConnection)) {
      if ((this.mConfiguration.openFlags & 0x20000000) == 0) {
        break label53;
      }
    }
    label53:
    for (String str = "WAL";; str = "PERSIST")
    {
      setJournalMode(str);
      AppMethodBeat.o(12311);
      return;
    }
  }
  
  private void throwIfStatementForbidden(PreparedStatement paramPreparedStatement)
  {
    AppMethodBeat.i(12337);
    if ((this.mOnlyAllowReadOnlyOperations) && (!paramPreparedStatement.mReadOnly))
    {
      paramPreparedStatement = new SQLiteException("Cannot execute this statement because it might modify the database but the connection is read-only.");
      AppMethodBeat.o(12337);
      throw paramPreparedStatement;
    }
    AppMethodBeat.o(12337);
  }
  
  private static String trimSqlForDisplay(String paramString)
  {
    AppMethodBeat.i(12349);
    paramString = TRIM_SQL_PATTERN.matcher(paramString).replaceAll(" ");
    AppMethodBeat.o(12349);
    return paramString;
  }
  
  final PreparedStatement acquirePreparedStatement(String paramString)
  {
    AppMethodBeat.i(12329);
    PreparedStatement localPreparedStatement2 = (PreparedStatement)this.mPreparedStatementCache.get(paramString);
    if (localPreparedStatement2 != null) {
      if (!localPreparedStatement2.mInUse)
      {
        PreparedStatement.access$402(localPreparedStatement2, true);
        AppMethodBeat.o(12329);
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
        AppMethodBeat.o(12329);
        return localPreparedStatement2;
      }
      catch (RuntimeException paramString)
      {
        if ((localPreparedStatement1 == null) || (!localPreparedStatement1.mInCache)) {
          nativeFinalizeStatement(this.mConnectionPtr, l);
        }
        AppMethodBeat.o(12329);
        throw paramString;
      }
    }
  }
  
  final void close()
  {
    AppMethodBeat.i(12302);
    dispose(false);
    AppMethodBeat.o(12302);
  }
  
  final void collectDbStats(ArrayList<SQLiteDebug.DbStats> paramArrayList)
  {
    AppMethodBeat.i(12343);
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
      label51:
      CursorWindow localCursorWindow;
      break label51;
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
          break label287;
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
        str1 = "  (attached) ".concat(String.valueOf(localObject));
        localObject = str1;
        if (str2.length() != 0) {
          localObject = str1 + ": " + str2;
        }
        paramArrayList.add(new SQLiteDebug.DbStats((String)localObject, l2, l1, 0, 0, 0, 0));
        i += 1;
      }
      label287:
      return;
    }
    catch (SQLiteException paramArrayList) {}finally
    {
      localCursorWindow.close();
      AppMethodBeat.o(12343);
    }
  }
  
  final void collectDbStatsUnsafe(ArrayList<SQLiteDebug.DbStats> paramArrayList)
  {
    AppMethodBeat.i(12344);
    paramArrayList.add(getMainDbStatsUnsafe(0, 0L, 0L));
    AppMethodBeat.o(12344);
  }
  
  final String describeCurrentOperationUnsafe()
  {
    AppMethodBeat.i(12340);
    String str = this.mRecentOperations.describeCurrentOperation();
    AppMethodBeat.o(12340);
    return str;
  }
  
  final void dump(Printer paramPrinter, boolean paramBoolean)
  {
    AppMethodBeat.i(12338);
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
    AppMethodBeat.o(12338);
  }
  
  final JSONObject dumpJSON(boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(141576);
    JSONObject localJSONObject = new JSONObject().put("id", this.mConnectionId).put("ptr", Long.toHexString(this.mConnectionPtr)).put("primary", this.mIsPrimaryConnection).put("readOnly", this.mOnlyAllowReadOnlyOperations);
    if (this.mAcquiredThread != null) {}
    for (Object localObject1 = this.mAcquiredThread.toString();; localObject1 = null)
    {
      localJSONObject = localJSONObject.putOpt("thread", localObject1);
      localObject1 = localObject2;
      if (this.mAcquiredTid > 0) {
        localObject1 = Integer.valueOf(this.mAcquiredTid);
      }
      localObject1 = localJSONObject.putOpt("tid", localObject1).put("operations", this.mRecentOperations.dumpJSON(paramBoolean));
      AppMethodBeat.o(141576);
      return localObject1;
    }
  }
  
  final void endNativeHandle(Exception paramException)
  {
    AppMethodBeat.i(12299);
    int i = this.mNativeHandleCount - 1;
    this.mNativeHandleCount = i;
    if ((i == 0) && (this.mNativeOperation != null))
    {
      nativeSQLiteHandle(this.mConnectionPtr, false);
      if (paramException != null) {
        break label69;
      }
      this.mRecentOperations.endOperationDeferLog(this.mNativeOperation.mCookie);
    }
    for (;;)
    {
      this.mNativeOperation = null;
      AppMethodBeat.o(12299);
      return;
      label69:
      this.mRecentOperations.failOperation(this.mNativeOperation.mCookie, paramException);
    }
  }
  
  /* Error */
  public final void execute(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: sipush 12322
    //   3: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +22 -> 29
    //   10: new 897	java/lang/IllegalArgumentException
    //   13: dup
    //   14: ldc_w 899
    //   17: invokespecial 900	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   20: astore_1
    //   21: sipush 12322
    //   24: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_1
    //   28: athrow
    //   29: aload_0
    //   30: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   33: ldc_w 901
    //   36: aload_1
    //   37: aload_2
    //   38: invokevirtual 298	com/tencent/wcdb/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   41: astore 5
    //   43: aload 5
    //   45: getfield 301	com/tencent/wcdb/database/SQLiteConnection$Operation:mCookie	I
    //   48: istore 4
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 903	com/tencent/wcdb/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   55: astore_1
    //   56: aload 5
    //   58: aload_1
    //   59: invokestatic 906	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:access$100	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   62: putfield 909	com/tencent/wcdb/database/SQLiteConnection$Operation:mType	I
    //   65: aload_0
    //   66: aload_1
    //   67: invokespecial 911	com/tencent/wcdb/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   70: aload_0
    //   71: aload_1
    //   72: aload_2
    //   73: invokespecial 196	com/tencent/wcdb/database/SQLiteConnection:bindArguments	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   76: aload_0
    //   77: aload_1
    //   78: invokespecial 913	com/tencent/wcdb/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   81: aload_0
    //   82: aload_3
    //   83: invokespecial 165	com/tencent/wcdb/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   86: aload_0
    //   87: getfield 206	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   90: aload_1
    //   91: invokevirtual 247	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:getPtr	()J
    //   94: invokestatic 915	com/tencent/wcdb/database/SQLiteConnection:nativeExecute	(JJ)V
    //   97: aload_0
    //   98: aload_3
    //   99: invokespecial 169	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   102: aload_0
    //   103: aload_1
    //   104: invokevirtual 918	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   107: aload_0
    //   108: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   111: iload 4
    //   113: invokevirtual 311	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   116: sipush 12322
    //   119: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: return
    //   123: astore_2
    //   124: aload_0
    //   125: aload_3
    //   126: invokespecial 169	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   129: sipush 12322
    //   132: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_2
    //   136: athrow
    //   137: astore_2
    //   138: aload_0
    //   139: aload_1
    //   140: invokevirtual 918	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   143: sipush 12322
    //   146: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload_2
    //   150: athrow
    //   151: astore_1
    //   152: aload_0
    //   153: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   156: iload 4
    //   158: aload_1
    //   159: invokevirtual 895	com/tencent/wcdb/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   162: sipush 12322
    //   165: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: aload_1
    //   169: athrow
    //   170: astore_1
    //   171: aload_0
    //   172: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   175: iload 4
    //   177: invokevirtual 311	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   180: sipush 12322
    //   183: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aload_1
    //   187: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	SQLiteConnection
    //   0	188	1	paramString	String
    //   0	188	2	paramArrayOfObject	Object[]
    //   0	188	3	paramCancellationSignal	CancellationSignal
    //   48	128	4	i	int
    //   41	16	5	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   86	97	123	finally
    //   65	86	137	finally
    //   97	102	137	finally
    //   124	137	137	finally
    //   50	65	151	java/lang/RuntimeException
    //   102	107	151	java/lang/RuntimeException
    //   138	151	151	java/lang/RuntimeException
    //   50	65	170	finally
    //   102	107	170	finally
    //   138	151	170	finally
    //   152	170	170	finally
  }
  
  /* Error */
  public final int executeForChangedRowCount(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: sipush 12325
    //   3: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +22 -> 29
    //   10: new 897	java/lang/IllegalArgumentException
    //   13: dup
    //   14: ldc_w 899
    //   17: invokespecial 900	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   20: astore_1
    //   21: sipush 12325
    //   24: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_1
    //   28: athrow
    //   29: iconst_0
    //   30: istore 6
    //   32: iconst_0
    //   33: istore 8
    //   35: iconst_0
    //   36: istore 7
    //   38: aload_0
    //   39: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   42: ldc_w 921
    //   45: aload_1
    //   46: aload_2
    //   47: invokevirtual 298	com/tencent/wcdb/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   50: astore 10
    //   52: aload 10
    //   54: getfield 301	com/tencent/wcdb/database/SQLiteConnection$Operation:mCookie	I
    //   57: istore 9
    //   59: iload 6
    //   61: istore 4
    //   63: iload 8
    //   65: istore 5
    //   67: aload_0
    //   68: aload_1
    //   69: invokevirtual 903	com/tencent/wcdb/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   72: astore_1
    //   73: iload 6
    //   75: istore 4
    //   77: iload 8
    //   79: istore 5
    //   81: aload 10
    //   83: aload_1
    //   84: invokestatic 906	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:access$100	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   87: putfield 909	com/tencent/wcdb/database/SQLiteConnection$Operation:mType	I
    //   90: iload 7
    //   92: istore 6
    //   94: aload_0
    //   95: aload_1
    //   96: invokespecial 911	com/tencent/wcdb/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   99: iload 7
    //   101: istore 6
    //   103: aload_0
    //   104: aload_1
    //   105: aload_2
    //   106: invokespecial 196	com/tencent/wcdb/database/SQLiteConnection:bindArguments	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   109: iload 7
    //   111: istore 6
    //   113: aload_0
    //   114: aload_1
    //   115: invokespecial 913	com/tencent/wcdb/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   118: iload 7
    //   120: istore 6
    //   122: aload_0
    //   123: aload_3
    //   124: invokespecial 165	com/tencent/wcdb/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   127: aload_0
    //   128: getfield 206	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   131: aload_1
    //   132: invokevirtual 247	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:getPtr	()J
    //   135: invokestatic 923	com/tencent/wcdb/database/SQLiteConnection:nativeExecuteForChangedRowCount	(JJ)I
    //   138: istore 4
    //   140: iload 4
    //   142: istore 7
    //   144: iload 7
    //   146: istore 6
    //   148: aload_0
    //   149: aload_3
    //   150: invokespecial 169	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   153: iload 7
    //   155: istore 4
    //   157: iload 7
    //   159: istore 5
    //   161: aload_0
    //   162: aload_1
    //   163: invokevirtual 918	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   166: aload_0
    //   167: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   170: iload 9
    //   172: invokevirtual 891	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperationDeferLog	(I)Z
    //   175: ifeq +23 -> 198
    //   178: aload_0
    //   179: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   182: iload 9
    //   184: ldc_w 925
    //   187: iload 7
    //   189: invokestatic 680	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   192: invokevirtual 574	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   195: invokevirtual 929	com/tencent/wcdb/database/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   198: sipush 12325
    //   201: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   204: iload 7
    //   206: ireturn
    //   207: astore_2
    //   208: iload 7
    //   210: istore 6
    //   212: aload_0
    //   213: aload_3
    //   214: invokespecial 169	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   217: iload 7
    //   219: istore 6
    //   221: sipush 12325
    //   224: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   227: iload 7
    //   229: istore 6
    //   231: aload_2
    //   232: athrow
    //   233: astore_2
    //   234: iload 6
    //   236: istore 4
    //   238: iload 6
    //   240: istore 5
    //   242: aload_0
    //   243: aload_1
    //   244: invokevirtual 918	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   247: iload 6
    //   249: istore 4
    //   251: iload 6
    //   253: istore 5
    //   255: sipush 12325
    //   258: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   261: iload 6
    //   263: istore 4
    //   265: iload 6
    //   267: istore 5
    //   269: aload_2
    //   270: athrow
    //   271: astore_1
    //   272: iload 4
    //   274: istore 5
    //   276: aload_0
    //   277: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   280: iload 9
    //   282: aload_1
    //   283: invokevirtual 895	com/tencent/wcdb/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   286: iload 4
    //   288: istore 5
    //   290: sipush 12325
    //   293: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   296: iload 4
    //   298: istore 5
    //   300: aload_1
    //   301: athrow
    //   302: astore_1
    //   303: aload_0
    //   304: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   307: iload 9
    //   309: invokevirtual 891	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperationDeferLog	(I)Z
    //   312: ifeq +23 -> 335
    //   315: aload_0
    //   316: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   319: iload 9
    //   321: ldc_w 925
    //   324: iload 5
    //   326: invokestatic 680	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   329: invokevirtual 574	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   332: invokevirtual 929	com/tencent/wcdb/database/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   335: sipush 12325
    //   338: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   341: aload_1
    //   342: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	this	SQLiteConnection
    //   0	343	1	paramString	String
    //   0	343	2	paramArrayOfObject	Object[]
    //   0	343	3	paramCancellationSignal	CancellationSignal
    //   61	236	4	i	int
    //   65	260	5	j	int
    //   30	236	6	k	int
    //   36	192	7	m	int
    //   33	45	8	n	int
    //   57	263	9	i1	int
    //   50	32	10	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   127	140	207	finally
    //   94	99	233	finally
    //   103	109	233	finally
    //   113	118	233	finally
    //   122	127	233	finally
    //   148	153	233	finally
    //   212	217	233	finally
    //   221	227	233	finally
    //   231	233	233	finally
    //   67	73	271	java/lang/RuntimeException
    //   81	90	271	java/lang/RuntimeException
    //   161	166	271	java/lang/RuntimeException
    //   242	247	271	java/lang/RuntimeException
    //   255	261	271	java/lang/RuntimeException
    //   269	271	271	java/lang/RuntimeException
    //   67	73	302	finally
    //   81	90	302	finally
    //   161	166	302	finally
    //   242	247	302	finally
    //   255	261	302	finally
    //   269	271	302	finally
    //   276	286	302	finally
    //   290	296	302	finally
    //   300	302	302	finally
  }
  
  /* Error */
  public final int executeForCursorWindow(String paramString, Object[] paramArrayOfObject, CursorWindow paramCursorWindow, int paramInt1, int paramInt2, boolean paramBoolean, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: sipush 12327
    //   3: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +22 -> 29
    //   10: new 897	java/lang/IllegalArgumentException
    //   13: dup
    //   14: ldc_w 899
    //   17: invokespecial 900	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   20: astore_1
    //   21: sipush 12327
    //   24: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_1
    //   28: athrow
    //   29: aload_3
    //   30: ifnonnull +22 -> 52
    //   33: new 897	java/lang/IllegalArgumentException
    //   36: dup
    //   37: ldc_w 931
    //   40: invokespecial 900	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   43: astore_1
    //   44: sipush 12327
    //   47: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_1
    //   51: athrow
    //   52: aload_3
    //   53: invokevirtual 934	com/tencent/wcdb/CursorWindow:acquireReference	()V
    //   56: aload_0
    //   57: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   60: ldc_w 935
    //   63: aload_1
    //   64: aload_2
    //   65: invokevirtual 298	com/tencent/wcdb/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   68: astore 20
    //   70: aload 20
    //   72: getfield 301	com/tencent/wcdb/database/SQLiteConnection$Operation:mCookie	I
    //   75: istore 16
    //   77: aload_0
    //   78: aload_1
    //   79: invokevirtual 903	com/tencent/wcdb/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   82: astore 19
    //   84: aload 20
    //   86: aload 19
    //   88: invokestatic 906	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:access$100	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   91: putfield 909	com/tencent/wcdb/database/SQLiteConnection$Operation:mType	I
    //   94: aload_0
    //   95: aload 19
    //   97: invokespecial 911	com/tencent/wcdb/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   100: aload_0
    //   101: aload 19
    //   103: aload_2
    //   104: invokespecial 196	com/tencent/wcdb/database/SQLiteConnection:bindArguments	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   107: aload_0
    //   108: aload 19
    //   110: invokespecial 913	com/tencent/wcdb/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   113: aload_0
    //   114: aload 7
    //   116: invokespecial 165	com/tencent/wcdb/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   119: aload_0
    //   120: getfield 206	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   123: aload 19
    //   125: invokevirtual 247	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:getPtr	()J
    //   128: aload_3
    //   129: getfield 938	com/tencent/wcdb/CursorWindow:mWindowPtr	J
    //   132: iload 4
    //   134: iload 5
    //   136: iload 6
    //   138: invokestatic 940	com/tencent/wcdb/database/SQLiteConnection:nativeExecuteForCursorWindow	(JJJIIZ)J
    //   141: lstore 17
    //   143: lload 17
    //   145: bipush 32
    //   147: lshr
    //   148: l2i
    //   149: istore 9
    //   151: lload 17
    //   153: l2i
    //   154: istore 11
    //   156: aload_3
    //   157: invokevirtual 777	com/tencent/wcdb/CursorWindow:getNumRows	()I
    //   160: istore 5
    //   162: aload_3
    //   163: iload 9
    //   165: invokevirtual 943	com/tencent/wcdb/CursorWindow:setStartPosition	(I)V
    //   168: iload 5
    //   170: istore 8
    //   172: iload 11
    //   174: istore 10
    //   176: iload 9
    //   178: istore 12
    //   180: aload_0
    //   181: aload 7
    //   183: invokespecial 169	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   186: iload 5
    //   188: istore 13
    //   190: iload 11
    //   192: istore 14
    //   194: iload 9
    //   196: istore 15
    //   198: iload 5
    //   200: istore 8
    //   202: iload 11
    //   204: istore 10
    //   206: iload 9
    //   208: istore 12
    //   210: aload_0
    //   211: aload 19
    //   213: invokevirtual 918	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   216: aload_0
    //   217: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   220: iload 16
    //   222: invokevirtual 891	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperationDeferLog	(I)Z
    //   225: ifeq +73 -> 298
    //   228: aload_0
    //   229: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   232: iload 16
    //   234: new 222	java/lang/StringBuilder
    //   237: dup
    //   238: ldc_w 945
    //   241: invokespecial 227	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   244: aload_3
    //   245: invokevirtual 832	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   248: ldc_w 947
    //   251: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: iload 4
    //   256: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   259: ldc_w 949
    //   262: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: iload 9
    //   267: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   270: ldc_w 951
    //   273: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: iload 5
    //   278: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   281: ldc_w 953
    //   284: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: iload 11
    //   289: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokevirtual 929	com/tencent/wcdb/database/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   298: aload_3
    //   299: invokevirtual 956	com/tencent/wcdb/CursorWindow:releaseReference	()V
    //   302: sipush 12327
    //   305: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   308: iload 11
    //   310: ireturn
    //   311: astore_1
    //   312: iconst_m1
    //   313: istore 5
    //   315: iconst_m1
    //   316: istore 11
    //   318: iconst_m1
    //   319: istore 9
    //   321: iload 5
    //   323: istore 8
    //   325: iload 11
    //   327: istore 10
    //   329: iload 9
    //   331: istore 12
    //   333: aload_0
    //   334: aload 7
    //   336: invokespecial 169	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   339: iload 5
    //   341: istore 8
    //   343: iload 11
    //   345: istore 10
    //   347: iload 9
    //   349: istore 12
    //   351: sipush 12327
    //   354: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   357: iload 5
    //   359: istore 8
    //   361: iload 11
    //   363: istore 10
    //   365: iload 9
    //   367: istore 12
    //   369: aload_1
    //   370: athrow
    //   371: astore_1
    //   372: iload 12
    //   374: istore 11
    //   376: iload 10
    //   378: istore 9
    //   380: iload 8
    //   382: istore 5
    //   384: iload 5
    //   386: istore 13
    //   388: iload 9
    //   390: istore 14
    //   392: iload 11
    //   394: istore 15
    //   396: iload 5
    //   398: istore 8
    //   400: iload 9
    //   402: istore 10
    //   404: iload 11
    //   406: istore 12
    //   408: aload_0
    //   409: aload 19
    //   411: invokevirtual 918	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   414: iload 5
    //   416: istore 13
    //   418: iload 9
    //   420: istore 14
    //   422: iload 11
    //   424: istore 15
    //   426: iload 5
    //   428: istore 8
    //   430: iload 9
    //   432: istore 10
    //   434: iload 11
    //   436: istore 12
    //   438: sipush 12327
    //   441: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   444: iload 5
    //   446: istore 13
    //   448: iload 9
    //   450: istore 14
    //   452: iload 11
    //   454: istore 15
    //   456: iload 5
    //   458: istore 8
    //   460: iload 9
    //   462: istore 10
    //   464: iload 11
    //   466: istore 12
    //   468: aload_1
    //   469: athrow
    //   470: astore_1
    //   471: iload 13
    //   473: istore 8
    //   475: iload 14
    //   477: istore 10
    //   479: iload 15
    //   481: istore 12
    //   483: aload_0
    //   484: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   487: iload 16
    //   489: aload_1
    //   490: invokevirtual 895	com/tencent/wcdb/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   493: iload 13
    //   495: istore 8
    //   497: iload 14
    //   499: istore 10
    //   501: iload 15
    //   503: istore 12
    //   505: sipush 12327
    //   508: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   511: iload 13
    //   513: istore 8
    //   515: iload 14
    //   517: istore 10
    //   519: iload 15
    //   521: istore 12
    //   523: aload_1
    //   524: athrow
    //   525: astore_1
    //   526: aload_0
    //   527: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   530: iload 16
    //   532: invokevirtual 891	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperationDeferLog	(I)Z
    //   535: ifeq +73 -> 608
    //   538: aload_0
    //   539: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   542: iload 16
    //   544: new 222	java/lang/StringBuilder
    //   547: dup
    //   548: ldc_w 945
    //   551: invokespecial 227	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   554: aload_3
    //   555: invokevirtual 832	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   558: ldc_w 947
    //   561: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: iload 4
    //   566: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   569: ldc_w 949
    //   572: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: iload 12
    //   577: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   580: ldc_w 951
    //   583: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: iload 8
    //   588: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   591: ldc_w 953
    //   594: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: iload 10
    //   599: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   602: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   605: invokevirtual 929	com/tencent/wcdb/database/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   608: sipush 12327
    //   611: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   614: aload_1
    //   615: athrow
    //   616: astore_1
    //   617: aload_3
    //   618: invokevirtual 956	com/tencent/wcdb/CursorWindow:releaseReference	()V
    //   621: sipush 12327
    //   624: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   627: aload_1
    //   628: athrow
    //   629: astore_1
    //   630: iconst_m1
    //   631: istore 8
    //   633: iconst_m1
    //   634: istore 10
    //   636: iconst_m1
    //   637: istore 12
    //   639: goto -113 -> 526
    //   642: astore_1
    //   643: iconst_m1
    //   644: istore 13
    //   646: iconst_m1
    //   647: istore 14
    //   649: iconst_m1
    //   650: istore 15
    //   652: goto -181 -> 471
    //   655: astore_1
    //   656: iconst_m1
    //   657: istore 5
    //   659: iconst_m1
    //   660: istore 9
    //   662: iconst_m1
    //   663: istore 11
    //   665: goto -281 -> 384
    //   668: astore_1
    //   669: iconst_m1
    //   670: istore 5
    //   672: goto -351 -> 321
    //   675: astore_1
    //   676: goto -355 -> 321
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	679	0	this	SQLiteConnection
    //   0	679	1	paramString	String
    //   0	679	2	paramArrayOfObject	Object[]
    //   0	679	3	paramCursorWindow	CursorWindow
    //   0	679	4	paramInt1	int
    //   0	679	5	paramInt2	int
    //   0	679	6	paramBoolean	boolean
    //   0	679	7	paramCancellationSignal	CancellationSignal
    //   170	462	8	i	int
    //   149	512	9	j	int
    //   174	461	10	k	int
    //   154	510	11	m	int
    //   178	460	12	n	int
    //   188	457	13	i1	int
    //   192	456	14	i2	int
    //   196	455	15	i3	int
    //   75	468	16	i4	int
    //   141	11	17	l	long
    //   82	328	19	localPreparedStatement	PreparedStatement
    //   68	17	20	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   119	143	311	finally
    //   180	186	371	finally
    //   333	339	371	finally
    //   351	357	371	finally
    //   369	371	371	finally
    //   210	216	470	java/lang/RuntimeException
    //   408	414	470	java/lang/RuntimeException
    //   438	444	470	java/lang/RuntimeException
    //   468	470	470	java/lang/RuntimeException
    //   210	216	525	finally
    //   408	414	525	finally
    //   438	444	525	finally
    //   468	470	525	finally
    //   483	493	525	finally
    //   505	511	525	finally
    //   523	525	525	finally
    //   56	77	616	finally
    //   216	298	616	finally
    //   526	608	616	finally
    //   608	616	616	finally
    //   77	94	629	finally
    //   77	94	642	java/lang/RuntimeException
    //   94	119	655	finally
    //   156	162	668	finally
    //   162	168	675	finally
  }
  
  /* Error */
  public final long executeForLastInsertedRowId(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: sipush 12326
    //   3: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +22 -> 29
    //   10: new 897	java/lang/IllegalArgumentException
    //   13: dup
    //   14: ldc_w 899
    //   17: invokespecial 900	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   20: astore_1
    //   21: sipush 12326
    //   24: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_1
    //   28: athrow
    //   29: aload_0
    //   30: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   33: ldc_w 958
    //   36: aload_1
    //   37: aload_2
    //   38: invokevirtual 298	com/tencent/wcdb/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   41: astore 7
    //   43: aload 7
    //   45: getfield 301	com/tencent/wcdb/database/SQLiteConnection$Operation:mCookie	I
    //   48: istore 4
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 903	com/tencent/wcdb/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   55: astore_1
    //   56: aload 7
    //   58: aload_1
    //   59: invokestatic 906	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:access$100	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   62: putfield 909	com/tencent/wcdb/database/SQLiteConnection$Operation:mType	I
    //   65: aload_0
    //   66: aload_1
    //   67: invokespecial 911	com/tencent/wcdb/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   70: aload_0
    //   71: aload_1
    //   72: aload_2
    //   73: invokespecial 196	com/tencent/wcdb/database/SQLiteConnection:bindArguments	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   76: aload_0
    //   77: aload_1
    //   78: invokespecial 913	com/tencent/wcdb/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   81: aload_0
    //   82: aload_3
    //   83: invokespecial 165	com/tencent/wcdb/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   86: aload_0
    //   87: getfield 206	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   90: aload_1
    //   91: invokevirtual 247	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:getPtr	()J
    //   94: invokestatic 960	com/tencent/wcdb/database/SQLiteConnection:nativeExecuteForLastInsertedRowId	(JJ)J
    //   97: lstore 5
    //   99: aload_0
    //   100: aload_3
    //   101: invokespecial 169	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   104: aload_0
    //   105: aload_1
    //   106: invokevirtual 918	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   109: aload_0
    //   110: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   113: iload 4
    //   115: invokevirtual 311	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   118: sipush 12326
    //   121: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: lload 5
    //   126: lreturn
    //   127: astore_2
    //   128: aload_0
    //   129: aload_3
    //   130: invokespecial 169	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   133: sipush 12326
    //   136: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_2
    //   140: athrow
    //   141: astore_2
    //   142: aload_0
    //   143: aload_1
    //   144: invokevirtual 918	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   147: sipush 12326
    //   150: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: aload_2
    //   154: athrow
    //   155: astore_1
    //   156: aload_0
    //   157: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   160: iload 4
    //   162: aload_1
    //   163: invokevirtual 895	com/tencent/wcdb/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   166: sipush 12326
    //   169: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: aload_1
    //   173: athrow
    //   174: astore_1
    //   175: aload_0
    //   176: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   179: iload 4
    //   181: invokevirtual 311	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   184: sipush 12326
    //   187: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: aload_1
    //   191: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	SQLiteConnection
    //   0	192	1	paramString	String
    //   0	192	2	paramArrayOfObject	Object[]
    //   0	192	3	paramCancellationSignal	CancellationSignal
    //   48	132	4	i	int
    //   97	28	5	l	long
    //   41	16	7	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   86	99	127	finally
    //   65	86	141	finally
    //   99	104	141	finally
    //   128	141	141	finally
    //   50	65	155	java/lang/RuntimeException
    //   104	109	155	java/lang/RuntimeException
    //   142	155	155	java/lang/RuntimeException
    //   50	65	174	finally
    //   104	109	174	finally
    //   142	155	174	finally
    //   156	174	174	finally
  }
  
  /* Error */
  public final long executeForLong(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: sipush 12323
    //   3: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +22 -> 29
    //   10: new 897	java/lang/IllegalArgumentException
    //   13: dup
    //   14: ldc_w 899
    //   17: invokespecial 900	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   20: astore_1
    //   21: sipush 12323
    //   24: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_1
    //   28: athrow
    //   29: aload_0
    //   30: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   33: ldc_w 961
    //   36: aload_1
    //   37: aload_2
    //   38: invokevirtual 298	com/tencent/wcdb/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   41: astore 7
    //   43: aload 7
    //   45: getfield 301	com/tencent/wcdb/database/SQLiteConnection$Operation:mCookie	I
    //   48: istore 4
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 903	com/tencent/wcdb/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   55: astore_1
    //   56: aload 7
    //   58: aload_1
    //   59: invokestatic 906	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:access$100	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   62: putfield 909	com/tencent/wcdb/database/SQLiteConnection$Operation:mType	I
    //   65: aload_0
    //   66: aload_1
    //   67: invokespecial 911	com/tencent/wcdb/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   70: aload_0
    //   71: aload_1
    //   72: aload_2
    //   73: invokespecial 196	com/tencent/wcdb/database/SQLiteConnection:bindArguments	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   76: aload_0
    //   77: aload_1
    //   78: invokespecial 913	com/tencent/wcdb/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   81: aload_0
    //   82: aload_3
    //   83: invokespecial 165	com/tencent/wcdb/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   86: aload_0
    //   87: getfield 206	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   90: aload_1
    //   91: invokevirtual 247	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:getPtr	()J
    //   94: invokestatic 963	com/tencent/wcdb/database/SQLiteConnection:nativeExecuteForLong	(JJ)J
    //   97: lstore 5
    //   99: aload_0
    //   100: aload_3
    //   101: invokespecial 169	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   104: aload_0
    //   105: aload_1
    //   106: invokevirtual 918	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   109: aload_0
    //   110: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   113: iload 4
    //   115: invokevirtual 311	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   118: sipush 12323
    //   121: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: lload 5
    //   126: lreturn
    //   127: astore_2
    //   128: aload_0
    //   129: aload_3
    //   130: invokespecial 169	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   133: sipush 12323
    //   136: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_2
    //   140: athrow
    //   141: astore_2
    //   142: aload_0
    //   143: aload_1
    //   144: invokevirtual 918	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   147: sipush 12323
    //   150: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: aload_2
    //   154: athrow
    //   155: astore_1
    //   156: aload_0
    //   157: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   160: iload 4
    //   162: aload_1
    //   163: invokevirtual 895	com/tencent/wcdb/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   166: sipush 12323
    //   169: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: aload_1
    //   173: athrow
    //   174: astore_1
    //   175: aload_0
    //   176: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   179: iload 4
    //   181: invokevirtual 311	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   184: sipush 12323
    //   187: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: aload_1
    //   191: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	SQLiteConnection
    //   0	192	1	paramString	String
    //   0	192	2	paramArrayOfObject	Object[]
    //   0	192	3	paramCancellationSignal	CancellationSignal
    //   48	132	4	i	int
    //   97	28	5	l	long
    //   41	16	7	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   86	99	127	finally
    //   65	86	141	finally
    //   99	104	141	finally
    //   128	141	141	finally
    //   50	65	155	java/lang/RuntimeException
    //   104	109	155	java/lang/RuntimeException
    //   142	155	155	java/lang/RuntimeException
    //   50	65	174	finally
    //   104	109	174	finally
    //   142	155	174	finally
    //   156	174	174	finally
  }
  
  /* Error */
  public final String executeForString(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: sipush 12324
    //   3: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +22 -> 29
    //   10: new 897	java/lang/IllegalArgumentException
    //   13: dup
    //   14: ldc_w 899
    //   17: invokespecial 900	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   20: astore_1
    //   21: sipush 12324
    //   24: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_1
    //   28: athrow
    //   29: aload_0
    //   30: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   33: ldc_w 964
    //   36: aload_1
    //   37: aload_2
    //   38: invokevirtual 298	com/tencent/wcdb/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   41: astore 5
    //   43: aload 5
    //   45: getfield 301	com/tencent/wcdb/database/SQLiteConnection$Operation:mCookie	I
    //   48: istore 4
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 903	com/tencent/wcdb/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   55: astore_1
    //   56: aload 5
    //   58: aload_1
    //   59: invokestatic 906	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:access$100	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   62: putfield 909	com/tencent/wcdb/database/SQLiteConnection$Operation:mType	I
    //   65: aload_0
    //   66: aload_1
    //   67: invokespecial 911	com/tencent/wcdb/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   70: aload_0
    //   71: aload_1
    //   72: aload_2
    //   73: invokespecial 196	com/tencent/wcdb/database/SQLiteConnection:bindArguments	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   76: aload_0
    //   77: aload_1
    //   78: invokespecial 913	com/tencent/wcdb/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   81: aload_0
    //   82: aload_3
    //   83: invokespecial 165	com/tencent/wcdb/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   86: aload_0
    //   87: getfield 206	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   90: aload_1
    //   91: invokevirtual 247	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:getPtr	()J
    //   94: invokestatic 966	com/tencent/wcdb/database/SQLiteConnection:nativeExecuteForString	(JJ)Ljava/lang/String;
    //   97: astore_2
    //   98: aload_0
    //   99: aload_3
    //   100: invokespecial 169	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   103: aload_0
    //   104: aload_1
    //   105: invokevirtual 918	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   108: aload_0
    //   109: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   112: iload 4
    //   114: invokevirtual 311	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   117: sipush 12324
    //   120: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: aload_2
    //   124: areturn
    //   125: astore_2
    //   126: aload_0
    //   127: aload_3
    //   128: invokespecial 169	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   131: sipush 12324
    //   134: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: aload_2
    //   138: athrow
    //   139: astore_2
    //   140: aload_0
    //   141: aload_1
    //   142: invokevirtual 918	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   145: sipush 12324
    //   148: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aload_2
    //   152: athrow
    //   153: astore_1
    //   154: aload_0
    //   155: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   158: iload 4
    //   160: aload_1
    //   161: invokevirtual 895	com/tencent/wcdb/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   164: sipush 12324
    //   167: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: aload_1
    //   171: athrow
    //   172: astore_1
    //   173: aload_0
    //   174: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   177: iload 4
    //   179: invokevirtual 311	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   182: sipush 12324
    //   185: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: aload_1
    //   189: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	SQLiteConnection
    //   0	190	1	paramString	String
    //   0	190	2	paramArrayOfObject	Object[]
    //   0	190	3	paramCancellationSignal	CancellationSignal
    //   48	130	4	i	int
    //   41	16	5	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   86	98	125	finally
    //   65	86	139	finally
    //   98	103	139	finally
    //   126	139	139	finally
    //   50	65	153	java/lang/RuntimeException
    //   103	108	153	java/lang/RuntimeException
    //   140	153	153	java/lang/RuntimeException
    //   50	65	172	finally
    //   103	108	172	finally
    //   140	153	172	finally
    //   154	172	172	finally
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(12300);
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
      AppMethodBeat.o(12300);
    }
  }
  
  public final int getConnectionId()
  {
    return this.mConnectionId;
  }
  
  final long getNativeHandle(String paramString)
  {
    AppMethodBeat.i(12298);
    if (this.mConnectionPtr == 0L)
    {
      AppMethodBeat.o(12298);
      return 0L;
    }
    if ((paramString != null) && (this.mNativeOperation == null))
    {
      this.mNativeOperation = this.mRecentOperations.beginOperation(paramString, null, null);
      this.mNativeOperation.mType = 99;
    }
    this.mNativeHandleCount += 1;
    long l = nativeSQLiteHandle(this.mConnectionPtr, true);
    AppMethodBeat.o(12298);
    return l;
  }
  
  final boolean isPreparedStatementInCache(String paramString)
  {
    AppMethodBeat.i(12320);
    if (this.mPreparedStatementCache.get(paramString) != null)
    {
      AppMethodBeat.o(12320);
      return true;
    }
    AppMethodBeat.o(12320);
    return false;
  }
  
  public final boolean isPrimaryConnection()
  {
    return this.mIsPrimaryConnection;
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(12334);
    nativeCancel(this.mConnectionPtr);
    AppMethodBeat.o(12334);
  }
  
  /* Error */
  public final void prepare(String paramString, SQLiteStatementInfo paramSQLiteStatementInfo)
  {
    // Byte code:
    //   0: sipush 12321
    //   3: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +22 -> 29
    //   10: new 897	java/lang/IllegalArgumentException
    //   13: dup
    //   14: ldc_w 899
    //   17: invokespecial 900	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   20: astore_1
    //   21: sipush 12321
    //   24: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_1
    //   28: athrow
    //   29: aload_0
    //   30: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   33: ldc_w 983
    //   36: aload_1
    //   37: aconst_null
    //   38: invokevirtual 298	com/tencent/wcdb/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   41: astore 6
    //   43: aload 6
    //   45: getfield 301	com/tencent/wcdb/database/SQLiteConnection$Operation:mCookie	I
    //   48: istore 4
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 903	com/tencent/wcdb/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   55: astore_1
    //   56: aload 6
    //   58: aload_1
    //   59: invokestatic 906	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:access$100	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   62: putfield 909	com/tencent/wcdb/database/SQLiteConnection$Operation:mType	I
    //   65: aload_2
    //   66: ifnull +44 -> 110
    //   69: aload_2
    //   70: aload_1
    //   71: invokestatic 218	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:access$200	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   74: putfield 988	com/tencent/wcdb/database/SQLiteStatementInfo:numParameters	I
    //   77: aload_2
    //   78: aload_1
    //   79: invokestatic 702	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:access$300	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)Z
    //   82: putfield 990	com/tencent/wcdb/database/SQLiteStatementInfo:readOnly	Z
    //   85: aload_0
    //   86: getfield 206	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   89: aload_1
    //   90: invokevirtual 247	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:getPtr	()J
    //   93: invokestatic 992	com/tencent/wcdb/database/SQLiteConnection:nativeGetColumnCount	(JJ)I
    //   96: istore 5
    //   98: iload 5
    //   100: ifne +31 -> 131
    //   103: aload_2
    //   104: getstatic 77	com/tencent/wcdb/database/SQLiteConnection:EMPTY_STRING_ARRAY	[Ljava/lang/String;
    //   107: putfield 995	com/tencent/wcdb/database/SQLiteStatementInfo:columnNames	[Ljava/lang/String;
    //   110: aload_0
    //   111: aload_1
    //   112: invokevirtual 918	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   115: aload_0
    //   116: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   119: iload 4
    //   121: invokevirtual 311	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   124: sipush 12321
    //   127: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: return
    //   131: aload_2
    //   132: iload 5
    //   134: anewarray 75	java/lang/String
    //   137: putfield 995	com/tencent/wcdb/database/SQLiteStatementInfo:columnNames	[Ljava/lang/String;
    //   140: iconst_0
    //   141: istore_3
    //   142: iload_3
    //   143: iload 5
    //   145: if_icmpge -35 -> 110
    //   148: aload_2
    //   149: getfield 995	com/tencent/wcdb/database/SQLiteStatementInfo:columnNames	[Ljava/lang/String;
    //   152: iload_3
    //   153: aload_0
    //   154: getfield 206	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   157: aload_1
    //   158: invokevirtual 247	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:getPtr	()J
    //   161: iload_3
    //   162: invokestatic 997	com/tencent/wcdb/database/SQLiteConnection:nativeGetColumnName	(JJI)Ljava/lang/String;
    //   165: aastore
    //   166: iload_3
    //   167: iconst_1
    //   168: iadd
    //   169: istore_3
    //   170: goto -28 -> 142
    //   173: astore_2
    //   174: aload_0
    //   175: aload_1
    //   176: invokevirtual 918	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   179: sipush 12321
    //   182: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: aload_2
    //   186: athrow
    //   187: astore_1
    //   188: aload_0
    //   189: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   192: iload 4
    //   194: aload_1
    //   195: invokevirtual 895	com/tencent/wcdb/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   198: sipush 12321
    //   201: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   204: aload_1
    //   205: athrow
    //   206: astore_1
    //   207: aload_0
    //   208: getfield 118	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   211: iload 4
    //   213: invokevirtual 311	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   216: sipush 12321
    //   219: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: aload_1
    //   223: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	SQLiteConnection
    //   0	224	1	paramString	String
    //   0	224	2	paramSQLiteStatementInfo	SQLiteStatementInfo
    //   141	29	3	i	int
    //   48	164	4	j	int
    //   96	50	5	k	int
    //   41	16	6	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   69	98	173	finally
    //   103	110	173	finally
    //   131	140	173	finally
    //   148	166	173	finally
    //   50	65	187	java/lang/RuntimeException
    //   110	115	187	java/lang/RuntimeException
    //   174	187	187	java/lang/RuntimeException
    //   50	65	206	finally
    //   110	115	206	finally
    //   174	187	206	finally
    //   188	206	206	finally
  }
  
  final void reconfigure(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
    int i1 = 0;
    AppMethodBeat.i(12318);
    this.mOnlyAllowReadOnlyOperations = false;
    long l1 = WCDBInitializationProbe.apiEnv;
    long l2 = nativeSQLiteHandle(this.mConnectionPtr, true);
    try
    {
      Iterator localIterator = paramSQLiteDatabaseConfiguration.extensions.iterator();
      while (localIterator.hasNext())
      {
        SQLiteExtension localSQLiteExtension = (SQLiteExtension)localIterator.next();
        if (!this.mConfiguration.extensions.contains(localSQLiteExtension)) {
          localSQLiteExtension.initialize(l2, l1);
        }
      }
      nativeSQLiteHandle(this.mConnectionPtr, false);
    }
    finally
    {
      nativeSQLiteHandle(this.mConnectionPtr, false);
      AppMethodBeat.o(12318);
    }
    int i;
    int j;
    label153:
    int k;
    label173:
    int m;
    if (((paramSQLiteDatabaseConfiguration.openFlags ^ this.mConfiguration.openFlags) & 0x20000000) != 0)
    {
      i = 1;
      if (paramSQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled == this.mConfiguration.foreignKeyConstraintsEnabled) {
        break label321;
      }
      j = 1;
      if (paramSQLiteDatabaseConfiguration.locale.equals(this.mConfiguration.locale)) {
        break label326;
      }
      k = 1;
      if (paramSQLiteDatabaseConfiguration.customWALHookEnabled == this.mConfiguration.customWALHookEnabled) {
        break label332;
      }
      m = 1;
      label190:
      if (paramSQLiteDatabaseConfiguration.synchronousMode == this.mConfiguration.synchronousMode) {
        break label338;
      }
    }
    label321:
    label326:
    label332:
    label338:
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
      AppMethodBeat.o(12318);
      return;
      i = 0;
      break;
      j = 0;
      break label153;
      k = 0;
      break label173;
      m = 0;
      break label190;
    }
  }
  
  final void releasePreparedStatement(PreparedStatement paramPreparedStatement)
  {
    AppMethodBeat.i(12330);
    PreparedStatement.access$402(paramPreparedStatement, false);
    if (paramPreparedStatement.mInCache) {
      try
      {
        resetStatement(paramPreparedStatement, true);
        AppMethodBeat.o(12330);
        return;
      }
      catch (SQLiteException localSQLiteException)
      {
        this.mPreparedStatementCache.remove(paramPreparedStatement.mSql);
        AppMethodBeat.o(12330);
        return;
      }
    }
    finalizePreparedStatement(paramPreparedStatement);
    AppMethodBeat.o(12330);
  }
  
  final void setAcquisitionState(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(12319);
    if (paramBoolean1)
    {
      this.mAcquiredThread = Thread.currentThread();
      this.mAcquiredTid = Process.myTid();
      if (paramBoolean2)
      {
        this.mAcquiredStack = this.mAcquiredThread.getStackTrace();
        this.mAcquiredTimestamp = System.currentTimeMillis();
        AppMethodBeat.o(12319);
        return;
      }
      this.mAcquiredStack = null;
      this.mAcquiredTimestamp = 0L;
      AppMethodBeat.o(12319);
      return;
    }
    this.mAcquiredThread = null;
    this.mAcquiredTid = 0;
    this.mAcquiredStack = null;
    this.mAcquiredTimestamp = 0L;
    AppMethodBeat.o(12319);
  }
  
  final void setOnlyAllowReadOnlyOperations(boolean paramBoolean)
  {
    this.mOnlyAllowReadOnlyOperations = paramBoolean;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12346);
    String str = "SQLiteConnection: " + this.mConfiguration.path + " (" + this.mConnectionId + ")";
    AppMethodBeat.o(12346);
    return str;
  }
  
  final SQLiteTrace.TraceInfo<String> traceCurrentOperationUnsafe()
  {
    AppMethodBeat.i(12341);
    SQLiteTrace.TraceInfo localTraceInfo = this.mRecentOperations.traceCurrentOperation();
    AppMethodBeat.o(12341);
    return localTraceInfo;
  }
  
  final SQLiteTrace.TraceInfo<StackTraceElement[]> tracePersistAcquisitionUnsafe()
  {
    AppMethodBeat.i(12342);
    Object localObject = this.mAcquiredStack;
    if (localObject == null)
    {
      AppMethodBeat.o(12342);
      return null;
    }
    localObject = new SQLiteTrace.TraceInfo(localObject, this.mAcquiredTimestamp, this.mAcquiredTid);
    AppMethodBeat.o(12342);
    return localObject;
  }
  
  public final Pair<Integer, Integer> walCheckpoint(String paramString)
  {
    AppMethodBeat.i(12328);
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
    paramString = new Pair(Integer.valueOf((int)(l >> 32)), Integer.valueOf((int)(l & 0xFFFFFFFF)));
    AppMethodBeat.o(12328);
    return paramString;
  }
  
  @SuppressLint({"SimpleDateFormat"})
  static final class Operation
  {
    private static final SimpleDateFormat sDateFormat;
    ArrayList<Object> mBindArgs;
    int mCookie;
    long mEndTime;
    Exception mException;
    boolean mFinished;
    String mKind;
    String mSql;
    long mStartTime;
    int mTid;
    int mType;
    
    static
    {
      AppMethodBeat.i(12274);
      sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
      AppMethodBeat.o(12274);
    }
    
    private String getFormattedStartTime()
    {
      AppMethodBeat.i(12272);
      String str = sDateFormat.format(new Date(this.mStartTime));
      AppMethodBeat.o(12272);
      return str;
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
      AppMethodBeat.i(12271);
      paramStringBuilder.append(this.mKind);
      int i;
      label149:
      Object localObject;
      if (this.mFinished)
      {
        paramStringBuilder.append(" took ").append(this.mEndTime - this.mStartTime).append("ms");
        paramStringBuilder.append(" - ").append(getStatus());
        if (this.mSql != null) {
          paramStringBuilder.append(", sql=\"").append(SQLiteConnection.access$1500(this.mSql)).append("\"");
        }
        if (this.mTid > 0) {
          paramStringBuilder.append(", tid=").append(this.mTid);
        }
        if ((!paramBoolean) || (this.mBindArgs == null) || (this.mBindArgs.size() == 0)) {
          break label287;
        }
        paramStringBuilder.append(", bindArgs=[");
        int j = this.mBindArgs.size();
        i = 0;
        if (i >= j) {
          break label280;
        }
        localObject = this.mBindArgs.get(i);
        if (i != 0) {
          paramStringBuilder.append(", ");
        }
        if (localObject != null) {
          break label221;
        }
        paramStringBuilder.append("null");
      }
      for (;;)
      {
        i += 1;
        break label149;
        paramStringBuilder.append(" started ").append(System.currentTimeMillis() - this.mStartTime).append("ms ago");
        break;
        label221:
        if ((localObject instanceof byte[])) {
          paramStringBuilder.append("<byte[]>");
        } else if ((localObject instanceof String)) {
          paramStringBuilder.append("\"").append((String)localObject).append("\"");
        } else {
          paramStringBuilder.append(localObject);
        }
      }
      label280:
      paramStringBuilder.append("]");
      label287:
      if ((this.mException != null) && (this.mException.getMessage() != null)) {
        paramStringBuilder.append(", exception=\"").append(this.mException.getMessage()).append("\"");
      }
      AppMethodBeat.o(12271);
    }
    
    final JSONObject dumpJSON(boolean paramBoolean)
    {
      AppMethodBeat.i(141574);
      Object localObject = new JSONObject().put("start", this.mStartTime).put("kind", this.mKind);
      long l;
      JSONObject localJSONObject;
      if (this.mFinished)
      {
        l = this.mEndTime;
        localJSONObject = ((JSONObject)localObject).put("duration", l - this.mStartTime).put("status", getStatus()).putOpt("sql", this.mSql);
        if (this.mTid <= 0) {
          break label128;
        }
      }
      label128:
      for (localObject = Integer.valueOf(this.mTid);; localObject = null)
      {
        localObject = localJSONObject.putOpt("tid", localObject).putOpt("exception", this.mException);
        AppMethodBeat.o(141574);
        return localObject;
        l = System.currentTimeMillis();
        break;
      }
    }
  }
  
  final class OperationLog
  {
    private static final int COOKIE_GENERATION_SHIFT = 8;
    private static final int COOKIE_INDEX_MASK = 255;
    private static final int MAX_RECENT_OPERATIONS = 20;
    private int mGeneration;
    private int mIndex;
    private final SQLiteConnection.Operation[] mOperations;
    
    private OperationLog()
    {
      AppMethodBeat.i(12275);
      this.mOperations = new SQLiteConnection.Operation[20];
      AppMethodBeat.o(12275);
    }
    
    private boolean endOperationDeferLogLocked(SQLiteConnection.Operation paramOperation)
    {
      AppMethodBeat.i(12281);
      if (paramOperation != null)
      {
        paramOperation.mEndTime = System.currentTimeMillis();
        paramOperation.mFinished = true;
        if ((paramOperation.mException != null) && (paramOperation.mException.getMessage() != null))
        {
          AppMethodBeat.o(12281);
          return true;
        }
        boolean bool = SQLiteDebug.shouldLogSlowQuery(paramOperation.mEndTime - paramOperation.mStartTime);
        AppMethodBeat.o(12281);
        return bool;
      }
      AppMethodBeat.o(12281);
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
      AppMethodBeat.i(12282);
      StringBuilder localStringBuilder = new StringBuilder();
      paramOperation.describe(localStringBuilder, false);
      if (paramString != null) {
        localStringBuilder.append(", ").append(paramString);
      }
      Log.i("WCDB.SQLiteConnection", localStringBuilder.toString());
      AppMethodBeat.o(12282);
    }
    
    private int newOperationCookieLocked(int paramInt)
    {
      int i = this.mGeneration;
      this.mGeneration = (i + 1);
      return i << 8 | paramInt;
    }
    
    final SQLiteConnection.Operation beginOperation(String paramString1, String paramString2, Object[] paramArrayOfObject)
    {
      int i = 0;
      AppMethodBeat.i(12276);
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
              break label219;
            }
            if (localOperation1.mBindArgs == null)
            {
              localOperation1.mBindArgs = new ArrayList();
              if (i >= paramArrayOfObject.length) {
                break label219;
              }
              paramString1 = paramArrayOfObject[i];
              if ((paramString1 == null) || (!(paramString1 instanceof byte[]))) {
                break label206;
              }
              localOperation1.mBindArgs.add(SQLiteConnection.EMPTY_BYTE_ARRAY);
              break label260;
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
        label206:
        localOperation1.mBindArgs.add(paramString1);
        break label260;
        label219:
        localOperation1.mCookie = newOperationCookieLocked(j);
        localOperation1.mTid = SQLiteConnection.this.mAcquiredTid;
        this.mIndex = j;
        AppMethodBeat.o(12276);
        return localOperation1;
        label260:
        i += 1;
      }
    }
    
    final String describeCurrentOperation()
    {
      AppMethodBeat.i(12283);
      synchronized (this.mOperations)
      {
        Object localObject1 = this.mOperations[this.mIndex];
        if ((localObject1 != null) && (!((SQLiteConnection.Operation)localObject1).mFinished))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          ((SQLiteConnection.Operation)localObject1).describe(localStringBuilder, false);
          localObject1 = localStringBuilder.toString();
          AppMethodBeat.o(12283);
          return localObject1;
        }
        AppMethodBeat.o(12283);
        return null;
      }
    }
    
    final void dump(Printer paramPrinter, boolean paramBoolean)
    {
      AppMethodBeat.i(12285);
      for (;;)
      {
        synchronized (this.mOperations)
        {
          paramPrinter.println("  Most recently executed operations:");
          int i = this.mIndex;
          SQLiteConnection.Operation localOperation = this.mOperations[i];
          if (localOperation != null)
          {
            int j = 0;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("    ").append(j).append(": [");
            localStringBuilder.append(SQLiteConnection.Operation.access$2000(localOperation));
            localStringBuilder.append("] ");
            localOperation.describe(localStringBuilder, paramBoolean);
            paramPrinter.println(localStringBuilder.toString());
            if (i > 0)
            {
              i -= 1;
              j += 1;
              localOperation = this.mOperations[i];
              if ((localOperation == null) || (j >= 20)) {
                AppMethodBeat.o(12285);
              }
            }
            else
            {
              i = 19;
            }
          }
          else
          {
            paramPrinter.println("    <none>");
          }
        }
      }
    }
    
    final JSONArray dumpJSON(boolean paramBoolean)
    {
      AppMethodBeat.i(141575);
      JSONArray localJSONArray = new JSONArray();
      int i;
      int j;
      synchronized (this.mOperations)
      {
        i = this.mIndex;
        j = 0;
        SQLiteConnection.Operation localOperation = this.mOperations[i];
        if ((localOperation != null) && (j < 20))
        {
          localJSONArray.put(localOperation.dumpJSON(paramBoolean));
          if (i <= 0) {
            break label103;
          }
          i -= 1;
        }
        else
        {
          AppMethodBeat.o(141575);
          return localJSONArray;
        }
      }
      for (;;)
      {
        j += 1;
        break;
        label103:
        i = 19;
      }
    }
    
    final void endOperation(int paramInt)
    {
      AppMethodBeat.i(12278);
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
        AppMethodBeat.o(12278);
        return;
      }
    }
    
    final boolean endOperationDeferLog(int paramInt)
    {
      AppMethodBeat.i(12279);
      synchronized (this.mOperations)
      {
        SQLiteConnection.Operation localOperation = getOperationLocked(paramInt);
        if (localOperation == null)
        {
          AppMethodBeat.o(12279);
          return false;
        }
        boolean bool = endOperationDeferLogLocked(localOperation);
        String str1 = localOperation.mSql;
        String str2 = localOperation.mKind;
        paramInt = localOperation.mType;
        long l1 = localOperation.mEndTime;
        long l2 = localOperation.mStartTime;
        if (!"prepare".equals(str2)) {
          SQLiteConnection.this.mPool.traceExecute(str1, paramInt, l1 - l2);
        }
        AppMethodBeat.o(12279);
        return bool;
      }
    }
    
    final void failOperation(int paramInt, Exception paramException)
    {
      AppMethodBeat.i(12277);
      synchronized (this.mOperations)
      {
        SQLiteConnection.Operation localOperation = getOperationLocked(paramInt);
        if (localOperation != null) {
          localOperation.mException = paramException;
        }
        AppMethodBeat.o(12277);
        return;
      }
    }
    
    final void logOperation(int paramInt, String paramString)
    {
      AppMethodBeat.i(12280);
      synchronized (this.mOperations)
      {
        SQLiteConnection.Operation localOperation = getOperationLocked(paramInt);
        if (localOperation != null) {
          logOperationLocked(localOperation, paramString);
        }
        AppMethodBeat.o(12280);
        return;
      }
    }
    
    final SQLiteTrace.TraceInfo<String> traceCurrentOperation()
    {
      AppMethodBeat.i(12284);
      synchronized (this.mOperations)
      {
        Object localObject1 = this.mOperations[this.mIndex];
        if ((localObject1 != null) && (!((SQLiteConnection.Operation)localObject1).mFinished))
        {
          localObject1 = new SQLiteTrace.TraceInfo(((SQLiteConnection.Operation)localObject1).mSql, ((SQLiteConnection.Operation)localObject1).mStartTime, ((SQLiteConnection.Operation)localObject1).mTid);
          AppMethodBeat.o(12284);
          return localObject1;
        }
        AppMethodBeat.o(12284);
        return null;
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
      AppMethodBeat.i(12286);
      this.mConnection = new WeakReference(paramSQLiteConnection);
      AppMethodBeat.o(12286);
    }
    
    public final void attachCancellationSignal(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(12289);
      SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
      if (localSQLiteConnection == null)
      {
        AppMethodBeat.o(12289);
        return;
      }
      SQLiteConnection.access$1100(localSQLiteConnection, paramCancellationSignal);
      AppMethodBeat.o(12289);
    }
    
    public final void beginOperation(String paramString, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(12291);
      SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
      if (localSQLiteConnection == null)
      {
        AppMethodBeat.o(12291);
        return;
      }
      this.mOperation = localSQLiteConnection.mRecentOperations.beginOperation(paramString, this.mSql, paramArrayOfObject);
      this.mOperation.mType = this.mType;
      AppMethodBeat.o(12291);
    }
    
    public final void bindArguments(Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(12287);
      SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
      if (localSQLiteConnection == null)
      {
        AppMethodBeat.o(12287);
        return;
      }
      SQLiteConnection.access$900(localSQLiteConnection, this, paramArrayOfObject);
      AppMethodBeat.o(12287);
    }
    
    public final void detachCancellationSignal(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(12290);
      SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
      if (localSQLiteConnection == null)
      {
        AppMethodBeat.o(12290);
        return;
      }
      SQLiteConnection.access$1200(localSQLiteConnection, paramCancellationSignal);
      AppMethodBeat.o(12290);
    }
    
    public final void endOperation(String paramString)
    {
      AppMethodBeat.i(12293);
      if (this.mOperation == null)
      {
        AppMethodBeat.o(12293);
        return;
      }
      SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
      if (localSQLiteConnection == null)
      {
        AppMethodBeat.o(12293);
        return;
      }
      if (localSQLiteConnection.mRecentOperations.endOperationDeferLog(this.mOperation.mCookie)) {
        localSQLiteConnection.mRecentOperations.logOperation(this.mOperation.mCookie, paramString);
      }
      this.mOperation = null;
      AppMethodBeat.o(12293);
    }
    
    public final void failOperation(Exception paramException)
    {
      AppMethodBeat.i(12292);
      if (this.mOperation == null)
      {
        AppMethodBeat.o(12292);
        return;
      }
      SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
      if (localSQLiteConnection == null)
      {
        AppMethodBeat.o(12292);
        return;
      }
      localSQLiteConnection.mRecentOperations.failOperation(this.mOperation.mCookie, paramException);
      AppMethodBeat.o(12292);
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
      AppMethodBeat.i(12288);
      SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
      if (localSQLiteConnection == null)
      {
        AppMethodBeat.o(12288);
        return;
      }
      SQLiteConnection.access$1000(localSQLiteConnection, this, paramBoolean);
      AppMethodBeat.o(12288);
    }
  }
  
  final class PreparedStatementCache
    extends LruCache<String, SQLiteConnection.PreparedStatement>
  {
    public PreparedStatementCache(int paramInt)
    {
      super();
    }
    
    public final void dump(Printer paramPrinter)
    {
      AppMethodBeat.i(12295);
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
            paramPrinter.println("    " + i + ": statementPtr=0x" + Long.toHexString(localPreparedStatement.getPtr()) + ", numParameters=" + localPreparedStatement.mNumParameters + ", type=" + localPreparedStatement.mType + ", readOnly=" + localPreparedStatement.mReadOnly + ", sql=\"" + SQLiteConnection.access$1500((String)localObject2) + "\"");
          }
          i += 1;
        }
        AppMethodBeat.o(12295);
        return;
      }
      paramPrinter.println("    <none>");
      AppMethodBeat.o(12295);
    }
    
    protected final void entryRemoved(boolean paramBoolean, String paramString, SQLiteConnection.PreparedStatement paramPreparedStatement1, SQLiteConnection.PreparedStatement paramPreparedStatement2)
    {
      AppMethodBeat.i(12294);
      SQLiteConnection.PreparedStatement.access$502(paramPreparedStatement1, false);
      if (!paramPreparedStatement1.mInUse) {
        SQLiteConnection.access$1400(SQLiteConnection.this, paramPreparedStatement1);
      }
      AppMethodBeat.o(12294);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteConnection
 * JD-Core Version:    0.7.0.1
 */