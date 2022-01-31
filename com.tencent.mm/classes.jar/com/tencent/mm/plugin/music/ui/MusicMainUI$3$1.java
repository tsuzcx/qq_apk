package com.tencent.mm.plugin.music.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ki;
import com.tencent.mm.g.a.ki.a;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.f.c.b;

final class MusicMainUI$3$1
  implements Runnable
{
  MusicMainUI$3$1(MusicMainUI.3 param3, ki paramki) {}
  
  public final void run()
  {
    AppMethodBeat.i(105091);
    if ((this.pce.cAc.action == 0) && (((e)b.am(e.class)).getMode() != 2))
    {
      MusicMainUI.j(this.pcf.pcd).setAdapter(MusicMainUI.i(this.pcf.pcd));
      MusicMainUI.j(this.pcf.pcd).setCurrentItem(((e)b.am(e.class)).bVC() + 100000);
    }
    MusicMainUI.k(this.pcf.pcd);
    AppMethodBeat.o(105091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI.3.1
 * JD-Core Version:    0.7.0.1
 */