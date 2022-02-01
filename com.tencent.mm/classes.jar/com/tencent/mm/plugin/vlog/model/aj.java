package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.xlabeffect.m;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.xeffect.f;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/VideoCompositionUtil;", "", "()V", "TAG", "", "setup", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aj
{
  private static final String TAG;
  public static final aj Ubd;
  
  static
  {
    AppMethodBeat.i(283638);
    Ubd = new aj();
    TAG = "MicroMsg.VideoCompositionUtil";
    Object localObject = f.agXF;
    f.aZ((b)aj.1.Ube);
    m.iGg();
    localObject = com.tencent.mm.plugin.xlabeffect.c.XJQ;
    com.tencent.mm.plugin.xlabeffect.c.fXr();
    localObject = TAVKitMuxer.Uam;
    TAVKitMuxer.setup();
    k.load("mediaplus");
    if ((((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zvi, 0) == 1) || (WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
    {
      Log.i(TAG, "use custom extractor");
      com.tencent.tav.extractor.AssetExtractor.DOWNGRADING = true;
      localObject = ab.Uau;
      ab.setup();
      AppMethodBeat.o(283638);
      return;
    }
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zck, 28);
    if ((i > 0) && (d.rb(i)))
    {
      Log.i(TAG, s.X("extractor config: ", Integer.valueOf(i)));
      com.tencent.tav.extractor.AssetExtractor.DOWNGRADING = true;
      AppMethodBeat.o(283638);
      return;
    }
    com.tencent.tav.extractor.AssetExtractor.DOWNGRADING = false;
    AppMethodBeat.o(283638);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.aj
 * JD-Core Version:    0.7.0.1
 */