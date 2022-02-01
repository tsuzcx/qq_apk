package com.tencent.thumbplayer.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.e;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.core.common.TPPostProcessFrame;
import com.tencent.thumbplayer.core.player.ITPNativePlayerPostProcessFrameCallback;

final class b$5
  implements ITPNativePlayerPostProcessFrameCallback
{
  b$5(b paramb) {}
  
  public final TPPostProcessFrame onPostProcessFrame(TPPostProcessFrame paramTPPostProcessFrame, int paramInt)
  {
    AppMethodBeat.i(228687);
    TPPostProcessFrameBuffer localTPPostProcessFrameBuffer = c.a(paramTPPostProcessFrame);
    localTPPostProcessFrameBuffer.eventFlag = paramInt;
    if (paramTPPostProcessFrame.mediaType == 0)
    {
      paramTPPostProcessFrame = c.c(this.ahFY.ahFQ.a(localTPPostProcessFrameBuffer));
      AppMethodBeat.o(228687);
      return paramTPPostProcessFrame;
    }
    if (paramTPPostProcessFrame.mediaType == 1)
    {
      paramTPPostProcessFrame = c.c(this.ahFY.ahFQ.b(localTPPostProcessFrameBuffer));
      AppMethodBeat.o(228687);
      return paramTPPostProcessFrame;
    }
    AppMethodBeat.o(228687);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.b.b.5
 * JD-Core Version:    0.7.0.1
 */