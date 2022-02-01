package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class ax<T extends a>
  extends bq<T>
{
  private static TrustManager DRu;
  
  static
  {
    AppMethodBeat.i(207916);
    DRu = new X509TrustManager()
    {
      public final void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
      {
        AppMethodBeat.i(207911);
        ad.i("MicroMsg.JsApiRequest", "checkClientTrusted");
        AppMethodBeat.o(207911);
      }
      
      public final void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
      {
        AppMethodBeat.i(207912);
        ad.i("MicroMsg.JsApiRequest", "checkServerTrusted");
        AppMethodBeat.o(207912);
      }
      
      public final X509Certificate[] getAcceptedIssuers()
      {
        return new X509Certificate[0];
      }
    };
    AppMethodBeat.o(207916);
  }
  
  private static SSLContext aHd(String paramString)
  {
    AppMethodBeat.i(207914);
    try
    {
      paramString = SSLContext.getInstance(paramString);
      AppMethodBeat.o(207914);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(207914);
    }
    return null;
  }
  
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(b<T>.a paramb)
  {
    AppMethodBeat.i(207913);
    h.LTJ.aR(new ax.1(this, paramb));
    AppMethodBeat.o(207913);
  }
  
  public final int ccO()
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