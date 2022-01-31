package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import org.json.JSONException;
import org.json.JSONObject;

public class at
  extends bh<n>
{
  private void a(long paramLong, bh.a parama)
  {
    AppMethodBeat.i(6365);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.iJ(paramLong);
    if ((locala != null) && (locala.field_fromDownloadApp))
    {
      locala.field_fromDownloadApp = false;
      locala.field_showNotification = true;
      com.tencent.mm.plugin.downloader.model.d.e(locala);
    }
    if (f.bjl().iC(paramLong)) {
      parama.c(null, null);
    }
    for (;;)
    {
      com.tencent.mm.modelstat.d.b(10, "LuggageGameWebViewUI_resumeDownloadTask", hashCode());
      AppMethodBeat.o(6365);
      return;
      parama.c("fail", null);
    }
  }
  
  public final void a(Context paramContext, String paramString, final bh.a parama)
  {
    AppMethodBeat.i(6364);
    ab.i("MicroMsg.JsApiResumeDownloadTask", "invokeInMM");
    long l;
    try
    {
      paramString = new JSONObject(paramString);
      l = paramString.optLong("download_id");
      if (l <= 0L)
      {
        ab.e("MicroMsg.JsApiResumeDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(l)));
        parama.c("invalid_downloadid", null);
        AppMethodBeat.o(6364);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      ab.e("MicroMsg.JsApiResumeDownloadTask", "paras data error: " + paramContext.getMessage());
      parama.c("fail", null);
      AppMethodBeat.o(6364);
      return;
    }
    int i = paramString.optInt("scene");
    int j = paramString.optInt("uiarea");
    int k = paramString.optInt("notice_id");
    int m = paramString.optInt("ssid");
    int n = paramString.optInt("download_type", 1);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.iJ(l);
    locala.field_scene = i;
    locala.field_uiarea = j;
    locala.field_noticeId = k;
    locala.field_ssid = m;
    locala.field_downloadType = n;
    com.tencent.mm.plugin.downloader.model.d.e(locala);
    if (locala != null)
    {
      b localb = new b();
      localb.i(locala);
      localb.iHc = 0L;
      com.tencent.mm.plugin.downloader.f.a.a(10, localb);
    }
    boolean bool1 = paramString.optBoolean("use_downloader_widget", false);
    boolean bool2 = paramString.optBoolean("download_in_wifi", false);
    if (bool1)
    {
      o.a(paramContext, l, bool2, new o.a()
      {
        public final void c(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(6363);
          parama.c(paramAnonymousString, paramAnonymousJSONObject);
          AppMethodBeat.o(6363);
        }
      });
      com.tencent.mm.modelstat.d.b(10, "LuggageGameWebViewUI_resumeDownloadTask", hashCode());
      AppMethodBeat.o(6364);
      return;
    }
    if (com.tencent.mm.sdk.platformtools.at.isWifi(paramContext))
    {
      a(l, parama);
      AppMethodBeat.o(6364);
      return;
    }
    h.a(paramContext, paramContext.getString(2131305852), paramContext.getString(2131305853), paramContext.getString(2131305847), paramContext.getString(2131296888), false, new at.1(this, paramString, l, parama), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(6362);
        paramAnonymousDialogInterface.dismiss();
        parama.c("fail_network_not_wifi", null);
        AppMethodBeat.o(6362);
      }
    }, 2131690701);
    AppMethodBeat.o(6364);
  }
  
  public final void b(com.tencent.luggage.d.a<n>.a parama) {}
  
  public final int bjL()
  {
    return 2;
  }
  
  public final String name()
  {
    return "resumeDownloadTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.at
 * JD-Core Version:    0.7.0.1
 */