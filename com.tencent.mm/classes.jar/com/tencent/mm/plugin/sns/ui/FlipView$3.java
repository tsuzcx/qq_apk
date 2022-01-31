package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ao;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.widget.b.d.a;

final class FlipView$3
  implements d.a
{
  FlipView$3(FlipView paramFlipView) {}
  
  public final void onDismiss()
  {
    AppMethodBeat.i(38228);
    ao localao = new ao();
    localao.cnS.filePath = FlipView.b(this.rGJ);
    a.ymk.l(localao);
    FlipView.a(this.rGJ, null);
    FlipView.b(this.rGJ, null);
    FlipView.c(this.rGJ);
    FlipView.d(this.rGJ);
    FlipView.c(this.rGJ, "");
    FlipView.e(this.rGJ);
    FlipView.d(this.rGJ, null);
    FlipView.a(this.rGJ, FlipView.b(this.rGJ, 0));
    AppMethodBeat.o(38228);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.FlipView.3
 * JD-Core Version:    0.7.0.1
 */