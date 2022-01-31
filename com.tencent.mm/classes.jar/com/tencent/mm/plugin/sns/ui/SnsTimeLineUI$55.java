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
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.vfs.e;
import com.tencent.xweb.util.d;

final class SnsTimeLineUI$55
  implements CaptureDataManager.b
{
  SnsTimeLineUI$55(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(155763);
    i.ZQ(paramCaptureVideoNormalModel.qbl.q("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)));
    paramBundle = new bby();
    paramBundle.xra = true;
    paramBundle.xqZ = false;
    String str = e.avM(paramCaptureVideoNormalModel.videoPath);
    paramBundle = new SightCaptureResult(true, paramCaptureVideoNormalModel.videoPath, paramCaptureVideoNormalModel.thumbPath, str, d.getMD5(paramCaptureVideoNormalModel.videoPath), (int)(paramCaptureVideoNormalModel.qbj.longValue() / 1000L), paramBundle);
    if (paramCaptureVideoNormalModel.qbk.booleanValue())
    {
      paramBundle.oFG = true;
      paramBundle.mCu = false;
      paramBundle.oFO = paramCaptureVideoNormalModel.thumbPath;
    }
    paramCaptureVideoNormalModel = new Intent();
    paramCaptureVideoNormalModel.putExtra("key_req_result", paramBundle);
    ((Activity)paramContext).setResult(-1, paramCaptureVideoNormalModel);
    ((Activity)paramContext).finish();
    AppMethodBeat.o(155763);
  }
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.55
 * JD-Core Version:    0.7.0.1
 */