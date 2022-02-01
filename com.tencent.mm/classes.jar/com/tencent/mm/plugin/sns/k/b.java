package com.tencent.mm.plugin.sns.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/sns/statistics/EditorVideoCompositionConfig;", "", "()V", "CLAZZ_NAME_VIDEO_COMPOSITION_EDITOR_LAYOUT", "", "TAG", "getC2CVideoCompositionSwitch", "", "provider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getSnsVideoCompositionSwitch", "plugin-sns_release"})
public final class b
{
  public static final b KfK;
  
  static
  {
    AppMethodBeat.i(267575);
    KfK = new b();
    AppMethodBeat.o(267575);
  }
  
  public static void k(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(267571);
    p.k(paramRecordConfigProvider, "provider");
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyz, false);
    Log.i("MicroMsg.EditorVideoCompositionConfig", "C2CVideoCompositionSwitch: ".concat(String.valueOf(bool)));
    if (bool) {
      paramRecordConfigProvider.G(2, "com.tencent.mm.plugin.vlog.ui.video.EditorVideoCompositionPluginLayout");
    }
    AppMethodBeat.o(267571);
  }
  
  public static void l(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(267572);
    p.k(paramRecordConfigProvider, "provider");
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyA, false);
    Log.i("MicroMsg.EditorVideoCompositionConfig", "SnsVideoCompositionSwitch: ".concat(String.valueOf(bool)));
    if (bool) {
      paramRecordConfigProvider.G(2, "com.tencent.mm.plugin.vlog.ui.video.EditorVideoCompositionPluginLayout");
    }
    AppMethodBeat.o(267572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.b
 * JD-Core Version:    0.7.0.1
 */