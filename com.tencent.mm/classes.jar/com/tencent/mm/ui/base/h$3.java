package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

final class h$3
  implements q.f
{
  h$3(String paramString1, List paramList1, List paramList2, String paramString2) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(141774);
    if (!Util.isNullOrNil(this.cWz)) {
      paramo.setHeaderTitle(this.cWz);
    }
    int i = 0;
    while (i < this.KEx.size())
    {
      paramo.d(((Integer)this.KDR.get(i)).intValue(), (CharSequence)this.KEx.get(i));
      i += 1;
    }
    if (!Util.isNullOrNil(this.Wiv)) {
      paramo.d(-1, this.Wiv);
    }
    AppMethodBeat.o(141774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.h.3
 * JD-Core Version:    0.7.0.1
 */