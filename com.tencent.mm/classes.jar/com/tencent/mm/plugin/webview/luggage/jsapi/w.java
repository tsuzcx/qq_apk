package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.e.n;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public class w
  extends aw<n>
{
  public final void a(Context paramContext, String paramString, aw.a parama)
  {
    y.i("MicroMsg.JsApiInstallDownloadTask", "invokeInOwn");
    long l;
    try
    {
      paramContext = new JSONObject(paramString);
      l = paramContext.optLong("download_id");
      if (l <= 0L)
      {
        y.i("MicroMsg.JsApiInstallDownloadTask", "data is null");
        parama.e("fail_invalid_data", null);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      y.e("MicroMsg.JsApiInstallDownloadTask", "paras data error: " + paramContext.getMessage());
      parama.e("fail", null);
      return;
    }
    paramContext = d.aFP().dd(l);
    if (paramContext.status == -1)
    {
      y.e("MicroMsg.JsApiInstallDownloadTask", "installDownloadTask fail, apilevel not supported");
      parama.e("fail", null);
      return;
    }
    if (paramContext.status != 3)
    {
      y.e("MicroMsg.JsApiInstallDownloadTask", "installDownloadTask fail, invalid status = " + paramContext.status);
      parama.e("fail", null);
      return;
    }
    if (com.tencent.mm.plugin.downloader.h.a.m(paramContext.id, false))
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
    return "installDownloadTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.w
 * JD-Core Version:    0.7.0.1
 */