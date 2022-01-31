package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.ui.base.p;

final class ComposeUI$13$2
  implements b.b
{
  ComposeUI$13$2(ComposeUI.13 param13) {}
  
  public final void ceh() {}
  
  public final void onComplete()
  {
    AppMethodBeat.i(68186);
    ComposeUI.G(this.pMd.pLX).dismiss();
    u.b(ComposeUI.s(this.pMd.pLX), ComposeUI.n(this.pMd.pLX), ComposeUI.x(this.pMd.pLX));
    ComposeUI.I(this.pMd.pLX);
    AppMethodBeat.o(68186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.13.2
 * JD-Core Version:    0.7.0.1
 */