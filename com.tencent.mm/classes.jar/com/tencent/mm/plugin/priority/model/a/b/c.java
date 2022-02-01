package com.tencent.mm.plugin.priority.model.a.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.protocal.protobuf.ib;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wcdb.database.SQLiteStatement;

public final class c
{
  private b AXQ;
  public SQLiteStatement AYG;
  public SQLiteStatement AYH;
  private SQLiteStatement AYI;
  private SQLiteStatement AYJ;
  public SQLiteStatement AYK;
  public SQLiteStatement AYL;
  private SQLiteStatement AYx;
  
  public c(b paramb)
  {
    AppMethodBeat.i(87834);
    this.AXQ = paramb;
    if (this.AXQ.ag(2L, 0L) != 4L)
    {
      if (this.AXQ.ayi("C2CMsgAutoDownloadFile")) {
        this.AXQ.aKd("C2CMsgAutoDownloadFile");
      }
      this.AXQ.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (id TEXT, fromuser TEXT, realuser TEXT, restype INTEGER, createtime INTEGER, reason INTEGER, status INTEGER, downloadtime INTEGER, msgsvrid LONG, filesize INTEGER, fileext TEXT, opentime INTEGER, priority FLOAT, prioritytype INTEGER, fileid TEXT, PRIMARY KEY(id, msgsvrid));", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.AXQ.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s ON %s(priority, createtime);", new Object[] { "C2CMsgAutoDownloadFile_Priority_CreateTime", "C2CMsgAutoDownloadFile" }));
      this.AXQ.ah(2L, 4L);
    }
    for (;;)
    {
      this.AYx = this.AXQ.compileStatement(String.format("INSERT OR IGNORE INTO %s (id, fromuser, realuser, restype, createtime, reason, status, downloadtime, msgsvrid, filesize, fileext, opentime, priority, prioritytype, fileid) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.AYG = this.AXQ.compileStatement(String.format("DELETE FROM %s WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.AYH = this.AXQ.compileStatement(String.format("DELETE FROM %s WHERE fromuser = ?;", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.AYI = this.AXQ.compileStatement(String.format("UPDATE %s SET status = ? WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.AYJ = this.AXQ.compileStatement(String.format("UPDATE %s SET reason = reason | ?, status = ? WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.AYK = this.AXQ.compileStatement(String.format("UPDATE %s SET downloadtime = ?, status = ? WHERE id = ? AND msgsvrid = ? AND downloadtime = 0", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.AYL = this.AXQ.compileStatement(String.format("UPDATE %s SET opentime = ? WHERE id = ? AND msgsvrid = ? AND opentime = 0", new Object[] { "C2CMsgAutoDownloadFile" }));
      AppMethodBeat.o(87834);
      return;
      Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "Exist Table %s Count %s", new Object[] { "C2CMsgAutoDownloadFile", Integer.valueOf(this.AXQ.aKc("C2CMsgAutoDownloadFile")) });
    }
  }
  
  private static ib l(Cursor paramCursor)
  {
    AppMethodBeat.i(87841);
    ib localib = new ib();
    localib.Id = paramCursor.getString(0);
    localib.KLZ = paramCursor.getString(1);
    localib.KMa = paramCursor.getString(2);
    localib.KMb = paramCursor.getInt(3);
    localib.KMc = paramCursor.getLong(4);
    localib.KMd = paramCursor.getInt(5);
    localib.oTW = paramCursor.getInt(6);
    localib.KMe = paramCursor.getLong(7);
    localib.KMf = paramCursor.getLong(8);
    localib.KMg = paramCursor.getInt(9);
    localib.KMh = paramCursor.getString(10);
    localib.KMi = paramCursor.getLong(11);
    localib.KMj = paramCursor.getFloat(12);
    localib.KMk = paramCursor.getInt(13);
    localib.KMl = paramCursor.getString(14);
    AppMethodBeat.o(87841);
    return localib;
  }
  
  public final void a(ib paramib)
  {
    AppMethodBeat.i(87835);
    this.AYx.bindString(1, paramib.Id);
    this.AYx.bindString(2, paramib.KLZ);
    this.AYx.bindString(3, paramib.KMa);
    this.AYx.bindLong(4, paramib.KMb);
    this.AYx.bindLong(5, paramib.KMc);
    this.AYx.bindLong(6, paramib.KMd);
    this.AYx.bindLong(7, paramib.oTW);
    this.AYx.bindLong(8, paramib.KMe);
    this.AYx.bindLong(9, paramib.KMf);
    this.AYx.bindLong(10, paramib.KMg);
    this.AYx.bindString(11, paramib.KMh);
    this.AYx.bindLong(12, paramib.KMi);
    this.AYx.bindDouble(13, paramib.KMj);
    this.AYx.bindLong(14, paramib.KMk);
    this.AYx.bindString(15, paramib.KMl);
    this.AYx.execute();
    AppMethodBeat.o(87835);
  }
  
  public final ib b(float paramFloat, long paramLong)
  {
    AppMethodBeat.i(87839);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %s AND priority >= ? AND createtime > ? AND filesize <= ? ORDER BY priority DESC, createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadFile", Integer.valueOf(1) });
    localObject1 = this.AXQ.rawQuery((String)localObject1, new String[] { String.valueOf(paramFloat), String.valueOf(l - 432000000L), String.valueOf(paramLong) });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        ib localib = l((Cursor)localObject1);
        return localib;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87839);
    }
  }
  
  public final boolean be(String paramString, long paramLong)
  {
    AppMethodBeat.i(87837);
    String str = String.format("SELECT 1 FROM %s WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" });
    paramString = this.AXQ.rawQuery(str, new String[] { paramString, String.valueOf(paramLong) });
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
  
  public final ib bf(String paramString, long paramLong)
  {
    AppMethodBeat.i(87838);
    Object localObject1 = String.format("SELECT * FROM %s WHERE id = ? AND msgsvrid = ?;", new Object[] { "C2CMsgAutoDownloadFile" });
    paramString = this.AXQ.rawQuery((String)localObject1, new String[] { paramString, String.valueOf(paramLong) });
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
  
  public final ib eCX()
  {
    AppMethodBeat.i(87840);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %s AND (reason & %s) > 0 AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadFile", Integer.valueOf(1), Integer.valueOf(1) });
    localObject1 = this.AXQ.rawQuery((String)localObject1, new String[] { String.valueOf(l - 432000000L) });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        ib localib = l((Cursor)localObject1);
        return localib;
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
    this.AYI.bindLong(1, paramInt);
    this.AYI.bindString(2, paramString);
    this.AYI.bindLong(3, paramLong);
    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "updateStatus %s res %s %s %s", new Object[] { Integer.valueOf(this.AYI.executeUpdateDelete()), paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(87836);
  }
  
  public final ib s(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(161938);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s File, %s Chat WHERE Chat.rank <= ? AND Chat.totallsp > ? AND Chat.chat = File.fromuser AND createtime > ? AND File.status = ? ORDER BY File.createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadFile", "C2CChatUsageResult" });
    localObject1 = this.AXQ.rawQuery((String)localObject1, new String[] { String.valueOf(paramInt), String.valueOf(paramFloat), String.valueOf(l - 432000000L), "1" });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        ib localib = l((Cursor)localObject1);
        return localib;
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