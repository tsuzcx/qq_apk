package com.tencent.threadpool.b;

import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.d.a;

public final class b
  extends SQLiteOpenHelper
  implements d
{
  private SQLiteDatabase ahBi;
  
  public b(Context paramContext)
  {
    super(paramContext, "Scheduler.db", null, 1);
    AppMethodBeat.i(183214);
    try
    {
      this.ahBi = getWritableDatabase();
      AppMethodBeat.o(183214);
      return;
    }
    catch (Exception paramContext)
    {
      com.tencent.threadpool.d.ahAq.e("ExperienceStorage", "%s", new Object[] { paramContext.toString() });
      AppMethodBeat.o(183214);
    }
  }
  
  /* Error */
  public final void E(java.util.Collection<a.a> paramCollection)
  {
    // Byte code:
    //   0: ldc 62
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 33	com/tencent/threadpool/b/b:ahBi	Landroid/database/sqlite/SQLiteDatabase;
    //   9: ifnull +12 -> 21
    //   12: aload_1
    //   13: invokeinterface 68 1 0
    //   18: ifgt +9 -> 27
    //   21: ldc 62
    //   23: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: return
    //   27: aload_0
    //   28: getfield 33	com/tencent/threadpool/b/b:ahBi	Landroid/database/sqlite/SQLiteDatabase;
    //   31: invokevirtual 74	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   34: aload_1
    //   35: invokeinterface 78 1 0
    //   40: astore_1
    //   41: aload_1
    //   42: invokeinterface 84 1 0
    //   47: ifeq +191 -> 238
    //   50: aload_1
    //   51: invokeinterface 88 1 0
    //   56: checkcast 90	com/tencent/threadpool/b/a$a
    //   59: astore_2
    //   60: new 92	com/tencent/threadpool/b/a$b
    //   63: dup
    //   64: aload_2
    //   65: getfield 96	com/tencent/threadpool/b/a$a:name	Ljava/lang/String;
    //   68: aload_2
    //   69: getfield 100	com/tencent/threadpool/b/a$a:ahBb	J
    //   72: aload_2
    //   73: getfield 103	com/tencent/threadpool/b/a$a:hto	J
    //   76: ldc 105
    //   78: invokespecial 108	com/tencent/threadpool/b/a$b:<init>	(Ljava/lang/String;JJLjava/lang/String;)V
    //   81: astore_2
    //   82: aload_2
    //   83: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   86: putfield 117	com/tencent/threadpool/b/a$b:timestamp	J
    //   89: aload_0
    //   90: getfield 33	com/tencent/threadpool/b/b:ahBi	Landroid/database/sqlite/SQLiteDatabase;
    //   93: astore_3
    //   94: new 119	android/content/ContentValues
    //   97: dup
    //   98: invokespecial 121	android/content/ContentValues:<init>	()V
    //   101: astore 4
    //   103: aload 4
    //   105: ldc 123
    //   107: aload_2
    //   108: getfield 124	com/tencent/threadpool/b/a$b:name	Ljava/lang/String;
    //   111: invokevirtual 128	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: aload 4
    //   116: ldc 130
    //   118: aload_2
    //   119: getfield 133	com/tencent/threadpool/b/a$b:MMg	J
    //   122: invokestatic 139	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   125: invokevirtual 142	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   128: aload 4
    //   130: ldc 144
    //   132: aload_2
    //   133: getfield 146	com/tencent/threadpool/b/a$b:time	J
    //   136: invokestatic 139	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   139: invokevirtual 142	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   142: aload 4
    //   144: ldc 147
    //   146: aload_2
    //   147: getfield 117	com/tencent/threadpool/b/a$b:timestamp	J
    //   150: invokestatic 139	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   153: invokevirtual 142	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   156: aload 4
    //   158: ldc 149
    //   160: aload_2
    //   161: getfield 152	com/tencent/threadpool/b/a$b:rate	F
    //   164: invokestatic 157	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   167: invokevirtual 160	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Float;)V
    //   170: aload 4
    //   172: ldc 162
    //   174: aload_2
    //   175: getfield 165	com/tencent/threadpool/b/a$b:ahBh	Ljava/lang/String;
    //   178: invokevirtual 128	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: aload_3
    //   182: ldc 167
    //   184: aconst_null
    //   185: aload 4
    //   187: invokevirtual 171	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   190: pop2
    //   191: goto -150 -> 41
    //   194: astore_1
    //   195: getstatic 42	com/tencent/threadpool/d:ahAq	Lcom/tencent/threadpool/d$a;
    //   198: ldc 44
    //   200: ldc 46
    //   202: iconst_1
    //   203: anewarray 48	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: aload_1
    //   209: invokevirtual 52	java/lang/Exception:toString	()Ljava/lang/String;
    //   212: aastore
    //   213: invokeinterface 58 4 0
    //   218: aload_0
    //   219: getfield 33	com/tencent/threadpool/b/b:ahBi	Landroid/database/sqlite/SQLiteDatabase;
    //   222: invokevirtual 174	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   225: aload_0
    //   226: getfield 33	com/tencent/threadpool/b/b:ahBi	Landroid/database/sqlite/SQLiteDatabase;
    //   229: invokevirtual 177	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   232: ldc 62
    //   234: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: return
    //   238: aload_0
    //   239: getfield 33	com/tencent/threadpool/b/b:ahBi	Landroid/database/sqlite/SQLiteDatabase;
    //   242: invokevirtual 174	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   245: aload_0
    //   246: getfield 33	com/tencent/threadpool/b/b:ahBi	Landroid/database/sqlite/SQLiteDatabase;
    //   249: invokevirtual 177	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   252: ldc 62
    //   254: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: return
    //   258: astore_1
    //   259: aload_0
    //   260: getfield 33	com/tencent/threadpool/b/b:ahBi	Landroid/database/sqlite/SQLiteDatabase;
    //   263: invokevirtual 174	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   266: aload_0
    //   267: getfield 33	com/tencent/threadpool/b/b:ahBi	Landroid/database/sqlite/SQLiteDatabase;
    //   270: invokevirtual 177	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   273: ldc 62
    //   275: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   278: aload_1
    //   279: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	b
    //   0	280	1	paramCollection	java.util.Collection<a.a>
    //   59	116	2	localObject	Object
    //   93	89	3	localSQLiteDatabase	SQLiteDatabase
    //   101	85	4	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   27	41	194	java/lang/Exception
    //   41	191	194	java/lang/Exception
    //   27	41	258	finally
    //   41	191	258	finally
    //   195	218	258	finally
  }
  
  public final void delete(long paramLong)
  {
    AppMethodBeat.i(183217);
    if (this.ahBi == null)
    {
      AppMethodBeat.o(183217);
      return;
    }
    if (paramLong <= 0L) {}
    for (paramLong = System.currentTimeMillis();; paramLong = System.currentTimeMillis() + paramLong) {
      try
      {
        this.ahBi.delete("DisposedTask", "timestamp<?", new String[] { String.valueOf(paramLong) });
        AppMethodBeat.o(183217);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.threadpool.d.ahAq.e("ExperienceStorage", "%s", new Object[] { localException.toString() });
        AppMethodBeat.o(183217);
      }
    }
  }
  
  /* Error */
  public final java.util.Map<String, a.a> jZf()
  {
    // Byte code:
    //   0: ldc 195
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 197	java/util/HashMap
    //   8: dup
    //   9: invokespecial 198	java/util/HashMap:<init>	()V
    //   12: astore 8
    //   14: aload_0
    //   15: getfield 33	com/tencent/threadpool/b/b:ahBi	Landroid/database/sqlite/SQLiteDatabase;
    //   18: ifnonnull +11 -> 29
    //   21: ldc 195
    //   23: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload 8
    //   28: areturn
    //   29: aload_0
    //   30: getfield 33	com/tencent/threadpool/b/b:ahBi	Landroid/database/sqlite/SQLiteDatabase;
    //   33: ldc 167
    //   35: iconst_3
    //   36: anewarray 186	java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: ldc 123
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: ldc 200
    //   48: iconst_1
    //   49: anewarray 48	java/lang/Object
    //   52: dup
    //   53: iconst_0
    //   54: ldc 149
    //   56: aastore
    //   57: invokestatic 204	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   60: aastore
    //   61: dup
    //   62: iconst_2
    //   63: ldc 200
    //   65: iconst_1
    //   66: anewarray 48	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: ldc 130
    //   73: aastore
    //   74: invokestatic 204	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   77: aastore
    //   78: aconst_null
    //   79: aconst_null
    //   80: ldc 123
    //   82: aconst_null
    //   83: aconst_null
    //   84: invokevirtual 208	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   87: astore 6
    //   89: aload 6
    //   91: astore 5
    //   93: aload 6
    //   95: invokeinterface 213 1 0
    //   100: pop
    //   101: aload 6
    //   103: astore 5
    //   105: aload 6
    //   107: invokeinterface 216 1 0
    //   112: ifne +156 -> 268
    //   115: aload 6
    //   117: astore 5
    //   119: new 8	com/tencent/threadpool/b/b$a
    //   122: dup
    //   123: aload_0
    //   124: aload 6
    //   126: invokespecial 219	com/tencent/threadpool/b/b$a:<init>	(Lcom/tencent/threadpool/b/b;Landroid/database/Cursor;)V
    //   129: astore 7
    //   131: aload 6
    //   133: astore 5
    //   135: aload 7
    //   137: iconst_0
    //   138: invokevirtual 223	com/tencent/threadpool/b/b$a:getString	(I)Ljava/lang/String;
    //   141: astore 9
    //   143: aload 6
    //   145: astore 5
    //   147: aload 7
    //   149: iconst_1
    //   150: invokevirtual 227	com/tencent/threadpool/b/b$a:getDouble	(I)D
    //   153: dstore_1
    //   154: aload 6
    //   156: astore 5
    //   158: aload 7
    //   160: iconst_2
    //   161: invokevirtual 227	com/tencent/threadpool/b/b$a:getDouble	(I)D
    //   164: dstore_3
    //   165: aload 6
    //   167: astore 5
    //   169: new 90	com/tencent/threadpool/b/a$a
    //   172: dup
    //   173: aload 9
    //   175: dload_1
    //   176: d2f
    //   177: dload_3
    //   178: d2l
    //   179: invokespecial 230	com/tencent/threadpool/b/a$a:<init>	(Ljava/lang/String;FJ)V
    //   182: astore 7
    //   184: aload 6
    //   186: astore 5
    //   188: aload 8
    //   190: aload 7
    //   192: getfield 96	com/tencent/threadpool/b/a$a:name	Ljava/lang/String;
    //   195: aload 7
    //   197: invokeinterface 235 3 0
    //   202: pop
    //   203: aload 6
    //   205: astore 5
    //   207: aload 6
    //   209: invokeinterface 238 1 0
    //   214: pop
    //   215: goto -114 -> 101
    //   218: astore 7
    //   220: aload 6
    //   222: astore 5
    //   224: getstatic 42	com/tencent/threadpool/d:ahAq	Lcom/tencent/threadpool/d$a;
    //   227: ldc 44
    //   229: ldc 46
    //   231: iconst_1
    //   232: anewarray 48	java/lang/Object
    //   235: dup
    //   236: iconst_0
    //   237: aload 7
    //   239: invokevirtual 52	java/lang/Exception:toString	()Ljava/lang/String;
    //   242: aastore
    //   243: invokeinterface 58 4 0
    //   248: aload 6
    //   250: ifnull +10 -> 260
    //   253: aload 6
    //   255: invokeinterface 241 1 0
    //   260: ldc 195
    //   262: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   265: aload 8
    //   267: areturn
    //   268: aload 6
    //   270: ifnull -10 -> 260
    //   273: aload 6
    //   275: invokeinterface 241 1 0
    //   280: goto -20 -> 260
    //   283: astore 6
    //   285: aconst_null
    //   286: astore 5
    //   288: aload 5
    //   290: ifnull +10 -> 300
    //   293: aload 5
    //   295: invokeinterface 241 1 0
    //   300: ldc 195
    //   302: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   305: aload 6
    //   307: athrow
    //   308: astore 6
    //   310: goto -22 -> 288
    //   313: astore 7
    //   315: aconst_null
    //   316: astore 6
    //   318: goto -98 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	this	b
    //   153	23	1	d1	double
    //   164	14	3	d2	double
    //   91	203	5	localCursor1	Cursor
    //   87	187	6	localCursor2	Cursor
    //   283	23	6	localObject1	Object
    //   308	1	6	localObject2	Object
    //   316	1	6	localObject3	Object
    //   129	67	7	localObject4	Object
    //   218	20	7	localException1	Exception
    //   313	1	7	localException2	Exception
    //   12	254	8	localHashMap	java.util.HashMap
    //   141	33	9	str	String
    // Exception table:
    //   from	to	target	type
    //   93	101	218	java/lang/Exception
    //   105	115	218	java/lang/Exception
    //   119	131	218	java/lang/Exception
    //   135	143	218	java/lang/Exception
    //   147	154	218	java/lang/Exception
    //   158	165	218	java/lang/Exception
    //   169	184	218	java/lang/Exception
    //   188	203	218	java/lang/Exception
    //   207	215	218	java/lang/Exception
    //   29	89	283	finally
    //   93	101	308	finally
    //   105	115	308	finally
    //   119	131	308	finally
    //   135	143	308	finally
    //   147	154	308	finally
    //   158	165	308	finally
    //   169	184	308	finally
    //   188	203	308	finally
    //   207	215	308	finally
    //   224	248	308	finally
    //   29	89	313	java/lang/Exception
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(183215);
    if (paramSQLiteDatabase == null)
    {
      AppMethodBeat.o(183215);
      return;
    }
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS DisposedTask(_ID INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL, taskName TEXT NOT NULL, threadTime LONG NOT NULL, time LONG NOT NULL, rate REAL NOT NULL, timestamp LONG NOT NULL, scheduler TEXT NOT NULL )");
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS timestampIndex ON DisposedTask(timestamp)");
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS taskNameIndex ON DisposedTask(taskName)");
    AppMethodBeat.o(183215);
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public final class a
    extends CursorWrapper
  {
    a(Cursor paramCursor)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.b.b
 * JD-Core Version:    0.7.0.1
 */