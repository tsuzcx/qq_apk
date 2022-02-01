package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.InputStream;
import java.net.HttpURLConnection;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpClientFactory;", "", "()V", "TAG", "", "httpURLConnectionGet", "Lcom/tencent/mm/modelimage/loader/model/Response;", "url", "forceNormal", "", "connectionListener", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListener;", "shouldCheckNoCache", "HttpUrlConnectionHelper", "ImageHttpUrlConnection", "plugin-biz_release"})
public final class h
{
  public static final h Kew;
  
  static
  {
    AppMethodBeat.i(124867);
    Kew = new h();
    AppMethodBeat.o(124867);
  }
  
  public static b a(String paramString, boolean paramBoolean, j paramj)
  {
    AppMethodBeat.i(124866);
    p.h(paramString, "url");
    Object localObject = a.Kex;
    paramString = a.b(paramString, paramBoolean, paramj);
    try
    {
      paramString.gpj();
      int i = paramString.getResponseCode();
      paramj = paramString.getInputStream();
      if (i >= 300)
      {
        paramString.O(paramj);
        paramString.disconnect();
        Log.w("MicroMsg.BizImageHttpClientFactory", "httpURLConnectionGet responseCode: %d", new Object[] { Integer.valueOf(i) });
        paramString.aih(i);
        AppMethodBeat.o(124866);
        return null;
      }
      localObject = paramString.P(paramj);
      paramString.O(paramj);
      paramString.disconnect();
      paramString.b((b)localObject);
      AppMethodBeat.o(124866);
      return localObject;
    }
    catch (Exception paramj)
    {
      Log.printErrStackTrace("MicroMsg.BizImageHttpClientFactory", (Throwable)paramj, "alvinluo httpURLConnectionGet exception: ", new Object[0]);
      paramString.aih(-1);
      AppMethodBeat.o(124866);
    }
    return null;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpClientFactory$HttpUrlConnectionHelper;", "", "()V", "createBizImageHttpUrlConnection", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpClientFactory$ImageHttpUrlConnection;", "url", "", "forceNormal", "", "connectionListener", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListener;", "plugin-biz_release"})
  public static final class a
  {
    public static final a Kex;
    
    static
    {
      AppMethodBeat.i(124865);
      Kex = new a();
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpClientFactory$ImageHttpUrlConnection;", "", "closeInputStream", "", "inputStream", "Ljava/io/InputStream;", "disconnect", "getDataResponse", "Lcom/tencent/mm/modelimage/loader/model/Response;", "getInputStream", "getResponseCode", "", "newConnection", "Ljava/net/HttpURLConnection;", "onResultError", "responseCode", "onResultSuccess", "response", "plugin-biz_release"})
  public static abstract interface b
  {
    public abstract void O(InputStream paramInputStream);
    
    public abstract b P(InputStream paramInputStream);
    
    public abstract void aih(int paramInt);
    
    public abstract void b(b paramb);
    
    public abstract void disconnect();
    
    public abstract InputStream getInputStream();
    
    public abstract int getResponseCode();
    
    public abstract HttpURLConnection gpj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.h
 * JD-Core Version:    0.7.0.1
 */