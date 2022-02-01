package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.ae;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.i;
import java.util.HashMap;
import org.json.JSONObject;

public class bp
  extends br<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(final com.tencent.luggage.d.b<g>.a paramb)
  {
    AppMethodBeat.i(78640);
    ad.i("MicroMsg.JsApiUploadMediaFile", "invokeInOwn");
    String str1 = paramb.chh.cgn.optString("appId");
    String str2 = paramb.chh.cgn.optString("localId");
    if (paramb.chh.cgn.optInt("isShowProgressTips", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.JsApiUploadMediaFile", "uploadMediaFile, appid = %s, localid = %s, isShowProgressTips = %b", new Object[] { str1, str2, Boolean.valueOf(bool) });
      if ((!bt.isNullOrNil(str1)) && (!bt.isNullOrNil(str2))) {
        break;
      }
      ad.e("MicroMsg.JsApiUploadMediaFile", "appId or localid is null or nil.");
      paramb.a("missing arguments", null);
      AppMethodBeat.o(78640);
      return;
    }
    final LuggageUploadMediaFileManager localLuggageUploadMediaFileManager = new LuggageUploadMediaFileManager();
    MMActivity localMMActivity = (MMActivity)((g)paramb.chg).mContext;
    g localg = (g)paramb.chg;
    paramb = new LuggageUploadMediaFileManager.b()
    {
      public final void a(boolean paramAnonymousBoolean, HashMap<String, Object> paramAnonymousHashMap)
      {
        AppMethodBeat.i(78639);
        ad.i("MicroMsg.JsApiUploadMediaFile", "sucess = %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean) {
          paramb.d("", paramAnonymousHashMap);
        }
        for (;;)
        {
          paramAnonymousHashMap = localLuggageUploadMediaFileManager;
          paramAnonymousHashMap.oJq = null;
          paramAnonymousHashMap.DOl = null;
          paramAnonymousHashMap.mAppId = null;
          paramAnonymousHashMap.DRH = null;
          paramAnonymousHashMap.DRJ = null;
          AppMethodBeat.o(78639);
          return;
          paramb.a("fail", null);
        }
      }
    };
    localLuggageUploadMediaFileManager.oJq = localMMActivity;
    localLuggageUploadMediaFileManager.DOl = localg;
    localLuggageUploadMediaFileManager.mAppId = str1;
    localLuggageUploadMediaFileManager.DRH = str2;
    localLuggageUploadMediaFileManager.DRI = bool;
    localLuggageUploadMediaFileManager.DRJ = paramb;
    paramb = com.tencent.mm.plugin.webview.luggage.c.b.aHh(localLuggageUploadMediaFileManager.DRH);
    if (paramb == null)
    {
      ad.e("MicroMsg.UploadMediaFileHelp", "item is null");
      localLuggageUploadMediaFileManager.DRJ.a(false, null);
      AppMethodBeat.o(78640);
      return;
    }
    if (paramb.mediaType != 1)
    {
      if ((bt.isNullOrNil(paramb.jUC)) || (!i.fv(paramb.jUC)))
      {
        ad.e("MicroMsg.UploadMediaFileHelp", "origFilePath is not exist");
        localLuggageUploadMediaFileManager.DRJ.a(false, null);
        AppMethodBeat.o(78640);
        return;
      }
      if (!ae.cP(localLuggageUploadMediaFileManager.oJq))
      {
        paramb = bt.Dd((int)i.aYo(paramb.jUC));
        com.tencent.mm.ui.base.h.a(localLuggageUploadMediaFileManager.oJq, localLuggageUploadMediaFileManager.oJq.getString(2131766113, new Object[] { paramb }), localLuggageUploadMediaFileManager.oJq.getString(2131755906), false, new LuggageUploadMediaFileManager.1(localLuggageUploadMediaFileManager), new LuggageUploadMediaFileManager.2(localLuggageUploadMediaFileManager));
        AppMethodBeat.o(78640);
        return;
      }
      localLuggageUploadMediaFileManager.ePQ();
      AppMethodBeat.o(78640);
      return;
    }
    localLuggageUploadMediaFileManager.ePR();
    AppMethodBeat.o(78640);
  }
  
  public final int ccO()
  {
    return 0;
  }
  
  public final String name()
  {
    return "uploadMediaFile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bp
 * JD-Core Version:    0.7.0.1
 */