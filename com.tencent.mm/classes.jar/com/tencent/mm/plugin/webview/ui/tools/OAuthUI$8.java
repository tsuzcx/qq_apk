package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class OAuthUI$8
  implements ap.a
{
  OAuthUI$8(OAuthUI paramOAuthUI, String paramString, View paramView, ThreeDotsLoadingView paramThreeDotsLoadingView) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(7425);
    OAuthUI.a(this.vaY, this.njr);
    this.vaZ.setVisibility(8);
    this.vba.dOW();
    AppMethodBeat.o(7425);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OAuthUI.8
 * JD-Core Version:    0.7.0.1
 */