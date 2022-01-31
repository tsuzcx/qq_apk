package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class SDKOAuthUI$6
  implements ap.a
{
  SDKOAuthUI$6(SDKOAuthUI paramSDKOAuthUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(153190);
    if (this.vbR.isFinishing())
    {
      ab.i("MicroMsg.SdkOAuthUI", "onTimerExpired isFinishing");
      AppMethodBeat.o(153190);
      return false;
    }
    SDKOAuthUI.q(this.vbR);
    AppMethodBeat.o(153190);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.6
 * JD-Core Version:    0.7.0.1
 */