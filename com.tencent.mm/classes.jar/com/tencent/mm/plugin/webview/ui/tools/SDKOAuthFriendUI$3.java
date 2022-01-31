package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.f.a;

final class SDKOAuthFriendUI$3
  implements View.OnClickListener
{
  SDKOAuthFriendUI$3(SDKOAuthFriendUI paramSDKOAuthFriendUI, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(7492);
    a.vtM.a(SDKOAuthFriendUI.a(this.vbr), SDKOAuthFriendUI.b(this.vbr), 1, SDKOAuthFriendUI.c(this.vbr), 3, 1, 0);
    SDKOAuthFriendUI.a(this.vbr, this.vbs);
    AppMethodBeat.o(7492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthFriendUI.3
 * JD-Core Version:    0.7.0.1
 */