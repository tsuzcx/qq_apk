package com.tencent.mm.plugin.priority.model.a.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.protocal.protobuf.hp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.wcdb.database.SQLiteStatement;

public final class c
{
  public b wKA;
  public SQLiteStatement wLh;
  public SQLiteStatement wLq;
  public SQLiteStatement wLr;
  public SQLiteStatement wLs;
  public SQLiteStatement wLt;
  public SQLiteStatement wLu;
  public SQLiteStatement wLv;
  
  public c(b paramb)
  {
    AppMethodBeat.i(87853);
    this.wKA = paramb;
    if (this.wKA.ad(1L, 0L) != 1L)
    {
      if (this.wKA.akg("C2CMsgAutoDownloadRes")) {
        this.wKA.auw("C2CMsgAutoDownloadRes");
      }
      this.wKA.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (msgid INTEGER PRIMARY KEY, fromuser TEXT, realuser TEXT, restype INTEGER, createtime INTEGER, reason INTEGER, status INTEGER, downloadtime INTEGER, msgsvrid LONG, imgsize INTEGER, opentime INTEGER, priority FLOAT, prioritytype INTEGER);", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.wKA.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s ON %s(priority, createtime);", new Object[] { "C2CMsgAutoDownloadRes_Priority_CreateTime", "C2CMsgAutoDownloadRes" }));
      this.wKA.ae(1L, 1L);
    }
    for (;;)
    {
      this.wLh = this.wKA.compileStatement(String.format("INSERT OR IGNORE INTO %s (msgid, fromuser, realuser, restype, createtime, reason, status, downloadtime, msgsvrid, imgsize, opentime, priority, prioritytype) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.wLq = this.wKA.compileStatement(String.format("DELETE FROM %s WHERE msgid = ?", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.wLr = this.wKA.compileStatement(String.format("DELETE FROM %s WHERE fromuser = ?;", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.wLs = this.wKA.compileStatement(String.format("UPDATE %s SET status = ? WHERE msgid = ?", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.wLt = this.wKA.compileStatement(String.format("UPDATE %s SET reason = reason | ?, status = ? WHERE msgid = ?", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.wLu = this.wKA.compileStatement(String.format("UPDATE %s SET downloadtime = ?, status = ?, imgsize = ? WHERE msgid = ? AND downloadtime = 0", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.wLv = this.wKA.compileStatement(String.format("UPDATE %s SET opentime = ? WHERE msgid = ? AND opentime = 0", new Object[] { "C2CMsgAutoDownloadRes" }));
      AppMethodBeat.o(87853);
      return;
      ad.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "Exist Table %s Count %d", new Object[] { "C2CMsgAutoDownloadRes", Integer.valueOf(this.wKA.auv("C2CMsgAutoDownloadRes")) });
    }
  }
  
  private static hp m(Cursor paramCursor)
  {
    AppMethodBeat.i(87862);
    hp localhp = new hp();
    localhp.FAf = paramCursor.getLong(0);
    localhp.FzS = paramCursor.getString(1);
    localhp.FzT = paramCursor.getString(2);
    localhp.FzU = paramCursor.getInt(3);
    localhp.FzV = paramCursor.getLong(4);
    localhp.FzW = paramCursor.getInt(5);
    localhp.nDG = paramCursor.getInt(6);
    localhp.FzX = paramCursor.getLong(7);
    localhp.FzY = paramCursor.getLong(8);
    localhp.FAg = paramCursor.getInt(9);
    localhp.FAb = paramCursor.getLong(10);
    localhp.FAc = paramCursor.getFloat(11);
    localhp.FAd = paramCursor.getInt(12);
    AppMethodBeat.o(87862);
    return localhp;
  }
  
  public final void S(long paramLong, int paramInt)
  {
    AppMethodBeat.i(87854);
    this.wLs.bindLong(1, paramInt);
    this.wLs.bindLong(2, paramLong);
    ad.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateStatus %d res %d %d", new Object[] { Integer.valueOf(this.wLs.executeUpdateDelete()), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(87854);
  }
  
  public final hp b(String paramString, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(87863);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s Img, %s Chat WHERE Chat.rank <= ? AND Chat.totallsp > ? AND Chat.chat = ? AND Img.fromuser = ? AND Img.createtime > ? AND Img.status = ? ORDER BY Img.createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", "C2CChatUsageResult" });
    paramString = this.wKA.rawQuery((String)localObject1, new String[] { String.valueOf(paramInt), String.valueOf(paramFloat), paramString, paramString, String.valueOf(l - 432000000L), "1" });
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
    localObject1 = this.wKA.rawQuery((String)localObject1, new String[] { String.valueOf(paramFloat), String.valueOf(l - 432000000L) });
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
    localObject1 = this.wKA.rawQuery((String)localObject1, new String[] { String.valueOf(paramFloat), String.valueOf(l - 432000000L) });
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
  
  public final hp dzq()
  {
    AppMethodBeat.i(87860);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %d AND (reason & %d) > 0 AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", Integer.valueOf(1), Integer.valueOf(128) });
    localObject1 = this.wKA.rawQuery((String)localObject1, new String[] { String.valueOf(l - 432000000L) });
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
    paramString = this.wKA.rawQuery((String)localObject1, new String[] { String.valueOf(paramString), String.valueOf(paramFloat), String.valueOf(l - 432000000L) });
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
    this.wLt.bindLong(1, paramInt1);
    this.wLt.bindLong(2, paramInt2);
    this.wLt.bindLong(3, paramLong);
    ad.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateStatusAndReason %d res %d %d %d", new Object[] { Integer.valueOf(this.wLt.executeUpdateDelete()), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(87855);
  }
  
  public final hp s(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(87864);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s Img, %s Chat WHERE Chat.rank <= ? AND Chat.totallsp > ? AND Chat.chat = Img.fromuser AND createtime > ? AND Img.status = ? ORDER BY Img.createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", "C2CChatUsageResult" });
    localObject1 = this.wKA.rawQuery((String)localObject1, new String[] { String.valueOf(paramInt), String.valueOf(paramFloat), String.valueOf(l - 432000000L), "1" });
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
  
  public final boolean yw(long paramLong)
  {
    AppMethodBeat.i(87856);
    Object localObject1 = String.format("SELECT 1 FROM %s WHERE msgid = %d", new Object[] { "C2CMsgAutoDownloadRes", Long.valueOf(paramLong) });
    localObject1 = this.wKA.rawQuery((String)localObject1, null);
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
  
  public final hp yx(long paramLong)
  {
    AppMethodBeat.i(87857);
    Object localObject1 = String.format("SELECT * FROM %s WHERE msgid = %d;", new Object[] { "C2CMsgAutoDownloadRes", Long.valueOf(paramLong) });
    localObject1 = this.wKA.rawQuery((String)localObject1, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.c.c
 * JD-Core Version:    0.7.0.1
 */