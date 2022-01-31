package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;

final class OnlineVideoView$16
  implements ap.a
{
  OnlineVideoView$16(OnlineVideoView paramOnlineVideoView) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(38405);
    if ((this.rJD.rJi == null) || (this.rJD.kvG == null))
    {
      AppMethodBeat.o(38405);
      return false;
    }
    if (((View)this.rJD.kvG).getAlpha() < 1.0F)
    {
      ab.i("MicroMsg.OnlineVideoView", "onlineVideoTimer switchVideoModel");
      OnlineVideoView.k(this.rJD);
    }
    if (this.rJD.kvG.isPlaying()) {
      OnlineVideoView.l(this.rJD);
    }
    try
    {
      boolean bool = bo.isNullOrNil(this.rJD.rJi.fVf);
      if (!bool) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(38405);
        return false;
      }
      i = this.rJD.kvG.getCurrentPosition() / 1000;
      bool = this.rJD.rJi.mj(i);
      AppMethodBeat.o(38405);
      return bool;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.OnlineVideoView", "online video timer check error : " + localException.toString());
      AppMethodBeat.o(38405);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.16
 * JD-Core Version:    0.7.0.1
 */