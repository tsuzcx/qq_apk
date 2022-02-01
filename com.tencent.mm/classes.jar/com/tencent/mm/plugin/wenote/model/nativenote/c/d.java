package com.tencent.mm.plugin.wenote.model.nativenote.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public int cWU;
  public int endPos;
  public int opi;
  public int startOffset;
  
  public d()
  {
    AppMethodBeat.i(30549);
    this.cWU = -1;
    this.startOffset = -1;
    this.endPos = -1;
    this.opi = -1;
    set(-1, -1, -1, -1);
    AppMethodBeat.o(30549);
  }
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(30550);
    this.cWU = -1;
    this.startOffset = -1;
    this.endPos = -1;
    this.opi = -1;
    set(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(30550);
  }
  
  public final int bSV()
  {
    AppMethodBeat.i(30551);
    if ((this.cWU < 0) || (this.startOffset < 0) || (this.endPos < 0) || (this.opi < 0) || (this.cWU > this.endPos) || ((this.cWU == this.endPos) && (this.startOffset > this.opi)))
    {
      AppMethodBeat.o(30551);
      return 0;
    }
    com.tencent.mm.plugin.wenote.model.a.c localc1 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().TZ(this.cWU);
    com.tencent.mm.plugin.wenote.model.a.c localc2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().TZ(this.endPos);
    if ((localc1 == null) || (localc2 == null))
    {
      AppMethodBeat.o(30551);
      return 0;
    }
    if ((this.cWU == this.endPos) && (this.startOffset == this.opi))
    {
      AppMethodBeat.o(30551);
      return 1;
    }
    if ((this.cWU == this.endPos) && (localc1.getType() == 1))
    {
      AppMethodBeat.o(30551);
      return 2;
    }
    AppMethodBeat.o(30551);
    return 3;
  }
  
  public final void set(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.cWU = paramInt1;
    this.startOffset = paramInt2;
    this.endPos = paramInt3;
    this.opi = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.d
 * JD-Core Version:    0.7.0.1
 */