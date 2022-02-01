package com.tencent.mm.plugin.webview.ui.tools.media;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.webview.model.c;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpShareVideoMsgFav;", "", "()V", "TAG", "", "doFav", "", "msgInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "data", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "IPCInvoke_Fav", "plugin-webview_release"})
public final class e
{
  public static final e BsW;
  private static final String TAG = "MicroMsg.MpShareVideoMsgFav";
  
  static
  {
    AppMethodBeat.i(82666);
    BsW = new e();
    TAG = "MicroMsg.MpShareVideoMsgFav";
    AppMethodBeat.o(82666);
  }
  
  public static void b(com.tencent.mm.ai.y paramy)
  {
    AppMethodBeat.i(82664);
    k.h(paramy, "msgInfo");
    MpVideoDataParcelable localMpVideoDataParcelable = new MpVideoDataParcelable();
    localMpVideoDataParcelable.BsY = paramy;
    h.a("com.tencent.mm", (Parcelable)localMpVideoDataParcelable, a.class, (d)b.BsX);
    AppMethodBeat.o(82664);
  }
  
  public static void b(MpVideoDataParcelable paramMpVideoDataParcelable)
  {
    AppMethodBeat.i(82665);
    k.h(paramMpVideoDataParcelable, "data");
    paramMpVideoDataParcelable = paramMpVideoDataParcelable.BsY;
    if (paramMpVideoDataParcelable == null)
    {
      ad.w(TAG, "doFav msgInfo is null");
      AppMethodBeat.o(82665);
      return;
    }
    cs localcs = new cs();
    Object localObject = com.tencent.mm.model.y.tD(bt.nullAsNil(paramMpVideoDataParcelable.gKw));
    localObject = com.tencent.mm.model.y.arz().E((String)localObject, true);
    if (localObject == null) {
      k.fvU();
    }
    ((y.b)localObject).m("sendAppMsgScene", Integer.valueOf(2));
    ((y.b)localObject).m("preChatName", paramMpVideoDataParcelable.dEz);
    ((y.b)localObject).m("prePublishId", paramMpVideoDataParcelable.gKw);
    ((y.b)localObject).m("preUsername", paramMpVideoDataParcelable.dEy);
    ((y.b)localObject).m("referUrl", paramMpVideoDataParcelable.url);
    localcs.deQ.deW = 36;
    c.a(localcs, paramMpVideoDataParcelable);
    a.ESL.l((com.tencent.mm.sdk.b.b)localcs);
    AppMethodBeat.o(82665);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpShareVideoMsgFav$IPCInvoke_Fav;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"})
  static final class a
    implements com.tencent.mm.ipcinvoker.b<MpVideoDataParcelable, Bundle>
  {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class b<T>
    implements d<ResultType>
  {
    public static final b BsX;
    
    static
    {
      AppMethodBeat.i(82663);
      BsX = new b();
      AppMethodBeat.o(82663);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.e
 * JD-Core Version:    0.7.0.1
 */