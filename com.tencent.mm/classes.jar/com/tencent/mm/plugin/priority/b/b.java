package com.tencent.mm.plugin.priority.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteDoneException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.io.File;

public final class b
{
  public SQLiteDatabase ptp;
  public SQLiteStatement ptq;
  public SQLiteStatement ptt;
  public SQLiteStatement ptu;
  
  public b(String paramString)
  {
    AppMethodBeat.i(54888);
    if (this.ptp != null)
    {
      ab.w("MicroMsg.Priority.PriorityDB", "before initDB, pre DB is not close, why?");
      this.ptp.close();
    }
    paramString = new File(paramString, "MicroMsgPriority.db").getAbsolutePath();
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.RJ();
    this.ptp = SQLiteDatabase.openOrCreateDatabase(paramString, com.tencent.mm.a.g.w((a.QC() + r.Zn() + q.bP(true)).getBytes()).substring(0, 7).getBytes(), null, null);
    this.ptp.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (type INTEGER PRIMARY KEY, version INTEGER);", new Object[] { "PriorityConfig" }));
    this.ptq = this.ptp.compileStatement(String.format("SELECT version FROM %s WHERE type=?;", new Object[] { "PriorityConfig" }));
    this.ptt = this.ptp.compileStatement(String.format("INSERT OR REPLACE INTO %s (type, version) VALUES (?, ?);", new Object[] { "PriorityConfig" }));
    this.ptu = this.ptp.compileStatement(String.format("DELETE FROM %s WHERE type=?", new Object[] { "PriorityConfig" }));
    ab.i("MicroMsg.Priority.PriorityDB", "initDB index params %d %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), bo.b(e.avI(paramString), 100.0D) });
    AppMethodBeat.o(54888);
  }
  
  public final boolean OS(String paramString)
  {
    AppMethodBeat.i(54894);
    paramString = this.ptp.rawQuery("SELECT 1 FROM sqlite_master WHERE type='table' AND name=?;", new String[] { paramString });
    boolean bool = paramString.moveToNext();
    paramString.close();
    AppMethodBeat.o(54894);
    return bool;
  }
  
  public final long T(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(54889);
    this.ptq.bindLong(1, paramLong1);
    try
    {
      paramLong1 = this.ptq.simpleQueryForLong();
      AppMethodBeat.o(54889);
      return paramLong1;
    }
    catch (SQLiteDoneException localSQLiteDoneException)
    {
      AppMethodBeat.o(54889);
    }
    return paramLong2;
  }
  
  public final void U(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(54890);
    this.ptt.bindLong(1, paramLong1);
    this.ptt.bindLong(2, paramLong2);
    this.ptt.execute();
    AppMethodBeat.o(54890);
  }
  
  public final int WS(String paramString)
  {
    AppMethodBeat.i(54893);
    paramString = this.ptp.rawQuery(String.format("SELECT count(*) FROM %s;", new Object[] { paramString }), null);
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
      AppMethodBeat.o(54893);
    }
  }
  
  public final void WT(String paramString)
  {
    AppMethodBeat.i(54895);
    ab.v("MicroMsg.Priority.PriorityDB", "dropTable: %s", new Object[] { paramString });
    this.ptp.execSQL(String.format("DROP TABLE %s", new Object[] { paramString }));
    AppMethodBeat.o(54895);
  }
  
  public final SQLiteStatement compileStatement(String paramString)
  {
    AppMethodBeat.i(54892);
    ab.v("MicroMsg.Priority.PriorityDB", "compileStatement sql = %s", new Object[] { paramString });
    paramString = this.ptp.compileStatement(paramString);
    AppMethodBeat.o(54892);
    return paramString;
  }
  
  public final void execSQL(String paramString)
  {
    AppMethodBeat.i(54896);
    ab.v("MicroMsg.Priority.PriorityDB", "execSQL: execute sql = %s", new Object[] { paramString });
    this.ptp.execSQL(paramString);
    AppMethodBeat.o(54896);
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(54891);
    ab.v("MicroMsg.Priority.PriorityDB", "rawQuery: execute sql = %s", new Object[] { paramString });
    paramString = this.ptp.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, paramString, paramArrayOfString, null);
    AppMethodBeat.o(54891);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.b.b
 * JD-Core Version:    0.7.0.1
 */