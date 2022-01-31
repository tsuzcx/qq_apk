package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class g$72
  implements Runnable
{
  g$72(g paramg, String paramString1, String paramString2, boolean paramBoolean, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(154993);
    Intent localIntent = new Intent();
    localIntent.putExtra("free_wifi_ssid", this.mJG);
    localIntent.putExtra("free_wifi_source", 3);
    localIntent.putExtra("free_wifi_passowrd", this.vrc);
    localIntent.putExtra("free_wifi_hide_ssid", this.vrd);
    localIntent.putExtra("free_wifi_encrypt_type", this.vre);
    localIntent.addFlags(67108864);
    d.b(g.j(this.vqm), "freewifi", ".ui.FreeWifiEntryUI", localIntent);
    AppMethodBeat.o(154993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.72
 * JD-Core Version:    0.7.0.1
 */