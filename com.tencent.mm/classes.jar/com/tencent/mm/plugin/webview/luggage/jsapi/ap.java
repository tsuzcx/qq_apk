package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public class ap
  extends bq<s>
{
  public final void a(Context paramContext, String paramString, bq.a parama)
  {
    AppMethodBeat.i(78593);
    long l;
    try
    {
      paramContext = new JSONObject(paramString);
      l = paramContext.optLong("download_id");
      if (l <= 0L)
      {
        ad.e("MicroMsg.JsApiPauseDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(l)));
        parama.f("invalid_downloadid", null);
        AppMethodBeat.o(78593);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      ad.e("MicroMsg.JsApiPauseDownloadTask", "paras data error: " + paramContext.getMessage());
      parama.f("fail", null);
      AppMethodBeat.o(78593);
      return;
    }
    paramString = d.ua(l);
    if (paramString == null)
    {
      parama.f(null, null);
      AppMethodBeat.o(78593);
      return;
    }
    int i = paramContext.optInt("scene", 1000);
    int j = paramContext.optInt("uiarea");
    int k = paramContext.optInt("notice_id");
    int m = paramContext.optInt("ssid");
    paramString.field_scene = i;
    paramString.field_uiarea = j;
    paramString.field_noticeId = k;
    paramString.field_ssid = m;
    paramString.field_downloadInWifi = false;
    d.e(paramString);
    if (f.ccl().tT(l))
    {
      parama.f(null, null);
      AppMethodBeat.o(78593);
      return;
    }
    parama.f("fail", null);
    AppMethodBeat.o(78593);
  }
  
  public final void b(b<s>.a paramb) {}
  
  public final int ccO()
  {
    return 1;
  }
  
  public final String name()
  {
    return "pauseDownloadTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ap
 * JD-Core Version:    0.7.0.1
 */