package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.am.a;

final class a$12
  implements am.a
{
  a$12(a parama) {}
  
  public final boolean tC()
  {
    if ((this.mpw.mlw != null) && (this.mpw.mlw.isPlaying()))
    {
      if ((this.mpw.mph > 0) && (this.mpw.mlw.getCurrentPosition() >= this.mpw.mph))
      {
        this.mpw.mlw.d(this.mpw.mpg, true);
        this.mpw.mpd.setCurrentCursorPosition(this.mpw.mpg / this.mpw.mpf);
      }
    }
    else {
      return true;
    }
    this.mpw.mpd.setCurrentCursorPosition(this.mpw.mlw.getCurrentPosition() / this.mpw.mpf);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.a.12
 * JD-Core Version:    0.7.0.1
 */