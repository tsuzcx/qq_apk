package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class g$89
  implements Runnable
{
  g$89(g paramg, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public final void run()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("free_wifi_jsapi_param_type", this.rAm);
    localIntent.putExtra("free_wifi_ap_key", this.rAn);
    localIntent.putExtra("free_wifi_jsapi_param_username", this.egy);
    localIntent.putExtra("free_wifi_sessionkey", this.rAo);
    localIntent.putExtra("free_wifi_source", 4);
    localIntent.addFlags(67108864);
    if ((!bk.bl(this.rAm)) && (this.rAm.equalsIgnoreCase("2")) && (!bk.bl(this.rAn)))
    {
      Uri localUri = Uri.parse(this.rAn);
      String str1 = localUri.getHost();
      String str2 = localUri.getQuery();
      if ((!bk.bl(str1)) && ("connectToFreeWifi".equals(str1)) && (!bk.bl(str2)) && (str2.startsWith("apKey=")))
      {
        str1 = localUri.getQueryParameter("apKey");
        y.i("[MicroMsg.FreeWifi.MsgHandler]", "apKey value = %s", new Object[] { str1 });
        str2 = localUri.getQueryParameter("ticket");
        if ((!bk.bl(str1)) && (str1.length() < 1024))
        {
          localIntent.putExtra("free_wifi_schema_uri", localUri.toString());
          localIntent.putExtra("free_wifi_ap_key", str1);
          localIntent.putExtra("free_wifi_source", 5);
          localIntent.putExtra("free_wifi_threeone_startup_type", 4);
          if (!bk.bl(str2)) {
            localIntent.putExtra("free_wifi_schema_ticket", str2);
          }
        }
      }
    }
    d.b(g.i(this.rzi), "freewifi", ".ui.FreeWifiEntryUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.89
 * JD-Core Version:    0.7.0.1
 */