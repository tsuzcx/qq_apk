package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw.a;

final class SDKOAuthUI$6
  implements aw.a
{
  SDKOAuthUI$6(SDKOAuthUI paramSDKOAuthUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(79737);
    if (this.Esd.isFinishing())
    {
      ae.i("MicroMsg.SdkOAuthUI", "onTimerExpired isFinishing");
      AppMethodBeat.o(79737);
      return false;
    }
    SDKOAuthUI.q(this.Esd);
    AppMethodBeat.o(79737);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.6
 * JD-Core Version:    0.7.0.1
 */