package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.f.a;
import com.tencent.mm.protocal.protobuf.bgv;

final class SDKOAuthFriendUI$4
  implements View.OnClickListener
{
  SDKOAuthFriendUI$4(SDKOAuthFriendUI paramSDKOAuthFriendUI, bgv parambgv, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(153177);
    a.vtM.a(SDKOAuthFriendUI.a(this.vbr), SDKOAuthFriendUI.b(this.vbr), 0, SDKOAuthFriendUI.c(this.vbr), 3, 1, 0);
    SDKOAuthFriendUI.a(this.vbr, this.vbt, this.vbs);
    AppMethodBeat.o(153177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthFriendUI.4
 * JD-Core Version:    0.7.0.1
 */