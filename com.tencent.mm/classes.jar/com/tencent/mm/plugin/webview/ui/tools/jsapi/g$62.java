package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.mm.br.d;

final class g$62
  implements Runnable
{
  g$62(g paramg, String paramString1, String paramString2, boolean paramBoolean, int paramInt) {}
  
  public final void run()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("free_wifi_ssid", this.knT);
    localIntent.putExtra("free_wifi_source", 3);
    localIntent.putExtra("free_wifi_passowrd", this.rzX);
    localIntent.putExtra("free_wifi_hide_ssid", this.rzY);
    localIntent.putExtra("free_wifi_encrypt_type", this.rzZ);
    localIntent.addFlags(67108864);
    d.b(g.i(this.rzi), "freewifi", ".ui.FreeWifiEntryUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.62
 * JD-Core Version:    0.7.0.1
 */