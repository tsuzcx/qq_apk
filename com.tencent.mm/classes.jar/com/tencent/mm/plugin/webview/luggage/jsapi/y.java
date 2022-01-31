package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public class y
  extends bh<n>
{
  public final void a(Context paramContext, String paramString, final bh.a parama)
  {
    AppMethodBeat.i(6319);
    ab.i("MicroMsg.JsApiInstallDownloadTask", "invokeInOwn");
    long l;
    try
    {
      paramContext = new JSONObject(paramString);
      l = paramContext.optLong("download_id");
      if (l <= 0L)
      {
        ab.i("MicroMsg.JsApiInstallDownloadTask", "data is null");
        parama.c("fail_invalid_data", null);
        AppMethodBeat.o(6319);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      ab.e("MicroMsg.JsApiInstallDownloadTask", "paras data error: " + paramContext.getMessage());
      parama.c("fail", null);
      AppMethodBeat.o(6319);
      return;
    }
    paramString = f.bjl().iA(l);
    if (paramString.status == -1)
    {
      ab.e("MicroMsg.JsApiInstallDownloadTask", "installDownloadTask fail, apilevel not supported");
      parama.c("fail", null);
      AppMethodBeat.o(6319);
      return;
    }
    if (paramString.status != 3)
    {
      ab.e("MicroMsg.JsApiInstallDownloadTask", "installDownloadTask fail, invalid status = " + paramString.status);
      parama.c("fail", null);
      AppMethodBeat.o(6319);
      return;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.iJ(l);
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
      public final void eb(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(6318);
        if (paramAnonymousBoolean)
        {
          parama.c(null, null);
          AppMethodBeat.o(6318);
          return;
        }
        parama.c("fail", null);
        AppMethodBeat.o(6318);
      }
    });
    AppMethodBeat.o(6319);
  }
  
  public final void b(com.tencent.luggage.d.a<n>.a parama) {}
  
  public final int bjL()
  {
    return 1;
  }
  
  public final String name()
  {
    return "installDownloadTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.y
 * JD-Core Version:    0.7.0.1
 */