package com.tencent.mm.plugin.sns.statistics;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.CameraKitPluginLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/statistics/EditorVideoCompositionConfig;", "", "()V", "CLAZZ_NAME_VIDEO_COMPOSITION_EDITOR_LAYOUT", "", "TAG", "c2cUseCameraKitRecord", "", "getC2CVideoCompositionSwitch", "", "provider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getSnsVideoCompositionSwitch", "snsUseCameraKitRecord", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b QDt;
  
  static
  {
    AppMethodBeat.i(306493);
    QDt = new b();
    AppMethodBeat.o(306493);
  }
  
  public static void r(RecordConfigProvider paramRecordConfigProvider)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(306492);
    s.u(paramRecordConfigProvider, "provider");
    boolean bool3 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yMc, false);
    Log.i("MicroMsg.EditorVideoCompositionConfig", s.X("SnsVideoCompositionSwitch: ", Boolean.valueOf(bool3)));
    if (bool3) {
      paramRecordConfigProvider.cD(2, "com.tencent.mm.plugin.vlog.ui.video.EditorVideoCompositionPluginLayout");
    }
    com.tencent.mm.media.camera.c localc = com.tencent.mm.media.camera.c.ntw;
    if (com.tencent.mm.media.camera.c.bnM())
    {
      if (bool1)
      {
        Log.i("MicroMsg.EditorVideoCompositionConfig", "useCameraKitRecord");
        paramRecordConfigProvider.cD(0, CameraKitPluginLayout.class.getName());
      }
      AppMethodBeat.o(306492);
      return;
    }
    bool1 = bool2;
    if (!aw.ato()) {
      if (!aw.jkP()) {
        break label167;
      }
    }
    label167:
    for (bool1 = bool2;; bool1 = false)
    {
      Log.i("MicroMsg.EditorVideoCompositionConfig", "sns UIUtils.isFoldableDevice:" + aw.ato() + " UIUtils.inTabletEnv:" + aw.jkP());
      bool1 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yTy, bool1);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.statistics.b
 * JD-Core Version:    0.7.0.1
 */