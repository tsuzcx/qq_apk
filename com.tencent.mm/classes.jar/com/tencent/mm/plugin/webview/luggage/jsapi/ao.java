package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public class ao
  extends bn<n>
{
  public final void a(Context paramContext, String paramString, bn.a parama)
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
    paramString = d.oq(l);
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
    if (f.bQt().oi(l))
    {
      parama.f(null, null);
      AppMethodBeat.o(78593);
      return;
    }
    parama.f("fail", null);
    AppMethodBeat.o(78593);
  }
  
  public final void b(a<n>.a parama) {}
  
  public final int bQV()
  {
    return 1;
  }
  
  public final String name()
  {
    return "pauseDownloadTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ao
 * JD-Core Version:    0.7.0.1
 */