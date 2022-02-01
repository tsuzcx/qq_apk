package com.tencent.mm.plugin.webview.ui.tools.media;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.y;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.webview.model.c;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpShareVideoMsgFav;", "", "()V", "TAG", "", "doFav", "", "msgInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "data", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "mpShareVideoInfo", "Lcom/tencent/mm/protocal/protobuf/BaseMpShareVideoInfo;", "IPCInvoke_Fav", "plugin-webview_release"})
public final class f
{
  public static final f Quk;
  private static final String TAG = "MicroMsg.MpShareVideoMsgFav";
  
  static
  {
    AppMethodBeat.i(82666);
    Quk = new f();
    TAG = "MicroMsg.MpShareVideoMsgFav";
    AppMethodBeat.o(82666);
  }
  
  public static void b(y paramy)
  {
    AppMethodBeat.i(82664);
    p.k(paramy, "msgInfo");
    MpVideoDataParcelable localMpVideoDataParcelable = new MpVideoDataParcelable();
    localMpVideoDataParcelable.Qun = paramy;
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localMpVideoDataParcelable, a.class, (com.tencent.mm.ipcinvoker.f)b.Qul);
    AppMethodBeat.o(82664);
  }
  
  public static void d(jd paramjd)
  {
    AppMethodBeat.i(235248);
    if (paramjd == null)
    {
      Log.w(TAG, "doFav msgInfo is null");
      AppMethodBeat.o(235248);
      return;
    }
    dd localdd = new dd();
    Object localObject = ad.Rp(Util.nullAsNil(paramjd.lpD));
    localObject = ad.beh().I((String)localObject, true);
    if (localObject == null) {
      p.iCn();
    }
    ((ad.b)localObject).k("sendAppMsgScene", Integer.valueOf(2));
    ((ad.b)localObject).k("preChatName", paramjd.gci);
    ((ad.b)localObject).k("prePublishId", paramjd.lpD);
    ((ad.b)localObject).k("preUsername", paramjd.gch);
    ((ad.b)localObject).k("referUrl", paramjd.url);
    localdd.fyI.fyP = 36;
    c.a(localdd, paramjd);
    EventCenter.instance.publish((IEvent)localdd);
    AppMethodBeat.o(235248);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpShareVideoMsgFav$IPCInvoke_Fav;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"})
  static final class a
    implements d<MpVideoDataParcelable, Bundle>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class b<T>
    implements com.tencent.mm.ipcinvoker.f<ResultType>
  {
    public static final b Qul;
    
    static
    {
      AppMethodBeat.i(82663);
      Qul = new b();
      AppMethodBeat.o(82663);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.f
 * JD-Core Version:    0.7.0.1
 */