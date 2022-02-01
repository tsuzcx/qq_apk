package com.tencent.wcdb.database;

import android.content.Context;
import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.support.Log;

public abstract class SQLiteOpenHelper
{
  private static final boolean DEBUG_STRICT_READONLY = false;
  private static final String TAG = "WCDB.SQLiteOpenHelper";
  private SQLiteCipherSpec mCipher;
  private final Context mContext;
  private SQLiteDatabase mDatabase;
  private boolean mEnableWriteAheadLogging;
  private final DatabaseErrorHandler mErrorHandler;
  private final SQLiteDatabase.CursorFactory mFactory;
  private boolean mForcedSingleConnection;
  private boolean mIsInitializing;
  private int mMode;
  private final String mName;
  private boolean mNeedMode;
  private final int mNewVersion;
  private byte[] mPassword;
  
  static {}
  
  public SQLiteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    this(paramContext, paramString, paramCursorFactory, paramInt, null);
  }
  
  public SQLiteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    this(paramContext, paramString, null, null, paramCursorFactory, paramInt, paramDatabaseErrorHandler);
  }
  
  public SQLiteOpenHelper(Context paramContext, String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Version must be >= 1, was ".concat(String.valueOf(paramInt)));
    }
    this.mContext = paramContext;
    this.mName = paramString;
    this.mFactory = paramCursorFactory;
    this.mNewVersion = paramInt;
    this.mErrorHandler = paramDatabaseErrorHandler;
    this.mPassword = paramArrayOfByte;
    if (paramSQLiteCipherSpec == null) {}
    for (paramContext = null;; paramContext = new SQLiteCipherSpec(paramSQLiteCipherSpec))
    {
      this.mCipher = paramContext;
      this.mNeedMode = false;
      return;
    }
  }
  
  public SQLiteOpenHelper(Context paramContext, String paramString, byte[] paramArrayOfByte, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    this(paramContext, paramString, paramArrayOfByte, null, paramCursorFactory, paramInt, paramDatabaseErrorHandler);
  }
  
  /* Error */
  private SQLiteDatabase getDatabaseLocked(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 94	com/tencent/wcdb/database/SQLiteOpenHelper:mDatabase	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   6: ifnull +18 -> 24
    //   9: aload_0
    //   10: getfield 94	com/tencent/wcdb/database/SQLiteOpenHelper:mDatabase	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   13: invokevirtual 100	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
    //   16: ifne +25 -> 41
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 94	com/tencent/wcdb/database/SQLiteOpenHelper:mDatabase	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   24: aload_0
    //   25: getfield 102	com/tencent/wcdb/database/SQLiteOpenHelper:mIsInitializing	Z
    //   28: ifeq +36 -> 64
    //   31: new 104	java/lang/IllegalStateException
    //   34: dup
    //   35: ldc 106
    //   37: invokespecial 107	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   40: athrow
    //   41: iload_1
    //   42: ifeq +13 -> 55
    //   45: aload_0
    //   46: getfield 94	com/tencent/wcdb/database/SQLiteOpenHelper:mDatabase	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   49: invokevirtual 110	com/tencent/wcdb/database/SQLiteDatabase:isReadOnly	()Z
    //   52: ifne -28 -> 24
    //   55: aload_0
    //   56: getfield 94	com/tencent/wcdb/database/SQLiteOpenHelper:mDatabase	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   59: astore 6
    //   61: aload 6
    //   63: areturn
    //   64: aload_0
    //   65: getfield 94	com/tencent/wcdb/database/SQLiteOpenHelper:mDatabase	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   68: astore 5
    //   70: aload_0
    //   71: iconst_1
    //   72: putfield 102	com/tencent/wcdb/database/SQLiteOpenHelper:mIsInitializing	Z
    //   75: aload 5
    //   77: ifnull +63 -> 140
    //   80: iload_1
    //   81: ifeq +285 -> 366
    //   84: aload 5
    //   86: invokevirtual 110	com/tencent/wcdb/database/SQLiteDatabase:isReadOnly	()Z
    //   89: ifeq +277 -> 366
    //   92: aload 5
    //   94: invokevirtual 113	com/tencent/wcdb/database/SQLiteDatabase:reopenReadWrite	()V
    //   97: aload_0
    //   98: aload 5
    //   100: invokespecial 117	com/tencent/wcdb/database/SQLiteOpenHelper:getDatabaseLockedLast	(Lcom/tencent/wcdb/database/SQLiteDatabase;)Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   103: astore 7
    //   105: aload_0
    //   106: iconst_0
    //   107: putfield 102	com/tencent/wcdb/database/SQLiteOpenHelper:mIsInitializing	Z
    //   110: aload 7
    //   112: astore 6
    //   114: aload 5
    //   116: ifnull -55 -> 61
    //   119: aload 7
    //   121: astore 6
    //   123: aload 5
    //   125: aload_0
    //   126: getfield 94	com/tencent/wcdb/database/SQLiteOpenHelper:mDatabase	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   129: if_acmpeq -68 -> 61
    //   132: aload 5
    //   134: invokevirtual 120	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   137: aload 7
    //   139: areturn
    //   140: aload_0
    //   141: getfield 70	com/tencent/wcdb/database/SQLiteOpenHelper:mName	Ljava/lang/String;
    //   144: ifnonnull +16 -> 160
    //   147: aconst_null
    //   148: invokestatic 124	com/tencent/wcdb/database/SQLiteDatabase:create	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;)Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   151: astore 6
    //   153: aload 6
    //   155: astore 5
    //   157: goto -60 -> 97
    //   160: aload_0
    //   161: getfield 126	com/tencent/wcdb/database/SQLiteOpenHelper:mForcedSingleConnection	Z
    //   164: istore 4
    //   166: iload 4
    //   168: ifeq +64 -> 232
    //   171: aload_0
    //   172: iconst_1
    //   173: putfield 82	com/tencent/wcdb/database/SQLiteOpenHelper:mNeedMode	Z
    //   176: aload_0
    //   177: getfield 128	com/tencent/wcdb/database/SQLiteOpenHelper:mEnableWriteAheadLogging	Z
    //   180: ifeq +57 -> 237
    //   183: bipush 8
    //   185: istore_3
    //   186: aload_0
    //   187: iload_3
    //   188: putfield 130	com/tencent/wcdb/database/SQLiteOpenHelper:mMode	I
    //   191: aload_0
    //   192: getfield 68	com/tencent/wcdb/database/SQLiteOpenHelper:mContext	Landroid/content/Context;
    //   195: aload_0
    //   196: getfield 70	com/tencent/wcdb/database/SQLiteOpenHelper:mName	Ljava/lang/String;
    //   199: aload_0
    //   200: getfield 78	com/tencent/wcdb/database/SQLiteOpenHelper:mPassword	[B
    //   203: aload_0
    //   204: getfield 80	com/tencent/wcdb/database/SQLiteOpenHelper:mCipher	Lcom/tencent/wcdb/database/SQLiteCipherSpec;
    //   207: aload_0
    //   208: getfield 130	com/tencent/wcdb/database/SQLiteOpenHelper:mMode	I
    //   211: aload_0
    //   212: getfield 72	com/tencent/wcdb/database/SQLiteOpenHelper:mFactory	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   215: aload_0
    //   216: getfield 76	com/tencent/wcdb/database/SQLiteOpenHelper:mErrorHandler	Lcom/tencent/wcdb/DatabaseErrorHandler;
    //   219: iload_2
    //   220: invokestatic 136	com/tencent/wcdb/support/Context:openOrCreateDatabase	(Landroid/content/Context;Ljava/lang/String;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;ILcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Lcom/tencent/wcdb/DatabaseErrorHandler;I)Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   223: astore 6
    //   225: aload 6
    //   227: astore 5
    //   229: goto -132 -> 97
    //   232: iconst_0
    //   233: istore_2
    //   234: goto -63 -> 171
    //   237: iconst_0
    //   238: istore_3
    //   239: goto -53 -> 186
    //   242: astore 6
    //   244: iload_1
    //   245: ifeq +35 -> 280
    //   248: aload 6
    //   250: athrow
    //   251: astore 6
    //   253: aload_0
    //   254: iconst_0
    //   255: putfield 102	com/tencent/wcdb/database/SQLiteOpenHelper:mIsInitializing	Z
    //   258: aload 5
    //   260: ifnull +17 -> 277
    //   263: aload 5
    //   265: aload_0
    //   266: getfield 94	com/tencent/wcdb/database/SQLiteOpenHelper:mDatabase	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   269: if_acmpeq +8 -> 277
    //   272: aload 5
    //   274: invokevirtual 120	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   277: aload 6
    //   279: athrow
    //   280: ldc 11
    //   282: new 138	java/lang/StringBuilder
    //   285: dup
    //   286: ldc 140
    //   288: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   291: aload_0
    //   292: getfield 70	com/tencent/wcdb/database/SQLiteOpenHelper:mName	Ljava/lang/String;
    //   295: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: ldc 147
    //   300: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: iconst_1
    //   307: anewarray 4	java/lang/Object
    //   310: dup
    //   311: iconst_0
    //   312: aload 6
    //   314: aastore
    //   315: invokestatic 157	com/tencent/wcdb/support/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   318: aload_0
    //   319: getfield 68	com/tencent/wcdb/database/SQLiteOpenHelper:mContext	Landroid/content/Context;
    //   322: aload_0
    //   323: getfield 70	com/tencent/wcdb/database/SQLiteOpenHelper:mName	Ljava/lang/String;
    //   326: invokevirtual 163	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   329: invokevirtual 168	java/io/File:getPath	()Ljava/lang/String;
    //   332: aload_0
    //   333: getfield 78	com/tencent/wcdb/database/SQLiteOpenHelper:mPassword	[B
    //   336: aload_0
    //   337: getfield 80	com/tencent/wcdb/database/SQLiteOpenHelper:mCipher	Lcom/tencent/wcdb/database/SQLiteCipherSpec;
    //   340: aload_0
    //   341: getfield 72	com/tencent/wcdb/database/SQLiteOpenHelper:mFactory	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   344: iconst_1
    //   345: aload_0
    //   346: getfield 76	com/tencent/wcdb/database/SQLiteOpenHelper:mErrorHandler	Lcom/tencent/wcdb/DatabaseErrorHandler;
    //   349: invokestatic 172	com/tencent/wcdb/database/SQLiteDatabase:openDatabase	(Ljava/lang/String;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;ILcom/tencent/wcdb/DatabaseErrorHandler;)Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   352: astore 6
    //   354: aload 6
    //   356: astore 5
    //   358: goto -261 -> 97
    //   361: astore 6
    //   363: goto -110 -> 253
    //   366: goto -269 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	SQLiteOpenHelper
    //   0	369	1	paramBoolean	boolean
    //   1	233	2	i	int
    //   185	54	3	j	int
    //   164	3	4	bool	boolean
    //   68	289	5	localObject1	Object
    //   59	167	6	localObject2	Object
    //   242	7	6	localSQLiteException	SQLiteException
    //   251	62	6	localObject3	Object
    //   352	3	6	localSQLiteDatabase1	SQLiteDatabase
    //   361	1	6	localObject4	Object
    //   103	35	7	localSQLiteDatabase2	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   171	183	242	com/tencent/wcdb/database/SQLiteException
    //   186	225	242	com/tencent/wcdb/database/SQLiteException
    //   70	75	251	finally
    //   84	97	251	finally
    //   140	153	251	finally
    //   160	166	251	finally
    //   171	183	251	finally
    //   186	225	251	finally
    //   248	251	251	finally
    //   280	354	251	finally
    //   97	105	361	finally
  }
  
  private SQLiteDatabase getDatabaseLockedLast(SQLiteDatabase paramSQLiteDatabase)
  {
    onConfigure(paramSQLiteDatabase);
    int i = paramSQLiteDatabase.getVersion();
    if (i != this.mNewVersion)
    {
      if (paramSQLiteDatabase.isReadOnly()) {
        throw new SQLiteException("Can't upgrade read-only database from version " + paramSQLiteDatabase.getVersion() + " to " + this.mNewVersion + ": " + this.mName);
      }
      paramSQLiteDatabase.beginTransaction();
      if (i != 0) {
        break label153;
      }
    }
    for (;;)
    {
      try
      {
        onCreate(paramSQLiteDatabase);
        paramSQLiteDatabase.setVersion(this.mNewVersion);
        paramSQLiteDatabase.setTransactionSuccessful();
        paramSQLiteDatabase.endTransaction();
        onOpen(paramSQLiteDatabase);
        if (paramSQLiteDatabase.isReadOnly()) {
          Log.w("WCDB.SQLiteOpenHelper", "Opened " + this.mName + " in read-only mode");
        }
        this.mDatabase = paramSQLiteDatabase;
        return paramSQLiteDatabase;
      }
      finally
      {
        label153:
        paramSQLiteDatabase.endTransaction();
      }
      if (i > this.mNewVersion) {
        onDowngrade(paramSQLiteDatabase, i, this.mNewVersion);
      } else {
        onUpgrade(paramSQLiteDatabase, i, this.mNewVersion);
      }
    }
  }
  
  public void close()
  {
    try
    {
      if (this.mIsInitializing) {
        throw new IllegalStateException("Closed during initialization");
      }
    }
    finally {}
    if ((this.mDatabase != null) && (this.mDatabase.isOpen()))
    {
      this.mDatabase.close();
      this.mDatabase = null;
    }
  }
  
  public String getDatabaseName()
  {
    return this.mName;
  }
  
  public SQLiteDatabase getReadableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = getDatabaseLocked(false);
      return localSQLiteDatabase;
    }
    finally {}
  }
  
  public SQLiteDatabase getWritableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = getDatabaseLocked(true);
      return localSQLiteDatabase;
    }
    finally {}
  }
  
  public void onConfigure(SQLiteDatabase paramSQLiteDatabase) {}
  
  public abstract void onCreate(SQLiteDatabase paramSQLiteDatabase);
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    throw new SQLiteException("Can't downgrade database from version " + paramInt1 + " to " + paramInt2);
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase) {}
  
  public abstract void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2);
  
  public void setForcedSingleConnection(boolean paramBoolean)
  {
    try
    {
      this.mForcedSingleConnection = paramBoolean;
      return;
    }
    finally {}
  }
  
  /* Error */
  public void setWriteAheadLoggingEnabled(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 128	com/tencent/wcdb/database/SQLiteOpenHelper:mEnableWriteAheadLogging	Z
    //   6: iload_1
    //   7: if_icmpeq +47 -> 54
    //   10: aload_0
    //   11: getfield 94	com/tencent/wcdb/database/SQLiteOpenHelper:mDatabase	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   14: ifnull +35 -> 49
    //   17: aload_0
    //   18: getfield 94	com/tencent/wcdb/database/SQLiteOpenHelper:mDatabase	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   21: invokevirtual 100	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
    //   24: ifeq +25 -> 49
    //   27: aload_0
    //   28: getfield 94	com/tencent/wcdb/database/SQLiteOpenHelper:mDatabase	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   31: invokevirtual 110	com/tencent/wcdb/database/SQLiteDatabase:isReadOnly	()Z
    //   34: ifne +15 -> 49
    //   37: iload_1
    //   38: ifeq +19 -> 57
    //   41: aload_0
    //   42: getfield 94	com/tencent/wcdb/database/SQLiteOpenHelper:mDatabase	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   45: invokevirtual 240	com/tencent/wcdb/database/SQLiteDatabase:enableWriteAheadLogging	()Z
    //   48: pop
    //   49: aload_0
    //   50: iload_1
    //   51: putfield 128	com/tencent/wcdb/database/SQLiteOpenHelper:mEnableWriteAheadLogging	Z
    //   54: aload_0
    //   55: monitorexit
    //   56: return
    //   57: aload_0
    //   58: getfield 94	com/tencent/wcdb/database/SQLiteOpenHelper:mDatabase	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   61: invokevirtual 243	com/tencent/wcdb/database/SQLiteDatabase:disableWriteAheadLogging	()V
    //   64: goto -15 -> 49
    //   67: astore_2
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_2
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	SQLiteOpenHelper
    //   0	72	1	paramBoolean	boolean
    //   67	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	37	67	finally
    //   41	49	67	finally
    //   49	54	67	finally
    //   54	56	67	finally
    //   57	64	67	finally
    //   68	70	67	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteOpenHelper
 * JD-Core Version:    0.7.0.1
 */