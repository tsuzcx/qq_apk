package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class MaskLinearLayout$1
  implements Runnable
{
  MaskLinearLayout$1(MaskLinearLayout paramMaskLinearLayout) {}
  
  public final void run()
  {
    AppMethodBeat.i(97966);
    this.RfB.setPressed(false);
    MaskLinearLayout.a(this.RfB);
    this.RfB.invalidate();
    AppMethodBeat.o(97966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.MaskLinearLayout.1
 * JD-Core Version:    0.7.0.1
 */