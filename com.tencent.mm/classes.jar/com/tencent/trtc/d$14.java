package com.tencent.trtc;

import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.renderer.e;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.RenderInfo;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$14
  implements Runnable
{
  d$14(WXTRTCCloud paramWXTRTCCloud, String paramString, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(14378);
    WXTRTCCloud.access$2400(this.IIP, "seRemoteSurfaceSize: " + this.a + ", " + this.b + "," + this.c);
    Object localObject = WXTRTCCloud.access$2500(this.IIP).getUser(this.a);
    if (localObject != null)
    {
      localObject = ((TRTCRoomInfo.UserInfo)localObject).mainRender.render;
      if (localObject != null)
      {
        localObject = ((TXCRenderAndDec)localObject).getVideoRender();
        if (localObject != null)
        {
          ((e)localObject).c(this.b, this.c);
          AppMethodBeat.o(14378);
          return;
        }
        WXTRTCCloud.access$2600(this.IIP, "videoRender no exist");
        AppMethodBeat.o(14378);
        return;
      }
      WXTRTCCloud.access$2700(this.IIP, "render no exist");
      AppMethodBeat.o(14378);
      return;
    }
    WXTRTCCloud.access$2800(this.IIP, "user no exist");
    AppMethodBeat.o(14378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.trtc.d.14
 * JD-Core Version:    0.7.0.1
 */