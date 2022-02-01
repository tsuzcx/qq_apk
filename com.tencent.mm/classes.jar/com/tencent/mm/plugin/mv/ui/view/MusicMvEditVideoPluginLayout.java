package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.a.d;
import com.tencent.mm.plugin.recordvideo.activity.a;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "initLogic", "", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "loadCurrentPage", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-mv_release"})
public final class MusicMvEditVideoPluginLayout
  extends EditorVideoPluginLayoutNew
{
  public static final a GoD;
  
  static
  {
    AppMethodBeat.i(243837);
    GoD = new a((byte)0);
    AppMethodBeat.o(243837);
  }
  
  public MusicMvEditVideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(243835);
    AppMethodBeat.o(243835);
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(243830);
    if (paramb != null)
    {
      Object localObject1 = d.CeY;
      Object localObject3 = d.aFG(paramb.lfj);
      localObject1 = getConfigProvider();
      if (localObject1 != null)
      {
        localObject2 = ((RecordConfigProvider)localObject1).HLg;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      Log.i("MicroMsg.MusicMvEditVideoPluginLayout", "videoInfo:" + localObject3 + ", path:" + paramb.lfj + ',' + u.agG(paramb.lfj) + ", thumb:" + paramb.lfk + ',' + u.agG(paramb.lfk) + ", outputVideoPath:" + (String)localObject1);
      if (!Util.isNullOrNil((String)localObject1)) {
        u.on(paramb.lfj, (String)localObject1);
      }
      Object localObject2 = Boolean.TRUE;
      paramb = paramb.lfk;
      long l = ((com.tencent.mm.plugin.sight.base.b)localObject3).videoDuration;
      localObject3 = Boolean.FALSE;
      c localc = c.HUw;
      paramb = new CaptureDataManager.CaptureVideoNormalModel((Boolean)localObject2, (String)localObject1, paramb, Long.valueOf(l), (Boolean)localObject3, c.fxp());
      CaptureDataManager.HKJ.a(getContext(), paramb);
      AppMethodBeat.o(243830);
      return;
    }
    AppMethodBeat.o(243830);
  }
  
  public final void a(a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(243831);
    p.k(parama, "navigator");
    p.k(paramRecordConfigProvider, "configProvider");
    super.a(parama, paramRecordConfigProvider);
    AppMethodBeat.o(243831);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(243834);
    p.k(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      super.a(paramc, paramBundle);
      AppMethodBeat.o(243834);
      return;
    }
    super.a(d.c.HSk, paramBundle);
    AppMethodBeat.o(243834);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvEditVideoPluginLayout$Companion;", "", "()V", "TAG", "", "plugin-mv_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvEditVideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */