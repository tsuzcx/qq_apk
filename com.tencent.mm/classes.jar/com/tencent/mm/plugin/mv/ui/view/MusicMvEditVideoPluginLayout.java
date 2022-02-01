package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "initLogic", "", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "loadCurrentPage", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-mv_release"})
public final class MusicMvEditVideoPluginLayout
  extends EditorVideoPluginLayoutNew
{
  public static final MusicMvEditVideoPluginLayout.a AxS;
  
  static
  {
    AppMethodBeat.i(257531);
    AxS = new MusicMvEditVideoPluginLayout.a((byte)0);
    AppMethodBeat.o(257531);
  }
  
  public MusicMvEditVideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(257530);
    AppMethodBeat.o(257530);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(257527);
    if (paramb != null)
    {
      Object localObject1 = com.tencent.mm.plugin.gallery.a.c.xsz;
      Object localObject3 = com.tencent.mm.plugin.gallery.a.c.awl(paramb.iqd);
      localObject1 = getConfigProvider();
      if (localObject1 != null)
      {
        localObject2 = ((RecordConfigProvider)localObject1).BOA;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      Log.i("MicroMsg.MusicMvEditVideoPluginLayout", "videoInfo:" + localObject3 + ", path:" + paramb.iqd + ',' + s.YS(paramb.iqd) + ", thumb:" + paramb.iqe + ',' + s.YS(paramb.iqe) + ", outputVideoPath:" + (String)localObject1);
      if (!Util.isNullOrNil((String)localObject1)) {
        s.nw(paramb.iqd, (String)localObject1);
      }
      Object localObject2 = Boolean.TRUE;
      paramb = paramb.iqe;
      long l = ((com.tencent.mm.plugin.sight.base.a)localObject3).videoDuration;
      localObject3 = Boolean.FALSE;
      com.tencent.mm.plugin.recordvideo.d.c localc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      paramb = new CaptureDataManager.CaptureVideoNormalModel((Boolean)localObject2, (String)localObject1, paramb, Long.valueOf(l), (Boolean)localObject3, com.tencent.mm.plugin.recordvideo.d.c.eKW());
      CaptureDataManager.BOb.a(getContext(), paramb);
      AppMethodBeat.o(257527);
      return;
    }
    AppMethodBeat.o(257527);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(257528);
    p.h(parama, "navigator");
    p.h(paramRecordConfigProvider, "configProvider");
    super.a(parama, paramRecordConfigProvider);
    AppMethodBeat.o(257528);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(257529);
    p.h(paramc, "status");
    switch (d.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      super.a(paramc, paramBundle);
      AppMethodBeat.o(257529);
      return;
    }
    super.a(d.c.BVw, paramBundle);
    AppMethodBeat.o(257529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvEditVideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */