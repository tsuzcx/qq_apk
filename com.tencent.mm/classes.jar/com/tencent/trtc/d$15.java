package com.tencent.trtc;

import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.renderer.e;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.RenderInfo;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$15
  implements Runnable
{
  d$15(WXTRTCCloud paramWXTRTCCloud, String paramString, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(14307);
    WXTRTCCloud.access$3400(this.IIP, "seRemoteSubStreamSurfaceSize: " + this.a + ", " + this.b + "," + this.c);
    Object localObject = WXTRTCCloud.access$3500(this.IIP).getUser(this.a);
    if (localObject != null)
    {
      localObject = ((TRTCRoomInfo.UserInfo)localObject).subRender.render;
      if (localObject != null)
      {
        localObject = ((TXCRenderAndDec)localObject).getVideoRender();
        if (localObject != null)
        {
          ((e)localObject).c(this.b, this.c);
          AppMethodBeat.o(14307);
          return;
        }
        WXTRTCCloud.access$3600(this.IIP, "videoRender no exist");
        AppMethodBeat.o(14307);
        return;
      }
      WXTRTCCloud.access$3700(this.IIP, "render no exist");
      AppMethodBeat.o(14307);
      return;
    }
    WXTRTCCloud.access$3800(this.IIP, "user no exist");
    AppMethodBeat.o(14307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.trtc.d.15
 * JD-Core Version:    0.7.0.1
 */