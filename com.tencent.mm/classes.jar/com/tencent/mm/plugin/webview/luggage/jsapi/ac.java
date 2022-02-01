package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class ac
  extends br<s>
{
  public final void a(Context paramContext, String paramString, final br.a parama)
  {
    AppMethodBeat.i(78567);
    Log.i("MicroMsg.JsApiInstallDownloadTask", "invokeInOwn");
    long l;
    try
    {
      paramContext = new JSONObject(paramString);
      l = paramContext.optLong("download_id");
      if (l <= 0L)
      {
        Log.i("MicroMsg.JsApiInstallDownloadTask", "data is null");
        parama.i("fail_invalid_data", null);
        AppMethodBeat.o(78567);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      Log.e("MicroMsg.JsApiInstallDownloadTask", "paras data error: " + paramContext.getMessage());
      parama.i("fail", null);
      AppMethodBeat.o(78567);
      return;
    }
    paramString = f.cPZ().Ix(l);
    if (paramString.status == -1)
    {
      Log.e("MicroMsg.JsApiInstallDownloadTask", "installDownloadTask fail, apilevel not supported");
      parama.i("fail", null);
      AppMethodBeat.o(78567);
      return;
    }
    if (paramString.status != 3)
    {
      Log.e("MicroMsg.JsApiInstallDownloadTask", "installDownloadTask fail, invalid status = " + paramString.status);
      parama.i("fail", null);
      AppMethodBeat.o(78567);
      return;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.IF(l);
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
      public final void ia(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(78566);
        if (paramAnonymousBoolean)
        {
          parama.i(null, null);
          AppMethodBeat.o(78566);
          return;
        }
        parama.i("fail", null);
        AppMethodBeat.o(78566);
      }
    });
    AppMethodBeat.o(78567);
  }
  
  public final void b(b<s>.a paramb) {}
  
  public final int cDj()
  {
    return 1;
  }
  
  public final String name()
  {
    return "installDownloadTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ac
 * JD-Core Version:    0.7.0.1
 */