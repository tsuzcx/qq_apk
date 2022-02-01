package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import org.json.JSONObject;

public class bq
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(final b<g>.a paramb)
  {
    AppMethodBeat.i(78640);
    Log.i("MicroMsg.JsApiUploadMediaFile", "invokeInOwn");
    String str1 = paramb.crh.cqn.optString("appId");
    String str2 = paramb.crh.cqn.optString("localId");
    if (paramb.crh.cqn.optInt("isShowProgressTips", 0) == 1) {}
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
    MMActivity localMMActivity = (MMActivity)((g)paramb.crg).mContext;
    g localg = (g)paramb.crg;
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
          paramAnonymousHashMap.tzD = null;
          paramAnonymousHashMap.PPn = null;
          paramAnonymousHashMap.mAppId = null;
          paramAnonymousHashMap.PST = null;
          paramAnonymousHashMap.PSV = null;
          AppMethodBeat.o(78639);
          return;
          paramb.a("fail", null);
        }
      }
    };
    localLuggageUploadMediaFileManager.tzD = localMMActivity;
    localLuggageUploadMediaFileManager.PPn = localg;
    localLuggageUploadMediaFileManager.mAppId = str1;
    localLuggageUploadMediaFileManager.PST = str2;
    localLuggageUploadMediaFileManager.PSU = bool;
    localLuggageUploadMediaFileManager.PSV = paramb;
    paramb = c.bkw(localLuggageUploadMediaFileManager.PST);
    if (paramb == null)
    {
      Log.e("MicroMsg.UploadMediaFileHelp", "item is null");
      localLuggageUploadMediaFileManager.PSV.b(false, null);
      AppMethodBeat.o(78640);
      return;
    }
    if (paramb.mediaType != 1)
    {
      if ((Util.isNullOrNil(paramb.nVa)) || (!u.agG(paramb.nVa)))
      {
        Log.e("MicroMsg.UploadMediaFileHelp", "origFilePath is not exist");
        localLuggageUploadMediaFileManager.PSV.b(false, null);
        AppMethodBeat.o(78640);
        return;
      }
      if (!ag.dj(localLuggageUploadMediaFileManager.tzD))
      {
        paramb = Util.getSizeMB((int)u.bBQ(paramb.nVa));
        com.tencent.mm.ui.base.h.a(localLuggageUploadMediaFileManager.tzD, localLuggageUploadMediaFileManager.tzD.getString(c.i.webview_jssdk_upload_video_gprs_confirm, new Object[] { paramb }), localLuggageUploadMediaFileManager.tzD.getString(c.i.app_tip), false, new LuggageUploadMediaFileManager.1(localLuggageUploadMediaFileManager), new LuggageUploadMediaFileManager.2(localLuggageUploadMediaFileManager));
        AppMethodBeat.o(78640);
        return;
      }
      localLuggageUploadMediaFileManager.gVi();
      AppMethodBeat.o(78640);
      return;
    }
    localLuggageUploadMediaFileManager.gVj();
    AppMethodBeat.o(78640);
  }
  
  public final int cDj()
  {
    return 0;
  }
  
  public final String name()
  {
    return "uploadMediaFile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bq
 * JD-Core Version:    0.7.0.1
 */