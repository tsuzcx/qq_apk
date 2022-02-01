package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class ax<T extends a>
  extends bq<T>
{
  private static TrustManager Eju;
  
  static
  {
    AppMethodBeat.i(198096);
    Eju = new X509TrustManager()
    {
      public final void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
      {
        AppMethodBeat.i(198091);
        ae.i("MicroMsg.JsApiRequest", "checkClientTrusted");
        AppMethodBeat.o(198091);
      }
      
      public final void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
      {
        AppMethodBeat.i(198092);
        ae.i("MicroMsg.JsApiRequest", "checkServerTrusted");
        AppMethodBeat.o(198092);
      }
      
      public final X509Certificate[] getAcceptedIssuers()
      {
        return new X509Certificate[0];
      }
    };
    AppMethodBeat.o(198096);
  }
  
  private static SSLContext aIx(String paramString)
  {
    AppMethodBeat.i(198094);
    try
    {
      paramString = SSLContext.getInstance(paramString);
      AppMethodBeat.o(198094);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(198094);
    }
    return null;
  }
  
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(b<T>.a paramb)
  {
    AppMethodBeat.i(198093);
    h.MqF.aO(new ax.1(this, paramb));
    AppMethodBeat.o(198093);
  }
  
  public final int ced()
  {
    return 0;
  }
  
  public final String name()
  {
    return "request";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ax
 * JD-Core Version:    0.7.0.1
 */