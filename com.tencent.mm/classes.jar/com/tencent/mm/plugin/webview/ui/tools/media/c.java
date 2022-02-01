package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.wm;
import com.tencent.mm.autogen.a.wm.a;
import com.tencent.mm.autogen.a.wp;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.f.s;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoTransmit;", "", "()V", "TAG", "", "doSendAppMsg", "", "data", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "", "toUser", "msgInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "appendText", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Landroid/os/Bundle;", "transmitMpVideoMsg", "context", "Landroid/content/Context;", "imgUrl", "desc", "title", "url", "fromScene", "", "IPCInvoke_SendAppMsg", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private static final String TAG;
  public static final c Xmk;
  
  static
  {
    AppMethodBeat.i(82657);
    Xmk = new c();
    TAG = "MicroMsg.MPVideoTransmit";
    AppMethodBeat.o(82657);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(82654);
    s.u(paramContext, "context");
    HashMap localHashMap = new HashMap();
    Map localMap = (Map)localHashMap;
    paramString1 = Util.nullAsNil(paramString1);
    s.s(paramString1, "nullAsNil(imgUrl)");
    localMap.put("img_url", paramString1);
    paramString1 = (Map)localHashMap;
    paramString2 = Util.nullAsNil(paramString2);
    s.s(paramString2, "nullAsNil(desc)");
    paramString1.put("desc", paramString2);
    paramString1 = (Map)localHashMap;
    paramString2 = Util.nullAsNil(paramString3);
    s.s(paramString2, "nullAsNil(title)");
    paramString1.put("title", paramString2);
    paramString1 = (Map)localHashMap;
    paramString2 = Util.nullAs(paramString4, f.s.adwM);
    s.s(paramString2, "nullAs(url, ConstantsUI.…ewUI.MP_VIDEO_UPDATE_URL)");
    paramString1.put("url", paramString2);
    Log.i(TAG, "transmitMpVideoMsg, img_url=%s, desc=%s, title=%s, url=%s", new Object[] { localHashMap.get("img_url"), localHashMap.get("desc"), localHashMap.get("title"), paramString4 });
    paramString1 = new Intent();
    paramString1.putExtra("Select_Conv_Type", 3);
    paramString1.putExtra("scene_from", paramInt);
    paramString1.putExtra("is_mp_video", true);
    paramString1.putExtra("Retr_Msg_Type", 1);
    paramString1.putExtra("mutil_select_is_ret", true);
    paramString1.putExtra("webview_params", (Serializable)localHashMap);
    com.tencent.mm.br.c.d(paramContext, ".ui.transmit.SelectConversationUI", paramString1, 203);
    AppMethodBeat.o(82654);
  }
  
  public static boolean a(MpVideoDataParcelable paramMpVideoDataParcelable)
  {
    AppMethodBeat.i(82656);
    s.u(paramMpVideoDataParcelable, "data");
    Object localObject1 = paramMpVideoDataParcelable.Xmn;
    if (localObject1 == null)
    {
      Log.w(TAG, "doSendAppMsg msgInfo is null");
      AppMethodBeat.o(82656);
      return false;
    }
    Object localObject2 = new com.tencent.mm.pluginsdk.model.app.ad();
    ((com.tencent.mm.pluginsdk.model.app.ad)localObject2).webpageUrl = ((com.tencent.mm.message.y)localObject1).url;
    Object localObject3 = new WXMediaMessage();
    ((WXMediaMessage)localObject3).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
    ((WXMediaMessage)localObject3).title = ((com.tencent.mm.message.y)localObject1).title;
    com.tencent.mm.plugin.webview.a.a.au(new c..ExternalSyntheticLambda0((com.tencent.mm.message.y)localObject1));
    localObject2 = new wm();
    ((wm)localObject2).hZZ.hzF = ((WXMediaMessage)localObject3);
    ((wm)localObject2).hZZ.toUser = paramMpVideoDataParcelable.toUser;
    ((wm)localObject2).hZZ.hKZ = 2;
    ((wm)localObject2).hZZ.iaa = ((com.tencent.mm.message.y)localObject1).hEE;
    ((wm)localObject2).hZZ.iab = ((com.tencent.mm.message.y)localObject1).nUF;
    try
    {
      ((wm)localObject2).hZZ.iag = Util.nullAsNil(((com.tencent.mm.message.y)localObject1).mso);
      localObject3 = com.tencent.mm.model.ad.Jo(((wm)localObject2).hZZ.iag);
      ad.b localb = com.tencent.mm.model.ad.bCb().M((String)localObject3, true);
      s.checkNotNull(localb);
      localb.q("sendAppMsgScene", Integer.valueOf(2));
      localb.q("preChatName", ((com.tencent.mm.message.y)localObject1).iiu);
      localb.q("prePublishId", ((com.tencent.mm.message.y)localObject1).mso);
      localb.q("preUsername", ((com.tencent.mm.message.y)localObject1).iit);
      localb.q("_DATA_CENTER_ITEM_SHOW_TYPE", Integer.valueOf(-1));
      localb.q("_tmpl_webview_transfer_scene", Integer.valueOf(11));
      localb.q("_DATA_CENTER_VID", ((com.tencent.mm.message.y)localObject1).YMn);
      localb.q("_DATA_CENTER__DULATION", Integer.valueOf(((com.tencent.mm.message.y)localObject1).videoDuration));
      localb.q("_DATA_CENTER_VIDEO_WIDTH", Integer.valueOf(((com.tencent.mm.message.y)localObject1).width));
      localb.q("_DATA_CENTER_VIDEO_HEIGHT", Integer.valueOf(((com.tencent.mm.message.y)localObject1).height));
      localb.q("_DATA_CENTER_COVER_URL", ((com.tencent.mm.message.y)localObject1).nUM);
      localb.q("_DATA_CENTER_VIDEO_PLAY_URL", ((com.tencent.mm.message.y)localObject1).videoUrl);
      localb.q("_DATA_CENTER_VIDEO_MP_URL", ((com.tencent.mm.message.y)localObject1).YMm);
      localb.q("_DATA_CENTER_IS_MP_SHARE_VIDEO", Boolean.TRUE);
      ((wm)localObject2).hZZ.sessionId = ((String)localObject3);
      boolean bool = ((wm)localObject2).publish();
      if (!Util.isNullOrNil(paramMpVideoDataParcelable.suZ))
      {
        localObject1 = new wp();
        ((wp)localObject1).iak.hgl = paramMpVideoDataParcelable.toUser;
        ((wp)localObject1).iak.content = paramMpVideoDataParcelable.suZ;
        ((wp)localObject1).iak.type = ab.IX(paramMpVideoDataParcelable.toUser);
        ((wp)localObject1).iak.flags = 0;
        ((wp)localObject1).publish();
      }
      AppMethodBeat.o(82656);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e(TAG, "init bunddata failed : %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  private static final void b(com.tencent.mm.message.y paramy)
  {
    AppMethodBeat.i(296737);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("MpShareVideoImage", 2);
    byte[] arrayOfByte = localMultiProcessMMKV.decodeBytes(paramy.YMn);
    paramy = com.tencent.mm.pluginsdk.model.y.bpF(paramy.nUM);
    if (arrayOfByte != null) {
      com.tencent.mm.vfs.y.f(paramy, arrayOfByte, arrayOfByte.length);
    }
    localMultiProcessMMKV.clearAll();
    AppMethodBeat.o(296737);
  }
  
  public static void b(String paramString1, com.tencent.mm.message.y paramy, String paramString2, f<Bundle> paramf)
  {
    AppMethodBeat.i(82655);
    s.u(paramString1, "toUser");
    s.u(paramy, "msgInfo");
    s.u(paramf, "callback");
    MpVideoDataParcelable localMpVideoDataParcelable = new MpVideoDataParcelable();
    localMpVideoDataParcelable.toUser = paramString1;
    localMpVideoDataParcelable.suZ = paramString2;
    localMpVideoDataParcelable.Xmn = paramy;
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localMpVideoDataParcelable, a.class, paramf);
    AppMethodBeat.o(82655);
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoTransmit$IPCInvoke_SendAppMsg;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements d<MpVideoDataParcelable, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.c
 * JD-Core Version:    0.7.0.1
 */