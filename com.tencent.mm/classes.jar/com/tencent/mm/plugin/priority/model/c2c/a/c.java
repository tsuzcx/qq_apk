package com.tencent.mm.plugin.priority.model.c2c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wcdb.database.SQLiteStatement;

public class c
{
  private SQLiteStatement MPZ;
  public b MPs;
  SQLiteStatement MQa;
  SQLiteStatement MQb;
  private SQLiteStatement MQc;
  
  public c(b paramb)
  {
    AppMethodBeat.i(87823);
    this.MPs = paramb;
    if (this.MPs.aY(49L, 0L) != 5L)
    {
      if (this.MPs.aDZ("C2CChatUsage")) {
        this.MPs.aRI("C2CChatUsage");
      }
      this.MPs.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (chat TEXT, date INTEGER, chattype INTEGER DEFAULT 0, opencount INTEGER DEFAULT 0, sendmsgcount INTEGER DEFAULT 0, staytime INTEGER DEFAULT 0, consumemsgcount INTEGER DEFAULT 0, PRIMARY KEY(chat, date));", new Object[] { "C2CChatUsage" }));
      this.MPs.aZ(49L, 5L);
    }
    for (;;)
    {
      this.MPZ = this.MPs.compileStatement(String.format("INSERT OR IGNORE INTO %s (chat, date, chattype) VALUES (?,?,?)", new Object[] { "C2CChatUsage" }));
      this.MQa = this.MPs.compileStatement(String.format("UPDATE %s SET opencount = opencount + 1, staytime = staytime + ? WHERE chat = ? AND date = ?", new Object[] { "C2CChatUsage" }));
      this.MQb = this.MPs.compileStatement(String.format("UPDATE %s SET sendmsgcount = sendmsgcount + 1 WHERE chat = ? AND date = ?", new Object[] { "C2CChatUsage" }));
      this.MQc = this.MPs.compileStatement(String.format("UPDATE %s SET consumemsgcount = consumemsgcount + 1 WHERE chat = ? AND date = ?", new Object[] { "C2CChatUsage" }));
      AppMethodBeat.o(87823);
      return;
      Log.i("MicroMsg.Priority.C2CChatUsageStorage", "Exist Table %s Count %d", new Object[] { "C2CChatUsage", Integer.valueOf(this.MPs.aRH("C2CChatUsage")) });
    }
  }
  
  public final boolean O(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(87824);
    this.MPZ.bindString(1, paramString);
    this.MPZ.bindLong(2, paramLong1);
    this.MPZ.bindLong(3, paramLong2);
    if (this.MPZ.executeInsert() >= 0L)
    {
      AppMethodBeat.o(87824);
      return true;
    }
    AppMethodBeat.o(87824);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.c2c.a.c
 * JD-Core Version:    0.7.0.1
 */