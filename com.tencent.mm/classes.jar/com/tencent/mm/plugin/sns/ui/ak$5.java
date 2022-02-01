package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class ak$5
  implements n.c
{
  ak$5(ak paramak) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(98160);
    if (!ab.hWB) {
      paraml.c(0, this.xqH.imP.getString(2131755747));
    }
    paraml.c(1, this.xqH.imP.getString(2131755754));
    AppMethodBeat.o(98160);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ak.5
 * JD-Core Version:    0.7.0.1
 */