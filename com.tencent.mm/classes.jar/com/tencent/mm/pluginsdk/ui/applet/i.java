package com.tencent.mm.pluginsdk.ui.applet;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.impr.e;
import com.tencent.mm.modelimage.u;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.Closeable;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnection;", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpClientFactory$ImageHttpUrlConnection;", "url", "", "forceNormal", "", "connectionListener", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListener;", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListener;)V", "mConnection", "Ljava/net/HttpURLConnection;", "mConnectionListener", "requestImageType", "", "closeInputStream", "", "inputStream", "Ljava/io/InputStream;", "disconnect", "forceWebp", "getDataResponse", "Lcom/tencent/mm/modelimage/loader/model/Response;", "getInputStream", "getResponseCode", "newConnection", "onRequest", "onResultError", "responseCode", "onResultSuccess", "response", "Companion", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements h.b
{
  public static final i.a Ybt;
  private final j Ybu;
  private final boolean Ybv;
  private int Ybw = -1;
  private HttpURLConnection mConnection;
  private String url;
  
  static
  {
    AppMethodBeat.i(124876);
    Ybt = new i.a((byte)0);
    AppMethodBeat.o(124876);
  }
  
  public i(String paramString, boolean paramBoolean, j paramj)
  {
    this.url = paramString;
    this.Ybv = paramBoolean;
    this.Ybu = paramj;
  }
  
  public final void a(com.tencent.mm.modelimage.loader.c.b paramb)
  {
    AppMethodBeat.i(124874);
    s.u(paramb, "response");
    j localj = this.Ybu;
    if (localj != null) {
      localj.a(paramb);
    }
    AppMethodBeat.o(124874);
  }
  
  public final void aa(InputStream paramInputStream)
  {
    AppMethodBeat.i(124871);
    j localj = this.Ybu;
    if (localj != null) {
      localj.iLh();
    }
    Util.qualityClose((Closeable)paramInputStream);
    paramInputStream = this.Ybu;
    if (paramInputStream != null) {
      paramInputStream.iLi();
    }
    AppMethodBeat.o(124871);
  }
  
  public final com.tencent.mm.modelimage.loader.c.b ab(InputStream paramInputStream)
  {
    Object localObject3 = null;
    AppMethodBeat.i(124872);
    Object localObject1 = this.mConnection;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      String str = this.url;
      localObject2 = this.mConnection;
      if (localObject2 != null) {
        break label171;
      }
      localObject2 = null;
      label39:
      Log.d("MicroMsg.BizImageHttpUrlConnection", "alvinluo getDataResponse contentType: %s, url: %s, contentLength: %s", new Object[] { localObject1, str, localObject2 });
      localObject1 = this.Ybu;
      if (localObject1 != null) {
        ((j)localObject1).iLf();
      }
      localObject1 = paramInputStream;
      if (paramInputStream == null)
      {
        paramInputStream = this.mConnection;
        if (paramInputStream != null) {
          break label184;
        }
        localObject1 = null;
      }
      label96:
      localObject1 = e.b((InputStream)localObject1, false);
      paramInputStream = this.mConnection;
      if (paramInputStream != null) {
        break label192;
      }
      paramInputStream = localObject3;
      label114:
      paramInputStream = new com.tencent.mm.modelimage.loader.c.b((byte[])localObject1, paramInputStream, (byte)0);
      localObject1 = this.mConnection;
      if (localObject1 != null) {
        break label200;
      }
    }
    label171:
    label184:
    label192:
    label200:
    for (int i = 0;; i = ((HttpURLConnection)localObject1).getContentLength())
    {
      paramInputStream.oKT = i;
      localObject1 = this.Ybu;
      if (localObject1 != null) {
        ((j)localObject1).iLg();
      }
      AppMethodBeat.o(124872);
      return paramInputStream;
      localObject1 = ((HttpURLConnection)localObject1).getContentType();
      break;
      localObject2 = Integer.valueOf(((HttpURLConnection)localObject2).getContentLength());
      break label39;
      localObject1 = paramInputStream.getInputStream();
      break label96;
      paramInputStream = paramInputStream.getContentType();
      break label114;
    }
  }
  
  public final void awn(int paramInt)
  {
    AppMethodBeat.i(124875);
    j localj = this.Ybu;
    if (localj != null) {
      localj.awn(paramInt);
    }
    AppMethodBeat.o(124875);
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
      localObject = this.Ybu;
      if (localObject != null)
      {
        ((j)localObject).iLj();
        AppMethodBeat.o(124873);
        return;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(124873);
    }
  }
  
  public final InputStream getInputStream()
  {
    AppMethodBeat.i(124870);
    Object localObject = this.mConnection;
    if (localObject == null)
    {
      AppMethodBeat.o(124870);
      return null;
    }
    localObject = ((HttpURLConnection)localObject).getInputStream();
    AppMethodBeat.o(124870);
    return localObject;
  }
  
  public final int getResponseCode()
  {
    AppMethodBeat.i(124869);
    Object localObject = this.Ybu;
    if (localObject != null) {
      ((j)localObject).ct(this.Ybw, this.Ybv);
    }
    localObject = this.Ybu;
    if (localObject != null) {
      ((j)localObject).iLd();
    }
    localObject = this.mConnection;
    if (localObject == null) {}
    for (int i = -1;; i = ((HttpURLConnection)localObject).getResponseCode())
    {
      localObject = this.Ybu;
      if (localObject != null) {
        ((j)localObject).iLe();
      }
      AppMethodBeat.o(124869);
      return i;
    }
  }
  
  public final HttpURLConnection iKZ()
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
    if (this.Ybv)
    {
      localObject1 = this.url;
      if (localObject1 != null) {
        break label165;
      }
    }
    label165:
    Object localObject2;
    for (localObject1 = null;; localObject1 = com.tencent.mm.api.b.o((String)localObject2, false))
    {
      this.url = ((String)localObject1);
      localObject1 = this.Ybu;
      if (localObject1 != null) {
        ((j)localObject1).fd(str, this.url);
      }
      if (this.Ybv)
      {
        localObject1 = this.Ybu;
        if (localObject1 != null) {
          ((j)localObject1).iLa();
        }
      }
      localObject1 = this.Ybu;
      if (localObject1 != null) {
        ((j)localObject1).iLb();
      }
      localObject1 = new URL(this.url).openConnection();
      if (localObject1 != null) {
        break;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
      AppMethodBeat.o(124868);
      throw ((Throwable)localObject1);
      localObject2 = g.Ybp;
      localObject2 = Uri.parse((String)localObject1);
      s.s(localObject2, "parse(url)");
      localObject2 = g.b((Uri)localObject2, "tp");
      Log.d("MicroMsg.BizImageHttpUrlConnection", "alvinluo forceWebp url: %s, temp: %s", new Object[] { localObject1, localObject2 });
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
    if ((!this.Ybv) && (com.tencent.mm.api.b.hC(this.url)))
    {
      Log.v("MicroMsg.BizImageHttpUrlConnection", "alvinluo BizImage get WxPic");
      this.Ybw = 1;
      localObject1 = this.mConnection;
      if (localObject1 != null) {
        ((HttpURLConnection)localObject1).addRequestProperty("Accept", "image/wxpic");
      }
    }
    for (;;)
    {
      localObject1 = this.Ybu;
      if (localObject1 != null) {
        ((j)localObject1).iLc();
      }
      localObject1 = this.mConnection;
      AppMethodBeat.o(124868);
      return localObject1;
      if (com.tencent.mm.api.b.hA(this.url))
      {
        Log.v("MicroMsg.BizImageHttpUrlConnection", "alvinluo BizImage get Webp");
        this.Ybw = 2;
        localObject1 = this.mConnection;
        if (localObject1 != null) {
          ((HttpURLConnection)localObject1).setRequestProperty("Referer", u.wz(d.Yxh));
        }
      }
      else
      {
        Log.v("MicroMsg.BizImageHttpUrlConnection", "alvinluo BizImage get jpeg");
        this.Ybw = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.i
 * JD-Core Version:    0.7.0.1
 */