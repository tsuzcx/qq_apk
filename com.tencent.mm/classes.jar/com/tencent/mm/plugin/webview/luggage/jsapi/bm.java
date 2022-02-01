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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
    ad.i("MicroMsg.JsApiUploadMediaFile", "invokeInOwn");
    String str1 = parama.bZV.bZb.optString("appId");
    String str2 = parama.bZV.bZb.optString("localId");
    if (parama.bZV.bZb.optInt("isShowProgressTips", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.JsApiUploadMediaFile", "uploadMediaFile, appid = %s, localid = %s, isShowProgressTips = %b", new Object[] { str1, str2, Boolean.valueOf(bool) });
      if ((!bt.isNullOrNil(str1)) && (!bt.isNullOrNil(str2))) {
        break;
      }
      ad.e("MicroMsg.JsApiUploadMediaFile", "appId or localid is null or nil.");
      parama.a("missing arguments", null);
      AppMethodBeat.o(78640);
      return;
    }
    final LuggageUploadMediaFileManager localLuggageUploadMediaFileManager = new LuggageUploadMediaFileManager();
    MMActivity localMMActivity = (MMActivity)((f)parama.bZU).mContext;
    f localf = (f)parama.bZU;
    parama = new LuggageUploadMediaFileManager.b()
    {
      public final void a(boolean paramAnonymousBoolean, HashMap<String, Object> paramAnonymousHashMap)
      {
        AppMethodBeat.i(78639);
        ad.i("MicroMsg.JsApiUploadMediaFile", "sucess = %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean) {
          parama.c("", paramAnonymousHashMap);
        }
        for (;;)
        {
          paramAnonymousHashMap = localLuggageUploadMediaFileManager;
          paramAnonymousHashMap.nCW = null;
          paramAnonymousHashMap.ASM = null;
          paramAnonymousHashMap.mAppId = null;
          paramAnonymousHashMap.AVW = null;
          paramAnonymousHashMap.AVY = null;
          AppMethodBeat.o(78639);
          return;
          parama.a("fail", null);
        }
      }
    };
    localLuggageUploadMediaFileManager.nCW = localMMActivity;
    localLuggageUploadMediaFileManager.ASM = localf;
    localLuggageUploadMediaFileManager.mAppId = str1;
    localLuggageUploadMediaFileManager.AVW = str2;
    localLuggageUploadMediaFileManager.AVX = bool;
    localLuggageUploadMediaFileManager.AVY = parama;
    parama = b.awq(localLuggageUploadMediaFileManager.AVW);
    if (parama == null)
    {
      ad.e("MicroMsg.UploadMediaFileHelp", "item is null");
      localLuggageUploadMediaFileManager.AVY.a(false, null);
      AppMethodBeat.o(78640);
      return;
    }
    if (parama.mediaType != 1)
    {
      if ((bt.isNullOrNil(parama.jau)) || (!i.eK(parama.jau)))
      {
        ad.e("MicroMsg.UploadMediaFileHelp", "origFilePath is not exist");
        localLuggageUploadMediaFileManager.AVY.a(false, null);
        AppMethodBeat.o(78640);
        return;
      }
      if (!ae.cJ(localLuggageUploadMediaFileManager.nCW))
      {
        parama = bt.vK((int)i.aMN(parama.jau));
        h.a(localLuggageUploadMediaFileManager.nCW, localLuggageUploadMediaFileManager.nCW.getString(2131766113, new Object[] { parama }), localLuggageUploadMediaFileManager.nCW.getString(2131755906), false, new LuggageUploadMediaFileManager.1(localLuggageUploadMediaFileManager), new LuggageUploadMediaFileManager.2(localLuggageUploadMediaFileManager));
        AppMethodBeat.o(78640);
        return;
      }
      localLuggageUploadMediaFileManager.elC();
      AppMethodBeat.o(78640);
      return;
    }
    localLuggageUploadMediaFileManager.elD();
    AppMethodBeat.o(78640);
  }
  
  public final int bQV()
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