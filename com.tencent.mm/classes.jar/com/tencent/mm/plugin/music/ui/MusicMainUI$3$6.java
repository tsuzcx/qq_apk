package com.tencent.mm.plugin.music.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class MusicMainUI$3$6
  implements Runnable
{
  MusicMainUI$3$6(MusicMainUI.3 param3) {}
  
  public final void run()
  {
    AppMethodBeat.i(105096);
    MusicMainUI.j(this.pcf.pcd).setCurrentItem(MusicMainUI.j(this.pcf.pcd).getCurrentItem() + 1);
    AppMethodBeat.o(105096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI.3.6
 * JD-Core Version:    0.7.0.1
 */