package com.tencent.wcdb.database;

import android.content.ContentValues;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Printer;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.DefaultDatabaseErrorHandler;
import com.tencent.wcdb.SQLException;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class SQLiteDatabase
  extends SQLiteClosable
{
  public static final int CONFLICT_ABORT = 2;
  public static final int CONFLICT_FAIL = 3;
  public static final int CONFLICT_IGNORE = 4;
  public static final int CONFLICT_NONE = 0;
  public static final int CONFLICT_REPLACE = 5;
  public static final int CONFLICT_ROLLBACK = 1;
  private static final String[] CONFLICT_VALUES;
  public static final int CREATE_IF_NECESSARY = 268435456;
  public static final int ENABLE_IO_TRACE = 256;
  public static final int ENABLE_WRITE_AHEAD_LOGGING = 536870912;
  public static final int MAX_SQL_CACHE_SIZE = 100;
  public static final int NO_LOCALIZED_COLLATORS = 16;
  public static final int OPEN_READONLY = 1;
  public static final int OPEN_READWRITE = 0;
  private static final int OPEN_READ_MASK = 1;
  public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
  public static final int SYNCHRONOUS_EXTRA = 3;
  public static final int SYNCHRONOUS_FULL = 2;
  public static final int SYNCHRONOUS_NORMAL = 1;
  public static final int SYNCHRONOUS_OFF = 0;
  private static final String TAG = "WCDB.SQLiteDatabase";
  private static final WeakHashMap<SQLiteDatabase, Object> sActiveDatabases;
  private final SQLiteDatabaseConfiguration mConfigurationLocked;
  private SQLiteConnectionPool mConnectionPoolLocked;
  private final CursorFactory mCursorFactory;
  private final DatabaseErrorHandler mErrorHandler;
  private boolean mHasAttachedDbsLocked;
  private final Object mLock = new Object();
  private final ThreadLocal<SQLiteSession> mThreadSession = new ThreadLocal()
  {
    protected SQLiteSession initialValue()
    {
      return SQLiteDatabase.this.createSession();
    }
  };
  
  static
  {
    if (!SQLiteDatabase.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      SQLiteGlobal.loadLib();
      sActiveDatabases = new WeakHashMap();
      CONFLICT_VALUES = new String[] { "", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE " };
      return;
    }
  }
  
  private SQLiteDatabase(String paramString, int paramInt, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    this.mCursorFactory = paramCursorFactory;
    if (paramDatabaseErrorHandler != null) {}
    for (;;)
    {
      this.mErrorHandler = paramDatabaseErrorHandler;
      this.mConfigurationLocked = new SQLiteDatabaseConfiguration(paramString, paramInt);
      return;
      paramDatabaseErrorHandler = new DefaultDatabaseErrorHandler(true);
    }
  }
  
  /* Error */
  private void beginTransaction(SQLiteTransactionListener paramSQLiteTransactionListener, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 143	com/tencent/wcdb/database/SQLiteDatabase:acquireReference	()V
    //   4: aload_0
    //   5: invokevirtual 147	com/tencent/wcdb/database/SQLiteDatabase:getThreadSession	()Lcom/tencent/wcdb/database/SQLiteSession;
    //   8: astore 4
    //   10: iload_2
    //   11: ifeq +23 -> 34
    //   14: iconst_2
    //   15: istore_3
    //   16: aload 4
    //   18: iload_3
    //   19: aload_1
    //   20: aload_0
    //   21: iconst_0
    //   22: invokevirtual 151	com/tencent/wcdb/database/SQLiteDatabase:getThreadDefaultConnectionFlags	(Z)I
    //   25: aconst_null
    //   26: invokevirtual 156	com/tencent/wcdb/database/SQLiteSession:beginTransaction	(ILcom/tencent/wcdb/database/SQLiteTransactionListener;ILcom/tencent/wcdb/support/CancellationSignal;)V
    //   29: aload_0
    //   30: invokevirtual 159	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   33: return
    //   34: iconst_1
    //   35: istore_3
    //   36: goto -20 -> 16
    //   39: astore_1
    //   40: aload_0
    //   41: invokevirtual 159	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	SQLiteDatabase
    //   0	46	1	paramSQLiteTransactionListener	SQLiteTransactionListener
    //   0	46	2	paramBoolean	boolean
    //   15	21	3	i	int
    //   8	9	4	localSQLiteSession	SQLiteSession
    // Exception table:
    //   from	to	target	type
    //   4	10	39	finally
    //   16	29	39	finally
  }
  
  private void collectDbStats(ArrayList<SQLiteDebug.DbStats> paramArrayList)
  {
    synchronized (this.mLock)
    {
      if (this.mConnectionPoolLocked != null) {
        this.mConnectionPoolLocked.collectDbStats(paramArrayList);
      }
      return;
    }
  }
  
  public static SQLiteDatabase create(CursorFactory paramCursorFactory)
  {
    return openDatabase(":memory:", paramCursorFactory, 268435456);
  }
  
  public static boolean deleteDatabase(File paramFile)
  {
    if (paramFile == null) {
      throw new IllegalArgumentException("file must not be null");
    }
    boolean bool1 = paramFile.delete() | new File(paramFile.getPath() + "-journal").delete() | new File(paramFile.getPath() + "-shm").delete() | new File(paramFile.getPath() + "-wal").delete();
    File localFile = paramFile.getParentFile();
    boolean bool2 = bool1;
    if (localFile != null)
    {
      paramFile = localFile.listFiles(new FileFilter()
      {
        public final boolean accept(File paramAnonymousFile)
        {
          return paramAnonymousFile.getName().startsWith(this.val$prefix);
        }
      });
      bool2 = bool1;
      if (paramFile != null)
      {
        int j = paramFile.length;
        int i = 0;
        for (;;)
        {
          bool2 = bool1;
          if (i >= j) {
            break;
          }
          bool1 |= paramFile[i].delete();
          i += 1;
        }
      }
    }
    return bool2;
  }
  
  private void dispose(boolean paramBoolean)
  {
    SQLiteConnectionPool localSQLiteConnectionPool;
    synchronized (this.mLock)
    {
      localSQLiteConnectionPool = this.mConnectionPoolLocked;
      this.mConnectionPoolLocked = null;
      if (paramBoolean) {}
    }
    synchronized (sActiveDatabases)
    {
      sActiveDatabases.remove(this);
      if (localSQLiteConnectionPool != null) {
        localSQLiteConnectionPool.close();
      }
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public static void dumpAll(Printer paramPrinter, boolean paramBoolean)
  {
    Iterator localIterator = getActiveDatabases().iterator();
    while (localIterator.hasNext()) {
      ((SQLiteDatabase)localIterator.next()).dump(paramPrinter, paramBoolean);
    }
  }
  
  private int executeSql(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    int i = 1;
    acquireReference();
    for (;;)
    {
      try
      {
        if (DatabaseUtils.getSqlStatementType(paramString) == 3) {}
        synchronized (this.mLock)
        {
          if (!this.mHasAttachedDbsLocked)
          {
            this.mHasAttachedDbsLocked = true;
            if (i != 0) {
              disableWriteAheadLogging();
            }
            paramString = new SQLiteStatement(this, paramString, paramArrayOfObject);
          }
        }
        i = 0;
      }
      finally
      {
        releaseReference();
      }
    }
  }
  
  public static String findEditTable(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.indexOf(' ');
      int j = paramString.indexOf(',');
      String str;
      if ((i > 0) && ((i < j) || (j < 0))) {
        str = paramString.substring(0, i);
      }
      do
      {
        do
        {
          return str;
          str = paramString;
        } while (j <= 0);
        if (j < i) {
          break;
        }
        str = paramString;
      } while (i >= 0);
      return paramString.substring(0, j);
    }
    throw new IllegalStateException("Invalid tables");
  }
  
  private static ArrayList<SQLiteDatabase> getActiveDatabases()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (sActiveDatabases)
    {
      localArrayList.addAll(sActiveDatabases.keySet());
      return localArrayList;
    }
  }
  
  static ArrayList<SQLiteDebug.DbStats> getDbStats()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getActiveDatabases().iterator();
    while (localIterator.hasNext()) {
      ((SQLiteDatabase)localIterator.next()).collectDbStats(localArrayList);
    }
    return localArrayList;
  }
  
  private static boolean isMainThread()
  {
    Looper localLooper = Looper.myLooper();
    return (localLooper != null) && (localLooper == Looper.getMainLooper());
  }
  
  private boolean isReadOnlyLocked()
  {
    return (this.mConfigurationLocked.openFlags & 0x1) == 1;
  }
  
  private Set<String> keySet(ContentValues paramContentValues)
  {
    if (Build.VERSION.SDK_INT < 11) {
      try
      {
        Field localField = Class.forName("android.content.ContentValues").getDeclaredField("mValues");
        localField.setAccessible(true);
        paramContentValues = ((HashMap)localField.get(paramContentValues)).keySet();
        return paramContentValues;
      }
      catch (Exception paramContentValues)
      {
        throw new RuntimeException(paramContentValues);
      }
    }
    return paramContentValues.keySet();
  }
  
  private void open(byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, int paramInt)
  {
    try
    {
      openInner(paramArrayOfByte, paramSQLiteCipherSpec, paramInt);
      return;
    }
    catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
    {
      onCorruption();
      openInner(paramArrayOfByte, paramSQLiteCipherSpec, paramInt);
      return;
    }
    catch (SQLiteException paramArrayOfByte)
    {
      Log.e("WCDB.SQLiteDatabase", "Failed to open database '" + getLabel() + "'.", new Object[] { paramArrayOfByte });
      close();
      throw paramArrayOfByte;
    }
  }
  
  public static SQLiteDatabase openDatabase(String paramString, CursorFactory paramCursorFactory, int paramInt)
  {
    return openDatabase(paramString, paramCursorFactory, paramInt, null);
  }
  
  public static SQLiteDatabase openDatabase(String paramString, CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return openDatabase(paramString, null, null, paramCursorFactory, paramInt, paramDatabaseErrorHandler, 0);
  }
  
  public static SQLiteDatabase openDatabase(String paramString, CursorFactory paramCursorFactory, int paramInt1, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt2)
  {
    return openDatabase(paramString, null, null, paramCursorFactory, paramInt1, paramDatabaseErrorHandler, paramInt2);
  }
  
  public static SQLiteDatabase openDatabase(String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return openDatabase(paramString, paramArrayOfByte, paramSQLiteCipherSpec, paramCursorFactory, paramInt, paramDatabaseErrorHandler, 0);
  }
  
  public static SQLiteDatabase openDatabase(String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, CursorFactory paramCursorFactory, int paramInt1, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt2)
  {
    paramString = new SQLiteDatabase(paramString, paramInt1, paramCursorFactory, paramDatabaseErrorHandler);
    paramString.open(paramArrayOfByte, paramSQLiteCipherSpec, paramInt2);
    return paramString;
  }
  
  private void openInner(byte[] arg1, SQLiteCipherSpec paramSQLiteCipherSpec, int paramInt)
  {
    synchronized (this.mLock)
    {
      if ((!$assertionsDisabled) && (this.mConnectionPoolLocked != null)) {
        throw new AssertionError();
      }
    }
    this.mConnectionPoolLocked = SQLiteConnectionPool.open(this, this.mConfigurationLocked, ???, paramSQLiteCipherSpec, paramInt);
    synchronized (sActiveDatabases)
    {
      sActiveDatabases.put(this, null);
      return;
    }
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, CursorFactory paramCursorFactory)
  {
    return openOrCreateDatabase(paramFile.getPath(), paramCursorFactory);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return openOrCreateDatabase(paramFile.getPath(), paramArrayOfByte, paramSQLiteCipherSpec, paramCursorFactory, paramDatabaseErrorHandler, 0);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt)
  {
    return openOrCreateDatabase(paramFile.getPath(), paramArrayOfByte, paramSQLiteCipherSpec, paramCursorFactory, paramDatabaseErrorHandler, paramInt);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, byte[] paramArrayOfByte, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return openOrCreateDatabase(paramFile.getPath(), paramArrayOfByte, null, paramCursorFactory, paramDatabaseErrorHandler, 0);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, byte[] paramArrayOfByte, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt)
  {
    return openOrCreateDatabase(paramFile.getPath(), paramArrayOfByte, null, paramCursorFactory, paramDatabaseErrorHandler, paramInt);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, CursorFactory paramCursorFactory)
  {
    return openDatabase(paramString, null, null, paramCursorFactory, 268435456, null, 0);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, CursorFactory paramCursorFactory, int paramInt)
  {
    return openDatabase(paramString, null, null, paramCursorFactory, 268435456, null, paramInt);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return openDatabase(paramString, paramCursorFactory, 268435456, paramDatabaseErrorHandler);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, CursorFactory paramCursorFactory, boolean paramBoolean)
  {
    int i = 268435456;
    if (paramBoolean) {
      i = 805306368;
    }
    return openDatabase(paramString, null, null, paramCursorFactory, i, null, 0);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt)
  {
    return openDatabase(paramString, paramArrayOfByte, paramSQLiteCipherSpec, paramCursorFactory, 268435456, paramDatabaseErrorHandler, paramInt);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, byte[] paramArrayOfByte, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return openOrCreateDatabase(paramString, paramArrayOfByte, null, paramCursorFactory, paramDatabaseErrorHandler, 0);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, byte[] paramArrayOfByte, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt)
  {
    return openOrCreateDatabase(paramString, paramArrayOfByte, null, paramCursorFactory, paramDatabaseErrorHandler, paramInt);
  }
  
  public static SQLiteDatabase openOrCreateDatabaseInWalMode(String paramString, CursorFactory paramCursorFactory)
  {
    return openDatabase(paramString, null, null, paramCursorFactory, 805306368, null, 0);
  }
  
  public static SQLiteDatabase openOrCreateDatabaseInWalMode(String paramString, CursorFactory paramCursorFactory, int paramInt)
  {
    return openDatabase(paramString, null, null, paramCursorFactory, 805306368, null, paramInt);
  }
  
  public static SQLiteDatabase openOrCreateDatabaseInWalMode(String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, CursorFactory paramCursorFactory)
  {
    return openDatabase(paramString, paramArrayOfByte, paramSQLiteCipherSpec, paramCursorFactory, 805306368, null, 0);
  }
  
  public static SQLiteDatabase openOrCreateDatabaseInWalMode(String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt)
  {
    return openDatabase(paramString, paramArrayOfByte, paramSQLiteCipherSpec, paramCursorFactory, 805306368, paramDatabaseErrorHandler, paramInt);
  }
  
  public static SQLiteDatabase openOrCreateMemoryDatabaseInWalMode(CursorFactory paramCursorFactory)
  {
    return openDatabase(":memory:", null, null, paramCursorFactory, 805306368, null, 0);
  }
  
  public static int releaseMemory()
  {
    return SQLiteGlobal.releaseMemory();
  }
  
  private void throwIfNotOpenLocked()
  {
    if (this.mConnectionPoolLocked == null) {
      throw new IllegalStateException("The database '" + this.mConfigurationLocked.label + "' is not open.");
    }
  }
  
  private boolean yieldIfContendedHelper(boolean paramBoolean, long paramLong)
  {
    acquireReference();
    try
    {
      paramBoolean = getThreadSession().yieldTransaction(paramLong, paramBoolean, null);
      return paramBoolean;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public final long acquireNativeConnectionHandle(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = paramString;
    if (paramString == null) {
      str = "unnamedNative";
    }
    if (paramBoolean1) {}
    long l;
    for (int i = 1;; i = 2)
    {
      int j = i;
      if (paramBoolean2) {
        j = i | 0x4;
      }
      l = getThreadSession().acquireConnectionForNativeHandle(j).getNativeHandle(str);
      if (l != 0L) {
        break;
      }
      throw new IllegalStateException("SQLiteConnection native handle not initialized.");
    }
    return l;
  }
  
  public final void addCustomFunction(String arg1, int paramInt, CustomFunction paramCustomFunction)
  {
    paramCustomFunction = new SQLiteCustomFunction(???, paramInt, paramCustomFunction);
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      this.mConfigurationLocked.customFunctions.add(paramCustomFunction);
      try
      {
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        this.mConfigurationLocked.customFunctions.remove(paramCustomFunction);
        throw localRuntimeException;
      }
    }
  }
  
  public final void beginTransaction()
  {
    beginTransaction(null, true);
  }
  
  public final void beginTransactionNonExclusive()
  {
    beginTransaction(null, false);
  }
  
  public final void beginTransactionWithListener(SQLiteTransactionListener paramSQLiteTransactionListener)
  {
    beginTransaction(paramSQLiteTransactionListener, true);
  }
  
  public final void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener paramSQLiteTransactionListener)
  {
    beginTransaction(paramSQLiteTransactionListener, false);
  }
  
  public final SQLiteStatement compileStatement(String paramString)
  {
    acquireReference();
    try
    {
      paramString = new SQLiteStatement(this, paramString, null);
      return paramString;
    }
    finally
    {
      releaseReference();
    }
  }
  
  final SQLiteSession createSession()
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      SQLiteConnectionPool localSQLiteConnectionPool = this.mConnectionPoolLocked;
      return new SQLiteSession(localSQLiteConnectionPool);
    }
  }
  
  /* Error */
  public final int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 143	com/tencent/wcdb/database/SQLiteDatabase:acquireReference	()V
    //   4: new 193	java/lang/StringBuilder
    //   7: dup
    //   8: ldc_w 509
    //   11: invokespecial 384	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: astore 5
    //   20: aload_2
    //   21: invokestatic 289	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifne +57 -> 81
    //   27: new 193	java/lang/StringBuilder
    //   30: dup
    //   31: ldc_w 511
    //   34: invokespecial 384	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   37: aload_2
    //   38: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: astore_1
    //   45: new 273	com/tencent/wcdb/database/SQLiteStatement
    //   48: dup
    //   49: aload_0
    //   50: aload 5
    //   52: aload_1
    //   53: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: aload_3
    //   60: invokespecial 276	com/tencent/wcdb/database/SQLiteStatement:<init>	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/Object;)V
    //   63: astore_1
    //   64: aload_1
    //   65: invokevirtual 513	com/tencent/wcdb/database/SQLiteStatement:executeUpdateDelete	()I
    //   68: istore 4
    //   70: aload_1
    //   71: invokevirtual 281	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   74: aload_0
    //   75: invokevirtual 159	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   78: iload 4
    //   80: ireturn
    //   81: ldc 97
    //   83: astore_1
    //   84: goto -39 -> 45
    //   87: astore_2
    //   88: aload_1
    //   89: invokevirtual 281	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   92: aload_2
    //   93: athrow
    //   94: astore_1
    //   95: aload_0
    //   96: invokevirtual 159	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	SQLiteDatabase
    //   0	101	1	paramString1	String
    //   0	101	2	paramString2	String
    //   0	101	3	paramArrayOfString	String[]
    //   68	11	4	i	int
    //   18	33	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   64	70	87	finally
    //   4	45	94	finally
    //   45	64	94	finally
    //   70	74	94	finally
    //   88	94	94	finally
  }
  
  public final void disableWriteAheadLogging()
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      if ((this.mConfigurationLocked.openFlags & 0x20000000) == 0) {
        return;
      }
      SQLiteDatabaseConfiguration localSQLiteDatabaseConfiguration1 = this.mConfigurationLocked;
      localSQLiteDatabaseConfiguration1.openFlags &= 0xDFFFFFFF;
    }
  }
  
  public final void dump(Printer paramPrinter, boolean paramBoolean)
  {
    synchronized (this.mLock)
    {
      if (this.mConnectionPoolLocked != null) {
        this.mConnectionPoolLocked.dump(paramPrinter, paramBoolean);
      }
      return;
    }
  }
  
  public final boolean enableWriteAheadLogging()
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      if ((this.mConfigurationLocked.openFlags & 0x20000000) != 0) {
        return true;
      }
      if (isReadOnlyLocked()) {
        return false;
      }
      if (this.mConfigurationLocked.isInMemoryDb())
      {
        Log.i("WCDB.SQLiteDatabase", "can't enable WAL for memory databases.");
        return false;
      }
      if (this.mHasAttachedDbsLocked)
      {
        Log.i("WCDB.SQLiteDatabase", "this database: " + this.mConfigurationLocked.label + " has attached databases. can't  enable WAL.");
        return false;
      }
      SQLiteDatabaseConfiguration localSQLiteDatabaseConfiguration1 = this.mConfigurationLocked;
      localSQLiteDatabaseConfiguration1.openFlags |= 0x20000000;
    }
  }
  
  public final void endTransaction()
  {
    acquireReference();
    try
    {
      getThreadSession().endTransaction(null);
      return;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public final void execSQL(String paramString)
  {
    executeSql(paramString, null, null);
  }
  
  public final void execSQL(String paramString, Object[] paramArrayOfObject)
  {
    executeSql(paramString, paramArrayOfObject, null);
  }
  
  public final void execSQL(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    executeSql(paramString, paramArrayOfObject, paramCancellationSignal);
  }
  
  protected final void finalize()
  {
    try
    {
      dispose(true);
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public final boolean getAsyncCheckpointEnabled()
  {
    SQLiteCheckpointListener localSQLiteCheckpointListener = getCheckpointCallback();
    return (localSQLiteCheckpointListener != null) && ((localSQLiteCheckpointListener instanceof SQLiteAsyncCheckpointer));
  }
  
  /* Error */
  public final java.util.List<Pair<String, String>> getAttachedDbs()
  {
    // Byte code:
    //   0: new 242	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 303	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 122	com/tencent/wcdb/database/SQLiteDatabase:mLock	Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 163	com/tencent/wcdb/database/SQLiteDatabase:mConnectionPoolLocked	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   19: ifnonnull +7 -> 26
    //   22: aload_1
    //   23: monitorexit
    //   24: aconst_null
    //   25: areturn
    //   26: aload_0
    //   27: getfield 268	com/tencent/wcdb/database/SQLiteDatabase:mHasAttachedDbsLocked	Z
    //   30: ifne +29 -> 59
    //   33: aload_2
    //   34: new 556	android/util/Pair
    //   37: dup
    //   38: ldc_w 558
    //   41: aload_0
    //   42: getfield 133	com/tencent/wcdb/database/SQLiteDatabase:mConfigurationLocked	Lcom/tencent/wcdb/database/SQLiteDatabaseConfiguration;
    //   45: getfield 561	com/tencent/wcdb/database/SQLiteDatabaseConfiguration:path	Ljava/lang/String;
    //   48: invokespecial 564	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   51: invokevirtual 488	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   54: pop
    //   55: aload_1
    //   56: monitorexit
    //   57: aload_2
    //   58: areturn
    //   59: aload_0
    //   60: invokevirtual 143	com/tencent/wcdb/database/SQLiteDatabase:acquireReference	()V
    //   63: aload_1
    //   64: monitorexit
    //   65: aload_0
    //   66: ldc_w 566
    //   69: aconst_null
    //   70: invokevirtual 570	com/tencent/wcdb/database/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   73: astore_1
    //   74: aload_1
    //   75: invokeinterface 575 1 0
    //   80: ifeq +57 -> 137
    //   83: aload_2
    //   84: new 556	android/util/Pair
    //   87: dup
    //   88: aload_1
    //   89: iconst_1
    //   90: invokeinterface 579 2 0
    //   95: aload_1
    //   96: iconst_2
    //   97: invokeinterface 579 2 0
    //   102: invokespecial 564	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   105: invokevirtual 488	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   108: pop
    //   109: goto -35 -> 74
    //   112: astore_2
    //   113: aload_1
    //   114: ifnull +9 -> 123
    //   117: aload_1
    //   118: invokeinterface 580 1 0
    //   123: aload_2
    //   124: athrow
    //   125: astore_1
    //   126: aload_0
    //   127: invokevirtual 159	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   130: aload_1
    //   131: athrow
    //   132: astore_2
    //   133: aload_1
    //   134: monitorexit
    //   135: aload_2
    //   136: athrow
    //   137: aload_1
    //   138: ifnull +9 -> 147
    //   141: aload_1
    //   142: invokeinterface 580 1 0
    //   147: aload_0
    //   148: invokevirtual 159	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   151: aload_2
    //   152: areturn
    //   153: astore_2
    //   154: aconst_null
    //   155: astore_1
    //   156: goto -43 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	SQLiteDatabase
    //   12	106	1	localObject1	Object
    //   125	17	1	localObject2	Object
    //   155	1	1	localObject3	Object
    //   7	77	2	localArrayList	ArrayList
    //   112	12	2	localObject4	Object
    //   132	20	2	localList	java.util.List<Pair<String, String>>
    //   153	1	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   74	109	112	finally
    //   117	123	125	finally
    //   123	125	125	finally
    //   141	147	125	finally
    //   15	24	132	finally
    //   26	57	132	finally
    //   59	65	132	finally
    //   133	135	132	finally
    //   65	74	153	finally
  }
  
  public final SQLiteChangeListener getChangeListener()
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      SQLiteChangeListener localSQLiteChangeListener = this.mConnectionPoolLocked.getChangeListener();
      return localSQLiteChangeListener;
    }
  }
  
  public final SQLiteCheckpointListener getCheckpointCallback()
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      if (!this.mConfigurationLocked.customWALHookEnabled) {
        return null;
      }
      SQLiteCheckpointListener localSQLiteCheckpointListener = this.mConnectionPoolLocked.getCheckpointListener();
      return localSQLiteCheckpointListener;
    }
  }
  
  final String getLabel()
  {
    synchronized (this.mLock)
    {
      String str = this.mConfigurationLocked.label;
      return str;
    }
  }
  
  public final long getMaximumSize()
  {
    return DatabaseUtils.longForQuery(this, "PRAGMA max_page_count;", null) * getPageSize();
  }
  
  public final long getPageSize()
  {
    return DatabaseUtils.longForQuery(this, "PRAGMA page_size;", null);
  }
  
  public final String getPath()
  {
    synchronized (this.mLock)
    {
      String str = this.mConfigurationLocked.path;
      return str;
    }
  }
  
  @Deprecated
  public final Map<String, String> getSyncedTables()
  {
    return new HashMap(0);
  }
  
  public final int getSynchronousMode()
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      int i = this.mConfigurationLocked.synchronousMode;
      return i;
    }
  }
  
  final int getThreadDefaultConnectionFlags(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      int j = i;
      if (isMainThread()) {
        j = i | 0x4;
      }
      return j;
    }
  }
  
  final SQLiteSession getThreadSession()
  {
    return (SQLiteSession)this.mThreadSession.get();
  }
  
  public final SQLiteTrace getTraceCallback()
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      SQLiteTrace localSQLiteTrace = this.mConnectionPoolLocked.getTraceCallback();
      return localSQLiteTrace;
    }
  }
  
  public final int getVersion()
  {
    return Long.valueOf(DatabaseUtils.longForQuery(this, "PRAGMA user_version;", null)).intValue();
  }
  
  public final boolean inTransaction()
  {
    acquireReference();
    try
    {
      boolean bool = getThreadSession().hasTransaction();
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public final long insert(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    try
    {
      long l = insertWithOnConflict(paramString1, paramString2, paramContentValues, 0);
      return l;
    }
    catch (SQLiteDatabaseCorruptException paramString1)
    {
      throw paramString1;
    }
    catch (SQLException paramString1)
    {
      Log.e("WCDB.SQLiteDatabase", "Error inserting %s: %s", new Object[] { paramContentValues, paramString1 });
    }
    return -1L;
  }
  
  public final long insertOrThrow(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    return insertWithOnConflict(paramString1, paramString2, paramContentValues, 0);
  }
  
  public final long insertWithOnConflict(String paramString1, String paramString2, ContentValues paramContentValues, int paramInt)
  {
    int j = 0;
    acquireReference();
    for (;;)
    {
      int i;
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("INSERT");
        localStringBuilder.append(CONFLICT_VALUES[paramInt]);
        localStringBuilder.append(" INTO ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append('(');
        paramString1 = null;
        if ((paramContentValues == null) || (paramContentValues.size() <= 0)) {
          break label294;
        }
        paramInt = paramContentValues.size();
        if (paramInt > 0)
        {
          paramString2 = new Object[paramInt];
          Iterator localIterator = keySet(paramContentValues).iterator();
          i = 0;
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (i <= 0) {
              break label300;
            }
            paramString1 = ",";
            localStringBuilder.append(paramString1);
            localStringBuilder.append(str);
            paramString2[i] = paramContentValues.get(str);
            i += 1;
            continue;
          }
          localStringBuilder.append(')');
          localStringBuilder.append(" VALUES (");
          i = j;
          break label306;
          localStringBuilder.append(paramString1);
          i += 1;
          break label306;
          localStringBuilder.append(')');
          paramString1 = new SQLiteStatement(this, localStringBuilder.toString(), paramString1);
        }
      }
      finally
      {
        StringBuilder localStringBuilder;
        long l;
        releaseReference();
      }
      try
      {
        l = paramString1.executeInsert();
        paramString1.close();
        releaseReference();
        return l;
      }
      finally
      {
        paramString1.close();
      }
      localStringBuilder.append(paramString2 + ") VALUES (NULL");
      continue;
      label294:
      paramInt = 0;
      continue;
      label300:
      paramString1 = "";
      continue;
      label306:
      if (i < paramInt)
      {
        if (i > 0) {
          paramString1 = ",?";
        } else {
          paramString1 = "?";
        }
      }
      else {
        paramString1 = paramString2;
      }
    }
  }
  
  /* Error */
  public final boolean isDatabaseIntegrityOk()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 143	com/tencent/wcdb/database/SQLiteDatabase:acquireReference	()V
    //   4: aload_0
    //   5: invokevirtual 689	com/tencent/wcdb/database/SQLiteDatabase:getAttachedDbs	()Ljava/util/List;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnonnull +198 -> 208
    //   13: new 299	java/lang/IllegalStateException
    //   16: dup
    //   17: new 193	java/lang/StringBuilder
    //   20: dup
    //   21: ldc_w 691
    //   24: invokespecial 384	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   27: aload_0
    //   28: invokevirtual 692	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   31: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc_w 694
    //   37: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokespecial 302	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   46: athrow
    //   47: astore_2
    //   48: new 242	java/util/ArrayList
    //   51: dup
    //   52: invokespecial 303	java/util/ArrayList:<init>	()V
    //   55: astore_3
    //   56: aload_3
    //   57: new 556	android/util/Pair
    //   60: dup
    //   61: ldc_w 558
    //   64: aload_0
    //   65: invokevirtual 692	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   68: invokespecial 564	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   71: invokeinterface 697 2 0
    //   76: pop
    //   77: goto +172 -> 249
    //   80: iload_1
    //   81: aload_3
    //   82: invokeinterface 698 1 0
    //   87: if_icmpge +152 -> 239
    //   90: aload_3
    //   91: iload_1
    //   92: invokeinterface 701 2 0
    //   97: checkcast 556	android/util/Pair
    //   100: astore 4
    //   102: aload_0
    //   103: new 193	java/lang/StringBuilder
    //   106: dup
    //   107: ldc_w 703
    //   110: invokespecial 384	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   113: aload 4
    //   115: getfield 706	android/util/Pair:first	Ljava/lang/Object;
    //   118: checkcast 95	java/lang/String
    //   121: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: ldc_w 708
    //   127: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokevirtual 710	com/tencent/wcdb/database/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteStatement;
    //   136: astore_2
    //   137: aload_2
    //   138: invokevirtual 713	com/tencent/wcdb/database/SQLiteStatement:simpleQueryForString	()Ljava/lang/String;
    //   141: astore 5
    //   143: aload 5
    //   145: ldc_w 715
    //   148: invokestatic 719	com/tencent/wcdb/DatabaseUtils:objectEquals	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   151: ifne +60 -> 211
    //   154: ldc 54
    //   156: new 193	java/lang/StringBuilder
    //   159: dup
    //   160: ldc_w 721
    //   163: invokespecial 384	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   166: aload 4
    //   168: getfield 724	android/util/Pair:second	Ljava/lang/Object;
    //   171: checkcast 95	java/lang/String
    //   174: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: ldc_w 726
    //   180: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload 5
    //   185: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 728	com/tencent/wcdb/support/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: aload_2
    //   195: ifnull +7 -> 202
    //   198: aload_2
    //   199: invokevirtual 281	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   202: aload_0
    //   203: invokevirtual 159	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   206: iconst_0
    //   207: ireturn
    //   208: goto +41 -> 249
    //   211: aload_2
    //   212: ifnull +42 -> 254
    //   215: aload_2
    //   216: invokevirtual 281	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   219: goto +35 -> 254
    //   222: aload_2
    //   223: ifnull +7 -> 230
    //   226: aload_2
    //   227: invokevirtual 281	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   230: aload_3
    //   231: athrow
    //   232: astore_2
    //   233: aload_0
    //   234: invokevirtual 159	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   237: aload_2
    //   238: athrow
    //   239: aload_0
    //   240: invokevirtual 159	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   243: iconst_1
    //   244: ireturn
    //   245: astore_3
    //   246: goto -24 -> 222
    //   249: iconst_0
    //   250: istore_1
    //   251: goto -171 -> 80
    //   254: iload_1
    //   255: iconst_1
    //   256: iadd
    //   257: istore_1
    //   258: goto -178 -> 80
    //   261: astore_3
    //   262: aconst_null
    //   263: astore_2
    //   264: goto -42 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	SQLiteDatabase
    //   80	178	1	i	int
    //   47	1	2	localSQLiteException	SQLiteException
    //   136	91	2	localSQLiteStatement	SQLiteStatement
    //   232	6	2	localObject1	Object
    //   263	1	2	localObject2	Object
    //   8	223	3	localObject3	Object
    //   245	1	3	localObject4	Object
    //   261	1	3	localObject5	Object
    //   100	67	4	localPair	Pair
    //   141	43	5	str	String
    // Exception table:
    //   from	to	target	type
    //   4	9	47	com/tencent/wcdb/database/SQLiteException
    //   13	47	47	com/tencent/wcdb/database/SQLiteException
    //   4	9	232	finally
    //   13	47	232	finally
    //   48	77	232	finally
    //   80	102	232	finally
    //   198	202	232	finally
    //   215	219	232	finally
    //   226	230	232	finally
    //   230	232	232	finally
    //   137	194	245	finally
    //   102	137	261	finally
  }
  
  public final boolean isDbLockedByCurrentThread()
  {
    acquireReference();
    try
    {
      boolean bool = getThreadSession().hasConnection();
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }
  
  @Deprecated
  public final boolean isDbLockedByOtherThreads()
  {
    return false;
  }
  
  public final boolean isInMemoryDatabase()
  {
    synchronized (this.mLock)
    {
      boolean bool = this.mConfigurationLocked.isInMemoryDb();
      return bool;
    }
  }
  
  public final boolean isOpen()
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (this.mConnectionPoolLocked != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public final boolean isReadOnly()
  {
    synchronized (this.mLock)
    {
      boolean bool = isReadOnlyLocked();
      return bool;
    }
  }
  
  public final boolean isWriteAheadLoggingEnabled()
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        throwIfNotOpenLocked();
        if ((this.mConfigurationLocked.openFlags & 0x20000000) != 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  @Deprecated
  public final void markTableSyncable(String paramString1, String paramString2) {}
  
  @Deprecated
  public final void markTableSyncable(String paramString1, String paramString2, String paramString3) {}
  
  public final boolean needUpgrade(int paramInt)
  {
    return paramInt > getVersion();
  }
  
  protected final void onAllReferencesReleased()
  {
    dispose(false);
  }
  
  final void onCorruption()
  {
    this.mErrorHandler.onCorruption(this);
  }
  
  public final Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    return query(false, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, null);
  }
  
  public final Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return query(false, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public final Cursor query(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return queryWithFactory(null, paramBoolean, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6, null);
  }
  
  public final Cursor query(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6, CancellationSignal paramCancellationSignal)
  {
    return queryWithFactory(null, paramBoolean, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6, paramCancellationSignal);
  }
  
  public final Cursor queryWithFactory(CursorFactory paramCursorFactory, boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return queryWithFactory(paramCursorFactory, paramBoolean, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6, null);
  }
  
  public final Cursor queryWithFactory(CursorFactory paramCursorFactory, boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6, CancellationSignal paramCancellationSignal)
  {
    acquireReference();
    try
    {
      paramCursorFactory = rawQueryWithFactory(paramCursorFactory, SQLiteQueryBuilder.buildQueryString(paramBoolean, paramString1, paramArrayOfString1, paramString2, paramString3, paramString4, paramString5, paramString6), paramArrayOfString2, findEditTable(paramString1), paramCancellationSignal);
      return paramCursorFactory;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    return rawQueryWithFactory(null, paramString, paramArrayOfString, null, null);
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString, CancellationSignal paramCancellationSignal)
  {
    return rawQueryWithFactory(null, paramString, paramArrayOfString, null, paramCancellationSignal);
  }
  
  public final Cursor rawQueryWithFactory(CursorFactory paramCursorFactory, String paramString1, String[] paramArrayOfString, String paramString2)
  {
    return rawQueryWithFactory(paramCursorFactory, paramString1, paramArrayOfString, paramString2, null);
  }
  
  /* Error */
  public final Cursor rawQueryWithFactory(CursorFactory paramCursorFactory, String paramString1, String[] paramArrayOfString, String paramString2, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 143	com/tencent/wcdb/database/SQLiteDatabase:acquireReference	()V
    //   4: new 776	com/tencent/wcdb/database/SQLiteDirectCursorDriver
    //   7: dup
    //   8: aload_0
    //   9: aload_2
    //   10: aload 4
    //   12: aload 5
    //   14: invokespecial 779	com/tencent/wcdb/database/SQLiteDirectCursorDriver:<init>	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   17: astore_2
    //   18: aload_1
    //   19: ifnull +18 -> 37
    //   22: aload_2
    //   23: aload_1
    //   24: aload_3
    //   25: invokeinterface 784 3 0
    //   30: astore_1
    //   31: aload_0
    //   32: invokevirtual 159	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   35: aload_1
    //   36: areturn
    //   37: aload_0
    //   38: getfield 124	com/tencent/wcdb/database/SQLiteDatabase:mCursorFactory	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   41: astore_1
    //   42: goto -20 -> 22
    //   45: astore_1
    //   46: aload_0
    //   47: invokevirtual 159	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	SQLiteDatabase
    //   0	52	1	paramCursorFactory	CursorFactory
    //   0	52	2	paramString1	String
    //   0	52	3	paramArrayOfString	String[]
    //   0	52	4	paramString2	String
    //   0	52	5	paramCancellationSignal	CancellationSignal
    // Exception table:
    //   from	to	target	type
    //   4	18	45	finally
    //   22	31	45	finally
    //   37	42	45	finally
  }
  
  public final void releaseNativeConnection(long paramLong, Exception paramException)
  {
    getThreadSession().releaseConnectionForNativeHandle(paramException);
  }
  
  public final void reopenReadWrite()
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      if (!isReadOnlyLocked()) {
        return;
      }
      i = this.mConfigurationLocked.openFlags;
      this.mConfigurationLocked.openFlags = (this.mConfigurationLocked.openFlags & 0xFFFFFFFE | 0x0);
    }
  }
  
  public final long replace(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    try
    {
      long l = insertWithOnConflict(paramString1, paramString2, paramContentValues, 5);
      return l;
    }
    catch (SQLiteDatabaseCorruptException paramString1)
    {
      throw paramString1;
    }
    catch (SQLException paramString1)
    {
      Log.e("WCDB.SQLiteDatabase", "Error inserting " + paramContentValues, new Object[] { paramString1 });
    }
    return -1L;
  }
  
  public final long replaceOrThrow(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    return insertWithOnConflict(paramString1, paramString2, paramContentValues, 5);
  }
  
  public final void setAsyncCheckpointEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (SQLiteAsyncCheckpointer localSQLiteAsyncCheckpointer = new SQLiteAsyncCheckpointer();; localSQLiteAsyncCheckpointer = null)
    {
      setCheckpointCallback(localSQLiteAsyncCheckpointer);
      return;
    }
  }
  
  public final void setChangeListener(SQLiteChangeListener paramSQLiteChangeListener, boolean paramBoolean)
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      this.mConnectionPoolLocked.setChangeListener(paramSQLiteChangeListener, paramBoolean);
      return;
    }
  }
  
  public final void setCheckpointCallback(SQLiteCheckpointListener paramSQLiteCheckpointListener)
  {
    boolean bool2 = true;
    if (paramSQLiteCheckpointListener != null) {}
    for (boolean bool1 = true;; bool1 = false) {
      for (;;)
      {
        synchronized (this.mLock)
        {
          throwIfNotOpenLocked();
          if (this.mConfigurationLocked.customWALHookEnabled != bool1) {
            this.mConfigurationLocked.customWALHookEnabled = bool1;
          }
          SQLiteDatabaseConfiguration localSQLiteDatabaseConfiguration;
          try
          {
            this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
            this.mConnectionPoolLocked.setCheckpointListener(paramSQLiteCheckpointListener);
            return;
          }
          catch (RuntimeException paramSQLiteCheckpointListener)
          {
            localSQLiteDatabaseConfiguration = this.mConfigurationLocked;
            if (bool1) {
              break label90;
            }
          }
          bool1 = bool2;
          localSQLiteDatabaseConfiguration.customWALHookEnabled = bool1;
          throw paramSQLiteCheckpointListener;
        }
        label90:
        bool1 = false;
      }
    }
  }
  
  public final void setForeignKeyConstraintsEnabled(boolean paramBoolean)
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      if (this.mConfigurationLocked.foreignKeyConstraintsEnabled == paramBoolean) {
        return;
      }
      this.mConfigurationLocked.foreignKeyConstraintsEnabled = paramBoolean;
    }
    try
    {
      this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      localSQLiteDatabaseConfiguration = this.mConfigurationLocked;
      if (paramBoolean) {
        break label73;
      }
    }
    localObject2 = finally;
    throw localObject2;
    SQLiteDatabaseConfiguration localSQLiteDatabaseConfiguration;
    label73:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localSQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled = paramBoolean;
      throw localRuntimeException;
    }
  }
  
  public final void setLocale(Locale paramLocale)
  {
    if (paramLocale == null) {
      throw new IllegalArgumentException("locale must not be null.");
    }
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      Locale localLocale = this.mConfigurationLocked.locale;
      this.mConfigurationLocked.locale = paramLocale;
      try
      {
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
        return;
      }
      catch (RuntimeException paramLocale)
      {
        this.mConfigurationLocked.locale = localLocale;
        throw paramLocale;
      }
    }
  }
  
  @Deprecated
  public final void setLockingEnabled(boolean paramBoolean) {}
  
  public final void setMaxSqlCacheSize(int paramInt)
  {
    if ((paramInt > 100) || (paramInt < 0)) {
      throw new IllegalStateException("expected value between 0 and 100");
    }
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      int i = this.mConfigurationLocked.maxSqlCacheSize;
      this.mConfigurationLocked.maxSqlCacheSize = paramInt;
      try
      {
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        this.mConfigurationLocked.maxSqlCacheSize = i;
        throw localRuntimeException;
      }
    }
  }
  
  public final long setMaximumSize(long paramLong)
  {
    long l3 = getPageSize();
    long l2 = paramLong / l3;
    long l1 = l2;
    if (paramLong % l3 != 0L) {
      l1 = l2 + 1L;
    }
    return DatabaseUtils.longForQuery(this, "PRAGMA max_page_count = " + l1, null) * l3;
  }
  
  public final void setPageSize(long paramLong)
  {
    execSQL("PRAGMA page_size = " + paramLong);
  }
  
  public final void setSynchronousMode(int paramInt)
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      int i = this.mConfigurationLocked.synchronousMode;
      if (i != paramInt) {
        this.mConfigurationLocked.synchronousMode = paramInt;
      }
      try
      {
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        this.mConfigurationLocked.synchronousMode = i;
        throw localRuntimeException;
      }
    }
  }
  
  public final void setTraceCallback(SQLiteTrace paramSQLiteTrace)
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      this.mConnectionPoolLocked.setTraceCallback(paramSQLiteTrace);
      return;
    }
  }
  
  public final void setTransactionSuccessful()
  {
    acquireReference();
    try
    {
      getThreadSession().setTransactionSuccessful();
      return;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public final void setVersion(int paramInt)
  {
    execSQL("PRAGMA user_version = " + paramInt);
  }
  
  public final String toString()
  {
    return "SQLiteDatabase: " + getPath();
  }
  
  public final int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    return updateWithOnConflict(paramString1, paramContentValues, paramString2, paramArrayOfString, 0);
  }
  
  public final int updateWithOnConflict(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, int paramInt)
  {
    if ((paramContentValues == null) || (paramContentValues.size() == 0)) {
      throw new IllegalArgumentException("Empty values");
    }
    acquireReference();
    for (;;)
    {
      int i;
      Object[] arrayOfObject;
      int j;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder(120);
        localStringBuilder.append("UPDATE ");
        localStringBuilder.append(CONFLICT_VALUES[paramInt]);
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" SET ");
        paramInt = paramContentValues.size();
        if (paramArrayOfString == null)
        {
          i = paramInt;
          arrayOfObject = new Object[i];
          Iterator localIterator = keySet(paramContentValues).iterator();
          j = 0;
          if (!localIterator.hasNext()) {
            break label273;
          }
          String str = (String)localIterator.next();
          if (j > 0)
          {
            paramString1 = ",";
            localStringBuilder.append(paramString1);
            localStringBuilder.append(str);
            arrayOfObject[j] = paramContentValues.get(str);
            localStringBuilder.append("=?");
            j += 1;
            continue;
          }
        }
        else
        {
          i = paramArrayOfString.length + paramInt;
          continue;
          if (!TextUtils.isEmpty(paramString2))
          {
            localStringBuilder.append(" WHERE ");
            localStringBuilder.append(paramString2);
          }
          paramString1 = new SQLiteStatement(this, localStringBuilder.toString(), arrayOfObject);
          try
          {
            paramInt = paramString1.executeUpdateDelete();
            return paramInt;
          }
          finally {}
        }
        paramString1 = "";
      }
      finally
      {
        releaseReference();
      }
      continue;
      label273:
      if (paramArrayOfString != null)
      {
        j = paramInt;
        while (j < i)
        {
          arrayOfObject[j] = paramArrayOfString[(j - paramInt)];
          j += 1;
        }
      }
    }
  }
  
  public final Pair<Integer, Integer> walCheckpoint(String paramString, boolean paramBoolean)
  {
    acquireReference();
    if (paramBoolean) {}
    for (int i = 2;; i = 0) {
      try
      {
        paramString = getThreadSession().walCheckpoint(paramString, i);
        return paramString;
      }
      finally
      {
        releaseReference();
      }
    }
  }
  
  @Deprecated
  public final boolean yieldIfContended()
  {
    return yieldIfContendedHelper(false, -1L);
  }
  
  public final boolean yieldIfContendedSafely()
  {
    return yieldIfContendedHelper(true, -1L);
  }
  
  public final boolean yieldIfContendedSafely(long paramLong)
  {
    return yieldIfContendedHelper(true, paramLong);
  }
  
  public static abstract interface CursorFactory
  {
    public abstract Cursor newCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteProgram paramSQLiteProgram);
    
    public abstract SQLiteProgram newQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal);
  }
  
  public static abstract interface CustomFunction
  {
    public abstract void callback(String[] paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDatabase
 * JD-Core Version:    0.7.0.1
 */