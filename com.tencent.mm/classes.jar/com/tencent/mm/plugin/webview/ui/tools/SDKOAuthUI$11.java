package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class SDKOAuthUI$11
  implements am.a
{
  SDKOAuthUI$11(SDKOAuthUI paramSDKOAuthUI) {}
  
  public final boolean tC()
  {
    if (this.rmk.isFinishing())
    {
      y.i("MicroMsg.SdkOAuthUI", "onTimerExpired isFinishing");
      return false;
    }
    SDKOAuthUI.j(this.rmk);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.11
 * JD-Core Version:    0.7.0.1
 */