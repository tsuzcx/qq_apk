package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av.a;

final class SDKOAuthUI$6
  implements av.a
{
  SDKOAuthUI$6(SDKOAuthUI paramSDKOAuthUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(79737);
    if (this.Eab.isFinishing())
    {
      ad.i("MicroMsg.SdkOAuthUI", "onTimerExpired isFinishing");
      AppMethodBeat.o(79737);
      return false;
    }
    SDKOAuthUI.q(this.Eab);
    AppMethodBeat.o(79737);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.6
 * JD-Core Version:    0.7.0.1
 */