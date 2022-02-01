package com.tencent.mm.plugin.priority.model.a.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.protocal.protobuf.ic;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wcdb.database.SQLiteStatement;

public final class c
{
  public b AXQ;
  public SQLiteStatement AYG;
  public SQLiteStatement AYH;
  public SQLiteStatement AYI;
  public SQLiteStatement AYJ;
  public SQLiteStatement AYK;
  public SQLiteStatement AYL;
  public SQLiteStatement AYx;
  
  public c(b paramb)
  {
    AppMethodBeat.i(87853);
    this.AXQ = paramb;
    if (this.AXQ.ag(1L, 0L) != 1L)
    {
      if (this.AXQ.ayi("C2CMsgAutoDownloadRes")) {
        this.AXQ.aKd("C2CMsgAutoDownloadRes");
      }
      this.AXQ.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (msgid INTEGER PRIMARY KEY, fromuser TEXT, realuser TEXT, restype INTEGER, createtime INTEGER, reason INTEGER, status INTEGER, downloadtime INTEGER, msgsvrid LONG, imgsize INTEGER, opentime INTEGER, priority FLOAT, prioritytype INTEGER);", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.AXQ.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s ON %s(priority, createtime);", new Object[] { "C2CMsgAutoDownloadRes_Priority_CreateTime", "C2CMsgAutoDownloadRes" }));
      this.AXQ.ah(1L, 1L);
    }
    for (;;)
    {
      this.AYx = this.AXQ.compileStatement(String.format("INSERT OR IGNORE INTO %s (msgid, fromuser, realuser, restype, createtime, reason, status, downloadtime, msgsvrid, imgsize, opentime, priority, prioritytype) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.AYG = this.AXQ.compileStatement(String.format("DELETE FROM %s WHERE msgid = ?", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.AYH = this.AXQ.compileStatement(String.format("DELETE FROM %s WHERE fromuser = ?;", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.AYI = this.AXQ.compileStatement(String.format("UPDATE %s SET status = ? WHERE msgid = ?", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.AYJ = this.AXQ.compileStatement(String.format("UPDATE %s SET reason = reason | ?, status = ? WHERE msgid = ?", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.AYK = this.AXQ.compileStatement(String.format("UPDATE %s SET downloadtime = ?, status = ?, imgsize = ? WHERE msgid = ? AND downloadtime = 0", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.AYL = this.AXQ.compileStatement(String.format("UPDATE %s SET opentime = ? WHERE msgid = ? AND opentime = 0", new Object[] { "C2CMsgAutoDownloadRes" }));
      AppMethodBeat.o(87853);
      return;
      Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "Exist Table %s Count %d", new Object[] { "C2CMsgAutoDownloadRes", Integer.valueOf(this.AXQ.aKc("C2CMsgAutoDownloadRes")) });
    }
  }
  
  private static ic m(Cursor paramCursor)
  {
    AppMethodBeat.i(87862);
    ic localic = new ic();
    localic.KMm = paramCursor.getLong(0);
    localic.KLZ = paramCursor.getString(1);
    localic.KMa = paramCursor.getString(2);
    localic.KMb = paramCursor.getInt(3);
    localic.KMc = paramCursor.getLong(4);
    localic.KMd = paramCursor.getInt(5);
    localic.oTW = paramCursor.getInt(6);
    localic.KMe = paramCursor.getLong(7);
    localic.KMf = paramCursor.getLong(8);
    localic.KMn = paramCursor.getInt(9);
    localic.KMi = paramCursor.getLong(10);
    localic.KMj = paramCursor.getFloat(11);
    localic.KMk = paramCursor.getInt(12);
    AppMethodBeat.o(87862);
    return localic;
  }
  
  public final boolean HL(long paramLong)
  {
    AppMethodBeat.i(87856);
    Object localObject1 = String.format("SELECT 1 FROM %s WHERE msgid = %d", new Object[] { "C2CMsgAutoDownloadRes", Long.valueOf(paramLong) });
    localObject1 = this.AXQ.rawQuery((String)localObject1, null);
    try
    {
      boolean bool = ((Cursor)localObject1).moveToNext();
      return bool;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87856);
    }
  }
  
  public final ic HM(long paramLong)
  {
    AppMethodBeat.i(87857);
    Object localObject1 = String.format("SELECT * FROM %s WHERE msgid = %d;", new Object[] { "C2CMsgAutoDownloadRes", Long.valueOf(paramLong) });
    localObject1 = this.AXQ.rawQuery((String)localObject1, null);
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        ic localic = m((Cursor)localObject1);
        return localic;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87857);
    }
  }
  
  public final void R(long paramLong, int paramInt)
  {
    AppMethodBeat.i(87854);
    this.AYI.bindLong(1, paramInt);
    this.AYI.bindLong(2, paramLong);
    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateStatus %d res %d %d", new Object[] { Integer.valueOf(this.AYI.executeUpdateDelete()), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(87854);
  }
  
  public final ic b(String paramString, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(87863);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s Img, %s Chat WHERE Chat.rank <= ? AND Chat.totallsp > ? AND Chat.chat = ? AND Img.fromuser = ? AND Img.createtime > ? AND Img.status = ? ORDER BY Img.createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", "C2CChatUsageResult" });
    paramString = this.AXQ.rawQuery((String)localObject1, new String[] { String.valueOf(paramInt), String.valueOf(paramFloat), paramString, paramString, String.valueOf(l - 432000000L), "1" });
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
      AppMethodBeat.o(87863);
    }
  }
  
  public final ic bG(float paramFloat)
  {
    AppMethodBeat.i(87858);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %d AND priority >= ? AND createtime > ? ORDER BY priority DESC, createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", Integer.valueOf(1) });
    localObject1 = this.AXQ.rawQuery((String)localObject1, new String[] { String.valueOf(paramFloat), String.valueOf(l - 432000000L) });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        ic localic = m((Cursor)localObject1);
        return localic;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87858);
    }
  }
  
  public final ic bH(float paramFloat)
  {
    AppMethodBeat.i(87859);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %d AND priority >= ? AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", Integer.valueOf(1) });
    localObject1 = this.AXQ.rawQuery((String)localObject1, new String[] { String.valueOf(paramFloat), String.valueOf(l - 432000000L) });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        ic localic = m((Cursor)localObject1);
        return localic;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87859);
    }
  }
  
  public final ic eCZ()
  {
    AppMethodBeat.i(87860);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %d AND (reason & %d) > 0 AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", Integer.valueOf(1), Integer.valueOf(128) });
    localObject1 = this.AXQ.rawQuery((String)localObject1, new String[] { String.valueOf(l - 432000000L) });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        ic localic = m((Cursor)localObject1);
        return localic;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87860);
    }
  }
  
  public final ic j(String paramString, float paramFloat)
  {
    AppMethodBeat.i(87861);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %d AND fromuser = ? AND priority >= ? AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", Integer.valueOf(1) });
    paramString = this.AXQ.rawQuery((String)localObject1, new String[] { String.valueOf(paramString), String.valueOf(paramFloat), String.valueOf(l - 432000000L) });
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
      AppMethodBeat.o(87861);
    }
  }
  
  public final void m(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(87855);
    this.AYJ.bindLong(1, paramInt1);
    this.AYJ.bindLong(2, paramInt2);
    this.AYJ.bindLong(3, paramLong);
    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateStatusAndReason %d res %d %d %d", new Object[] { Integer.valueOf(this.AYJ.executeUpdateDelete()), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(87855);
  }
  
  public final ic t(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(87864);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s Img, %s Chat WHERE Chat.rank <= ? AND Chat.totallsp > ? AND Chat.chat = Img.fromuser AND createtime > ? AND Img.status = ? ORDER BY Img.createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", "C2CChatUsageResult" });
    localObject1 = this.AXQ.rawQuery((String)localObject1, new String[] { String.valueOf(paramInt), String.valueOf(paramFloat), String.valueOf(l - 432000000L), "1" });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        ic localic = m((Cursor)localObject1);
        return localic;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87864);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.c.c
 * JD-Core Version:    0.7.0.1
 */