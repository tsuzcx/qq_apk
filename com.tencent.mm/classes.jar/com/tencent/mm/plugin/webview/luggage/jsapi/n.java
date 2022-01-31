package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.e.a;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

public class n
  extends ax<com.tencent.mm.plugin.webview.luggage.e>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(a<com.tencent.mm.plugin.webview.luggage.e>.a parama)
  {
    y.i("MicroMsg.JsApiGetBrandWCPayRequest", "invokeInOwn");
    MMActivity localMMActivity = (MMActivity)((com.tencent.mm.plugin.webview.luggage.e)parama.big).mContext;
    g localg = new g(parama.bih.bhk);
    parama = new n.1(this, parama);
    h.a(localMMActivity, localg, hashCode() & 0xFFFF, parama);
  }
  
  public final String name()
  {
    return "getBrandWCPayRequest";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.n
 * JD-Core Version:    0.7.0.1
 */