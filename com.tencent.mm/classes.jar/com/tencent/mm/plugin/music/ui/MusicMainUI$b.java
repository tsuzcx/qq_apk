package com.tencent.mm.plugin.music.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.pluginsdk.i.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class MusicMainUI$b
  extends d.a
{
  private MusicMainUI$b(MusicMainUI paramMusicMainUI) {}
  
  public final void onRelease() {}
  
  public final void onShake(boolean paramBoolean)
  {
    AppMethodBeat.i(151919);
    ab.i("MicroMsg.Music.MusicMainUI", "shake %b", new Object[] { Boolean.valueOf(paramBoolean) });
    long l = bo.av(MusicMainUI.e(this.pcd));
    if (l < 1200L)
    {
      ab.i("MicroMsg.Music.MusicMainUI", "tryStartShake delay too short:".concat(String.valueOf(l)));
      AppMethodBeat.o(151919);
      return;
    }
    ab.w("MicroMsg.Music.MusicMainUI", "tryStartShake delay too enough:".concat(String.valueOf(l)));
    MusicMainUI.a(this.pcd, bo.yB());
    MusicMainUI.f(this.pcd);
    if (MusicMainUI.g(this.pcd) % 2 == 0) {
      ((e)b.am(e.class)).xR(MusicMainUI.h(this.pcd));
    }
    AppMethodBeat.o(151919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI.b
 * JD-Core Version:    0.7.0.1
 */