package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public class ab
  extends bn<n>
{
  public final void a(Context paramContext, String paramString, final bn.a parama)
  {
    AppMethodBeat.i(78567);
    ad.i("MicroMsg.JsApiInstallDownloadTask", "invokeInOwn");
    long l;
    try
    {
      paramContext = new JSONObject(paramString);
      l = paramContext.optLong("download_id");
      if (l <= 0L)
      {
        ad.i("MicroMsg.JsApiInstallDownloadTask", "data is null");
        parama.f("fail_invalid_data", null);
        AppMethodBeat.o(78567);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      ad.e("MicroMsg.JsApiInstallDownloadTask", "paras data error: " + paramContext.getMessage());
      parama.f("fail", null);
      AppMethodBeat.o(78567);
      return;
    }
    paramString = f.bQt().oh(l);
    if (paramString.status == -1)
    {
      ad.e("MicroMsg.JsApiInstallDownloadTask", "installDownloadTask fail, apilevel not supported");
      parama.f("fail", null);
      AppMethodBeat.o(78567);
      return;
    }
    if (paramString.status != 3)
    {
      ad.e("MicroMsg.JsApiInstallDownloadTask", "installDownloadTask fail, invalid status = " + paramString.status);
      parama.f("fail", null);
      AppMethodBeat.o(78567);
      return;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.oq(l);
    if (locala != null)
    {
      int i = paramContext.optInt("scene");
      int j = paramContext.optInt("uiarea");
      int k = paramContext.optInt("notice_id");
      int m = paramContext.optInt("ssid");
      locala.field_scene = i;
      locala.field_uiarea = j;
      locala.field_noticeId = k;
      locala.field_ssid = m;
      d.e(locala);
    }
    com.tencent.mm.plugin.downloader.i.a.a(paramString.id, false, new com.tencent.mm.pluginsdk.permission.a()
    {
      public final void fO(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(78566);
        if (paramAnonymousBoolean)
        {
          parama.f(null, null);
          AppMethodBeat.o(78566);
          return;
        }
        parama.f("fail", null);
        AppMethodBeat.o(78566);
      }
    });
    AppMethodBeat.o(78567);
  }
  
  public final void b(com.tencent.luggage.d.a<n>.a parama) {}
  
  public final int bQV()
  {
    return 1;
  }
  
  public final String name()
  {
    return "installDownloadTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ab
 * JD-Core Version:    0.7.0.1
 */