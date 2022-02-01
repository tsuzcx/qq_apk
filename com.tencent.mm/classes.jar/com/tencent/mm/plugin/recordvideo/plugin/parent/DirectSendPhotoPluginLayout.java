package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.f.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/DirectSendPhotoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditPhotoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class DirectSendPhotoPluginLayout
  extends EditPhotoPluginLayout
  implements a
{
  public DirectSendPhotoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(281015);
    AppMethodBeat.o(281015);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(281029);
    if (paramb != null)
    {
      Boolean localBoolean1 = Boolean.TRUE;
      paramb = paramb.nKb;
      Boolean localBoolean2 = Boolean.TRUE;
      c localc = c.NRf;
      paramb = new CaptureDataManager.CaptureVideoNormalModel(localBoolean1, "", paramb, Long.valueOf(0L), localBoolean2, c.gJe());
      CaptureDataManager.NHH.a(getContext(), paramb);
    }
    AppMethodBeat.o(281029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.DirectSendPhotoPluginLayout
 * JD-Core Version:    0.7.0.1
 */