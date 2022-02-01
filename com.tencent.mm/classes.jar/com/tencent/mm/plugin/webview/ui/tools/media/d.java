package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.y;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tt.a;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.pluginsdk.model.app.z;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.e.p;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoTransmit;", "", "()V", "TAG", "", "doSendAppMsg", "", "data", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "", "toUser", "msgInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "appendText", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Landroid/os/Bundle;", "transmitMpVideoMsg", "context", "Landroid/content/Context;", "imgUrl", "desc", "title", "url", "fromScene", "", "IPCInvoke_SendAppMsg", "plugin-webview_release"})
public final class d
{
  public static final d Jwx;
  private static final String TAG = "MicroMsg.MPVideoTransmit";
  
  static
  {
    AppMethodBeat.i(82657);
    Jwx = new d();
    TAG = "MicroMsg.MPVideoTransmit";
    AppMethodBeat.o(82657);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(82654);
    p.h(paramContext, "context");
    HashMap localHashMap = new HashMap();
    Map localMap = (Map)localHashMap;
    paramString1 = Util.nullAsNil(paramString1);
    p.g(paramString1, "Util.nullAsNil(imgUrl)");
    localMap.put("img_url", paramString1);
    paramString1 = (Map)localHashMap;
    paramString2 = Util.nullAsNil(paramString2);
    p.g(paramString2, "Util.nullAsNil(desc)");
    paramString1.put("desc", paramString2);
    paramString1 = (Map)localHashMap;
    paramString2 = Util.nullAsNil(paramString3);
    p.g(paramString2, "Util.nullAsNil(title)");
    paramString1.put("title", paramString2);
    paramString1 = (Map)localHashMap;
    paramString2 = Util.nullAs(paramString4, e.p.Ozp);
    p.g(paramString2, "Util.nullAs(url, Constan…ewUI.MP_VIDEO_UPDATE_URL)");
    paramString1.put("url", paramString2);
    Log.i(TAG, "transmitMpVideoMsg, img_url=%s, desc=%s, title=%s, url=%s", new Object[] { localHashMap.get("img_url"), localHashMap.get("desc"), localHashMap.get("title"), paramString4 });
    paramString1 = new Intent();
    paramString1.putExtra("Select_Conv_Type", 3);
    paramString1.putExtra("scene_from", paramInt);
    paramString1.putExtra("is_mp_video", true);
    paramString1.putExtra("Retr_Msg_Type", 1);
    paramString1.putExtra("mutil_select_is_ret", true);
    paramString1.putExtra("webview_params", (Serializable)localHashMap);
    c.c(paramContext, ".ui.transmit.SelectConversationUI", paramString1, 3);
    AppMethodBeat.o(82654);
  }
  
  public static boolean a(MpVideoDataParcelable paramMpVideoDataParcelable)
  {
    AppMethodBeat.i(82656);
    p.h(paramMpVideoDataParcelable, "data");
    Object localObject1 = paramMpVideoDataParcelable.JwD;
    if (localObject1 == null)
    {
      Log.w(TAG, "doSendAppMsg msgInfo is null");
      AppMethodBeat.o(82656);
      return false;
    }
    Object localObject2 = new z();
    ((z)localObject2).webpageUrl = ((y)localObject1).url;
    Object localObject3 = new WXMediaMessage();
    ((WXMediaMessage)localObject3).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
    ((WXMediaMessage)localObject3).title = ((y)localObject1).title;
    a.aj((Runnable)new b((y)localObject1));
    localObject2 = new tt();
    ((tt)localObject2).eaf.dCE = ((WXMediaMessage)localObject3);
    ((tt)localObject2).eaf.toUser = paramMpVideoDataParcelable.toUser;
    ((tt)localObject2).eaf.dMG = 2;
    ((tt)localObject2).eaf.eag = ((y)localObject1).dHc;
    ((tt)localObject2).eaf.eah = ((y)localObject1).iAg;
    try
    {
      ((tt)localObject2).eaf.eam = Util.nullAsNil(((y)localObject1).iAh);
      localObject3 = ad.JX(((tt)localObject2).eaf.eam);
      ad.b localb = ad.aVe().G((String)localObject3, true);
      if (localb == null) {
        p.hyc();
      }
      localb.l("sendAppMsgScene", Integer.valueOf(2));
      localb.l("preChatName", ((y)localObject1).ehR);
      localb.l("prePublishId", ((y)localObject1).iAh);
      localb.l("preUsername", ((y)localObject1).ehQ);
      localb.l("_DATA_CENTER_ITEM_SHOW_TYPE", Integer.valueOf(-1));
      localb.l("_tmpl_webview_transfer_scene", Integer.valueOf(11));
      localb.l("_DATA_CENTER_VID", ((y)localObject1).KOf);
      localb.l("_DATA_CENTER__DULATION", Integer.valueOf(((y)localObject1).videoDuration));
      localb.l("_DATA_CENTER_VIDEO_WIDTH", Integer.valueOf(((y)localObject1).width));
      localb.l("_DATA_CENTER_VIDEO_HEIGHT", Integer.valueOf(((y)localObject1).height));
      localb.l("_DATA_CENTER_COVER_URL", ((y)localObject1).iAo);
      localb.l("_DATA_CENTER_VIDEO_PLAY_URL", ((y)localObject1).videoUrl);
      localb.l("_DATA_CENTER_VIDEO_MP_URL", ((y)localObject1).KOe);
      localb.l("_DATA_CENTER_IS_MP_SHARE_VIDEO", Boolean.TRUE);
      ((tt)localObject2).eaf.sessionId = ((String)localObject3);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool;
        Log.e(TAG, "init bunddata failed : %s", new Object[] { localException.getMessage() });
      }
    }
    bool = EventCenter.instance.publish((IEvent)localObject2);
    if (!Util.isNullOrNil(paramMpVideoDataParcelable.msd))
    {
      localObject1 = new tw();
      ((tw)localObject1).eaq.dkV = paramMpVideoDataParcelable.toUser;
      ((tw)localObject1).eaq.content = paramMpVideoDataParcelable.msd;
      ((tw)localObject1).eaq.type = ab.JG(paramMpVideoDataParcelable.toUser);
      ((tw)localObject1).eaq.flags = 0;
      EventCenter.instance.publish((IEvent)localObject1);
    }
    AppMethodBeat.o(82656);
    return bool;
  }
  
  public static void b(String paramString1, y paramy, String paramString2, com.tencent.mm.ipcinvoker.d<Bundle> paramd)
  {
    AppMethodBeat.i(82655);
    p.h(paramString1, "toUser");
    p.h(paramy, "msgInfo");
    p.h(paramd, "callback");
    MpVideoDataParcelable localMpVideoDataParcelable = new MpVideoDataParcelable();
    localMpVideoDataParcelable.toUser = paramString1;
    localMpVideoDataParcelable.msd = paramString2;
    localMpVideoDataParcelable.JwD = paramy;
    h.a(MainProcessIPCService.dkO, (Parcelable)localMpVideoDataParcelable, a.class, paramd);
    AppMethodBeat.o(82655);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoTransmit$IPCInvoke_SendAppMsg;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"})
  static final class a
    implements b<MpVideoDataParcelable, Bundle>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(y paramy) {}
    
    public final void run()
    {
      AppMethodBeat.i(82653);
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("MpShareVideoImage", 2);
      byte[] arrayOfByte = localMultiProcessMMKV.decodeBytes(this.Jwy.KOf);
      String str = com.tencent.mm.pluginsdk.model.s.bdu(this.Jwy.iAo);
      if (arrayOfByte != null) {
        com.tencent.mm.vfs.s.C(str, arrayOfByte);
      }
      localMultiProcessMMKV.clearAll();
      AppMethodBeat.o(82653);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.d
 * JD-Core Version:    0.7.0.1
 */