package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.f.a;

final class SDKOAuthOtherUI$3
  implements View.OnClickListener
{
  SDKOAuthOtherUI$3(SDKOAuthOtherUI paramSDKOAuthOtherUI, int paramInt1, int paramInt2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(7508);
    a.vtM.a(SDKOAuthOtherUI.a(this.vbx), SDKOAuthOtherUI.b(this.vbx), 1, SDKOAuthOtherUI.c(this.vbx), 4, 1, 0);
    SDKOAuthOtherUI.a(this.vbx, this.vbs, this.vby);
    AppMethodBeat.o(7508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthOtherUI.3
 * JD-Core Version:    0.7.0.1
 */