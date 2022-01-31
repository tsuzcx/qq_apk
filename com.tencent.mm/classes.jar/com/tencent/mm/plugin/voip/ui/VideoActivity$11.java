package com.tencent.mm.plugin.voip.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.a.e;

final class VideoActivity$11
  implements e
{
  VideoActivity$11(VideoActivity paramVideoActivity) {}
  
  public final void bx(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(4798);
    if (paramArrayOfByte != null) {
      VideoActivity.a(this.tCq, paramArrayOfByte);
    }
    AppMethodBeat.o(4798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VideoActivity.11
 * JD-Core Version:    0.7.0.1
 */