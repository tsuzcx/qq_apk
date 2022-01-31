package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;

final class ComposeUI$11$2
  implements b.b
{
  ComposeUI$11$2(ComposeUI.11 param11) {}
  
  public final void ceh()
  {
    AppMethodBeat.i(68181);
    ComposeUI.G(this.pMc.pLX).setMessage(this.pMc.pLX.getString(2131302111));
    AppMethodBeat.o(68181);
  }
  
  public final void onComplete()
  {
    AppMethodBeat.i(68182);
    ComposeUI.a(this.pMc.pLX, ComposeUI.H(this.pMc.pLX));
    AppMethodBeat.o(68182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.11.2
 * JD-Core Version:    0.7.0.1
 */