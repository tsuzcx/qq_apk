package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.plugin.webview.f.a;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.protocal.protobuf.bxa;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class SDKOAuthUI$2
  implements b
{
  SDKOAuthUI$2(SDKOAuthUI paramSDKOAuthUI, bxa parambxa) {}
  
  public final void kK(int paramInt)
  {
    AppMethodBeat.i(7525);
    ab.i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1)
    {
      SDKOAuthUI.a(this.vbR, -4);
      a.vtM.a(SDKOAuthUI.a(this.vbR), SDKOAuthUI.b(this.vbR), 0, SDKOAuthUI.c(this.vbR), 2, 1, 0);
      this.vbR.finish();
      AppMethodBeat.o(7525);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    SDKOAuthUI.g(this.vbR);
    ai.a(this.vbS, localLinkedList);
    SDKOAuthUI.n(this.vbR);
    if (SDKOAuthUI.o(this.vbR))
    {
      SDKOAuthUI.g(this.vbR);
      ai.a(localLinkedList, SDKOAuthUI.b.a(SDKOAuthUI.h(this.vbR)), SDKOAuthUI.p(this.vbR));
      AppMethodBeat.o(7525);
      return;
    }
    SDKOAuthUI.g(this.vbR).h(localLinkedList, SDKOAuthUI.b.a(SDKOAuthUI.h(this.vbR)));
    AppMethodBeat.o(7525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.2
 * JD-Core Version:    0.7.0.1
 */