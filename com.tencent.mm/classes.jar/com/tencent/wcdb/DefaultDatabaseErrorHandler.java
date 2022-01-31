package com.tencent.wcdb;

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
    if ((paramString.equalsIgnoreCase(":memory:")) || (paramString.trim().length() == 0)) {}
    for (;;)
    {
      return;
      Log.e("WCDB.DefaultDatabaseErrorHandler", "Remove database file: " + paramString);
      Object localObject1;
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
      }
      else
      {
        localObject1 = SUFFIX_TO_BACKUP;
        int k = localObject1.length;
        i = j;
        while (i < k)
        {
          localObject2 = localObject1[i];
          deleteFile(paramString + (String)localObject2);
          i += 1;
        }
      }
    }
  }
  
  private static boolean deleteFile(String paramString)
  {
    return new File(paramString).delete();
  }
  
  private static boolean moveOrDeleteFile(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    boolean bool = paramString1.renameTo(new File(paramString2));
    if (!bool) {
      paramString1.delete();
    }
    return bool;
  }
  
  /* Error */
  public final void onCorruption(com.tencent.wcdb.database.SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: ldc 12
    //   2: new 59	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 123
    //   8: invokespecial 63	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_1
    //   12: invokevirtual 126	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   15: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21: invokestatic 76	com/tencent/wcdb/support/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: aload_1
    //   25: invokevirtual 129	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
    //   28: ifne +12 -> 40
    //   31: aload_0
    //   32: aload_1
    //   33: invokevirtual 126	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   36: invokespecial 131	com/tencent/wcdb/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   39: return
    //   40: aconst_null
    //   41: astore_2
    //   42: aload_1
    //   43: invokevirtual 135	com/tencent/wcdb/database/SQLiteDatabase:getAttachedDbs	()Ljava/util/List;
    //   46: astore_3
    //   47: aload_3
    //   48: astore_2
    //   49: aload_1
    //   50: invokevirtual 139	com/tencent/wcdb/database/SQLiteDatabase:getTraceCallback	()Lcom/tencent/wcdb/database/SQLiteTrace;
    //   53: astore_3
    //   54: aload_3
    //   55: ifnull +10 -> 65
    //   58: aload_3
    //   59: aload_1
    //   60: invokeinterface 144 2 0
    //   65: aload_1
    //   66: invokevirtual 147	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   69: aload_2
    //   70: ifnull +41 -> 111
    //   73: aload_2
    //   74: invokeinterface 153 1 0
    //   79: astore_1
    //   80: aload_1
    //   81: invokeinterface 158 1 0
    //   86: ifeq -47 -> 39
    //   89: aload_0
    //   90: aload_1
    //   91: invokeinterface 162 1 0
    //   96: checkcast 164	android/util/Pair
    //   99: getfield 168	android/util/Pair:second	Ljava/lang/Object;
    //   102: checkcast 18	java/lang/String
    //   105: invokespecial 131	com/tencent/wcdb/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   108: goto -28 -> 80
    //   111: aload_0
    //   112: aload_1
    //   113: invokevirtual 126	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   116: invokespecial 131	com/tencent/wcdb/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   119: return
    //   120: astore_3
    //   121: aload_2
    //   122: ifnull +41 -> 163
    //   125: aload_2
    //   126: invokeinterface 153 1 0
    //   131: astore_1
    //   132: aload_1
    //   133: invokeinterface 158 1 0
    //   138: ifeq -99 -> 39
    //   141: aload_0
    //   142: aload_1
    //   143: invokeinterface 162 1 0
    //   148: checkcast 164	android/util/Pair
    //   151: getfield 168	android/util/Pair:second	Ljava/lang/Object;
    //   154: checkcast 18	java/lang/String
    //   157: invokespecial 131	com/tencent/wcdb/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   160: goto -28 -> 132
    //   163: aload_0
    //   164: aload_1
    //   165: invokevirtual 126	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   168: invokespecial 131	com/tencent/wcdb/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   171: return
    //   172: astore_3
    //   173: aload_2
    //   174: ifnull +41 -> 215
    //   177: aload_2
    //   178: invokeinterface 153 1 0
    //   183: astore_1
    //   184: aload_1
    //   185: invokeinterface 158 1 0
    //   190: ifeq +33 -> 223
    //   193: aload_0
    //   194: aload_1
    //   195: invokeinterface 162 1 0
    //   200: checkcast 164	android/util/Pair
    //   203: getfield 168	android/util/Pair:second	Ljava/lang/Object;
    //   206: checkcast 18	java/lang/String
    //   209: invokespecial 131	com/tencent/wcdb/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   212: goto -28 -> 184
    //   215: aload_0
    //   216: aload_1
    //   217: invokevirtual 126	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   220: invokespecial 131	com/tencent/wcdb/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   223: aload_3
    //   224: athrow
    //   225: astore_3
    //   226: goto -177 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	DefaultDatabaseErrorHandler
    //   0	229	1	paramSQLiteDatabase	com.tencent.wcdb.database.SQLiteDatabase
    //   41	137	2	localObject1	Object
    //   46	13	3	localObject2	Object
    //   120	1	3	localSQLiteException1	com.tencent.wcdb.database.SQLiteException
    //   172	52	3	localObject3	Object
    //   225	1	3	localSQLiteException2	com.tencent.wcdb.database.SQLiteException
    // Exception table:
    //   from	to	target	type
    //   65	69	120	com/tencent/wcdb/database/SQLiteException
    //   65	69	172	finally
    //   42	47	225	com/tencent/wcdb/database/SQLiteException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.DefaultDatabaseErrorHandler
 * JD-Core Version:    0.7.0.1
 */