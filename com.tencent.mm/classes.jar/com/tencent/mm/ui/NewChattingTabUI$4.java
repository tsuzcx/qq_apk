package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.platformtools.ah;

final class NewChattingTabUI$4
  implements Runnable
{
  NewChattingTabUI$4(NewChattingTabUI paramNewChattingTabUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(29796);
    d.b(this.yYH, "ChattingUI" + NewChattingTabUI.i(this.zei), hashCode());
    if (this.yYH == 4) {
      d.o("ChattingUI" + NewChattingTabUI.i(this.zei), NewChattingTabUI.j(this.zei), ah.aox());
    }
    AppMethodBeat.o(29796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.NewChattingTabUI.4
 * JD-Core Version:    0.7.0.1
 */