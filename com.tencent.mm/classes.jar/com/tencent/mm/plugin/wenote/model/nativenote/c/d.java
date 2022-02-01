package com.tencent.mm.plugin.wenote.model.nativenote.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public int bNu;
  public int endPos;
  public int qSo;
  public int startOffset;
  
  public d()
  {
    AppMethodBeat.i(30549);
    this.bNu = -1;
    this.startOffset = -1;
    this.endPos = -1;
    this.qSo = -1;
    set(-1, -1, -1, -1);
    AppMethodBeat.o(30549);
  }
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(30550);
    this.bNu = -1;
    this.startOffset = -1;
    this.endPos = -1;
    this.qSo = -1;
    set(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(30550);
  }
  
  public final int getSelectType()
  {
    AppMethodBeat.i(30551);
    if ((this.bNu < 0) || (this.startOffset < 0) || (this.endPos < 0) || (this.qSo < 0) || (this.bNu > this.endPos) || ((this.bNu == this.endPos) && (this.startOffset > this.qSo)))
    {
      AppMethodBeat.o(30551);
      return 0;
    }
    com.tencent.mm.plugin.wenote.model.a.c localc1 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(this.bNu);
    com.tencent.mm.plugin.wenote.model.a.c localc2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(this.endPos);
    if ((localc1 == null) || (localc2 == null))
    {
      AppMethodBeat.o(30551);
      return 0;
    }
    if ((this.bNu == this.endPos) && (this.startOffset == this.qSo))
    {
      AppMethodBeat.o(30551);
      return 1;
    }
    if ((this.bNu == this.endPos) && (localc1.getType() == 1))
    {
      AppMethodBeat.o(30551);
      return 2;
    }
    AppMethodBeat.o(30551);
    return 3;
  }
  
  public final void set(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.bNu = paramInt1;
    this.startOffset = paramInt2;
    this.endPos = paramInt3;
    this.qSo = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.d
 * JD-Core Version:    0.7.0.1
 */