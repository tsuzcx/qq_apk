package com.tencent.mm.plugin.vlog.ui.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/FinderVideoCropLocalConfig;", "", "()V", "TAG", "", "isEnable43RatioVideo", "", "()Z", "plugin-vlog_release"})
public final class f
{
  public static final f GHk;
  
  static
  {
    AppMethodBeat.i(191277);
    GHk = new f();
    AppMethodBeat.o(191277);
  }
  
  public static boolean fDl()
  {
    AppMethodBeat.i(191276);
    int i = ((b)g.af(b.class)).a(b.a.smW, 0);
    int j = MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_VIDEO_RATIO_3_4_INT_SYNC", 0);
    Log.i("MicroMsg.FinderVideoCropLocalConfig", "init, isEnable43RatioVideo:" + i + ", localConfig:" + j);
    if (j != 0)
    {
      if (j == 1)
      {
        AppMethodBeat.o(191276);
        return true;
      }
      AppMethodBeat.o(191276);
      return false;
    }
    if (i == 1)
    {
      AppMethodBeat.o(191276);
      return true;
    }
    AppMethodBeat.o(191276);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.f
 * JD-Core Version:    0.7.0.1
 */