package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.R.l;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;

final class OAuthUI$7
  implements c.a
{
  OAuthUI$7(OAuthUI paramOAuthUI) {}
  
  public final void a(c paramc, String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.OAuthUI", "onResult, url = " + paramString + ", isShowLocalErrorPage = " + paramBoolean);
    if (paramc != null) {
      paramc.rln = false;
    }
    if (paramBoolean) {}
    do
    {
      do
      {
        try
        {
          paramc = this.rlw.getString(R.l.oauth_network_error_doc);
          y.i("MicroMsg.OAuthUI", "onResult, html = " + paramc);
          if (this.rlw.niQ != null)
          {
            this.rlw.niQ.loadUrl(paramc);
            if (this.rlw.rfg != null) {
              this.rlw.rfg.cch().caS = paramc;
            }
          }
          return;
        }
        catch (Exception paramc)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.OAuthUI", paramc, "", new Object[0]);
            paramc = null;
          }
        }
      } while ((bk.bl(paramString)) || (this.rlw.niQ == null));
      this.rlw.niQ.loadUrl(paramString);
    } while (this.rlw.rfg == null);
    this.rlw.rfg.cch().caS = paramString;
  }
  
  public final void d(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (paramBoolean)
    {
      OAuthUI.a(this.rlw, paramString2, paramString3, paramString1);
      return;
    }
    OAuthUI.b(this.rlw, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OAuthUI.7
 * JD-Core Version:    0.7.0.1
 */