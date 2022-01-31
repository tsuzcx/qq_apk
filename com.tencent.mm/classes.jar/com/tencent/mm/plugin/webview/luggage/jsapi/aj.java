package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.e.n;
import com.tencent.mm.game.report.api.b;
import com.tencent.mm.plugin.ak.a.a;
import com.tencent.mm.plugin.ak.a.b;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import org.json.JSONException;
import org.json.JSONObject;

public class aj
  extends aw<n>
{
  private void a(long paramLong, aw.a parama)
  {
    com.tencent.mm.modelstat.d.b(10, "LuggageGameWebViewUI_resumeDownloadTask", hashCode());
    if (com.tencent.mm.plugin.downloader.model.d.aFP().df(paramLong))
    {
      parama.e(null, null);
      return;
    }
    parama.e("fail", null);
  }
  
  public final void a(Context paramContext, String paramString, aw.a parama)
  {
    y.i("MicroMsg.JsApiResumeDownloadTask", "invokeInMM");
    long l;
    try
    {
      paramString = new JSONObject(paramString);
      l = paramString.optLong("download_id");
      if (l <= 0L)
      {
        y.e("MicroMsg.JsApiResumeDownloadTask", "fail, invalid downloadId = " + l);
        parama.e("invalid_downloadid", null);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      y.e("MicroMsg.JsApiResumeDownloadTask", "paras data error: " + paramContext.getMessage());
      parama.e("fail", null);
      return;
    }
    paramString = c.dk(l);
    if (paramString != null) {
      b.dCw.a(paramString.field_appId, paramString.field_scene, 10, paramString.field_startSize, paramString.field_downloadedSize - paramString.field_startSize, paramString.field_totalSize, paramString.field_downloadUrl, paramString.field_errCode, paramString.field_downloaderType, paramString.field_channelId, (System.currentTimeMillis() - paramString.field_startTime) / 1000L, paramString.field_startState, paramString.field_downloadId, paramString.field_extInfo);
    }
    if (aq.isWifi(paramContext))
    {
      a(l, parama);
      return;
    }
    h.a(paramContext, paramContext.getString(a.b.webview_download_ui_download_not_in_wifi_tips), paramContext.getString(a.b.webview_download_ui_download_not_in_wifi_title), paramContext.getString(a.b.webview_download_ui_btn_state_to_download), paramContext.getString(a.b.app_cancel), false, new aj.1(this, l, parama), new aj.2(this, parama), a.a.wechat_green);
  }
  
  public final int aGj()
  {
    return 2;
  }
  
  public final void b(com.tencent.luggage.e.a<n>.a parama) {}
  
  public final String name()
  {
    return "resumeDownloadTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.aj
 * JD-Core Version:    0.7.0.1
 */