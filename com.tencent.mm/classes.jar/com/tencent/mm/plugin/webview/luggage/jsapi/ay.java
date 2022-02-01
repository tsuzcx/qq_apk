package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class ay<T extends a>
  extends br<T>
{
  private static TrustManager IWq;
  
  static
  {
    AppMethodBeat.i(210954);
    IWq = new X509TrustManager()
    {
      public final void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
      {
        AppMethodBeat.i(210951);
        Log.i("MicroMsg.JsApiRequest", "checkClientTrusted");
        AppMethodBeat.o(210951);
      }
      
      public final void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
      {
        AppMethodBeat.i(210952);
        Log.i("MicroMsg.JsApiRequest", "checkServerTrusted");
        AppMethodBeat.o(210952);
      }
      
      public final X509Certificate[] getAcceptedIssuers()
      {
        return new X509Certificate[0];
      }
    };
    AppMethodBeat.o(210954);
  }
  
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b<T>.a paramb)
  {
    AppMethodBeat.i(210953);
    h.RTc.aX(new ay.1(this, paramb));
    AppMethodBeat.o(210953);
  }
  
  public final int dTs()
  {
    return 0;
  }
  
  public final String name()
  {
    return "request";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ay
 * JD-Core Version:    0.7.0.1
 */