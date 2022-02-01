package com.tencent.mm.plugin.priority.model.a.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.protocal.protobuf.ho;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.wcdb.database.SQLiteStatement;

public final class c
{
  private SQLiteStatement xaV;
  private b xao;
  public SQLiteStatement xbe;
  public SQLiteStatement xbf;
  private SQLiteStatement xbg;
  private SQLiteStatement xbh;
  public SQLiteStatement xbi;
  public SQLiteStatement xbj;
  
  public c(b paramb)
  {
    AppMethodBeat.i(87834);
    this.xao = paramb;
    if (this.xao.ac(2L, 0L) != 4L)
    {
      if (this.xao.ale("C2CMsgAutoDownloadFile")) {
        this.xao.avL("C2CMsgAutoDownloadFile");
      }
      this.xao.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (id TEXT, fromuser TEXT, realuser TEXT, restype INTEGER, createtime INTEGER, reason INTEGER, status INTEGER, downloadtime INTEGER, msgsvrid LONG, filesize INTEGER, fileext TEXT, opentime INTEGER, priority FLOAT, prioritytype INTEGER, fileid TEXT, PRIMARY KEY(id, msgsvrid));", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.xao.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s ON %s(priority, createtime);", new Object[] { "C2CMsgAutoDownloadFile_Priority_CreateTime", "C2CMsgAutoDownloadFile" }));
      this.xao.ad(2L, 4L);
    }
    for (;;)
    {
      this.xaV = this.xao.compileStatement(String.format("INSERT OR IGNORE INTO %s (id, fromuser, realuser, restype, createtime, reason, status, downloadtime, msgsvrid, filesize, fileext, opentime, priority, prioritytype, fileid) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.xbe = this.xao.compileStatement(String.format("DELETE FROM %s WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.xbf = this.xao.compileStatement(String.format("DELETE FROM %s WHERE fromuser = ?;", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.xbg = this.xao.compileStatement(String.format("UPDATE %s SET status = ? WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.xbh = this.xao.compileStatement(String.format("UPDATE %s SET reason = reason | ?, status = ? WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.xbi = this.xao.compileStatement(String.format("UPDATE %s SET downloadtime = ?, status = ? WHERE id = ? AND msgsvrid = ? AND downloadtime = 0", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.xbj = this.xao.compileStatement(String.format("UPDATE %s SET opentime = ? WHERE id = ? AND msgsvrid = ? AND opentime = 0", new Object[] { "C2CMsgAutoDownloadFile" }));
      AppMethodBeat.o(87834);
      return;
      ae.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "Exist Table %s Count %s", new Object[] { "C2CMsgAutoDownloadFile", Integer.valueOf(this.xao.avK("C2CMsgAutoDownloadFile")) });
    }
  }
  
  private static ho l(Cursor paramCursor)
  {
    AppMethodBeat.i(87841);
    ho localho = new ho();
    localho.Id = paramCursor.getString(0);
    localho.FSq = paramCursor.getString(1);
    localho.FSr = paramCursor.getString(2);
    localho.FSs = paramCursor.getInt(3);
    localho.FSt = paramCursor.getLong(4);
    localho.FSu = paramCursor.getInt(5);
    localho.nJb = paramCursor.getInt(6);
    localho.FSv = paramCursor.getLong(7);
    localho.FSw = paramCursor.getLong(8);
    localho.FSx = paramCursor.getInt(9);
    localho.FSy = paramCursor.getString(10);
    localho.FSz = paramCursor.getLong(11);
    localho.FSA = paramCursor.getFloat(12);
    localho.FSB = paramCursor.getInt(13);
    localho.FSC = paramCursor.getString(14);
    AppMethodBeat.o(87841);
    return localho;
  }
  
  public final void a(ho paramho)
  {
    AppMethodBeat.i(87835);
    this.xaV.bindString(1, paramho.Id);
    this.xaV.bindString(2, paramho.FSq);
    this.xaV.bindString(3, paramho.FSr);
    this.xaV.bindLong(4, paramho.FSs);
    this.xaV.bindLong(5, paramho.FSt);
    this.xaV.bindLong(6, paramho.FSu);
    this.xaV.bindLong(7, paramho.nJb);
    this.xaV.bindLong(8, paramho.FSv);
    this.xaV.bindLong(9, paramho.FSw);
    this.xaV.bindLong(10, paramho.FSx);
    this.xaV.bindString(11, paramho.FSy);
    this.xaV.bindLong(12, paramho.FSz);
    this.xaV.bindDouble(13, paramho.FSA);
    this.xaV.bindLong(14, paramho.FSB);
    this.xaV.bindString(15, paramho.FSC);
    this.xaV.execute();
    AppMethodBeat.o(87835);
  }
  
  public final ho b(float paramFloat, long paramLong)
  {
    AppMethodBeat.i(87839);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %s AND priority >= ? AND createtime > ? AND filesize <= ? ORDER BY priority DESC, createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadFile", Integer.valueOf(1) });
    localObject1 = this.xao.rawQuery((String)localObject1, new String[] { String.valueOf(paramFloat), String.valueOf(l - 432000000L), String.valueOf(paramLong) });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        ho localho = l((Cursor)localObject1);
        return localho;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87839);
    }
  }
  
  public final boolean bc(String paramString, long paramLong)
  {
    AppMethodBeat.i(87837);
    String str = String.format("SELECT 1 FROM %s WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" });
    paramString = this.xao.rawQuery(str, new String[] { paramString, String.valueOf(paramLong) });
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
  
  public final ho bd(String paramString, long paramLong)
  {
    AppMethodBeat.i(87838);
    Object localObject1 = String.format("SELECT * FROM %s WHERE id = ? AND msgsvrid = ?;", new Object[] { "C2CMsgAutoDownloadFile" });
    paramString = this.xao.rawQuery((String)localObject1, new String[] { paramString, String.valueOf(paramLong) });
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
  
  public final ho dCF()
  {
    AppMethodBeat.i(87840);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %s AND (reason & %s) > 0 AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadFile", Integer.valueOf(1), Integer.valueOf(1) });
    localObject1 = this.xao.rawQuery((String)localObject1, new String[] { String.valueOf(l - 432000000L) });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        ho localho = l((Cursor)localObject1);
        return localho;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87840);
    }
  }
  
  public final void l(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(87836);
    this.xbg.bindLong(1, paramInt);
    this.xbg.bindString(2, paramString);
    this.xbg.bindLong(3, paramLong);
    ae.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "updateStatus %s res %s %s %s", new Object[] { Integer.valueOf(this.xbg.executeUpdateDelete()), paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(87836);
  }
  
  public final ho r(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(161938);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s File, %s Chat WHERE Chat.rank <= ? AND Chat.totallsp > ? AND Chat.chat = File.fromuser AND createtime > ? AND File.status = ? ORDER BY File.createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadFile", "C2CChatUsageResult" });
    localObject1 = this.xao.rawQuery((String)localObject1, new String[] { String.valueOf(paramInt), String.valueOf(paramFloat), String.valueOf(l - 432000000L), "1" });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        ho localho = l((Cursor)localObject1);
        return localho;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.b.c
 * JD-Core Version:    0.7.0.1
 */