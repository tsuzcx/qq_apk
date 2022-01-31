package com.tencent.mm.plugin.webwx.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WebWXLogoutUI$3
  extends AnimatorListenerAdapter
{
  WebWXLogoutUI$3(WebWXLogoutUI paramWebWXLogoutUI) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(26540);
    super.onAnimationEnd(paramAnimator);
    WebWXLogoutUI.c(this.vuJ, WebWXLogoutUI.c(this.vuJ));
    AppMethodBeat.o(26540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI.3
 * JD-Core Version:    0.7.0.1
 */