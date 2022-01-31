package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class bq
  extends SQLiteOpenHelper
{
  private static Map<String, bq> a;
  private static final Object b;
  
  static
  {
    AppMethodBeat.i(147314);
    a = new ConcurrentHashMap();
    b = new Object();
    AppMethodBeat.o(147314);
  }
  
  private bq(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, null, 2);
  }
  
  /* Error */
  private int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc 43
    //   5: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokevirtual 47	com/tencent/tencentmap/mapsdk/maps/a/bq:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore 5
    //   14: iload_1
    //   15: ifeq +69 -> 84
    //   18: iload_2
    //   19: ifeq +65 -> 84
    //   22: aload 5
    //   24: ldc 49
    //   26: iconst_1
    //   27: anewarray 51	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: ldc 53
    //   34: aastore
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: invokevirtual 59	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore 5
    //   45: aload 5
    //   47: ifnull +180 -> 227
    //   50: aload 5
    //   52: invokeinterface 65 1 0
    //   57: istore_3
    //   58: iload_3
    //   59: istore 4
    //   61: aload 5
    //   63: ifnull +13 -> 76
    //   66: aload 5
    //   68: invokeinterface 68 1 0
    //   73: iload_3
    //   74: istore 4
    //   76: ldc 43
    //   78: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: iload 4
    //   83: ireturn
    //   84: iload_1
    //   85: ifeq +38 -> 123
    //   88: aload 5
    //   90: ldc 49
    //   92: iconst_1
    //   93: anewarray 51	java/lang/String
    //   96: dup
    //   97: iconst_0
    //   98: ldc 53
    //   100: aastore
    //   101: ldc 70
    //   103: iconst_1
    //   104: anewarray 51	java/lang/String
    //   107: dup
    //   108: iconst_0
    //   109: ldc 72
    //   111: aastore
    //   112: aconst_null
    //   113: aconst_null
    //   114: aconst_null
    //   115: invokevirtual 59	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   118: astore 5
    //   120: goto -75 -> 45
    //   123: aload 5
    //   125: ldc 49
    //   127: iconst_1
    //   128: anewarray 51	java/lang/String
    //   131: dup
    //   132: iconst_0
    //   133: ldc 53
    //   135: aastore
    //   136: ldc 70
    //   138: iconst_1
    //   139: anewarray 51	java/lang/String
    //   142: dup
    //   143: iconst_0
    //   144: ldc 74
    //   146: aastore
    //   147: aconst_null
    //   148: aconst_null
    //   149: aconst_null
    //   150: invokevirtual 59	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   153: astore 5
    //   155: goto -110 -> 45
    //   158: astore 5
    //   160: aconst_null
    //   161: astore 5
    //   163: aload 5
    //   165: ifnull +56 -> 221
    //   168: aload 5
    //   170: invokeinterface 68 1 0
    //   175: iconst_0
    //   176: istore 4
    //   178: goto -102 -> 76
    //   181: astore 5
    //   183: aload 6
    //   185: ifnull +10 -> 195
    //   188: aload 6
    //   190: invokeinterface 68 1 0
    //   195: ldc 43
    //   197: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: aload 5
    //   202: athrow
    //   203: astore 7
    //   205: aload 5
    //   207: astore 6
    //   209: aload 7
    //   211: astore 5
    //   213: goto -30 -> 183
    //   216: astore 6
    //   218: goto -55 -> 163
    //   221: iconst_0
    //   222: istore 4
    //   224: goto -148 -> 76
    //   227: iconst_0
    //   228: istore_3
    //   229: goto -171 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	bq
    //   0	232	1	paramBoolean1	boolean
    //   0	232	2	paramBoolean2	boolean
    //   57	172	3	i	int
    //   59	164	4	j	int
    //   12	142	5	localObject1	Object
    //   158	1	5	localThrowable1	java.lang.Throwable
    //   161	8	5	localObject2	Object
    //   181	25	5	localObject3	Object
    //   211	1	5	localObject4	Object
    //   1	207	6	localObject5	Object
    //   216	1	6	localThrowable2	java.lang.Throwable
    //   203	7	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   8	14	158	java/lang/Throwable
    //   22	45	158	java/lang/Throwable
    //   88	120	158	java/lang/Throwable
    //   123	155	158	java/lang/Throwable
    //   8	14	181	finally
    //   22	45	181	finally
    //   88	120	181	finally
    //   123	155	181	finally
    //   50	58	203	finally
    //   50	58	216	java/lang/Throwable
  }
  
  public static bq a(String paramString)
  {
    AppMethodBeat.i(147304);
    synchronized (b)
    {
      bq localbq = (bq)a.get(paramString);
      Object localObject1 = localbq;
      if (localbq == null)
      {
        if (ac.b())
        {
          localObject1 = "_test_";
          localObject1 = "HalleyAction_" + ac.c() + (String)localObject1 + ac.i() + "_" + paramString + ".db";
          localObject1 = new bq(ac.a(), (String)localObject1, null, 2);
          a.put(paramString, localObject1);
        }
      }
      else
      {
        AppMethodBeat.o(147304);
        return localObject1;
      }
      localObject1 = "_";
    }
  }
  
  public final void a(List<Long> paramList)
  {
    AppMethodBeat.i(147313);
    if (paramList.size() <= 0)
    {
      AppMethodBeat.o(147313);
      return;
    }
    SQLiteDatabase localSQLiteDatabase;
    try
    {
      localSQLiteDatabase = getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("state", "remove");
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        localSQLiteDatabase.update("halley_action_tbl", localContentValues, "key=?", new String[] { String.valueOf(((Long)localIterator.next()).longValue()) });
      }
      paramList = paramList.iterator();
    }
    catch (Exception paramList)
    {
      AppMethodBeat.o(147313);
      return;
    }
    while (paramList.hasNext()) {
      localSQLiteDatabase.delete("halley_action_tbl", "key=?", new String[] { String.valueOf(((Long)paramList.next()).longValue()) });
    }
    if (a(false, true) > 0)
    {
      int i = a(true, false);
      if (i > 0) {}
    }
    try
    {
      localSQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
      try
      {
        label181:
        localSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
        AppMethodBeat.o(147313);
        return;
      }
      catch (SQLException paramList)
      {
        AppMethodBeat.o(147313);
        throw paramList;
      }
      AppMethodBeat.o(147313);
      return;
    }
    catch (SQLException paramList)
    {
      break label181;
    }
  }
  
  /* Error */
  public final boolean a(int paramInt)
  {
    // Byte code:
    //   0: ldc 189
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: iconst_1
    //   7: iconst_1
    //   8: invokespecial 178	com/tencent/tencentmap/mapsdk/maps/a/bq:a	(ZZ)I
    //   11: iload_1
    //   12: if_icmple +50 -> 62
    //   15: aload_0
    //   16: invokevirtual 47	com/tencent/tencentmap/mapsdk/maps/a/bq:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   19: ldc 49
    //   21: aconst_null
    //   22: aconst_null
    //   23: invokevirtual 176	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   26: pop
    //   27: ldc 189
    //   29: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: iconst_1
    //   33: ireturn
    //   34: astore_2
    //   35: aload_0
    //   36: iconst_1
    //   37: iconst_1
    //   38: invokespecial 178	com/tencent/tencentmap/mapsdk/maps/a/bq:a	(ZZ)I
    //   41: iload_1
    //   42: if_icmple +20 -> 62
    //   45: aload_0
    //   46: invokevirtual 47	com/tencent/tencentmap/mapsdk/maps/a/bq:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   49: astore_2
    //   50: aload_2
    //   51: ldc 180
    //   53: invokevirtual 183	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   56: aload_2
    //   57: ldc 185
    //   59: invokevirtual 183	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   62: ldc 189
    //   64: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: iconst_0
    //   68: ireturn
    //   69: astore_2
    //   70: ldc 189
    //   72: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_2
    //   76: athrow
    //   77: astore_2
    //   78: goto -16 -> 62
    //   81: astore_3
    //   82: goto -26 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	bq
    //   0	85	1	paramInt	int
    //   34	1	2	localException	Exception
    //   49	8	2	localSQLiteDatabase	SQLiteDatabase
    //   69	7	2	localSQLException1	SQLException
    //   77	1	2	localThrowable	java.lang.Throwable
    //   81	1	3	localSQLException2	SQLException
    // Exception table:
    //   from	to	target	type
    //   15	27	34	java/lang/Exception
    //   56	62	69	android/database/SQLException
    //   45	50	77	java/lang/Throwable
    //   50	56	77	java/lang/Throwable
    //   56	62	77	java/lang/Throwable
    //   70	77	77	java/lang/Throwable
    //   50	56	81	android/database/SQLException
  }
  
  /* Error */
  public final long b(String paramString)
  {
    // Byte code:
    //   0: ldc 191
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 197	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +12 -> 21
    //   12: ldc 191
    //   14: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: ldc2_w 198
    //   20: lreturn
    //   21: aload_0
    //   22: invokevirtual 47	com/tencent/tencentmap/mapsdk/maps/a/bq:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   25: astore 4
    //   27: new 137	android/content/ContentValues
    //   30: dup
    //   31: invokespecial 138	android/content/ContentValues:<init>	()V
    //   34: astore 5
    //   36: aload 5
    //   38: ldc 201
    //   40: aload_1
    //   41: invokevirtual 143	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload 5
    //   46: ldc 140
    //   48: ldc 72
    //   50: invokevirtual 143	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload 4
    //   55: ldc 49
    //   57: aconst_null
    //   58: aload 5
    //   60: invokevirtual 205	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   63: lstore_2
    //   64: ldc 191
    //   66: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: lload_2
    //   70: lreturn
    //   71: astore_1
    //   72: ldc 191
    //   74: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: ldc2_w 198
    //   80: lreturn
    //   81: astore_1
    //   82: ldc 191
    //   84: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	bq
    //   0	89	1	paramString	String
    //   63	7	2	l	long
    //   25	29	4	localSQLiteDatabase	SQLiteDatabase
    //   34	25	5	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   21	64	71	java/lang/Exception
    //   21	64	81	finally
  }
  
  /* Error */
  public final List<bq.a> b(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 207
    //   5: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 209	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 210	java/util/ArrayList:<init>	()V
    //   15: astore 6
    //   17: aload_0
    //   18: invokevirtual 47	com/tencent/tencentmap/mapsdk/maps/a/bq:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   21: ldc 49
    //   23: aconst_null
    //   24: ldc 70
    //   26: iconst_1
    //   27: anewarray 51	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: ldc 72
    //   34: aastore
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: invokevirtual 59	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   41: astore 4
    //   43: aload 4
    //   45: ifnull +111 -> 156
    //   48: aload 4
    //   50: invokeinterface 65 1 0
    //   55: iload_1
    //   56: invokestatic 216	java/lang/Math:min	(II)I
    //   59: istore_2
    //   60: aload 4
    //   62: invokeinterface 219 1 0
    //   67: ifeq +89 -> 156
    //   70: iconst_0
    //   71: istore_1
    //   72: aload 6
    //   74: new 6	com/tencent/tencentmap/mapsdk/maps/a/bq$a
    //   77: dup
    //   78: aload 4
    //   80: aload 4
    //   82: ldc 53
    //   84: invokeinterface 223 2 0
    //   89: invokeinterface 227 2 0
    //   94: aload 4
    //   96: aload 4
    //   98: ldc 201
    //   100: invokeinterface 223 2 0
    //   105: invokeinterface 231 2 0
    //   110: aload 4
    //   112: aload 4
    //   114: ldc 140
    //   116: invokeinterface 223 2 0
    //   121: invokeinterface 231 2 0
    //   126: invokespecial 234	com/tencent/tencentmap/mapsdk/maps/a/bq$a:<init>	(JLjava/lang/String;Ljava/lang/String;)V
    //   129: invokeinterface 237 2 0
    //   134: pop
    //   135: iload_1
    //   136: iconst_1
    //   137: iadd
    //   138: istore_1
    //   139: iload_1
    //   140: iload_2
    //   141: if_icmpge +15 -> 156
    //   144: aload 4
    //   146: invokeinterface 240 1 0
    //   151: istore_3
    //   152: iload_3
    //   153: ifne -81 -> 72
    //   156: aload 4
    //   158: ifnull +10 -> 168
    //   161: aload 4
    //   163: invokeinterface 68 1 0
    //   168: ldc 207
    //   170: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: aload 6
    //   175: areturn
    //   176: astore 4
    //   178: aconst_null
    //   179: astore 4
    //   181: aload 4
    //   183: ifnull -15 -> 168
    //   186: aload 4
    //   188: invokeinterface 68 1 0
    //   193: goto -25 -> 168
    //   196: astore 4
    //   198: aload 5
    //   200: ifnull +10 -> 210
    //   203: aload 5
    //   205: invokeinterface 68 1 0
    //   210: ldc 207
    //   212: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   215: aload 4
    //   217: athrow
    //   218: astore 6
    //   220: aload 4
    //   222: astore 5
    //   224: aload 6
    //   226: astore 4
    //   228: goto -30 -> 198
    //   231: astore 5
    //   233: goto -52 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	bq
    //   0	236	1	paramInt	int
    //   59	83	2	i	int
    //   151	2	3	bool	boolean
    //   41	121	4	localCursor	android.database.Cursor
    //   176	1	4	localThrowable1	java.lang.Throwable
    //   179	8	4	localObject1	Object
    //   196	25	4	localObject2	Object
    //   226	1	4	localObject3	Object
    //   1	222	5	localObject4	Object
    //   231	1	5	localThrowable2	java.lang.Throwable
    //   15	159	6	localArrayList	java.util.ArrayList
    //   218	7	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   17	43	176	java/lang/Throwable
    //   17	43	196	finally
    //   48	70	218	finally
    //   72	135	218	finally
    //   144	152	218	finally
    //   48	70	231	java/lang/Throwable
    //   72	135	231	java/lang/Throwable
    //   144	152	231	java/lang/Throwable
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(147305);
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
      AppMethodBeat.o(147305);
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      AppMethodBeat.o(147305);
      throw paramSQLiteDatabase;
    }
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(147307);
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
      try
      {
        label11:
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
        AppMethodBeat.o(147307);
        return;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        AppMethodBeat.o(147307);
        throw paramSQLiteDatabase;
      }
    }
    catch (Exception paramSQLiteDatabase)
    {
      AppMethodBeat.o(147307);
      return;
    }
    catch (SQLException localSQLException)
    {
      break label11;
    }
  }
  
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(147306);
    super.onOpen(paramSQLiteDatabase);
    try
    {
      int i = paramSQLiteDatabase.getVersion();
      if (i != 0)
      {
        if (i < 2)
        {
          onUpgrade(paramSQLiteDatabase, i, 2);
          AppMethodBeat.o(147306);
          return;
        }
        if (i > 2) {
          onDowngrade(paramSQLiteDatabase, i, 2);
        }
      }
      AppMethodBeat.o(147306);
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      AppMethodBeat.o(147306);
    }
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(147308);
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
      try
      {
        label12:
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
        AppMethodBeat.o(147308);
        return;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        AppMethodBeat.o(147308);
        throw paramSQLiteDatabase;
      }
    }
    catch (Exception paramSQLiteDatabase)
    {
      AppMethodBeat.o(147308);
      return;
    }
    catch (SQLException localSQLException)
    {
      break label12;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.bq
 * JD-Core Version:    0.7.0.1
 */