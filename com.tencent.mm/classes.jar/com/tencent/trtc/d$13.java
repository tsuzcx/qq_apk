package com.tencent.trtc;

import android.view.Surface;
import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.renderer.e;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.RenderInfo;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$13
  implements Runnable
{
  d$13(WXTRTCCloud paramWXTRTCCloud, String paramString, Surface paramSurface) {}
  
  public final void run()
  {
    AppMethodBeat.i(14304);
    WXTRTCCloud.access$1900(this.IIO, "setRemoteSurface " + this.a + ", " + this.b);
    Object localObject = WXTRTCCloud.access$2000(this.IIO).getUser(this.a);
    if (localObject != null)
    {
      localObject = ((TRTCRoomInfo.UserInfo)localObject).mainRender.render;
      if (localObject != null)
      {
        localObject = ((TXCRenderAndDec)localObject).getVideoRender();
        if (localObject != null)
        {
          ((e)localObject).a(this.b);
          AppMethodBeat.o(14304);
          return;
        }
        WXTRTCCloud.access$2100(this.IIO, "videoRender no exist");
        AppMethodBeat.o(14304);
        return;
      }
      WXTRTCCloud.access$2200(this.IIO, "render no exist");
      AppMethodBeat.o(14304);
      return;
    }
    WXTRTCCloud.access$2300(this.IIO, "user no exist");
    AppMethodBeat.o(14304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.trtc.d.13
 * JD-Core Version:    0.7.0.1
 */