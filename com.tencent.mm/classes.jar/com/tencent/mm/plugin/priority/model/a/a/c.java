package com.tencent.mm.plugin.priority.model.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.wcdb.database.SQLiteStatement;

public final class c
{
  private SQLiteStatement xaV;
  SQLiteStatement xaW;
  SQLiteStatement xaX;
  private SQLiteStatement xaY;
  public b xao;
  
  public c(b paramb)
  {
    AppMethodBeat.i(87823);
    this.xao = paramb;
    if (this.xao.ac(49L, 0L) != 5L)
    {
      if (this.xao.ale("C2CChatUsage")) {
        this.xao.avL("C2CChatUsage");
      }
      this.xao.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (chat TEXT, date INTEGER, chattype INTEGER DEFAULT 0, opencount INTEGER DEFAULT 0, sendmsgcount INTEGER DEFAULT 0, staytime INTEGER DEFAULT 0, consumemsgcount INTEGER DEFAULT 0, PRIMARY KEY(chat, date));", new Object[] { "C2CChatUsage" }));
      this.xao.ad(49L, 5L);
    }
    for (;;)
    {
      this.xaV = this.xao.compileStatement(String.format("INSERT OR IGNORE INTO %s (chat, date, chattype) VALUES (?,?,?)", new Object[] { "C2CChatUsage" }));
      this.xaW = this.xao.compileStatement(String.format("UPDATE %s SET opencount = opencount + 1, staytime = staytime + ? WHERE chat = ? AND date = ?", new Object[] { "C2CChatUsage" }));
      this.xaX = this.xao.compileStatement(String.format("UPDATE %s SET sendmsgcount = sendmsgcount + 1 WHERE chat = ? AND date = ?", new Object[] { "C2CChatUsage" }));
      this.xaY = this.xao.compileStatement(String.format("UPDATE %s SET consumemsgcount = consumemsgcount + 1 WHERE chat = ? AND date = ?", new Object[] { "C2CChatUsage" }));
      AppMethodBeat.o(87823);
      return;
      ae.i("MicroMsg.Priority.C2CChatUsageStorage", "Exist Table %s Count %d", new Object[] { "C2CChatUsage", Integer.valueOf(this.xao.avK("C2CChatUsage")) });
    }
  }
  
  public final boolean J(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(87824);
    this.xaV.bindString(1, paramString);
    this.xaV.bindLong(2, paramLong1);
    this.xaV.bindLong(3, paramLong2);
    if (this.xaV.executeInsert() >= 0L)
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