package com.tencent.mm.plugin.priority.model.a.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.protocal.protobuf.hd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.wcdb.database.SQLiteStatement;

public final class c
{
  private b uuB;
  private SQLiteStatement uvi;
  public SQLiteStatement uvr;
  public SQLiteStatement uvs;
  private SQLiteStatement uvt;
  private SQLiteStatement uvu;
  public SQLiteStatement uvv;
  public SQLiteStatement uvw;
  
  public c(b paramb)
  {
    AppMethodBeat.i(87834);
    this.uuB = paramb;
    if (this.uuB.ae(2L, 0L) != 4L)
    {
      if (this.uuB.aaQ("C2CMsgAutoDownloadFile")) {
        this.uuB.akr("C2CMsgAutoDownloadFile");
      }
      this.uuB.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (id TEXT, fromuser TEXT, realuser TEXT, restype INTEGER, createtime INTEGER, reason INTEGER, status INTEGER, downloadtime INTEGER, msgsvrid LONG, filesize INTEGER, fileext TEXT, opentime INTEGER, priority FLOAT, prioritytype INTEGER, fileid TEXT, PRIMARY KEY(id, msgsvrid));", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.uuB.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s ON %s(priority, createtime);", new Object[] { "C2CMsgAutoDownloadFile_Priority_CreateTime", "C2CMsgAutoDownloadFile" }));
      this.uuB.af(2L, 4L);
    }
    for (;;)
    {
      this.uvi = this.uuB.compileStatement(String.format("INSERT OR IGNORE INTO %s (id, fromuser, realuser, restype, createtime, reason, status, downloadtime, msgsvrid, filesize, fileext, opentime, priority, prioritytype, fileid) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.uvr = this.uuB.compileStatement(String.format("DELETE FROM %s WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.uvs = this.uuB.compileStatement(String.format("DELETE FROM %s WHERE fromuser = ?;", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.uvt = this.uuB.compileStatement(String.format("UPDATE %s SET status = ? WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.uvu = this.uuB.compileStatement(String.format("UPDATE %s SET reason = reason | ?, status = ? WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.uvv = this.uuB.compileStatement(String.format("UPDATE %s SET downloadtime = ?, status = ? WHERE id = ? AND msgsvrid = ? AND downloadtime = 0", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.uvw = this.uuB.compileStatement(String.format("UPDATE %s SET opentime = ? WHERE id = ? AND msgsvrid = ? AND opentime = 0", new Object[] { "C2CMsgAutoDownloadFile" }));
      AppMethodBeat.o(87834);
      return;
      ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "Exist Table %s Count %s", new Object[] { "C2CMsgAutoDownloadFile", Integer.valueOf(this.uuB.akq("C2CMsgAutoDownloadFile")) });
    }
  }
  
  private static hd m(Cursor paramCursor)
  {
    AppMethodBeat.i(87841);
    hd localhd = new hd();
    localhd.Id = paramCursor.getString(0);
    localhd.uKU = paramCursor.getString(1);
    localhd.CCb = paramCursor.getString(2);
    localhd.CCc = paramCursor.getInt(3);
    localhd.CCd = paramCursor.getLong(4);
    localhd.CCe = paramCursor.getInt(5);
    localhd.mBi = paramCursor.getInt(6);
    localhd.CCf = paramCursor.getLong(7);
    localhd.CCg = paramCursor.getLong(8);
    localhd.CCh = paramCursor.getInt(9);
    localhd.CCi = paramCursor.getString(10);
    localhd.CCj = paramCursor.getLong(11);
    localhd.CCk = paramCursor.getFloat(12);
    localhd.CCl = paramCursor.getInt(13);
    localhd.CCm = paramCursor.getString(14);
    AppMethodBeat.o(87841);
    return localhd;
  }
  
  public final hd a(float paramFloat, long paramLong)
  {
    AppMethodBeat.i(87839);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %s AND priority >= ? AND createtime > ? AND filesize <= ? ORDER BY priority DESC, createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadFile", Integer.valueOf(1) });
    localObject1 = this.uuB.rawQuery((String)localObject1, new String[] { String.valueOf(paramFloat), String.valueOf(l - 432000000L), String.valueOf(paramLong) });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        hd localhd = m((Cursor)localObject1);
        return localhd;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87839);
    }
  }
  
  public final void a(hd paramhd)
  {
    AppMethodBeat.i(87835);
    this.uvi.bindString(1, paramhd.Id);
    this.uvi.bindString(2, paramhd.uKU);
    this.uvi.bindString(3, paramhd.CCb);
    this.uvi.bindLong(4, paramhd.CCc);
    this.uvi.bindLong(5, paramhd.CCd);
    this.uvi.bindLong(6, paramhd.CCe);
    this.uvi.bindLong(7, paramhd.mBi);
    this.uvi.bindLong(8, paramhd.CCf);
    this.uvi.bindLong(9, paramhd.CCg);
    this.uvi.bindLong(10, paramhd.CCh);
    this.uvi.bindString(11, paramhd.CCi);
    this.uvi.bindLong(12, paramhd.CCj);
    this.uvi.bindDouble(13, paramhd.CCk);
    this.uvi.bindLong(14, paramhd.CCl);
    this.uvi.bindString(15, paramhd.CCm);
    this.uvi.execute();
    AppMethodBeat.o(87835);
  }
  
  public final boolean aX(String paramString, long paramLong)
  {
    AppMethodBeat.i(87837);
    String str = String.format("SELECT 1 FROM %s WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" });
    paramString = this.uuB.rawQuery(str, new String[] { paramString, String.valueOf(paramLong) });
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
  
  public final hd aY(String paramString, long paramLong)
  {
    AppMethodBeat.i(87838);
    Object localObject1 = String.format("SELECT * FROM %s WHERE id = ? AND msgsvrid = ?;", new Object[] { "C2CMsgAutoDownloadFile" });
    paramString = this.uuB.rawQuery((String)localObject1, new String[] { paramString, String.valueOf(paramLong) });
    try
    {
      if (paramString.moveToNext())
      {
        localObject1 = m(paramString);
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
  
  public final hd dbe()
  {
    AppMethodBeat.i(87840);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %s AND (reason & %s) > 0 AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadFile", Integer.valueOf(1), Integer.valueOf(1) });
    localObject1 = this.uuB.rawQuery((String)localObject1, new String[] { String.valueOf(l - 432000000L) });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        hd localhd = m((Cursor)localObject1);
        return localhd;
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
    this.uvt.bindLong(1, paramInt);
    this.uvt.bindString(2, paramString);
    this.uvt.bindLong(3, paramLong);
    ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "updateStatus %s res %s %s %s", new Object[] { Integer.valueOf(this.uvt.executeUpdateDelete()), paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(87836);
  }
  
  public final hd q(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(161938);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s File, %s Chat WHERE Chat.rank <= ? AND Chat.totallsp > ? AND Chat.chat = File.fromuser AND createtime > ? AND File.status = ? ORDER BY File.createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadFile", "C2CChatUsageResult" });
    localObject1 = this.uuB.rawQuery((String)localObject1, new String[] { String.valueOf(paramInt), String.valueOf(paramFloat), String.valueOf(l - 432000000L), "1" });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        hd localhd = m((Cursor)localObject1);
        return localhd;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.b.c
 * JD-Core Version:    0.7.0.1
 */