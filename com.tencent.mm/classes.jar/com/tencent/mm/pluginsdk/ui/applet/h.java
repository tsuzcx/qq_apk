package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.d.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.io.InputStream;
import java.net.HttpURLConnection;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpClientFactory;", "", "()V", "TAG", "", "httpURLConnectionGet", "Lcom/tencent/mm/modelimage/loader/model/Response;", "url", "forceNormal", "", "connectionListener", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListener;", "shouldCheckNoCache", "HttpUrlConnectionHelper", "ImageHttpUrlConnection", "plugin-biz_release"})
public final class h
{
  public static final h EVl;
  
  static
  {
    AppMethodBeat.i(124867);
    EVl = new h();
    AppMethodBeat.o(124867);
  }
  
  public static b a(String paramString, boolean paramBoolean, j paramj)
  {
    AppMethodBeat.i(124866);
    p.h(paramString, "url");
    Object localObject = a.EVm;
    paramString = a.b(paramString, paramBoolean, paramj);
    try
    {
      paramString.fcm();
      int i = paramString.getResponseCode();
      paramj = paramString.getInputStream();
      if (i >= 300)
      {
        paramString.P(paramj);
        paramString.disconnect();
        ad.w("MicroMsg.BizImageHttpClientFactory", "httpURLConnectionGet responseCode: %d", new Object[] { Integer.valueOf(i) });
        paramString.YQ(i);
        AppMethodBeat.o(124866);
        return null;
      }
      localObject = paramString.Q(paramj);
      paramString.P(paramj);
      paramString.disconnect();
      paramString.b((b)localObject);
      AppMethodBeat.o(124866);
      return localObject;
    }
    catch (Exception paramj)
    {
      ad.printErrStackTrace("MicroMsg.BizImageHttpClientFactory", (Throwable)paramj, "alvinluo httpURLConnectionGet exception: ", new Object[0]);
      paramString.YQ(-1);
      AppMethodBeat.o(124866);
    }
    return null;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpClientFactory$HttpUrlConnectionHelper;", "", "()V", "createBizImageHttpUrlConnection", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpClientFactory$ImageHttpUrlConnection;", "url", "", "forceNormal", "", "connectionListener", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListener;", "plugin-biz_release"})
  public static final class a
  {
    public static final a EVm;
    
    static
    {
      AppMethodBeat.i(124865);
      EVm = new a();
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpClientFactory$ImageHttpUrlConnection;", "", "closeInputStream", "", "inputStream", "Ljava/io/InputStream;", "disconnect", "getDataResponse", "Lcom/tencent/mm/modelimage/loader/model/Response;", "getInputStream", "getResponseCode", "", "newConnection", "Ljava/net/HttpURLConnection;", "onResultError", "responseCode", "onResultSuccess", "response", "plugin-biz_release"})
  public static abstract interface b
  {
    public abstract void P(InputStream paramInputStream);
    
    public abstract b Q(InputStream paramInputStream);
    
    public abstract void YQ(int paramInt);
    
    public abstract void b(b paramb);
    
    public abstract void disconnect();
    
    public abstract HttpURLConnection fcm();
    
    public abstract InputStream getInputStream();
    
    public abstract int getResponseCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.h
 * JD-Core Version:    0.7.0.1
 */