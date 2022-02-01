package com.tencent.mm.plugin.priority.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.util.c;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteDoneException;
import com.tencent.wcdb.database.SQLiteStatement;

public final class b
{
  public SQLiteDatabase wKU;
  public SQLiteStatement wKV;
  public SQLiteStatement wKW;
  public SQLiteStatement wKX;
  
  public b(String paramString)
  {
    AppMethodBeat.i(87799);
    if (this.wKU != null)
    {
      ad.w("MicroMsg.Priority.PriorityDB", "before initDB, pre DB is not close, why?");
      this.wKU.close();
    }
    String str = com.tencent.mm.vfs.q.B(new e(paramString, "MicroMsgPriority.db").fOK());
    long l1 = System.currentTimeMillis();
    paramString = new StringBuilder();
    com.tencent.mm.kernel.g.ajA();
    paramString = com.tencent.mm.b.g.getMessageDigest((a.aiq() + u.aAm() + com.tencent.mm.compatible.deviceinfo.q.cH(true)).getBytes()).substring(0, 7);
    this.wKU = SQLiteDatabase.openOrCreateDatabase(str, paramString.getBytes(), null, null);
    Object localObject = this.wKU;
    long l2 = ((SQLiteDatabase)localObject).acquireNativeConnectionHandle("initPriority", false, false);
    PriorityJni.nativeInit(l2);
    ((SQLiteDatabase)localObject).releaseNativeConnection(l2, null);
    this.wKU.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (type INTEGER PRIMARY KEY, version INTEGER);", new Object[] { "PriorityConfig" }));
    this.wKV = this.wKU.compileStatement(String.format("SELECT version FROM %s WHERE type=?;", new Object[] { "PriorityConfig" }));
    this.wKW = this.wKU.compileStatement(String.format("INSERT OR REPLACE INTO %s (type, version) VALUES (?, ?);", new Object[] { "PriorityConfig" }));
    this.wKX = this.wKU.compileStatement(String.format("DELETE FROM %s WHERE type=?", new Object[] { "PriorityConfig" }));
    l2 = System.currentTimeMillis();
    str = bt.a(i.aYo(str), 100.0D);
    localObject = c.LgD;
    if (c.fNK()) {}
    for (;;)
    {
      ad.i("MicroMsg.Priority.PriorityDB", "initDB index params %d %s %s", new Object[] { Long.valueOf(l2 - l1), str, paramString });
      AppMethodBeat.o(87799);
      return;
      paramString = "";
    }
  }
  
  public final long ad(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(87800);
    this.wKV.bindLong(1, paramLong1);
    try
    {
      paramLong1 = this.wKV.simpleQueryForLong();
      AppMethodBeat.o(87800);
      return paramLong1;
    }
    catch (SQLiteDoneException localSQLiteDoneException)
    {
      AppMethodBeat.o(87800);
    }
    return paramLong2;
  }
  
  public final void ae(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(87801);
    this.wKW.bindLong(1, paramLong1);
    this.wKW.bindLong(2, paramLong2);
    this.wKW.execute();
    AppMethodBeat.o(87801);
  }
  
  public final boolean akg(String paramString)
  {
    AppMethodBeat.i(87805);
    paramString = this.wKU.rawQuery("SELECT 1 FROM sqlite_master WHERE type='table' AND name=?;", new String[] { paramString });
    boolean bool = paramString.moveToNext();
    paramString.close();
    AppMethodBeat.o(87805);
    return bool;
  }
  
  public final int auv(String paramString)
  {
    AppMethodBeat.i(87804);
    paramString = this.wKU.rawQuery(String.format("SELECT count(*) FROM %s;", new Object[] { paramString }), null);
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
  
  public final void auw(String paramString)
  {
    AppMethodBeat.i(87806);
    ad.v("MicroMsg.Priority.PriorityDB", "dropTable: %s", new Object[] { paramString });
    this.wKU.execSQL(String.format("DROP TABLE %s", new Object[] { paramString }));
    AppMethodBeat.o(87806);
  }
  
  public final SQLiteStatement compileStatement(String paramString)
  {
    AppMethodBeat.i(87803);
    ad.v("MicroMsg.Priority.PriorityDB", "compileStatement sql = %s", new Object[] { paramString });
    paramString = this.wKU.compileStatement(paramString);
    AppMethodBeat.o(87803);
    return paramString;
  }
  
  public final void execSQL(String paramString)
  {
    AppMethodBeat.i(87807);
    ad.v("MicroMsg.Priority.PriorityDB", "execSQL: execute sql = %s", new Object[] { paramString });
    this.wKU.execSQL(paramString);
    AppMethodBeat.o(87807);
  }
  
  public final void execSQL(String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(87808);
    ad.v("MicroMsg.Priority.PriorityDB", "execSQL: execute sql = %s", new Object[] { paramString });
    this.wKU.execSQL(paramString, paramArrayOfObject);
    AppMethodBeat.o(87808);
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(87802);
    ad.v("MicroMsg.Priority.PriorityDB", "rawQuery: execute sql = %s", new Object[] { paramString });
    paramString = this.wKU.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, paramString, paramArrayOfString, null);
    AppMethodBeat.o(87802);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.b
 * JD-Core Version:    0.7.0.1
 */