package com.tencent.mm.plugin.webwx.ui;

import android.animation.Animator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WebWXLogoutUI$4
  implements View.OnClickListener
{
  WebWXLogoutUI$4(WebWXLogoutUI paramWebWXLogoutUI, Animator paramAnimator) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26541);
    if (WebWXLogoutUI.c(this.vuJ)) {
      WebWXLogoutUI.d(this.vuJ).setImageResource(2131231170);
    }
    for (;;)
    {
      WebWXLogoutUI.e(this.vuJ);
      this.vuJ.findViewById(2131829563).setVisibility(0);
      this.vuK.start();
      AppMethodBeat.o(26541);
      return;
      WebWXLogoutUI.d(this.vuJ).setImageResource(2131231168);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI.4
 * JD-Core Version:    0.7.0.1
 */