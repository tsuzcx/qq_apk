package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.f.a;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.protocal.protobuf.bgv;
import com.tencent.mm.protocal.protobuf.bxa;

final class SDKOAuthUI$11
  implements View.OnClickListener
{
  SDKOAuthUI$11(SDKOAuthUI paramSDKOAuthUI, bxa parambxa) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(7534);
    SDKOAuthUI.g(this.vbR);
    bgv localbgv = ai.d("snsapi_userinfo", this.vbS.xvT);
    paramView = localbgv;
    if (localbgv == null)
    {
      SDKOAuthUI.g(this.vbR);
      paramView = ai.d("snsapi_login", this.vbS.xvT);
    }
    if (paramView == null)
    {
      SDKOAuthUI.g(this.vbR);
      paramView = ai.d("group_sns_login", this.vbS.xvT);
    }
    for (;;)
    {
      a.vtM.a(SDKOAuthUI.a(this.vbR), SDKOAuthUI.b(this.vbR), 0, SDKOAuthUI.c(this.vbR), 2, 1, 0);
      SDKOAuthUI.a(this.vbR, paramView, this.vbS);
      AppMethodBeat.o(7534);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.11
 * JD-Core Version:    0.7.0.1
 */