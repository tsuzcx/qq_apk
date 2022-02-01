package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.textstatus.a.m;
import com.tencent.mm.plugin.textstatus.g.z;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.util.d;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$cameraClickListener$1$generateCallback$1", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$SimpleVideoGenerateCallback;", "onFinishBtnClick", "", "context", "Landroid/content/Context;", "extData", "Landroid/os/Bundle;", "finishController", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaGenerated", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "plugin-textstatus_release"})
public final class TextStatusEditActivity$c$a
  extends CaptureDataManager.c
{
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(216486);
    p.h(paramContext, "context");
    p.h(paramCaptureVideoNormalModel, "model");
    p.h(paramBundle, "extData");
    paramBundle = new cly();
    paramBundle.Mrn = true;
    paramBundle.Mrm = false;
    Object localObject1 = s.bpb(paramCaptureVideoNormalModel.getVideoPath());
    paramBundle = new SightCaptureResult(true, paramCaptureVideoNormalModel.getVideoPath(), paramCaptureVideoNormalModel.aQn(), (String)localObject1, d.getMD5(paramCaptureVideoNormalModel.getVideoPath()), Math.round((float)paramCaptureVideoNormalModel.eJH().longValue() * 1.0F / 1000.0F), paramBundle);
    localObject1 = paramCaptureVideoNormalModel.eJI();
    p.g(localObject1, "model.getPhoto()");
    if (((Boolean)localObject1).booleanValue())
    {
      paramBundle.zsy = true;
      paramBundle.tkD = false;
      paramBundle.zsG = paramCaptureVideoNormalModel.aQn();
    }
    localObject1 = SecDataUIC.CWq;
    localObject1 = this.UsV.GeQ.getContext();
    p.g(localObject1, "getContext()");
    localObject1 = (z)SecDataUIC.a.a((Context)localObject1, 8, z.class);
    if (localObject1 != null)
    {
      Object localObject2 = paramCaptureVideoNormalModel.eJJ().y("KEY_ORIGIN_MEDIA_DURATION_MS_LONG", Long.valueOf(0L));
      p.g(localObject2, "model.reportInfo.getRepo…DIA_DURATION_MS_LONG, 0L)");
      ((z)localObject1).Usg = ((Number)localObject2).longValue();
      ((z)localObject1).Usj = (((Number)paramCaptureVideoNormalModel.eJJ().y("KEY_MEDIA_SOURCE_INT", Integer.valueOf(0))).intValue() + 1);
      paramCaptureVideoNormalModel = this.UsV.GeQ.Gev;
      if ((paramCaptureVideoNormalModel != null) && (paramCaptureVideoNormalModel.Gah != null)) {
        ((z)localObject1).Usp = 1L;
      }
    }
    paramCaptureVideoNormalModel = new Intent();
    paramCaptureVideoNormalModel.putExtra("key_req_result", (Parcelable)paramBundle);
    ((Activity)paramContext).setResult(-1, paramCaptureVideoNormalModel);
    ((Activity)paramContext).finish();
    AppMethodBeat.o(216486);
  }
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    AppMethodBeat.i(216487);
    p.h(paramContext, "context");
    p.h(paramBundle, "extData");
    p.h(parama, "finishController");
    AppMethodBeat.o(216487);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.c.a
 * JD-Core Version:    0.7.0.1
 */