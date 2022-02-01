package com.tencent.mm.plugin.priority.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bx;
import com.tencent.wcdb.database.SQLiteStatement;

public final class d
  extends a
{
  private String MPK;
  
  public d(String paramString)
  {
    this.MPK = paramString;
  }
  
  public final String getName()
  {
    return "PriorityDeleteContactTask";
  }
  
  public final void run()
  {
    AppMethodBeat.i(87871);
    if (com.tencent.mm.contact.d.rs(((n)h.ax(n.class)).bzA().JE(this.MPK).field_type))
    {
      Log.i("MicroMsg.Priority.PriorityDeleteContactTask", "%s is Contact", new Object[] { this.MPK });
      AppMethodBeat.o(87871);
      return;
    }
    Object localObject = ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
    String str1 = this.MPK;
    ((com.tencent.mm.plugin.priority.model.c2c.img.c)localObject).MQj.bindString(1, str1);
    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "delete %d img %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.priority.model.c2c.img.c)localObject).MQi.executeUpdateDelete()), str1 });
    ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgImgUsageStorage().aRK(this.MPK);
    localObject = ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage();
    str1 = this.MPK;
    ((com.tencent.mm.plugin.priority.model.c2c.b.c)localObject).MQj.bindString(1, str1);
    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "delete %d file %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.priority.model.c2c.b.c)localObject).MQi.executeUpdateDelete()), str1 });
    ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgFileUsageStorage().aRK(this.MPK);
    localObject = ((PluginPriority)h.az(PluginPriority.class)).getC2CChatUsageResultStorage();
    str1 = this.MPK;
    String str2 = String.format("DELETE FROM %s WHERE chat = ?", new Object[] { "C2CChatUsageResult" });
    ((com.tencent.mm.plugin.priority.model.c2c.a.b)localObject).MPs.execSQL(str2, new String[] { str1 });
    localObject = ((PluginPriority)h.az(PluginPriority.class)).getC2CChatUsageStorage();
    str1 = this.MPK;
    str2 = String.format("DELETE FROM %s WHERE chat = ?", new Object[] { "C2CChatUsage" });
    ((com.tencent.mm.plugin.priority.model.c2c.a.c)localObject).MPs.execSQL(str2, new String[] { str1 });
    AppMethodBeat.o(87871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.d
 * JD-Core Version:    0.7.0.1
 */