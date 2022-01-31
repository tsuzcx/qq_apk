package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.plugin.webview.f.a;
import com.tencent.mm.protocal.protobuf.bxa;
import com.tencent.mm.sdk.platformtools.ab;

final class SDKOAuthUI$9$1
  implements b
{
  SDKOAuthUI$9$1(SDKOAuthUI.9 param9) {}
  
  public final void kK(int paramInt)
  {
    AppMethodBeat.i(7531);
    ab.i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1)
    {
      SDKOAuthUI.a(this.vbU.vbR, -4);
      a.vtM.a(SDKOAuthUI.a(this.vbU.vbR), SDKOAuthUI.b(this.vbU.vbR), 0, SDKOAuthUI.c(this.vbU.vbR), 1, 1, 0);
      this.vbU.vbR.finish();
      AppMethodBeat.o(7531);
      return;
    }
    if (this.vbU.vbS.xvX)
    {
      SDKOAuthUI.a(this.vbU.vbR, SDKOAuthUI.a(this.vbU.vbR), SDKOAuthUI.e(this.vbU.vbR).state, SDKOAuthUI.aij(SDKOAuthUI.a(this.vbU.vbR)), SDKOAuthUI.f(this.vbU.vbR).ddG());
      AppMethodBeat.o(7531);
      return;
    }
    a.vtM.a(SDKOAuthUI.a(this.vbU.vbR), SDKOAuthUI.b(this.vbU.vbR), 1, SDKOAuthUI.c(this.vbU.vbR), 1, 1, 0);
    SDKOAuthUI.a(this.vbU.vbR, this.vbU.vbS.wqy);
    AppMethodBeat.o(7531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.9.1
 * JD-Core Version:    0.7.0.1
 */