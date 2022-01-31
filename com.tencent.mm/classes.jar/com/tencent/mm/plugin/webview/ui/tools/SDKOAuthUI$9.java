package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.gdpr.a;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.protocal.protobuf.bxa;
import com.tencent.mm.sdk.platformtools.ab;

final class SDKOAuthUI$9
  implements View.OnClickListener
{
  SDKOAuthUI$9(SDKOAuthUI paramSDKOAuthUI, bxa parambxa) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(7532);
    ab.i("MicroMsg.SdkOAuthUI", "accept go  MPGdprPolicyUtil.checkPolicy");
    c.a(this.vbR, a.foA, SDKOAuthUI.a(this.vbR), new SDKOAuthUI.9.1(this));
    AppMethodBeat.o(7532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.9
 * JD-Core Version:    0.7.0.1
 */