package com.tencent.shadow.core.b.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;

public class f
  extends SQLiteOpenHelper
{
  private static final Logger a = LoggerFactory.getLogger(f.class);
  
  public f(Context paramContext, String paramString)
  {
    super(paramContext, localStringBuilder.toString(), null, 4);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS shadowPluginManager ( id INTEGER PRIMARY KEY AUTOINCREMENT,hash VARCHAR , filePath VARCHAR, type INTEGER, businessName VARCHAR, partKey VARCHAR, dependsOn VARCHAR, uuid VARCHAR, version VARCHAR, installedTime INTEGER ,odexPath VARCHAR ,libPath VARCHAR ,hostWhiteList VARCHAR );");
  }
  
  /* Error */
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iload_2
    //   1: iconst_2
    //   2: if_icmpge +187 -> 189
    //   5: aload_1
    //   6: invokevirtual 53	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   9: aload_1
    //   10: iconst_1
    //   11: ldc 55
    //   13: iconst_2
    //   14: anewarray 57	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc 59
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: ldc 61
    //   26: aastore
    //   27: ldc 63
    //   29: iconst_1
    //   30: anewarray 57	java/lang/String
    //   33: dup
    //   34: iconst_0
    //   35: ldc 65
    //   37: aastore
    //   38: aconst_null
    //   39: aconst_null
    //   40: aconst_null
    //   41: aconst_null
    //   42: invokevirtual 69	android/database/sqlite/SQLiteDatabase:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore 4
    //   47: new 71	java/util/ArrayList
    //   50: dup
    //   51: invokespecial 72	java/util/ArrayList:<init>	()V
    //   54: astore 5
    //   56: aload 4
    //   58: invokeinterface 78 1 0
    //   63: ifeq +30 -> 93
    //   66: aload 5
    //   68: aload 4
    //   70: aload 4
    //   72: ldc 59
    //   74: invokeinterface 82 2 0
    //   79: invokeinterface 86 2 0
    //   84: invokeinterface 92 2 0
    //   89: pop
    //   90: goto -34 -> 56
    //   93: aload 4
    //   95: invokeinterface 95 1 0
    //   100: aload 5
    //   102: invokeinterface 99 1 0
    //   107: astore 4
    //   109: aload 4
    //   111: invokeinterface 104 1 0
    //   116: ifeq +32 -> 148
    //   119: aload_1
    //   120: ldc 55
    //   122: ldc 106
    //   124: iconst_1
    //   125: anewarray 57	java/lang/String
    //   128: dup
    //   129: iconst_0
    //   130: aload 4
    //   132: invokeinterface 110 1 0
    //   137: checkcast 57	java/lang/String
    //   140: aastore
    //   141: invokevirtual 114	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   144: pop
    //   145: goto -36 -> 109
    //   148: aload_1
    //   149: invokevirtual 117	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   152: goto +23 -> 175
    //   155: astore 4
    //   157: goto +25 -> 182
    //   160: astore 4
    //   162: getstatic 16	com/tencent/shadow/core/b/a/f:a	Lcom/tencent/shadow/core/common/Logger;
    //   165: aload 4
    //   167: invokevirtual 120	android/database/SQLException:getMessage	()Ljava/lang/String;
    //   170: invokeinterface 125 2 0
    //   175: aload_1
    //   176: invokevirtual 128	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   179: goto +10 -> 189
    //   182: aload_1
    //   183: invokevirtual 128	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   186: aload 4
    //   188: athrow
    //   189: iload_2
    //   190: iconst_4
    //   191: if_icmpge +52 -> 243
    //   194: aload_1
    //   195: invokevirtual 53	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   198: aload_1
    //   199: ldc 130
    //   201: invokevirtual 46	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   204: aload_1
    //   205: invokevirtual 117	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   208: aload_1
    //   209: invokevirtual 128	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   212: return
    //   213: astore 4
    //   215: goto +21 -> 236
    //   218: astore 4
    //   220: getstatic 16	com/tencent/shadow/core/b/a/f:a	Lcom/tencent/shadow/core/common/Logger;
    //   223: aload 4
    //   225: invokevirtual 120	android/database/SQLException:getMessage	()Ljava/lang/String;
    //   228: invokeinterface 125 2 0
    //   233: goto -25 -> 208
    //   236: aload_1
    //   237: invokevirtual 128	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   240: aload 4
    //   242: athrow
    //   243: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	f
    //   0	244	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	244	2	paramInt1	int
    //   0	244	3	paramInt2	int
    //   45	86	4	localObject1	java.lang.Object
    //   155	1	4	localObject2	java.lang.Object
    //   160	27	4	localSQLException1	android.database.SQLException
    //   213	1	4	localObject3	java.lang.Object
    //   218	23	4	localSQLException2	android.database.SQLException
    //   54	47	5	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   9	56	155	finally
    //   56	90	155	finally
    //   93	109	155	finally
    //   109	145	155	finally
    //   148	152	155	finally
    //   162	175	155	finally
    //   9	56	160	android/database/SQLException
    //   56	90	160	android/database/SQLException
    //   93	109	160	android/database/SQLException
    //   109	145	160	android/database/SQLException
    //   148	152	160	android/database/SQLException
    //   198	208	213	finally
    //   220	233	213	finally
    //   198	208	218	android/database/SQLException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\live_shopping_manager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.core.b.a.f
 * JD-Core Version:    0.7.0.1
 */