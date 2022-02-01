package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.y;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.uw;
import com.tencent.mm.f.a.uw.a;
import com.tencent.mm.f.a.uz;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.model.app.z;
import com.tencent.mm.pluginsdk.model.w;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.f.r;
import com.tencent.mm.vfs.u;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoTransmit;", "", "()V", "TAG", "", "doSendAppMsg", "", "data", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "", "toUser", "msgInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "appendText", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Landroid/os/Bundle;", "transmitMpVideoMsg", "context", "Landroid/content/Context;", "imgUrl", "desc", "title", "url", "fromScene", "", "IPCInvoke_SendAppMsg", "plugin-webview_release"})
public final class d
{
  public static final d Qug;
  private static final String TAG = "MicroMsg.MPVideoTransmit";
  
  static
  {
    AppMethodBeat.i(82657);
    Qug = new d();
    TAG = "MicroMsg.MPVideoTransmit";
    AppMethodBeat.o(82657);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(82654);
    p.k(paramContext, "context");
    HashMap localHashMap = new HashMap();
    Map localMap = (Map)localHashMap;
    paramString1 = Util.nullAsNil(paramString1);
    p.j(paramString1, "Util.nullAsNil(imgUrl)");
    localMap.put("img_url", paramString1);
    paramString1 = (Map)localHashMap;
    paramString2 = Util.nullAsNil(paramString2);
    p.j(paramString2, "Util.nullAsNil(desc)");
    paramString1.put("desc", paramString2);
    paramString1 = (Map)localHashMap;
    paramString2 = Util.nullAsNil(paramString3);
    p.j(paramString2, "Util.nullAsNil(title)");
    paramString1.put("title", paramString2);
    paramString1 = (Map)localHashMap;
    paramString2 = Util.nullAs(paramString4, f.r.VSD);
    p.j(paramString2, "Util.nullAs(url, Constan…ewUI.MP_VIDEO_UPDATE_URL)");
    paramString1.put("url", paramString2);
    Log.i(TAG, "transmitMpVideoMsg, img_url=%s, desc=%s, title=%s, url=%s", new Object[] { localHashMap.get("img_url"), localHashMap.get("desc"), localHashMap.get("title"), paramString4 });
    paramString1 = new Intent();
    paramString1.putExtra("Select_Conv_Type", 3);
    paramString1.putExtra("scene_from", paramInt);
    paramString1.putExtra("is_mp_video", true);
    paramString1.putExtra("Retr_Msg_Type", 1);
    paramString1.putExtra("mutil_select_is_ret", true);
    paramString1.putExtra("webview_params", (Serializable)localHashMap);
    c.d(paramContext, ".ui.transmit.SelectConversationUI", paramString1, 3);
    AppMethodBeat.o(82654);
  }
  
  public static boolean a(MpVideoDataParcelable paramMpVideoDataParcelable)
  {
    AppMethodBeat.i(82656);
    p.k(paramMpVideoDataParcelable, "data");
    Object localObject1 = paramMpVideoDataParcelable.Qun;
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
    com.tencent.mm.plugin.webview.a.a.am((Runnable)new b((y)localObject1));
    localObject2 = new uw();
    ((uw)localObject2).fUc.fvl = ((WXMediaMessage)localObject3);
    ((uw)localObject2).fUc.toUser = paramMpVideoDataParcelable.toUser;
    ((uw)localObject2).fUc.fFO = 2;
    ((uw)localObject2).fUc.fUd = ((y)localObject1).fzT;
    ((uw)localObject2).fUc.fUe = ((y)localObject1).lpC;
    try
    {
      ((uw)localObject2).fUc.fUj = Util.nullAsNil(((y)localObject1).lpD);
      localObject3 = ad.Rp(((uw)localObject2).fUc.fUj);
      ad.b localb = ad.beh().I((String)localObject3, true);
      if (localb == null) {
        p.iCn();
      }
      localb.k("sendAppMsgScene", Integer.valueOf(2));
      localb.k("preChatName", ((y)localObject1).gci);
      localb.k("prePublishId", ((y)localObject1).lpD);
      localb.k("preUsername", ((y)localObject1).gch);
      localb.k("_DATA_CENTER_ITEM_SHOW_TYPE", Integer.valueOf(-1));
      localb.k("_tmpl_webview_transfer_scene", Integer.valueOf(11));
      localb.k("_DATA_CENTER_VID", ((y)localObject1).RPa);
      localb.k("_DATA_CENTER__DULATION", Integer.valueOf(((y)localObject1).videoDuration));
      localb.k("_DATA_CENTER_VIDEO_WIDTH", Integer.valueOf(((y)localObject1).width));
      localb.k("_DATA_CENTER_VIDEO_HEIGHT", Integer.valueOf(((y)localObject1).height));
      localb.k("_DATA_CENTER_COVER_URL", ((y)localObject1).lpK);
      localb.k("_DATA_CENTER_VIDEO_PLAY_URL", ((y)localObject1).videoUrl);
      localb.k("_DATA_CENTER_VIDEO_MP_URL", ((y)localObject1).ROZ);
      localb.k("_DATA_CENTER_IS_MP_SHARE_VIDEO", Boolean.TRUE);
      ((uw)localObject2).fUc.sessionId = ((String)localObject3);
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
    if (!Util.isNullOrNil(paramMpVideoDataParcelable.pqm))
    {
      localObject1 = new uz();
      ((uz)localObject1).fUn.fcD = paramMpVideoDataParcelable.toUser;
      ((uz)localObject1).fUn.content = paramMpVideoDataParcelable.pqm;
      ((uz)localObject1).fUn.type = ab.QZ(paramMpVideoDataParcelable.toUser);
      ((uz)localObject1).fUn.flags = 0;
      EventCenter.instance.publish((IEvent)localObject1);
    }
    AppMethodBeat.o(82656);
    return bool;
  }
  
  public static void b(String paramString1, y paramy, String paramString2, f<Bundle> paramf)
  {
    AppMethodBeat.i(82655);
    p.k(paramString1, "toUser");
    p.k(paramy, "msgInfo");
    p.k(paramf, "callback");
    MpVideoDataParcelable localMpVideoDataParcelable = new MpVideoDataParcelable();
    localMpVideoDataParcelable.toUser = paramString1;
    localMpVideoDataParcelable.pqm = paramString2;
    localMpVideoDataParcelable.Qun = paramy;
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localMpVideoDataParcelable, a.class, paramf);
    AppMethodBeat.o(82655);
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoTransmit$IPCInvoke_SendAppMsg;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"})
  static final class a
    implements com.tencent.mm.ipcinvoker.d<MpVideoDataParcelable, Bundle>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(y paramy) {}
    
    public final void run()
    {
      AppMethodBeat.i(82653);
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("MpShareVideoImage", 2);
      byte[] arrayOfByte = localMultiProcessMMKV.decodeBytes(this.Quh.RPa);
      String str = w.bpO(this.Quh.lpK);
      if (arrayOfByte != null) {
        u.H(str, arrayOfByte);
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