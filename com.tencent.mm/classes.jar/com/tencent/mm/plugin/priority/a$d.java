package com.tencent.mm.plugin.priority;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.priority.b.a.c;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.protocal.protobuf.gh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import java.lang.ref.WeakReference;

final class a$d
  extends com.tencent.mm.plugin.priority.b.b.a
{
  private bi cEE;
  private WeakReference<Runnable> ptn;
  
  a$d(bi parambi, WeakReference<Runnable> paramWeakReference)
  {
    this.cEE = paramWeakReference;
    Object localObject;
    this.ptn = localObject;
  }
  
  public final String getName()
  {
    return "Priority.onC2CImgScrollTask";
  }
  
  public final void run()
  {
    AppMethodBeat.i(54878);
    if ((com.tencent.mm.plugin.priority.a.a.a.biG()) && (this.cEE.field_createTime <= ((PluginPriority)g.G(PluginPriority.class)).getInstallPriorityTime()))
    {
      ab.i("MicroMsg.Priority.PriorityService", "onC2CImgScroll time condition not support %s", new Object[] { h.formatTime("yyyy-MM-dd HH:mm:ss", this.cEE.field_createTime / 1000L) });
      AppMethodBeat.o(54878);
      return;
    }
    ab.i("MicroMsg.Priority.PriorityService", "C2CImgScrollTask Start To Auto Download %d MsgId %d", new Object[] { Integer.valueOf(32), Long.valueOf(this.cEE.field_msgId) });
    if (this.ptn.get() != null) {
      ((Runnable)this.ptn.get()).run();
    }
    ((PluginPriority)g.G(PluginPriority.class)).getC2CMsgAutoDownloadResLogic();
    bi localbi = this.cEE;
    gh localgh = ((PluginPriority)g.G(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().kS(localbi.field_msgId);
    if (localgh == null)
    {
      ab.i("MicroMsg.Priority.C2CMsgAutoDownloadResLogic", "This Image Sender is Me");
      AppMethodBeat.o(54878);
      return;
    }
    if (localgh.jJS == 1) {
      ((PluginPriority)g.G(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().l(localbi.field_msgId, 32, 2);
    }
    AppMethodBeat.o(54878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.a.d
 * JD-Core Version:    0.7.0.1
 */