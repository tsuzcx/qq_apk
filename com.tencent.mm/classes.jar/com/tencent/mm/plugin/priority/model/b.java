package com.tencent.mm.plugin.priority.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.util.c;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteDoneException;
import com.tencent.wcdb.database.SQLiteStatement;

public final class b
{
  public SQLiteDatabase vDO;
  public SQLiteStatement vDP;
  public SQLiteStatement vDQ;
  public SQLiteStatement vDR;
  
  public b(String paramString)
  {
    AppMethodBeat.i(87799);
    if (this.vDO != null)
    {
      ac.w("MicroMsg.Priority.PriorityDB", "before initDB, pre DB is not close, why?");
      this.vDO.close();
    }
    String str = com.tencent.mm.vfs.q.B(new e(paramString, "MicroMsgPriority.db").fxV());
    long l1 = System.currentTimeMillis();
    paramString = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    paramString = com.tencent.mm.b.g.getMessageDigest((a.afE() + u.axw() + com.tencent.mm.compatible.deviceinfo.q.cF(true)).getBytes()).substring(0, 7);
    this.vDO = SQLiteDatabase.openOrCreateDatabase(str, paramString.getBytes(), null, null);
    SQLiteDatabase localSQLiteDatabase = this.vDO;
    long l2 = localSQLiteDatabase.acquireNativeConnectionHandle("initPriority", false, false);
    PriorityJni.nativeInit(l2);
    localSQLiteDatabase.releaseNativeConnection(l2, null);
    this.vDO.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (type INTEGER PRIMARY KEY, version INTEGER);", new Object[] { "PriorityConfig" }));
    this.vDP = this.vDO.compileStatement(String.format("SELECT version FROM %s WHERE type=?;", new Object[] { "PriorityConfig" }));
    this.vDQ = this.vDO.compileStatement(String.format("INSERT OR REPLACE INTO %s (type, version) VALUES (?, ?);", new Object[] { "PriorityConfig" }));
    this.vDR = this.vDO.compileStatement(String.format("DELETE FROM %s WHERE type=?", new Object[] { "PriorityConfig" }));
    l2 = System.currentTimeMillis();
    str = bs.a(i.aSp(str), 100.0D);
    if (c.fwW()) {}
    for (;;)
    {
      ac.i("MicroMsg.Priority.PriorityDB", "initDB index params %d %s %s", new Object[] { Long.valueOf(l2 - l1), str, paramString });
      AppMethodBeat.o(87799);
      return;
      paramString = "";
    }
  }
  
  public final long ab(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(87800);
    this.vDP.bindLong(1, paramLong1);
    try
    {
      paramLong1 = this.vDP.simpleQueryForLong();
      AppMethodBeat.o(87800);
      return paramLong1;
    }
    catch (SQLiteDoneException localSQLiteDoneException)
    {
      AppMethodBeat.o(87800);
    }
    return paramLong2;
  }
  
  public final void ac(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(87801);
    this.vDQ.bindLong(1, paramLong1);
    this.vDQ.bindLong(2, paramLong2);
    this.vDQ.execute();
    AppMethodBeat.o(87801);
  }
  
  public final boolean afI(String paramString)
  {
    AppMethodBeat.i(87805);
    paramString = this.vDO.rawQuery("SELECT 1 FROM sqlite_master WHERE type='table' AND name=?;", new String[] { paramString });
    boolean bool = paramString.moveToNext();
    paramString.close();
    AppMethodBeat.o(87805);
    return bool;
  }
  
  public final int app(String paramString)
  {
    AppMethodBeat.i(87804);
    paramString = this.vDO.rawQuery(String.format("SELECT count(*) FROM %s;", new Object[] { paramString }), null);
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
  
  public final void apq(String paramString)
  {
    AppMethodBeat.i(87806);
    ac.v("MicroMsg.Priority.PriorityDB", "dropTable: %s", new Object[] { paramString });
    this.vDO.execSQL(String.format("DROP TABLE %s", new Object[] { paramString }));
    AppMethodBeat.o(87806);
  }
  
  public final SQLiteStatement compileStatement(String paramString)
  {
    AppMethodBeat.i(87803);
    ac.v("MicroMsg.Priority.PriorityDB", "compileStatement sql = %s", new Object[] { paramString });
    paramString = this.vDO.compileStatement(paramString);
    AppMethodBeat.o(87803);
    return paramString;
  }
  
  public final void execSQL(String paramString)
  {
    AppMethodBeat.i(87807);
    ac.v("MicroMsg.Priority.PriorityDB", "execSQL: execute sql = %s", new Object[] { paramString });
    this.vDO.execSQL(paramString);
    AppMethodBeat.o(87807);
  }
  
  public final void execSQL(String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(87808);
    ac.v("MicroMsg.Priority.PriorityDB", "execSQL: execute sql = %s", new Object[] { paramString });
    this.vDO.execSQL(paramString, paramArrayOfObject);
    AppMethodBeat.o(87808);
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(87802);
    ac.v("MicroMsg.Priority.PriorityDB", "rawQuery: execute sql = %s", new Object[] { paramString });
    paramString = this.vDO.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, paramString, paramArrayOfString, null);
    AppMethodBeat.o(87802);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.b
 * JD-Core Version:    0.7.0.1
 */