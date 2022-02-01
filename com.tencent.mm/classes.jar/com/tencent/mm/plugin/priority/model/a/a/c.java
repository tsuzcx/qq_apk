package com.tencent.mm.plugin.priority.model.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.wcdb.database.SQLiteStatement;

public final class c
{
  public b uuB;
  private SQLiteStatement uvi;
  SQLiteStatement uvj;
  SQLiteStatement uvk;
  private SQLiteStatement uvl;
  
  public c(b paramb)
  {
    AppMethodBeat.i(87823);
    this.uuB = paramb;
    if (this.uuB.ae(49L, 0L) != 5L)
    {
      if (this.uuB.aaQ("C2CChatUsage")) {
        this.uuB.akr("C2CChatUsage");
      }
      this.uuB.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (chat TEXT, date INTEGER, chattype INTEGER DEFAULT 0, opencount INTEGER DEFAULT 0, sendmsgcount INTEGER DEFAULT 0, staytime INTEGER DEFAULT 0, consumemsgcount INTEGER DEFAULT 0, PRIMARY KEY(chat, date));", new Object[] { "C2CChatUsage" }));
      this.uuB.af(49L, 5L);
    }
    for (;;)
    {
      this.uvi = this.uuB.compileStatement(String.format("INSERT OR IGNORE INTO %s (chat, date, chattype) VALUES (?,?,?)", new Object[] { "C2CChatUsage" }));
      this.uvj = this.uuB.compileStatement(String.format("UPDATE %s SET opencount = opencount + 1, staytime = staytime + ? WHERE chat = ? AND date = ?", new Object[] { "C2CChatUsage" }));
      this.uvk = this.uuB.compileStatement(String.format("UPDATE %s SET sendmsgcount = sendmsgcount + 1 WHERE chat = ? AND date = ?", new Object[] { "C2CChatUsage" }));
      this.uvl = this.uuB.compileStatement(String.format("UPDATE %s SET consumemsgcount = consumemsgcount + 1 WHERE chat = ? AND date = ?", new Object[] { "C2CChatUsage" }));
      AppMethodBeat.o(87823);
      return;
      ad.i("MicroMsg.Priority.C2CChatUsageStorage", "Exist Table %s Count %d", new Object[] { "C2CChatUsage", Integer.valueOf(this.uuB.akq("C2CChatUsage")) });
    }
  }
  
  public final boolean K(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(87824);
    this.uvi.bindString(1, paramString);
    this.uvi.bindLong(2, paramLong1);
    this.uvi.bindLong(3, paramLong2);
    if (this.uvi.executeInsert() >= 0L)
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