package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class h$5
  implements q.f
{
  h$5(String paramString, ArrayList paramArrayList) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(197286);
    paramo.setHeaderTitle(this.cWz);
    int i = 0;
    while (i < this.val$list.size())
    {
      paramo.d(i, (CharSequence)this.val$list.get(i));
      i += 1;
    }
    AppMethodBeat.o(197286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.h.5
 * JD-Core Version:    0.7.0.1
 */