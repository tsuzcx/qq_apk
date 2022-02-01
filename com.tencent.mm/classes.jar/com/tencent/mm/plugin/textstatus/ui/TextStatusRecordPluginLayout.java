package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.RecordPluginLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusRecordPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/RecordPluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "generateCallback", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onResume", "plugin-textstatus_release"})
public final class TextStatusRecordPluginLayout
  extends RecordPluginLayout
{
  private CaptureDataManager.b HKI;
  
  public TextStatusRecordPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(232390);
    AppMethodBeat.o(232390);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(232386);
    super.a(paramb);
    paramb = CaptureDataManager.HKJ;
    p.j(paramb, "CaptureDataManager.INSTANCE");
    this.HKI = paramb.fvP();
    AppMethodBeat.o(232386);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(232388);
    super.onResume();
    CaptureDataManager.b localb = this.HKI;
    if (localb != null)
    {
      CaptureDataManager.HKJ.a(localb);
      AppMethodBeat.o(232388);
      return;
    }
    AppMethodBeat.o(232388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusRecordPluginLayout
 * JD-Core Version:    0.7.0.1
 */