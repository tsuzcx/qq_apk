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
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.vfs.i;
import com.tencent.xweb.util.d;

final class ak$8
  implements CaptureDataManager.b
{
  ak$8(ak paramak) {}
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(98163);
    paramBundle = new bsz();
    paramBundle.FhZ = true;
    paramBundle.FhY = false;
    q.atg(paramCaptureVideoNormalModel.dvk().x("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)));
    String str = i.aSu(paramCaptureVideoNormalModel.videoPath);
    paramBundle = new SightCaptureResult(true, paramCaptureVideoNormalModel.videoPath, paramCaptureVideoNormalModel.thumbPath, str, d.getMD5(paramCaptureVideoNormalModel.videoPath), (int)(paramCaptureVideoNormalModel.wqk.longValue() / 1000L), paramBundle);
    if (paramCaptureVideoNormalModel.wql.booleanValue())
    {
      paramBundle.uJm = true;
      paramBundle.oWm = false;
      paramBundle.uJu = paramCaptureVideoNormalModel.thumbPath;
    }
    paramCaptureVideoNormalModel = new Intent();
    paramCaptureVideoNormalModel.putExtra("key_req_result", paramBundle);
    ((Activity)paramContext).setResult(-1, paramCaptureVideoNormalModel);
    ((Activity)paramContext).finish();
    AppMethodBeat.o(98163);
  }
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ak.8
 * JD-Core Version:    0.7.0.1
 */