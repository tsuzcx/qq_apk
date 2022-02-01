package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpClientFactory;", "", "()V", "TAG", "", "httpURLConnectionGet", "Lcom/tencent/mm/modelimage/loader/model/Response;", "url", "forceNormal", "", "connectionListener", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListener;", "receiveHeaders", "Lkotlin/Function1;", "", "", "Lkotlin/ParameterName;", "name", "headers", "", "shouldCheckNoCache", "HttpUrlConnectionHelper", "ImageHttpUrlConnection", "plugin-biz_release"})
public final class h
{
  public static final h Rfk;
  
  static
  {
    AppMethodBeat.i(124867);
    Rfk = new h();
    AppMethodBeat.o(124867);
  }
  
  public static com.tencent.mm.ay.a.d.b a(String paramString, boolean paramBoolean, j paramj)
  {
    AppMethodBeat.i(124866);
    p.k(paramString, "url");
    paramString = a(paramString, paramBoolean, paramj, null);
    AppMethodBeat.o(124866);
    return paramString;
  }
  
  public static com.tencent.mm.ay.a.d.b a(String paramString, boolean paramBoolean, j paramj, kotlin.g.a.b<? super Map<String, ? extends List<String>>, x> paramb)
  {
    AppMethodBeat.i(208476);
    p.k(paramString, "url");
    Object localObject = a.Rfl;
    paramString = a.b(paramString, paramBoolean, paramj);
    try
    {
      localObject = paramString.hkh();
      int i = paramString.getResponseCode();
      paramj = paramString.getInputStream();
      if (i >= 300)
      {
        paramString.M(paramj);
        paramString.disconnect();
        Log.w("MicroMsg.BizImageHttpClientFactory", "httpURLConnectionGet responseCode: %d", new Object[] { Integer.valueOf(i) });
        paramString.aqj(i);
        AppMethodBeat.o(208476);
        return null;
      }
      if ((localObject != null) && (paramb != null))
      {
        localObject = ((HttpURLConnection)localObject).getHeaderFields();
        p.j(localObject, "connection.headerFields");
        paramb.invoke(localObject);
      }
      paramb = paramString.N(paramj);
      paramString.M(paramj);
      paramString.disconnect();
      paramString.b(paramb);
      AppMethodBeat.o(208476);
      return paramb;
    }
    catch (Exception paramj)
    {
      Log.printErrStackTrace("MicroMsg.BizImageHttpClientFactory", (Throwable)paramj, "alvinluo httpURLConnectionGet exception: ", new Object[0]);
      paramString.aqj(-1);
      AppMethodBeat.o(208476);
    }
    return null;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpClientFactory$HttpUrlConnectionHelper;", "", "()V", "createBizImageHttpUrlConnection", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpClientFactory$ImageHttpUrlConnection;", "url", "", "forceNormal", "", "connectionListener", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListener;", "plugin-biz_release"})
  public static final class a
  {
    public static final a Rfl;
    
    static
    {
      AppMethodBeat.i(124865);
      Rfl = new a();
      AppMethodBeat.o(124865);
    }
    
    public static h.b b(String paramString, boolean paramBoolean, j paramj)
    {
      AppMethodBeat.i(124864);
      paramString = (h.b)new i(paramString, paramBoolean, paramj);
      AppMethodBeat.o(124864);
      return paramString;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpClientFactory$ImageHttpUrlConnection;", "", "closeInputStream", "", "inputStream", "Ljava/io/InputStream;", "disconnect", "getDataResponse", "Lcom/tencent/mm/modelimage/loader/model/Response;", "getInputStream", "getResponseCode", "", "newConnection", "Ljava/net/HttpURLConnection;", "onResultError", "responseCode", "onResultSuccess", "response", "plugin-biz_release"})
  public static abstract interface b
  {
    public abstract void M(InputStream paramInputStream);
    
    public abstract com.tencent.mm.ay.a.d.b N(InputStream paramInputStream);
    
    public abstract void aqj(int paramInt);
    
    public abstract void b(com.tencent.mm.ay.a.d.b paramb);
    
    public abstract void disconnect();
    
    public abstract InputStream getInputStream();
    
    public abstract int getResponseCode();
    
    public abstract HttpURLConnection hkh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.h
 * JD-Core Version:    0.7.0.1
 */