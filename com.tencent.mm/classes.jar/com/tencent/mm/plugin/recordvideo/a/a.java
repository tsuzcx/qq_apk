package com.tencent.mm.plugin.recordvideo.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/biz/MediaGenerateMediaCallback;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "onEditFinish", "", "forward", "", "reportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "extData", "Landroid/os/Bundle;", "onFinishBtnClick", "context", "Landroid/content/Context;", "finishController", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaGenerated", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "plugin-recordvideo_release"})
public final class a
  implements CaptureDataManager.b
{
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(75342);
    p.h(paramContext, "context");
    p.h(paramCaptureVideoNormalModel, "model");
    p.h(paramBundle, "extData");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_extra_data", paramBundle);
    localIntent.putExtra("KSEGMENTMEDIAINFO", (Parcelable)paramCaptureVideoNormalModel);
    ((Activity)paramContext).setResult(-1, localIntent);
    ((Activity)paramContext).finish();
    AppMethodBeat.o(75342);
  }
  
  public final void a(RecordMediaReportInfo paramRecordMediaReportInfo, Bundle paramBundle)
  {
    AppMethodBeat.i(206549);
    p.h(paramRecordMediaReportInfo, "reportInfo");
    p.h(paramBundle, "extData");
    AppMethodBeat.o(206549);
  }
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    AppMethodBeat.i(75341);
    p.h(paramContext, "context");
    p.h(paramBundle, "extData");
    p.h(parama, "finishController");
    AppMethodBeat.o(75341);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.a.a
 * JD-Core Version:    0.7.0.1
 */