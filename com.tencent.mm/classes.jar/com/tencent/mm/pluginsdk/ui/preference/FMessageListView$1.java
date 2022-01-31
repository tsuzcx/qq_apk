package com.tencent.mm.pluginsdk.ui.preference;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.je;
import com.tencent.mm.g.a.je.a;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.sdk.b.b;

final class FMessageListView$1
  extends a
{
  FMessageListView$1(FMessageListView paramFMessageListView) {}
  
  public final void i(b paramb)
  {
    AppMethodBeat.i(28037);
    if (((paramb instanceof je)) && (!FMessageListView.a(this.waO))) {
      FMessageListView.a(this.waO, ((je)paramb).cyC.cnC);
    }
    AppMethodBeat.o(28037);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.FMessageListView.1
 * JD-Core Version:    0.7.0.1
 */