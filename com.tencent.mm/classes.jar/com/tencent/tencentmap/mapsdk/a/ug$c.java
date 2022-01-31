package com.tencent.tencentmap.mapsdk.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;

final class ug$c
  extends SQLiteOpenHelper
{
  private SQLiteDatabase a = null;
  
  public ug$c(ug paramug, Context paramContext)
  {
    super(paramContext, "Cache.db", null, 1);
    if (Build.VERSION.SDK_INT > 10)
    {
      this.a.enableWriteAheadLogging();
      return;
    }
    this.a.setLockingEnabled(true);
  }
  
  private static void a(String paramString, SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + paramString + " (tile TEXT PRIMARY KEY UNIQUE,version TEXT,style TEXT,md5 TEXT,data BLOB )");
  }
  
  private static String b(ue.a parama)
  {
    switch (ug.1.a[parama.ordinal()])
    {
    default: 
      return "";
    case 2: 
      return "tct";
    case 1: 
      return "wmt";
    }
    return "stt";
  }
  
  private static String b(uf paramuf)
  {
    switch (ug.1.a[paramuf.m().ordinal()])
    {
    default: 
      return null;
    case 2: 
      return paramuf.d() + "-" + paramuf.b() + "-" + paramuf.c() + "-zh-" + paramuf.n();
    case 1: 
      return paramuf.d() + "-" + paramuf.b() + "-" + paramuf.c() + "-" + tn.q() + "-" + paramuf.n();
    }
    return paramuf.d() + "-" + paramuf.b() + "-" + paramuf.c();
  }
  
  private boolean c(uf paramuf)
  {
    localObject = null;
    Cursor localCursor = null;
    boolean bool2 = true;
    boolean bool1 = true;
    String str = b(paramuf);
    str = "select count(*) as ct from " + b(paramuf.m()) + " where " + "tile" + " = '" + str + "'";
    paramuf = localCursor;
    do
    {
      for (;;)
      {
        try
        {
          localCursor = this.a.rawQuery(str, null);
          if (localCursor == null) {
            continue;
          }
          paramuf = localCursor;
          localObject = localCursor;
          if (localCursor.getCount() <= 0) {
            continue;
          }
          paramuf = localCursor;
          localObject = localCursor;
          localCursor.moveToFirst();
          paramuf = localCursor;
          localObject = localCursor;
          int i = localCursor.getInt(localCursor.getColumnIndex("ct"));
          if (i <= 0) {
            continue;
          }
          bool2 = bool1;
          if (localCursor != null)
          {
            localCursor.close();
            bool2 = bool1;
          }
        }
        catch (Throwable localThrowable)
        {
          localObject = paramuf;
          new StringBuilder("tileExist error:").append(localThrowable.toString());
          if (paramuf == null) {
            continue;
          }
          paramuf.close();
          return true;
        }
        finally
        {
          if (localObject == null) {
            continue;
          }
          ((Cursor)localObject).close();
        }
        return bool2;
        bool1 = false;
      }
    } while (localCursor == null);
    localCursor.close();
    return true;
  }
  
  /* Error */
  public final uh a(uf paramuf)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/tencent/tencentmap/mapsdk/a/ug$c:a	Landroid/database/sqlite/SQLiteDatabase;
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 42	java/lang/StringBuilder
    //   12: dup
    //   13: ldc 164
    //   15: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: aload_1
    //   19: invokevirtual 92	com/tencent/tencentmap/mapsdk/a/uf:m	()Lcom/tencent/tencentmap/mapsdk/a/ue$a;
    //   22: invokestatic 125	com/tencent/tencentmap/mapsdk/a/ug$c:b	(Lcom/tencent/tencentmap/mapsdk/a/ue$a;)Ljava/lang/String;
    //   25: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 166
    //   30: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore_2
    //   37: aload_0
    //   38: getfield 18	com/tencent/tencentmap/mapsdk/a/ug$c:a	Landroid/database/sqlite/SQLiteDatabase;
    //   41: aload_2
    //   42: iconst_1
    //   43: anewarray 168	java/lang/String
    //   46: dup
    //   47: iconst_0
    //   48: aload_1
    //   49: invokestatic 121	com/tencent/tencentmap/mapsdk/a/ug$c:b	(Lcom/tencent/tencentmap/mapsdk/a/uf;)Ljava/lang/String;
    //   52: aastore
    //   53: invokevirtual 137	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   56: astore_2
    //   57: aload_2
    //   58: ifnull +102 -> 160
    //   61: aload_2
    //   62: astore_1
    //   63: aload_2
    //   64: invokeinterface 142 1 0
    //   69: ifle +91 -> 160
    //   72: aload_2
    //   73: astore_1
    //   74: aload_2
    //   75: invokeinterface 145 1 0
    //   80: pop
    //   81: aload_2
    //   82: astore_1
    //   83: aload_2
    //   84: aload_2
    //   85: ldc 170
    //   87: invokeinterface 151 2 0
    //   92: invokeinterface 174 2 0
    //   97: astore_3
    //   98: aload_2
    //   99: astore_1
    //   100: aload_2
    //   101: aload_2
    //   102: ldc 176
    //   104: invokeinterface 151 2 0
    //   109: invokeinterface 180 2 0
    //   114: astore 4
    //   116: aload_2
    //   117: astore_1
    //   118: new 182	com/tencent/tencentmap/mapsdk/a/uh
    //   121: dup
    //   122: aload_3
    //   123: aload 4
    //   125: invokestatic 185	com/tencent/tencentmap/mapsdk/a/ug:a	([BLjava/lang/String;)[B
    //   128: aload_2
    //   129: aload_2
    //   130: ldc 187
    //   132: invokeinterface 151 2 0
    //   137: invokeinterface 155 2 0
    //   142: aload 4
    //   144: invokespecial 190	com/tencent/tencentmap/mapsdk/a/uh:<init>	([BILjava/lang/String;)V
    //   147: astore_3
    //   148: aload_2
    //   149: ifnull +9 -> 158
    //   152: aload_2
    //   153: invokeinterface 158 1 0
    //   158: aload_3
    //   159: areturn
    //   160: aload_2
    //   161: ifnull +9 -> 170
    //   164: aload_2
    //   165: invokeinterface 158 1 0
    //   170: new 182	com/tencent/tencentmap/mapsdk/a/uh
    //   173: dup
    //   174: aconst_null
    //   175: invokestatic 193	com/tencent/tencentmap/mapsdk/a/tp:b	()I
    //   178: ldc 79
    //   180: invokespecial 190	com/tencent/tencentmap/mapsdk/a/uh:<init>	([BILjava/lang/String;)V
    //   183: areturn
    //   184: astore_3
    //   185: aconst_null
    //   186: astore_2
    //   187: aload_2
    //   188: astore_1
    //   189: new 42	java/lang/StringBuilder
    //   192: dup
    //   193: ldc 195
    //   195: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   198: aload_3
    //   199: invokevirtual 161	java/lang/Throwable:toString	()Ljava/lang/String;
    //   202: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_2
    //   207: ifnull -37 -> 170
    //   210: aload_2
    //   211: invokeinterface 158 1 0
    //   216: goto -46 -> 170
    //   219: astore_2
    //   220: aconst_null
    //   221: astore_1
    //   222: aload_1
    //   223: ifnull +9 -> 232
    //   226: aload_1
    //   227: invokeinterface 158 1 0
    //   232: aload_2
    //   233: athrow
    //   234: astore_2
    //   235: goto -13 -> 222
    //   238: astore_3
    //   239: goto -52 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	c
    //   0	242	1	paramuf	uf
    //   36	175	2	localObject1	Object
    //   219	14	2	localObject2	Object
    //   234	1	2	localObject3	Object
    //   97	62	3	localObject4	Object
    //   184	15	3	localThrowable1	Throwable
    //   238	1	3	localThrowable2	Throwable
    //   114	29	4	str	String
    // Exception table:
    //   from	to	target	type
    //   37	57	184	java/lang/Throwable
    //   37	57	219	finally
    //   63	72	234	finally
    //   74	81	234	finally
    //   83	98	234	finally
    //   100	116	234	finally
    //   118	148	234	finally
    //   189	206	234	finally
    //   63	72	238	java/lang/Throwable
    //   74	81	238	java/lang/Throwable
    //   83	98	238	java/lang/Throwable
    //   100	116	238	java/lang/Throwable
    //   118	148	238	java/lang/Throwable
  }
  
  public final boolean a(ue.a parama)
  {
    if (this.a == null) {
      return false;
    }
    parama = "delete  from " + b(parama);
    try
    {
      this.a.execSQL(parama);
      return true;
    }
    catch (Throwable parama)
    {
      new StringBuilder("cleanCache Error:").append(parama.toString());
    }
    return false;
  }
  
  public final boolean a(uf paramuf, byte[] paramArrayOfByte)
  {
    if (this.a == null) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject = ug.a(paramArrayOfByte);
        byte[] arrayOfByte = ug.b(paramArrayOfByte, (String)localObject);
        paramArrayOfByte = new ContentValues();
        paramArrayOfByte.put("tile", b(paramuf));
        paramArrayOfByte.put("data", arrayOfByte);
        paramArrayOfByte.put("md5", (String)localObject);
        localObject = paramuf.m();
        if (localObject == ue.a.b) {
          paramArrayOfByte.put("style", Integer.valueOf(tp.e()));
        }
        if (localObject == ue.a.a) {
          paramArrayOfByte.put("style", Integer.valueOf(tp.a()));
        }
        paramArrayOfByte.put("version", Integer.valueOf(paramuf.l()));
        long l = this.a.insert(b(paramuf.m()), null, paramArrayOfByte);
        if (l != -1L) {
          return true;
        }
      }
      catch (Throwable paramuf)
      {
        new StringBuilder("putBitmap Error:").append(paramuf.toString());
      }
    }
    return false;
  }
  
  public final boolean a(uf paramuf, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (this.a == null) {}
    for (;;)
    {
      return false;
      try
      {
        ContentValues localContentValues = new ContentValues();
        String str1 = b(paramuf);
        localContentValues.put("version", Integer.valueOf(paramuf.l()));
        if ((!paramBoolean) && (paramArrayOfByte != null))
        {
          String str2 = ug.a(paramArrayOfByte);
          paramArrayOfByte = ug.b(paramArrayOfByte, str2);
          localContentValues.put("md5", str2);
          localContentValues.put("data", paramArrayOfByte);
        }
        int i = this.a.update(b(paramuf.m()), localContentValues, "tile = ? ", new String[] { str1 });
        if (i > 0) {
          return true;
        }
      }
      catch (Throwable paramuf)
      {
        new StringBuilder("updateBitmap Error:").append(paramuf.toString());
      }
    }
    return false;
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    a("tct", paramSQLiteDatabase);
    a("wmt", paramSQLiteDatabase);
    a("stt", paramSQLiteDatabase);
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS  tct");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS  wmt");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS  stt");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ug.c
 * JD-Core Version:    0.7.0.1
 */