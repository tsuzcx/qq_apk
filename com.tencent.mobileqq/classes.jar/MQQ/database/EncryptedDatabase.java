package mqq.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EncryptedDatabase
{
  private static final String SQL_GET_TABLE_ATTR = "select sql from sqlite_master where type=? and name=?";
  private static final String TAG = "db";
  private SQLiteDatabase.CursorFactory encryptedFactory = new EncryptedDatabase.1(this);
  private final SQLiteOpenHelper mHelper;
  private final Map<String, ArrayList<String>> tableMap = new HashMap();
  
  public EncryptedDatabase(Context paramContext, String paramString, int paramInt)
  {
    SecurityUtile.setKey(paramContext);
    this.mHelper = new EncryptedDatabase.DBHelper(this, paramContext, paramString, paramInt);
  }
  
  private ArrayList<String> analyseTableField(String paramString1, String paramString2)
  {
    paramString1 = paramString1.substring(paramString1.indexOf("(") + 1, paramString1.indexOf(")")).split(",");
    paramString2 = paramString2.toLowerCase();
    ArrayList localArrayList = new ArrayList();
    int j = paramString1.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString = paramString1[i].trim().split(" ");
      if ((arrayOfString.length > 1) && (paramString2.equals(arrayOfString[1].toLowerCase()))) {
        localArrayList.add(arrayOfString[0]);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private String convert(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    String str = paramObject.toString();
    paramObject = str;
    if (str.length() > 0) {
      paramObject = SecurityUtile.encode(str);
    }
    return paramObject;
  }
  
  private ContentValues convertContentValues(String paramString, ContentValues paramContentValues)
  {
    if (paramContentValues != null)
    {
      if (paramContentValues.size() <= 0) {
        return paramContentValues;
      }
      paramString = getTableInfo(paramString);
      if (paramString != null)
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          String str1 = (String)paramString.next();
          if (paramContentValues.containsKey(str1))
          {
            String str2 = (String)paramContentValues.get(str1);
            if ((str2 != null) && (str2.length() > 0)) {
              paramContentValues.put(str1, convert(paramContentValues.get(str1)));
            }
          }
        }
      }
    }
    return paramContentValues;
  }
  
  /* Error */
  private ArrayList<String> getTableInfo(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 28	mqq/database/EncryptedDatabase:tableMap	Ljava/util/Map;
    //   4: aload_1
    //   5: invokeinterface 152 2 0
    //   10: ifne +148 -> 158
    //   13: aconst_null
    //   14: astore_2
    //   15: aconst_null
    //   16: astore_3
    //   17: aload_0
    //   18: getfield 48	mqq/database/EncryptedDatabase:mHelper	Landroid/database/sqlite/SQLiteOpenHelper;
    //   21: invokevirtual 158	android/database/sqlite/SQLiteOpenHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   24: aconst_null
    //   25: ldc 8
    //   27: iconst_2
    //   28: anewarray 57	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: ldc 160
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: aload_1
    //   39: aastore
    //   40: ldc 162
    //   42: invokevirtual 168	android/database/sqlite/SQLiteDatabase:rawQueryWithFactory	(Landroid/database/sqlite/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore 4
    //   47: aload 4
    //   49: ifnull +60 -> 109
    //   52: aload 4
    //   54: astore_3
    //   55: aload 4
    //   57: astore_2
    //   58: aload 4
    //   60: invokeinterface 173 1 0
    //   65: ifeq +44 -> 109
    //   68: aload 4
    //   70: astore_3
    //   71: aload 4
    //   73: astore_2
    //   74: aload_0
    //   75: aload 4
    //   77: iconst_0
    //   78: invokeinterface 177 2 0
    //   83: ldc 179
    //   85: invokespecial 181	mqq/database/EncryptedDatabase:analyseTableField	(Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;
    //   88: astore 5
    //   90: aload 4
    //   92: astore_3
    //   93: aload 4
    //   95: astore_2
    //   96: aload_0
    //   97: getfield 28	mqq/database/EncryptedDatabase:tableMap	Ljava/util/Map;
    //   100: aload_1
    //   101: aload 5
    //   103: invokeinterface 184 3 0
    //   108: pop
    //   109: aload 4
    //   111: ifnull +47 -> 158
    //   114: aload 4
    //   116: astore_2
    //   117: goto +20 -> 137
    //   120: astore_1
    //   121: goto +25 -> 146
    //   124: astore 4
    //   126: aload_2
    //   127: astore_3
    //   128: aload 4
    //   130: invokevirtual 187	java/lang/Exception:printStackTrace	()V
    //   133: aload_2
    //   134: ifnull +24 -> 158
    //   137: aload_2
    //   138: invokeinterface 190 1 0
    //   143: goto +15 -> 158
    //   146: aload_3
    //   147: ifnull +9 -> 156
    //   150: aload_3
    //   151: invokeinterface 190 1 0
    //   156: aload_1
    //   157: athrow
    //   158: aload_0
    //   159: getfield 28	mqq/database/EncryptedDatabase:tableMap	Ljava/util/Map;
    //   162: aload_1
    //   163: invokeinterface 193 2 0
    //   168: checkcast 79	java/util/ArrayList
    //   171: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	EncryptedDatabase
    //   0	172	1	paramString	String
    //   14	124	2	localObject1	Object
    //   16	135	3	localObject2	Object
    //   45	70	4	localCursor	Cursor
    //   124	5	4	localException	java.lang.Exception
    //   88	14	5	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   17	47	120	finally
    //   58	68	120	finally
    //   74	90	120	finally
    //   96	109	120	finally
    //   128	133	120	finally
    //   17	47	124	java/lang/Exception
    //   58	68	124	java/lang/Exception
    //   74	90	124	java/lang/Exception
    //   96	109	124	java/lang/Exception
  }
  
  public void close()
  {
    this.mHelper.close();
  }
  
  public void execSQL(String paramString)
  {
    this.mHelper.getWritableDatabase().execSQL(paramString);
  }
  
  public long insert(String paramString, ContentValues paramContentValues)
  {
    paramContentValues = convertContentValues(paramString, paramContentValues);
    return this.mHelper.getWritableDatabase().insert(paramString, null, paramContentValues);
  }
  
  public Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    return this.mHelper.getReadableDatabase().rawQuery(paramString, paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.database.EncryptedDatabase
 * JD-Core Version:    0.7.0.1
 */