package com.tencent.mm.plugin.vlog.ui.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/FinderVideoCropLocalConfig;", "", "()V", "TAG", "", "isEnable43RatioVideo", "", "()Z", "plugin-vlog_release"})
public final class d
{
  public static final d CeI;
  
  static
  {
    AppMethodBeat.i(191660);
    CeI = new d();
    AppMethodBeat.o(191660);
  }
  
  public static boolean ewY()
  {
    AppMethodBeat.i(191659);
    int i = ((b)g.ab(b.class)).a(b.a.qPL, 0);
    int j = ay.aRW("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_VIDEO_RATIO_3_4_INT_SYNC", 0);
    ae.i("MicroMsg.FinderVideoCropLocalConfig", "init, isEnable43RatioVideo:" + i + ", localConfig:" + j);
    if (j != 0)
    {
      if (j == 1)
      {
        AppMethodBeat.o(191659);
        return true;
      }
      AppMethodBeat.o(191659);
      return false;
    }
    if (i == 1)
    {
      AppMethodBeat.o(191659);
      return true;
    }
    AppMethodBeat.o(191659);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.d
 * JD-Core Version:    0.7.0.1
 */