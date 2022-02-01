package com.tencent.trtc;

import android.view.Surface;
import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.renderer.e;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.RenderInfo;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$12
  implements Runnable
{
  d$12(WXTRTCCloud paramWXTRTCCloud, String paramString, Surface paramSurface) {}
  
  public final void run()
  {
    AppMethodBeat.i(14289);
    WXTRTCCloud.access$2900(this.IIO, "setRemoteSubStreamSurface " + this.a + ", " + this.b);
    Object localObject = WXTRTCCloud.access$3000(this.IIO).getUser(this.a);
    if (localObject != null)
    {
      localObject = ((TRTCRoomInfo.UserInfo)localObject).subRender.render;
      if (localObject != null)
      {
        localObject = ((TXCRenderAndDec)localObject).getVideoRender();
        if (localObject != null)
        {
          ((e)localObject).a(this.b);
          AppMethodBeat.o(14289);
          return;
        }
        WXTRTCCloud.access$3100(this.IIO, "videoRender no exist");
        AppMethodBeat.o(14289);
        return;
      }
      WXTRTCCloud.access$3200(this.IIO, "render no exist");
      AppMethodBeat.o(14289);
      return;
    }
    WXTRTCCloud.access$3300(this.IIO, "user no exist");
    AppMethodBeat.o(14289);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.trtc.d.12
 * JD-Core Version:    0.7.0.1
 */