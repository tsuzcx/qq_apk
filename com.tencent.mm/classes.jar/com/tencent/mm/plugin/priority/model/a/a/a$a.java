package com.tencent.mm.plugin.priority.model.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.wcdb.database.SQLiteStatement;

public final class a$a
  extends com.tencent.mm.plugin.priority.model.b.a
{
  private int chatType;
  private long dpQ;
  private int score;
  private int type;
  private String vDM;
  
  public a$a(a parama, String paramString, int paramInt)
  {
    this.vDM = paramString;
    this.type = paramInt;
  }
  
  public a$a(a parama, String paramString, int paramInt, byte paramByte)
  {
    this.vDM = paramString;
    this.type = 2;
    this.score = paramInt;
  }
  
  public a$a(a parama, String paramString, long paramLong)
  {
    AppMethodBeat.i(174313);
    this.vDM = paramString;
    this.type = 0;
    this.score = this.score;
    this.dpQ = paramLong;
    AppMethodBeat.o(174313);
  }
  
  public final String getName()
  {
    AppMethodBeat.i(87818);
    String str = String.format("Priority.UpdateTask[%s][%d][%d][%d][%d]", new Object[] { this.vDM, Integer.valueOf(this.type), Long.valueOf(this.dpQ), Integer.valueOf(this.chatType), Integer.valueOf(this.score) });
    AppMethodBeat.o(87818);
    return str;
  }
  
  public final void run()
  {
    AppMethodBeat.i(87819);
    Object localObject1 = this.vDM;
    int i;
    if (bs.isNullOrNil((String)localObject1)) {
      i = 0;
    }
    while (i == 0)
    {
      ac.i("MicroMsg.Priority.C2CChatUsageLogic", "filterByUsername %s", new Object[] { this.vDM });
      AppMethodBeat.o(87819);
      return;
      if (((String)localObject1).endsWith("@stranger")) {
        i = 0;
      } else if (((String)localObject1).endsWith("@qqim")) {
        i = 0;
      } else if (((String)localObject1).endsWith("@app")) {
        i = 0;
      } else if (((String)localObject1).startsWith("fake_")) {
        i = 0;
      } else if (w.wH(this.vDM)) {
        i = 0;
      } else {
        i = 1;
      }
    }
    if (((k)g.ab(k.class)).awB().aNt(this.vDM).isHidden())
    {
      ac.i("MicroMsg.Priority.C2CChatUsageLogic", "Hidden %s", new Object[] { this.vDM });
      AppMethodBeat.o(87819);
      return;
    }
    if (w.sQ(this.vDM))
    {
      this.chatType = 2;
      switch (this.type)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(87819);
      return;
      this.chatType = 3;
      break;
      localObject1 = ((PluginPriority)g.ad(PluginPriority.class)).getC2CChatUsageStorage();
      String str = this.vDM;
      long l1 = this.dpQ;
      long l2 = this.chatType;
      long l3 = com.tencent.mm.plugin.priority.a.a.a.doF();
      boolean bool = ((c)localObject1).I(str, l3, l2);
      ((c)localObject1).vEc.bindLong(1, l1);
      ((c)localObject1).vEc.bindString(2, str);
      ((c)localObject1).vEc.bindLong(3, l3);
      ac.i("MicroMsg.Priority.C2CChatUsageStorage", "updateOpen chat %s insert %b update %b", new Object[] { str, Boolean.valueOf(bool), Integer.valueOf(((c)localObject1).vEc.executeUpdateDelete()) });
      AppMethodBeat.o(87819);
      return;
      localObject1 = ((PluginPriority)g.ad(PluginPriority.class)).getC2CChatUsageStorage();
      str = this.vDM;
      l1 = this.chatType;
      Object localObject2 = ((c)localObject1).vEd;
      l2 = com.tencent.mm.plugin.priority.a.a.a.doF();
      bool = ((c)localObject1).I(str, l2, l1);
      ((SQLiteStatement)localObject2).bindString(1, str);
      ((SQLiteStatement)localObject2).bindLong(2, l2);
      ac.i("MicroMsg.Priority.C2CChatUsageStorage", "%s chat %s insert %b update %b", new Object[] { "updateSendMsg", str, Boolean.valueOf(bool), Integer.valueOf(((SQLiteStatement)localObject2).executeUpdateDelete()) });
      AppMethodBeat.o(87819);
      return;
      localObject1 = ((PluginPriority)g.ad(PluginPriority.class)).getC2CChatUsageStorage();
      str = this.vDM;
      l1 = this.chatType;
      localObject2 = String.format("UPDATE %s SET consumemsgcount = consumemsgcount + %d WHERE chat = ? AND date = ?", new Object[] { "C2CChatUsage", Integer.valueOf(this.score) });
      ((c)localObject1).vDu.execSQL((String)localObject2, new String[] { str, String.valueOf(l1) });
      AppMethodBeat.o(87819);
      return;
      ((PluginPriority)g.ad(PluginPriority.class)).getC2CChatUsageStorage().I(this.vDM, com.tencent.mm.plugin.priority.a.a.a.doF(), this.chatType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */