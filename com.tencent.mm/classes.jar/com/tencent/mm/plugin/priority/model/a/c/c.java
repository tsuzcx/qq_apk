package com.tencent.mm.plugin.priority.model.a.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.protocal.protobuf.hi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.wcdb.database.SQLiteStatement;

public final class c
{
  public b vDu;
  public SQLiteStatement vEb;
  public SQLiteStatement vEk;
  public SQLiteStatement vEl;
  public SQLiteStatement vEm;
  public SQLiteStatement vEn;
  public SQLiteStatement vEo;
  public SQLiteStatement vEp;
  
  public c(b paramb)
  {
    AppMethodBeat.i(87853);
    this.vDu = paramb;
    if (this.vDu.ab(1L, 0L) != 1L)
    {
      if (this.vDu.afI("C2CMsgAutoDownloadRes")) {
        this.vDu.apq("C2CMsgAutoDownloadRes");
      }
      this.vDu.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (msgid INTEGER PRIMARY KEY, fromuser TEXT, realuser TEXT, restype INTEGER, createtime INTEGER, reason INTEGER, status INTEGER, downloadtime INTEGER, msgsvrid LONG, imgsize INTEGER, opentime INTEGER, priority FLOAT, prioritytype INTEGER);", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.vDu.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s ON %s(priority, createtime);", new Object[] { "C2CMsgAutoDownloadRes_Priority_CreateTime", "C2CMsgAutoDownloadRes" }));
      this.vDu.ac(1L, 1L);
    }
    for (;;)
    {
      this.vEb = this.vDu.compileStatement(String.format("INSERT OR IGNORE INTO %s (msgid, fromuser, realuser, restype, createtime, reason, status, downloadtime, msgsvrid, imgsize, opentime, priority, prioritytype) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.vEk = this.vDu.compileStatement(String.format("DELETE FROM %s WHERE msgid = ?", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.vEl = this.vDu.compileStatement(String.format("DELETE FROM %s WHERE fromuser = ?;", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.vEm = this.vDu.compileStatement(String.format("UPDATE %s SET status = ? WHERE msgid = ?", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.vEn = this.vDu.compileStatement(String.format("UPDATE %s SET reason = reason | ?, status = ? WHERE msgid = ?", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.vEo = this.vDu.compileStatement(String.format("UPDATE %s SET downloadtime = ?, status = ?, imgsize = ? WHERE msgid = ? AND downloadtime = 0", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.vEp = this.vDu.compileStatement(String.format("UPDATE %s SET opentime = ? WHERE msgid = ? AND opentime = 0", new Object[] { "C2CMsgAutoDownloadRes" }));
      AppMethodBeat.o(87853);
      return;
      ac.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "Exist Table %s Count %d", new Object[] { "C2CMsgAutoDownloadRes", Integer.valueOf(this.vDu.app("C2CMsgAutoDownloadRes")) });
    }
  }
  
  private static hi m(Cursor paramCursor)
  {
    AppMethodBeat.i(87862);
    hi localhi = new hi();
    localhi.DUK = paramCursor.getLong(0);
    localhi.vTL = paramCursor.getString(1);
    localhi.DUy = paramCursor.getString(2);
    localhi.DUz = paramCursor.getInt(3);
    localhi.DUA = paramCursor.getLong(4);
    localhi.DUB = paramCursor.getInt(5);
    localhi.ndj = paramCursor.getInt(6);
    localhi.DUC = paramCursor.getLong(7);
    localhi.DUD = paramCursor.getLong(8);
    localhi.DUL = paramCursor.getInt(9);
    localhi.DUG = paramCursor.getLong(10);
    localhi.DUH = paramCursor.getFloat(11);
    localhi.DUI = paramCursor.getInt(12);
    AppMethodBeat.o(87862);
    return localhi;
  }
  
  public final void O(long paramLong, int paramInt)
  {
    AppMethodBeat.i(87854);
    this.vEm.bindLong(1, paramInt);
    this.vEm.bindLong(2, paramLong);
    ac.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateStatus %d res %d %d", new Object[] { Integer.valueOf(this.vEm.executeUpdateDelete()), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(87854);
  }
  
  public final hi b(String paramString, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(87863);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s Img, %s Chat WHERE Chat.rank <= ? AND Chat.totallsp > ? AND Chat.chat = ? AND Img.fromuser = ? AND Img.createtime > ? AND Img.status = ? ORDER BY Img.createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", "C2CChatUsageResult" });
    paramString = this.vDu.rawQuery((String)localObject1, new String[] { String.valueOf(paramInt), String.valueOf(paramFloat), paramString, paramString, String.valueOf(l - 432000000L), "1" });
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
  
  public final hi bl(float paramFloat)
  {
    AppMethodBeat.i(87858);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %d AND priority >= ? AND createtime > ? ORDER BY priority DESC, createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", Integer.valueOf(1) });
    localObject1 = this.vDu.rawQuery((String)localObject1, new String[] { String.valueOf(paramFloat), String.valueOf(l - 432000000L) });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        hi localhi = m((Cursor)localObject1);
        return localhi;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87858);
    }
  }
  
  public final hi bm(float paramFloat)
  {
    AppMethodBeat.i(87859);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %d AND priority >= ? AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", Integer.valueOf(1) });
    localObject1 = this.vDu.rawQuery((String)localObject1, new String[] { String.valueOf(paramFloat), String.valueOf(l - 432000000L) });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        hi localhi = m((Cursor)localObject1);
        return localhi;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87859);
    }
  }
  
  public final hi doO()
  {
    AppMethodBeat.i(87860);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %d AND (reason & %d) > 0 AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", Integer.valueOf(1), Integer.valueOf(128) });
    localObject1 = this.vDu.rawQuery((String)localObject1, new String[] { String.valueOf(l - 432000000L) });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        hi localhi = m((Cursor)localObject1);
        return localhi;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87860);
    }
  }
  
  public final hi k(String paramString, float paramFloat)
  {
    AppMethodBeat.i(87861);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %d AND fromuser = ? AND priority >= ? AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", Integer.valueOf(1) });
    paramString = this.vDu.rawQuery((String)localObject1, new String[] { String.valueOf(paramString), String.valueOf(paramFloat), String.valueOf(l - 432000000L) });
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
    this.vEn.bindLong(1, paramInt1);
    this.vEn.bindLong(2, paramInt2);
    this.vEn.bindLong(3, paramLong);
    ac.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateStatusAndReason %d res %d %d %d", new Object[] { Integer.valueOf(this.vEn.executeUpdateDelete()), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(87855);
  }
  
  public final hi r(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(87864);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s Img, %s Chat WHERE Chat.rank <= ? AND Chat.totallsp > ? AND Chat.chat = Img.fromuser AND createtime > ? AND Img.status = ? ORDER BY Img.createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", "C2CChatUsageResult" });
    localObject1 = this.vDu.rawQuery((String)localObject1, new String[] { String.valueOf(paramInt), String.valueOf(paramFloat), String.valueOf(l - 432000000L), "1" });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        hi localhi = m((Cursor)localObject1);
        return localhi;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87864);
    }
  }
  
  public final boolean wl(long paramLong)
  {
    AppMethodBeat.i(87856);
    Object localObject1 = String.format("SELECT 1 FROM %s WHERE msgid = %d", new Object[] { "C2CMsgAutoDownloadRes", Long.valueOf(paramLong) });
    localObject1 = this.vDu.rawQuery((String)localObject1, null);
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
  
  public final hi wm(long paramLong)
  {
    AppMethodBeat.i(87857);
    Object localObject1 = String.format("SELECT * FROM %s WHERE msgid = %d;", new Object[] { "C2CMsgAutoDownloadRes", Long.valueOf(paramLong) });
    localObject1 = this.vDu.rawQuery((String)localObject1, null);
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        hi localhi = m((Cursor)localObject1);
        return localhi;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87857);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.c.c
 * JD-Core Version:    0.7.0.1
 */