package com.tencent.mm.plugin.webview.ui.tools.media;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.y;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.webview.model.c;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpShareVideoMsgFav;", "", "()V", "TAG", "", "doFav", "", "msgInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "data", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "mpShareVideoInfo", "Lcom/tencent/mm/protocal/protobuf/BaseMpShareVideoInfo;", "IPCInvoke_Fav", "plugin-webview_release"})
public final class f
{
  public static final f JwB;
  private static final String TAG = "MicroMsg.MpShareVideoMsgFav";
  
  static
  {
    AppMethodBeat.i(82666);
    JwB = new f();
    TAG = "MicroMsg.MpShareVideoMsgFav";
    AppMethodBeat.o(82666);
  }
  
  public static void b(y paramy)
  {
    AppMethodBeat.i(82664);
    p.h(paramy, "msgInfo");
    MpVideoDataParcelable localMpVideoDataParcelable = new MpVideoDataParcelable();
    localMpVideoDataParcelable.JwD = paramy;
    h.a(MainProcessIPCService.dkO, (Parcelable)localMpVideoDataParcelable, a.class, (d)b.JwC);
    AppMethodBeat.o(82664);
  }
  
  public static void d(jo paramjo)
  {
    AppMethodBeat.i(210562);
    if (paramjo == null)
    {
      Log.w(TAG, "doFav msgInfo is null");
      AppMethodBeat.o(210562);
      return;
    }
    cz localcz = new cz();
    Object localObject = ad.JX(Util.nullAsNil(paramjo.iAh));
    localObject = ad.aVe().G((String)localObject, true);
    if (localObject == null) {
      p.hyc();
    }
    ((ad.b)localObject).l("sendAppMsgScene", Integer.valueOf(2));
    ((ad.b)localObject).l("preChatName", paramjo.ehR);
    ((ad.b)localObject).l("prePublishId", paramjo.iAh);
    ((ad.b)localObject).l("preUsername", paramjo.ehQ);
    ((ad.b)localObject).l("referUrl", paramjo.url);
    localcz.dFZ.dGf = 36;
    c.a(localcz, paramjo);
    EventCenter.instance.publish((IEvent)localcz);
    AppMethodBeat.o(210562);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpShareVideoMsgFav$IPCInvoke_Fav;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"})
  static final class a
    implements b<MpVideoDataParcelable, Bundle>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class b<T>
    implements d<ResultType>
  {
    public static final b JwC;
    
    static
    {
      AppMethodBeat.i(82663);
      JwC = new b();
      AppMethodBeat.o(82663);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.f
 * JD-Core Version:    0.7.0.1
 */