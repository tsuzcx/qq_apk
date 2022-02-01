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
import com.tencent.mm.plugin.secdata.ui.a;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.textstatus.a.q;
import com.tencent.mm.plugin.textstatus.proto.am;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.vfs.u;
import com.tencent.xweb.util.d;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$goCapture$generateCallback$1", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$SimpleVideoGenerateCallback;", "onFinishBtnClick", "", "context", "Landroid/content/Context;", "extData", "Landroid/os/Bundle;", "finishController", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaGenerated", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "plugin-textstatus_release"})
public final class TextStatusEditActivity$q
  extends CaptureDataManager.c
{
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(233060);
    p.k(paramContext, "context");
    p.k(paramCaptureVideoNormalModel, "model");
    p.k(paramBundle, "extData");
    paramBundle = new cuv();
    paramBundle.TCA = true;
    paramBundle.TCz = false;
    Object localObject1 = u.bBW(paramCaptureVideoNormalModel.getVideoPath());
    paramBundle = new SightCaptureResult(true, paramCaptureVideoNormalModel.getVideoPath(), paramCaptureVideoNormalModel.aZe(), (String)localObject1, d.getMD5(paramCaptureVideoNormalModel.getVideoPath()), Math.round((float)paramCaptureVideoNormalModel.fvS().longValue() * 1.0F / 1000.0F), paramBundle);
    localObject1 = paramCaptureVideoNormalModel.fvT();
    p.j(localObject1, "model.getPhoto()");
    if (((Boolean)localObject1).booleanValue())
    {
      paramBundle.EXZ = true;
      paramBundle.wRb = false;
      paramBundle.EYh = paramCaptureVideoNormalModel.aZe();
    }
    localObject1 = a.JbV;
    localObject1 = this.MMz.getContext();
    p.j(localObject1, "getContext()");
    localObject1 = (am)a.a.a((Context)localObject1, 8, am.class);
    if (localObject1 != null)
    {
      Object localObject2 = paramCaptureVideoNormalModel.fvU().x("KEY_ORIGIN_MEDIA_DURATION_MS_LONG", Long.valueOf(0L));
      p.j(localObject2, "model.reportInfo.getRepo…DIA_DURATION_MS_LONG, 0L)");
      ((am)localObject1).MGb = ((Number)localObject2).longValue();
      ((am)localObject1).MGe = (((Number)paramCaptureVideoNormalModel.fvU().x("KEY_MEDIA_SOURCE_INT", Integer.valueOf(0))).intValue() + 1);
      paramCaptureVideoNormalModel = this.MMz.MKR;
      if ((paramCaptureVideoNormalModel != null) && (paramCaptureVideoNormalModel.MEC == 5L)) {
        ((am)localObject1).MGk = 1L;
      }
    }
    paramCaptureVideoNormalModel = new Intent();
    paramCaptureVideoNormalModel.putExtra("key_req_result", (Parcelable)paramBundle);
    ((Activity)paramContext).setResult(-1, paramCaptureVideoNormalModel);
    ((Activity)paramContext).finish();
    AppMethodBeat.o(233060);
  }
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    AppMethodBeat.i(233062);
    p.k(paramContext, "context");
    p.k(paramBundle, "extData");
    p.k(parama, "finishController");
    AppMethodBeat.o(233062);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.q
 * JD-Core Version:    0.7.0.1
 */