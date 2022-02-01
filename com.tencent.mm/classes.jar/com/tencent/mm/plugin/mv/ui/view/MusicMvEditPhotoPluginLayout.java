package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvEditPhotoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditPhotoPluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "plugin-mv_release"})
public final class MusicMvEditPhotoPluginLayout
  extends EditPhotoPluginLayout
{
  public MusicMvEditPhotoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(257525);
    AppMethodBeat.o(257525);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(257524);
    if (paramb != null)
    {
      Boolean localBoolean1 = Boolean.TRUE;
      paramb = paramb.iql;
      Boolean localBoolean2 = Boolean.TRUE;
      c localc = c.BXI;
      paramb = new CaptureDataManager.CaptureVideoNormalModel(localBoolean1, "", paramb, Long.valueOf(0L), localBoolean2, c.eKW());
      CaptureDataManager.BOb.a(getContext(), paramb);
      AppMethodBeat.o(257524);
      return;
    }
    AppMethodBeat.o(257524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvEditPhotoPluginLayout
 * JD-Core Version:    0.7.0.1
 */