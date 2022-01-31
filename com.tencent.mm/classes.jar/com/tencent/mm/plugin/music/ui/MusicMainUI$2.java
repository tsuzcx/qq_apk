package com.tencent.mm.plugin.music.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a;
import com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar;
import com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar.a;

final class MusicMainUI$2
  implements MusicSeekBar.a
{
  MusicMainUI$2(MusicMainUI paramMusicMainUI) {}
  
  public final void qH(int paramInt)
  {
    AppMethodBeat.i(105090);
    a.lN(paramInt);
    MusicMainUI.d(this.pcd).setProgress(paramInt);
    MusicMainUI.d(this.pcd).fs(true);
    AppMethodBeat.o(105090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI.2
 * JD-Core Version:    0.7.0.1
 */