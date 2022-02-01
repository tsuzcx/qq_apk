package com.tencent.mm.plugin.webview.ui.tools.media;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.webview.model.c;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpShareVideoMsgFav;", "", "()V", "TAG", "", "doFav", "", "msgInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "data", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "mpShareVideoInfo", "Lcom/tencent/mm/protocal/protobuf/BaseMpShareVideoInfo;", "IPCInvoke_Fav", "plugin-webview_release"})
public final class f
{
  public static final f EoS;
  private static final String TAG = "MicroMsg.MpShareVideoMsgFav";
  
  static
  {
    AppMethodBeat.i(82666);
    EoS = new f();
    TAG = "MicroMsg.MpShareVideoMsgFav";
    AppMethodBeat.o(82666);
  }
  
  public static void b(com.tencent.mm.ai.y paramy)
  {
    AppMethodBeat.i(82664);
    p.h(paramy, "msgInfo");
    MpVideoDataParcelable localMpVideoDataParcelable = new MpVideoDataParcelable();
    localMpVideoDataParcelable.EoU = paramy;
    h.a("com.tencent.mm", (Parcelable)localMpVideoDataParcelable, a.class, (d)b.EoT);
    AppMethodBeat.o(82664);
  }
  
  public static void d(jb paramjb)
  {
    AppMethodBeat.i(207612);
    if (paramjb == null)
    {
      ad.w(TAG, "doFav msgInfo is null");
      AppMethodBeat.o(207612);
      return;
    }
    cv localcv = new cv();
    Object localObject = com.tencent.mm.model.y.AH(bt.nullAsNil(paramjb.hDf));
    localObject = com.tencent.mm.model.y.aBq().F((String)localObject, true);
    if (localObject == null) {
      p.gfZ();
    }
    ((y.b)localObject).k("sendAppMsgScene", Integer.valueOf(2));
    ((y.b)localObject).k("preChatName", paramjb.dOy);
    ((y.b)localObject).k("prePublishId", paramjb.hDf);
    ((y.b)localObject).k("preUsername", paramjb.dOx);
    ((y.b)localObject).k("referUrl", paramjb.url);
    localcv.dnG.dnM = 36;
    c.a(localcv, paramjb);
    a.IbL.l((com.tencent.mm.sdk.b.b)localcv);
    AppMethodBeat.o(207612);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpShareVideoMsgFav$IPCInvoke_Fav;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"})
  static final class a
    implements com.tencent.mm.ipcinvoker.b<MpVideoDataParcelable, Bundle>
  {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class b<T>
    implements d<ResultType>
  {
    public static final b EoT;
    
    static
    {
      AppMethodBeat.i(82663);
      EoT = new b();
      AppMethodBeat.o(82663);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.f
 * JD-Core Version:    0.7.0.1
 */