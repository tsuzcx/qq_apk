package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.ui.base.h;

final class e$1
  implements ap.a
{
  e$1(e parame) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(7414);
    if (this.vaS.vaR.isFinishing())
    {
      ab.w("MicroMsg.OAuthSession", "onTimerExpired, context is finishing");
      AppMethodBeat.o(7414);
      return false;
    }
    e locale = this.vaS;
    OAuthUI localOAuthUI = this.vaS.vaR;
    this.vaS.vaR.getString(2131297087);
    locale.mOt = h.b(localOAuthUI, this.vaS.vaR.getString(2131297112), true, new e.1.1(this));
    AppMethodBeat.o(7414);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.e.1
 * JD-Core Version:    0.7.0.1
 */