package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.km;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends bw<g>
{
  private void a(JSONObject paramJSONObject, bv.a parama)
  {
    AppMethodBeat.i(78511);
    km localkm = new km();
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
    localkm.hMf.url = str2;
    localkm.hMf.md5 = str4;
    localkm.hMf.extInfo = str8;
    localkm.hMf.appId = str6;
    localkm.hMf.scene = i;
    localkm.publish();
    paramJSONObject = new g.a();
    paramJSONObject.amR(str2);
    paramJSONObject.amS(str3);
    paramJSONObject.setFileSize(l);
    paramJSONObject.amT(str1);
    paramJSONObject.setFileMD5(str4);
    paramJSONObject.setAppId(str6);
    paramJSONObject.setPackageName(str7);
    paramJSONObject.nA(true);
    paramJSONObject.JA(Util.getInt(str5, 1));
    paramJSONObject.setScene(i);
    paramJSONObject.JE(k);
    paramJSONObject.JB(m);
    paramJSONObject.JC(n);
    paramJSONObject.JD(i1);
    paramJSONObject = paramJSONObject.xoe;
    if (j == 1) {}
    for (l = f.duv().b(paramJSONObject);; l = f.duv().a(paramJSONObject))
    {
      d.d(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
      if (l > 0L) {
        break;
      }
      parama.j("fail", null);
      AppMethodBeat.o(78511);
      return;
    }
    try
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("download_id", l);
      parama.j(null, paramJSONObject);
      AppMethodBeat.o(78511);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      parama.j(null, null);
      AppMethodBeat.o(78511);
    }
  }
  
  public final void a(final Context paramContext, final String paramString, final bv.a parama)
  {
    AppMethodBeat.i(78510);
    Log.i("MicroMsg.JsApiAddDownloadTaskStraight", "invokeInMM");
    if (com.tencent.mm.plugin.webview.luggage.c.a.iuX())
    {
      Log.i("MicroMsg.JsApiAddDownloadTaskStraight", "addDownloadTaskStraight isTeenMode and ignore");
      com.tencent.mm.plugin.webview.luggage.c.a.kQ(paramContext);
      parama.j("cancel", null);
      AppMethodBeat.o(78510);
      return;
    }
    final String str1;
    long l;
    try
    {
      paramString = new JSONObject(paramString);
      str1 = paramString.optString("task_url");
      l = paramString.optLong("task_size");
      if (Util.isNullOrNil(str1))
      {
        Log.e("MicroMsg.JsApiAddDownloadTaskStraight", "url is null");
        parama.j("fail", null);
        AppMethodBeat.o(78510);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      Log.e("MicroMsg.JsApiAddDownloadTaskStraight", "paras data error: " + paramContext.getMessage());
      parama.j("fail", null);
      AppMethodBeat.o(78510);
      return;
    }
    final String str2 = paramString.optString("appid");
    int i = paramString.optInt("scene", 1000);
    int j = paramString.optInt("download_type", 1);
    int k = paramString.optInt("ssid");
    int m = paramString.optInt("uiarea");
    int n = paramString.optInt("notice_id");
    com.tencent.mm.plugin.downloader.e.a.a(9, new com.tencent.mm.plugin.downloader.e.b(str2, i, paramString.optString("extInfo"), m, k, n, j));
    final String str3 = paramString.optString("currentUrl");
    if (paramString.optBoolean("use_downloader_widget", false))
    {
      o.a(paramContext, com.tencent.mm.plugin.downloader_app.a.a.aZ(paramString), new o.a()
      {
        public final void j(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(78509);
          parama.j(paramAnonymousString, paramAnonymousJSONObject);
          AppMethodBeat.o(78509);
        }
      });
      d.d(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
      AppMethodBeat.o(78510);
      return;
    }
    if (!NetStatusUtil.isNetworkConnected(paramContext))
    {
      parama.j("fail_network_not_connected", null);
      c.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78504);
          Toast.makeText(paramContext, paramContext.getString(c.i.game_download_network_unavailable), 0).show();
          AppMethodBeat.o(78504);
        }
      });
      Log.i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, network not ready");
      AppMethodBeat.o(78510);
      return;
    }
    if (!e.aPU())
    {
      parama.j("sdcard_not_ready", null);
      c.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78505);
          Toast.makeText(paramContext, paramContext.getString(c.i.game_download_sdcard_unavailable), 0).show();
          AppMethodBeat.o(78505);
        }
      });
      Log.i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, sdcard not ready");
      AppMethodBeat.o(78510);
      return;
    }
    if ((l > 0L) && (!com.tencent.mm.plugin.downloader.model.h.lj(l)) && (!com.tencent.mm.plugin.downloader.model.h.li(l)))
    {
      parama.j("has_not_enough_space", null);
      c.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78506);
          Toast.makeText(paramContext, paramContext.getString(c.i.game_download_not_enough_space), 0).show();
          AppMethodBeat.o(78506);
        }
      });
      Log.i("MicroMsg.JsApiAddDownloadTaskStraight", "fail, not enough space, require size = ".concat(String.valueOf(l)));
      AppMethodBeat.o(78510);
      return;
    }
    if (NetStatusUtil.isWifi(paramContext))
    {
      a(paramString, parama);
      AppMethodBeat.o(78510);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(14217, new Object[] { str2, Integer.valueOf(4), str3, str1, Integer.valueOf(3) });
    k.a(paramContext, paramContext.getString(c.i.webview_download_ui_download_not_in_wifi_tips), paramContext.getString(c.i.webview_download_ui_download_not_in_wifi_title), paramContext.getString(c.i.webview_download_ui_btn_state_to_download), paramContext.getString(c.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(78507);
        com.tencent.mm.plugin.report.service.h.OAn.b(14217, new Object[] { str2, Integer.valueOf(5), str3, str1, Integer.valueOf(3) });
        a.a(a.this, paramString, parama);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(78507);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(78508);
        com.tencent.mm.plugin.report.service.h.OAn.b(14217, new Object[] { str2, Integer.valueOf(6), str3, str1, Integer.valueOf(3) });
        paramAnonymousDialogInterface.dismiss();
        parama.j("network_not_wifi", null);
        AppMethodBeat.o(78508);
      }
    }, c.c.wechat_green);
    AppMethodBeat.o(78510);
  }
  
  public final void b(com.tencent.luggage.d.b<g>.a paramb) {}
  
  public final int dgI()
  {
    return 2;
  }
  
  public final String name()
  {
    return "addDownloadTaskStraight";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.a
 * JD-Core Version:    0.7.0.1
 */