package com.tencent.mm.plugin.vlog.ui.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.res.g;
import com.tencent.mm.plugin.vlog.model.local.a;
import com.tencent.mm.plugin.xlabeffect.e;
import com.tencent.mm.vfs.s;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VideoEnhancementPlugin$Companion;", "", "()V", "TAG", "", "isEnable", "", "plugin-vlog_release"})
public final class aj$a
{
  public static boolean isEnable()
  {
    AppMethodBeat.i(191578);
    Object localObject = a.GAD;
    if (a.fBW()) {
      if (!g.BYp.eLz())
      {
        localObject = new StringBuilder();
        e locale = e.JRF;
        localObject = ((StringBuilder)localObject).append(e.glu()).append("/");
        locale = e.JRF;
        if (!s.YS(e.glv())) {}
      }
      else
      {
        AppMethodBeat.o(191578);
        return true;
      }
    }
    AppMethodBeat.o(191578);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.aj.a
 * JD-Core Version:    0.7.0.1
 */