package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class SnsAdStreamVideoPlayUI$1
  implements n.c
{
  SnsAdStreamVideoPlayUI$1(SnsAdStreamVideoPlayUI paramSnsAdStreamVideoPlayUI) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(145503);
    if (paraml.dEc())
    {
      paraml.hx(1002, 2131303767);
      paraml.hx(1003, 2131303768);
      if (!SnsAdStreamVideoPlayUI.c(this.rNK)) {
        paraml.hx(1004, 2131303766);
      }
    }
    AppMethodBeat.o(145503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdStreamVideoPlayUI.1
 * JD-Core Version:    0.7.0.1
 */