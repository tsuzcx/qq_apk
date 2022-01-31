package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

final class WebViewUI$k
  implements b
{
  private WebViewUI$k(WebViewUI paramWebViewUI) {}
  
  public final boolean ait(String paramString)
  {
    AppMethodBeat.i(7950);
    paramString = Uri.parse(paramString);
    String str1 = paramString.getQueryParameter("apKey");
    ab.i("MicroMsg.WebViewUI", "apKey value = %s", new Object[] { str1 });
    String str2 = paramString.getQueryParameter("ticket");
    if (!bo.isNullOrNil(str1))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("free_wifi_schema_uri", paramString.toString());
      localIntent.putExtra("free_wifi_ap_key", str1);
      localIntent.putExtra("free_wifi_source", 5);
      if (!bo.isNullOrNil(str2)) {
        localIntent.putExtra("free_wifi_schema_ticket", str2);
      }
      localIntent.addFlags(67108864);
      d.b(ah.getContext(), "freewifi", ".ui.FreeWifiEntryUI", localIntent);
    }
    AppMethodBeat.o(7950);
    return true;
  }
  
  public final boolean aiz(String paramString)
  {
    AppMethodBeat.i(7949);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(7949);
      return false;
    }
    boolean bool = u.x(paramString, "weixin://connectToFreeWifi/");
    AppMethodBeat.o(7949);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.k
 * JD-Core Version:    0.7.0.1
 */