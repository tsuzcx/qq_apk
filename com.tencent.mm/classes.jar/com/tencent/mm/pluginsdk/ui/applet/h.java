package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.InputStream;
import java.net.HttpURLConnection;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpClientFactory;", "", "()V", "TAG", "", "httpURLConnectionGet", "Lcom/tencent/mm/modelimage/loader/model/Response;", "url", "forceNormal", "", "connectionListener", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListener;", "onCreateConnection", "Lkotlin/Function1;", "Ljava/net/HttpURLConnection;", "Lkotlin/ParameterName;", "name", "conn", "", "receiveHeaders", "", "", "headers", "shouldCheckNoCache", "HttpUrlConnectionHelper", "ImageHttpUrlConnection", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h Ybr;
  
  static
  {
    AppMethodBeat.i(124867);
    Ybr = new h();
    AppMethodBeat.o(124867);
  }
  
  public static b a(String paramString, boolean paramBoolean, j paramj)
  {
    AppMethodBeat.i(124866);
    s.u(paramString, "url");
    paramString = b(paramString, paramBoolean, paramj);
    AppMethodBeat.o(124866);
    return paramString;
  }
  
  private static b b(String paramString, boolean paramBoolean, j paramj)
  {
    AppMethodBeat.i(245251);
    s.u(paramString, "url");
    Object localObject = a.Ybs;
    paramString = a.c(paramString, paramBoolean, paramj);
    try
    {
      paramString.iKZ();
      int i = paramString.getResponseCode();
      paramj = paramString.getInputStream();
      if (i >= 300)
      {
        paramString.aa(paramj);
        paramString.disconnect();
        Log.w("MicroMsg.BizImageHttpClientFactory", "httpURLConnectionGet responseCode: %d", new Object[] { Integer.valueOf(i) });
        paramString.awn(i);
        AppMethodBeat.o(245251);
        return null;
      }
      localObject = paramString.ab(paramj);
      paramString.aa(paramj);
      paramString.disconnect();
      paramString.a((b)localObject);
      AppMethodBeat.o(245251);
      return localObject;
    }
    catch (Exception paramj)
    {
      Log.printErrStackTrace("MicroMsg.BizImageHttpClientFactory", (Throwable)paramj, "alvinluo httpURLConnectionGet exception: ", new Object[0]);
      paramString.awn(-1);
      AppMethodBeat.o(245251);
    }
    return null;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpClientFactory$HttpUrlConnectionHelper;", "", "()V", "createBizImageHttpUrlConnection", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpClientFactory$ImageHttpUrlConnection;", "url", "", "forceNormal", "", "connectionListener", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListener;", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static final a Ybs;
    
    static
    {
      AppMethodBeat.i(124865);
      Ybs = new a();
      AppMethodBeat.o(124865);
    }
    
    public static h.b c(String paramString, boolean paramBoolean, j paramj)
    {
      AppMethodBeat.i(124864);
      paramString = (h.b)new i(paramString, paramBoolean, paramj);
      AppMethodBeat.o(124864);
      return paramString;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpClientFactory$ImageHttpUrlConnection;", "", "closeInputStream", "", "inputStream", "Ljava/io/InputStream;", "disconnect", "getDataResponse", "Lcom/tencent/mm/modelimage/loader/model/Response;", "getInputStream", "getResponseCode", "", "newConnection", "Ljava/net/HttpURLConnection;", "onResultError", "responseCode", "onResultSuccess", "response", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(b paramb);
    
    public abstract void aa(InputStream paramInputStream);
    
    public abstract b ab(InputStream paramInputStream);
    
    public abstract void awn(int paramInt);
    
    public abstract void disconnect();
    
    public abstract InputStream getInputStream();
    
    public abstract int getResponseCode();
    
    public abstract HttpURLConnection iKZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.h
 * JD-Core Version:    0.7.0.1
 */