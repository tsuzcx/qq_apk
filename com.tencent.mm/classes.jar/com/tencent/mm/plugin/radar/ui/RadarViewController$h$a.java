package com.tencent.mm.plugin.radar.ui;

import a.l;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.protocal.protobuf.brg;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class RadarViewController$h$a
  implements Runnable
{
  RadarViewController$h$a(RadarViewController.h paramh, View paramView, brg parambrg, c.e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(103099);
    RadarViewController.g(this.pTt.pTd).a(this.pTu, this.pRx, this.pTv);
    RadarViewController.f(this.pTt.pTd).cfh();
    AppMethodBeat.o(103099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarViewController.h.a
 * JD-Core Version:    0.7.0.1
 */