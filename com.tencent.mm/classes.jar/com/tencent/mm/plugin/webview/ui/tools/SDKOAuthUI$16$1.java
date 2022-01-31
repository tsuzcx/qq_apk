package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.protocal.c.bnf;
import com.tencent.mm.sdk.platformtools.y;

final class SDKOAuthUI$16$1
  implements b
{
  SDKOAuthUI$16$1(SDKOAuthUI.16 param16) {}
  
  public final void hX(int paramInt)
  {
    y.i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1)
    {
      SDKOAuthUI.a(this.rmm.rmk, -4);
      this.rmm.rmk.finish();
      return;
    }
    if (this.rmm.rml.tvM)
    {
      SDKOAuthUI.a(this.rmm.rmk, SDKOAuthUI.a(this.rmm.rmk), SDKOAuthUI.b(this.rmm.rmk).state, SDKOAuthUI.Th(SDKOAuthUI.a(this.rmm.rmk)), SDKOAuthUI.c(this.rmm.rmk).cdG());
      return;
    }
    SDKOAuthUI.a(this.rmm.rmk, this.rmm.rml.sLy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.16.1
 * JD-Core Version:    0.7.0.1
 */