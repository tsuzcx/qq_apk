package com.tencent.mm.plugin.vlog.ui.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/FinderVideoCropLocalConfig;", "", "()V", "TAG", "", "isEnable43RatioVideo", "", "()Z", "plugin-vlog_release"})
public final class e
{
  public static final e NuX;
  
  static
  {
    AppMethodBeat.i(236092);
    NuX = new e();
    AppMethodBeat.o(236092);
  }
  
  public static boolean gvk()
  {
    AppMethodBeat.i(236085);
    int i = ((b)h.ae(b.class)).a(b.a.vXY, 0);
    int j = MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_VIDEO_RATIO_3_4_INT_SYNC", 0);
    Log.i("MicroMsg.FinderVideoCropLocalConfig", "init, isEnable43RatioVideo:" + i + ", localConfig:" + j);
    if (j != 0)
    {
      if (j == 1)
      {
        AppMethodBeat.o(236085);
        return true;
      }
      AppMethodBeat.o(236085);
      return false;
    }
    if (i == 1)
    {
      AppMethodBeat.o(236085);
      return true;
    }
    AppMethodBeat.o(236085);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.e
 * JD-Core Version:    0.7.0.1
 */