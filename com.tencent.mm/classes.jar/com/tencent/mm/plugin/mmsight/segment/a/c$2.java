package com.tencent.mm.plugin.mmsight.segment.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class c$2
  implements ap.a
{
  c$2(c paramc) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(3725);
    if (this.oNg.released)
    {
      AppMethodBeat.o(3725);
      return false;
    }
    try
    {
      boolean bool = this.oNg.isPlaying();
      if (!bool)
      {
        AppMethodBeat.o(3725);
        return true;
      }
      int i = this.oNg.getCurrentPosition();
      if (this.oNg.oMC != null) {
        this.oNg.oMC.zx(i);
      }
      ab.d("MicroMsg.SectionRepeatMediaPlayer", "position[%d] repeat[%d, %d] duration[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(this.oNg.oMU), Integer.valueOf(this.oNg.oMV), Integer.valueOf(this.oNg.getDuration()) });
      int j = this.oNg.oMV;
      if (i < j)
      {
        AppMethodBeat.o(3725);
        return true;
      }
      ab.i("MicroMsg.SectionRepeatMediaPlayer", "reach repeat end time, seek to %s", new Object[] { Integer.valueOf(this.oNg.oMV) });
      this.oNg.seekTo(this.oNg.oMU);
      AppMethodBeat.o(3725);
      return false;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      ab.e("MicroMsg.SectionRepeatMediaPlayer", "MediaPlayer may be released. %s", new Object[] { localIllegalStateException.getMessage() });
      if (!this.oNg.released)
      {
        AppMethodBeat.o(3725);
        return true;
      }
      AppMethodBeat.o(3725);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.c.2
 * JD-Core Version:    0.7.0.1
 */