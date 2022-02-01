package com.tencent.thumbplayer.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.e;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import com.tencent.thumbplayer.core.player.ITPNativePlayerAudioFrameCallback;

final class b$2
  implements ITPNativePlayerAudioFrameCallback
{
  b$2(b paramb) {}
  
  public final void onAudioFrame(TPAudioFrame paramTPAudioFrame, int paramInt)
  {
    AppMethodBeat.i(228677);
    paramTPAudioFrame = c.a(paramTPAudioFrame);
    this.ahFY.ahFQ.a(paramTPAudioFrame);
    AppMethodBeat.o(228677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.b.b.2
 * JD-Core Version:    0.7.0.1
 */