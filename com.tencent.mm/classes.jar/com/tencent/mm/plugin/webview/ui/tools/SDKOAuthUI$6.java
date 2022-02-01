package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

final class SDKOAuthUI$6
  implements MTimerHandler.CallBack
{
  SDKOAuthUI$6(SDKOAuthUI paramSDKOAuthUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(79737);
    if (this.Qcn.isFinishing())
    {
      Log.i("MicroMsg.SdkOAuthUI", "onTimerExpired isFinishing");
      AppMethodBeat.o(79737);
      return false;
    }
    SDKOAuthUI.q(this.Qcn);
    AppMethodBeat.o(79737);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.6
 * JD-Core Version:    0.7.0.1
 */