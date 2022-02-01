package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.base.k;
import org.json.JSONException;
import org.json.JSONObject;

public class be
  extends bv<s>
{
  private void a(long paramLong, bv.a parama)
  {
    AppMethodBeat.i(78616);
    com.tencent.mm.plugin.downloader.f.a locala = com.tencent.mm.plugin.downloader.model.d.la(paramLong);
    if ((locala != null) && (locala.field_fromDownloadApp))
    {
      locala.field_fromDownloadApp = false;
      locala.field_showNotification = true;
      com.tencent.mm.plugin.downloader.model.d.e(locala);
    }
    if (f.duv().kU(paramLong)) {
      parama.j(null, null);
    }
    for (;;)
    {
      com.tencent.mm.modelstat.d.d(10, "LuggageGameWebViewUI_resumeDownloadTask", hashCode());
      AppMethodBeat.o(78616);
      return;
      parama.j("fail", null);
    }
  }
  
  public final void a(Context paramContext, final String paramString, final bv.a parama)
  {
    AppMethodBeat.i(78615);
    Log.i("MicroMsg.JsApiResumeDownloadTask", "invokeInMM");
    if (com.tencent.mm.plugin.webview.luggage.c.a.iuX())
    {
      Log.i("MicroMsg.JsApiResumeDownloadTask", "resumeDownloadTask isTeenMode and ignore");
      com.tencent.mm.plugin.webview.luggage.c.a.kQ(paramContext);
      parama.j("cancel", null);
      AppMethodBeat.o(78615);
      return;
    }
    final long l;
    try
    {
      paramString = new JSONObject(paramString);
      l = paramString.optLong("download_id");
      if (l <= 0L)
      {
        Log.e("MicroMsg.JsApiResumeDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(l)));
        parama.j("invalid_downloadid", null);
        AppMethodBeat.o(78615);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      Log.e("MicroMsg.JsApiResumeDownloadTask", "paras data error: " + paramContext.getMessage());
      parama.j("fail", null);
      AppMethodBeat.o(78615);
      return;
    }
    int i = paramString.optInt("scene", 1000);
    int j = paramString.optInt("uiarea");
    int k = paramString.optInt("notice_id");
    int m = paramString.optInt("ssid");
    int n = paramString.optInt("download_type", 1);
    if (paramString.optInt("ignoreNetwork", 0) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      com.tencent.mm.plugin.downloader.f.a locala = com.tencent.mm.plugin.downloader.model.d.la(l);
      locala.field_scene = i;
      locala.field_uiarea = j;
      locala.field_noticeId = k;
      locala.field_ssid = m;
      locala.field_downloadType = n;
      com.tencent.mm.plugin.downloader.model.d.e(locala);
      if (locala != null)
      {
        com.tencent.mm.plugin.downloader.e.b localb = new com.tencent.mm.plugin.downloader.e.b();
        localb.k(locala);
        localb.costTime = 0L;
        com.tencent.mm.plugin.downloader.e.a.a(10, localb);
      }
      boolean bool2 = paramString.optBoolean("use_downloader_widget", false);
      boolean bool3 = paramString.optBoolean("download_in_wifi", false);
      if (!bool2) {
        break;
      }
      o.a(paramContext, l, bool3, bool1, new o.a()
      {
        public final void j(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(78614);
          parama.j(paramAnonymousString, paramAnonymousJSONObject);
          AppMethodBeat.o(78614);
        }
      });
      com.tencent.mm.modelstat.d.d(10, "LuggageGameWebViewUI_resumeDownloadTask", hashCode());
      AppMethodBeat.o(78615);
      return;
    }
    if (NetStatusUtil.isWifi(paramContext))
    {
      a(l, parama);
      AppMethodBeat.o(78615);
      return;
    }
    k.a(paramContext, paramContext.getString(c.i.webview_download_ui_download_not_in_wifi_tips), paramContext.getString(c.i.webview_download_ui_download_not_in_wifi_title), paramContext.getString(c.i.webview_download_ui_btn_state_to_download), paramContext.getString(c.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(78612);
        be.a(be.this, l, this.Ive);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(78612);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(78613);
        paramAnonymousDialogInterface.dismiss();
        parama.j("fail_network_not_wifi", null);
        AppMethodBeat.o(78613);
      }
    }, c.c.wechat_green);
    AppMethodBeat.o(78615);
  }
  
  public final void b(com.tencent.luggage.d.b<s>.a paramb) {}
  
  public final int dgI()
  {
    return 2;
  }
  
  public final String name()
  {
    return "resumeDownloadTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.be
 * JD-Core Version:    0.7.0.1
 */