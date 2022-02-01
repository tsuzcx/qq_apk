package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.g.a.ry.a;
import com.tencent.mm.g.a.sb;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.model.app.z;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoTransmit;", "", "()V", "TAG", "", "doSendAppMsg", "", "data", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "", "toUser", "msgInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "appendText", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Landroid/os/Bundle;", "transmitMpVideoMsg", "context", "Landroid/content/Context;", "imgUrl", "desc", "title", "url", "fromScene", "", "IPCInvoke_SendAppMsg", "plugin-webview_release"})
public final class c
{
  public static final c BsS;
  private static final String TAG = "MicroMsg.MPVideoTransmit";
  
  static
  {
    AppMethodBeat.i(82657);
    BsS = new c();
    TAG = "MicroMsg.MPVideoTransmit";
    AppMethodBeat.o(82657);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(82654);
    k.h(paramContext, "context");
    HashMap localHashMap = new HashMap();
    Map localMap = (Map)localHashMap;
    paramString1 = bt.nullAsNil(paramString1);
    k.g(paramString1, "Util.nullAsNil(imgUrl)");
    localMap.put("img_url", paramString1);
    paramString1 = (Map)localHashMap;
    paramString2 = bt.nullAsNil(paramString2);
    k.g(paramString2, "Util.nullAsNil(desc)");
    paramString1.put("desc", paramString2);
    paramString1 = (Map)localHashMap;
    paramString2 = bt.nullAsNil(paramString3);
    k.g(paramString2, "Util.nullAsNil(title)");
    paramString1.put("title", paramString2);
    paramString1 = (Map)localHashMap;
    paramString2 = bt.by(paramString4, "https://support.weixin.qq.com/update/");
    k.g(paramString2, "Util.nullAs(url, Constan…ewUI.MP_VIDEO_UPDATE_URL)");
    paramString1.put("url", paramString2);
    ad.i(TAG, "transmitMpVideoMsg, img_url=%s, desc=%s, title=%s, url=%s", new Object[] { localHashMap.get("img_url"), localHashMap.get("desc"), localHashMap.get("title"), paramString4 });
    paramString1 = new Intent();
    paramString1.putExtra("Select_Conv_Type", 3);
    paramString1.putExtra("scene_from", paramInt);
    paramString1.putExtra("is_mp_video", true);
    paramString1.putExtra("Retr_Msg_Type", 1);
    paramString1.putExtra("mutil_select_is_ret", true);
    paramString1.putExtra("webview_params", (Serializable)localHashMap);
    com.tencent.mm.bs.d.c(paramContext, ".ui.transmit.SelectConversationUI", paramString1, 3);
    AppMethodBeat.o(82654);
  }
  
  public static boolean a(MpVideoDataParcelable paramMpVideoDataParcelable)
  {
    AppMethodBeat.i(82656);
    k.h(paramMpVideoDataParcelable, "data");
    Object localObject1 = paramMpVideoDataParcelable.BsY;
    if (localObject1 == null)
    {
      ad.w(TAG, "doSendAppMsg msgInfo is null");
      AppMethodBeat.o(82656);
      return false;
    }
    Object localObject2 = new z();
    ((z)localObject2).webpageUrl = ((com.tencent.mm.ai.y)localObject1).url;
    Object localObject3 = new WXMediaMessage();
    ((WXMediaMessage)localObject3).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
    ((WXMediaMessage)localObject3).title = ((com.tencent.mm.ai.y)localObject1).title;
    com.tencent.mm.plugin.webview.a.a.ae((Runnable)new b((com.tencent.mm.ai.y)localObject1));
    localObject2 = new ry();
    ((ry)localObject2).dxx.doG = ((WXMediaMessage)localObject3);
    ((ry)localObject2).dxx.toUser = paramMpVideoDataParcelable.toUser;
    ((ry)localObject2).dxx.dxy = 2;
    ((ry)localObject2).dxx.dxz = ((com.tencent.mm.ai.y)localObject1).dfT;
    ((ry)localObject2).dxx.dxA = ((com.tencent.mm.ai.y)localObject1).gKv;
    try
    {
      ((ry)localObject2).dxx.dxF = bt.nullAsNil(((com.tencent.mm.ai.y)localObject1).gKw);
      localObject3 = com.tencent.mm.model.y.tD(((ry)localObject2).dxx.dxF);
      y.b localb = com.tencent.mm.model.y.arz().E((String)localObject3, true);
      if (localb == null) {
        k.fvU();
      }
      localb.m("sendAppMsgScene", Integer.valueOf(2));
      localb.m("preChatName", ((com.tencent.mm.ai.y)localObject1).dEz);
      localb.m("prePublishId", ((com.tencent.mm.ai.y)localObject1).gKw);
      localb.m("preUsername", ((com.tencent.mm.ai.y)localObject1).dEy);
      localb.m("_DATA_CENTER_ITEM_SHOW_TYPE", Integer.valueOf(-1));
      localb.m("_tmpl_webview_transfer_scene", Integer.valueOf(11));
      localb.m("_DATA_CENTER_VID", ((com.tencent.mm.ai.y)localObject1).CEg);
      localb.m("_DATA_CENTER__DULATION", Integer.valueOf(((com.tencent.mm.ai.y)localObject1).videoDuration));
      localb.m("_DATA_CENTER_VIDEO_WIDTH", Integer.valueOf(((com.tencent.mm.ai.y)localObject1).width));
      localb.m("_DATA_CENTER_VIDEO_HEIGHT", Integer.valueOf(((com.tencent.mm.ai.y)localObject1).height));
      localb.m("_DATA_CENTER_COVER_URL", ((com.tencent.mm.ai.y)localObject1).gKD);
      localb.m("_DATA_CENTER_VIDEO_PLAY_URL", ((com.tencent.mm.ai.y)localObject1).videoUrl);
      localb.m("_DATA_CENTER_VIDEO_MP_URL", ((com.tencent.mm.ai.y)localObject1).CEf);
      localb.m("_DATA_CENTER_IS_MP_SHARE_VIDEO", Boolean.TRUE);
      ((ry)localObject2).dxx.sessionId = ((String)localObject3);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool;
        ad.e(TAG, "init bunddata failed : %s", new Object[] { localException.getMessage() });
      }
    }
    bool = com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
    if (!bt.isNullOrNil(paramMpVideoDataParcelable.kkB))
    {
      localObject1 = new sb();
      ((sb)localObject1).dxJ.dxK = paramMpVideoDataParcelable.toUser;
      ((sb)localObject1).dxJ.content = paramMpVideoDataParcelable.kkB;
      ((sb)localObject1).dxJ.type = w.tq(paramMpVideoDataParcelable.toUser);
      ((sb)localObject1).dxJ.flags = 0;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
    }
    AppMethodBeat.o(82656);
    return bool;
  }
  
  public static void b(String paramString1, com.tencent.mm.ai.y paramy, String paramString2, com.tencent.mm.ipcinvoker.d<Bundle> paramd)
  {
    AppMethodBeat.i(82655);
    k.h(paramString1, "toUser");
    k.h(paramy, "msgInfo");
    k.h(paramd, "callback");
    MpVideoDataParcelable localMpVideoDataParcelable = new MpVideoDataParcelable();
    localMpVideoDataParcelable.toUser = paramString1;
    localMpVideoDataParcelable.kkB = paramString2;
    localMpVideoDataParcelable.BsY = paramy;
    h.a("com.tencent.mm", (Parcelable)localMpVideoDataParcelable, a.class, paramd);
    AppMethodBeat.o(82655);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoTransmit$IPCInvoke_SendAppMsg;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"})
  static final class a
    implements com.tencent.mm.ipcinvoker.b<MpVideoDataParcelable, Bundle>
  {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(com.tencent.mm.ai.y paramy) {}
    
    public final void run()
    {
      AppMethodBeat.i(82653);
      ax localax = ax.fF("MpShareVideoImage", 2);
      byte[] arrayOfByte = localax.decodeBytes(this.BsT.CEg);
      String str = r.aAK(this.BsT.gKD);
      if (arrayOfByte != null) {
        i.B(str, arrayOfByte);
      }
      localax.clearAll();
      AppMethodBeat.o(82653);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.c
 * JD-Core Version:    0.7.0.1
 */