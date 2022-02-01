package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.ah;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import org.json.JSONObject;

public class bu
  extends bw<g>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(final b<g>.a paramb)
  {
    AppMethodBeat.i(78640);
    Log.i("MicroMsg.JsApiUploadMediaFile", "invokeInOwn");
    String str1 = paramb.eiZ.eif.optString("appId");
    String str2 = paramb.eiZ.eif.optString("localId");
    if (paramb.eiZ.eif.optInt("isShowProgressTips", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.JsApiUploadMediaFile", "uploadMediaFile, appid = %s, localid = %s, isShowProgressTips = %b", new Object[] { str1, str2, Boolean.valueOf(bool) });
      if ((!Util.isNullOrNil(str1)) && (!Util.isNullOrNil(str2))) {
        break;
      }
      Log.e("MicroMsg.JsApiUploadMediaFile", "appId or localid is null or nil.");
      paramb.a("missing arguments", null);
      AppMethodBeat.o(78640);
      return;
    }
    final LuggageUploadMediaFileManager localLuggageUploadMediaFileManager = new LuggageUploadMediaFileManager();
    MMActivity localMMActivity = (MMActivity)((g)paramb.eiY).mContext;
    g localg = (g)paramb.eiY;
    paramb = new LuggageUploadMediaFileManager.b()
    {
      public final void b(boolean paramAnonymousBoolean, HashMap<String, Object> paramAnonymousHashMap)
      {
        AppMethodBeat.i(78639);
        Log.i("MicroMsg.JsApiUploadMediaFile", "sucess = %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean) {
          paramb.d("", paramAnonymousHashMap);
        }
        for (;;)
        {
          paramAnonymousHashMap = localLuggageUploadMediaFileManager;
          paramAnonymousHashMap.pVV = null;
          paramAnonymousHashMap.WFG = null;
          paramAnonymousHashMap.mAppId = null;
          paramAnonymousHashMap.WJF = null;
          paramAnonymousHashMap.WJH = null;
          AppMethodBeat.o(78639);
          return;
          paramb.a("fail", null);
        }
      }
    };
    localLuggageUploadMediaFileManager.pVV = localMMActivity;
    localLuggageUploadMediaFileManager.WFG = localg;
    localLuggageUploadMediaFileManager.mAppId = str1;
    localLuggageUploadMediaFileManager.WJF = str2;
    localLuggageUploadMediaFileManager.WJG = bool;
    localLuggageUploadMediaFileManager.WJH = paramb;
    paramb = c.bkh(localLuggageUploadMediaFileManager.WJF);
    if (paramb == null)
    {
      Log.e("MicroMsg.UploadMediaFileHelp", "item is null");
      localLuggageUploadMediaFileManager.WJH.b(false, null);
      AppMethodBeat.o(78640);
      return;
    }
    if (paramb.mediaType != 1)
    {
      if ((Util.isNullOrNil(paramb.qUK)) || (!y.ZC(paramb.qUK)))
      {
        Log.e("MicroMsg.UploadMediaFileHelp", "origFilePath is not exist");
        localLuggageUploadMediaFileManager.WJH.b(false, null);
        AppMethodBeat.o(78640);
        return;
      }
      if (!ah.eb(localLuggageUploadMediaFileManager.pVV))
      {
        paramb = Util.getSizeMB((int)y.bEl(paramb.qUK));
        com.tencent.mm.ui.base.k.a(localLuggageUploadMediaFileManager.pVV, localLuggageUploadMediaFileManager.pVV.getString(c.i.webview_jssdk_upload_video_gprs_confirm, new Object[] { paramb }), localLuggageUploadMediaFileManager.pVV.getString(c.i.app_tip), false, new LuggageUploadMediaFileManager.1(localLuggageUploadMediaFileManager), new LuggageUploadMediaFileManager.2(localLuggageUploadMediaFileManager));
        AppMethodBeat.o(78640);
        return;
      }
      localLuggageUploadMediaFileManager.iuT();
      AppMethodBeat.o(78640);
      return;
    }
    localLuggageUploadMediaFileManager.iuU();
    AppMethodBeat.o(78640);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "uploadMediaFile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bu
 * JD-Core Version:    0.7.0.1
 */