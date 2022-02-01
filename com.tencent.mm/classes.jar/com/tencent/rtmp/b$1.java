package com.tencent.rtmp;

import com.tencent.liteav.audio.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

class b$1
  implements f
{
  b$1(b paramb) {}
  
  public void onPlayEnd(int paramInt)
  {
    AppMethodBeat.i(14007);
    if (this.a.a != null) {
      this.a.a.onBGMComplete(paramInt);
    }
    AppMethodBeat.o(14007);
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(14008);
    if (this.a.a != null) {
      this.a.a.onBGMProgress(paramLong1, paramLong2);
    }
    AppMethodBeat.o(14008);
  }
  
  public void onPlayStart()
  {
    AppMethodBeat.i(14006);
    if (this.a.a != null) {
      this.a.a.onBGMStart();
    }
    AppMethodBeat.o(14006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.rtmp.b.1
 * JD-Core Version:    0.7.0.1
 */