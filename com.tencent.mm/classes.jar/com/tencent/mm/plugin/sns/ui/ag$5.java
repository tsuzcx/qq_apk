package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class ag$5
  implements n.c
{
  ag$5(ag paramag) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(38481);
    if (!ae.glE) {
      paraml.e(0, this.rKd.cmc.getString(2131296938));
    }
    paraml.e(1, this.rKd.cmc.getString(2131296945));
    AppMethodBeat.o(38481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ag.5
 * JD-Core Version:    0.7.0.1
 */