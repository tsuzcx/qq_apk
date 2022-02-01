package com.tencent.mm.plugin.priority.model.c2c.img;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.protocal.protobuf.io;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wcdb.database.SQLiteStatement;

public class c
{
  public SQLiteStatement MPZ;
  public b MPs;
  public SQLiteStatement MQi;
  public SQLiteStatement MQj;
  public SQLiteStatement MQk;
  public SQLiteStatement MQl;
  public SQLiteStatement MQm;
  public SQLiteStatement MQn;
  
  public c(b paramb)
  {
    AppMethodBeat.i(87853);
    this.MPs = paramb;
    if (this.MPs.aY(1L, 0L) != 1L)
    {
      if (this.MPs.aDZ("C2CMsgAutoDownloadRes")) {
        this.MPs.aRI("C2CMsgAutoDownloadRes");
      }
      this.MPs.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (msgid INTEGER PRIMARY KEY, fromuser TEXT, realuser TEXT, restype INTEGER, createtime INTEGER, reason INTEGER, status INTEGER, downloadtime INTEGER, msgsvrid LONG, imgsize INTEGER, opentime INTEGER, priority FLOAT, prioritytype INTEGER);", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.MPs.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s ON %s(priority, createtime);", new Object[] { "C2CMsgAutoDownloadRes_Priority_CreateTime", "C2CMsgAutoDownloadRes" }));
      this.MPs.aZ(1L, 1L);
    }
    for (;;)
    {
      this.MPZ = this.MPs.compileStatement(String.format("INSERT OR IGNORE INTO %s (msgid, fromuser, realuser, restype, createtime, reason, status, downloadtime, msgsvrid, imgsize, opentime, priority, prioritytype) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.MQi = this.MPs.compileStatement(String.format("DELETE FROM %s WHERE msgid = ?", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.MQj = this.MPs.compileStatement(String.format("DELETE FROM %s WHERE fromuser = ?;", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.MQk = this.MPs.compileStatement(String.format("UPDATE %s SET status = ? WHERE msgid = ?", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.MQl = this.MPs.compileStatement(String.format("UPDATE %s SET reason = reason | ?, status = ? WHERE msgid = ?", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.MQm = this.MPs.compileStatement(String.format("UPDATE %s SET downloadtime = ?, status = ?, imgsize = ? WHERE msgid = ? AND downloadtime = 0", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.MQn = this.MPs.compileStatement(String.format("UPDATE %s SET opentime = ? WHERE msgid = ? AND opentime = 0", new Object[] { "C2CMsgAutoDownloadRes" }));
      AppMethodBeat.o(87853);
      return;
      Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "Exist Table %s Count %d", new Object[] { "C2CMsgAutoDownloadRes", Integer.valueOf(this.MPs.aRH("C2CMsgAutoDownloadRes")) });
    }
  }
  
  private static io q(Cursor paramCursor)
  {
    AppMethodBeat.i(87862);
    io localio = new io();
    localio.YKx = paramCursor.getLong(0);
    localio.YKk = paramCursor.getString(1);
    localio.YKl = paramCursor.getString(2);
    localio.YKm = paramCursor.getInt(3);
    localio.YKn = paramCursor.getLong(4);
    localio.YKo = paramCursor.getInt(5);
    localio.vhk = paramCursor.getInt(6);
    localio.YKp = paramCursor.getLong(7);
    localio.YKq = paramCursor.getLong(8);
    localio.YKy = paramCursor.getInt(9);
    localio.YKt = paramCursor.getLong(10);
    localio.YKu = paramCursor.getFloat(11);
    localio.YKv = paramCursor.getInt(12);
    AppMethodBeat.o(87862);
    return localio;
  }
  
  public final void ar(long paramLong, int paramInt)
  {
    AppMethodBeat.i(87854);
    this.MQk.bindLong(1, paramInt);
    this.MQk.bindLong(2, paramLong);
    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateStatus %d res %d %d", new Object[] { Integer.valueOf(this.MQk.executeUpdateDelete()), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(87854);
  }
  
  public final io b(String paramString, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(87863);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s Img, %s Chat WHERE Chat.rank <= ? AND Chat.totallsp > ? AND Chat.chat = ? AND Img.fromuser = ? AND Img.createtime > ? AND Img.status = ? ORDER BY Img.createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", "C2CChatUsageResult" });
    paramString = this.MPs.rawQuery((String)localObject1, new String[] { String.valueOf(paramInt), String.valueOf(paramFloat), paramString, paramString, String.valueOf(l - 432000000L), "1" });
    try
    {
      if (paramString.moveToNext())
      {
        localObject1 = q(paramString);
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
  
  public final io cQ(float paramFloat)
  {
    AppMethodBeat.i(87858);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %d AND priority >= ? AND createtime > ? ORDER BY priority DESC, createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", Integer.valueOf(1) });
    localObject1 = this.MPs.rawQuery((String)localObject1, new String[] { String.valueOf(paramFloat), String.valueOf(l - 432000000L) });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        io localio = q((Cursor)localObject1);
        return localio;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87858);
    }
  }
  
  public final io cR(float paramFloat)
  {
    AppMethodBeat.i(87859);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %d AND priority >= ? AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", Integer.valueOf(1) });
    localObject1 = this.MPs.rawQuery((String)localObject1, new String[] { String.valueOf(paramFloat), String.valueOf(l - 432000000L) });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        io localio = q((Cursor)localObject1);
        return localio;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87859);
    }
  }
  
  public final void delete(long paramLong)
  {
    AppMethodBeat.i(283817);
    this.MQi.bindLong(1, paramLong);
    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "delete %d img %d", new Object[] { Integer.valueOf(this.MQi.executeUpdateDelete()), Long.valueOf(paramLong) });
    AppMethodBeat.o(283817);
  }
  
  public final io gzW()
  {
    AppMethodBeat.i(87860);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %d AND (reason & %d) > 0 AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", Integer.valueOf(1), Integer.valueOf(128) });
    localObject1 = this.MPs.rawQuery((String)localObject1, new String[] { String.valueOf(l - 432000000L) });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        io localio = q((Cursor)localObject1);
        return localio;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87860);
    }
  }
  
  public final io l(String paramString, float paramFloat)
  {
    AppMethodBeat.i(87861);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %d AND fromuser = ? AND priority >= ? AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", Integer.valueOf(1) });
    paramString = this.MPs.rawQuery((String)localObject1, new String[] { String.valueOf(paramString), String.valueOf(paramFloat), String.valueOf(l - 432000000L) });
    try
    {
      if (paramString.moveToNext())
      {
        localObject1 = q(paramString);
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
  
  public final boolean th(long paramLong)
  {
    AppMethodBeat.i(87856);
    Object localObject1 = String.format("SELECT 1 FROM %s WHERE msgid = %d", new Object[] { "C2CMsgAutoDownloadRes", Long.valueOf(paramLong) });
    localObject1 = this.MPs.rawQuery((String)localObject1, null);
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
  
  public final io ti(long paramLong)
  {
    AppMethodBeat.i(87857);
    Object localObject1 = String.format("SELECT * FROM %s WHERE msgid = %d;", new Object[] { "C2CMsgAutoDownloadRes", Long.valueOf(paramLong) });
    localObject1 = this.MPs.rawQuery((String)localObject1, null);
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        io localio = q((Cursor)localObject1);
        return localio;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87857);
    }
  }
  
  public final void v(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(87855);
    this.MQl.bindLong(1, paramInt1);
    this.MQl.bindLong(2, paramInt2);
    this.MQl.bindLong(3, paramLong);
    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateStatusAndReason %d res %d %d %d", new Object[] { Integer.valueOf(this.MQl.executeUpdateDelete()), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(87855);
  }
  
  public final io x(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(87864);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s Img, %s Chat WHERE Chat.rank <= ? AND Chat.totallsp > ? AND Chat.chat = Img.fromuser AND createtime > ? AND Img.status = ? ORDER BY Img.createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", "C2CChatUsageResult" });
    localObject1 = this.MPs.rawQuery((String)localObject1, new String[] { String.valueOf(paramInt), String.valueOf(paramFloat), String.valueOf(l - 432000000L), "1" });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        io localio = q((Cursor)localObject1);
        return localio;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.c2c.img.c
 * JD-Core Version:    0.7.0.1
 */