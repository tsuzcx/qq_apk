package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;

public final class n
  extends e
{
  final boolean vBb;
  public final boolean vBc;
  
  public n(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramInt1, paramInt2);
    this.vBb = paramBoolean1;
    this.vBc = paramBoolean2;
  }
  
  public final boolean a(e parame)
  {
    AppMethodBeat.i(26958);
    if (parame == null)
    {
      AppMethodBeat.o(26958);
      return false;
    }
    if (parame.isEmpty())
    {
      int i;
      if ((parame.akX >= this.akX) && (parame.Fe < this.Fe))
      {
        i = 1;
        if ((parame.akX < this.akX) || (parame.Fe > this.Fe)) {
          break label101;
        }
      }
      label101:
      for (int j = 1;; j = 0)
      {
        if ((i == 0) && ((j == 0) || (!this.vBc))) {
          break label106;
        }
        AppMethodBeat.o(26958);
        return true;
        i = 0;
        break;
      }
      label106:
      AppMethodBeat.o(26958);
      return false;
    }
    if (Math.max(this.akX, parame.akX) < Math.min(this.Fe, parame.Fe))
    {
      AppMethodBeat.o(26958);
      return true;
    }
    AppMethodBeat.o(26958);
    return false;
  }
  
  public final int djG()
  {
    AppMethodBeat.i(26959);
    int i = Math.abs(this.Fe - this.akX);
    AppMethodBeat.o(26959);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.n
 * JD-Core Version:    0.7.0.1
 */