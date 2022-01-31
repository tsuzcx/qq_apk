package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends bi<e>
{
  private void a(JSONObject paramJSONObject, bh.a parama)
  {
    AppMethodBeat.i(6271);
    gx localgx = new gx();
    String str1 = paramJSONObject.optString("task_name");
    String str2 = paramJSONObject.optString("task_url");
    String str3 = paramJSONObject.optString("alternative_url");
    long l = paramJSONObject.optLong("task_size");
    String str4 = paramJSONObject.optString("file_md5");
    String str8 = paramJSONObject.optString("extInfo");
    String str5 = paramJSONObject.optString("fileType");
    String str6 = paramJSONObject.optString("appid");
    String str7 = paramJSONObject.optString("package_name");
    int i = paramJSONObject.optInt("scene", 1000);
    int j = paramJSONObject.optInt("downloader_type", 1);
    int k = paramJSONObject.optInt("download_type", 1);
    int m = paramJSONObject.optInt("ssid");
    int n = paramJSONObject.optInt("uiarea");
    int i1 = paramJSONObject.optInt("notice_id");
    localgx.cvS.url = str2;
    localgx.cvS.cqq = str4;
    localgx.cvS.extInfo = str8;
    localgx.cvS.appId = str6;
    localgx.cvS.scene = i;
    com.tencent.mm.sdk.b.a.ymk.l(localgx);
    paramJSONObject = new g.a();
    paramJSONObject.JJ(str2);
    paramJSONObject.JK(str3);
    paramJSONObject.iR(l);
    paramJSONObject.JL(str1);
    paramJSONObject.JM(str4);
    paramJSONObject.setAppId(str6);
    paramJSONObject.dC(str7);
    paramJSONObject.gr(true);
    paramJSONObject.tV(bo.getInt(str5, 1));
    paramJSONObject.setScene(i);
    paramJSONObject.tZ(k);
    paramJSONObject.tW(m);
    paramJSONObject.tX(n);
    paramJSONObject.tY(i1);
    paramJSONObject = paramJSONObject.kYR;
    if (j == 1) {}
    for (l = com.tencent.mm.plugin.downloader.model.f.bjl().b(paramJSONObject);; l = com.tencent.mm.plugin.downloader.model.f.bjl().a(paramJSONObject))
    {
      d.b(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
      if (l > 0L) {
        break;
      }
      parama.c("fail", null);
      AppMethodBeat.o(6271);
      return;
    }
    try
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("download_id", l);
      parama.c(null, paramJSONObject);
      AppMethodBeat.o(6271);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      parama.c(null, null);
      AppMethodBeat.o(6271);
    }
  }
  
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(6270);
    String str1;
    long l;
    try
    {
      paramString = new JSONObject(paramString);
      str1 = paramString.optString("task_url");
      l = paramString.optLong("task_size");
      if (bo.isNullOrNil(str1))
      {
        ab.e("MicroMsg.JsApiAddDownloadTaskStraight", "url is null");
        parama.c("fail", null);
        AppMethodBeat.o(6270);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      ab.e("MicroMsg.JsApiAddDownloadTaskStraight", "paras data error: " + paramContext.getMessage());
      parama.c("fail", null);
      AppMethodBeat.o(6270);
      return;
    }
    String str2 = paramString.optString("appid");
    int i = paramString.optInt("scene", 1000);
    int j = paramString.optInt("download_type", 1);
    int k = paramString.optInt("ssid");
    int m = paramString.optInt("uiarea");
    int n = paramString.optInt("notice_id");
    com.tencent.mm.plugin.downloader.f.a.a(9, new com.tencent.mm.plugin.downloader.f.b(str2, i, paramString.optString("extInfo"), m, k, n, j));
    String str3 = paramString.optString("currentUrl");
    if (paramString.optBoolean("use_downloader_widget", false))
    {
      o.a(paramContext, com.tencent.mm.plugin.downloader_app.b.a.Y(paramString), new a.6(this, parama));
      d.b(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
      AppMethodBeat.o(6270);
      return;
    }
    if (!at.isNetworkConnected(paramContext))
    {
      parama.c("fail_network_not_connected", null);
      com.tencent.mm.plugin.webview.luggage.c.b.runOnUiThread(new a.1(this, paramContext));
      ab.i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, network not ready");
      AppMethodBeat.o(6270);
      return;
    }
    if (!com.tencent.mm.compatible.util.f.Mi())
    {
      parama.c("sdcard_not_ready", null);
      com.tencent.mm.plugin.webview.luggage.c.b.runOnUiThread(new a.2(this, paramContext));
      ab.i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, sdcard not ready");
      AppMethodBeat.o(6270);
      return;
    }
    if ((l > 0L) && (!com.tencent.mm.compatible.util.f.gc(l)) && (!com.tencent.mm.plugin.downloader.model.h.iS(l)))
    {
      parama.c("has_not_enough_space", null);
      com.tencent.mm.plugin.webview.luggage.c.b.runOnUiThread(new a.3(this, paramContext));
      ab.i("MicroMsg.JsApiAddDownloadTaskStraight", "fail, not enough space, require size = ".concat(String.valueOf(l)));
      AppMethodBeat.o(6270);
      return;
    }
    if (at.isWifi(paramContext))
    {
      a(paramString, parama);
      AppMethodBeat.o(6270);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(14217, new Object[] { str2, Integer.valueOf(4), str3, str1, Integer.valueOf(3) });
    com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131305852), paramContext.getString(2131305853), paramContext.getString(2131305847), paramContext.getString(2131296888), false, new a.4(this, str2, str3, str1, paramContext, paramString, parama), new a.5(this, str2, str3, str1, parama), 2131690701);
    AppMethodBeat.o(6270);
  }
  
  public final void b(com.tencent.luggage.d.a<e>.a parama) {}
  
  public final int bjL()
  {
    return 2;
  }
  
  public final String name()
  {
    return "addDownloadTaskStraight";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.a
 * JD-Core Version:    0.7.0.1
 */