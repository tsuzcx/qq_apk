package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class SDKOAuthUI$3
  implements View.OnClickListener
{
  SDKOAuthUI$3(SDKOAuthUI paramSDKOAuthUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.rmk, CreateAvatarUI.class);
    paramView.putExtra("0", SDKOAuthUI.a(this.rmk));
    this.rmk.startActivityForResult(paramView, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.3
 * JD-Core Version:    0.7.0.1
 */