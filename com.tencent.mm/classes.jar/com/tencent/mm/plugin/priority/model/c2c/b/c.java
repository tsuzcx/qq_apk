package com.tencent.mm.plugin.priority.model.c2c.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.protocal.protobuf.in;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wcdb.database.SQLiteStatement;

public class c
{
  private SQLiteStatement MPZ;
  private b MPs;
  public SQLiteStatement MQi;
  public SQLiteStatement MQj;
  private SQLiteStatement MQk;
  private SQLiteStatement MQl;
  SQLiteStatement MQm;
  SQLiteStatement MQn;
  
  public c(b paramb)
  {
    AppMethodBeat.i(87834);
    this.MPs = paramb;
    if (this.MPs.aY(2L, 0L) != 4L)
    {
      if (this.MPs.aDZ("C2CMsgAutoDownloadFile")) {
        this.MPs.aRI("C2CMsgAutoDownloadFile");
      }
      this.MPs.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (id TEXT, fromuser TEXT, realuser TEXT, restype INTEGER, createtime INTEGER, reason INTEGER, status INTEGER, downloadtime INTEGER, msgsvrid LONG, filesize INTEGER, fileext TEXT, opentime INTEGER, priority FLOAT, prioritytype INTEGER, fileid TEXT, PRIMARY KEY(id, msgsvrid));", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.MPs.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s ON %s(priority, createtime);", new Object[] { "C2CMsgAutoDownloadFile_Priority_CreateTime", "C2CMsgAutoDownloadFile" }));
      this.MPs.aZ(2L, 4L);
    }
    for (;;)
    {
      this.MPZ = this.MPs.compileStatement(String.format("INSERT OR IGNORE INTO %s (id, fromuser, realuser, restype, createtime, reason, status, downloadtime, msgsvrid, filesize, fileext, opentime, priority, prioritytype, fileid) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.MQi = this.MPs.compileStatement(String.format("DELETE FROM %s WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.MQj = this.MPs.compileStatement(String.format("DELETE FROM %s WHERE fromuser = ?;", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.MQk = this.MPs.compileStatement(String.format("UPDATE %s SET status = ? WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.MQl = this.MPs.compileStatement(String.format("UPDATE %s SET reason = reason | ?, status = ? WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.MQm = this.MPs.compileStatement(String.format("UPDATE %s SET downloadtime = ?, status = ? WHERE id = ? AND msgsvrid = ? AND downloadtime = 0", new Object[] { "C2CMsgAutoDownloadFile" }));
      this.MQn = this.MPs.compileStatement(String.format("UPDATE %s SET opentime = ? WHERE id = ? AND msgsvrid = ? AND opentime = 0", new Object[] { "C2CMsgAutoDownloadFile" }));
      AppMethodBeat.o(87834);
      return;
      Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "Exist Table %s Count %s", new Object[] { "C2CMsgAutoDownloadFile", Integer.valueOf(this.MPs.aRH("C2CMsgAutoDownloadFile")) });
    }
  }
  
  private static in p(Cursor paramCursor)
  {
    AppMethodBeat.i(87841);
    in localin = new in();
    localin.Id = paramCursor.getString(0);
    localin.YKk = paramCursor.getString(1);
    localin.YKl = paramCursor.getString(2);
    localin.YKm = paramCursor.getInt(3);
    localin.YKn = paramCursor.getLong(4);
    localin.YKo = paramCursor.getInt(5);
    localin.vhk = paramCursor.getInt(6);
    localin.YKp = paramCursor.getLong(7);
    localin.YKq = paramCursor.getLong(8);
    localin.YKr = paramCursor.getInt(9);
    localin.YKs = paramCursor.getString(10);
    localin.YKt = paramCursor.getLong(11);
    localin.YKu = paramCursor.getFloat(12);
    localin.YKv = paramCursor.getInt(13);
    localin.YKw = paramCursor.getString(14);
    AppMethodBeat.o(87841);
    return localin;
  }
  
  public final void a(in paramin)
  {
    AppMethodBeat.i(87835);
    this.MPZ.bindString(1, paramin.Id);
    this.MPZ.bindString(2, paramin.YKk);
    this.MPZ.bindString(3, paramin.YKl);
    this.MPZ.bindLong(4, paramin.YKm);
    this.MPZ.bindLong(5, paramin.YKn);
    this.MPZ.bindLong(6, paramin.YKo);
    this.MPZ.bindLong(7, paramin.vhk);
    this.MPZ.bindLong(8, paramin.YKp);
    this.MPZ.bindLong(9, paramin.YKq);
    this.MPZ.bindLong(10, paramin.YKr);
    this.MPZ.bindString(11, paramin.YKs);
    this.MPZ.bindLong(12, paramin.YKt);
    this.MPZ.bindDouble(13, paramin.YKu);
    this.MPZ.bindLong(14, paramin.YKv);
    this.MPZ.bindString(15, paramin.YKw);
    this.MPZ.execute();
    AppMethodBeat.o(87835);
  }
  
  public final void bq(String paramString, long paramLong)
  {
    AppMethodBeat.i(283807);
    this.MQi.bindString(1, paramString);
    this.MQi.bindLong(2, paramLong);
    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "delete %s img %s %s", new Object[] { Integer.valueOf(this.MQi.executeUpdateDelete()), paramString, Long.valueOf(paramLong) });
    AppMethodBeat.o(283807);
  }
  
  public final boolean br(String paramString, long paramLong)
  {
    AppMethodBeat.i(87837);
    String str = String.format("SELECT 1 FROM %s WHERE id = ? AND msgsvrid = ?", new Object[] { "C2CMsgAutoDownloadFile" });
    paramString = this.MPs.rawQuery(str, new String[] { paramString, String.valueOf(paramLong) });
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
  
  public final in bs(String paramString, long paramLong)
  {
    AppMethodBeat.i(87838);
    Object localObject1 = String.format("SELECT * FROM %s WHERE id = ? AND msgsvrid = ?;", new Object[] { "C2CMsgAutoDownloadFile" });
    paramString = this.MPs.rawQuery((String)localObject1, new String[] { paramString, String.valueOf(paramLong) });
    try
    {
      if (paramString.moveToNext())
      {
        localObject1 = p(paramString);
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
  
  public final in d(float paramFloat, long paramLong)
  {
    AppMethodBeat.i(87839);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %s AND priority >= ? AND createtime > ? AND filesize <= ? ORDER BY priority DESC, createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadFile", Integer.valueOf(1) });
    localObject1 = this.MPs.rawQuery((String)localObject1, new String[] { String.valueOf(paramFloat), String.valueOf(l - 432000000L), String.valueOf(paramLong) });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        in localin = p((Cursor)localObject1);
        return localin;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87839);
    }
  }
  
  public final in gzU()
  {
    AppMethodBeat.i(87840);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %s AND (reason & %s) > 0 AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadFile", Integer.valueOf(1), Integer.valueOf(1) });
    localObject1 = this.MPs.rawQuery((String)localObject1, new String[] { String.valueOf(l - 432000000L) });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        in localin = p((Cursor)localObject1);
        return localin;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(87840);
    }
  }
  
  public final void o(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(87836);
    this.MQk.bindLong(1, paramInt);
    this.MQk.bindString(2, paramString);
    this.MQk.bindLong(3, paramLong);
    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "updateStatus %s res %s %s %s", new Object[] { Integer.valueOf(this.MQk.executeUpdateDelete()), paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(87836);
  }
  
  public final in w(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(161938);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s File, %s Chat WHERE Chat.rank <= ? AND Chat.totallsp > ? AND Chat.chat = File.fromuser AND createtime > ? AND File.status = ? ORDER BY File.createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadFile", "C2CChatUsageResult" });
    localObject1 = this.MPs.rawQuery((String)localObject1, new String[] { String.valueOf(paramInt), String.valueOf(paramFloat), String.valueOf(l - 432000000L), "1" });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        in localin = p((Cursor)localObject1);
        return localin;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.c2c.b.c
 * JD-Core Version:    0.7.0.1
 */