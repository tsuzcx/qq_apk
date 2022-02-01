package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.RecordPluginLayout;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusRecordPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/RecordPluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "generateCallback", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onResume", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusRecordPluginLayout
  extends RecordPluginLayout
{
  private CaptureDataManager.b NHG;
  
  public TextStatusRecordPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(291256);
    AppMethodBeat.o(291256);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(291263);
    super.a(paramb);
    this.NHG = CaptureDataManager.NHH.NHG;
    AppMethodBeat.o(291263);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(291269);
    super.onResume();
    CaptureDataManager.b localb = this.NHG;
    if (localb != null) {
      CaptureDataManager.NHH.NHG = localb;
    }
    AppMethodBeat.o(291269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusRecordPluginLayout
 * JD-Core Version:    0.7.0.1
 */