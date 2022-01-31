package com.tencent.mm.plugin.music.ui;

import com.tencent.mm.h.a.jy;
import com.tencent.mm.h.a.jy.a;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.f.c.b;

final class MusicMainUI$3$1
  implements Runnable
{
  MusicMainUI$3$1(MusicMainUI.3 param3, jy paramjy) {}
  
  public final void run()
  {
    if ((this.mCb.bSA.action == 0) && (((e)b.Q(e.class)).getMode() != 2))
    {
      MusicMainUI.j(this.mCc.mCa).setAdapter(MusicMainUI.i(this.mCc.mCa));
      MusicMainUI.j(this.mCc.mCa).setCurrentItem(((e)b.Q(e.class)).bng() + 100000);
    }
    MusicMainUI.k(this.mCc.mCa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI.3.1
 * JD-Core Version:    0.7.0.1
 */