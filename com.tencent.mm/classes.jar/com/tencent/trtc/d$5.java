package com.tencent.trtc;

import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.RenderInfo;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserAction;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$5
  implements TRTCRoomInfo.UserAction
{
  d$5(WXTRTCCloud paramWXTRTCCloud) {}
  
  public final void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    AppMethodBeat.i(182435);
    if ((paramUserInfo.mainRender.render != null) && (paramUserInfo.mainRender.render.isRendering())) {
      paramUserInfo.mainRender.render.updateLoadInfo();
    }
    if ((paramUserInfo.subRender.render != null) && (paramUserInfo.subRender.render.isRendering())) {
      paramUserInfo.subRender.render.updateLoadInfo();
    }
    WXTRTCCloud.access$4800(this.IIK, paramUserInfo.mainRender.view, paramUserInfo.mainRender.render, paramUserInfo);
    WXTRTCCloud.access$4900(this.IIK, paramUserInfo.subRender.view, paramUserInfo.subRender.render, paramUserInfo);
    AppMethodBeat.o(182435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.trtc.d.5
 * JD-Core Version:    0.7.0.1
 */