package com.tencent.mm.plugin.priority.model.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wcdb.database.SQLiteStatement;

public class c
{
  public b GRO;
  private SQLiteStatement GSv;
  SQLiteStatement GSw;
  SQLiteStatement GSx;
  private SQLiteStatement GSy;
  
  public c(b paramb)
  {
    AppMethodBeat.i(87823);
    this.GRO = paramb;
    if (this.GRO.ao(49L, 0L) != 5L)
    {
      if (this.GRO.aHB("C2CChatUsage")) {
        this.GRO.aUA("C2CChatUsage");
      }
      this.GRO.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (chat TEXT, date INTEGER, chattype INTEGER DEFAULT 0, opencount INTEGER DEFAULT 0, sendmsgcount INTEGER DEFAULT 0, staytime INTEGER DEFAULT 0, consumemsgcount INTEGER DEFAULT 0, PRIMARY KEY(chat, date));", new Object[] { "C2CChatUsage" }));
      this.GRO.ap(49L, 5L);
    }
    for (;;)
    {
      this.GSv = this.GRO.compileStatement(String.format("INSERT OR IGNORE INTO %s (chat, date, chattype) VALUES (?,?,?)", new Object[] { "C2CChatUsage" }));
      this.GSw = this.GRO.compileStatement(String.format("UPDATE %s SET opencount = opencount + 1, staytime = staytime + ? WHERE chat = ? AND date = ?", new Object[] { "C2CChatUsage" }));
      this.GSx = this.GRO.compileStatement(String.format("UPDATE %s SET sendmsgcount = sendmsgcount + 1 WHERE chat = ? AND date = ?", new Object[] { "C2CChatUsage" }));
      this.GSy = this.GRO.compileStatement(String.format("UPDATE %s SET consumemsgcount = consumemsgcount + 1 WHERE chat = ? AND date = ?", new Object[] { "C2CChatUsage" }));
      AppMethodBeat.o(87823);
      return;
      Log.i("MicroMsg.Priority.C2CChatUsageStorage", "Exist Table %s Count %d", new Object[] { "C2CChatUsage", Integer.valueOf(this.GRO.aUz("C2CChatUsage")) });
    }
  }
  
  public final boolean J(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(87824);
    this.GSv.bindString(1, paramString);
    this.GSv.bindLong(2, paramLong1);
    this.GSv.bindLong(3, paramLong2);
    if (this.GSv.executeInsert() >= 0L)
    {
      AppMethodBeat.o(87824);
      return true;
    }
    AppMethodBeat.o(87824);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.a.c
 * JD-Core Version:    0.7.0.1
 */