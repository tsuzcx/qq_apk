package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.e.a;
import com.tencent.luggage.e.n;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.webview.luggage.d.b;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public class e
  extends aw<n>
{
  public final void a(Context paramContext, String paramString, aw.a parama)
  {
    y.i("MicroMsg.JsApiCancelDownloadTask", "invokeInMM");
    paramContext = b.tJ(paramString);
    if (paramContext == null)
    {
      parama.e("fail", null);
      return;
    }
    long l = paramContext.optLong("download_id");
    if (l <= 0L)
    {
      y.e("MicroMsg.JsApiCancelDownloadTask", "fail, invalid downloadId = " + l);
      parama.e("invalid_downloadid", null);
      return;
    }
    if (d.aFP().dc(l) > 0)
    {
      parama.e(null, null);
      return;
    }
    parama.e("fail", null);
  }
  
  public final int aGj()
  {
    return 1;
  }
  
  public final void b(a<n>.a parama) {}
  
  public final String name()
  {
    return "cancelDownloadTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.e
 * JD-Core Version:    0.7.0.1
 */