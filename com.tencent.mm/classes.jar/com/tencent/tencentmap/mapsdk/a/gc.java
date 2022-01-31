package com.tencent.tencentmap.mapsdk.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class gc
  extends SQLiteOpenHelper
{
  private static Map<String, gc> a = new ConcurrentHashMap();
  private static final Object b = new Object();
  
  private gc(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, null, 2);
  }
  
  /* Error */
  private int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: invokevirtual 36	com/tencent/tencentmap/mapsdk/a/gc:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore 4
    //   9: iload_1
    //   10: ifeq +57 -> 67
    //   13: iload_2
    //   14: ifeq +53 -> 67
    //   17: aload 4
    //   19: ldc 38
    //   21: iconst_1
    //   22: anewarray 40	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: ldc 42
    //   29: aastore
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: invokevirtual 48	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   38: astore 4
    //   40: aload 4
    //   42: ifnull +155 -> 197
    //   45: aload 4
    //   47: invokeinterface 54 1 0
    //   52: istore_3
    //   53: aload 4
    //   55: ifnull +10 -> 65
    //   58: aload 4
    //   60: invokeinterface 57 1 0
    //   65: iload_3
    //   66: ireturn
    //   67: iload_1
    //   68: ifeq +38 -> 106
    //   71: aload 4
    //   73: ldc 38
    //   75: iconst_1
    //   76: anewarray 40	java/lang/String
    //   79: dup
    //   80: iconst_0
    //   81: ldc 42
    //   83: aastore
    //   84: ldc 59
    //   86: iconst_1
    //   87: anewarray 40	java/lang/String
    //   90: dup
    //   91: iconst_0
    //   92: ldc 61
    //   94: aastore
    //   95: aconst_null
    //   96: aconst_null
    //   97: aconst_null
    //   98: invokevirtual 48	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   101: astore 4
    //   103: goto -63 -> 40
    //   106: aload 4
    //   108: ldc 38
    //   110: iconst_1
    //   111: anewarray 40	java/lang/String
    //   114: dup
    //   115: iconst_0
    //   116: ldc 42
    //   118: aastore
    //   119: ldc 59
    //   121: iconst_1
    //   122: anewarray 40	java/lang/String
    //   125: dup
    //   126: iconst_0
    //   127: ldc 63
    //   129: aastore
    //   130: aconst_null
    //   131: aconst_null
    //   132: aconst_null
    //   133: invokevirtual 48	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   136: astore 4
    //   138: goto -98 -> 40
    //   141: astore 4
    //   143: aconst_null
    //   144: astore 4
    //   146: aload 4
    //   148: ifnull +47 -> 195
    //   151: aload 4
    //   153: invokeinterface 57 1 0
    //   158: iconst_0
    //   159: ireturn
    //   160: astore 4
    //   162: aload 5
    //   164: ifnull +10 -> 174
    //   167: aload 5
    //   169: invokeinterface 57 1 0
    //   174: aload 4
    //   176: athrow
    //   177: astore 6
    //   179: aload 4
    //   181: astore 5
    //   183: aload 6
    //   185: astore 4
    //   187: goto -25 -> 162
    //   190: astore 5
    //   192: goto -46 -> 146
    //   195: iconst_0
    //   196: ireturn
    //   197: iconst_0
    //   198: istore_3
    //   199: goto -146 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	gc
    //   0	202	1	paramBoolean1	boolean
    //   0	202	2	paramBoolean2	boolean
    //   52	147	3	i	int
    //   7	130	4	localObject1	Object
    //   141	1	4	localThrowable1	java.lang.Throwable
    //   144	8	4	localObject2	Object
    //   160	20	4	localObject3	Object
    //   185	1	4	localObject4	Object
    //   1	181	5	localObject5	Object
    //   190	1	5	localThrowable2	java.lang.Throwable
    //   177	7	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   3	9	141	java/lang/Throwable
    //   17	40	141	java/lang/Throwable
    //   71	103	141	java/lang/Throwable
    //   106	138	141	java/lang/Throwable
    //   3	9	160	finally
    //   17	40	160	finally
    //   71	103	160	finally
    //   106	138	160	finally
    //   45	53	177	finally
    //   45	53	190	java/lang/Throwable
  }
  
  public static gc a(String paramString)
  {
    for (;;)
    {
      synchronized (b)
      {
        gc localgc = (gc)a.get(paramString);
        localObject1 = localgc;
        if (localgc == null)
        {
          if (em.b())
          {
            localObject1 = "_test_";
            localObject1 = "HalleyAction_" + em.c() + (String)localObject1 + em.i() + "_" + paramString + ".db";
            localObject1 = new gc(em.a(), (String)localObject1, null, 2);
            a.put(paramString, localObject1);
          }
        }
        else {
          return localObject1;
        }
      }
      Object localObject1 = "_";
    }
  }
  
  public final void a(List<Long> paramList)
  {
    if (paramList.size() <= 0) {}
    for (;;)
    {
      return;
      try
      {
        SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("state", "remove");
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          localSQLiteDatabase.update("halley_action_tbl", localContentValues, "key=?", new String[] { String.valueOf(((Long)localIterator.next()).longValue()) });
        }
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          localSQLiteDatabase.delete("halley_action_tbl", "key=?", new String[] { String.valueOf(((Long)paramList.next()).longValue()) });
        }
        if (a(false, true) <= 0) {
          continue;
        }
        int i = a(true, false);
        if (i > 0) {
          continue;
        }
        try
        {
          localSQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
          try
          {
            label164:
            localSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
            return;
          }
          catch (SQLException paramList)
          {
            throw paramList;
          }
        }
        catch (SQLException paramList)
        {
          break label164;
        }
        return;
      }
      catch (Exception paramList) {}
    }
  }
  
  /* Error */
  public final boolean a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: iconst_1
    //   3: invokespecial 166	com/tencent/tencentmap/mapsdk/a/gc:a	(ZZ)I
    //   6: iload_1
    //   7: if_icmple +45 -> 52
    //   10: aload_0
    //   11: invokevirtual 36	com/tencent/tencentmap/mapsdk/a/gc:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   14: ldc 38
    //   16: aconst_null
    //   17: aconst_null
    //   18: invokevirtual 164	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   21: pop
    //   22: iconst_1
    //   23: ireturn
    //   24: astore_2
    //   25: aload_0
    //   26: iconst_1
    //   27: iconst_1
    //   28: invokespecial 166	com/tencent/tencentmap/mapsdk/a/gc:a	(ZZ)I
    //   31: iload_1
    //   32: if_icmple +20 -> 52
    //   35: aload_0
    //   36: invokevirtual 36	com/tencent/tencentmap/mapsdk/a/gc:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   39: astore_2
    //   40: aload_2
    //   41: ldc 168
    //   43: invokevirtual 171	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   46: aload_2
    //   47: ldc 173
    //   49: invokevirtual 171	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   52: iconst_0
    //   53: ireturn
    //   54: astore_2
    //   55: aload_2
    //   56: athrow
    //   57: astore_2
    //   58: goto -6 -> 52
    //   61: astore_3
    //   62: goto -16 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	gc
    //   0	65	1	paramInt	int
    //   24	1	2	localException	Exception
    //   39	8	2	localSQLiteDatabase	SQLiteDatabase
    //   54	2	2	localSQLException1	SQLException
    //   57	1	2	localThrowable	java.lang.Throwable
    //   61	1	3	localSQLException2	SQLException
    // Exception table:
    //   from	to	target	type
    //   10	22	24	java/lang/Exception
    //   46	52	54	android/database/SQLException
    //   35	40	57	java/lang/Throwable
    //   40	46	57	java/lang/Throwable
    //   46	52	57	java/lang/Throwable
    //   55	57	57	java/lang/Throwable
    //   40	46	61	android/database/SQLException
  }
  
  /* Error */
  public final long b(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 183	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +7 -> 11
    //   7: ldc2_w 184
    //   10: lreturn
    //   11: aload_0
    //   12: invokevirtual 36	com/tencent/tencentmap/mapsdk/a/gc:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore 4
    //   17: new 125	android/content/ContentValues
    //   20: dup
    //   21: invokespecial 126	android/content/ContentValues:<init>	()V
    //   24: astore 5
    //   26: aload 5
    //   28: ldc 187
    //   30: aload_1
    //   31: invokevirtual 131	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload 5
    //   36: ldc 128
    //   38: ldc 61
    //   40: invokevirtual 131	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload 4
    //   45: ldc 38
    //   47: aconst_null
    //   48: aload 5
    //   50: invokevirtual 191	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   53: lstore_2
    //   54: lload_2
    //   55: lreturn
    //   56: astore_1
    //   57: aload_1
    //   58: athrow
    //   59: astore_1
    //   60: ldc2_w 184
    //   63: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	gc
    //   0	64	1	paramString	String
    //   53	2	2	l	long
    //   15	29	4	localSQLiteDatabase	SQLiteDatabase
    //   24	25	5	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   11	54	56	finally
    //   11	54	59	java/lang/Exception
  }
  
  /* Error */
  public final List<gc.a> b(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 194	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 195	java/util/ArrayList:<init>	()V
    //   10: astore 6
    //   12: aload_0
    //   13: invokevirtual 36	com/tencent/tencentmap/mapsdk/a/gc:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: ldc 38
    //   18: aconst_null
    //   19: ldc 59
    //   21: iconst_1
    //   22: anewarray 40	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: ldc 61
    //   29: aastore
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: invokevirtual 48	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore 4
    //   38: aload 4
    //   40: ifnull +111 -> 151
    //   43: aload 4
    //   45: invokeinterface 54 1 0
    //   50: iload_1
    //   51: invokestatic 201	java/lang/Math:min	(II)I
    //   54: istore_2
    //   55: aload 4
    //   57: invokeinterface 204 1 0
    //   62: ifeq +89 -> 151
    //   65: iconst_0
    //   66: istore_1
    //   67: aload 6
    //   69: new 6	com/tencent/tencentmap/mapsdk/a/gc$a
    //   72: dup
    //   73: aload 4
    //   75: aload 4
    //   77: ldc 42
    //   79: invokeinterface 208 2 0
    //   84: invokeinterface 212 2 0
    //   89: aload 4
    //   91: aload 4
    //   93: ldc 187
    //   95: invokeinterface 208 2 0
    //   100: invokeinterface 216 2 0
    //   105: aload 4
    //   107: aload 4
    //   109: ldc 128
    //   111: invokeinterface 208 2 0
    //   116: invokeinterface 216 2 0
    //   121: invokespecial 219	com/tencent/tencentmap/mapsdk/a/gc$a:<init>	(JLjava/lang/String;Ljava/lang/String;)V
    //   124: invokeinterface 222 2 0
    //   129: pop
    //   130: iload_1
    //   131: iconst_1
    //   132: iadd
    //   133: istore_1
    //   134: iload_1
    //   135: iload_2
    //   136: if_icmpge +15 -> 151
    //   139: aload 4
    //   141: invokeinterface 225 1 0
    //   146: istore_3
    //   147: iload_3
    //   148: ifne -81 -> 67
    //   151: aload 4
    //   153: ifnull +10 -> 163
    //   156: aload 4
    //   158: invokeinterface 57 1 0
    //   163: aload 6
    //   165: areturn
    //   166: astore 4
    //   168: aconst_null
    //   169: astore 4
    //   171: aload 4
    //   173: ifnull -10 -> 163
    //   176: aload 4
    //   178: invokeinterface 57 1 0
    //   183: aload 6
    //   185: areturn
    //   186: astore 4
    //   188: aload 5
    //   190: ifnull +10 -> 200
    //   193: aload 5
    //   195: invokeinterface 57 1 0
    //   200: aload 4
    //   202: athrow
    //   203: astore 6
    //   205: aload 4
    //   207: astore 5
    //   209: aload 6
    //   211: astore 4
    //   213: goto -25 -> 188
    //   216: astore 5
    //   218: goto -47 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	gc
    //   0	221	1	paramInt	int
    //   54	83	2	i	int
    //   146	2	3	bool	boolean
    //   36	121	4	localCursor	android.database.Cursor
    //   166	1	4	localThrowable1	java.lang.Throwable
    //   169	8	4	localObject1	Object
    //   186	20	4	localObject2	Object
    //   211	1	4	localObject3	Object
    //   1	207	5	localObject4	Object
    //   216	1	5	localThrowable2	java.lang.Throwable
    //   10	174	6	localArrayList	java.util.ArrayList
    //   203	7	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   12	38	166	java/lang/Throwable
    //   12	38	186	finally
    //   43	65	203	finally
    //   67	130	203	finally
    //   139	147	203	finally
    //   43	65	216	java/lang/Throwable
    //   67	130	216	java/lang/Throwable
    //   139	147	216	java/lang/Throwable
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      throw paramSQLiteDatabase;
    }
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
      try
      {
        label6:
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
        return;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        throw paramSQLiteDatabase;
      }
    }
    catch (Exception paramSQLiteDatabase) {}catch (SQLException localSQLException)
    {
      break label6;
    }
  }
  
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onOpen(paramSQLiteDatabase);
    try
    {
      int i = paramSQLiteDatabase.getVersion();
      if (i != 0)
      {
        if (i < 2)
        {
          onUpgrade(paramSQLiteDatabase, i, 2);
          return;
        }
        if (i > 2)
        {
          onDowngrade(paramSQLiteDatabase, i, 2);
          return;
        }
      }
    }
    catch (Exception paramSQLiteDatabase) {}
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
      try
      {
        label6:
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
        return;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        throw paramSQLiteDatabase;
      }
    }
    catch (Exception paramSQLiteDatabase) {}catch (SQLException localSQLException)
    {
      break label6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.gc
 * JD-Core Version:    0.7.0.1
 */