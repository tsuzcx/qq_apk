package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SDKOAuthUI$15
  implements View.OnClickListener
{
  SDKOAuthUI$15(SDKOAuthUI paramSDKOAuthUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(7538);
    paramView = new Intent(this.vbR, CreateAvatarUI.class);
    paramView.putExtra("0", SDKOAuthUI.a(this.vbR));
    paramView.putExtra("default_fileid", SDKOAuthUI.m(this.vbR));
    this.vbR.startActivityForResult(paramView, 6);
    AppMethodBeat.o(7538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.15
 * JD-Core Version:    0.7.0.1
 */