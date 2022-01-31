package com.tencent.mm.plugin.mmsight.segment.a;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class c$2
  implements am.a
{
  c$2(c paramc) {}
  
  public final boolean tC()
  {
    if (this.mnY.released) {}
    do
    {
      return false;
      try
      {
        if (!this.mnY.isPlaying()) {
          return true;
        }
        int i = this.mnY.getCurrentPosition();
        if (this.mnY.mnu != null) {
          this.mnY.mnu.ui(i);
        }
        y.d("MicroMsg.SectionRepeatMediaPlayer", "position[%d] repeat[%d, %d] duration[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(this.mnY.mnM), Integer.valueOf(this.mnY.mnN), Integer.valueOf(this.mnY.getDuration()) });
        if (i < this.mnY.mnN) {
          return true;
        }
        y.i("MicroMsg.SectionRepeatMediaPlayer", "reach repeat end time, seek to %s", new Object[] { Integer.valueOf(this.mnY.mnN) });
        this.mnY.seekTo(this.mnY.mnM);
        return false;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        y.e("MicroMsg.SectionRepeatMediaPlayer", "MediaPlayer may be released. %s", new Object[] { localIllegalStateException.getMessage() });
      }
    } while (this.mnY.released);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.c.2
 * JD-Core Version:    0.7.0.1
 */