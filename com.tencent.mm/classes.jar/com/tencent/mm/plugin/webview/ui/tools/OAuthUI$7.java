package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.as;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;

final class OAuthUI$7
  implements e.a
{
  OAuthUI$7(OAuthUI paramOAuthUI) {}
  
  public final void a(e parame, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(7423);
    ab.i("MicroMsg.OAuthUI", "onResult, url = " + paramString + ", isShowLocalErrorPage = " + paramBoolean);
    parame.vaP = false;
    if (paramBoolean) {
      try
      {
        parame = this.vaY.getString(2131301993);
        ab.i("MicroMsg.OAuthUI", "onResult, html = ".concat(String.valueOf(parame)));
        if (this.vaY.pOd != null)
        {
          this.vaY.pOd.loadUrl(parame);
          if (this.vaY.uVh != null) {
            this.vaY.uVh.dck().cJr = parame;
          }
        }
        AppMethodBeat.o(7423);
        return;
      }
      catch (Exception parame)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.OAuthUI", parame, "", new Object[0]);
          parame = null;
        }
      }
    }
    if ((!bo.isNullOrNil(paramString)) && (this.vaY.pOd != null))
    {
      this.vaY.pOd.loadUrl(paramString);
      if (this.vaY.uVh != null) {
        this.vaY.uVh.dck().cJr = paramString;
      }
    }
    AppMethodBeat.o(7423);
  }
  
  public final void c(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(7424);
    if (paramBoolean)
    {
      OAuthUI.a(this.vaY, paramString2, paramString3, paramString1);
      AppMethodBeat.o(7424);
      return;
    }
    OAuthUI.b(this.vaY, paramString3);
    AppMethodBeat.o(7424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OAuthUI.7
 * JD-Core Version:    0.7.0.1
 */