package com.tencent.mm.plugin.priority.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.v;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.util.c;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteDoneException;
import com.tencent.wcdb.database.SQLiteStatement;

public final class b
{
  public SQLiteDatabase xaI;
  public SQLiteStatement xaJ;
  public SQLiteStatement xaK;
  public SQLiteStatement xaL;
  
  public b(String paramString)
  {
    AppMethodBeat.i(87799);
    if (this.xaI != null)
    {
      ae.w("MicroMsg.Priority.PriorityDB", "before initDB, pre DB is not close, why?");
      this.xaI.close();
    }
    String str = w.B(new k(paramString, "MicroMsgPriority.db").fTh());
    long l1 = System.currentTimeMillis();
    paramString = new StringBuilder();
    com.tencent.mm.kernel.g.ajP();
    paramString = com.tencent.mm.b.g.getMessageDigest((a.aiF() + v.aAC() + q.cH(true)).getBytes()).substring(0, 7);
    this.xaI = SQLiteDatabase.openOrCreateDatabase(str, paramString.getBytes(), null, null);
    Object localObject = this.xaI;
    long l2 = ((SQLiteDatabase)localObject).acquireNativeConnectionHandle("initPriority", false, false);
    PriorityJni.nativeInit(l2);
    ((SQLiteDatabase)localObject).releaseNativeConnection(l2, null);
    this.xaI.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (type INTEGER PRIMARY KEY, version INTEGER);", new Object[] { "PriorityConfig" }));
    this.xaJ = this.xaI.compileStatement(String.format("SELECT version FROM %s WHERE type=?;", new Object[] { "PriorityConfig" }));
    this.xaK = this.xaI.compileStatement(String.format("INSERT OR REPLACE INTO %s (type, version) VALUES (?, ?);", new Object[] { "PriorityConfig" }));
    this.xaL = this.xaI.compileStatement(String.format("DELETE FROM %s WHERE type=?", new Object[] { "PriorityConfig" }));
    l2 = System.currentTimeMillis();
    str = bu.a(o.aZR(str), 100.0D);
    localObject = c.LDf;
    if (c.fSf()) {}
    for (;;)
    {
      ae.i("MicroMsg.Priority.PriorityDB", "initDB index params %d %s %s", new Object[] { Long.valueOf(l2 - l1), str, paramString });
      AppMethodBeat.o(87799);
      return;
      paramString = "";
    }
  }
  
  public final long ac(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(87800);
    this.xaJ.bindLong(1, paramLong1);
    try
    {
      paramLong1 = this.xaJ.simpleQueryForLong();
      AppMethodBeat.o(87800);
      return paramLong1;
    }
    catch (SQLiteDoneException localSQLiteDoneException)
    {
      AppMethodBeat.o(87800);
    }
    return paramLong2;
  }
  
  public final void ad(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(87801);
    this.xaK.bindLong(1, paramLong1);
    this.xaK.bindLong(2, paramLong2);
    this.xaK.execute();
    AppMethodBeat.o(87801);
  }
  
  public final boolean ale(String paramString)
  {
    AppMethodBeat.i(87805);
    paramString = this.xaI.rawQuery("SELECT 1 FROM sqlite_master WHERE type='table' AND name=?;", new String[] { paramString });
    boolean bool = paramString.moveToNext();
    paramString.close();
    AppMethodBeat.o(87805);
    return bool;
  }
  
  public final int avK(String paramString)
  {
    AppMethodBeat.i(87804);
    paramString = this.xaI.rawQuery(String.format("SELECT count(*) FROM %s;", new Object[] { paramString }), null);
    try
    {
      if (paramString.moveToNext())
      {
        int i = paramString.getInt(0);
        return i;
      }
      return 0;
    }
    finally
    {
      paramString.close();
      AppMethodBeat.o(87804);
    }
  }
  
  public final void avL(String paramString)
  {
    AppMethodBeat.i(87806);
    ae.v("MicroMsg.Priority.PriorityDB", "dropTable: %s", new Object[] { paramString });
    this.xaI.execSQL(String.format("DROP TABLE %s", new Object[] { paramString }));
    AppMethodBeat.o(87806);
  }
  
  public final SQLiteStatement compileStatement(String paramString)
  {
    AppMethodBeat.i(87803);
    ae.v("MicroMsg.Priority.PriorityDB", "compileStatement sql = %s", new Object[] { paramString });
    paramString = this.xaI.compileStatement(paramString);
    AppMethodBeat.o(87803);
    return paramString;
  }
  
  public final void execSQL(String paramString)
  {
    AppMethodBeat.i(87807);
    ae.v("MicroMsg.Priority.PriorityDB", "execSQL: execute sql = %s", new Object[] { paramString });
    this.xaI.execSQL(paramString);
    AppMethodBeat.o(87807);
  }
  
  public final void execSQL(String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(87808);
    ae.v("MicroMsg.Priority.PriorityDB", "execSQL: execute sql = %s", new Object[] { paramString });
    this.xaI.execSQL(paramString, paramArrayOfObject);
    AppMethodBeat.o(87808);
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(87802);
    ae.v("MicroMsg.Priority.PriorityDB", "rawQuery: execute sql = %s", new Object[] { paramString });
    paramString = this.xaI.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, paramString, paramArrayOfString, null);
    AppMethodBeat.o(87802);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.b
 * JD-Core Version:    0.7.0.1
 */