package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.secdata.ui.a;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.textstatus.proto.bh;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$goCapture$generateCallback$1", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$SimpleVideoGenerateCallback;", "onFinishBtnClick", "", "context", "Landroid/content/Context;", "extData", "Landroid/os/Bundle;", "finishController", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaGenerated", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusEditActivity$q
  extends CaptureDataManager.c
{
  TextStatusEditActivity$q(TextStatusEditActivity paramTextStatusEditActivity) {}
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(291117);
    s.u(paramContext, "context");
    s.u(paramCaptureVideoNormalModel, "model");
    s.u(paramBundle, "extData");
    paramBundle = new dmb();
    paramBundle.aaSg = true;
    paramBundle.aaSf = false;
    Object localObject1 = y.bEq(paramCaptureVideoNormalModel.videoPath);
    paramBundle = new SightCaptureResult(true, paramCaptureVideoNormalModel.videoPath, paramCaptureVideoNormalModel.thumbPath, (String)localObject1, g.getMD5(paramCaptureVideoNormalModel.videoPath), Math.round((float)paramCaptureVideoNormalModel.NHJ.longValue() * 1.0F / 1000.0F), paramBundle);
    localObject1 = paramCaptureVideoNormalModel.NHK;
    s.s(localObject1, "model.getPhoto()");
    if (((Boolean)localObject1).booleanValue())
    {
      paramBundle.KTL = true;
      paramBundle.AnF = false;
      paramBundle.KTT = paramCaptureVideoNormalModel.thumbPath;
    }
    localObject1 = a.PlI;
    localObject1 = this.Tzd.getContext();
    s.s(localObject1, "getContext()");
    localObject1 = (bh)a.a.a((Context)localObject1, 8, bh.class);
    if (localObject1 != null)
    {
      Object localObject2 = paramCaptureVideoNormalModel.gHE().J("KEY_ORIGIN_MEDIA_DURATION_MS_LONG", Long.valueOf(0L));
      s.s(localObject2, "model.reportInfo.getRepo…DIA_DURATION_MS_LONG, 0L)");
      ((bh)localObject1).Tqv = ((Number)localObject2).longValue();
      ((bh)localObject1).Tqy = (((Number)paramCaptureVideoNormalModel.gHE().J("KEY_MEDIA_SOURCE_INT", Integer.valueOf(0))).intValue() + 1);
    }
    paramCaptureVideoNormalModel = new Intent();
    paramCaptureVideoNormalModel.putExtra("key_req_result", (Parcelable)paramBundle);
    ((Activity)paramContext).setResult(-1, paramCaptureVideoNormalModel);
    ((Activity)paramContext).finish();
    AppMethodBeat.o(291117);
  }
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    AppMethodBeat.i(291124);
    s.u(paramContext, "context");
    s.u(paramBundle, "extData");
    s.u(parama, "finishController");
    AppMethodBeat.o(291124);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.q
 * JD-Core Version:    0.7.0.1
 */