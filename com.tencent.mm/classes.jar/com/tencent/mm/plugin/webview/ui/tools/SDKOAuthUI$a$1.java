package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.R.k;
import com.tencent.mm.protocal.c.azs;

final class SDKOAuthUI$a$1
  implements View.OnClickListener
{
  SDKOAuthUI$a$1(SDKOAuthUI.a parama, azs paramazs, ImageView paramImageView) {}
  
  public final void onClick(View paramView)
  {
    if (this.rlZ.tvP == 2)
    {
      this.fYc.setImageResource(R.k.login_auth_state_not_selected);
      this.rlZ.tvP = 1;
    }
    while (this.rlZ.tvP != 1) {
      return;
    }
    this.fYc.setImageResource(R.k.login_auth_state_default_select);
    this.rlZ.tvP = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.a.1
 * JD-Core Version:    0.7.0.1
 */