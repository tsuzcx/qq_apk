package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.protocal.protobuf.bo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.w;

final class SnsAdNativeLandingPagesUI$2
  implements AdLandingPagesProxy.e
{
  SnsAdNativeLandingPagesUI$2(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI) {}
  
  public final void aH(Object paramObject) {}
  
  public final void i(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(247844);
    Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "doAdNativeAntiAbuseScene end, errType = " + paramInt1 + ", errNo = " + paramInt2 + ", canvasAuthFailed = " + paramObject);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramObject != null)) {
      try
      {
        bo localbo = new bo();
        localbo.parseFrom((byte[])paramObject);
        if (localbo.RGG != 0) {
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(200103);
              Context localContext = SnsAdNativeLandingPagesUI.2.this.KMH.getApplicationContext();
              if (localContext != null) {
                w.cS(localContext, "广告无效，已为你关闭");
              }
              SnsAdNativeLandingPagesUI.2.this.KMH.cJs();
              AppMethodBeat.o(200103);
            }
          }, 500L);
        }
        AppMethodBeat.o(247844);
        return;
      }
      catch (Throwable paramObject)
      {
        Log.e("MicroMsg.SnsAdNativeLandingPagesUI", paramObject.toString());
      }
    }
    AppMethodBeat.o(247844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.2
 * JD-Core Version:    0.7.0.1
 */