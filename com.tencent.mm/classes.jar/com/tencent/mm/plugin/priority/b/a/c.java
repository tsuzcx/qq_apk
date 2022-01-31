package com.tencent.mm.plugin.priority.b.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.b.b;
import com.tencent.mm.protocal.protobuf.gh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.wcdb.database.SQLiteStatement;

public final class c
{
  public SQLiteStatement ptG;
  public SQLiteStatement ptH;
  public SQLiteStatement ptI;
  public SQLiteStatement ptJ;
  public SQLiteStatement ptK;
  public SQLiteStatement ptL;
  private b pte;
  
  public c(b paramb)
  {
    AppMethodBeat.i(54913);
    this.pte = paramb;
    if (this.pte.T(1L, 0L) != 1L)
    {
      if (this.pte.OS("C2CMsgAutoDownloadRes")) {
        this.pte.WT("C2CMsgAutoDownloadRes");
      }
      this.pte.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (msgid INTEGER PRIMARY KEY, fromuser TEXT, realuser TEXT, restype INTEGER, createtime INTEGER, reason INTEGER, status INTEGER, downloadtime INTEGER, msgsvrid LONG, imgsize INTEGER, opentime INTEGER, priority FLOAT, prioritytype INTEGER);", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.pte.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s ON %s(priority, createtime);", new Object[] { "C2CMsgAutoDownloadRes_Priority_CreateTime", "C2CMsgAutoDownloadRes" }));
      this.pte.U(1L, 1L);
    }
    for (;;)
    {
      this.ptG = this.pte.compileStatement(String.format("INSERT OR IGNORE INTO %s (msgid, fromuser, realuser, restype, createtime, reason, status, downloadtime, msgsvrid, imgsize, opentime, priority, prioritytype) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.ptH = this.pte.compileStatement(String.format("DELETE FROM %s WHERE msgid = ?", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.ptI = this.pte.compileStatement(String.format("UPDATE %s SET status = ? WHERE msgid = ?", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.ptJ = this.pte.compileStatement(String.format("UPDATE %s SET reason = reason | ?, status = ? WHERE msgid = ?", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.ptK = this.pte.compileStatement(String.format("UPDATE %s SET downloadtime = ?, status = ?, imgsize = ? WHERE msgid = ? AND downloadtime = 0", new Object[] { "C2CMsgAutoDownloadRes" }));
      this.ptL = this.pte.compileStatement(String.format("UPDATE %s SET opentime = ? WHERE msgid = ? AND opentime = 0", new Object[] { "C2CMsgAutoDownloadRes" }));
      AppMethodBeat.o(54913);
      return;
      ab.i("MicroMsg.Priority.C2CMsgAutoDownloadResStorage", "Exist Table %s Count %d", new Object[] { "C2CMsgAutoDownloadRes", Integer.valueOf(this.pte.WS("C2CMsgAutoDownloadRes")) });
    }
  }
  
  private static gh k(Cursor paramCursor)
  {
    AppMethodBeat.i(54922);
    gh localgh = new gh();
    localgh.wsz = paramCursor.getLong(0);
    localgh.pIB = paramCursor.getString(1);
    localgh.wsA = paramCursor.getString(2);
    localgh.wsB = paramCursor.getInt(3);
    localgh.wsC = paramCursor.getLong(4);
    localgh.wsD = paramCursor.getInt(5);
    localgh.jJS = paramCursor.getInt(6);
    localgh.wsE = paramCursor.getLong(7);
    localgh.wsF = paramCursor.getLong(8);
    localgh.wsG = paramCursor.getInt(9);
    localgh.wsH = paramCursor.getLong(10);
    localgh.wsI = paramCursor.getFloat(11);
    localgh.wsJ = paramCursor.getInt(12);
    AppMethodBeat.o(54922);
    return localgh;
  }
  
  public final void C(long paramLong, int paramInt)
  {
    AppMethodBeat.i(54914);
    this.ptI.bindLong(1, paramInt);
    this.ptI.bindLong(2, paramLong);
    ab.i("MicroMsg.Priority.C2CMsgAutoDownloadResStorage", "updateStatus %d res %d %d", new Object[] { Integer.valueOf(this.ptI.executeUpdateDelete()), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(54914);
  }
  
  public final gh aS(float paramFloat)
  {
    AppMethodBeat.i(54918);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %d AND priority >= ? AND createtime > ? ORDER BY priority DESC, createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", Integer.valueOf(1) });
    localObject1 = this.pte.rawQuery((String)localObject1, new String[] { String.valueOf(paramFloat), String.valueOf(l - 432000000L) });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        gh localgh = k((Cursor)localObject1);
        return localgh;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(54918);
    }
  }
  
  public final gh aT(float paramFloat)
  {
    AppMethodBeat.i(54919);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %d AND priority >= ? AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", Integer.valueOf(1) });
    localObject1 = this.pte.rawQuery((String)localObject1, new String[] { String.valueOf(paramFloat), String.valueOf(l - 432000000L) });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        gh localgh = k((Cursor)localObject1);
        return localgh;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(54919);
    }
  }
  
  public final gh caR()
  {
    AppMethodBeat.i(54920);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %d AND (reason & %d) > 0 AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", Integer.valueOf(1), Integer.valueOf(128) });
    localObject1 = this.pte.rawQuery((String)localObject1, new String[] { String.valueOf(l - 432000000L) });
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        gh localgh = k((Cursor)localObject1);
        return localgh;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(54920);
    }
  }
  
  public final gh j(String paramString, float paramFloat)
  {
    AppMethodBeat.i(54921);
    long l = System.currentTimeMillis();
    Object localObject1 = String.format("SELECT * FROM %s WHERE status = %d AND fromuser = ? AND priority >= ? AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[] { "C2CMsgAutoDownloadRes", Integer.valueOf(1) });
    paramString = this.pte.rawQuery((String)localObject1, new String[] { String.valueOf(paramString), String.valueOf(paramFloat), String.valueOf(l - 432000000L) });
    try
    {
      if (paramString.moveToNext())
      {
        localObject1 = k(paramString);
        return localObject1;
      }
      return null;
    }
    finally
    {
      paramString.close();
      AppMethodBeat.o(54921);
    }
  }
  
  public final boolean kR(long paramLong)
  {
    AppMethodBeat.i(54916);
    Object localObject1 = String.format("SELECT 1 FROM %s WHERE msgid = %d", new Object[] { "C2CMsgAutoDownloadRes", Long.valueOf(paramLong) });
    localObject1 = this.pte.rawQuery((String)localObject1, null);
    try
    {
      boolean bool = ((Cursor)localObject1).moveToNext();
      return bool;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(54916);
    }
  }
  
  public final gh kS(long paramLong)
  {
    AppMethodBeat.i(54917);
    Object localObject1 = String.format("SELECT * FROM %s WHERE msgid = %d;", new Object[] { "C2CMsgAutoDownloadRes", Long.valueOf(paramLong) });
    localObject1 = this.pte.rawQuery((String)localObject1, null);
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        gh localgh = k((Cursor)localObject1);
        return localgh;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(54917);
    }
  }
  
  public final void l(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54915);
    this.ptJ.bindLong(1, paramInt1);
    this.ptJ.bindLong(2, paramInt2);
    this.ptJ.bindLong(3, paramLong);
    ab.i("MicroMsg.Priority.C2CMsgAutoDownloadResStorage", "updateStatusAndReason %d res %d %d %d", new Object[] { Integer.valueOf(this.ptJ.executeUpdateDelete()), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(54915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.b.a.c
 * JD-Core Version:    0.7.0.1
 */