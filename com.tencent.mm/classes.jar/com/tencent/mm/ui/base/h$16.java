package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

final class h$16
  implements n.c
{
  h$16(String paramString1, List paramList1, List paramList2, String paramString2) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(106420);
    if (!bo.isNullOrNil(this.cbK)) {
      paraml.setHeaderTitle(this.cbK);
    }
    int i = 0;
    while (i < this.rHo.size())
    {
      paraml.e(((Integer)this.rGK.get(i)).intValue(), (CharSequence)this.rHo.get(i));
      i += 1;
    }
    if (!bo.isNullOrNil(this.ziA)) {
      paraml.e(-1, this.ziA);
    }
    AppMethodBeat.o(106420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.h.16
 * JD-Core Version:    0.7.0.1
 */