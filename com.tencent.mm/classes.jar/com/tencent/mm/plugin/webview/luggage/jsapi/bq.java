package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import org.json.JSONObject;

public class bq
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(final com.tencent.luggage.d.b<g>.a paramb)
  {
    AppMethodBeat.i(78640);
    Log.i("MicroMsg.JsApiUploadMediaFile", "invokeInOwn");
    String str1 = paramb.ctb.csi.optString("appId");
    String str2 = paramb.ctb.csi.optString("localId");
    if (paramb.ctb.csi.optInt("isShowProgressTips", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.JsApiUploadMediaFile", "uploadMediaFile, appid = %s, localid = %s, isShowProgressTips = %b", new Object[] { str1, str2, Boolean.valueOf(bool) });
      if ((!Util.isNullOrNil(str1)) && (!Util.isNullOrNil(str2))) {
        break;
      }
      Log.e("MicroMsg.JsApiUploadMediaFile", "appId or localid is null or nil.");
      paramb.c("missing arguments", null);
      AppMethodBeat.o(78640);
      return;
    }
    final LuggageUploadMediaFileManager localLuggageUploadMediaFileManager = new LuggageUploadMediaFileManager();
    MMActivity localMMActivity = (MMActivity)((g)paramb.cta).mContext;
    g localg = (g)paramb.cta;
    paramb = new LuggageUploadMediaFileManager.b()
    {
      public final void b(boolean paramAnonymousBoolean, HashMap<String, Object> paramAnonymousHashMap)
      {
        AppMethodBeat.i(78639);
        Log.i("MicroMsg.JsApiUploadMediaFile", "sucess = %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean) {
          paramb.e("", paramAnonymousHashMap);
        }
        for (;;)
        {
          paramAnonymousHashMap = localLuggageUploadMediaFileManager;
          paramAnonymousHashMap.qdG = null;
          paramAnonymousHashMap.ISU = null;
          paramAnonymousHashMap.mAppId = null;
          paramAnonymousHashMap.IWD = null;
          paramAnonymousHashMap.IWF = null;
          AppMethodBeat.o(78639);
          return;
          paramb.c("fail", null);
        }
      }
    };
    localLuggageUploadMediaFileManager.qdG = localMMActivity;
    localLuggageUploadMediaFileManager.ISU = localg;
    localLuggageUploadMediaFileManager.mAppId = str1;
    localLuggageUploadMediaFileManager.IWD = str2;
    localLuggageUploadMediaFileManager.IWE = bool;
    localLuggageUploadMediaFileManager.IWF = paramb;
    paramb = com.tencent.mm.plugin.webview.luggage.c.b.aYC(localLuggageUploadMediaFileManager.IWD);
    if (paramb == null)
    {
      Log.e("MicroMsg.UploadMediaFileHelp", "item is null");
      localLuggageUploadMediaFileManager.IWF.b(false, null);
      AppMethodBeat.o(78640);
      return;
    }
    if (paramb.mediaType != 1)
    {
      if ((Util.isNullOrNil(paramb.laR)) || (!s.YS(paramb.laR)))
      {
        Log.e("MicroMsg.UploadMediaFileHelp", "origFilePath is not exist");
        localLuggageUploadMediaFileManager.IWF.b(false, null);
        AppMethodBeat.o(78640);
        return;
      }
      if (!ag.dm(localLuggageUploadMediaFileManager.qdG))
      {
        paramb = Util.getSizeMB((int)s.boW(paramb.laR));
        com.tencent.mm.ui.base.h.a(localLuggageUploadMediaFileManager.qdG, localLuggageUploadMediaFileManager.qdG.getString(2131768584, new Object[] { paramb }), localLuggageUploadMediaFileManager.qdG.getString(2131755998), false, new LuggageUploadMediaFileManager.1(localLuggageUploadMediaFileManager), new LuggageUploadMediaFileManager.2(localLuggageUploadMediaFileManager));
        AppMethodBeat.o(78640);
        return;
      }
      localLuggageUploadMediaFileManager.gco();
      AppMethodBeat.o(78640);
      return;
    }
    localLuggageUploadMediaFileManager.gcp();
    AppMethodBeat.o(78640);
  }
  
  public final int dTs()
  {
    return 0;
  }
  
  public final String name()
  {
    return "uploadMediaFile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bq
 * JD-Core Version:    0.7.0.1
 */