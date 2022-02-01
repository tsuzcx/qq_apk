package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.b.g;
import com.tencent.mm.plugin.recordvideo.activity.a;
import com.tencent.mm.plugin.recordvideo.f.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "initLogic", "", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "loadCurrentPage", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvEditVideoPluginLayout
  extends EditorVideoPluginLayoutNew
{
  public static final MusicMvEditVideoPluginLayout.a Mit;
  
  static
  {
    AppMethodBeat.i(287251);
    Mit = new MusicMvEditVideoPluginLayout.a((byte)0);
    AppMethodBeat.o(287251);
  }
  
  public MusicMvEditVideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(287245);
    AppMethodBeat.o(287245);
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(287263);
    Object localObject1;
    Object localObject3;
    if (paramb != null)
    {
      localObject1 = g.HRf;
      localObject3 = g.aBH(paramb.nJU);
      localObject1 = getConfigProvider();
      if (localObject1 != null) {
        break label209;
      }
      localObject1 = "";
    }
    for (;;)
    {
      Log.i("MicroMsg.MusicMvEditVideoPluginLayout", "videoInfo:" + localObject3 + ", path:" + paramb.nJU + ',' + y.ZC(paramb.nJU) + ", thumb:" + paramb.nJV + ',' + y.ZC(paramb.nJV) + ", outputVideoPath:" + (String)localObject1);
      if (!Util.isNullOrNil((String)localObject1)) {
        y.O(paramb.nJU, (String)localObject1, false);
      }
      Object localObject2 = Boolean.TRUE;
      paramb = paramb.nJV;
      long l = ((com.tencent.mm.plugin.sight.base.b)localObject3).videoDuration;
      localObject3 = Boolean.FALSE;
      c localc = c.NRf;
      paramb = new CaptureDataManager.CaptureVideoNormalModel((Boolean)localObject2, (String)localObject1, paramb, Long.valueOf(l), (Boolean)localObject3, c.gJe());
      CaptureDataManager.NHH.a(getContext(), paramb);
      AppMethodBeat.o(287263);
      return;
      label209:
      localObject2 = ((RecordConfigProvider)localObject1).NIe;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
  }
  
  public final void a(a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(287271);
    s.u(parama, "navigator");
    s.u(paramRecordConfigProvider, "configProvider");
    super.a(parama, paramRecordConfigProvider);
    AppMethodBeat.o(287271);
  }
  
  public final void a(a.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(287277);
    s.u(paramc, "status");
    if (b.$EnumSwitchMapping$0[paramc.ordinal()] == 1)
    {
      super.a(a.c.NOQ, paramBundle);
      AppMethodBeat.o(287277);
      return;
    }
    super.a(paramc, paramBundle);
    AppMethodBeat.o(287277);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvEditVideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */