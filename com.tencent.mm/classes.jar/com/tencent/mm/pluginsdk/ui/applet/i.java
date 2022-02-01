package com.tencent.mm.pluginsdk.ui.applet;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.b.e;
import com.tencent.mm.av.t;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import d.v;
import java.io.Closeable;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnection;", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpClientFactory$ImageHttpUrlConnection;", "url", "", "forceNormal", "", "connectionListener", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListener;", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListener;)V", "mConnection", "Ljava/net/HttpURLConnection;", "mConnectionListener", "requestImageType", "", "closeInputStream", "", "inputStream", "Ljava/io/InputStream;", "disconnect", "forceWebp", "getDataResponse", "Lcom/tencent/mm/modelimage/loader/model/Response;", "getInputStream", "getResponseCode", "newConnection", "onRequest", "onResultError", "responseCode", "onResultSuccess", "response", "Companion", "plugin-biz_release"})
public final class i
  implements h.b
{
  public static final i.a FnL;
  private final j FnI;
  private final boolean FnJ;
  private int FnK = -1;
  private HttpURLConnection mConnection;
  private String url;
  
  static
  {
    AppMethodBeat.i(124876);
    FnL = new i.a((byte)0);
    AppMethodBeat.o(124876);
  }
  
  public i(String paramString, boolean paramBoolean, j paramj)
  {
    this.url = paramString;
    this.FnJ = paramBoolean;
    this.FnI = paramj;
  }
  
  public final void P(InputStream paramInputStream)
  {
    AppMethodBeat.i(124871);
    j localj = this.FnI;
    if (localj != null) {
      localj.fgi();
    }
    bu.d((Closeable)paramInputStream);
    paramInputStream = this.FnI;
    if (paramInputStream != null)
    {
      paramInputStream.fgj();
      AppMethodBeat.o(124871);
      return;
    }
    AppMethodBeat.o(124871);
  }
  
  public final com.tencent.mm.av.a.d.b Q(InputStream paramInputStream)
  {
    Object localObject3 = null;
    AppMethodBeat.i(124872);
    Object localObject1 = this.mConnection;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((HttpURLConnection)localObject1).getContentType();
      String str = this.url;
      localObject2 = this.mConnection;
      if (localObject2 == null) {
        break label191;
      }
      localObject2 = Integer.valueOf(((HttpURLConnection)localObject2).getContentLength());
      label49:
      ae.d("MicroMsg.BizImageHttpUrlConnection", "alvinluo getDataResponse contentType: %s, url: %s, contentLength: %s", new Object[] { localObject1, str, localObject2 });
      localObject1 = this.FnI;
      if (localObject1 != null) {
        ((j)localObject1).fgg();
      }
      localObject1 = paramInputStream;
      if (paramInputStream == null)
      {
        paramInputStream = this.mConnection;
        if (paramInputStream == null) {
          break label197;
        }
        localObject1 = paramInputStream.getInputStream();
      }
      label109:
      localObject1 = e.s((InputStream)localObject1);
      localObject2 = this.mConnection;
      paramInputStream = localObject3;
      if (localObject2 != null) {
        paramInputStream = ((HttpURLConnection)localObject2).getContentType();
      }
      paramInputStream = new com.tencent.mm.av.a.d.b((byte[])localObject1, paramInputStream, (byte)0);
      localObject1 = this.mConnection;
      if (localObject1 == null) {
        break label202;
      }
    }
    label191:
    label197:
    label202:
    for (int i = ((HttpURLConnection)localObject1).getContentLength();; i = 0)
    {
      paramInputStream.pM(i);
      localObject1 = this.FnI;
      if (localObject1 != null) {
        ((j)localObject1).fgh();
      }
      AppMethodBeat.o(124872);
      return paramInputStream;
      localObject1 = null;
      break;
      localObject2 = null;
      break label49;
      localObject1 = null;
      break label109;
    }
  }
  
  public final void Zw(int paramInt)
  {
    AppMethodBeat.i(124875);
    j localj = this.FnI;
    if (localj != null)
    {
      localj.Zw(paramInt);
      AppMethodBeat.o(124875);
      return;
    }
    AppMethodBeat.o(124875);
  }
  
  public final void b(com.tencent.mm.av.a.d.b paramb)
  {
    AppMethodBeat.i(124874);
    p.h(paramb, "response");
    j localj = this.FnI;
    if (localj != null)
    {
      localj.b(paramb);
      AppMethodBeat.o(124874);
      return;
    }
    AppMethodBeat.o(124874);
  }
  
  public final void disconnect()
  {
    AppMethodBeat.i(124873);
    try
    {
      Object localObject = this.mConnection;
      if (localObject != null)
      {
        localObject = ((HttpURLConnection)localObject).getInputStream();
        if (localObject != null) {
          ((InputStream)localObject).close();
        }
      }
      localObject = this.mConnection;
      if (localObject != null) {
        ((HttpURLConnection)localObject).disconnect();
      }
      localObject = this.FnI;
      if (localObject != null)
      {
        ((j)localObject).fgk();
        AppMethodBeat.o(124873);
        return;
      }
      AppMethodBeat.o(124873);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(124873);
    }
  }
  
  public final HttpURLConnection fga()
  {
    AppMethodBeat.i(124868);
    Object localObject1 = (CharSequence)this.url;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(124868);
      return null;
    }
    String str = this.url;
    if (this.FnJ)
    {
      localObject1 = this.url;
      if (localObject1 != null) {
        break label165;
      }
    }
    label165:
    Object localObject2;
    for (localObject1 = null;; localObject1 = com.tencent.mm.api.b.l((String)localObject2, false))
    {
      this.url = ((String)localObject1);
      localObject1 = this.FnI;
      if (localObject1 != null) {
        ((j)localObject1).eh(str, this.url);
      }
      if (this.FnJ)
      {
        localObject1 = this.FnI;
        if (localObject1 != null) {
          ((j)localObject1).fgb();
        }
      }
      localObject1 = this.FnI;
      if (localObject1 != null) {
        ((j)localObject1).fgc();
      }
      localObject1 = new URL(this.url).openConnection();
      if (localObject1 != null) {
        break;
      }
      localObject1 = new v("null cannot be cast to non-null type java.net.HttpURLConnection");
      AppMethodBeat.o(124868);
      throw ((Throwable)localObject1);
      localObject2 = g.FnF;
      localObject2 = Uri.parse((String)localObject1);
      p.g(localObject2, "Uri.parse(url)");
      localObject2 = g.c((Uri)localObject2, "tp");
      ae.d("MicroMsg.BizImageHttpUrlConnection", "alvinluo forceWebp url: %s, temp: %s", new Object[] { localObject1, localObject2 });
    }
    this.mConnection = ((HttpURLConnection)localObject1);
    localObject1 = this.mConnection;
    if (localObject1 != null) {
      ((HttpURLConnection)localObject1).setConnectTimeout(15000);
    }
    localObject1 = this.mConnection;
    if (localObject1 != null) {
      ((HttpURLConnection)localObject1).setReadTimeout(20000);
    }
    if ((!this.FnJ) && (com.tencent.mm.api.b.eC(this.url)))
    {
      ae.v("MicroMsg.BizImageHttpUrlConnection", "alvinluo BizImage get WxPic");
      this.FnK = 1;
      localObject1 = this.mConnection;
      if (localObject1 != null) {
        ((HttpURLConnection)localObject1).addRequestProperty("Accept", "image/wxpic");
      }
    }
    for (;;)
    {
      localObject1 = this.FnI;
      if (localObject1 != null) {
        ((j)localObject1).fgd();
      }
      localObject1 = this.mConnection;
      AppMethodBeat.o(124868);
      return localObject1;
      if (com.tencent.mm.api.b.eA(this.url))
      {
        ae.v("MicroMsg.BizImageHttpUrlConnection", "alvinluo BizImage get Webp");
        this.FnK = 2;
        localObject1 = this.mConnection;
        if (localObject1 != null) {
          ((HttpURLConnection)localObject1).setRequestProperty("Referer", t.pG(d.FFH));
        }
      }
      else
      {
        ae.v("MicroMsg.BizImageHttpUrlConnection", "alvinluo BizImage get jpeg");
        this.FnK = 0;
      }
    }
  }
  
  public final InputStream getInputStream()
  {
    AppMethodBeat.i(124870);
    Object localObject = this.mConnection;
    if (localObject != null)
    {
      localObject = ((HttpURLConnection)localObject).getInputStream();
      AppMethodBeat.o(124870);
      return localObject;
    }
    AppMethodBeat.o(124870);
    return null;
  }
  
  public final int getResponseCode()
  {
    AppMethodBeat.i(124869);
    Object localObject = this.FnI;
    if (localObject != null) {
      ((j)localObject).bf(this.FnK, this.FnJ);
    }
    localObject = this.FnI;
    if (localObject != null) {
      ((j)localObject).fge();
    }
    localObject = this.mConnection;
    if (localObject != null) {}
    for (int i = ((HttpURLConnection)localObject).getResponseCode();; i = -1)
    {
      localObject = this.FnI;
      if (localObject != null) {
        ((j)localObject).fgf();
      }
      AppMethodBeat.o(124869);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.i
 * JD-Core Version:    0.7.0.1
 */