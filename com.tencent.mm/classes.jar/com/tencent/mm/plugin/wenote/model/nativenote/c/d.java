package com.tencent.mm.plugin.wenote.model.nativenote.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public int cUq;
  public int endPos;
  public int oSI;
  public int startOffset;
  
  public d()
  {
    AppMethodBeat.i(30549);
    this.cUq = -1;
    this.startOffset = -1;
    this.endPos = -1;
    this.oSI = -1;
    set(-1, -1, -1, -1);
    AppMethodBeat.o(30549);
  }
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(30550);
    this.cUq = -1;
    this.startOffset = -1;
    this.endPos = -1;
    this.oSI = -1;
    set(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(30550);
  }
  
  public final int cak()
  {
    AppMethodBeat.i(30551);
    if ((this.cUq < 0) || (this.startOffset < 0) || (this.endPos < 0) || (this.oSI < 0) || (this.cUq > this.endPos) || ((this.cUq == this.endPos) && (this.startOffset > this.oSI)))
    {
      AppMethodBeat.o(30551);
      return 0;
    }
    com.tencent.mm.plugin.wenote.model.a.c localc1 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().Wh(this.cUq);
    com.tencent.mm.plugin.wenote.model.a.c localc2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().Wh(this.endPos);
    if ((localc1 == null) || (localc2 == null))
    {
      AppMethodBeat.o(30551);
      return 0;
    }
    if ((this.cUq == this.endPos) && (this.startOffset == this.oSI))
    {
      AppMethodBeat.o(30551);
      return 1;
    }
    if ((this.cUq == this.endPos) && (localc1.getType() == 1))
    {
      AppMethodBeat.o(30551);
      return 2;
    }
    AppMethodBeat.o(30551);
    return 3;
  }
  
  public final void set(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.cUq = paramInt1;
    this.startOffset = paramInt2;
    this.endPos = paramInt3;
    this.oSI = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.d
 * JD-Core Version:    0.7.0.1
 */