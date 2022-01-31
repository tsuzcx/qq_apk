package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class ca$a
  extends SQLiteOpenHelper
{
  public ca$a(ca paramca, Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, null, paramInt);
  }
  
  private void a()
  {
    AppMethodBeat.i(147330);
    try
    {
      localArrayList = new ArrayList();
      i = an.a.a("apn_cache_num", 1, 100, 8);
      localSQLiteDatabase = getWritableDatabase();
    }
    catch (Exception localException)
    {
      ArrayList localArrayList;
      SQLiteDatabase localSQLiteDatabase;
      Object localObject1;
      label80:
      String str;
      boolean bool;
      label141:
      AppMethodBeat.o(147330);
      return;
    }
    try
    {
      localObject1 = localSQLiteDatabase.query("halley_schedule_tbl", new String[] { "apn" }, null, null, null, null, "key");
      if (localObject1 == null) {}
    }
    finally
    {
      Object localObject2 = null;
      label218:
      if (localObject2 != null) {
        localObject2.close();
      }
      AppMethodBeat.o(147330);
    }
    try
    {
      i = ((Cursor)localObject1).getCount() - i;
      if ((i <= 0) || (!((Cursor)localObject1).moveToFirst())) {
        break label141;
      }
    }
    finally
    {
      break label218;
      i -= 1;
      break label80;
    }
    str = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("apn"));
    if ((!TextUtils.isEmpty(str)) && (!localArrayList.contains(str))) {
      localArrayList.add(str);
    }
    bool = ((Cursor)localObject1).moveToNext();
    if ((!bool) || (i <= 0))
    {
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
      if (localArrayList.size() > 0)
      {
        localObject1 = localArrayList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          localSQLiteDatabase.delete("halley_schedule_tbl", "apn=?", new String[] { (String)((Iterator)localObject1).next() });
        }
      }
      AppMethodBeat.o(147330);
      return;
    }
  }
  
  public final void a(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      AppMethodBeat.i(147328);
      try
      {
        SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
        int i = localSQLiteDatabase.delete("halley_schedule_tbl", "apn=?", new String[] { paramString });
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("apn", paramString);
        localContentValues.put("result", paramArrayOfByte);
        localContentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        if ((-1L != localSQLiteDatabase.insert("halley_schedule_tbl", null, localContentValues)) && (i <= 0)) {
          a();
        }
        AppMethodBeat.o(147328);
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          AppMethodBeat.o(147328);
        }
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public final byte[] a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 161
    //   4: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokevirtual 164	com/tencent/tencentmap/mapsdk/maps/a/ca$a:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   11: astore_3
    //   12: aload_3
    //   13: ldc 43
    //   15: aconst_null
    //   16: ldc 108
    //   18: iconst_1
    //   19: anewarray 45	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: aload_1
    //   25: aastore
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: invokevirtual 55	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore_1
    //   33: aload_1
    //   34: ifnull +57 -> 91
    //   37: aload_1
    //   38: invokeinterface 65 1 0
    //   43: ifeq +48 -> 91
    //   46: aload_1
    //   47: aload_1
    //   48: ldc 132
    //   50: invokeinterface 69 2 0
    //   55: invokeinterface 168 2 0
    //   60: astore_3
    //   61: aload_3
    //   62: invokestatic 173	com/tencent/tencentmap/mapsdk/maps/a/dd:a	([B)Z
    //   65: istore_2
    //   66: iload_2
    //   67: ifne +24 -> 91
    //   70: aload_1
    //   71: ifnull +9 -> 80
    //   74: aload_1
    //   75: invokeinterface 94 1 0
    //   80: ldc 161
    //   82: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload_3
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: areturn
    //   91: aload_1
    //   92: ifnull +9 -> 101
    //   95: aload_1
    //   96: invokeinterface 94 1 0
    //   101: ldc 161
    //   103: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aconst_null
    //   107: astore_1
    //   108: goto -21 -> 87
    //   111: astore_3
    //   112: aconst_null
    //   113: astore_1
    //   114: aload_1
    //   115: ifnull +9 -> 124
    //   118: aload_1
    //   119: invokeinterface 94 1 0
    //   124: ldc 161
    //   126: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aload_3
    //   130: athrow
    //   131: astore_1
    //   132: goto -31 -> 101
    //   135: astore_1
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    //   140: astore_3
    //   141: goto -27 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	a
    //   0	144	1	paramString	String
    //   65	2	2	bool	boolean
    //   11	75	3	localObject1	Object
    //   111	19	3	localObject2	Object
    //   140	1	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   12	33	111	finally
    //   7	12	131	java/lang/Throwable
    //   74	80	131	java/lang/Throwable
    //   95	101	131	java/lang/Throwable
    //   118	124	131	java/lang/Throwable
    //   124	131	131	java/lang/Throwable
    //   2	7	135	finally
    //   7	12	135	finally
    //   74	80	135	finally
    //   80	85	135	finally
    //   95	101	135	finally
    //   101	106	135	finally
    //   118	124	135	finally
    //   124	131	135	finally
    //   37	66	140	finally
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(147331);
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_schedule_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,result BLOB,timestamp INTEGER);");
      AppMethodBeat.o(147331);
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      AppMethodBeat.o(147331);
    }
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(147333);
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_schedule_tbl");
      try
      {
        label11:
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_schedule_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,result BLOB,timestamp INTEGER);");
        AppMethodBeat.o(147333);
        return;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        AppMethodBeat.o(147333);
        throw paramSQLiteDatabase;
      }
    }
    catch (Exception paramSQLiteDatabase)
    {
      AppMethodBeat.o(147333);
      return;
    }
    catch (SQLException localSQLException)
    {
      break label11;
    }
  }
  
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(147332);
    super.onOpen(paramSQLiteDatabase);
    try
    {
      int i = paramSQLiteDatabase.getVersion();
      if (i != 0)
      {
        if (i <= 0)
        {
          onUpgrade(paramSQLiteDatabase, i, 1);
          AppMethodBeat.o(147332);
          return;
        }
        if (i > 1) {
          onDowngrade(paramSQLiteDatabase, i, 1);
        }
      }
      AppMethodBeat.o(147332);
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      AppMethodBeat.o(147332);
    }
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(147334);
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_schedule_tbl");
      try
      {
        label11:
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_schedule_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,result BLOB,timestamp INTEGER);");
        AppMethodBeat.o(147334);
        return;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        AppMethodBeat.o(147334);
        throw paramSQLiteDatabase;
      }
    }
    catch (Exception paramSQLiteDatabase)
    {
      AppMethodBeat.o(147334);
      return;
    }
    catch (SQLException localSQLException)
    {
      break label11;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ca.a
 * JD-Core Version:    0.7.0.1
 */