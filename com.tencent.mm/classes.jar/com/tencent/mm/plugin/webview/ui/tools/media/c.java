package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sh;
import com.tencent.mm.g.a.sh.a;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.model.app.z;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoTransmit;", "", "()V", "TAG", "", "doSendAppMsg", "", "data", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "", "toUser", "msgInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "appendText", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Landroid/os/Bundle;", "transmitMpVideoMsg", "context", "Landroid/content/Context;", "imgUrl", "desc", "title", "url", "fromScene", "", "IPCInvoke_SendAppMsg", "plugin-webview_release"})
public final class c
{
  public static final c CKY;
  private static final String TAG = "MicroMsg.MPVideoTransmit";
  
  static
  {
    AppMethodBeat.i(82657);
    CKY = new c();
    TAG = "MicroMsg.MPVideoTransmit";
    AppMethodBeat.o(82657);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(82654);
    k.h(paramContext, "context");
    HashMap localHashMap = new HashMap();
    Map localMap = (Map)localHashMap;
    paramString1 = bs.nullAsNil(paramString1);
    k.g(paramString1, "Util.nullAsNil(imgUrl)");
    localMap.put("img_url", paramString1);
    paramString1 = (Map)localHashMap;
    paramString2 = bs.nullAsNil(paramString2);
    k.g(paramString2, "Util.nullAsNil(desc)");
    paramString1.put("desc", paramString2);
    paramString1 = (Map)localHashMap;
    paramString2 = bs.nullAsNil(paramString3);
    k.g(paramString2, "Util.nullAsNil(title)");
    paramString1.put("title", paramString2);
    paramString1 = (Map)localHashMap;
    paramString2 = bs.bG(paramString4, "https://support.weixin.qq.com/update/");
    k.g(paramString2, "Util.nullAs(url, Constan…ewUI.MP_VIDEO_UPDATE_URL)");
    paramString1.put("url", paramString2);
    ac.i(TAG, "transmitMpVideoMsg, img_url=%s, desc=%s, title=%s, url=%s", new Object[] { localHashMap.get("img_url"), localHashMap.get("desc"), localHashMap.get("title"), paramString4 });
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
    k.h(paramMpVideoDataParcelable, "data");
    Object localObject1 = paramMpVideoDataParcelable.CLe;
    if (localObject1 == null)
    {
      ac.w(TAG, "doSendAppMsg msgInfo is null");
      AppMethodBeat.o(82656);
      return false;
    }
    Object localObject2 = new z();
    ((z)localObject2).webpageUrl = ((com.tencent.mm.ah.y)localObject1).url;
    Object localObject3 = new WXMediaMessage();
    ((WXMediaMessage)localObject3).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
    ((WXMediaMessage)localObject3).title = ((com.tencent.mm.ah.y)localObject1).title;
    com.tencent.mm.plugin.webview.a.a.ag((Runnable)new b((com.tencent.mm.ah.y)localObject1));
    localObject2 = new sh();
    ((sh)localObject2).dvk.dis = ((WXMediaMessage)localObject3);
    ((sh)localObject2).dvk.toUser = paramMpVideoDataParcelable.toUser;
    ((sh)localObject2).dvk.dit = 2;
    ((sh)localObject2).dvk.dvl = ((com.tencent.mm.ah.y)localObject1).ddo;
    ((sh)localObject2).dvk.dvm = ((com.tencent.mm.ah.y)localObject1).hkV;
    try
    {
      ((sh)localObject2).dvk.dvr = bs.nullAsNil(((com.tencent.mm.ah.y)localObject1).hkW);
      localObject3 = com.tencent.mm.model.y.xJ(((sh)localObject2).dvk.dvr);
      y.b localb = com.tencent.mm.model.y.ayq().F((String)localObject3, true);
      if (localb == null) {
        k.fOy();
      }
      localb.l("sendAppMsgScene", Integer.valueOf(2));
      localb.l("preChatName", ((com.tencent.mm.ah.y)localObject1).dCl);
      localb.l("prePublishId", ((com.tencent.mm.ah.y)localObject1).hkW);
      localb.l("preUsername", ((com.tencent.mm.ah.y)localObject1).dCk);
      localb.l("_DATA_CENTER_ITEM_SHOW_TYPE", Integer.valueOf(-1));
      localb.l("_tmpl_webview_transfer_scene", Integer.valueOf(11));
      localb.l("_DATA_CENTER_VID", ((com.tencent.mm.ah.y)localObject1).DWG);
      localb.l("_DATA_CENTER__DULATION", Integer.valueOf(((com.tencent.mm.ah.y)localObject1).videoDuration));
      localb.l("_DATA_CENTER_VIDEO_WIDTH", Integer.valueOf(((com.tencent.mm.ah.y)localObject1).width));
      localb.l("_DATA_CENTER_VIDEO_HEIGHT", Integer.valueOf(((com.tencent.mm.ah.y)localObject1).height));
      localb.l("_DATA_CENTER_COVER_URL", ((com.tencent.mm.ah.y)localObject1).hld);
      localb.l("_DATA_CENTER_VIDEO_PLAY_URL", ((com.tencent.mm.ah.y)localObject1).videoUrl);
      localb.l("_DATA_CENTER_VIDEO_MP_URL", ((com.tencent.mm.ah.y)localObject1).DWF);
      localb.l("_DATA_CENTER_IS_MP_SHARE_VIDEO", Boolean.TRUE);
      ((sh)localObject2).dvk.sessionId = ((String)localObject3);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool;
        ac.e(TAG, "init bunddata failed : %s", new Object[] { localException.getMessage() });
      }
    }
    bool = com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
    if (!bs.isNullOrNil(paramMpVideoDataParcelable.kLS))
    {
      localObject1 = new sk();
      ((sk)localObject1).dvv.dvw = paramMpVideoDataParcelable.toUser;
      ((sk)localObject1).dvv.content = paramMpVideoDataParcelable.kLS;
      ((sk)localObject1).dvv.type = w.xt(paramMpVideoDataParcelable.toUser);
      ((sk)localObject1).dvv.flags = 0;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
    }
    AppMethodBeat.o(82656);
    return bool;
  }
  
  public static void b(String paramString1, com.tencent.mm.ah.y paramy, String paramString2, com.tencent.mm.ipcinvoker.d<Bundle> paramd)
  {
    AppMethodBeat.i(82655);
    k.h(paramString1, "toUser");
    k.h(paramy, "msgInfo");
    k.h(paramd, "callback");
    MpVideoDataParcelable localMpVideoDataParcelable = new MpVideoDataParcelable();
    localMpVideoDataParcelable.toUser = paramString1;
    localMpVideoDataParcelable.kLS = paramString2;
    localMpVideoDataParcelable.CLe = paramy;
    h.a("com.tencent.mm", (Parcelable)localMpVideoDataParcelable, a.class, paramd);
    AppMethodBeat.o(82655);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoTransmit$IPCInvoke_SendAppMsg;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"})
  static final class a
    implements com.tencent.mm.ipcinvoker.b<MpVideoDataParcelable, Bundle>
  {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(com.tencent.mm.ah.y paramy) {}
    
    public final void run()
    {
      AppMethodBeat.i(82653);
      aw localaw = aw.fK("MpShareVideoImage", 2);
      byte[] arrayOfByte = localaw.decodeBytes(this.CKZ.DWG);
      String str = r.aGc(this.CKZ.hld);
      if (arrayOfByte != null) {
        i.B(str, arrayOfByte);
      }
      localaw.clearAll();
      AppMethodBeat.o(82653);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.c
 * JD-Core Version:    0.7.0.1
 */