package com.tencent.mm.plugin.priority.model.a.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.protocal.protobuf.ho;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.wcdb.database.SQLiteStatement;

public final class c
{
  private b wKA;
  private SQLiteStatement wLh;
  public SQLiteStatement wLq;
  public SQLiteStatement wLr;
  private SQLiteStatement wLs;
  private SQLiteStatement wLt;
  public SQLiteStatement wLu;
  public SQLiteStatement wLv;
  
  public c(b paramb)
  {
    AppMethodBeat.i(87834);
    this.wKA = paramb;
    if (this.wKA.ad(2L, 0L) != 4L)
    {
      if (this.wKA.akg("C2CMsgAutoDownloadFile")) {
        this.wKA.auw("C2CMsgAutoDownloadFile");
      }
      this.wKA.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (id TEXT, fromuser TEXT, realuser TEXT, restype INTEGER, createtime INTEGER, reason INTEGER, status INTEGER, downloadtime INTEGER, msgsvrid LONG, filesize INTEGER, fileext TEXT, opentime INTEGER, priority FLOAT, prioritytype INTEGER, fileid TEXT, PRIMARY KEY(id, msgsvrid));", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.wKA.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s ON %s(priority, createtime);", new Object[] { "C2CMsgAutoDownloadFile_Priority_CreateTime", "C2CMsgAutoDownloadFile" }));
      this.wKA.ae(2L, 4L);
    }
    for (;;)
    {
      this.wLh = this.wKA.compileStatement(String.format("INSERT OR IGNORE INTO %s (id, fromuser, realuser, restype, createtime, reason, status, downloadtime, msgsvrid, filesize, fileext, opentime, priority, prioritytype, fileid) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.wLq = this.wKA.compileStatement(String.format("DELETE FROM %s WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.wLr = this.wKA.compileStatement(String.format("DELETE FROM %s WHERE fromuser = ?;", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.wLs = this.wKA.compileStatement(String.format("UPDATE %s SET status = ? WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.wLt = this.wKA.compileStatement(String.format("UPDATE %s SET reason = reason | ?, status = ? WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.wLu = this.wKA.compileStatement(String.format("UPDATE %s SET downloadtime = ?, status = ? WHERE id = ? AND msgsvrid = ? AND downloadtime = 0", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.wLv = this.wKA.compileStatement(String.format("UPDATE %s SET opentime = ? WHERE id = ? AND msgsvrid = ? AND opentime = 0", new Object[] { "C2CMsgAutoDownloadFile" }));
      AppMethodBeat.o(87834);
      return;
      ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "Exist Table %s Count %s", new Object[] { "C2CMsgAutoDownloadFile", Integer.valueOf(this.wKA.auv("C2CMsgAutoDownloadFile")) });
    }
  }
  
  private static ho l(Cursor paramCursor)
  {
    AppMethodBeat.i(87841);
    ho localho = new ho();
    localho.Id = paramCursor.getString(0);
    localho.FzS = paramCursor.getString(1);
    localho.FzT = paramCursor.getString(2);
    localho.FzU = paramCursor.getInt(3);
    localho.FzV = paramCursor.getLong(4);
    localho.FzW = paramCursor.getInt(5);
    localho.nDG = paramCursor.getInt(6);
    localho.FzX = paramCursor.getLong(7);
    localho.FzY = paramCursor.getLong(8);
    localho.FzZ = paramCursor.getInt(9);
    localho.FAa = paramCursor.getString(10);
    localho.FAb = paramCursor.getLong(11);
    localho.FAc = paramCursor.getFloat(12);
    localho.FAd = paramCursor.getInt(13);
    localho.FAe = paramCursor.getString(14);
    AppMethodBeat.o(87841);
    return localho;
  }
  
  public final void a(ho paramho)
  {
    AppMethodBeat.i(87835);
    this.wLh.bindString(1, paramho.Id);
    this.wLh.bindString(2, paramho.FzS);
    this.wLh.bindString(3, paramho.FzT);
    this.wLh.bindLong(4, paramho.FzU);
    this.wLh.bindLong(5, paramho.FzV);
    this.wLh.bindLong(6, paramho.FzW);
    this.wLh.bindLong(7, paramho.nDG);
    this.wLh.bindLong(8, paramho.FzX);
    this.wLh.bindLong(9, paramho.FzY);
    this.wLh.bindLong(10, paramho.FzZ);
    this.wLh.bindString(11, paramho.FAa);
    this.wLh.bindLong(12, paramho.FAb);
    this.wLh.bindDouble(13, paramho.FAc);
    this.wLh.bindLong(14, paramho.FAd);
    this.wLh.bindString(15, paramho.FAe);
    this.wLh.execute();
    AppMethodBeat.o(87835);
  }
  
  public final ho b(float paramFloat, long paramLong)
  {
    AppMethodBeat.i(87839);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %s AND priority >= ? AND createtime > ? AND filesize <= ? ORDER BY priority DESC, createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadFile", Integer.valueOf(1) });
    localObject1 = this.wKA.rawQuery((String)localObject1, new String[] { String.valueOf(paramFloat), String.valueOf(l - 432000000L), String.valueOf(paramLong) });
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
  
  public final boolean bb(String paramString, long paramLong)
  {
    AppMethodBeat.i(87837);
    String str = String.format("SELECT 1 FROM %s WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" });
    paramString = this.wKA.rawQuery(str, new String[] { paramString, String.valueOf(paramLong) });
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
  
  public final ho bc(String paramString, long paramLong)
  {
    AppMethodBeat.i(87838);
    Object localObject1 = String.format("SELECT * FROM %s WHERE id = ? AND msgsvrid = ?;", new Object[] { "C2CMsgAutoDownloadFile" });
    paramString = this.wKA.rawQuery((String)localObject1, new String[] { paramString, String.valueOf(paramLong) });
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
  
  public final ho dzo()
  {
    AppMethodBeat.i(87840);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %s AND (reason & %s) > 0 AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadFile", Integer.valueOf(1), Integer.valueOf(1) });
    localObject1 = this.wKA.rawQuery((String)localObject1, new String[] { String.valueOf(l - 432000000L) });
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
    this.wLs.bindLong(1, paramInt);
    this.wLs.bindString(2, paramString);
    this.wLs.bindLong(3, paramLong);
    ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "updateStatus %s res %s %s %s", new Object[] { Integer.valueOf(this.wLs.executeUpdateDelete()), paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(87836);
  }
  
  public final ho r(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(161938);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s File, %s Chat WHERE Chat.rank <= ? AND Chat.totallsp > ? AND Chat.chat = File.fromuser AND createtime > ? AND File.status = ? ORDER BY File.createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadFile", "C2CChatUsageResult" });
    localObject1 = this.wKA.rawQuery((String)localObject1, new String[] { String.valueOf(paramInt), String.valueOf(paramFloat), String.valueOf(l - 432000000L), "1" });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.b.c
 * JD-Core Version:    0.7.0.1
 */