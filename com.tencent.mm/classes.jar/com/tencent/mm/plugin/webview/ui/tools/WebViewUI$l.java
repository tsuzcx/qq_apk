package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewUI$l
  implements b
{
  private WebViewUI$l(WebViewUI paramWebViewUI) {}
  
  public final boolean Tq(String paramString)
  {
    paramString = Uri.parse(paramString);
    String str1 = paramString.getQueryParameter("apKey");
    y.i("MicroMsg.WebViewUI", "apKey value = %s", new Object[] { str1 });
    String str2 = paramString.getQueryParameter("ticket");
    if (!bk.bl(str1))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("free_wifi_schema_uri", paramString.toString());
      localIntent.putExtra("free_wifi_ap_key", str1);
      localIntent.putExtra("free_wifi_source", 5);
      if (!bk.bl(str2)) {
        localIntent.putExtra("free_wifi_schema_ticket", str2);
      }
      localIntent.addFlags(67108864);
      d.b(ae.getContext(), "freewifi", ".ui.FreeWifiEntryUI", localIntent);
    }
    return true;
  }
  
  public final boolean Ty(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    return s.n(paramString, "weixin://connectToFreeWifi/");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.l
 * JD-Core Version:    0.7.0.1
 */