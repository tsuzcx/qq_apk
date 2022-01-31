package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.ap.a;

final class b$13
  implements ap.a
{
  b$13(b paramb) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(55161);
    if ((b.f(this.oOV) != null) && (b.f(this.oOV).isPlaying()))
    {
      if ((b.c(this.oOV) <= 0) || (b.f(this.oOV).getCurrentPosition() < b.c(this.oOV))) {
        break label111;
      }
      b.f(this.oOV).e(b.s(this.oOV), true);
      b.w(this.oOV).setCurrentCursorPosition(b.s(this.oOV) / b.d(this.oOV));
    }
    for (;;)
    {
      AppMethodBeat.o(55161);
      return true;
      label111:
      b.w(this.oOV).setCurrentCursorPosition(b.f(this.oOV).getCurrentPosition() / b.d(this.oOV));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.b.13
 * JD-Core Version:    0.7.0.1
 */