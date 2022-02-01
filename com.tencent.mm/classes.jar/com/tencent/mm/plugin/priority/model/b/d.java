package com.tencent.mm.plugin.priority.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bv;
import com.tencent.wcdb.database.SQLiteStatement;

public final class d
  extends a
{
  private String AYi;
  
  public d(String paramString)
  {
    this.AYi = paramString;
  }
  
  public final String getName()
  {
    return "PriorityDeleteContactTask";
  }
  
  public final void run()
  {
    AppMethodBeat.i(87871);
    if (com.tencent.mm.contact.c.oR(((l)g.af(l.class)).aSN().Kn(this.AYi).field_type))
    {
      Log.i("MicroMsg.Priority.PriorityDeleteContactTask", "%s is Contact", new Object[] { this.AYi });
      AppMethodBeat.o(87871);
      return;
    }
    Object localObject = ((PluginPriority)g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
    String str1 = this.AYi;
    ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).AYH.bindString(1, str1);
    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "delete %d img %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.priority.model.a.c.c)localObject).AYG.executeUpdateDelete()), str1 });
    ((PluginPriority)g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().aKf(this.AYi);
    localObject = ((PluginPriority)g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage();
    str1 = this.AYi;
    ((com.tencent.mm.plugin.priority.model.a.b.c)localObject).AYH.bindString(1, str1);
    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "delete %d file %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.priority.model.a.b.c)localObject).AYG.executeUpdateDelete()), str1 });
    ((PluginPriority)g.ah(PluginPriority.class)).getC2CMsgFileUsageStorage().aKf(this.AYi);
    localObject = ((PluginPriority)g.ah(PluginPriority.class)).getC2CChatUsageResultStorage();
    str1 = this.AYi;
    String str2 = String.format("DELETE FROM %s WHERE chat = ?", new Object[] { "C2CChatUsageResult" });
    ((com.tencent.mm.plugin.priority.model.a.a.b)localObject).AXQ.execSQL(str2, new String[] { str1 });
    localObject = ((PluginPriority)g.ah(PluginPriority.class)).getC2CChatUsageStorage();
    str1 = this.AYi;
    str2 = String.format("DELETE FROM %s WHERE chat = ?", new Object[] { "C2CChatUsage" });
    ((com.tencent.mm.plugin.priority.model.a.a.c)localObject).AXQ.execSQL(str2, new String[] { str1 });
    AppMethodBeat.o(87871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.b.d
 * JD-Core Version:    0.7.0.1
 */