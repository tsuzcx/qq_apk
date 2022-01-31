package com.tencent.mm.plugin.music.ui;

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
    ((e)b.Q(e.class)).uL(this.position);
    a locala = ((e)b.Q(e.class)).bna();
    if (locala == null) {
      return;
    }
    if (locala.bnz()) {
      this.mCa.g(locala);
    }
    if (((e)b.Q(e.class)).bni()) {
      MusicMainUI.j(this.mCa).setCanSlide(true);
    }
    MusicMainUI.a(this.mCa, locala);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI.a
 * JD-Core Version:    0.7.0.1
 */