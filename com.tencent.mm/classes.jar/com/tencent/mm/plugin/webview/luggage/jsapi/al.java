package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public class al
  extends bh<n>
{
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(6343);
    long l;
    try
    {
      paramContext = new JSONObject(paramString);
      l = paramContext.optLong("download_id");
      if (l <= 0L)
      {
        ab.e("MicroMsg.JsApiPauseDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(l)));
        parama.c("invalid_downloadid", null);
        AppMethodBeat.o(6343);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      ab.e("MicroMsg.JsApiPauseDownloadTask", "paras data error: " + paramContext.getMessage());
      parama.c("fail", null);
      AppMethodBeat.o(6343);
      return;
    }
    paramString = d.iJ(l);
    if (paramString == null)
    {
      parama.c(null, null);
      AppMethodBeat.o(6343);
      return;
    }
    int i = paramContext.optInt("scene");
    int j = paramContext.optInt("uiarea");
    int k = paramContext.optInt("notice_id");
    int m = paramContext.optInt("ssid");
    paramString.field_scene = i;
    paramString.field_uiarea = j;
    paramString.field_noticeId = k;
    paramString.field_ssid = m;
    paramString.field_downloadInWifi = false;
    d.e(paramString);
    if (f.bjl().iB(l))
    {
      parama.c(null, null);
      AppMethodBeat.o(6343);
      return;
    }
    parama.c("fail", null);
    AppMethodBeat.o(6343);
  }
  
  public final void b(a<n>.a parama) {}
  
  public final int bjL()
  {
    return 1;
  }
  
  public final String name()
  {
    return "pauseDownloadTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.al
 * JD-Core Version:    0.7.0.1
 */