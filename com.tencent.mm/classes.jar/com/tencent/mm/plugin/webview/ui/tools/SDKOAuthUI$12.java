package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.protocal.c.bnf;
import com.tencent.mm.sdk.platformtools.y;

final class SDKOAuthUI$12
  implements b
{
  SDKOAuthUI$12(SDKOAuthUI paramSDKOAuthUI, bnf parambnf) {}
  
  public final void hX(int paramInt)
  {
    y.i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1)
    {
      SDKOAuthUI.a(this.rmk, -4);
      return;
    }
    SDKOAuthUI.a(this.rmk, this.rml.sLy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.12
 * JD-Core Version:    0.7.0.1
 */