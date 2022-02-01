package com.tencent.sqlitelint.behaviour.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.io.File;

public enum SQLiteLintOwnDatabase
{
  private static final String DATABASE_DIRECTORY = "database";
  private static final String DATABASE_NAME = "own.db";
  private static final int NEW_VERSION = 1;
  private static final String ROOT_PATH;
  private static final String TAG = "SQLiteLint.SQLiteLintOwnDatabase";
  private static final int VERSION_1 = 1;
  private static String sOwnDbDirectory;
  private volatile SQLiteDatabase mDatabase;
  private boolean mIsInitializing;
  
  static
  {
    AppMethodBeat.i(52937);
    INSTANCE = new SQLiteLintOwnDatabase("INSTANCE", 0);
    $VALUES = new SQLiteLintOwnDatabase[] { INSTANCE };
    ROOT_PATH = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
    sOwnDbDirectory = "";
    AppMethodBeat.o(52937);
  }
  
  private SQLiteLintOwnDatabase() {}
  
  private void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = 0;
    AppMethodBeat.i(52933);
    SLog.i("SQLiteLint.SQLiteLintOwnDatabase", "onCreate", new Object[0]);
    paramSQLiteDatabase.execSQL(IssueStorage.DB_VERSION_1_CREATE_SQL);
    while (i < IssueStorage.DB_VERSION_1_CREATE_INDEX.length)
    {
      paramSQLiteDatabase.execSQL(IssueStorage.DB_VERSION_1_CREATE_INDEX[i]);
      i += 1;
    }
    AppMethodBeat.o(52933);
  }
  
  private void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    AppMethodBeat.i(52934);
    SLog.i("SQLiteLint.SQLiteLintOwnDatabase", "onUpgrade oldVersion=%d, newVersion=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1) });
    AppMethodBeat.o(52934);
  }
  
  /* Error */
  private SQLiteDatabase openOrCreateDatabase()
  {
    // Byte code:
    //   0: ldc 114
    //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 116	com/tencent/sqlitelint/behaviour/persistence/SQLiteLintOwnDatabase:mIsInitializing	Z
    //   9: ifeq +20 -> 29
    //   12: new 118	java/lang/IllegalStateException
    //   15: dup
    //   16: ldc 120
    //   18: invokespecial 122	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   21: astore_2
    //   22: ldc 114
    //   24: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_2
    //   28: athrow
    //   29: getstatic 68	com/tencent/sqlitelint/behaviour/persistence/SQLiteLintOwnDatabase:sOwnDbDirectory	Ljava/lang/String;
    //   32: invokestatic 128	com/tencent/sqlitelint/util/SQLiteLintUtil:isNullOrNil	(Ljava/lang/String;)Z
    //   35: ifeq +20 -> 55
    //   38: new 118	java/lang/IllegalStateException
    //   41: dup
    //   42: ldc 130
    //   44: invokespecial 122	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   47: astore_2
    //   48: ldc 114
    //   50: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_2
    //   54: athrow
    //   55: aload_0
    //   56: iconst_1
    //   57: putfield 116	com/tencent/sqlitelint/behaviour/persistence/SQLiteLintOwnDatabase:mIsInitializing	Z
    //   60: ldc 132
    //   62: iconst_2
    //   63: anewarray 80	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: getstatic 68	com/tencent/sqlitelint/behaviour/persistence/SQLiteLintOwnDatabase:sOwnDbDirectory	Ljava/lang/String;
    //   71: aastore
    //   72: dup
    //   73: iconst_1
    //   74: ldc 14
    //   76: aastore
    //   77: invokestatic 138	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   80: astore_2
    //   81: ldc 23
    //   83: ldc 140
    //   85: iconst_1
    //   86: anewarray 80	java/lang/Object
    //   89: dup
    //   90: iconst_0
    //   91: aload_2
    //   92: aastore
    //   93: invokestatic 85	com/tencent/sqlitelint/util/SLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   96: aload_2
    //   97: invokestatic 143	com/tencent/sqlitelint/util/SQLiteLintUtil:mkdirs	(Ljava/lang/String;)V
    //   100: aload_2
    //   101: aconst_null
    //   102: ldc 144
    //   104: aconst_null
    //   105: invokestatic 148	android/database/sqlite/SQLiteDatabase:openDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;ILandroid/database/DatabaseErrorHandler;)Landroid/database/sqlite/SQLiteDatabase;
    //   108: astore_2
    //   109: aload_2
    //   110: invokevirtual 152	android/database/sqlite/SQLiteDatabase:getVersion	()I
    //   113: istore_1
    //   114: iload_1
    //   115: iconst_1
    //   116: if_icmpeq +29 -> 145
    //   119: aload_2
    //   120: invokevirtual 155	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   123: iload_1
    //   124: ifne +33 -> 157
    //   127: aload_0
    //   128: aload_2
    //   129: invokespecial 157	com/tencent/sqlitelint/behaviour/persistence/SQLiteLintOwnDatabase:onCreate	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   132: aload_2
    //   133: iconst_1
    //   134: invokevirtual 160	android/database/sqlite/SQLiteDatabase:setVersion	(I)V
    //   137: aload_2
    //   138: invokevirtual 163	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   141: aload_2
    //   142: invokevirtual 166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   145: aload_0
    //   146: iconst_0
    //   147: putfield 116	com/tencent/sqlitelint/behaviour/persistence/SQLiteLintOwnDatabase:mIsInitializing	Z
    //   150: ldc 114
    //   152: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: aload_2
    //   156: areturn
    //   157: iload_1
    //   158: iconst_1
    //   159: if_icmpeq -27 -> 132
    //   162: aload_0
    //   163: aload_2
    //   164: iload_1
    //   165: invokespecial 168	com/tencent/sqlitelint/behaviour/persistence/SQLiteLintOwnDatabase:onUpgrade	(Landroid/database/sqlite/SQLiteDatabase;I)V
    //   168: goto -36 -> 132
    //   171: astore_3
    //   172: aload_2
    //   173: invokevirtual 166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   176: ldc 114
    //   178: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: aload_3
    //   182: athrow
    //   183: astore_2
    //   184: aload_0
    //   185: iconst_0
    //   186: putfield 116	com/tencent/sqlitelint/behaviour/persistence/SQLiteLintOwnDatabase:mIsInitializing	Z
    //   189: ldc 114
    //   191: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: aload_2
    //   195: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	SQLiteLintOwnDatabase
    //   113	52	1	i	int
    //   21	152	2	localObject1	Object
    //   183	12	2	localObject2	Object
    //   171	11	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   127	132	171	finally
    //   132	141	171	finally
    //   162	168	171	finally
    //   55	114	183	finally
    //   119	123	183	finally
    //   141	145	183	finally
    //   172	183	183	finally
  }
  
  public static void setOwnDbDirectory(Context paramContext)
  {
    AppMethodBeat.i(52936);
    if (!SQLiteLintUtil.isNullOrNil(sOwnDbDirectory))
    {
      AppMethodBeat.o(52936);
      return;
    }
    sOwnDbDirectory = String.format("%s/SQLiteLint-%s/%s/", new Object[] { ROOT_PATH, paramContext.getPackageManager(), "database" });
    AppMethodBeat.o(52936);
  }
  
  public final void closeDatabase()
  {
    try
    {
      AppMethodBeat.i(52932);
      if (this.mIsInitializing)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Closed during initialization");
        AppMethodBeat.o(52932);
        throw localIllegalStateException;
      }
    }
    finally {}
    if ((this.mDatabase != null) && (this.mDatabase.isOpen()))
    {
      this.mDatabase.close();
      this.mDatabase = null;
    }
    AppMethodBeat.o(52932);
  }
  
  public final SQLiteDatabase getDatabase()
  {
    AppMethodBeat.i(52931);
    if ((this.mDatabase == null) || (!this.mDatabase.isOpen())) {}
    try
    {
      if ((this.mDatabase == null) || (!this.mDatabase.isOpen())) {
        this.mDatabase = openOrCreateDatabase();
      }
      SQLiteDatabase localSQLiteDatabase = this.mDatabase;
      AppMethodBeat.o(52931);
      return localSQLiteDatabase;
    }
    finally
    {
      AppMethodBeat.o(52931);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.sqlitelint.behaviour.persistence.SQLiteLintOwnDatabase
 * JD-Core Version:    0.7.0.1
 */