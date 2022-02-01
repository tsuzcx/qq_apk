package com.tencent.thumbplayer.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.e;
import com.tencent.thumbplayer.core.common.TPSubtitleFrame;
import com.tencent.thumbplayer.core.player.ITPNativePlayerSubtitleFrameCallback;

final class b$4
  implements ITPNativePlayerSubtitleFrameCallback
{
  b$4(b paramb) {}
  
  public final void onSubtitleFrame(TPSubtitleFrame paramTPSubtitleFrame, int paramInt)
  {
    AppMethodBeat.i(228701);
    paramTPSubtitleFrame = c.a(paramTPSubtitleFrame);
    this.ahFY.ahFQ.a(paramTPSubtitleFrame);
    AppMethodBeat.o(228701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.b.b.4
 * JD-Core Version:    0.7.0.1
 */