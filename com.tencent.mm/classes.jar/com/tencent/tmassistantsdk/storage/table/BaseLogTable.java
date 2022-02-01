package com.tencent.tmassistantsdk.storage.table;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.tmassistantsdk.storage.helper.AstSDKDBHelper_V2;
import com.tencent.tmassistantsdk.storage.helper.SqliteHelper;
import java.util.Iterator;
import java.util.List;

public abstract class BaseLogTable
  implements ITableBase
{
  private static final String TAG = "BaseLogTable";
  
  public String createTableSQL()
  {
    return getCreateTableSQL();
  }
  
  public void dataMovement(SQLiteDatabase paramSQLiteDatabase1, SQLiteDatabase paramSQLiteDatabase2) {}
  
  public boolean delete(List<Long> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return false;
    }
    StringBuffer localStringBuffer = new StringBuffer("(");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localStringBuffer.append((Long)paramList.next());
      localStringBuffer.append(",");
    }
    if (localStringBuffer.length() > 0) {
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    localStringBuffer.append(")");
    getHelper().getWritableDatabase().delete(getTableName(), "_id in ".concat(String.valueOf(localStringBuffer)), null);
    return true;
  }
  
  protected abstract String[] getAlterSQL(int paramInt);
  
  public String[] getAlterSQL(int paramInt1, int paramInt2)
  {
    return getAlterSQL(paramInt2);
  }
  
  protected abstract String getCreateTableSQL();
  
  /* Error */
  public DataWrapper getDatas(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 8	com/tencent/tmassistantsdk/storage/table/BaseLogTable$DataWrapper
    //   6: dup
    //   7: invokespecial 116	com/tencent/tmassistantsdk/storage/table/BaseLogTable$DataWrapper:<init>	()V
    //   10: astore 7
    //   12: aload 7
    //   14: new 118	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 119	java/util/ArrayList:<init>	()V
    //   21: putfield 123	com/tencent/tmassistantsdk/storage/table/BaseLogTable$DataWrapper:idList	Ljava/util/List;
    //   24: aload 7
    //   26: new 118	java/util/ArrayList
    //   29: dup
    //   30: invokespecial 119	java/util/ArrayList:<init>	()V
    //   33: putfield 126	com/tencent/tmassistantsdk/storage/table/BaseLogTable$DataWrapper:dataList	Ljava/util/List;
    //   36: iload_1
    //   37: ifle +248 -> 285
    //   40: ldc 128
    //   42: iload_1
    //   43: invokestatic 131	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   46: invokevirtual 99	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   49: astore 5
    //   51: aload_0
    //   52: invokevirtual 78	com/tencent/tmassistantsdk/storage/table/BaseLogTable:getHelper	()Lcom/tencent/tmassistantsdk/storage/helper/SqliteHelper;
    //   55: invokevirtual 134	com/tencent/tmassistantsdk/storage/helper/SqliteHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   58: astore 6
    //   60: aload 6
    //   62: aload_0
    //   63: invokevirtual 87	com/tencent/tmassistantsdk/storage/table/BaseLogTable:getTableName	()Ljava/lang/String;
    //   66: aconst_null
    //   67: aconst_null
    //   68: aconst_null
    //   69: aconst_null
    //   70: aconst_null
    //   71: ldc 136
    //   73: aload 5
    //   75: invokevirtual 140	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   78: astore 6
    //   80: aload 6
    //   82: ifnull +114 -> 196
    //   85: aload 6
    //   87: astore 5
    //   89: aload 6
    //   91: invokeinterface 145 1 0
    //   96: ifeq +100 -> 196
    //   99: aload 6
    //   101: astore 5
    //   103: aload 6
    //   105: aload 6
    //   107: ldc 147
    //   109: invokeinterface 151 2 0
    //   114: invokeinterface 155 2 0
    //   119: lstore_2
    //   120: aload 6
    //   122: astore 5
    //   124: aload 7
    //   126: getfield 123	com/tencent/tmassistantsdk/storage/table/BaseLogTable$DataWrapper:idList	Ljava/util/List;
    //   129: lload_2
    //   130: invokestatic 158	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   133: invokeinterface 162 2 0
    //   138: pop
    //   139: aload 6
    //   141: astore 5
    //   143: aload 6
    //   145: aload 6
    //   147: ldc 164
    //   149: invokeinterface 151 2 0
    //   154: invokeinterface 168 2 0
    //   159: astore 9
    //   161: aload 6
    //   163: astore 5
    //   165: aload 7
    //   167: getfield 126	com/tencent/tmassistantsdk/storage/table/BaseLogTable$DataWrapper:dataList	Ljava/util/List;
    //   170: aload 9
    //   172: invokeinterface 162 2 0
    //   177: pop
    //   178: aload 6
    //   180: astore 5
    //   182: aload 6
    //   184: invokeinterface 171 1 0
    //   189: istore 4
    //   191: iload 4
    //   193: ifne -94 -> 99
    //   196: aload 6
    //   198: ifnull +10 -> 208
    //   201: aload 6
    //   203: invokeinterface 174 1 0
    //   208: aload 7
    //   210: astore 5
    //   212: aload 5
    //   214: areturn
    //   215: astore 7
    //   217: aconst_null
    //   218: astore 6
    //   220: aload 6
    //   222: astore 5
    //   224: ldc 13
    //   226: aload 7
    //   228: ldc 176
    //   230: iconst_0
    //   231: anewarray 4	java/lang/Object
    //   234: invokestatic 182	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: aload 8
    //   239: astore 5
    //   241: aload 6
    //   243: ifnull -31 -> 212
    //   246: aload 6
    //   248: invokeinterface 174 1 0
    //   253: aconst_null
    //   254: areturn
    //   255: astore 6
    //   257: aconst_null
    //   258: astore 5
    //   260: aload 5
    //   262: ifnull +10 -> 272
    //   265: aload 5
    //   267: invokeinterface 174 1 0
    //   272: aload 6
    //   274: athrow
    //   275: astore 6
    //   277: goto -17 -> 260
    //   280: astore 7
    //   282: goto -62 -> 220
    //   285: aconst_null
    //   286: astore 5
    //   288: goto -237 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	this	BaseLogTable
    //   0	291	1	paramInt	int
    //   119	11	2	l	long
    //   189	3	4	bool	boolean
    //   49	238	5	localObject1	Object
    //   58	189	6	localObject2	Object
    //   255	18	6	localObject3	Object
    //   275	1	6	localObject4	Object
    //   10	199	7	localDataWrapper	DataWrapper
    //   215	12	7	localException1	java.lang.Exception
    //   280	1	7	localException2	java.lang.Exception
    //   1	237	8	localObject5	Object
    //   159	12	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   60	80	215	java/lang/Exception
    //   60	80	255	finally
    //   89	99	275	finally
    //   103	120	275	finally
    //   124	139	275	finally
    //   143	161	275	finally
    //   165	178	275	finally
    //   182	191	275	finally
    //   224	237	275	finally
    //   89	99	280	java/lang/Exception
    //   103	120	280	java/lang/Exception
    //   124	139	280	java/lang/Exception
    //   143	161	280	java/lang/Exception
    //   165	178	280	java/lang/Exception
    //   182	191	280	java/lang/Exception
  }
  
  public SqliteHelper getHelper()
  {
    return AstSDKDBHelper_V2.getInstance();
  }
  
  protected abstract String getInsertSQL();
  
  protected abstract String getTableName();
  
  /* Error */
  public boolean save(List<byte[]> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 78	com/tencent/tmassistantsdk/storage/table/BaseLogTable:getHelper	()Lcom/tencent/tmassistantsdk/storage/helper/SqliteHelper;
    //   4: invokevirtual 84	com/tencent/tmassistantsdk/storage/helper/SqliteHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore_2
    //   8: aload_2
    //   9: invokevirtual 192	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   12: aload_2
    //   13: aload_0
    //   14: invokevirtual 194	com/tencent/tmassistantsdk/storage/table/BaseLogTable:getInsertSQL	()Ljava/lang/String;
    //   17: invokevirtual 198	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   20: astore_3
    //   21: aload_1
    //   22: invokeinterface 44 1 0
    //   27: astore_1
    //   28: aload_1
    //   29: invokeinterface 50 1 0
    //   34: ifeq +44 -> 78
    //   37: aload_3
    //   38: iconst_1
    //   39: aload_1
    //   40: invokeinterface 54 1 0
    //   45: checkcast 200	[B
    //   48: invokevirtual 206	android/database/sqlite/SQLiteStatement:bindBlob	(I[B)V
    //   51: aload_3
    //   52: invokevirtual 210	android/database/sqlite/SQLiteStatement:executeInsert	()J
    //   55: pop2
    //   56: goto -28 -> 28
    //   59: astore_1
    //   60: ldc 13
    //   62: aload_1
    //   63: ldc 176
    //   65: iconst_0
    //   66: anewarray 4	java/lang/Object
    //   69: invokestatic 182	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: aload_2
    //   73: invokevirtual 213	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   76: iconst_0
    //   77: ireturn
    //   78: aload_2
    //   79: invokevirtual 216	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   82: aload_2
    //   83: invokevirtual 213	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   86: iconst_1
    //   87: ireturn
    //   88: astore_1
    //   89: aload_2
    //   90: invokevirtual 213	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	BaseLogTable
    //   0	95	1	paramList	List<byte[]>
    //   7	83	2	localSQLiteDatabase	SQLiteDatabase
    //   20	32	3	localSQLiteStatement	android.database.sqlite.SQLiteStatement
    // Exception table:
    //   from	to	target	type
    //   8	28	59	java/lang/Exception
    //   28	56	59	java/lang/Exception
    //   78	82	59	java/lang/Exception
    //   8	28	88	finally
    //   28	56	88	finally
    //   60	72	88	finally
    //   78	82	88	finally
  }
  
  public boolean save(byte[] paramArrayOfByte)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("logData", paramArrayOfByte);
    return getHelper().getWritableDatabase().insert(getTableName(), null, localContentValues) > 0L;
  }
  
  public String tableName()
  {
    return getTableName();
  }
  
  public static class DataWrapper
  {
    public List<byte[]> dataList;
    public List<Long> idList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.storage.table.BaseLogTable
 * JD-Core Version:    0.7.0.1
 */