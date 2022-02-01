package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import org.json.JSONObject;

public class bp
  extends br<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(final com.tencent.luggage.d.b<g>.a paramb)
  {
    AppMethodBeat.i(78640);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiUploadMediaFile", "invokeInOwn");
    String str1 = paramb.chh.cgn.optString("appId");
    String str2 = paramb.chh.cgn.optString("localId");
    if (paramb.chh.cgn.optInt("isShowProgressTips", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiUploadMediaFile", "uploadMediaFile, appid = %s, localid = %s, isShowProgressTips = %b", new Object[] { str1, str2, Boolean.valueOf(bool) });
      if ((!bu.isNullOrNil(str1)) && (!bu.isNullOrNil(str2))) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.JsApiUploadMediaFile", "appId or localid is null or nil.");
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
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiUploadMediaFile", "sucess = %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean) {
          paramb.e("", paramAnonymousHashMap);
        }
        for (;;)
        {
          paramAnonymousHashMap = localLuggageUploadMediaFileManager;
          paramAnonymousHashMap.oPS = null;
          paramAnonymousHashMap.Egl = null;
          paramAnonymousHashMap.mAppId = null;
          paramAnonymousHashMap.EjH = null;
          paramAnonymousHashMap.EjJ = null;
          AppMethodBeat.o(78639);
          return;
          paramb.a("fail", null);
        }
      }
    };
    localLuggageUploadMediaFileManager.oPS = localMMActivity;
    localLuggageUploadMediaFileManager.Egl = localg;
    localLuggageUploadMediaFileManager.mAppId = str1;
    localLuggageUploadMediaFileManager.EjH = str2;
    localLuggageUploadMediaFileManager.EjI = bool;
    localLuggageUploadMediaFileManager.EjJ = paramb;
    paramb = com.tencent.mm.plugin.webview.luggage.c.b.aIB(localLuggageUploadMediaFileManager.EjH);
    if (paramb == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.UploadMediaFileHelp", "item is null");
      localLuggageUploadMediaFileManager.EjJ.a(false, null);
      AppMethodBeat.o(78640);
      return;
    }
    if (paramb.mediaType != 1)
    {
      if ((bu.isNullOrNil(paramb.jXT)) || (!o.fB(paramb.jXT)))
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.UploadMediaFileHelp", "origFilePath is not exist");
        localLuggageUploadMediaFileManager.EjJ.a(false, null);
        AppMethodBeat.o(78640);
        return;
      }
      if (!com.tencent.mm.network.ae.cR(localLuggageUploadMediaFileManager.oPS))
      {
        paramb = bu.DB((int)o.aZR(paramb.jXT));
        com.tencent.mm.ui.base.h.a(localLuggageUploadMediaFileManager.oPS, localLuggageUploadMediaFileManager.oPS.getString(2131766113, new Object[] { paramb }), localLuggageUploadMediaFileManager.oPS.getString(2131755906), false, new LuggageUploadMediaFileManager.1(localLuggageUploadMediaFileManager), new LuggageUploadMediaFileManager.2(localLuggageUploadMediaFileManager));
        AppMethodBeat.o(78640);
        return;
      }
      localLuggageUploadMediaFileManager.eTC();
      AppMethodBeat.o(78640);
      return;
    }
    localLuggageUploadMediaFileManager.eTD();
    AppMethodBeat.o(78640);
  }
  
  public final int ced()
  {
    return 0;
  }
  
  public final String name()
  {
    return "uploadMediaFile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bp
 * JD-Core Version:    0.7.0.1
 */