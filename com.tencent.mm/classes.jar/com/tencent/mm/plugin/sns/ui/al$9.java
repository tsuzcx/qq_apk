package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.util.d;

final class al$9
  extends CaptureDataManager.c
{
  al$9(al paramal) {}
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(97998);
    paramBundle = new cly();
    paramBundle.Mrn = true;
    paramBundle.Mrm = false;
    String str = s.bpb(paramCaptureVideoNormalModel.videoPath);
    paramBundle = new SightCaptureResult(true, paramCaptureVideoNormalModel.videoPath, paramCaptureVideoNormalModel.thumbPath, str, d.getMD5(paramCaptureVideoNormalModel.videoPath), (int)(paramCaptureVideoNormalModel.BOd.longValue() / 1000L), paramBundle);
    if (paramCaptureVideoNormalModel.BOe.booleanValue())
    {
      paramBundle.zsy = true;
      paramBundle.tkD = false;
      paramBundle.zsG = paramCaptureVideoNormalModel.thumbPath;
    }
    paramCaptureVideoNormalModel = new Intent();
    paramCaptureVideoNormalModel.putExtra("key_req_result", paramBundle);
    ((Activity)paramContext).setResult(-1, paramCaptureVideoNormalModel);
    ((Activity)paramContext).finish();
    AppMethodBeat.o(97998);
  }
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.al.9
 * JD-Core Version:    0.7.0.1
 */