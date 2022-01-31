package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;

final class WebViewUI$t
  implements b
{
  private WebViewUI$t(WebViewUI paramWebViewUI) {}
  
  public final boolean ait(String paramString)
  {
    AppMethodBeat.i(7968);
    paramString = this.vgz.getString(2131302302);
    WebViewUI localWebViewUI = this.vgz;
    h.c local1 = new h.c()
    {
      public final void iA(int paramAnonymousInt)
      {
        AppMethodBeat.i(7966);
        if (paramAnonymousInt == 0)
        {
          WebViewUI.t localt = WebViewUI.t.this;
          try
          {
            Bundle localBundle = new Bundle();
            localBundle.putString("shortUrl", localt.vgz.getIntent().getStringExtra("shortUrl"));
            localBundle.putInt("type", localt.vgz.getIntent().getIntExtra("type", 0));
            localt.vgz.igU.a(4, localBundle, localt.hashCode());
            AppMethodBeat.o(7966);
            return;
          }
          catch (Exception localException)
          {
            ab.e("MicroMsg.WebViewUI", "share fail, ex = " + localException.getMessage());
          }
        }
        AppMethodBeat.o(7966);
      }
    };
    h.a(localWebViewUI, "", new String[] { paramString }, "", local1);
    AppMethodBeat.o(7968);
    return true;
  }
  
  public final boolean aiz(String paramString)
  {
    AppMethodBeat.i(7967);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(7967);
      return false;
    }
    boolean bool = u.x(paramString, "weixin://readershare/");
    AppMethodBeat.o(7967);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.t
 * JD-Core Version:    0.7.0.1
 */