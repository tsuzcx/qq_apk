package com.tencent.mm.plugin.priority.model.a.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.protocal.protobuf.hh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.wcdb.database.SQLiteStatement;

public final class c
{
  private b vDu;
  private SQLiteStatement vEb;
  public SQLiteStatement vEk;
  public SQLiteStatement vEl;
  private SQLiteStatement vEm;
  private SQLiteStatement vEn;
  public SQLiteStatement vEo;
  public SQLiteStatement vEp;
  
  public c(b paramb)
  {
    AppMethodBeat.i(87834);
    this.vDu = paramb;
    if (this.vDu.ab(2L, 0L) != 4L)
    {
      if (this.vDu.afI("C2CMsgAutoDownloadFile")) {
        this.vDu.apq("C2CMsgAutoDownloadFile");
      }
      this.vDu.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (id TEXT, fromuser TEXT, realuser TEXT, restype INTEGER, createtime INTEGER, reason INTEGER, status INTEGER, downloadtime INTEGER, msgsvrid LONG, filesize INTEGER, fileext TEXT, opentime INTEGER, priority FLOAT, prioritytype INTEGER, fileid TEXT, PRIMARY KEY(id, msgsvrid));", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.vDu.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s ON %s(priority, createtime);", new Object[] { "C2CMsgAutoDownloadFile_Priority_CreateTime", "C2CMsgAutoDownloadFile" }));
      this.vDu.ac(2L, 4L);
    }
    for (;;)
    {
      this.vEb = this.vDu.compileStatement(String.format("INSERT OR IGNORE INTO %s (id, fromuser, realuser, restype, createtime, reason, status, downloadtime, msgsvrid, filesize, fileext, opentime, priority, prioritytype, fileid) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.vEk = this.vDu.compileStatement(String.format("DELETE FROM %s WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.vEl = this.vDu.compileStatement(String.format("DELETE FROM %s WHERE fromuser = ?;", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.vEm = this.vDu.compileStatement(String.format("UPDATE %s SET status = ? WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.vEn = this.vDu.compileStatement(String.format("UPDATE %s SET reason = reason | ?, status = ? WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.vEo = this.vDu.compileStatement(String.format("UPDATE %s SET downloadtime = ?, status = ? WHERE id = ? AND msgsvrid = ? AND downloadtime = 0", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.vEp = this.vDu.compileStatement(String.format("UPDATE %s SET opentime = ? WHERE id = ? AND msgsvrid = ? AND opentime = 0", new Object[] { "C2CMsgAutoDownloadFile" }));
      AppMethodBeat.o(87834);
      return;
      ac.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "Exist Table %s Count %s", new Object[] { "C2CMsgAutoDownloadFile", Integer.valueOf(this.vDu.app("C2CMsgAutoDownloadFile")) });
    }
  }
  
  private static hh l(Cursor paramCursor)
  {
    AppMethodBeat.i(87841);
    hh localhh = new hh();
    localhh.Id = paramCursor.getString(0);
    localhh.vTL = paramCursor.getString(1);
    localhh.DUy = paramCursor.getString(2);
    localhh.DUz = paramCursor.getInt(3);
    localhh.DUA = paramCursor.getLong(4);
    localhh.DUB = paramCursor.getInt(5);
    localhh.ndj = paramCursor.getInt(6);
    localhh.DUC = paramCursor.getLong(7);
    localhh.DUD = paramCursor.getLong(8);
    localhh.DUE = paramCursor.getInt(9);
    localhh.DUF = paramCursor.getString(10);
    localhh.DUG = paramCursor.getLong(11);
    localhh.DUH = paramCursor.getFloat(12);
    localhh.DUI = paramCursor.getInt(13);
    localhh.DUJ = paramCursor.getString(14);
    AppMethodBeat.o(87841);
    return localhh;
  }
  
  public final hh a(float paramFloat, long paramLong)
  {
    AppMethodBeat.i(87839);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %s AND priority >= ? AND createtime > ? AND filesize <= ? ORDER BY priority DESC, createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadFile", Integer.valueOf(1) });
    localObject1 = this.vDu.rawQuery((String)localObject1, new String[] { String.valueOf(paramFloat), String.valueOf(l - 432000000L), String.valueOf(paramLong) });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        hh localhh = l((Cursor)localObject1);
        return localhh;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87839);
    }
  }
  
  public final void a(hh paramhh)
  {
    AppMethodBeat.i(87835);
    this.vEb.bindString(1, paramhh.Id);
    this.vEb.bindString(2, paramhh.vTL);
    this.vEb.bindString(3, paramhh.DUy);
    this.vEb.bindLong(4, paramhh.DUz);
    this.vEb.bindLong(5, paramhh.DUA);
    this.vEb.bindLong(6, paramhh.DUB);
    this.vEb.bindLong(7, paramhh.ndj);
    this.vEb.bindLong(8, paramhh.DUC);
    this.vEb.bindLong(9, paramhh.DUD);
    this.vEb.bindLong(10, paramhh.DUE);
    this.vEb.bindString(11, paramhh.DUF);
    this.vEb.bindLong(12, paramhh.DUG);
    this.vEb.bindDouble(13, paramhh.DUH);
    this.vEb.bindLong(14, paramhh.DUI);
    this.vEb.bindString(15, paramhh.DUJ);
    this.vEb.execute();
    AppMethodBeat.o(87835);
  }
  
  public final boolean aZ(String paramString, long paramLong)
  {
    AppMethodBeat.i(87837);
    String str = String.format("SELECT 1 FROM %s WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" });
    paramString = this.vDu.rawQuery(str, new String[] { paramString, String.valueOf(paramLong) });
    try
    {
      boolean bool = paramString.moveToNext();
      return bool;
    }
    finally
    {
      paramString.close();
      AppMethodBeat.o(87837);
    }
  }
  
  public final hh ba(String paramString, long paramLong)
  {
    AppMethodBeat.i(87838);
    Object localObject1 = String.format("SELECT * FROM %s WHERE id = ? AND msgsvrid = ?;", new Object[] { "C2CMsgAutoDownloadFile" });
    paramString = this.vDu.rawQuery((String)localObject1, new String[] { paramString, String.valueOf(paramLong) });
    try
    {
      if (paramString.moveToNext())
      {
        localObject1 = l(paramString);
        return localObject1;
      }
      return null;
    }
    finally
    {
      paramString.close();
      AppMethodBeat.o(87838);
    }
  }
  
  public final hh doM()
  {
    AppMethodBeat.i(87840);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %s AND (reason & %s) > 0 AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadFile", Integer.valueOf(1), Integer.valueOf(1) });
    localObject1 = this.vDu.rawQuery((String)localObject1, new String[] { String.valueOf(l - 432000000L) });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        hh localhh = l((Cursor)localObject1);
        return localhh;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87840);
    }
  }
  
  public final void j(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(87836);
    this.vEm.bindLong(1, paramInt);
    this.vEm.bindString(2, paramString);
    this.vEm.bindLong(3, paramLong);
    ac.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "updateStatus %s res %s %s %s", new Object[] { Integer.valueOf(this.vEm.executeUpdateDelete()), paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(87836);
  }
  
  public final hh q(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(161938);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s File, %s Chat WHERE Chat.rank <= ? AND Chat.totallsp > ? AND Chat.chat = File.fromuser AND createtime > ? AND File.status = ? ORDER BY File.createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadFile", "C2CChatUsageResult" });
    localObject1 = this.vDu.rawQuery((String)localObject1, new String[] { String.valueOf(paramInt), String.valueOf(paramFloat), String.valueOf(l - 432000000L), "1" });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        hh localhh = l((Cursor)localObject1);
        return localhh;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(161938);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.b.c
 * JD-Core Version:    0.7.0.1
 */