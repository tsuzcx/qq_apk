package com.tencent.mm.plugin.music.ui;

import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.pluginsdk.i.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class MusicMainUI$b
  extends c.a
{
  private MusicMainUI$b(MusicMainUI paramMusicMainUI) {}
  
  public final void bnY()
  {
    y.i("MicroMsg.Music.MusicMainUI", "shake %b", new Object[] { Boolean.valueOf(true) });
    long l = bk.cp(MusicMainUI.e(this.mCa));
    if (l < 1200L) {
      y.i("MicroMsg.Music.MusicMainUI", "tryStartShake delay too short:" + l);
    }
    do
    {
      return;
      y.w("MicroMsg.Music.MusicMainUI", "tryStartShake delay too enough:" + l);
      MusicMainUI.a(this.mCa, bk.UZ());
      MusicMainUI.f(this.mCa);
    } while (MusicMainUI.g(this.mCa) % 2 != 0);
    ((e)b.Q(e.class)).sP(MusicMainUI.h(this.mCa));
  }
  
  public final void onRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI.b
 * JD-Core Version:    0.7.0.1
 */