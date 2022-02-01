package com.tencent.mm.plugin.priority.model.c2c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.protocal.protobuf.zj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.wcdb.database.SQLiteStatement;

public class a
{
  public static boolean aRL(String paramString)
  {
    AppMethodBeat.i(283804);
    zj localzj = ((PluginPriority)h.az(PluginPriority.class)).getC2CChatUsageResultStorage().aRM(paramString);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yLU, 10);
    float f = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yLV, 10.0F);
    Log.i("MicroMsg.Priority.C2CChatUsageLogic", "getAutoDownloadImgFlag %s %s %.2f", new Object[] { paramString, Integer.valueOf(i), Float.valueOf(f) });
    if ((localzj != null) && (localzj.ILB <= i) && (localzj.Zii > f))
    {
      AppMethodBeat.o(283804);
      return true;
    }
    AppMethodBeat.o(283804);
    return false;
  }
  
  public final class a
    extends com.tencent.mm.plugin.priority.model.a.a
  {
    private String MPK;
    private int chatType;
    private long hTS;
    private int score;
    private int type;
    
    public a(String paramString, int paramInt)
    {
      this.MPK = paramString;
      this.type = paramInt;
    }
    
    public a(String paramString, int paramInt, byte paramByte)
    {
      this.MPK = paramString;
      this.type = 2;
      this.score = paramInt;
    }
    
    public a(String paramString, long paramLong)
    {
      AppMethodBeat.i(174313);
      this.MPK = paramString;
      this.type = 0;
      this.score = this.score;
      this.hTS = paramLong;
      AppMethodBeat.o(174313);
    }
    
    public final String getName()
    {
      AppMethodBeat.i(87818);
      String str = String.format("Priority.UpdateTask[%s][%d][%d][%d][%d]", new Object[] { this.MPK, Integer.valueOf(this.type), Long.valueOf(this.hTS), Integer.valueOf(this.chatType), Integer.valueOf(this.score) });
      AppMethodBeat.o(87818);
      return str;
    }
    
    public final void run()
    {
      AppMethodBeat.i(87819);
      Object localObject1 = this.MPK;
      int i;
      if (Util.isNullOrNil((String)localObject1)) {
        i = 0;
      }
      while (i == 0)
      {
        Log.i("MicroMsg.Priority.C2CChatUsageLogic", "filterByUsername %s", new Object[] { this.MPK });
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
        } else if (ab.IS(this.MPK)) {
          i = 0;
        } else {
          i = 1;
        }
      }
      if (((n)h.ax(n.class)).bzA().JE(this.MPK).isHidden())
      {
        Log.i("MicroMsg.Priority.C2CChatUsageLogic", "Hidden %s", new Object[] { this.MPK });
        AppMethodBeat.o(87819);
        return;
      }
      if (au.bwE(this.MPK))
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
        localObject1 = ((PluginPriority)h.az(PluginPriority.class)).getC2CChatUsageStorage();
        String str = this.MPK;
        long l1 = this.hTS;
        long l2 = this.chatType;
        long l3 = com.tencent.mm.plugin.priority.a.a.a.gzM();
        boolean bool = ((c)localObject1).O(str, l3, l2);
        ((c)localObject1).MQa.bindLong(1, l1);
        ((c)localObject1).MQa.bindString(2, str);
        ((c)localObject1).MQa.bindLong(3, l3);
        Log.i("MicroMsg.Priority.C2CChatUsageStorage", "updateOpen chat %s insert %b update %b", new Object[] { str, Boolean.valueOf(bool), Integer.valueOf(((c)localObject1).MQa.executeUpdateDelete()) });
        AppMethodBeat.o(87819);
        return;
        localObject1 = ((PluginPriority)h.az(PluginPriority.class)).getC2CChatUsageStorage();
        str = this.MPK;
        l1 = this.chatType;
        Object localObject2 = ((c)localObject1).MQb;
        l2 = com.tencent.mm.plugin.priority.a.a.a.gzM();
        bool = ((c)localObject1).O(str, l2, l1);
        ((SQLiteStatement)localObject2).bindString(1, str);
        ((SQLiteStatement)localObject2).bindLong(2, l2);
        Log.i("MicroMsg.Priority.C2CChatUsageStorage", "%s chat %s insert %b update %b", new Object[] { "updateSendMsg", str, Boolean.valueOf(bool), Integer.valueOf(((SQLiteStatement)localObject2).executeUpdateDelete()) });
        AppMethodBeat.o(87819);
        return;
        localObject1 = ((PluginPriority)h.az(PluginPriority.class)).getC2CChatUsageStorage();
        str = this.MPK;
        l1 = this.chatType;
        localObject2 = String.format("UPDATE %s SET consumemsgcount = consumemsgcount + %d WHERE chat = ? AND date = ?", new Object[] { "C2CChatUsage", Integer.valueOf(this.score) });
        ((c)localObject1).MPs.execSQL((String)localObject2, new String[] { str, String.valueOf(l1) });
        AppMethodBeat.o(87819);
        return;
        ((PluginPriority)h.az(PluginPriority.class)).getC2CChatUsageStorage().O(this.MPK, com.tencent.mm.plugin.priority.a.a.a.gzM(), this.chatType);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.c2c.a.a
 * JD-Core Version:    0.7.0.1
 */