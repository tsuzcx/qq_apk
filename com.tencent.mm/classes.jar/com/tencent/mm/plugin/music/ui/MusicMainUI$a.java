package com.tencent.mm.plugin.music.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.plugin.music.model.e.a;

final class MusicMainUI$a
  implements Runnable
{
  int position;
  
  public MusicMainUI$a(MusicMainUI paramMusicMainUI, int paramInt)
  {
    this.position = paramInt;
  }
  
  public final void run()
  {
    AppMethodBeat.i(105105);
    ((e)b.am(e.class)).Ah(this.position);
    a locala = ((e)b.am(e.class)).bVw();
    if (locala == null)
    {
      AppMethodBeat.o(105105);
      return;
    }
    if (locala.bVW()) {
      this.pcd.i(locala);
    }
    if (((e)b.am(e.class)).bVE()) {
      MusicMainUI.j(this.pcd).setCanSlide(true);
    }
    MusicMainUI.a(this.pcd, locala);
    AppMethodBeat.o(105105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI.a
 * JD-Core Version:    0.7.0.1
 */