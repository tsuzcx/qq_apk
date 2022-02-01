package com.tencent.mm.plugin.priority.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bg;
import com.tencent.wcdb.database.SQLiteStatement;

public final class d
  extends a
{
  private String uuT;
  
  public d(String paramString)
  {
    this.uuT = paramString;
  }
  
  public final String getName()
  {
    return "PriorityDeleteContactTask";
  }
  
  public final void run()
  {
    AppMethodBeat.i(87871);
    if (com.tencent.mm.n.b.ls(((k)g.ab(k.class)).apM().aHY(this.uuT).field_type))
    {
      ad.i("MicroMsg.Priority.PriorityDeleteContactTask", "%s is Contact", new Object[] { this.uuT });
      AppMethodBeat.o(87871);
      return;
    }
    Object localObject = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
    String str1 = this.uuT;
    ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).uvs.bindString(1, str1);
    ad.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "delete %d img %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.priority.model.a.c.c)localObject).uvr.executeUpdateDelete()), str1 });
    ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().akt(this.uuT);
    localObject = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage();
    str1 = this.uuT;
    ((com.tencent.mm.plugin.priority.model.a.b.c)localObject).uvs.bindString(1, str1);
    ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "delete %d file %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.priority.model.a.b.c)localObject).uvr.executeUpdateDelete()), str1 });
    ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().akt(this.uuT);
    localObject = ((PluginPriority)g.ad(PluginPriority.class)).getC2CChatUsageResultStorage();
    str1 = this.uuT;
    String str2 = String.format("DELETE FROM %s WHERE chat = ?", new Object[] { "C2CChatUsageResult" });
    ((com.tencent.mm.plugin.priority.model.a.a.b)localObject).uuB.execSQL(str2, new String[] { str1 });
    localObject = ((PluginPriority)g.ad(PluginPriority.class)).getC2CChatUsageStorage();
    str1 = this.uuT;
    str2 = String.format("DELETE FROM %s WHERE chat = ?", new Object[] { "C2CChatUsage" });
    ((com.tencent.mm.plugin.priority.model.a.a.c)localObject).uuB.execSQL(str2, new String[] { str1 });
    AppMethodBeat.o(87871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.b.d
 * JD-Core Version:    0.7.0.1
 */