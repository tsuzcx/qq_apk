package com.tencent.mm.plugin.scanner.box;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.wm;
import com.tencent.mm.autogen.a.wp;
import com.tencent.mm.model.ab;
import com.tencent.mm.modelimage.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/ScanSendAppMsgHelper;", "", "()V", "TAG", "", "convertToAppMsg", "Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;", "data", "Lorg/json/JSONObject;", "doSendAppMessage", "", "appMsg", "app", "Lcom/tencent/mm/pluginsdk/model/app/AppInfo;", "appId", "toUser", "imageUrl", "srcUsername", "srcDisplayName", "appendText", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
{
  public static final r ONX;
  
  static
  {
    AppMethodBeat.i(313741);
    ONX = new r();
    AppMethodBeat.o(313741);
  }
  
  public static boolean b(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(313736);
    if (paramWXMediaMessage == null)
    {
      Log.e("MicroMsg.ScanSendAppMsgHelper", "doSendAppMessage appMsg is null");
      AppMethodBeat.o(313736);
      return false;
    }
    com.tencent.mm.modelimage.r.bJZ();
    paramString2 = e.Eo(paramString2);
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
        paramWXMediaMessage = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.opensdk.modelmsg.WXWebpageObject");
        AppMethodBeat.o(313736);
        throw paramWXMediaMessage;
      }
    }
    for (paramString2 = ((WXWebpageObject)paramString2).webpageUrl;; paramString2 = "")
    {
      localObject = new wm();
      ((wm)localObject).hZZ.hzF = paramWXMediaMessage;
      ((wm)localObject).hZZ.appId = null;
      ((wm)localObject).hZZ.appName = "";
      ((wm)localObject).hZZ.toUser = paramString1;
      ((wm)localObject).hZZ.hKZ = 2;
      ((wm)localObject).hZZ.iaa = null;
      ((wm)localObject).hZZ.iab = null;
      ((wm)localObject).hZZ.iad = paramString2;
      ((wm)localObject).hZZ.iae = paramString2;
      ((wm)localObject).hZZ.iaf = null;
      boolean bool = ((wm)localObject).publish();
      if (!Util.isNullOrNil(paramString3))
      {
        paramWXMediaMessage = new wp();
        paramWXMediaMessage.iak.hgl = paramString1;
        paramWXMediaMessage.iak.content = paramString3;
        paramWXMediaMessage.iak.type = ab.IX(paramString1);
        paramWXMediaMessage.iak.flags = 0;
        paramWXMediaMessage.publish();
      }
      Log.d("MicroMsg.ScanSendAppMsgHelper", "doSendAppMessage result %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(313736);
      return bool;
    }
  }
  
  public static final WXMediaMessage bM(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(313728);
    s.u(paramJSONObject, "data");
    Object localObject2 = paramJSONObject.optString("url");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    if (((CharSequence)localObject1).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("MicroMsg.ScanSendAppMsgHelper", "convertToAppMsg fail, url is null");
      AppMethodBeat.o(313728);
      return null;
    }
    Log.i("MicroMsg.ScanSendAppMsgHelper", "convertToAppMsg url: %s", new Object[] { localObject1 });
    localObject2 = new WXMediaMessage();
    WXWebpageObject localWXWebpageObject = new WXWebpageObject();
    localWXWebpageObject.webpageUrl = ((String)localObject1);
    localObject1 = ah.aiuX;
    ((WXMediaMessage)localObject2).mediaObject = ((WXMediaMessage.IMediaObject)localWXWebpageObject);
    ((WXMediaMessage)localObject2).title = paramJSONObject.optString("title");
    ((WXMediaMessage)localObject2).description = paramJSONObject.optString("desc");
    AppMethodBeat.o(313728);
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.r
 * JD-Core Version:    0.7.0.1
 */