package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class ac$2$1
  implements n.c
{
  ac$2$1(ac.2 param2) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(38337);
    if (!ae.glE) {
      paraml.e(0, this.rIR.rIQ.cmc.getString(2131296938));
    }
    paraml.e(1, this.rIR.rIQ.cmc.getString(2131296945));
    AppMethodBeat.o(38337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ac.2.1
 * JD-Core Version:    0.7.0.1
 */