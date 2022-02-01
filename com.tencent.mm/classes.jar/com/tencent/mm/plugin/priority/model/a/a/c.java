package com.tencent.mm.plugin.priority.model.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.wcdb.database.SQLiteStatement;

public final class c
{
  public b vDu;
  private SQLiteStatement vEb;
  SQLiteStatement vEc;
  SQLiteStatement vEd;
  private SQLiteStatement vEe;
  
  public c(b paramb)
  {
    AppMethodBeat.i(87823);
    this.vDu = paramb;
    if (this.vDu.ab(49L, 0L) != 5L)
    {
      if (this.vDu.afI("C2CChatUsage")) {
        this.vDu.apq("C2CChatUsage");
      }
      this.vDu.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (chat TEXT, date INTEGER, chattype INTEGER DEFAULT 0, opencount INTEGER DEFAULT 0, sendmsgcount INTEGER DEFAULT 0, staytime INTEGER DEFAULT 0, consumemsgcount INTEGER DEFAULT 0, PRIMARY KEY(chat, date));", new Object[] { "C2CChatUsage" }));
      this.vDu.ac(49L, 5L);
    }
    for (;;)
    {
      this.vEb = this.vDu.compileStatement(String.format("INSERT OR IGNORE INTO %s (chat, date, chattype) VALUES (?,?,?)", new Object[] { "C2CChatUsage" }));
      this.vEc = this.vDu.compileStatement(String.format("UPDATE %s SET opencount = opencount + 1, staytime = staytime + ? WHERE chat = ? AND date = ?", new Object[] { "C2CChatUsage" }));
      this.vEd = this.vDu.compileStatement(String.format("UPDATE %s SET sendmsgcount = sendmsgcount + 1 WHERE chat = ? AND date = ?", new Object[] { "C2CChatUsage" }));
      this.vEe = this.vDu.compileStatement(String.format("UPDATE %s SET consumemsgcount = consumemsgcount + 1 WHERE chat = ? AND date = ?", new Object[] { "C2CChatUsage" }));
      AppMethodBeat.o(87823);
      return;
      ac.i("MicroMsg.Priority.C2CChatUsageStorage", "Exist Table %s Count %d", new Object[] { "C2CChatUsage", Integer.valueOf(this.vDu.app("C2CChatUsage")) });
    }
  }
  
  public final boolean I(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(87824);
    this.vEb.bindString(1, paramString);
    this.vEb.bindLong(2, paramLong1);
    this.vEb.bindLong(3, paramLong2);
    if (this.vEb.executeInsert() >= 0L)
    {
      AppMethodBeat.o(87824);
      return true;
    }
    AppMethodBeat.o(87824);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.a.c
 * JD-Core Version:    0.7.0.1
 */