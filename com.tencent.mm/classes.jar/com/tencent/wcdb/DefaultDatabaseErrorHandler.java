package com.tencent.wcdb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.support.Log;
import java.io.File;

public final class DefaultDatabaseErrorHandler
  implements DatabaseErrorHandler
{
  private static final String[] SUFFIX_TO_BACKUP = { "", "-journal", "-wal", ".sm", ".bak", "-vfslog", "-vfslo1" };
  private static final String TAG = "WCDB.DefaultDatabaseErrorHandler";
  private final boolean mNoCorruptionBackup;
  
  public DefaultDatabaseErrorHandler()
  {
    this.mNoCorruptionBackup = false;
  }
  
  public DefaultDatabaseErrorHandler(boolean paramBoolean)
  {
    this.mNoCorruptionBackup = paramBoolean;
  }
  
  private void deleteDatabaseFile(String paramString)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(2851);
    if ((paramString.equalsIgnoreCase(":memory:")) || (paramString.trim().length() == 0))
    {
      AppMethodBeat.o(2851);
      return;
    }
    Log.e("WCDB.DefaultDatabaseErrorHandler", "Remove database file: ".concat(String.valueOf(paramString)));
    Object localObject2;
    if (!this.mNoCorruptionBackup)
    {
      localObject1 = new File(paramString);
      localObject2 = new File(((File)localObject1).getParentFile(), "corrupted");
      if (!((File)localObject2).mkdirs()) {
        Log.e("WCDB.DefaultDatabaseErrorHandler", "Could not create directory for corrupted database. Corruption backup may be unavailable.");
      }
      localObject1 = ((File)localObject2).getPath() + "/" + ((File)localObject1).getName();
      localObject2 = SUFFIX_TO_BACKUP;
      j = localObject2.length;
      while (i < j)
      {
        String str = localObject2[i];
        moveOrDeleteFile(paramString + str, (String)localObject1 + str);
        i += 1;
      }
      AppMethodBeat.o(2851);
      return;
    }
    Object localObject1 = SUFFIX_TO_BACKUP;
    int k = localObject1.length;
    i = j;
    while (i < k)
    {
      localObject2 = localObject1[i];
      deleteFile(paramString + (String)localObject2);
      i += 1;
    }
    AppMethodBeat.o(2851);
  }
  
  private static boolean deleteFile(String paramString)
  {
    AppMethodBeat.i(2853);
    boolean bool = new File(paramString).delete();
    AppMethodBeat.o(2853);
    return bool;
  }
  
  private static boolean moveOrDeleteFile(String paramString1, String paramString2)
  {
    AppMethodBeat.i(2852);
    paramString1 = new File(paramString1);
    boolean bool = paramString1.renameTo(new File(paramString2));
    if (!bool) {
      paramString1.delete();
    }
    AppMethodBeat.o(2852);
    return bool;
  }
  
  /* Error */
  public final void onCorruption(com.tencent.wcdb.database.SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: sipush 2850
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 12
    //   8: new 103	java/lang/StringBuilder
    //   11: dup
    //   12: ldc 139
    //   14: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   17: aload_1
    //   18: invokevirtual 143	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   21: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 82	com/tencent/wcdb/support/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_1
    //   31: invokevirtual 146	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
    //   34: ifne +18 -> 52
    //   37: aload_0
    //   38: aload_1
    //   39: invokevirtual 143	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   42: invokespecial 148	com/tencent/wcdb/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   45: sipush 2850
    //   48: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: return
    //   52: aconst_null
    //   53: astore_2
    //   54: aload_1
    //   55: invokevirtual 152	com/tencent/wcdb/database/SQLiteDatabase:getAttachedDbs	()Ljava/util/List;
    //   58: astore_3
    //   59: aload_3
    //   60: astore_2
    //   61: aload_1
    //   62: invokevirtual 156	com/tencent/wcdb/database/SQLiteDatabase:getTraceCallback	()Lcom/tencent/wcdb/database/SQLiteTrace;
    //   65: astore_3
    //   66: aload_3
    //   67: ifnull +10 -> 77
    //   70: aload_3
    //   71: aload_1
    //   72: invokeinterface 161 2 0
    //   77: aload_1
    //   78: invokevirtual 164	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   81: aload_2
    //   82: ifnull +48 -> 130
    //   85: aload_2
    //   86: invokeinterface 170 1 0
    //   91: astore_1
    //   92: aload_1
    //   93: invokeinterface 175 1 0
    //   98: ifeq +25 -> 123
    //   101: aload_0
    //   102: aload_1
    //   103: invokeinterface 179 1 0
    //   108: checkcast 181	android/util/Pair
    //   111: getfield 185	android/util/Pair:second	Ljava/lang/Object;
    //   114: checkcast 18	java/lang/String
    //   117: invokespecial 148	com/tencent/wcdb/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   120: goto -28 -> 92
    //   123: sipush 2850
    //   126: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: return
    //   130: aload_0
    //   131: aload_1
    //   132: invokevirtual 143	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   135: invokespecial 148	com/tencent/wcdb/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   138: sipush 2850
    //   141: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: return
    //   145: astore_3
    //   146: aload_2
    //   147: ifnull +48 -> 195
    //   150: aload_2
    //   151: invokeinterface 170 1 0
    //   156: astore_1
    //   157: aload_1
    //   158: invokeinterface 175 1 0
    //   163: ifeq +25 -> 188
    //   166: aload_0
    //   167: aload_1
    //   168: invokeinterface 179 1 0
    //   173: checkcast 181	android/util/Pair
    //   176: getfield 185	android/util/Pair:second	Ljava/lang/Object;
    //   179: checkcast 18	java/lang/String
    //   182: invokespecial 148	com/tencent/wcdb/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   185: goto -28 -> 157
    //   188: sipush 2850
    //   191: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: return
    //   195: aload_0
    //   196: aload_1
    //   197: invokevirtual 143	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   200: invokespecial 148	com/tencent/wcdb/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   203: sipush 2850
    //   206: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   209: return
    //   210: astore_3
    //   211: aload_2
    //   212: ifnull +41 -> 253
    //   215: aload_2
    //   216: invokeinterface 170 1 0
    //   221: astore_1
    //   222: aload_1
    //   223: invokeinterface 175 1 0
    //   228: ifeq +33 -> 261
    //   231: aload_0
    //   232: aload_1
    //   233: invokeinterface 179 1 0
    //   238: checkcast 181	android/util/Pair
    //   241: getfield 185	android/util/Pair:second	Ljava/lang/Object;
    //   244: checkcast 18	java/lang/String
    //   247: invokespecial 148	com/tencent/wcdb/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   250: goto -28 -> 222
    //   253: aload_0
    //   254: aload_1
    //   255: invokevirtual 143	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   258: invokespecial 148	com/tencent/wcdb/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   261: sipush 2850
    //   264: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   267: aload_3
    //   268: athrow
    //   269: astore_3
    //   270: goto -209 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	DefaultDatabaseErrorHandler
    //   0	273	1	paramSQLiteDatabase	com.tencent.wcdb.database.SQLiteDatabase
    //   53	163	2	localObject1	Object
    //   58	13	3	localObject2	Object
    //   145	1	3	localSQLiteException1	com.tencent.wcdb.database.SQLiteException
    //   210	58	3	localObject3	Object
    //   269	1	3	localSQLiteException2	com.tencent.wcdb.database.SQLiteException
    // Exception table:
    //   from	to	target	type
    //   77	81	145	com/tencent/wcdb/database/SQLiteException
    //   77	81	210	finally
    //   54	59	269	com/tencent/wcdb/database/SQLiteException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wcdb.DefaultDatabaseErrorHandler
 * JD-Core Version:    0.7.0.1
 */