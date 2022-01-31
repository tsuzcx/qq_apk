package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.gdpr.a;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.protocal.c.bnf;
import com.tencent.mm.sdk.platformtools.y;

final class SDKOAuthUI$16
  implements View.OnClickListener
{
  SDKOAuthUI$16(SDKOAuthUI paramSDKOAuthUI, bnf parambnf) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.SdkOAuthUI", "accept go  MPGdprPolicyUtil.checkPolicy");
    c.a(this.rmk, a.dYv, SDKOAuthUI.a(this.rmk), new SDKOAuthUI.16.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.16
 * JD-Core Version:    0.7.0.1
 */