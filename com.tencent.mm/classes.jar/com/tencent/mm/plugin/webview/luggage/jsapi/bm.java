package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.ae;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;
import java.util.HashMap;
import org.json.JSONObject;

public class bm
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(final a<f>.a parama)
  {
    AppMethodBeat.i(78640);
    ac.i("MicroMsg.JsApiUploadMediaFile", "invokeInOwn");
    String str1 = parama.bWS.bVY.optString("appId");
    String str2 = parama.bWS.bVY.optString("localId");
    if (parama.bWS.bVY.optInt("isShowProgressTips", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.JsApiUploadMediaFile", "uploadMediaFile, appid = %s, localid = %s, isShowProgressTips = %b", new Object[] { str1, str2, Boolean.valueOf(bool) });
      if ((!bs.isNullOrNil(str1)) && (!bs.isNullOrNil(str2))) {
        break;
      }
      ac.e("MicroMsg.JsApiUploadMediaFile", "appId or localid is null or nil.");
      parama.a("missing arguments", null);
      AppMethodBeat.o(78640);
      return;
    }
    final LuggageUploadMediaFileManager localLuggageUploadMediaFileManager = new LuggageUploadMediaFileManager();
    MMActivity localMMActivity = (MMActivity)((f)parama.bWR).mContext;
    f localf = (f)parama.bWR;
    parama = new LuggageUploadMediaFileManager.b()
    {
      public final void a(boolean paramAnonymousBoolean, HashMap<String, Object> paramAnonymousHashMap)
      {
        AppMethodBeat.i(78639);
        ac.i("MicroMsg.JsApiUploadMediaFile", "sucess = %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean) {
          parama.c("", paramAnonymousHashMap);
        }
        for (;;)
        {
          paramAnonymousHashMap = localLuggageUploadMediaFileManager;
          paramAnonymousHashMap.ofX = null;
          paramAnonymousHashMap.CkZ = null;
          paramAnonymousHashMap.mAppId = null;
          paramAnonymousHashMap.Coj = null;
          paramAnonymousHashMap.Col = null;
          AppMethodBeat.o(78639);
          return;
          parama.a("fail", null);
        }
      }
    };
    localLuggageUploadMediaFileManager.ofX = localMMActivity;
    localLuggageUploadMediaFileManager.CkZ = localf;
    localLuggageUploadMediaFileManager.mAppId = str1;
    localLuggageUploadMediaFileManager.Coj = str2;
    localLuggageUploadMediaFileManager.Cok = bool;
    localLuggageUploadMediaFileManager.Col = parama;
    parama = b.aBI(localLuggageUploadMediaFileManager.Coj);
    if (parama == null)
    {
      ac.e("MicroMsg.UploadMediaFileHelp", "item is null");
      localLuggageUploadMediaFileManager.Col.a(false, null);
      AppMethodBeat.o(78640);
      return;
    }
    if (parama.mediaType != 1)
    {
      if ((bs.isNullOrNil(parama.jAH)) || (!i.eA(parama.jAH)))
      {
        ac.e("MicroMsg.UploadMediaFileHelp", "origFilePath is not exist");
        localLuggageUploadMediaFileManager.Col.a(false, null);
        AppMethodBeat.o(78640);
        return;
      }
      if (!ae.cS(localLuggageUploadMediaFileManager.ofX))
      {
        parama = bs.An((int)i.aSp(parama.jAH));
        h.a(localLuggageUploadMediaFileManager.ofX, localLuggageUploadMediaFileManager.ofX.getString(2131766113, new Object[] { parama }), localLuggageUploadMediaFileManager.ofX.getString(2131755906), false, new LuggageUploadMediaFileManager.1(localLuggageUploadMediaFileManager), new LuggageUploadMediaFileManager.2(localLuggageUploadMediaFileManager));
        AppMethodBeat.o(78640);
        return;
      }
      localLuggageUploadMediaFileManager.eAY();
      AppMethodBeat.o(78640);
      return;
    }
    localLuggageUploadMediaFileManager.eAZ();
    AppMethodBeat.o(78640);
  }
  
  public final int bYk()
  {
    return 0;
  }
  
  public final String name()
  {
    return "uploadMediaFile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bm
 * JD-Core Version:    0.7.0.1
 */