package com.tencent.mm.plugin.webwx.ui;

import android.animation.Animator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;

final class WebWXLogoutUI$3
  implements View.OnClickListener
{
  WebWXLogoutUI$3(WebWXLogoutUI paramWebWXLogoutUI, Animator paramAnimator) {}
  
  public final void onClick(View paramView)
  {
    if (WebWXLogoutUI.c(this.rEh)) {
      WebWXLogoutUI.d(this.rEh).setImageResource(R.k.connect_icon_lock_on_regular);
    }
    for (;;)
    {
      WebWXLogoutUI.e(this.rEh);
      this.rEh.findViewById(R.h.webwx_lock_progress).setVisibility(0);
      this.rEi.start();
      return;
      WebWXLogoutUI.d(this.rEh).setImageResource(R.k.connect_icon_lock_off_regular);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI.3
 * JD-Core Version:    0.7.0.1
 */