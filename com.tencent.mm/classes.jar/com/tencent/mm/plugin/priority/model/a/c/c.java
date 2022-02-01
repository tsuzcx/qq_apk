package com.tencent.mm.plugin.priority.model.a.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.protocal.protobuf.hp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.wcdb.database.SQLiteStatement;

public final class c
{
  public SQLiteStatement xaV;
  public b xao;
  public SQLiteStatement xbe;
  public SQLiteStatement xbf;
  public SQLiteStatement xbg;
  public SQLiteStatement xbh;
  public SQLiteStatement xbi;
  public SQLiteStatement xbj;
  
  public c(b paramb)
  {
    AppMethodBeat.i(87853);
    this.xao = paramb;
    if (this.xao.ac(1L, 0L) != 1L)
    {
      if (this.xao.ale("C2CMsgAutoDownloadRes")) {
        this.xao.avL("C2CMsgAutoDownloadRes");
      }
      this.xao.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (msgid INTEGER PRIMARY KEY, fromuser TEXT, realuser TEXT, restype INTEGER, createtime INTEGER, reason INTEGER, status INTEGER, downloadtime INTEGER, msgsvrid LONG, imgsize INTEGER, opentime INTEGER, priority FLOAT, prioritytype INTEGER);", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.xao.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s ON %s(priority, createtime);", new Object[] { "C2CMsgAutoDownloadRes_Priority_CreateTime", "C2CMsgAutoDownloadRes" }));
      this.xao.ad(1L, 1L);
    }
    for (;;)
    {
      this.xaV = this.xao.compileStatement(String.format("INSERT OR IGNORE INTO %s (msgid, fromuser, realuser, restype, createtime, reason, status, downloadtime, msgsvrid, imgsize, opentime, priority, prioritytype) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.xbe = this.xao.compileStatement(String.format("DELETE FROM %s WHERE msgid = ?", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.xbf = this.xao.compileStatement(String.format("DELETE FROM %s WHERE fromuser = ?;", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.xbg = this.xao.compileStatement(String.format("UPDATE %s SET status = ? WHERE msgid = ?", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.xbh = this.xao.compileStatement(String.format("UPDATE %s SET reason = reason | ?, status = ? WHERE msgid = ?", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.xbi = this.xao.compileStatement(String.format("UPDATE %s SET downloadtime = ?, status = ?, imgsize = ? WHERE msgid = ? AND downloadtime = 0", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.xbj = this.xao.compileStatement(String.format("UPDATE %s SET opentime = ? WHERE msgid = ? AND opentime = 0", new Object[] { "C2CMsgAutoDownloadRes" }));
      AppMethodBeat.o(87853);
      return;
      ae.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "Exist Table %s Count %d", new Object[] { "C2CMsgAutoDownloadRes", Integer.valueOf(this.xao.avK("C2CMsgAutoDownloadRes")) });
    }
  }
  
  private static hp m(Cursor paramCursor)
  {
    AppMethodBeat.i(87862);
    hp localhp = new hp();
    localhp.FSD = paramCursor.getLong(0);
    localhp.FSq = paramCursor.getString(1);
    localhp.FSr = paramCursor.getString(2);
    localhp.FSs = paramCursor.getInt(3);
    localhp.FSt = paramCursor.getLong(4);
    localhp.FSu = paramCursor.getInt(5);
    localhp.nJb = paramCursor.getInt(6);
    localhp.FSv = paramCursor.getLong(7);
    localhp.FSw = paramCursor.getLong(8);
    localhp.FSE = paramCursor.getInt(9);
    localhp.FSz = paramCursor.getLong(10);
    localhp.FSA = paramCursor.getFloat(11);
    localhp.FSB = paramCursor.getInt(12);
    AppMethodBeat.o(87862);
    return localhp;
  }
  
  public final void S(long paramLong, int paramInt)
  {
    AppMethodBeat.i(87854);
    this.xbg.bindLong(1, paramInt);
    this.xbg.bindLong(2, paramLong);
    ae.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateStatus %d res %d %d", new Object[] { Integer.valueOf(this.xbg.executeUpdateDelete()), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(87854);
  }
  
  public final hp b(String paramString, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(87863);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s Img, %s Chat WHERE Chat.rank <= ? AND Chat.totallsp > ? AND Chat.chat = ? AND Img.fromuser = ? AND Img.createtime > ? AND Img.status = ? ORDER BY Img.createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", "C2CChatUsageResult" });
    paramString = this.xao.rawQuery((String)localObject1, new String[] { String.valueOf(paramInt), String.valueOf(paramFloat), paramString, paramString, String.valueOf(l - 432000000L), "1" });
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
  
  public final hp bo(float paramFloat)
  {
    AppMethodBeat.i(87858);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %d AND priority >= ? AND createtime > ? ORDER BY priority DESC, createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", Integer.valueOf(1) });
    localObject1 = this.xao.rawQuery((String)localObject1, new String[] { String.valueOf(paramFloat), String.valueOf(l - 432000000L) });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        hp localhp = m((Cursor)localObject1);
        return localhp;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87858);
    }
  }
  
  public final hp bp(float paramFloat)
  {
    AppMethodBeat.i(87859);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %d AND priority >= ? AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", Integer.valueOf(1) });
    localObject1 = this.xao.rawQuery((String)localObject1, new String[] { String.valueOf(paramFloat), String.valueOf(l - 432000000L) });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        hp localhp = m((Cursor)localObject1);
        return localhp;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87859);
    }
  }
  
  public final hp dCH()
  {
    AppMethodBeat.i(87860);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %d AND (reason & %d) > 0 AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", Integer.valueOf(1), Integer.valueOf(128) });
    localObject1 = this.xao.rawQuery((String)localObject1, new String[] { String.valueOf(l - 432000000L) });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        hp localhp = m((Cursor)localObject1);
        return localhp;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87860);
    }
  }
  
  public final hp l(String paramString, float paramFloat)
  {
    AppMethodBeat.i(87861);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %d AND fromuser = ? AND priority >= ? AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", Integer.valueOf(1) });
    paramString = this.xao.rawQuery((String)localObject1, new String[] { String.valueOf(paramString), String.valueOf(paramFloat), String.valueOf(l - 432000000L) });
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
  
  public final void n(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(87855);
    this.xbh.bindLong(1, paramInt1);
    this.xbh.bindLong(2, paramInt2);
    this.xbh.bindLong(3, paramLong);
    ae.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateStatusAndReason %d res %d %d %d", new Object[] { Integer.valueOf(this.xbh.executeUpdateDelete()), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(87855);
  }
  
  public final hp s(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(87864);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s Img, %s Chat WHERE Chat.rank <= ? AND Chat.totallsp > ? AND Chat.chat = Img.fromuser AND createtime > ? AND Img.status = ? ORDER BY Img.createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", "C2CChatUsageResult" });
    localObject1 = this.xao.rawQuery((String)localObject1, new String[] { String.valueOf(paramInt), String.valueOf(paramFloat), String.valueOf(l - 432000000L), "1" });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        hp localhp = m((Cursor)localObject1);
        return localhp;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87864);
    }
  }
  
  public final boolean yV(long paramLong)
  {
    AppMethodBeat.i(87856);
    Object localObject1 = String.format("SELECT 1 FROM %s WHERE msgid = %d", new Object[] { "C2CMsgAutoDownloadRes", Long.valueOf(paramLong) });
    localObject1 = this.xao.rawQuery((String)localObject1, null);
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
  
  public final hp yW(long paramLong)
  {
    AppMethodBeat.i(87857);
    Object localObject1 = String.format("SELECT * FROM %s WHERE msgid = %d;", new Object[] { "C2CMsgAutoDownloadRes", Long.valueOf(paramLong) });
    localObject1 = this.xao.rawQuery((String)localObject1, null);
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        hp localhp = m((Cursor)localObject1);
        return localhp;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.c.c
 * JD-Core Version:    0.7.0.1
 */