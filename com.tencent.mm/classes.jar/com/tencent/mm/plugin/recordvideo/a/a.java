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
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/biz/MediaGenerateMediaCallback;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "onFinishBtnClick", "", "context", "Landroid/content/Context;", "extData", "Landroid/os/Bundle;", "finishController", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaGenerated", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "plugin-recordvideo_release"})
public final class a
  implements CaptureDataManager.b
{
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(75342);
    k.h(paramContext, "context");
    k.h(paramCaptureVideoNormalModel, "model");
    k.h(paramBundle, "extData");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_extra_data", paramBundle);
    localIntent.putExtra("KSEGMENTMEDIAINFO", (Parcelable)paramCaptureVideoNormalModel);
    ((Activity)paramContext).setResult(-1, localIntent);
    ((Activity)paramContext).finish();
    AppMethodBeat.o(75342);
  }
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    AppMethodBeat.i(75341);
    k.h(paramContext, "context");
    k.h(paramBundle, "extData");
    k.h(parama, "finishController");
    AppMethodBeat.o(75341);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.a.a
 * JD-Core Version:    0.7.0.1
 */