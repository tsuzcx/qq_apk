package com.tencent.mm.plugin.priority.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bj;
import com.tencent.wcdb.database.SQLiteStatement;

public final class d
  extends a
{
  private String vDM;
  
  public d(String paramString)
  {
    this.vDM = paramString;
  }
  
  public final String getName()
  {
    return "PriorityDeleteContactTask";
  }
  
  public final void run()
  {
    AppMethodBeat.i(87871);
    if (com.tencent.mm.n.b.ln(((k)g.ab(k.class)).awB().aNt(this.vDM).field_type))
    {
      ac.i("MicroMsg.Priority.PriorityDeleteContactTask", "%s is Contact", new Object[] { this.vDM });
      AppMethodBeat.o(87871);
      return;
    }
    Object localObject = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
    String str1 = this.vDM;
    ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).vEl.bindString(1, str1);
    ac.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "delete %d img %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.priority.model.a.c.c)localObject).vEk.executeUpdateDelete()), str1 });
    ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().aps(this.vDM);
    localObject = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage();
    str1 = this.vDM;
    ((com.tencent.mm.plugin.priority.model.a.b.c)localObject).vEl.bindString(1, str1);
    ac.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "delete %d file %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.priority.model.a.b.c)localObject).vEk.executeUpdateDelete()), str1 });
    ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().aps(this.vDM);
    localObject = ((PluginPriority)g.ad(PluginPriority.class)).getC2CChatUsageResultStorage();
    str1 = this.vDM;
    String str2 = String.format("DELETE FROM %s WHERE chat = ?", new Object[] { "C2CChatUsageResult" });
    ((com.tencent.mm.plugin.priority.model.a.a.b)localObject).vDu.execSQL(str2, new String[] { str1 });
    localObject = ((PluginPriority)g.ad(PluginPriority.class)).getC2CChatUsageStorage();
    str1 = this.vDM;
    str2 = String.format("DELETE FROM %s WHERE chat = ?", new Object[] { "C2CChatUsage" });
    ((com.tencent.mm.plugin.priority.model.a.a.c)localObject).vDu.execSQL(str2, new String[] { str1 });
    AppMethodBeat.o(87871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.b.d
 * JD-Core Version:    0.7.0.1
 */