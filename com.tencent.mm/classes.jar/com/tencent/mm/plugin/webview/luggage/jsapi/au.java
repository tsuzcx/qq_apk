package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.o.7;
import com.tencent.mm.plugin.downloader.model.o.8;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class au
  extends bv<s>
{
  public final void a(Context paramContext, String paramString, final bv.a parama)
  {
    AppMethodBeat.i(78593);
    long l;
    try
    {
      paramString = new JSONObject(paramString);
      l = paramString.optLong("download_id");
      if (l <= 0L)
      {
        Log.e("MicroMsg.JsApiPauseDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(l)));
        parama.j("invalid_downloadid", null);
        AppMethodBeat.o(78593);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      Log.e("MicroMsg.JsApiPauseDownloadTask", "paras data error: " + paramContext.getMessage());
      parama.j("fail", null);
      AppMethodBeat.o(78593);
      return;
    }
    a locala = d.la(l);
    if (locala == null)
    {
      parama.j(null, null);
      AppMethodBeat.o(78593);
      return;
    }
    int j = paramString.optInt("scene", 1000);
    int k = paramString.optInt("uiarea");
    int m = paramString.optInt("notice_id");
    int n = paramString.optInt("ssid");
    if (paramString.optInt("ignoreNetwork", 0) == 1) {}
    for (int i = 1;; i = 0)
    {
      locala.field_scene = j;
      locala.field_uiarea = k;
      locala.field_noticeId = m;
      locala.field_ssid = n;
      locala.field_downloadInWifi = false;
      d.e(locala);
      paramString = new o.a()
      {
        public final void j(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(296071);
          parama.j(paramAnonymousString, paramAnonymousJSONObject);
          AppMethodBeat.o(296071);
        }
      };
      if (!f.duv().kT(l)) {
        break label374;
      }
      if (!NetStatusUtil.isWifi(paramContext)) {
        break;
      }
      paramString.j(null, null);
      AppMethodBeat.o(78593);
      return;
    }
    if (d.la(l) == null)
    {
      paramString.j(null, null);
      AppMethodBeat.o(78593);
      return;
    }
    if ((i != 0) && (((com.tencent.mm.game.report.a.b)h.ax(com.tencent.mm.game.report.a.b.class)).a(c.a.yGQ, false))) {}
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        parama = new JSONObject();
        ((com.tencent.mm.plugin.downloader_app.api.b)h.ax(com.tencent.mm.plugin.downloader_app.api.b.class)).a(paramContext, new o.7(l, paramString), new o.8(l, paramString, parama));
        AppMethodBeat.o(78593);
        return;
      }
      paramString.j(null, null);
      AppMethodBeat.o(78593);
      return;
      label374:
      paramString.j("fail", null);
      AppMethodBeat.o(78593);
      return;
    }
  }
  
  public final void b(com.tencent.luggage.d.b<s>.a paramb) {}
  
  public final int dgI()
  {
    return 2;
  }
  
  public final String name()
  {
    return "pauseDownloadTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.au
 * JD-Core Version:    0.7.0.1
 */