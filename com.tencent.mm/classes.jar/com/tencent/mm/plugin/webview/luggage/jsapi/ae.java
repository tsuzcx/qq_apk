package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.e.n;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public class ae
  extends aw<n>
{
  public final void a(Context paramContext, String paramString, aw.a parama)
  {
    long l;
    try
    {
      paramContext = new JSONObject(paramString);
      l = paramContext.optLong("download_id");
      if (l <= 0L)
      {
        y.e("MicroMsg.JsApiPauseDownloadTask", "fail, invalid downloadId = " + l);
        parama.e("invalid_downloadid", null);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      y.e("MicroMsg.JsApiPauseDownloadTask", "paras data error: " + paramContext.getMessage());
      parama.e("fail", null);
      return;
    }
    paramContext = c.dk(l);
    if (paramContext == null)
    {
      parama.e(null, null);
      return;
    }
    if (paramContext.field_downloadInWifi)
    {
      paramContext.field_downloadInWifi = false;
      c.d(paramContext);
    }
    if (d.aFP().de(l))
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
  
  public final void b(com.tencent.luggage.e.a<n>.a parama) {}
  
  public final String name()
  {
    return "pauseDownloadTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ae
 * JD-Core Version:    0.7.0.1
 */