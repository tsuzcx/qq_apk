package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.plugin.webview.f.a;
import com.tencent.mm.protocal.protobuf.bxa;
import com.tencent.mm.sdk.platformtools.ab;

final class SDKOAuthUI$8
  implements b
{
  SDKOAuthUI$8(SDKOAuthUI paramSDKOAuthUI, bxa parambxa) {}
  
  public final void kK(int paramInt)
  {
    AppMethodBeat.i(7530);
    ab.i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1)
    {
      SDKOAuthUI.a(this.vbR, -4);
      a.vtM.a(SDKOAuthUI.a(this.vbR), SDKOAuthUI.b(this.vbR), 0, SDKOAuthUI.c(this.vbR), 0, 0, 0);
      this.vbR.finish();
      AppMethodBeat.o(7530);
      return;
    }
    SDKOAuthUI.a(this.vbR, this.vbS.wqy);
    a.vtM.a(SDKOAuthUI.a(this.vbR), SDKOAuthUI.b(this.vbR), 1, SDKOAuthUI.c(this.vbR), 0, 0, 0);
    AppMethodBeat.o(7530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.8
 * JD-Core Version:    0.7.0.1
 */