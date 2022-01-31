package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class h$7
  implements n.c
{
  h$7(String paramString, ArrayList paramArrayList) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(106409);
    paraml.setHeaderTitle(this.cbK);
    int i = 0;
    while (i < this.etW.size())
    {
      paraml.e(i, (CharSequence)this.etW.get(i));
      i += 1;
    }
    AppMethodBeat.o(106409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.h.7
 * JD-Core Version:    0.7.0.1
 */