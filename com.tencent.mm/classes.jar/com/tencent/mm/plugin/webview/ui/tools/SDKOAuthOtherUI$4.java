package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.f.a;

final class SDKOAuthOtherUI$4
  implements View.OnClickListener
{
  SDKOAuthOtherUI$4(SDKOAuthOtherUI paramSDKOAuthOtherUI, boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(153184);
    a.vtM.a(SDKOAuthOtherUI.a(this.vbx), SDKOAuthOtherUI.b(this.vbx), 0, SDKOAuthOtherUI.c(this.vbx), 4, 1, 0);
    SDKOAuthOtherUI.a(this.vbx, this.vbz, this.vbs, this.vby);
    AppMethodBeat.o(153184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthOtherUI.4
 * JD-Core Version:    0.7.0.1
 */