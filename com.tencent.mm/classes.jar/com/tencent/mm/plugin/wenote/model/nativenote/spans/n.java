package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;

public final class n
  extends e
{
  final boolean xBN;
  public final boolean xBO;
  
  public n(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramInt1, paramInt2);
    this.xBN = paramBoolean1;
    this.xBO = paramBoolean2;
  }
  
  public final boolean a(e parame)
  {
    AppMethodBeat.i(30652);
    if (parame == null)
    {
      AppMethodBeat.o(30652);
      return false;
    }
    if (parame.isEmpty())
    {
      int i;
      if ((parame.uG >= this.uG) && (parame.uH < this.uH))
      {
        i = 1;
        if ((parame.uG < this.uG) || (parame.uH > this.uH)) {
          break label101;
        }
      }
      label101:
      for (int j = 1;; j = 0)
      {
        if ((i == 0) && ((j == 0) || (!this.xBO))) {
          break label106;
        }
        AppMethodBeat.o(30652);
        return true;
        i = 0;
        break;
      }
      label106:
      AppMethodBeat.o(30652);
      return false;
    }
    if (Math.max(this.uG, parame.uG) < Math.min(this.uH, parame.uH))
    {
      AppMethodBeat.o(30652);
      return true;
    }
    AppMethodBeat.o(30652);
    return false;
  }
  
  public final int getLen()
  {
    AppMethodBeat.i(30653);
    int i = Math.abs(this.uH - this.uG);
    AppMethodBeat.o(30653);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.n
 * JD-Core Version:    0.7.0.1
 */