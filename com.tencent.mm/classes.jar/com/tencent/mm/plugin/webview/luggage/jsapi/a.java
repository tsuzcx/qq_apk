package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.iv;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends bs<g>
{
  private void a(JSONObject paramJSONObject, br.a parama)
  {
    AppMethodBeat.i(78511);
    iv localiv = new iv();
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
    localiv.dNx.url = str2;
    localiv.dNx.md5 = str4;
    localiv.dNx.extInfo = str8;
    localiv.dNx.appId = str6;
    localiv.dNx.scene = i;
    EventCenter.instance.publish(localiv);
    paramJSONObject = new g.a();
    paramJSONObject.alj(str2);
    paramJSONObject.alk(str3);
    paramJSONObject.setFileSize(l);
    paramJSONObject.all(str1);
    paramJSONObject.setFileMD5(str4);
    paramJSONObject.setAppId(str6);
    paramJSONObject.gm(str7);
    paramJSONObject.kS(true);
    paramJSONObject.Fl(Util.getInt(str5, 1));
    paramJSONObject.setScene(i);
    paramJSONObject.Fp(k);
    paramJSONObject.Fm(m);
    paramJSONObject.Fn(n);
    paramJSONObject.Fo(i1);
    paramJSONObject = paramJSONObject.qIY;
    if (j == 1) {}
    for (l = f.cBv().b(paramJSONObject);; l = f.cBv().a(paramJSONObject))
    {
      d.d(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
      if (l > 0L) {
        break;
      }
      parama.i("fail", null);
      AppMethodBeat.o(78511);
      return;
    }
    try
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("download_id", l);
      parama.i(null, paramJSONObject);
      AppMethodBeat.o(78511);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      parama.i(null, null);
      AppMethodBeat.o(78511);
    }
  }
  
  public final void a(final Context paramContext, final String paramString, final br.a parama)
  {
    AppMethodBeat.i(78510);
    Log.i("MicroMsg.JsApiAddDownloadTaskStraight", "invokeInMM");
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
        parama.i("fail", null);
        AppMethodBeat.o(78510);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      Log.e("MicroMsg.JsApiAddDownloadTaskStraight", "paras data error: " + paramContext.getMessage());
      parama.i("fail", null);
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
      o.a(paramContext, com.tencent.mm.plugin.downloader_app.a.a.aK(paramString), new o.a()
      {
        public final void i(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(78509);
          parama.i(paramAnonymousString, paramAnonymousJSONObject);
          AppMethodBeat.o(78509);
        }
      });
      d.d(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
      AppMethodBeat.o(78510);
      return;
    }
    if (!NetStatusUtil.isNetworkConnected(paramContext))
    {
      parama.i("fail_network_not_connected", null);
      com.tencent.mm.plugin.webview.luggage.c.b.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78504);
          Toast.makeText(paramContext, paramContext.getString(2131761199), 0).show();
          AppMethodBeat.o(78504);
        }
      });
      Log.i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, network not ready");
      AppMethodBeat.o(78510);
      return;
    }
    if (!e.apn())
    {
      parama.i("sdcard_not_ready", null);
      com.tencent.mm.plugin.webview.luggage.c.b.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78505);
          Toast.makeText(paramContext, paramContext.getString(2131761203), 0).show();
          AppMethodBeat.o(78505);
        }
      });
      Log.i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, sdcard not ready");
      AppMethodBeat.o(78510);
      return;
    }
    if ((l > 0L) && (!com.tencent.mm.plugin.downloader.model.h.CF(l)) && (!com.tencent.mm.plugin.downloader.model.h.CE(l)))
    {
      parama.i("has_not_enough_space", null);
      com.tencent.mm.plugin.webview.luggage.c.b.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78506);
          Toast.makeText(paramContext, paramContext.getString(2131761200), 0).show();
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
    com.tencent.mm.plugin.report.service.h.CyF.a(14217, new Object[] { str2, Integer.valueOf(4), str3, str1, Integer.valueOf(3) });
    com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131768552), paramContext.getString(2131768553), paramContext.getString(2131768547), paramContext.getString(2131755761), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(78507);
        com.tencent.mm.plugin.report.service.h.CyF.a(14217, new Object[] { str2, Integer.valueOf(5), str3, str1, Integer.valueOf(3) });
        a.a(a.this, paramString, parama);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(78507);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(78508);
        com.tencent.mm.plugin.report.service.h.CyF.a(14217, new Object[] { str2, Integer.valueOf(6), str3, str1, Integer.valueOf(3) });
        paramAnonymousDialogInterface.dismiss();
        parama.i("network_not_wifi", null);
        AppMethodBeat.o(78508);
      }
    }, 2131101414);
    AppMethodBeat.o(78510);
  }
  
  public final void b(com.tencent.luggage.d.b<g>.a paramb) {}
  
  public final int dTs()
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