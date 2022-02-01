package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.y;
import com.tencent.mm.g.a.sv;
import com.tencent.mm.g.a.sv.a;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoTransmit;", "", "()V", "TAG", "", "doSendAppMsg", "", "data", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "", "toUser", "msgInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "appendText", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Landroid/os/Bundle;", "transmitMpVideoMsg", "context", "Landroid/content/Context;", "imgUrl", "desc", "title", "url", "fromScene", "", "IPCInvoke_SendAppMsg", "plugin-webview_release"})
public final class d
{
  public static final d EGT;
  private static final String TAG = "MicroMsg.MPVideoTransmit";
  
  static
  {
    AppMethodBeat.i(82657);
    EGT = new d();
    TAG = "MicroMsg.MPVideoTransmit";
    AppMethodBeat.o(82657);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(82654);
    p.h(paramContext, "context");
    HashMap localHashMap = new HashMap();
    Map localMap = (Map)localHashMap;
    paramString1 = bu.nullAsNil(paramString1);
    p.g(paramString1, "Util.nullAsNil(imgUrl)");
    localMap.put("img_url", paramString1);
    paramString1 = (Map)localHashMap;
    paramString2 = bu.nullAsNil(paramString2);
    p.g(paramString2, "Util.nullAsNil(desc)");
    paramString1.put("desc", paramString2);
    paramString1 = (Map)localHashMap;
    paramString2 = bu.nullAsNil(paramString3);
    p.g(paramString2, "Util.nullAsNil(title)");
    paramString1.put("title", paramString2);
    paramString1 = (Map)localHashMap;
    paramString2 = bu.bI(paramString4, "https://support.weixin.qq.com/update/");
    p.g(paramString2, "Util.nullAs(url, Constan…ewUI.MP_VIDEO_UPDATE_URL)");
    paramString1.put("url", paramString2);
    ae.i(TAG, "transmitMpVideoMsg, img_url=%s, desc=%s, title=%s, url=%s", new Object[] { localHashMap.get("img_url"), localHashMap.get("desc"), localHashMap.get("title"), paramString4 });
    paramString1 = new Intent();
    paramString1.putExtra("Select_Conv_Type", 3);
    paramString1.putExtra("scene_from", paramInt);
    paramString1.putExtra("is_mp_video", true);
    paramString1.putExtra("Retr_Msg_Type", 1);
    paramString1.putExtra("mutil_select_is_ret", true);
    paramString1.putExtra("webview_params", (Serializable)localHashMap);
    com.tencent.mm.br.d.c(paramContext, ".ui.transmit.SelectConversationUI", paramString1, 3);
    AppMethodBeat.o(82654);
  }
  
  public static boolean a(MpVideoDataParcelable paramMpVideoDataParcelable)
  {
    AppMethodBeat.i(82656);
    p.h(paramMpVideoDataParcelable, "data");
    Object localObject1 = paramMpVideoDataParcelable.EGZ;
    if (localObject1 == null)
    {
      ae.w(TAG, "doSendAppMsg msgInfo is null");
      AppMethodBeat.o(82656);
      return false;
    }
    Object localObject2 = new com.tencent.mm.pluginsdk.model.app.z();
    ((com.tencent.mm.pluginsdk.model.app.z)localObject2).webpageUrl = ((y)localObject1).url;
    Object localObject3 = new WXMediaMessage();
    ((WXMediaMessage)localObject3).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
    ((WXMediaMessage)localObject3).title = ((y)localObject1).title;
    com.tencent.mm.plugin.webview.a.a.ad((Runnable)new b((y)localObject1));
    localObject2 = new sv();
    ((sv)localObject2).dIs.dve = ((WXMediaMessage)localObject3);
    ((sv)localObject2).dIs.toUser = paramMpVideoDataParcelable.toUser;
    ((sv)localObject2).dIs.dvf = 2;
    ((sv)localObject2).dIs.dIt = ((y)localObject1).dpP;
    ((sv)localObject2).dIs.dIu = ((y)localObject1).hFW;
    try
    {
      ((sv)localObject2).dIs.dIz = bu.nullAsNil(((y)localObject1).hFX);
      localObject3 = com.tencent.mm.model.z.Br(((sv)localObject2).dIs.dIz);
      z.b localb = com.tencent.mm.model.z.aBG().F((String)localObject3, true);
      if (localb == null) {
        p.gkB();
      }
      localb.k("sendAppMsgScene", Integer.valueOf(2));
      localb.k("preChatName", ((y)localObject1).dPO);
      localb.k("prePublishId", ((y)localObject1).hFX);
      localb.k("preUsername", ((y)localObject1).dPN);
      localb.k("_DATA_CENTER_ITEM_SHOW_TYPE", Integer.valueOf(-1));
      localb.k("_tmpl_webview_transfer_scene", Integer.valueOf(11));
      localb.k("_DATA_CENTER_VID", ((y)localObject1).FUx);
      localb.k("_DATA_CENTER__DULATION", Integer.valueOf(((y)localObject1).videoDuration));
      localb.k("_DATA_CENTER_VIDEO_WIDTH", Integer.valueOf(((y)localObject1).width));
      localb.k("_DATA_CENTER_VIDEO_HEIGHT", Integer.valueOf(((y)localObject1).height));
      localb.k("_DATA_CENTER_COVER_URL", ((y)localObject1).hGe);
      localb.k("_DATA_CENTER_VIDEO_PLAY_URL", ((y)localObject1).videoUrl);
      localb.k("_DATA_CENTER_VIDEO_MP_URL", ((y)localObject1).FUw);
      localb.k("_DATA_CENTER_IS_MP_SHARE_VIDEO", Boolean.TRUE);
      ((sv)localObject2).dIs.sessionId = ((String)localObject3);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool;
        ae.e(TAG, "init bunddata failed : %s", new Object[] { localException.getMessage() });
      }
    }
    bool = com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
    if (!bu.isNullOrNil(paramMpVideoDataParcelable.lmh))
    {
      localObject1 = new sy();
      ((sy)localObject1).dID.cUB = paramMpVideoDataParcelable.toUser;
      ((sy)localObject1).dID.content = paramMpVideoDataParcelable.lmh;
      ((sy)localObject1).dID.type = x.Bb(paramMpVideoDataParcelable.toUser);
      ((sy)localObject1).dID.flags = 0;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
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
    localMpVideoDataParcelable.lmh = paramString2;
    localMpVideoDataParcelable.EGZ = paramy;
    h.a("com.tencent.mm", (Parcelable)localMpVideoDataParcelable, a.class, paramd);
    AppMethodBeat.o(82655);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoTransmit$IPCInvoke_SendAppMsg;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"})
  static final class a
    implements com.tencent.mm.ipcinvoker.b<MpVideoDataParcelable, Bundle>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(y paramy) {}
    
    public final void run()
    {
      AppMethodBeat.i(82653);
      ay localay = ay.gq("MpShareVideoImage", 2);
      byte[] arrayOfByte = localay.decodeBytes(this.EGU.FUx);
      String str = r.aMY(this.EGU.hGe);
      if (arrayOfByte != null) {
        o.C(str, arrayOfByte);
      }
      localay.clearAll();
      AppMethodBeat.o(82653);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.d
 * JD-Core Version:    0.7.0.1
 */