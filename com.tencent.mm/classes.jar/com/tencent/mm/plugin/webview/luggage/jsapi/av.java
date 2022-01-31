package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.e.a;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.R.l;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.webview.luggage.d.c;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import org.json.JSONObject;

public class av
  extends ax<com.tencent.mm.plugin.webview.luggage.e>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(a<com.tencent.mm.plugin.webview.luggage.e>.a parama)
  {
    y.i("MicroMsg.JsApiUploadMediaFile", "invokeInOwn");
    String str1 = parama.bih.bhk.optString("appId");
    String str2 = parama.bih.bhk.optString("localId");
    if (parama.bih.bhk.optInt("isShowProgressTips", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.JsApiUploadMediaFile", "uploadMediaFile, appid = %s, localid = %s, isShowProgressTips = %b", new Object[] { str1, str2, Boolean.valueOf(bool) });
      if ((!bk.bl(str1)) && (!bk.bl(str2))) {
        break;
      }
      y.e("MicroMsg.JsApiUploadMediaFile", "appId or localid is null or nil.");
      parama.a("missing arguments", null);
      return;
    }
    LuggageUploadMediaFileManager localLuggageUploadMediaFileManager = new LuggageUploadMediaFileManager();
    MMActivity localMMActivity = (MMActivity)((com.tencent.mm.plugin.webview.luggage.e)parama.big).mContext;
    com.tencent.mm.plugin.webview.luggage.e locale = (com.tencent.mm.plugin.webview.luggage.e)parama.big;
    parama = new av.1(this, parama, localLuggageUploadMediaFileManager);
    localLuggageUploadMediaFileManager.iwz = localMMActivity;
    localLuggageUploadMediaFileManager.rcp = locale;
    localLuggageUploadMediaFileManager.mAppId = str1;
    localLuggageUploadMediaFileManager.rdX = str2;
    localLuggageUploadMediaFileManager.rdY = bool;
    localLuggageUploadMediaFileManager.rdZ = parama;
    parama = c.Sc(localLuggageUploadMediaFileManager.rdX);
    if (parama == null)
    {
      y.e("MicroMsg.UploadMediaFileHelp", "item is null");
      localLuggageUploadMediaFileManager.rdZ.a(false, null);
      return;
    }
    if (parama.bLN != 1)
    {
      if ((bk.bl(parama.fMZ)) || (!com.tencent.mm.a.e.bK(parama.fMZ)))
      {
        y.e("MicroMsg.UploadMediaFileHelp", "origFilePath is not exist");
        localLuggageUploadMediaFileManager.rdZ.a(false, null);
        return;
      }
      if (!ab.bG(localLuggageUploadMediaFileManager.iwz))
      {
        parama = bk.ht(com.tencent.mm.a.e.bJ(parama.fMZ));
        h.a(localLuggageUploadMediaFileManager.iwz, localLuggageUploadMediaFileManager.iwz.getString(R.l.webview_jssdk_upload_video_gprs_confirm, new Object[] { parama }), localLuggageUploadMediaFileManager.iwz.getString(R.l.app_tip), false, new LuggageUploadMediaFileManager.1(localLuggageUploadMediaFileManager), new LuggageUploadMediaFileManager.2(localLuggageUploadMediaFileManager));
        return;
      }
      localLuggageUploadMediaFileManager.cbz();
      return;
    }
    localLuggageUploadMediaFileManager.cbA();
  }
  
  public final String name()
  {
    return "uploadMediaFile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.av
 * JD-Core Version:    0.7.0.1
 */