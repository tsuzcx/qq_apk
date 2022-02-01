package com.tencent.mm.plugin.vlog.ui.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/FinderVideoCropLocalConfig;", "", "()V", "TAG", "", "isEnable43RatioVideo", "", "()Z", "plugin-vlog_release"})
public final class d
{
  public static final d BNj;
  
  static
  {
    AppMethodBeat.i(196201);
    BNj = new d();
    AppMethodBeat.o(196201);
  }
  
  public static boolean etr()
  {
    AppMethodBeat.i(196200);
    int i = ((b)g.ab(b.class)).a(b.a.qIe, 0);
    int j = ax.aQz("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_VIDEO_RATIO_3_4_INT_SYNC", 0);
    ad.i("MicroMsg.FinderVideoCropLocalConfig", "init, isEnable43RatioVideo:" + i + ", localConfig:" + j);
    if (j != 0)
    {
      if (j == 1)
      {
        AppMethodBeat.o(196200);
        return true;
      }
      AppMethodBeat.o(196200);
      return false;
    }
    if (i == 1)
    {
      AppMethodBeat.o(196200);
      return true;
    }
    AppMethodBeat.o(196200);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.d
 * JD-Core Version:    0.7.0.1
 */