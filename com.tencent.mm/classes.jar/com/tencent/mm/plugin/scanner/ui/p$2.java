package com.tencent.mm.plugin.scanner.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.util.i.a;

final class p$2
  implements i.a
{
  p$2(p paramp) {}
  
  public final void ciY()
  {
    AppMethodBeat.i(151678);
    this.qAf.kn(true);
    AppMethodBeat.o(151678);
  }
  
  public final void onCancel()
  {
    this.qAf.qzT = false;
  }
  
  public final void onError()
  {
    this.qAf.qzT = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.p.2
 * JD-Core Version:    0.7.0.1
 */