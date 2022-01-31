package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMTagPanelScrollView$1
  implements Runnable
{
  MMTagPanelScrollView$1(MMTagPanelScrollView paramMMTagPanelScrollView) {}
  
  public final void run()
  {
    AppMethodBeat.i(106856);
    this.zmT.scrollTo(0, this.zmT.getBottom());
    AppMethodBeat.o(106856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanelScrollView.1
 * JD-Core Version:    0.7.0.1
 */