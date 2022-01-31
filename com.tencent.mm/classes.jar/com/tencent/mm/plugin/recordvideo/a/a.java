package com.tencent.mm.plugin.recordvideo.a;

import a.f.b.j;
import a.l;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/biz/MediaGenerateMediaCallback;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "onFinishBtnClick", "", "context", "Landroid/content/Context;", "extData", "Landroid/os/Bundle;", "finishController", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaGenerated", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "plugin-recordvideo_release"})
public final class a
  implements CaptureDataManager.b
{
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(150561);
    j.q(paramContext, "context");
    j.q(paramCaptureVideoNormalModel, "model");
    j.q(paramBundle, "extData");
    paramBundle = new Intent();
    paramBundle.putExtra("KSEGMENTMEDIAINFO", (Parcelable)paramCaptureVideoNormalModel);
    ((Activity)paramContext).setResult(-1, paramBundle);
    ((Activity)paramContext).finish();
    AppMethodBeat.o(150561);
  }
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    AppMethodBeat.i(150560);
    j.q(paramContext, "context");
    j.q(paramBundle, "extData");
    j.q(parama, "finishController");
    AppMethodBeat.o(150560);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.a.a
 * JD-Core Version:    0.7.0.1
 */