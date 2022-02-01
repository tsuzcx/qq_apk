package com.tencent.mm.plugin.vlog.ui.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/FinderVideoCropLocalConfig;", "", "()V", "TAG", "", "isEnable43RatioVideo", "", "()Z", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e Uio;
  
  static
  {
    AppMethodBeat.i(282420);
    Uio = new e();
    AppMethodBeat.o(282420);
  }
  
  public static boolean hTa()
  {
    AppMethodBeat.i(282413);
    int i = ((c)h.ax(c.class)).a(c.a.zqN, 0);
    int j = MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_VIDEO_RATIO_3_4_INT_SYNC", 0);
    Log.i("MicroMsg.FinderVideoCropLocalConfig", "init, isEnable43RatioVideo:" + i + ", localConfig:" + j);
    if (j != 0)
    {
      if (j == 1)
      {
        AppMethodBeat.o(282413);
        return true;
      }
      AppMethodBeat.o(282413);
      return false;
    }
    if (i == 1)
    {
      AppMethodBeat.o(282413);
      return true;
    }
    AppMethodBeat.o(282413);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.e
 * JD-Core Version:    0.7.0.1
 */