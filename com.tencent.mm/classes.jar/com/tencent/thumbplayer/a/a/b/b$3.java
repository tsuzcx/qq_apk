package com.tencent.thumbplayer.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.e;
import com.tencent.thumbplayer.core.common.TPVideoFrame;
import com.tencent.thumbplayer.core.player.ITPNativePlayerVideoFrameCallback;

final class b$3
  implements ITPNativePlayerVideoFrameCallback
{
  b$3(b paramb) {}
  
  public final void onVideoFrame(TPVideoFrame paramTPVideoFrame, int paramInt)
  {
    AppMethodBeat.i(228686);
    paramTPVideoFrame = c.a(paramTPVideoFrame);
    this.ahFY.ahFQ.a(paramTPVideoFrame);
    AppMethodBeat.o(228686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.b.b.3
 * JD-Core Version:    0.7.0.1
 */