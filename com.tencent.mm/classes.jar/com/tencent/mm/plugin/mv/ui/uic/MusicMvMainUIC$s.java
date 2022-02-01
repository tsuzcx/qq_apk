package com.tencent.mm.plugin.mv.ui.uic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.mv.a.e;
import com.tencent.mm.plugin.thumbplayer.d.a;
import com.tencent.mm.plugin.thumbplayer.view.g;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$refreshVideo$1", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerActionListener;", "onPause", "", "media", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "onResume", "plugin-mv_release"})
public final class MusicMvMainUIC$s
  implements g
{
  MusicMvMainUIC$s(e parame) {}
  
  public final void a(a parama)
  {
    AppMethodBeat.i(258912);
    p.h(parama, "media");
    if (this.Awc.Uqs > 0L)
    {
      parama = this.Awc;
      parama.Uqt += cl.aWA() - this.Awc.Uqs;
      this.Awc.Uqs = 0L;
    }
    AppMethodBeat.o(258912);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(258913);
    p.h(parama, "media");
    if (this.Awc.Uqs > 0L)
    {
      parama = this.Awc;
      parama.Uqt += cl.aWA() - this.Awc.Uqs;
    }
    this.Awc.Uqs = cl.aWA();
    AppMethodBeat.o(258913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvMainUIC.s
 * JD-Core Version:    0.7.0.1
 */