package com.tencent.mm.plugin.music.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class MusicMainUI$3$5
  implements Runnable
{
  MusicMainUI$3$5(MusicMainUI.3 param3) {}
  
  public final void run()
  {
    AppMethodBeat.i(105095);
    MusicMainUI.j(this.pcf.pcd).setCurrentItem(MusicMainUI.j(this.pcf.pcd).getCurrentItem() - 1);
    AppMethodBeat.o(105095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI.3.5
 * JD-Core Version:    0.7.0.1
 */