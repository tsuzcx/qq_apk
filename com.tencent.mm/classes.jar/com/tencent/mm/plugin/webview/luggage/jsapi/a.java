package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.hr;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends bo<com.tencent.mm.plugin.webview.luggage.f>
{
  private void a(JSONObject paramJSONObject, bn.a parama)
  {
    AppMethodBeat.i(78511);
    hr localhr = new hr();
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
    localhr.dlr.url = str2;
    localhr.dlr.md5 = str4;
    localhr.dlr.extInfo = str8;
    localhr.dlr.appId = str6;
    localhr.dlr.scene = i;
    com.tencent.mm.sdk.b.a.ESL.l(localhr);
    paramJSONObject = new g.a();
    paramJSONObject.Sr(str2);
    paramJSONObject.Ss(str3);
    paramJSONObject.oy(l);
    paramJSONObject.St(str1);
    paramJSONObject.Su(str4);
    paramJSONObject.setAppId(str6);
    paramJSONObject.eI(str7);
    paramJSONObject.jc(true);
    paramJSONObject.zO(bt.getInt(str5, 1));
    paramJSONObject.setScene(i);
    paramJSONObject.zS(k);
    paramJSONObject.zP(m);
    paramJSONObject.zQ(n);
    paramJSONObject.zR(i1);
    paramJSONObject = paramJSONObject.ofF;
    if (j == 1) {}
    for (l = com.tencent.mm.plugin.downloader.model.f.bQt().b(paramJSONObject);; l = com.tencent.mm.plugin.downloader.model.f.bQt().a(paramJSONObject))
    {
      d.c(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
      if (l > 0L) {
        break;
      }
      parama.f("fail", null);
      AppMethodBeat.o(78511);
      return;
    }
    try
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("download_id", l);
      parama.f(null, paramJSONObject);
      AppMethodBeat.o(78511);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      parama.f(null, null);
      AppMethodBeat.o(78511);
    }
  }
  
  public final void a(final Context paramContext, final String paramString, final bn.a parama)
  {
    AppMethodBeat.i(78510);
    ad.i("MicroMsg.JsApiAddDownloadTaskStraight", "invokeInMM");
    final String str1;
    long l;
    try
    {
      paramString = new JSONObject(paramString);
      str1 = paramString.optString("task_url");
      l = paramString.optLong("task_size");
      if (bt.isNullOrNil(str1))
      {
        ad.e("MicroMsg.JsApiAddDownloadTaskStraight", "url is null");
        parama.f("fail", null);
        AppMethodBeat.o(78510);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      ad.e("MicroMsg.JsApiAddDownloadTaskStraight", "paras data error: " + paramContext.getMessage());
      parama.f("fail", null);
      AppMethodBeat.o(78510);
      return;
    }
    final String str2 = paramString.optString("appid");
    int i = paramString.optInt("scene", 1000);
    int j = paramString.optInt("download_type", 1);
    int k = paramString.optInt("ssid");
    int m = paramString.optInt("uiarea");
    int n = paramString.optInt("notice_id");
    com.tencent.mm.plugin.downloader.f.a.a(9, new com.tencent.mm.plugin.downloader.f.b(str2, i, paramString.optString("extInfo"), m, k, n, j));
    final String str3 = paramString.optString("currentUrl");
    if (paramString.optBoolean("use_downloader_widget", false))
    {
      o.a(paramContext, com.tencent.mm.plugin.downloader_app.a.a.ao(paramString), new o.a()
      {
        public final void f(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(78509);
          parama.f(paramAnonymousString, paramAnonymousJSONObject);
          AppMethodBeat.o(78509);
        }
      });
      d.c(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
      AppMethodBeat.o(78510);
      return;
    }
    if (!ay.isNetworkConnected(paramContext))
    {
      parama.f("fail_network_not_connected", null);
      com.tencent.mm.plugin.webview.luggage.c.b.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78504);
          Toast.makeText(paramContext, paramContext.getString(2131759864), 0).show();
          AppMethodBeat.o(78504);
        }
      });
      ad.i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, network not ready");
      AppMethodBeat.o(78510);
      return;
    }
    if (!e.XG())
    {
      parama.f("sdcard_not_ready", null);
      com.tencent.mm.plugin.webview.luggage.c.b.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78505);
          Toast.makeText(paramContext, paramContext.getString(2131759868), 0).show();
          AppMethodBeat.o(78505);
        }
      });
      ad.i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, sdcard not ready");
      AppMethodBeat.o(78510);
      return;
    }
    if ((l > 0L) && (!com.tencent.mm.plugin.downloader.model.h.oA(l)) && (!com.tencent.mm.plugin.downloader.model.h.oz(l)))
    {
      parama.f("has_not_enough_space", null);
      com.tencent.mm.plugin.webview.luggage.c.b.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78506);
          Toast.makeText(paramContext, paramContext.getString(2131759865), 0).show();
          AppMethodBeat.o(78506);
        }
      });
      ad.i("MicroMsg.JsApiAddDownloadTaskStraight", "fail, not enough space, require size = ".concat(String.valueOf(l)));
      AppMethodBeat.o(78510);
      return;
    }
    if (ay.isWifi(paramContext))
    {
      a(paramString, parama);
      AppMethodBeat.o(78510);
      return;
    }
    com.tencent.mm.plugin.report.service.h.vKh.f(14217, new Object[] { str2, Integer.valueOf(4), str3, str1, Integer.valueOf(3) });
    com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131766086), paramContext.getString(2131766087), paramContext.getString(2131766081), paramContext.getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(78507);
        com.tencent.mm.plugin.report.service.h.vKh.f(14217, new Object[] { str2, Integer.valueOf(5), str3, str1, Integer.valueOf(3) });
        a.a(a.this, paramString, parama);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(78507);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(78508);
        com.tencent.mm.plugin.report.service.h.vKh.f(14217, new Object[] { str2, Integer.valueOf(6), str3, str1, Integer.valueOf(3) });
        paramAnonymousDialogInterface.dismiss();
        parama.f("network_not_wifi", null);
        AppMethodBeat.o(78508);
      }
    }, 2131101171);
    AppMethodBeat.o(78510);
  }
  
  public final void b(com.tencent.luggage.d.a<com.tencent.mm.plugin.webview.luggage.f>.a parama) {}
  
  public final int bQV()
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