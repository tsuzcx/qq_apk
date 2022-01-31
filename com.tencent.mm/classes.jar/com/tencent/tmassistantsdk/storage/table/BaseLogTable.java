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
    getHelper().getWritableDatabase().delete(getTableName(), "_id in " + localStringBuffer, null);
    return true;
  }
  
  protected abstract String[] getAlterSQL(int paramInt);
  
  public String[] getAlterSQL(int paramInt1, int paramInt2)
  {
    return getAlterSQL(paramInt2);
  }
  
  protected abstract String getCreateTableSQL();
  
  /* Error */
  public BaseLogTable.DataWrapper getDatas(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 8	com/tencent/tmassistantsdk/storage/table/BaseLogTable$DataWrapper
    //   6: dup
    //   7: invokespecial 114	com/tencent/tmassistantsdk/storage/table/BaseLogTable$DataWrapper:<init>	()V
    //   10: astore 7
    //   12: aload 7
    //   14: new 116	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 117	java/util/ArrayList:<init>	()V
    //   21: putfield 121	com/tencent/tmassistantsdk/storage/table/BaseLogTable$DataWrapper:idList	Ljava/util/List;
    //   24: aload 7
    //   26: new 116	java/util/ArrayList
    //   29: dup
    //   30: invokespecial 117	java/util/ArrayList:<init>	()V
    //   33: putfield 124	com/tencent/tmassistantsdk/storage/table/BaseLogTable$DataWrapper:dataList	Ljava/util/List;
    //   36: iload_1
    //   37: ifle +255 -> 292
    //   40: new 88	java/lang/StringBuilder
    //   43: dup
    //   44: ldc 126
    //   46: invokespecial 91	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   49: iload_1
    //   50: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: astore 5
    //   58: aload_0
    //   59: invokevirtual 77	com/tencent/tmassistantsdk/storage/table/BaseLogTable:getHelper	()Lcom/tencent/tmassistantsdk/storage/helper/SqliteHelper;
    //   62: invokevirtual 132	com/tencent/tmassistantsdk/storage/helper/SqliteHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   65: astore 6
    //   67: aload 6
    //   69: aload_0
    //   70: invokevirtual 86	com/tencent/tmassistantsdk/storage/table/BaseLogTable:getTableName	()Ljava/lang/String;
    //   73: aconst_null
    //   74: aconst_null
    //   75: aconst_null
    //   76: aconst_null
    //   77: aconst_null
    //   78: ldc 134
    //   80: aload 5
    //   82: invokevirtual 138	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   85: astore 6
    //   87: aload 6
    //   89: ifnull +114 -> 203
    //   92: aload 6
    //   94: astore 5
    //   96: aload 6
    //   98: invokeinterface 143 1 0
    //   103: ifeq +100 -> 203
    //   106: aload 6
    //   108: astore 5
    //   110: aload 6
    //   112: aload 6
    //   114: ldc 145
    //   116: invokeinterface 149 2 0
    //   121: invokeinterface 153 2 0
    //   126: lstore_2
    //   127: aload 6
    //   129: astore 5
    //   131: aload 7
    //   133: getfield 121	com/tencent/tmassistantsdk/storage/table/BaseLogTable$DataWrapper:idList	Ljava/util/List;
    //   136: lload_2
    //   137: invokestatic 157	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   140: invokeinterface 161 2 0
    //   145: pop
    //   146: aload 6
    //   148: astore 5
    //   150: aload 6
    //   152: aload 6
    //   154: ldc 163
    //   156: invokeinterface 149 2 0
    //   161: invokeinterface 167 2 0
    //   166: astore 9
    //   168: aload 6
    //   170: astore 5
    //   172: aload 7
    //   174: getfield 124	com/tencent/tmassistantsdk/storage/table/BaseLogTable$DataWrapper:dataList	Ljava/util/List;
    //   177: aload 9
    //   179: invokeinterface 161 2 0
    //   184: pop
    //   185: aload 6
    //   187: astore 5
    //   189: aload 6
    //   191: invokeinterface 170 1 0
    //   196: istore 4
    //   198: iload 4
    //   200: ifne -94 -> 106
    //   203: aload 6
    //   205: ifnull +10 -> 215
    //   208: aload 6
    //   210: invokeinterface 173 1 0
    //   215: aload 7
    //   217: astore 5
    //   219: aload 5
    //   221: areturn
    //   222: astore 7
    //   224: aconst_null
    //   225: astore 6
    //   227: aload 6
    //   229: astore 5
    //   231: ldc 12
    //   233: aload 7
    //   235: ldc 175
    //   237: iconst_0
    //   238: anewarray 4	java/lang/Object
    //   241: invokestatic 181	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   244: aload 8
    //   246: astore 5
    //   248: aload 6
    //   250: ifnull -31 -> 219
    //   253: aload 6
    //   255: invokeinterface 173 1 0
    //   260: aconst_null
    //   261: areturn
    //   262: astore 6
    //   264: aconst_null
    //   265: astore 5
    //   267: aload 5
    //   269: ifnull +10 -> 279
    //   272: aload 5
    //   274: invokeinterface 173 1 0
    //   279: aload 6
    //   281: athrow
    //   282: astore 6
    //   284: goto -17 -> 267
    //   287: astore 7
    //   289: goto -62 -> 227
    //   292: aconst_null
    //   293: astore 5
    //   295: goto -237 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	this	BaseLogTable
    //   0	298	1	paramInt	int
    //   126	11	2	l	long
    //   196	3	4	bool	boolean
    //   56	238	5	localObject1	Object
    //   65	189	6	localObject2	Object
    //   262	18	6	localObject3	Object
    //   282	1	6	localObject4	Object
    //   10	206	7	localDataWrapper	BaseLogTable.DataWrapper
    //   222	12	7	localException1	java.lang.Exception
    //   287	1	7	localException2	java.lang.Exception
    //   1	244	8	localObject5	Object
    //   166	12	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   67	87	222	java/lang/Exception
    //   67	87	262	finally
    //   96	106	282	finally
    //   110	127	282	finally
    //   131	146	282	finally
    //   150	168	282	finally
    //   172	185	282	finally
    //   189	198	282	finally
    //   231	244	282	finally
    //   96	106	287	java/lang/Exception
    //   110	127	287	java/lang/Exception
    //   131	146	287	java/lang/Exception
    //   150	168	287	java/lang/Exception
    //   172	185	287	java/lang/Exception
    //   189	198	287	java/lang/Exception
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
    //   1: invokevirtual 77	com/tencent/tmassistantsdk/storage/table/BaseLogTable:getHelper	()Lcom/tencent/tmassistantsdk/storage/helper/SqliteHelper;
    //   4: invokevirtual 83	com/tencent/tmassistantsdk/storage/helper/SqliteHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore_2
    //   8: aload_2
    //   9: invokevirtual 191	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   12: aload_2
    //   13: aload_0
    //   14: invokevirtual 193	com/tencent/tmassistantsdk/storage/table/BaseLogTable:getInsertSQL	()Ljava/lang/String;
    //   17: invokevirtual 197	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   20: astore_3
    //   21: aload_1
    //   22: invokeinterface 43 1 0
    //   27: astore_1
    //   28: aload_1
    //   29: invokeinterface 49 1 0
    //   34: ifeq +44 -> 78
    //   37: aload_3
    //   38: iconst_1
    //   39: aload_1
    //   40: invokeinterface 53 1 0
    //   45: checkcast 199	[B
    //   48: invokevirtual 205	android/database/sqlite/SQLiteStatement:bindBlob	(I[B)V
    //   51: aload_3
    //   52: invokevirtual 209	android/database/sqlite/SQLiteStatement:executeInsert	()J
    //   55: pop2
    //   56: goto -28 -> 28
    //   59: astore_1
    //   60: ldc 12
    //   62: aload_1
    //   63: ldc 175
    //   65: iconst_0
    //   66: anewarray 4	java/lang/Object
    //   69: invokestatic 181	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: aload_2
    //   73: invokevirtual 212	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   76: iconst_0
    //   77: ireturn
    //   78: aload_2
    //   79: invokevirtual 215	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   82: aload_2
    //   83: invokevirtual 212	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   86: iconst_1
    //   87: ireturn
    //   88: astore_1
    //   89: aload_2
    //   90: invokevirtual 212	android/database/sqlite/SQLiteDatabase:endTransaction	()V
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmassistantsdk.storage.table.BaseLogTable
 * JD-Core Version:    0.7.0.1
 */