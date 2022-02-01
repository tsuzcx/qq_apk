package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.ig;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends br<com.tencent.mm.plugin.webview.luggage.g>
{
  private void a(JSONObject paramJSONObject, bq.a parama)
  {
    AppMethodBeat.i(78511);
    ig localig = new ig();
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
    localig.dvQ.url = str2;
    localig.dvQ.md5 = str4;
    localig.dvQ.extInfo = str8;
    localig.dvQ.appId = str6;
    localig.dvQ.scene = i;
    com.tencent.mm.sdk.b.a.IvT.l(localig);
    paramJSONObject = new g.a();
    paramJSONObject.abb(str2);
    paramJSONObject.abc(str3);
    paramJSONObject.uz(l);
    paramJSONObject.abd(str1);
    paramJSONObject.abe(str4);
    paramJSONObject.setAppId(str6);
    paramJSONObject.fz(str7);
    paramJSONObject.jP(true);
    paramJSONObject.BB(bu.getInt(str5, 1));
    paramJSONObject.setScene(i);
    paramJSONObject.BF(k);
    paramJSONObject.BC(m);
    paramJSONObject.BD(n);
    paramJSONObject.BE(i1);
    paramJSONObject = paramJSONObject.ptu;
    if (j == 1) {}
    for (l = f.cdA().b(paramJSONObject);; l = f.cdA().a(paramJSONObject))
    {
      d.d(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
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
  
  public final void a(final Context paramContext, final String paramString, final bq.a parama)
  {
    AppMethodBeat.i(78510);
    ae.i("MicroMsg.JsApiAddDownloadTaskStraight", "invokeInMM");
    final String str1;
    long l;
    try
    {
      paramString = new JSONObject(paramString);
      str1 = paramString.optString("task_url");
      l = paramString.optLong("task_size");
      if (bu.isNullOrNil(str1))
      {
        ae.e("MicroMsg.JsApiAddDownloadTaskStraight", "url is null");
        parama.f("fail", null);
        AppMethodBeat.o(78510);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      ae.e("MicroMsg.JsApiAddDownloadTaskStraight", "paras data error: " + paramContext.getMessage());
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
      o.a(paramContext, com.tencent.mm.plugin.downloader_app.a.a.ar(paramString), new o.a()
      {
        public final void f(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(78509);
          parama.f(paramAnonymousString, paramAnonymousJSONObject);
          AppMethodBeat.o(78509);
        }
      });
      d.d(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
      AppMethodBeat.o(78510);
      return;
    }
    if (!az.isNetworkConnected(paramContext))
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
      ae.i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, network not ready");
      AppMethodBeat.o(78510);
      return;
    }
    if (!e.abo())
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
      ae.i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, sdcard not ready");
      AppMethodBeat.o(78510);
      return;
    }
    if ((l > 0L) && (!com.tencent.mm.plugin.downloader.model.h.uB(l)) && (!com.tencent.mm.plugin.downloader.model.h.uA(l)))
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
      ae.i("MicroMsg.JsApiAddDownloadTaskStraight", "fail, not enough space, require size = ".concat(String.valueOf(l)));
      AppMethodBeat.o(78510);
      return;
    }
    if (az.isWifi(paramContext))
    {
      a(paramString, parama);
      AppMethodBeat.o(78510);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(14217, new Object[] { str2, Integer.valueOf(4), str3, str1, Integer.valueOf(3) });
    com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131766086), paramContext.getString(2131766087), paramContext.getString(2131766081), paramContext.getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(78507);
        com.tencent.mm.plugin.report.service.g.yxI.f(14217, new Object[] { str2, Integer.valueOf(5), str3, str1, Integer.valueOf(3) });
        a.a(a.this, paramString, parama);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(78507);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(78508);
        com.tencent.mm.plugin.report.service.g.yxI.f(14217, new Object[] { str2, Integer.valueOf(6), str3, str1, Integer.valueOf(3) });
        paramAnonymousDialogInterface.dismiss();
        parama.f("network_not_wifi", null);
        AppMethodBeat.o(78508);
      }
    }, 2131101171);
    AppMethodBeat.o(78510);
  }
  
  public final void b(com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>.a paramb) {}
  
  public final int ced()
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