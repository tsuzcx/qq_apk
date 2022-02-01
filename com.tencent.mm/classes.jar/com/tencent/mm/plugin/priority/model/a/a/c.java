package com.tencent.mm.plugin.priority.model.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wcdb.database.SQLiteStatement;

public final class c
{
  public b AXQ;
  private SQLiteStatement AYA;
  private SQLiteStatement AYx;
  SQLiteStatement AYy;
  SQLiteStatement AYz;
  
  public c(b paramb)
  {
    AppMethodBeat.i(87823);
    this.AXQ = paramb;
    if (this.AXQ.ag(49L, 0L) != 5L)
    {
      if (this.AXQ.ayi("C2CChatUsage")) {
        this.AXQ.aKd("C2CChatUsage");
      }
      this.AXQ.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (chat TEXT, date INTEGER, chattype INTEGER DEFAULT 0, opencount INTEGER DEFAULT 0, sendmsgcount INTEGER DEFAULT 0, staytime INTEGER DEFAULT 0, consumemsgcount INTEGER DEFAULT 0, PRIMARY KEY(chat, date));", new Object[] { "C2CChatUsage" }));
      this.AXQ.ah(49L, 5L);
    }
    for (;;)
    {
      this.AYx = this.AXQ.compileStatement(String.format("INSERT OR IGNORE INTO %s (chat, date, chattype) VALUES (?,?,?)", new Object[] { "C2CChatUsage" }));
      this.AYy = this.AXQ.compileStatement(String.format("UPDATE %s SET opencount = opencount + 1, staytime = staytime + ? WHERE chat = ? AND date = ?", new Object[] { "C2CChatUsage" }));
      this.AYz = this.AXQ.compileStatement(String.format("UPDATE %s SET sendmsgcount = sendmsgcount + 1 WHERE chat = ? AND date = ?", new Object[] { "C2CChatUsage" }));
      this.AYA = this.AXQ.compileStatement(String.format("UPDATE %s SET consumemsgcount = consumemsgcount + 1 WHERE chat = ? AND date = ?", new Object[] { "C2CChatUsage" }));
      AppMethodBeat.o(87823);
      return;
      Log.i("MicroMsg.Priority.C2CChatUsageStorage", "Exist Table %s Count %d", new Object[] { "C2CChatUsage", Integer.valueOf(this.AXQ.aKc("C2CChatUsage")) });
    }
  }
  
  public final boolean K(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(87824);
    this.AYx.bindString(1, paramString);
    this.AYx.bindLong(2, paramLong1);
    this.AYx.bindLong(3, paramLong2);
    if (this.AYx.executeInsert() >= 0L)
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