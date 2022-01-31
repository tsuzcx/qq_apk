package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

final class c$1
  implements am.a
{
  c$1(c paramc) {}
  
  public final boolean tC()
  {
    if (this.rlq.rlp.isFinishing())
    {
      y.w("MicroMsg.OAuthSession", "onTimerExpired, context is finishing");
      return false;
    }
    c localc = this.rlq;
    OAuthUI localOAuthUI = this.rlq.rlp;
    this.rlq.rlp.getString(R.l.app_tip);
    localc.ksE = h.b(localOAuthUI, this.rlq.rlp.getString(R.l.app_waiting), true, new c.1.1(this));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.c.1
 * JD-Core Version:    0.7.0.1
 */