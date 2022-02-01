package com.tencent.mm.plugin.priority.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bq;
import com.tencent.wcdb.database.SQLiteStatement;

public final class d
  extends a
{
  private String xaG;
  
  public d(String paramString)
  {
    this.xaG = paramString;
  }
  
  public final String getName()
  {
    return "PriorityDeleteContactTask";
  }
  
  public final void run()
  {
    AppMethodBeat.i(87871);
    if (com.tencent.mm.contact.c.lO(((l)g.ab(l.class)).azF().BH(this.xaG).field_type))
    {
      ae.i("MicroMsg.Priority.PriorityDeleteContactTask", "%s is Contact", new Object[] { this.xaG });
      AppMethodBeat.o(87871);
      return;
    }
    Object localObject = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
    String str1 = this.xaG;
    ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).xbf.bindString(1, str1);
    ae.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "delete %d img %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.priority.model.a.c.c)localObject).xbe.executeUpdateDelete()), str1 });
    ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().avN(this.xaG);
    localObject = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage();
    str1 = this.xaG;
    ((com.tencent.mm.plugin.priority.model.a.b.c)localObject).xbf.bindString(1, str1);
    ae.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "delete %d file %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.priority.model.a.b.c)localObject).xbe.executeUpdateDelete()), str1 });
    ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().avN(this.xaG);
    localObject = ((PluginPriority)g.ad(PluginPriority.class)).getC2CChatUsageResultStorage();
    str1 = this.xaG;
    String str2 = String.format("DELETE FROM %s WHERE chat = ?", new Object[] { "C2CChatUsageResult" });
    ((com.tencent.mm.plugin.priority.model.a.a.b)localObject).xao.execSQL(str2, new String[] { str1 });
    localObject = ((PluginPriority)g.ad(PluginPriority.class)).getC2CChatUsageStorage();
    str1 = this.xaG;
    str2 = String.format("DELETE FROM %s WHERE chat = ?", new Object[] { "C2CChatUsage" });
    ((com.tencent.mm.plugin.priority.model.a.a.c)localObject).xao.execSQL(str2, new String[] { str1 });
    AppMethodBeat.o(87871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.b.d
 * JD-Core Version:    0.7.0.1
 */