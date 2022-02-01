package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.vfs.i;
import com.tencent.xweb.util.d;

final class SnsTimeLineUI$62
  implements CaptureDataManager.b
{
  SnsTimeLineUI$62(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(179279);
    q.anU(paramCaptureVideoNormalModel.dhD().w("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)));
    paramBundle = new boj();
    paramBundle.DLK = true;
    paramBundle.DLJ = false;
    String str = i.aMS(paramCaptureVideoNormalModel.videoPath);
    paramBundle = new SightCaptureResult(true, paramCaptureVideoNormalModel.videoPath, paramCaptureVideoNormalModel.thumbPath, str, d.getMD5(paramCaptureVideoNormalModel.videoPath), (int)(paramCaptureVideoNormalModel.vhy.longValue() / 1000L), paramBundle);
    if (paramCaptureVideoNormalModel.vhz.booleanValue())
    {
      paramBundle.tAP = true;
      paramBundle.osM = false;
      paramBundle.tAX = paramCaptureVideoNormalModel.thumbPath;
    }
    paramCaptureVideoNormalModel = new Intent();
    paramCaptureVideoNormalModel.putExtra("key_req_result", paramBundle);
    ((Activity)paramContext).setResult(-1, paramCaptureVideoNormalModel);
    ((Activity)paramContext).finish();
    AppMethodBeat.o(179279);
  }
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.62
 * JD-Core Version:    0.7.0.1
 */