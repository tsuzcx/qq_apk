package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.e.n;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.game.report.api.b;
import com.tencent.mm.h.a.gt;
import com.tencent.mm.plugin.downloader.model.e.a;
import com.tencent.mm.plugin.webview.luggage.d.c;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends aw<n>
{
  private void a(JSONObject paramJSONObject, aw.a parama)
  {
    gt localgt = new gt();
    String str2 = paramJSONObject.optString("task_name");
    String str3 = paramJSONObject.optString("task_url");
    String str4 = paramJSONObject.optString("alternative_url");
    long l = paramJSONObject.optLong("task_size");
    String str5 = paramJSONObject.optString("file_md5");
    String str8 = paramJSONObject.optString("extInfo");
    String str6 = paramJSONObject.optString("fileType");
    String str1 = paramJSONObject.optString("appid");
    String str7 = paramJSONObject.optString("packageName");
    int i = paramJSONObject.optInt("scene", 1000);
    int j = paramJSONObject.optInt("downloader_type", 1);
    localgt.bOB.url = str3;
    localgt.bOB.bIW = str5;
    localgt.bOB.extInfo = str8;
    localgt.bOB.appId = str1;
    localgt.bOB.scene = i;
    com.tencent.mm.sdk.b.a.udP.m(localgt);
    paramJSONObject = new e.a();
    paramJSONObject.zN(str3);
    paramJSONObject.zO(str4);
    paramJSONObject.dp(l);
    paramJSONObject.zP(str2);
    paramJSONObject.zQ(str5);
    paramJSONObject.setAppId(str1);
    paramJSONObject.cq(str7);
    paramJSONObject.eO(true);
    paramJSONObject.pE(bk.getInt(str6, 1));
    paramJSONObject.setScene(i);
    paramJSONObject = paramJSONObject.iPG;
    if (j == 1) {}
    for (l = com.tencent.mm.plugin.downloader.model.d.aFP().b(paramJSONObject);; l = com.tencent.mm.plugin.downloader.model.d.aFP().a(paramJSONObject))
    {
      com.tencent.mm.modelstat.d.b(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
      b.dCw.a(str1, i, 9, l, "", null);
      if (l > 0L) {
        break;
      }
      parama.e("fail", null);
      return;
    }
    try
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("download_id", l);
      parama.e(null, paramJSONObject);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      parama.e(null, null);
    }
  }
  
  public final void a(Context paramContext, String paramString, aw.a parama)
  {
    long l;
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.optString("task_url");
      l = paramString.optLong("task_size");
      if (bk.bl(str))
      {
        y.e("MicroMsg.JsApiAddDownloadTaskStraight", "url is null");
        parama.e("fail", null);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      y.e("MicroMsg.JsApiAddDownloadTaskStraight", "paras data error: " + paramContext.getMessage());
      parama.e("fail", null);
      return;
    }
    if (!aq.isNetworkConnected(paramContext))
    {
      parama.e("fail_network_not_connected", null);
      c.runOnUiThread(new a.1(this, paramContext));
      y.i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, network not ready");
      return;
    }
    if (!f.zF())
    {
      parama.e("sdcard_not_ready", null);
      c.runOnUiThread(new a.2(this, paramContext));
      y.i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, sdcard not ready");
      return;
    }
    if ((l > 0L) && (!f.bs(l)))
    {
      parama.e("has_not_enough_space", null);
      c.runOnUiThread(new a.3(this, paramContext));
      y.i("MicroMsg.JsApiAddDownloadTaskStraight", "fail, not enough space, require size = " + l);
      return;
    }
    if (aq.isWifi(paramContext))
    {
      a(paramString, parama);
      return;
    }
    h.a(paramContext, paramContext.getString(R.l.webview_download_ui_download_not_in_wifi_tips), paramContext.getString(R.l.webview_download_ui_download_not_in_wifi_title), paramContext.getString(R.l.webview_download_ui_btn_state_to_download), paramContext.getString(R.l.app_cancel), false, new a.4(this, paramContext, paramString, parama), new a.5(this, parama), R.e.wechat_green);
  }
  
  public final int aGj()
  {
    return 2;
  }
  
  public final void b(com.tencent.luggage.e.a<n>.a parama) {}
  
  public final String name()
  {
    return "addDownloadTaskStraight";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.a
 * JD-Core Version:    0.7.0.1
 */