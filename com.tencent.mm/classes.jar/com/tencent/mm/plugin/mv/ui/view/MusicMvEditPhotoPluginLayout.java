package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.f.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvEditPhotoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditPhotoPluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvEditPhotoPluginLayout
  extends EditPhotoPluginLayout
{
  public MusicMvEditPhotoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(287198);
    AppMethodBeat.o(287198);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(287205);
    if (paramb != null)
    {
      Boolean localBoolean1 = Boolean.TRUE;
      paramb = paramb.nKb;
      Boolean localBoolean2 = Boolean.TRUE;
      c localc = c.NRf;
      paramb = new CaptureDataManager.CaptureVideoNormalModel(localBoolean1, "", paramb, Long.valueOf(0L), localBoolean2, c.gJe());
      CaptureDataManager.NHH.a(getContext(), paramb);
    }
    AppMethodBeat.o(287205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvEditPhotoPluginLayout
 * JD-Core Version:    0.7.0.1
 */