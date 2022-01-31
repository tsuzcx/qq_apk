package com.tencent.mm.plugin.music.ui;

import com.tencent.mm.av.a;

final class MusicMainUI$2
  implements MusicSeekBar.a
{
  MusicMainUI$2(MusicMainUI paramMusicMainUI) {}
  
  public final void uZ(int paramInt)
  {
    a.iV(paramInt);
    MusicMainUI.d(this.mCa).setProgress(paramInt);
    MusicMainUI.d(this.mCa).hU(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI.2
 * JD-Core Version:    0.7.0.1
 */