package com.tencent.wcdb.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Printer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.DefaultDatabaseErrorHandler;
import com.tencent.wcdb.SQLException;
import com.tencent.wcdb.extension.SQLiteExtension;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

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
  private final Object mLock;
  private final ThreadLocal<SQLiteSession> mThreadSession;
  
  static
  {
    AppMethodBeat.i(3225);
    if (!SQLiteDatabase.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      SQLiteGlobal.initialize();
      sActiveDatabases = new WeakHashMap();
      CONFLICT_VALUES = new String[] { "", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE " };
      AppMethodBeat.o(3225);
      return;
    }
  }
  
  private SQLiteDatabase(String paramString, int paramInt, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    AppMethodBeat.i(3109);
    this.mThreadSession = new ThreadLocal()
    {
      protected SQLiteSession initialValue()
      {
        AppMethodBeat.i(3106);
        SQLiteSession localSQLiteSession = SQLiteDatabase.this.createSession();
        AppMethodBeat.o(3106);
        return localSQLiteSession;
      }
    };
    this.mLock = new Object();
    this.mCursorFactory = paramCursorFactory;
    if (paramDatabaseErrorHandler != null) {}
    for (;;)
    {
      this.mErrorHandler = paramDatabaseErrorHandler;
      this.mConfigurationLocked = new SQLiteDatabaseConfiguration(paramString, paramInt);
      AppMethodBeat.o(3109);
      return;
      paramDatabaseErrorHandler = new DefaultDatabaseErrorHandler(true);
    }
  }
  
  /* Error */
  private void beginTransaction(SQLiteTransactionListener paramSQLiteTransactionListener, boolean paramBoolean)
  {
    // Byte code:
    //   0: sipush 3123
    //   3: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 149	com/tencent/wcdb/database/SQLiteDatabase:acquireReference	()V
    //   10: aload_0
    //   11: invokevirtual 153	com/tencent/wcdb/database/SQLiteDatabase:getThreadSession	()Lcom/tencent/wcdb/database/SQLiteSession;
    //   14: astore 4
    //   16: iload_2
    //   17: ifeq +29 -> 46
    //   20: iconst_2
    //   21: istore_3
    //   22: aload 4
    //   24: iload_3
    //   25: aload_1
    //   26: aload_0
    //   27: iconst_0
    //   28: invokevirtual 157	com/tencent/wcdb/database/SQLiteDatabase:getThreadDefaultConnectionFlags	(Z)I
    //   31: aconst_null
    //   32: invokevirtual 162	com/tencent/wcdb/database/SQLiteSession:beginTransaction	(ILandroid/database/sqlite/SQLiteTransactionListener;ILcom/tencent/wcdb/support/CancellationSignal;)V
    //   35: aload_0
    //   36: invokevirtual 165	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   39: sipush 3123
    //   42: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: return
    //   46: iconst_1
    //   47: istore_3
    //   48: goto -26 -> 22
    //   51: astore_1
    //   52: aload_0
    //   53: invokevirtual 165	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   56: sipush 3123
    //   59: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	SQLiteDatabase
    //   0	64	1	paramSQLiteTransactionListener	SQLiteTransactionListener
    //   0	64	2	paramBoolean	boolean
    //   21	27	3	i	int
    //   14	9	4	localSQLiteSession	SQLiteSession
    // Exception table:
    //   from	to	target	type
    //   10	16	51	finally
    //   22	35	51	finally
  }
  
  private void collectDbStats(ArrayList<SQLiteDebug.DbStats> paramArrayList)
  {
    AppMethodBeat.i(3213);
    synchronized (this.mLock)
    {
      if (this.mConnectionPoolLocked != null) {
        this.mConnectionPoolLocked.collectDbStats(paramArrayList);
      }
      AppMethodBeat.o(3213);
      return;
    }
  }
  
  public static SQLiteDatabase create(CursorFactory paramCursorFactory)
  {
    AppMethodBeat.i(3159);
    paramCursorFactory = openDatabase(":memory:", paramCursorFactory, 268435456);
    AppMethodBeat.o(3159);
    return paramCursorFactory;
  }
  
  public static boolean deleteDatabase(File paramFile)
  {
    AppMethodBeat.i(3155);
    if (paramFile == null)
    {
      paramFile = new IllegalArgumentException("file must not be null");
      AppMethodBeat.o(3155);
      throw paramFile;
    }
    boolean bool1 = paramFile.delete() | new File(paramFile.getPath() + "-journal").delete() | new File(paramFile.getPath() + "-shm").delete() | new File(paramFile.getPath() + "-wal").delete();
    File localFile = paramFile.getParentFile();
    boolean bool2 = bool1;
    if (localFile != null)
    {
      paramFile = localFile.listFiles(new SQLiteDatabase.2(paramFile.getName() + "-mj"));
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
    AppMethodBeat.o(3155);
    return bool2;
  }
  
  private void dispose(boolean paramBoolean)
  {
    AppMethodBeat.i(3112);
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
      AppMethodBeat.o(3112);
      return;
      localObject2 = finally;
      AppMethodBeat.o(3112);
      throw localObject2;
    }
  }
  
  public static void dumpAll(Printer paramPrinter, boolean paramBoolean)
  {
    AppMethodBeat.i(3215);
    Iterator localIterator = getActiveDatabases().iterator();
    while (localIterator.hasNext()) {
      ((SQLiteDatabase)localIterator.next()).dump(paramPrinter, paramBoolean);
    }
    AppMethodBeat.o(3215);
  }
  
  public static JSONArray dumpAllJSON(boolean paramBoolean)
  {
    AppMethodBeat.i(3216);
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = getActiveDatabases().iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(((SQLiteDatabase)localIterator.next()).dumpJSON(paramBoolean));
    }
    AppMethodBeat.o(3216);
    return localJSONArray;
  }
  
  private int executeSql(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    int i = 1;
    AppMethodBeat.i(3191);
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
        AppMethodBeat.o(3191);
      }
    }
  }
  
  public static String findEditTable(String paramString)
  {
    AppMethodBeat.i(3167);
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.indexOf(' ');
      int j = paramString.indexOf(',');
      if ((i > 0) && ((i < j) || (j < 0)))
      {
        paramString = paramString.substring(0, i);
        AppMethodBeat.o(3167);
        return paramString;
      }
      if ((j > 0) && ((j < i) || (i < 0)))
      {
        paramString = paramString.substring(0, j);
        AppMethodBeat.o(3167);
        return paramString;
      }
      AppMethodBeat.o(3167);
      return paramString;
    }
    paramString = new IllegalStateException("Invalid tables");
    AppMethodBeat.o(3167);
    throw paramString;
  }
  
  private static ArrayList<SQLiteDatabase> getActiveDatabases()
  {
    AppMethodBeat.i(3214);
    ArrayList localArrayList = new ArrayList();
    synchronized (sActiveDatabases)
    {
      localArrayList.addAll(sActiveDatabases.keySet());
      AppMethodBeat.o(3214);
      return localArrayList;
    }
  }
  
  static ArrayList<SQLiteDebug.DbStats> getDbStats()
  {
    AppMethodBeat.i(3212);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getActiveDatabases().iterator();
    while (localIterator.hasNext()) {
      ((SQLiteDatabase)localIterator.next()).collectDbStats(localArrayList);
    }
    AppMethodBeat.o(3212);
    return localArrayList;
  }
  
  private static boolean isMainThread()
  {
    AppMethodBeat.i(3118);
    Looper localLooper = Looper.myLooper();
    if ((localLooper != null) && (localLooper == Looper.getMainLooper()))
    {
      AppMethodBeat.o(3118);
      return true;
    }
    AppMethodBeat.o(3118);
    return false;
  }
  
  private boolean isReadOnlyLocked()
  {
    return (this.mConfigurationLocked.openFlags & 0x1) == 1;
  }
  
  private Set<String> keySet(ContentValues paramContentValues)
  {
    AppMethodBeat.i(3183);
    if (Build.VERSION.SDK_INT < 11) {
      try
      {
        Field localField = Class.forName("android.content.ContentValues").getDeclaredField("mValues");
        localField.setAccessible(true);
        paramContentValues = ((HashMap)localField.get(paramContentValues)).keySet();
        AppMethodBeat.o(3183);
        return paramContentValues;
      }
      catch (Exception paramContentValues)
      {
        paramContentValues = new RuntimeException(paramContentValues);
        AppMethodBeat.o(3183);
        throw paramContentValues;
      }
    }
    paramContentValues = paramContentValues.keySet();
    AppMethodBeat.o(3183);
    return paramContentValues;
  }
  
  private void open(byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, int paramInt)
  {
    AppMethodBeat.i(3157);
    try
    {
      openInner(paramArrayOfByte, paramSQLiteCipherSpec, paramInt);
      AppMethodBeat.o(3157);
      return;
    }
    catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
    {
      onCorruption();
      openInner(paramArrayOfByte, paramSQLiteCipherSpec, paramInt);
      AppMethodBeat.o(3157);
      return;
    }
    catch (SQLiteException paramArrayOfByte)
    {
      Log.e("WCDB.SQLiteDatabase", "Failed to open database '" + getLabel() + "'.", new Object[] { paramArrayOfByte });
      close();
      AppMethodBeat.o(3157);
      throw paramArrayOfByte;
    }
  }
  
  public static SQLiteDatabase openDatabase(String paramString, CursorFactory paramCursorFactory, int paramInt)
  {
    AppMethodBeat.i(3133);
    paramString = openDatabase(paramString, paramCursorFactory, paramInt, null);
    AppMethodBeat.o(3133);
    return paramString;
  }
  
  public static SQLiteDatabase openDatabase(String paramString, CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    AppMethodBeat.i(3136);
    paramString = openDatabase(paramString, null, null, paramCursorFactory, paramInt, paramDatabaseErrorHandler, 0);
    AppMethodBeat.o(3136);
    return paramString;
  }
  
  public static SQLiteDatabase openDatabase(String paramString, CursorFactory paramCursorFactory, int paramInt1, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt2)
  {
    AppMethodBeat.i(3137);
    paramString = openDatabase(paramString, null, null, paramCursorFactory, paramInt1, paramDatabaseErrorHandler, paramInt2);
    AppMethodBeat.o(3137);
    return paramString;
  }
  
  public static SQLiteDatabase openDatabase(String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    AppMethodBeat.i(3135);
    paramString = openDatabase(paramString, paramArrayOfByte, paramSQLiteCipherSpec, paramCursorFactory, paramInt, paramDatabaseErrorHandler, 0);
    AppMethodBeat.o(3135);
    return paramString;
  }
  
  public static SQLiteDatabase openDatabase(String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, CursorFactory paramCursorFactory, int paramInt1, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt2)
  {
    AppMethodBeat.i(3134);
    paramString = new SQLiteDatabase(paramString, paramInt1, paramCursorFactory, paramDatabaseErrorHandler);
    paramString.open(paramArrayOfByte, paramSQLiteCipherSpec, paramInt2);
    AppMethodBeat.o(3134);
    return paramString;
  }
  
  private void openInner(byte[] arg1, SQLiteCipherSpec paramSQLiteCipherSpec, int paramInt)
  {
    AppMethodBeat.i(3158);
    synchronized (this.mLock)
    {
      if ((!$assertionsDisabled) && (this.mConnectionPoolLocked != null))
      {
        ??? = new AssertionError();
        AppMethodBeat.o(3158);
        throw ???;
      }
    }
    this.mConnectionPoolLocked = SQLiteConnectionPool.open(this, this.mConfigurationLocked, ???, paramSQLiteCipherSpec, paramInt);
    synchronized (sActiveDatabases)
    {
      sActiveDatabases.put(this, null);
      AppMethodBeat.o(3158);
      return;
    }
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, CursorFactory paramCursorFactory)
  {
    AppMethodBeat.i(3138);
    paramFile = openOrCreateDatabase(paramFile.getPath(), paramCursorFactory);
    AppMethodBeat.o(3138);
    return paramFile;
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    AppMethodBeat.i(3139);
    paramFile = openOrCreateDatabase(paramFile.getPath(), paramArrayOfByte, paramSQLiteCipherSpec, paramCursorFactory, paramDatabaseErrorHandler, 0);
    AppMethodBeat.o(3139);
    return paramFile;
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt)
  {
    AppMethodBeat.i(3140);
    paramFile = openOrCreateDatabase(paramFile.getPath(), paramArrayOfByte, paramSQLiteCipherSpec, paramCursorFactory, paramDatabaseErrorHandler, paramInt);
    AppMethodBeat.o(3140);
    return paramFile;
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, byte[] paramArrayOfByte, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    AppMethodBeat.i(3141);
    paramFile = openOrCreateDatabase(paramFile.getPath(), paramArrayOfByte, null, paramCursorFactory, paramDatabaseErrorHandler, 0);
    AppMethodBeat.o(3141);
    return paramFile;
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, byte[] paramArrayOfByte, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt)
  {
    AppMethodBeat.i(3142);
    paramFile = openOrCreateDatabase(paramFile.getPath(), paramArrayOfByte, null, paramCursorFactory, paramDatabaseErrorHandler, paramInt);
    AppMethodBeat.o(3142);
    return paramFile;
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, CursorFactory paramCursorFactory)
  {
    AppMethodBeat.i(3146);
    paramString = openDatabase(paramString, null, null, paramCursorFactory, 268435456, null, 0);
    AppMethodBeat.o(3146);
    return paramString;
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, CursorFactory paramCursorFactory, int paramInt)
  {
    AppMethodBeat.i(3143);
    paramString = openDatabase(paramString, null, null, paramCursorFactory, 268435456, null, paramInt);
    AppMethodBeat.o(3143);
    return paramString;
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    AppMethodBeat.i(3154);
    paramString = openDatabase(paramString, paramCursorFactory, 268435456, paramDatabaseErrorHandler);
    AppMethodBeat.o(3154);
    return paramString;
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, CursorFactory paramCursorFactory, boolean paramBoolean)
  {
    AppMethodBeat.i(3147);
    int i = 268435456;
    if (paramBoolean) {
      i = 805306368;
    }
    paramString = openDatabase(paramString, null, null, paramCursorFactory, i, null, 0);
    AppMethodBeat.o(3147);
    return paramString;
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt)
  {
    AppMethodBeat.i(3148);
    paramString = openDatabase(paramString, paramArrayOfByte, paramSQLiteCipherSpec, paramCursorFactory, 268435456, paramDatabaseErrorHandler, paramInt);
    AppMethodBeat.o(3148);
    return paramString;
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, byte[] paramArrayOfByte, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    AppMethodBeat.i(3153);
    paramString = openOrCreateDatabase(paramString, paramArrayOfByte, null, paramCursorFactory, paramDatabaseErrorHandler, 0);
    AppMethodBeat.o(3153);
    return paramString;
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, byte[] paramArrayOfByte, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt)
  {
    AppMethodBeat.i(3152);
    paramString = openOrCreateDatabase(paramString, paramArrayOfByte, null, paramCursorFactory, paramDatabaseErrorHandler, paramInt);
    AppMethodBeat.o(3152);
    return paramString;
  }
  
  public static SQLiteDatabase openOrCreateDatabaseInWalMode(String paramString, CursorFactory paramCursorFactory)
  {
    AppMethodBeat.i(3144);
    paramString = openDatabase(paramString, null, null, paramCursorFactory, 805306368, null, 0);
    AppMethodBeat.o(3144);
    return paramString;
  }
  
  public static SQLiteDatabase openOrCreateDatabaseInWalMode(String paramString, CursorFactory paramCursorFactory, int paramInt)
  {
    AppMethodBeat.i(3145);
    paramString = openDatabase(paramString, null, null, paramCursorFactory, 805306368, null, paramInt);
    AppMethodBeat.o(3145);
    return paramString;
  }
  
  public static SQLiteDatabase openOrCreateDatabaseInWalMode(String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, CursorFactory paramCursorFactory)
  {
    AppMethodBeat.i(3150);
    paramString = openDatabase(paramString, paramArrayOfByte, paramSQLiteCipherSpec, paramCursorFactory, 805306368, null, 0);
    AppMethodBeat.o(3150);
    return paramString;
  }
  
  public static SQLiteDatabase openOrCreateDatabaseInWalMode(String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt)
  {
    AppMethodBeat.i(3149);
    paramString = openDatabase(paramString, paramArrayOfByte, paramSQLiteCipherSpec, paramCursorFactory, 805306368, paramDatabaseErrorHandler, paramInt);
    AppMethodBeat.o(3149);
    return paramString;
  }
  
  public static SQLiteDatabase openOrCreateMemoryDatabaseInWalMode(CursorFactory paramCursorFactory)
  {
    AppMethodBeat.i(3151);
    paramCursorFactory = openDatabase(":memory:", null, null, paramCursorFactory, 805306368, null, 0);
    AppMethodBeat.o(3151);
    return paramCursorFactory;
  }
  
  public static int releaseMemory()
  {
    AppMethodBeat.i(3113);
    int i = SQLiteGlobal.releaseMemory();
    AppMethodBeat.o(3113);
    return i;
  }
  
  private void throwIfNotOpenLocked()
  {
    AppMethodBeat.i(3224);
    if (this.mConnectionPoolLocked == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("The database '" + this.mConfigurationLocked.label + "' is not open.");
      AppMethodBeat.o(3224);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(3224);
  }
  
  private boolean yieldIfContendedHelper(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(3131);
    acquireReference();
    try
    {
      paramBoolean = getThreadSession().yieldTransaction(paramLong, paramBoolean, null);
      return paramBoolean;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(3131);
    }
  }
  
  public final long acquireNativeConnectionHandle(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(3221);
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
      paramString = new IllegalStateException("SQLiteConnection native handle not initialized.");
      AppMethodBeat.o(3221);
      throw paramString;
    }
    AppMethodBeat.o(3221);
    return l;
  }
  
  public final void addExtension(SQLiteExtension paramSQLiteExtension)
  {
    AppMethodBeat.i(3160);
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      boolean bool = this.mConfigurationLocked.extensions.add(paramSQLiteExtension);
      if (bool) {}
      try
      {
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
        AppMethodBeat.o(3160);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        this.mConfigurationLocked.extensions.remove(paramSQLiteExtension);
        AppMethodBeat.o(3160);
        throw localRuntimeException;
      }
    }
  }
  
  public final void beginTransaction()
  {
    AppMethodBeat.i(3119);
    beginTransaction(null, true);
    AppMethodBeat.o(3119);
  }
  
  public final void beginTransactionNonExclusive()
  {
    AppMethodBeat.i(3120);
    beginTransaction(null, false);
    AppMethodBeat.o(3120);
  }
  
  public final void beginTransactionWithListener(SQLiteTransactionListener paramSQLiteTransactionListener)
  {
    AppMethodBeat.i(3121);
    beginTransaction(paramSQLiteTransactionListener, true);
    AppMethodBeat.o(3121);
  }
  
  public final void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener paramSQLiteTransactionListener)
  {
    AppMethodBeat.i(3122);
    beginTransaction(paramSQLiteTransactionListener, false);
    AppMethodBeat.o(3122);
  }
  
  public final SQLiteStatement compileStatement(String paramString)
  {
    AppMethodBeat.i(3168);
    acquireReference();
    try
    {
      paramString = new SQLiteStatement(this, paramString, null);
      return paramString;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(3168);
    }
  }
  
  final SQLiteSession createSession()
  {
    AppMethodBeat.i(3116);
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      SQLiteConnectionPool localSQLiteConnectionPool = this.mConnectionPoolLocked;
      ??? = new SQLiteSession(localSQLiteConnectionPool);
      AppMethodBeat.o(3116);
      return ???;
    }
  }
  
  /* Error */
  public final int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: sipush 3185
    //   3: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 149	com/tencent/wcdb/database/SQLiteDatabase:acquireReference	()V
    //   10: new 199	java/lang/StringBuilder
    //   13: dup
    //   14: ldc_w 527
    //   17: invokespecial 405	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: aload_1
    //   21: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: astore 5
    //   26: aload_2
    //   27: invokestatic 310	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   30: ifne +56 -> 86
    //   33: ldc_w 529
    //   36: aload_2
    //   37: invokestatic 533	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   40: invokevirtual 536	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore_1
    //   44: new 294	com/tencent/wcdb/database/SQLiteStatement
    //   47: dup
    //   48: aload_0
    //   49: aload 5
    //   51: aload_1
    //   52: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: aload_3
    //   59: invokespecial 297	com/tencent/wcdb/database/SQLiteStatement:<init>	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: astore_1
    //   63: aload_1
    //   64: invokevirtual 538	com/tencent/wcdb/database/SQLiteStatement:executeUpdateDelete	()I
    //   67: istore 4
    //   69: aload_1
    //   70: invokevirtual 302	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   73: aload_0
    //   74: invokevirtual 165	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   77: sipush 3185
    //   80: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: iload 4
    //   85: ireturn
    //   86: ldc 100
    //   88: astore_1
    //   89: goto -45 -> 44
    //   92: astore_2
    //   93: aload_1
    //   94: invokevirtual 302	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   97: sipush 3185
    //   100: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_2
    //   104: athrow
    //   105: astore_1
    //   106: aload_0
    //   107: invokevirtual 165	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   110: sipush 3185
    //   113: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: aload_1
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	SQLiteDatabase
    //   0	118	1	paramString1	String
    //   0	118	2	paramString2	String
    //   0	118	3	paramArrayOfString	String[]
    //   67	17	4	i	int
    //   24	26	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   63	69	92	finally
    //   10	44	105	finally
    //   44	63	105	finally
    //   69	73	105	finally
    //   93	105	105	finally
  }
  
  public final void disableWriteAheadLogging()
  {
    AppMethodBeat.i(3204);
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      if ((this.mConfigurationLocked.openFlags & 0x20000000) == 0)
      {
        AppMethodBeat.o(3204);
        return;
      }
      SQLiteDatabaseConfiguration localSQLiteDatabaseConfiguration1 = this.mConfigurationLocked;
      localSQLiteDatabaseConfiguration1.openFlags &= 0xDFFFFFFF;
      try
      {
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
        AppMethodBeat.o(3204);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        SQLiteDatabaseConfiguration localSQLiteDatabaseConfiguration2 = this.mConfigurationLocked;
        localSQLiteDatabaseConfiguration2.openFlags |= 0x20000000;
        AppMethodBeat.o(3204);
        throw localRuntimeException;
      }
    }
  }
  
  public final void dump(Printer paramPrinter, boolean paramBoolean)
  {
    AppMethodBeat.i(3217);
    synchronized (this.mLock)
    {
      if (this.mConnectionPoolLocked != null) {
        this.mConnectionPoolLocked.dump(paramPrinter, paramBoolean);
      }
      AppMethodBeat.o(3217);
      return;
    }
  }
  
  public final JSONObject dumpJSON(boolean paramBoolean)
  {
    AppMethodBeat.i(3218);
    synchronized (this.mLock)
    {
      if (this.mConnectionPoolLocked != null)
      {
        localJSONObject = this.mConnectionPoolLocked.dumpJSON(paramBoolean);
        AppMethodBeat.o(3218);
        return localJSONObject;
      }
      JSONObject localJSONObject = new JSONObject();
      AppMethodBeat.o(3218);
      return localJSONObject;
    }
  }
  
  public final boolean enableWriteAheadLogging()
  {
    AppMethodBeat.i(3203);
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      if ((this.mConfigurationLocked.openFlags & 0x20000000) != 0)
      {
        AppMethodBeat.o(3203);
        return true;
      }
      if (isReadOnlyLocked())
      {
        AppMethodBeat.o(3203);
        return false;
      }
      if (this.mConfigurationLocked.isInMemoryDb())
      {
        Log.i("WCDB.SQLiteDatabase", "can't enable WAL for memory databases.");
        AppMethodBeat.o(3203);
        return false;
      }
      if (this.mHasAttachedDbsLocked)
      {
        Log.i("WCDB.SQLiteDatabase", "this database: " + this.mConfigurationLocked.label + " has attached databases. can't  enable WAL.");
        AppMethodBeat.o(3203);
        return false;
      }
      SQLiteDatabaseConfiguration localSQLiteDatabaseConfiguration1 = this.mConfigurationLocked;
      localSQLiteDatabaseConfiguration1.openFlags |= 0x20000000;
      try
      {
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
        AppMethodBeat.o(3203);
        return true;
      }
      catch (RuntimeException localRuntimeException)
      {
        SQLiteDatabaseConfiguration localSQLiteDatabaseConfiguration2 = this.mConfigurationLocked;
        localSQLiteDatabaseConfiguration2.openFlags &= 0xDFFFFFFF;
        AppMethodBeat.o(3203);
        throw localRuntimeException;
      }
    }
  }
  
  public final void endTransaction()
  {
    AppMethodBeat.i(3124);
    acquireReference();
    try
    {
      getThreadSession().endTransaction(null);
      return;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(3124);
    }
  }
  
  public final void execSQL(String paramString)
  {
    AppMethodBeat.i(3188);
    executeSql(paramString, null, null);
    AppMethodBeat.o(3188);
  }
  
  public final void execSQL(String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(3189);
    executeSql(paramString, paramArrayOfObject, null);
    AppMethodBeat.o(3189);
  }
  
  public final void execSQL(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3190);
    executeSql(paramString, paramArrayOfObject, paramCancellationSignal);
    AppMethodBeat.o(3190);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(3110);
    try
    {
      dispose(true);
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(3110);
    }
  }
  
  public final boolean getAsyncCheckpointEnabled()
  {
    AppMethodBeat.i(3201);
    SQLiteCheckpointListener localSQLiteCheckpointListener = getCheckpointCallback();
    if ((localSQLiteCheckpointListener != null) && ((localSQLiteCheckpointListener instanceof SQLiteAsyncCheckpointer)))
    {
      AppMethodBeat.o(3201);
      return true;
    }
    AppMethodBeat.o(3201);
    return false;
  }
  
  /* Error */
  public final java.util.List<Pair<String, String>> getAttachedDbs()
  {
    // Byte code:
    //   0: sipush 3219
    //   3: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 250	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 324	java/util/ArrayList:<init>	()V
    //   13: astore_2
    //   14: aload_0
    //   15: getfield 128	com/tencent/wcdb/database/SQLiteDatabase:mLock	Ljava/lang/Object;
    //   18: astore_1
    //   19: aload_1
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 169	com/tencent/wcdb/database/SQLiteDatabase:mConnectionPoolLocked	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   25: ifnonnull +13 -> 38
    //   28: aload_1
    //   29: monitorexit
    //   30: sipush 3219
    //   33: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aconst_null
    //   37: areturn
    //   38: aload_0
    //   39: getfield 289	com/tencent/wcdb/database/SQLiteDatabase:mHasAttachedDbsLocked	Z
    //   42: ifne +35 -> 77
    //   45: aload_2
    //   46: new 584	android/util/Pair
    //   49: dup
    //   50: ldc_w 586
    //   53: aload_0
    //   54: getfield 139	com/tencent/wcdb/database/SQLiteDatabase:mConfigurationLocked	Lcom/tencent/wcdb/database/SQLiteDatabaseConfiguration;
    //   57: getfield 589	com/tencent/wcdb/database/SQLiteDatabaseConfiguration:path	Ljava/lang/String;
    //   60: invokespecial 592	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   63: invokevirtual 593	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   66: pop
    //   67: aload_1
    //   68: monitorexit
    //   69: sipush 3219
    //   72: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_2
    //   76: areturn
    //   77: aload_0
    //   78: invokevirtual 149	com/tencent/wcdb/database/SQLiteDatabase:acquireReference	()V
    //   81: aload_1
    //   82: monitorexit
    //   83: aload_0
    //   84: ldc_w 595
    //   87: aconst_null
    //   88: invokevirtual 599	com/tencent/wcdb/database/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/Cursor;
    //   91: astore_1
    //   92: aload_1
    //   93: invokeinterface 604 1 0
    //   98: ifeq +75 -> 173
    //   101: aload_2
    //   102: new 584	android/util/Pair
    //   105: dup
    //   106: aload_1
    //   107: iconst_1
    //   108: invokeinterface 608 2 0
    //   113: aload_1
    //   114: iconst_2
    //   115: invokeinterface 608 2 0
    //   120: invokespecial 592	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   123: invokevirtual 593	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   126: pop
    //   127: goto -35 -> 92
    //   130: astore_2
    //   131: aload_1
    //   132: ifnull +9 -> 141
    //   135: aload_1
    //   136: invokeinterface 609 1 0
    //   141: sipush 3219
    //   144: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: aload_2
    //   148: athrow
    //   149: astore_1
    //   150: aload_0
    //   151: invokevirtual 165	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   154: sipush 3219
    //   157: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_1
    //   161: athrow
    //   162: astore_2
    //   163: aload_1
    //   164: monitorexit
    //   165: sipush 3219
    //   168: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload_2
    //   172: athrow
    //   173: aload_1
    //   174: ifnull +9 -> 183
    //   177: aload_1
    //   178: invokeinterface 609 1 0
    //   183: aload_0
    //   184: invokevirtual 165	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   187: sipush 3219
    //   190: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: aload_2
    //   194: areturn
    //   195: astore_2
    //   196: aconst_null
    //   197: astore_1
    //   198: goto -67 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	SQLiteDatabase
    //   18	118	1	localObject1	Object
    //   149	29	1	localObject2	Object
    //   197	1	1	localObject3	Object
    //   13	89	2	localArrayList	ArrayList
    //   130	18	2	localObject4	Object
    //   162	32	2	localList	java.util.List<Pair<String, String>>
    //   195	1	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   92	127	130	finally
    //   135	141	149	finally
    //   141	149	149	finally
    //   177	183	149	finally
    //   21	30	162	finally
    //   38	69	162	finally
    //   77	83	162	finally
    //   83	92	195	finally
  }
  
  public final SQLiteChangeListener getChangeListener()
  {
    AppMethodBeat.i(3208);
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      SQLiteChangeListener localSQLiteChangeListener = this.mConnectionPoolLocked.getChangeListener();
      AppMethodBeat.o(3208);
      return localSQLiteChangeListener;
    }
  }
  
  public final SQLiteCheckpointListener getCheckpointCallback()
  {
    AppMethodBeat.i(3199);
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      if (!this.mConfigurationLocked.customWALHookEnabled)
      {
        AppMethodBeat.o(3199);
        return null;
      }
      SQLiteCheckpointListener localSQLiteCheckpointListener = this.mConnectionPoolLocked.getCheckpointListener();
      AppMethodBeat.o(3199);
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
    AppMethodBeat.i(3163);
    long l1 = DatabaseUtils.longForQuery(this, "PRAGMA max_page_count;", null);
    long l2 = getPageSize();
    AppMethodBeat.o(3163);
    return l1 * l2;
  }
  
  public final long getPageSize()
  {
    AppMethodBeat.i(3165);
    long l = DatabaseUtils.longForQuery(this, "PRAGMA page_size;", null);
    AppMethodBeat.o(3165);
    return l;
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
    AppMethodBeat.i(3132);
    HashMap localHashMap = new HashMap(0);
    AppMethodBeat.o(3132);
    return localHashMap;
  }
  
  public final int getSynchronousMode()
  {
    AppMethodBeat.i(3206);
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      int i = this.mConfigurationLocked.synchronousMode;
      AppMethodBeat.o(3206);
      return i;
    }
  }
  
  final int getThreadDefaultConnectionFlags(boolean paramBoolean)
  {
    AppMethodBeat.i(3117);
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      int j = i;
      if (isMainThread()) {
        j = i | 0x4;
      }
      AppMethodBeat.o(3117);
      return j;
    }
  }
  
  final SQLiteSession getThreadSession()
  {
    AppMethodBeat.i(3115);
    SQLiteSession localSQLiteSession = (SQLiteSession)this.mThreadSession.get();
    AppMethodBeat.o(3115);
    return localSQLiteSession;
  }
  
  public final SQLiteTrace getTraceCallback()
  {
    AppMethodBeat.i(3210);
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      SQLiteTrace localSQLiteTrace = this.mConnectionPoolLocked.getTraceCallback();
      AppMethodBeat.o(3210);
      return localSQLiteTrace;
    }
  }
  
  public final int getVersion()
  {
    AppMethodBeat.i(3161);
    int i = Long.valueOf(DatabaseUtils.longForQuery(this, "PRAGMA user_version;", null)).intValue();
    AppMethodBeat.o(3161);
    return i;
  }
  
  public final boolean inTransaction()
  {
    AppMethodBeat.i(3126);
    acquireReference();
    try
    {
      boolean bool = getThreadSession().hasTransaction();
      return bool;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(3126);
    }
  }
  
  public final long insert(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    AppMethodBeat.i(3179);
    try
    {
      long l = insertWithOnConflict(paramString1, paramString2, paramContentValues, 0);
      AppMethodBeat.o(3179);
      return l;
    }
    catch (SQLiteDatabaseCorruptException paramString1)
    {
      AppMethodBeat.o(3179);
      throw paramString1;
    }
    catch (SQLException paramString1)
    {
      Log.e("WCDB.SQLiteDatabase", "Error inserting %s: %s", new Object[] { paramContentValues, paramString1 });
      AppMethodBeat.o(3179);
    }
    return -1L;
  }
  
  public final long insertOrThrow(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    AppMethodBeat.i(3180);
    long l = insertWithOnConflict(paramString1, paramString2, paramContentValues, 0);
    AppMethodBeat.o(3180);
    return l;
  }
  
  public final long insertWithOnConflict(String paramString1, String paramString2, ContentValues paramContentValues, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(3184);
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
          break label318;
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
              break label324;
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
          break label330;
          localStringBuilder.append(paramString1);
          i += 1;
          break label330;
          localStringBuilder.append(')');
          paramString1 = new SQLiteStatement(this, localStringBuilder.toString(), paramString1);
        }
      }
      finally
      {
        StringBuilder localStringBuilder;
        long l;
        releaseReference();
        AppMethodBeat.o(3184);
      }
      try
      {
        l = paramString1.executeInsert();
        paramString1.close();
        releaseReference();
        AppMethodBeat.o(3184);
        return l;
      }
      finally
      {
        paramString1.close();
        AppMethodBeat.o(3184);
      }
      localStringBuilder.append(paramString2 + ") VALUES (NULL");
      continue;
      label318:
      paramInt = 0;
      continue;
      label324:
      paramString1 = "";
      continue;
      label330:
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
    //   0: sipush 3220
    //   3: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 149	com/tencent/wcdb/database/SQLiteDatabase:acquireReference	()V
    //   10: aload_0
    //   11: invokevirtual 716	com/tencent/wcdb/database/SQLiteDatabase:getAttachedDbs	()Ljava/util/List;
    //   14: astore_3
    //   15: aload_3
    //   16: ifnonnull +212 -> 228
    //   19: new 320	java/lang/IllegalStateException
    //   22: dup
    //   23: new 199	java/lang/StringBuilder
    //   26: dup
    //   27: ldc_w 718
    //   30: invokespecial 405	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: aload_0
    //   34: invokevirtual 719	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   37: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 721
    //   43: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 323	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   52: astore_2
    //   53: sipush 3220
    //   56: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_2
    //   60: athrow
    //   61: astore_2
    //   62: new 250	java/util/ArrayList
    //   65: dup
    //   66: invokespecial 324	java/util/ArrayList:<init>	()V
    //   69: astore_3
    //   70: aload_3
    //   71: new 584	android/util/Pair
    //   74: dup
    //   75: ldc_w 586
    //   78: aload_0
    //   79: invokevirtual 719	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   82: invokespecial 592	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   85: invokeinterface 724 2 0
    //   90: pop
    //   91: goto +196 -> 287
    //   94: iload_1
    //   95: aload_3
    //   96: invokeinterface 725 1 0
    //   101: if_icmpge +170 -> 271
    //   104: aload_3
    //   105: iload_1
    //   106: invokeinterface 728 2 0
    //   111: checkcast 584	android/util/Pair
    //   114: astore 4
    //   116: aload_0
    //   117: new 199	java/lang/StringBuilder
    //   120: dup
    //   121: ldc_w 730
    //   124: invokespecial 405	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   127: aload 4
    //   129: getfield 733	android/util/Pair:first	Ljava/lang/Object;
    //   132: checkcast 98	java/lang/String
    //   135: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc_w 735
    //   141: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokevirtual 737	com/tencent/wcdb/database/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteStatement;
    //   150: astore_2
    //   151: aload_2
    //   152: invokevirtual 740	com/tencent/wcdb/database/SQLiteStatement:simpleQueryForString	()Ljava/lang/String;
    //   155: astore 5
    //   157: aload 5
    //   159: ldc_w 742
    //   162: invokestatic 746	com/tencent/wcdb/DatabaseUtils:objectEquals	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   165: ifne +66 -> 231
    //   168: ldc 51
    //   170: new 199	java/lang/StringBuilder
    //   173: dup
    //   174: ldc_w 748
    //   177: invokespecial 405	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   180: aload 4
    //   182: getfield 751	android/util/Pair:second	Ljava/lang/Object;
    //   185: checkcast 98	java/lang/String
    //   188: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc_w 753
    //   194: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload 5
    //   199: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 755	com/tencent/wcdb/support/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: aload_2
    //   209: ifnull +7 -> 216
    //   212: aload_2
    //   213: invokevirtual 302	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   216: aload_0
    //   217: invokevirtual 165	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   220: sipush 3220
    //   223: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: iconst_0
    //   227: ireturn
    //   228: goto +59 -> 287
    //   231: aload_2
    //   232: ifnull +60 -> 292
    //   235: aload_2
    //   236: invokevirtual 302	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   239: goto +53 -> 292
    //   242: aload_2
    //   243: ifnull +7 -> 250
    //   246: aload_2
    //   247: invokevirtual 302	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   250: sipush 3220
    //   253: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: aload_3
    //   257: athrow
    //   258: astore_2
    //   259: aload_0
    //   260: invokevirtual 165	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   263: sipush 3220
    //   266: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: aload_2
    //   270: athrow
    //   271: aload_0
    //   272: invokevirtual 165	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   275: sipush 3220
    //   278: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   281: iconst_1
    //   282: ireturn
    //   283: astore_3
    //   284: goto -42 -> 242
    //   287: iconst_0
    //   288: istore_1
    //   289: goto -195 -> 94
    //   292: iload_1
    //   293: iconst_1
    //   294: iadd
    //   295: istore_1
    //   296: goto -202 -> 94
    //   299: astore_3
    //   300: aconst_null
    //   301: astore_2
    //   302: goto -60 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	this	SQLiteDatabase
    //   94	202	1	i	int
    //   52	8	2	localIllegalStateException	IllegalStateException
    //   61	1	2	localSQLiteException	SQLiteException
    //   150	97	2	localSQLiteStatement	SQLiteStatement
    //   258	12	2	localObject1	Object
    //   301	1	2	localObject2	Object
    //   14	243	3	localObject3	Object
    //   283	1	3	localObject4	Object
    //   299	1	3	localObject5	Object
    //   114	67	4	localPair	Pair
    //   155	43	5	str	String
    // Exception table:
    //   from	to	target	type
    //   10	15	61	com/tencent/wcdb/database/SQLiteException
    //   19	61	61	com/tencent/wcdb/database/SQLiteException
    //   10	15	258	finally
    //   19	61	258	finally
    //   62	91	258	finally
    //   94	116	258	finally
    //   212	216	258	finally
    //   235	239	258	finally
    //   246	250	258	finally
    //   250	258	258	finally
    //   151	208	283	finally
    //   116	151	299	finally
  }
  
  public final boolean isDbLockedByCurrentThread()
  {
    AppMethodBeat.i(3127);
    acquireReference();
    try
    {
      boolean bool = getThreadSession().hasConnection();
      return bool;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(3127);
    }
  }
  
  @Deprecated
  public final boolean isDbLockedByOtherThreads()
  {
    return false;
  }
  
  public final boolean isInMemoryDatabase()
  {
    AppMethodBeat.i(3194);
    synchronized (this.mLock)
    {
      boolean bool = this.mConfigurationLocked.isInMemoryDb();
      AppMethodBeat.o(3194);
      return bool;
    }
  }
  
  public final boolean isOpen()
  {
    synchronized (this.mLock)
    {
      if (this.mConnectionPoolLocked != null)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public final boolean isReadOnly()
  {
    AppMethodBeat.i(3193);
    synchronized (this.mLock)
    {
      boolean bool = isReadOnlyLocked();
      AppMethodBeat.o(3193);
      return bool;
    }
  }
  
  public final boolean isWriteAheadLoggingEnabled()
  {
    AppMethodBeat.i(3205);
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      if ((this.mConfigurationLocked.openFlags & 0x20000000) != 0)
      {
        bool = true;
        AppMethodBeat.o(3205);
        return bool;
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
    AppMethodBeat.i(3195);
    if (paramInt > getVersion())
    {
      AppMethodBeat.o(3195);
      return true;
    }
    AppMethodBeat.o(3195);
    return false;
  }
  
  protected final void onAllReferencesReleased()
  {
    AppMethodBeat.i(3111);
    dispose(false);
    AppMethodBeat.o(3111);
  }
  
  final void onCorruption()
  {
    AppMethodBeat.i(3114);
    this.mErrorHandler.onCorruption(this);
    AppMethodBeat.o(3114);
  }
  
  public final Cursor query(String paramString1, String[] paramArrayOfString, String paramString2, Object[] paramArrayOfObject, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(3173);
    paramString1 = query(false, paramString1, paramArrayOfString, paramString2, paramArrayOfObject, paramString3, paramString4, paramString5, null);
    AppMethodBeat.o(3173);
    return paramString1;
  }
  
  public final Cursor query(String paramString1, String[] paramArrayOfString, String paramString2, Object[] paramArrayOfObject, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(3174);
    paramString1 = query(false, paramString1, paramArrayOfString, paramString2, paramArrayOfObject, paramString3, paramString4, paramString5, paramString6);
    AppMethodBeat.o(3174);
    return paramString1;
  }
  
  public final Cursor query(boolean paramBoolean, String paramString1, String[] paramArrayOfString, String paramString2, Object[] paramArrayOfObject, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(3169);
    paramString1 = queryWithFactory(null, paramBoolean, paramString1, paramArrayOfString, paramString2, paramArrayOfObject, paramString3, paramString4, paramString5, paramString6, null);
    AppMethodBeat.o(3169);
    return paramString1;
  }
  
  public final Cursor query(boolean paramBoolean, String paramString1, String[] paramArrayOfString, String paramString2, Object[] paramArrayOfObject, String paramString3, String paramString4, String paramString5, String paramString6, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3170);
    paramString1 = queryWithFactory(null, paramBoolean, paramString1, paramArrayOfString, paramString2, paramArrayOfObject, paramString3, paramString4, paramString5, paramString6, paramCancellationSignal);
    AppMethodBeat.o(3170);
    return paramString1;
  }
  
  public final Cursor queryWithFactory(CursorFactory paramCursorFactory, boolean paramBoolean, String paramString1, String[] paramArrayOfString, String paramString2, Object[] paramArrayOfObject, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(3171);
    paramCursorFactory = queryWithFactory(paramCursorFactory, paramBoolean, paramString1, paramArrayOfString, paramString2, paramArrayOfObject, paramString3, paramString4, paramString5, paramString6, null);
    AppMethodBeat.o(3171);
    return paramCursorFactory;
  }
  
  public final Cursor queryWithFactory(CursorFactory paramCursorFactory, boolean paramBoolean, String paramString1, String[] paramArrayOfString, String paramString2, Object[] paramArrayOfObject, String paramString3, String paramString4, String paramString5, String paramString6, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3172);
    acquireReference();
    try
    {
      paramCursorFactory = rawQueryWithFactory(paramCursorFactory, SQLiteQueryBuilder.buildQueryString(paramBoolean, paramString1, paramArrayOfString, paramString2, paramString3, paramString4, paramString5, paramString6), paramArrayOfObject, findEditTable(paramString1), paramCancellationSignal);
      return paramCursorFactory;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(3172);
    }
  }
  
  public final Cursor rawQuery(String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(3175);
    paramString = rawQueryWithFactory(null, paramString, paramArrayOfObject, null, null);
    AppMethodBeat.o(3175);
    return paramString;
  }
  
  public final Cursor rawQuery(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3176);
    paramString = rawQueryWithFactory(null, paramString, paramArrayOfObject, null, paramCancellationSignal);
    AppMethodBeat.o(3176);
    return paramString;
  }
  
  public final Cursor rawQueryWithFactory(CursorFactory paramCursorFactory, String paramString1, Object[] paramArrayOfObject, String paramString2)
  {
    AppMethodBeat.i(3177);
    paramCursorFactory = rawQueryWithFactory(paramCursorFactory, paramString1, paramArrayOfObject, paramString2, null);
    AppMethodBeat.o(3177);
    return paramCursorFactory;
  }
  
  /* Error */
  public final Cursor rawQueryWithFactory(CursorFactory paramCursorFactory, String paramString1, Object[] paramArrayOfObject, String paramString2, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: sipush 3178
    //   3: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 149	com/tencent/wcdb/database/SQLiteDatabase:acquireReference	()V
    //   10: new 803	com/tencent/wcdb/database/SQLiteDirectCursorDriver
    //   13: dup
    //   14: aload_0
    //   15: aload_2
    //   16: aload 4
    //   18: aload 5
    //   20: invokespecial 806	com/tencent/wcdb/database/SQLiteDirectCursorDriver:<init>	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   23: astore_2
    //   24: aload_1
    //   25: ifnull +24 -> 49
    //   28: aload_2
    //   29: aload_1
    //   30: aload_3
    //   31: invokeinterface 811 3 0
    //   36: astore_1
    //   37: aload_0
    //   38: invokevirtual 165	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   41: sipush 3178
    //   44: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_1
    //   48: areturn
    //   49: aload_0
    //   50: getfield 130	com/tencent/wcdb/database/SQLiteDatabase:mCursorFactory	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   53: astore_1
    //   54: goto -26 -> 28
    //   57: astore_1
    //   58: aload_0
    //   59: invokevirtual 165	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   62: sipush 3178
    //   65: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	SQLiteDatabase
    //   0	70	1	paramCursorFactory	CursorFactory
    //   0	70	2	paramString1	String
    //   0	70	3	paramArrayOfObject	Object[]
    //   0	70	4	paramString2	String
    //   0	70	5	paramCancellationSignal	CancellationSignal
    // Exception table:
    //   from	to	target	type
    //   10	24	57	finally
    //   28	37	57	finally
    //   49	54	57	finally
  }
  
  public final void releaseNativeConnection(long paramLong, Exception paramException)
  {
    AppMethodBeat.i(3222);
    getThreadSession().releaseConnectionForNativeHandle(paramException);
    AppMethodBeat.o(3222);
  }
  
  public final void reopenReadWrite()
  {
    AppMethodBeat.i(3156);
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      if (!isReadOnlyLocked())
      {
        AppMethodBeat.o(3156);
        return;
      }
      int i = this.mConfigurationLocked.openFlags;
      this.mConfigurationLocked.openFlags = (this.mConfigurationLocked.openFlags & 0xFFFFFFFE | 0x0);
      try
      {
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
        AppMethodBeat.o(3156);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        this.mConfigurationLocked.openFlags = i;
        AppMethodBeat.o(3156);
        throw localRuntimeException;
      }
    }
  }
  
  public final long replace(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    AppMethodBeat.i(3181);
    try
    {
      long l = insertWithOnConflict(paramString1, paramString2, paramContentValues, 5);
      AppMethodBeat.o(3181);
      return l;
    }
    catch (SQLiteDatabaseCorruptException paramString1)
    {
      AppMethodBeat.o(3181);
      throw paramString1;
    }
    catch (SQLException paramString1)
    {
      Log.e("WCDB.SQLiteDatabase", "Error inserting ".concat(String.valueOf(paramContentValues)), new Object[] { paramString1 });
      AppMethodBeat.o(3181);
    }
    return -1L;
  }
  
  public final long replaceOrThrow(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    AppMethodBeat.i(3182);
    long l = insertWithOnConflict(paramString1, paramString2, paramContentValues, 5);
    AppMethodBeat.o(3182);
    return l;
  }
  
  public final void setAsyncCheckpointEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(3202);
    if (paramBoolean) {}
    for (SQLiteAsyncCheckpointer localSQLiteAsyncCheckpointer = new SQLiteAsyncCheckpointer();; localSQLiteAsyncCheckpointer = null)
    {
      setCheckpointCallback(localSQLiteAsyncCheckpointer);
      AppMethodBeat.o(3202);
      return;
    }
  }
  
  public final void setChangeListener(SQLiteChangeListener paramSQLiteChangeListener, boolean paramBoolean)
  {
    AppMethodBeat.i(3209);
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      this.mConnectionPoolLocked.setChangeListener(paramSQLiteChangeListener, paramBoolean);
      AppMethodBeat.o(3209);
      return;
    }
  }
  
  public final void setCheckpointCallback(SQLiteCheckpointListener paramSQLiteCheckpointListener)
  {
    boolean bool2 = true;
    AppMethodBeat.i(3200);
    if (paramSQLiteCheckpointListener != null) {}
    for (boolean bool1 = true;; bool1 = false) {
      synchronized (this.mLock)
      {
        for (;;)
        {
          throwIfNotOpenLocked();
          if (this.mConfigurationLocked.customWALHookEnabled != bool1) {
            this.mConfigurationLocked.customWALHookEnabled = bool1;
          }
          try
          {
            this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
            this.mConnectionPoolLocked.setCheckpointListener(paramSQLiteCheckpointListener);
            AppMethodBeat.o(3200);
            return;
          }
          catch (RuntimeException paramSQLiteCheckpointListener)
          {
            localSQLiteDatabaseConfiguration = this.mConfigurationLocked;
            if (bool1) {
              break;
            }
          }
          bool1 = false;
        }
        SQLiteDatabaseConfiguration localSQLiteDatabaseConfiguration;
        bool1 = bool2;
        localSQLiteDatabaseConfiguration.customWALHookEnabled = bool1;
        AppMethodBeat.o(3200);
        throw paramSQLiteCheckpointListener;
      }
    }
  }
  
  public final void setForeignKeyConstraintsEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(3198);
    for (;;)
    {
      synchronized (this.mLock)
      {
        throwIfNotOpenLocked();
        if (this.mConfigurationLocked.foreignKeyConstraintsEnabled == paramBoolean)
        {
          AppMethodBeat.o(3198);
          return;
        }
        this.mConfigurationLocked.foreignKeyConstraintsEnabled = paramBoolean;
        SQLiteDatabaseConfiguration localSQLiteDatabaseConfiguration;
        try
        {
          this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
          AppMethodBeat.o(3198);
          return;
        }
        catch (RuntimeException localRuntimeException)
        {
          localSQLiteDatabaseConfiguration = this.mConfigurationLocked;
          if (paramBoolean) {
            break label103;
          }
        }
        paramBoolean = true;
        localSQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled = paramBoolean;
        AppMethodBeat.o(3198);
        throw localRuntimeException;
      }
      label103:
      paramBoolean = false;
    }
  }
  
  public final void setLocale(Locale paramLocale)
  {
    AppMethodBeat.i(3196);
    if (paramLocale == null)
    {
      paramLocale = new IllegalArgumentException("locale must not be null.");
      AppMethodBeat.o(3196);
      throw paramLocale;
    }
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      Locale localLocale = this.mConfigurationLocked.locale;
      this.mConfigurationLocked.locale = paramLocale;
      try
      {
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
        AppMethodBeat.o(3196);
        return;
      }
      catch (RuntimeException paramLocale)
      {
        this.mConfigurationLocked.locale = localLocale;
        AppMethodBeat.o(3196);
        throw paramLocale;
      }
    }
  }
  
  @Deprecated
  public final void setLockingEnabled(boolean paramBoolean) {}
  
  public final void setMaxSqlCacheSize(int paramInt)
  {
    AppMethodBeat.i(3197);
    if ((paramInt > 100) || (paramInt < 0))
    {
      ??? = new IllegalStateException("expected value between 0 and 100");
      AppMethodBeat.o(3197);
      throw ((Throwable)???);
    }
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      int i = this.mConfigurationLocked.maxSqlCacheSize;
      this.mConfigurationLocked.maxSqlCacheSize = paramInt;
      try
      {
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
        AppMethodBeat.o(3197);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        this.mConfigurationLocked.maxSqlCacheSize = i;
        AppMethodBeat.o(3197);
        throw localRuntimeException;
      }
    }
  }
  
  public final long setMaximumSize(long paramLong)
  {
    AppMethodBeat.i(3164);
    long l3 = getPageSize();
    long l2 = paramLong / l3;
    long l1 = l2;
    if (paramLong % l3 != 0L) {
      l1 = l2 + 1L;
    }
    paramLong = DatabaseUtils.longForQuery(this, "PRAGMA max_page_count = ".concat(String.valueOf(l1)), null);
    AppMethodBeat.o(3164);
    return paramLong * l3;
  }
  
  public final void setPageSize(long paramLong)
  {
    AppMethodBeat.i(3166);
    execSQL("PRAGMA page_size = ".concat(String.valueOf(paramLong)));
    AppMethodBeat.o(3166);
  }
  
  public final void setSynchronousMode(int paramInt)
  {
    AppMethodBeat.i(3207);
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
        AppMethodBeat.o(3207);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        this.mConfigurationLocked.synchronousMode = i;
        AppMethodBeat.o(3207);
        throw localRuntimeException;
      }
    }
  }
  
  public final void setTraceCallback(SQLiteTrace paramSQLiteTrace)
  {
    AppMethodBeat.i(3211);
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      this.mConnectionPoolLocked.setTraceCallback(paramSQLiteTrace);
      AppMethodBeat.o(3211);
      return;
    }
  }
  
  public final void setTransactionSuccessful()
  {
    AppMethodBeat.i(3125);
    acquireReference();
    try
    {
      getThreadSession().setTransactionSuccessful();
      return;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(3125);
    }
  }
  
  public final void setVersion(int paramInt)
  {
    AppMethodBeat.i(3162);
    execSQL("PRAGMA user_version = ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(3162);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(3223);
    String str = "SQLiteDatabase: " + getPath();
    AppMethodBeat.o(3223);
    return str;
  }
  
  public final int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(3186);
    int i = updateWithOnConflict(paramString1, paramContentValues, paramString2, paramArrayOfString, 0);
    AppMethodBeat.o(3186);
    return i;
  }
  
  public final int updateWithOnConflict(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(3187);
    if ((paramContentValues == null) || (paramContentValues.size() == 0))
    {
      paramString1 = new IllegalArgumentException("Empty values");
      AppMethodBeat.o(3187);
      throw paramString1;
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
            break label305;
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
            paramString1.close();
            return paramInt;
          }
          finally {}
        }
        paramString1 = "";
      }
      finally
      {
        releaseReference();
        AppMethodBeat.o(3187);
      }
      continue;
      label305:
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
    AppMethodBeat.i(3192);
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
        AppMethodBeat.o(3192);
      }
    }
  }
  
  @Deprecated
  public final boolean yieldIfContended()
  {
    AppMethodBeat.i(3128);
    boolean bool = yieldIfContendedHelper(false, -1L);
    AppMethodBeat.o(3128);
    return bool;
  }
  
  public final boolean yieldIfContendedSafely()
  {
    AppMethodBeat.i(3129);
    boolean bool = yieldIfContendedHelper(true, -1L);
    AppMethodBeat.o(3129);
    return bool;
  }
  
  public final boolean yieldIfContendedSafely(long paramLong)
  {
    AppMethodBeat.i(3130);
    boolean bool = yieldIfContendedHelper(true, paramLong);
    AppMethodBeat.o(3130);
    return bool;
  }
  
  public static abstract interface CursorFactory
  {
    public abstract Cursor newCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteProgram paramSQLiteProgram);
    
    public abstract SQLiteProgram newQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDatabase
 * JD-Core Version:    0.7.0.1
 */