package com.tencent.mm.plugin.priority.model.a.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.protocal.protobuf.hr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wcdb.database.SQLiteStatement;

public class c
{
  private b GRO;
  public SQLiteStatement GSE;
  public SQLiteStatement GSF;
  private SQLiteStatement GSG;
  private SQLiteStatement GSH;
  SQLiteStatement GSI;
  SQLiteStatement GSJ;
  private SQLiteStatement GSv;
  
  public c(b paramb)
  {
    AppMethodBeat.i(87834);
    this.GRO = paramb;
    if (this.GRO.ao(2L, 0L) != 4L)
    {
      if (this.GRO.aHB("C2CMsgAutoDownloadFile")) {
        this.GRO.aUA("C2CMsgAutoDownloadFile");
      }
      this.GRO.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (id TEXT, fromuser TEXT, realuser TEXT, restype INTEGER, createtime INTEGER, reason INTEGER, status INTEGER, downloadtime INTEGER, msgsvrid LONG, filesize INTEGER, fileext TEXT, opentime INTEGER, priority FLOAT, prioritytype INTEGER, fileid TEXT, PRIMARY KEY(id, msgsvrid));", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.GRO.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s ON %s(priority, createtime);", new Object[] { "C2CMsgAutoDownloadFile_Priority_CreateTime", "C2CMsgAutoDownloadFile" }));
      this.GRO.ap(2L, 4L);
    }
    for (;;)
    {
      this.GSv = this.GRO.compileStatement(String.format("INSERT OR IGNORE INTO %s (id, fromuser, realuser, restype, createtime, reason, status, downloadtime, msgsvrid, filesize, fileext, opentime, priority, prioritytype, fileid) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.GSE = this.GRO.compileStatement(String.format("DELETE FROM %s WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.GSF = this.GRO.compileStatement(String.format("DELETE FROM %s WHERE fromuser = ?;", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.GSG = this.GRO.compileStatement(String.format("UPDATE %s SET status = ? WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.GSH = this.GRO.compileStatement(String.format("UPDATE %s SET reason = reason | ?, status = ? WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.GSI = this.GRO.compileStatement(String.format("UPDATE %s SET downloadtime = ?, status = ? WHERE id = ? AND msgsvrid = ? AND downloadtime = 0", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.GSJ = this.GRO.compileStatement(String.format("UPDATE %s SET opentime = ? WHERE id = ? AND msgsvrid = ? AND opentime = 0", new Object[] { "C2CMsgAutoDownloadFile" }));
      AppMethodBeat.o(87834);
      return;
      Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "Exist Table %s Count %s", new Object[] { "C2CMsgAutoDownloadFile", Integer.valueOf(this.GRO.aUz("C2CMsgAutoDownloadFile")) });
    }
  }
  
  private static hr o(Cursor paramCursor)
  {
    AppMethodBeat.i(87841);
    hr localhr = new hr();
    localhr.Id = paramCursor.getString(0);
    localhr.RMW = paramCursor.getString(1);
    localhr.RMX = paramCursor.getString(2);
    localhr.RMY = paramCursor.getInt(3);
    localhr.RMZ = paramCursor.getLong(4);
    localhr.RNa = paramCursor.getInt(5);
    localhr.rVU = paramCursor.getInt(6);
    localhr.RNb = paramCursor.getLong(7);
    localhr.RNc = paramCursor.getLong(8);
    localhr.RNd = paramCursor.getInt(9);
    localhr.RNe = paramCursor.getString(10);
    localhr.RNf = paramCursor.getLong(11);
    localhr.RNg = paramCursor.getFloat(12);
    localhr.RNh = paramCursor.getInt(13);
    localhr.RNi = paramCursor.getString(14);
    AppMethodBeat.o(87841);
    return localhr;
  }
  
  public final void a(hr paramhr)
  {
    AppMethodBeat.i(87835);
    this.GSv.bindString(1, paramhr.Id);
    this.GSv.bindString(2, paramhr.RMW);
    this.GSv.bindString(3, paramhr.RMX);
    this.GSv.bindLong(4, paramhr.RMY);
    this.GSv.bindLong(5, paramhr.RMZ);
    this.GSv.bindLong(6, paramhr.RNa);
    this.GSv.bindLong(7, paramhr.rVU);
    this.GSv.bindLong(8, paramhr.RNb);
    this.GSv.bindLong(9, paramhr.RNc);
    this.GSv.bindLong(10, paramhr.RNd);
    this.GSv.bindString(11, paramhr.RNe);
    this.GSv.bindLong(12, paramhr.RNf);
    this.GSv.bindDouble(13, paramhr.RNg);
    this.GSv.bindLong(14, paramhr.RNh);
    this.GSv.bindString(15, paramhr.RNi);
    this.GSv.execute();
    AppMethodBeat.o(87835);
  }
  
  public final boolean bg(String paramString, long paramLong)
  {
    AppMethodBeat.i(87837);
    String str = String.format("SELECT 1 FROM %s WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" });
    paramString = this.GRO.rawQuery(str, new String[] { paramString, String.valueOf(paramLong) });
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
  
  public final hr bh(String paramString, long paramLong)
  {
    AppMethodBeat.i(87838);
    Object localObject1 = String.format("SELECT * FROM %s WHERE id = ? AND msgsvrid = ?;", new Object[] { "C2CMsgAutoDownloadFile" });
    paramString = this.GRO.rawQuery((String)localObject1, new String[] { paramString, String.valueOf(paramLong) });
    try
    {
      if (paramString.moveToNext())
      {
        localObject1 = o(paramString);
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
  
  public final hr d(float paramFloat, long paramLong)
  {
    AppMethodBeat.i(87839);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %s AND priority >= ? AND createtime > ? AND filesize <= ? ORDER BY priority DESC, createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadFile", Integer.valueOf(1) });
    localObject1 = this.GRO.rawQuery((String)localObject1, new String[] { String.valueOf(paramFloat), String.valueOf(l - 432000000L), String.valueOf(paramLong) });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        hr localhr = o((Cursor)localObject1);
        return localhr;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87839);
    }
  }
  
  public final hr foQ()
  {
    AppMethodBeat.i(87840);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %s AND (reason & %s) > 0 AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadFile", Integer.valueOf(1), Integer.valueOf(1) });
    localObject1 = this.GRO.rawQuery((String)localObject1, new String[] { String.valueOf(l - 432000000L) });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        hr localhr = o((Cursor)localObject1);
        return localhr;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87840);
    }
  }
  
  public final void m(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(87836);
    this.GSG.bindLong(1, paramInt);
    this.GSG.bindString(2, paramString);
    this.GSG.bindLong(3, paramLong);
    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "updateStatus %s res %s %s %s", new Object[] { Integer.valueOf(this.GSG.executeUpdateDelete()), paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(87836);
  }
  
  public final hr t(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(161938);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s File, %s Chat WHERE Chat.rank <= ? AND Chat.totallsp > ? AND Chat.chat = File.fromuser AND createtime > ? AND File.status = ? ORDER BY File.createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadFile", "C2CChatUsageResult" });
    localObject1 = this.GRO.rawQuery((String)localObject1, new String[] { String.valueOf(paramInt), String.valueOf(paramFloat), String.valueOf(l - 432000000L), "1" });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        hr localhr = o((Cursor)localObject1);
        return localhr;
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