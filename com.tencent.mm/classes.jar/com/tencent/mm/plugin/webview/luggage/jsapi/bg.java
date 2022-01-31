package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.ac;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import org.json.JSONObject;

public class bg
  extends bi<com.tencent.mm.plugin.webview.luggage.e>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<com.tencent.mm.plugin.webview.luggage.e>.a parama)
  {
    AppMethodBeat.i(6388);
    ab.i("MicroMsg.JsApiUploadMediaFile", "invokeInOwn");
    String str1 = parama.byF.bxK.optString("appId");
    String str2 = parama.byF.bxK.optString("localId");
    if (parama.byF.bxK.optInt("isShowProgressTips", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.JsApiUploadMediaFile", "uploadMediaFile, appid = %s, localid = %s, isShowProgressTips = %b", new Object[] { str1, str2, Boolean.valueOf(bool) });
      if ((!bo.isNullOrNil(str1)) && (!bo.isNullOrNil(str2))) {
        break;
      }
      ab.e("MicroMsg.JsApiUploadMediaFile", "appId or localid is null or nil.");
      parama.a("missing arguments", null);
      AppMethodBeat.o(6388);
      return;
    }
    LuggageUploadMediaFileManager localLuggageUploadMediaFileManager = new LuggageUploadMediaFileManager();
    MMActivity localMMActivity = (MMActivity)((com.tencent.mm.plugin.webview.luggage.e)parama.byE).mContext;
    com.tencent.mm.plugin.webview.luggage.e locale = (com.tencent.mm.plugin.webview.luggage.e)parama.byE;
    parama = new bg.1(this, parama, localLuggageUploadMediaFileManager);
    localLuggageUploadMediaFileManager.kxD = localMMActivity;
    localLuggageUploadMediaFileManager.uSb = locale;
    localLuggageUploadMediaFileManager.mAppId = str1;
    localLuggageUploadMediaFileManager.uUa = str2;
    localLuggageUploadMediaFileManager.uUb = bool;
    localLuggageUploadMediaFileManager.uUc = parama;
    parama = b.agY(localLuggageUploadMediaFileManager.uUa);
    if (parama == null)
    {
      ab.e("MicroMsg.UploadMediaFileHelp", "item is null");
      localLuggageUploadMediaFileManager.uUc.a(false, null);
      AppMethodBeat.o(6388);
      return;
    }
    if (parama.cth != 1)
    {
      if ((bo.isNullOrNil(parama.hgj)) || (!com.tencent.mm.a.e.cN(parama.hgj)))
      {
        ab.e("MicroMsg.UploadMediaFileHelp", "origFilePath is not exist");
        localLuggageUploadMediaFileManager.uUc.a(false, null);
        AppMethodBeat.o(6388);
        return;
      }
      if (!ac.cm(localLuggageUploadMediaFileManager.kxD))
      {
        parama = bo.nV(com.tencent.mm.a.e.cM(parama.hgj));
        h.a(localLuggageUploadMediaFileManager.kxD, localLuggageUploadMediaFileManager.kxD.getString(2131305879, new Object[] { parama }), localLuggageUploadMediaFileManager.kxD.getString(2131297087), false, new LuggageUploadMediaFileManager.1(localLuggageUploadMediaFileManager), new LuggageUploadMediaFileManager.2(localLuggageUploadMediaFileManager));
        AppMethodBeat.o(6388);
        return;
      }
      localLuggageUploadMediaFileManager.dbD();
      AppMethodBeat.o(6388);
      return;
    }
    localLuggageUploadMediaFileManager.dbE();
    AppMethodBeat.o(6388);
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "uploadMediaFile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bg
 * JD-Core Version:    0.7.0.1
 */