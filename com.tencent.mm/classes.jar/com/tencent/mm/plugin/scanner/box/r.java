package com.tencent.mm.plugin.scanner.box;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.d;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.model.ab;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/ScanSendAppMsgHelper;", "", "()V", "TAG", "", "convertToAppMsg", "Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;", "data", "Lorg/json/JSONObject;", "doSendAppMessage", "", "appMsg", "app", "Lcom/tencent/mm/pluginsdk/model/app/AppInfo;", "appId", "toUser", "imageUrl", "srcUsername", "srcDisplayName", "appendText", "plugin-scan_release"})
public final class r
{
  public static final r CDy;
  
  static
  {
    AppMethodBeat.i(240337);
    CDy = new r();
    AppMethodBeat.o(240337);
  }
  
  public static boolean b(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(240336);
    if (paramWXMediaMessage == null)
    {
      Log.e("MicroMsg.ScanSendAppMsgHelper", "doSendAppMessage appMsg is null");
      AppMethodBeat.o(240336);
      return false;
    }
    q.bcQ();
    paramString2 = d.EP(paramString2);
    Object localObject;
    if ((paramString2 != null) && (!paramString2.isRecycled()))
    {
      Log.i("MicroMsg.ScanSendAppMsgHelper", "doSendAppMessage thumbImage is not null");
      localObject = new ByteArrayOutputStream();
      paramString2.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      paramWXMediaMessage.thumbData = ((ByteArrayOutputStream)localObject).toByteArray();
    }
    if ((paramWXMediaMessage.mediaObject instanceof WXWebpageObject))
    {
      paramString2 = paramWXMediaMessage.mediaObject;
      if (paramString2 == null)
      {
        paramWXMediaMessage = new t("null cannot be cast to non-null type com.tencent.mm.opensdk.modelmsg.WXWebpageObject");
        AppMethodBeat.o(240336);
        throw paramWXMediaMessage;
      }
    }
    for (paramString2 = ((WXWebpageObject)paramString2).webpageUrl;; paramString2 = "")
    {
      localObject = new tt();
      ((tt)localObject).eaf.dCE = paramWXMediaMessage;
      ((tt)localObject).eaf.appId = null;
      ((tt)localObject).eaf.appName = "";
      ((tt)localObject).eaf.toUser = paramString1;
      ((tt)localObject).eaf.dMG = 2;
      ((tt)localObject).eaf.eag = null;
      ((tt)localObject).eaf.eah = null;
      ((tt)localObject).eaf.eaj = paramString2;
      ((tt)localObject).eaf.eak = paramString2;
      ((tt)localObject).eaf.eal = null;
      boolean bool = EventCenter.instance.publish((IEvent)localObject);
      if (!Util.isNullOrNil(paramString3))
      {
        paramWXMediaMessage = new tw();
        paramWXMediaMessage.eaq.dkV = paramString1;
        paramWXMediaMessage.eaq.content = paramString3;
        paramWXMediaMessage.eaq.type = ab.JG(paramString1);
        paramWXMediaMessage.eaq.flags = 0;
        EventCenter.instance.publish((IEvent)paramWXMediaMessage);
      }
      Log.d("MicroMsg.ScanSendAppMsgHelper", "doSendAppMessage result %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(240336);
      return bool;
    }
  }
  
  public static final WXMediaMessage bm(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(240335);
    p.h(paramJSONObject, "data");
    Object localObject2 = paramJSONObject.optString("url");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    if (((CharSequence)localObject1).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("MicroMsg.ScanSendAppMsgHelper", "convertToAppMsg fail, url is null");
      AppMethodBeat.o(240335);
      return null;
    }
    Log.i("MicroMsg.ScanSendAppMsgHelper", "convertToAppMsg url: %s", new Object[] { localObject1 });
    localObject2 = new WXMediaMessage();
    WXWebpageObject localWXWebpageObject = new WXWebpageObject();
    localWXWebpageObject.webpageUrl = ((String)localObject1);
    ((WXMediaMessage)localObject2).mediaObject = ((WXMediaMessage.IMediaObject)localWXWebpageObject);
    ((WXMediaMessage)localObject2).title = paramJSONObject.optString("title");
    ((WXMediaMessage)localObject2).description = paramJSONObject.optString("desc");
    AppMethodBeat.o(240335);
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.r
 * JD-Core Version:    0.7.0.1
 */