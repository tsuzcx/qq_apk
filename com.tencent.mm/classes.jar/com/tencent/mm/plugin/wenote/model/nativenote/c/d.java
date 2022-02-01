package com.tencent.mm.plugin.wenote.model.nativenote.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public int bPt;
  public int endPos;
  public int lPo;
  public int uuu;
  
  public d()
  {
    AppMethodBeat.i(30549);
    this.bPt = -1;
    this.lPo = -1;
    this.endPos = -1;
    this.uuu = -1;
    E(-1, -1, -1, -1);
    AppMethodBeat.o(30549);
  }
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(30550);
    this.bPt = -1;
    this.lPo = -1;
    this.endPos = -1;
    this.uuu = -1;
    E(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(30550);
  }
  
  public final void E(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.bPt = paramInt1;
    this.lPo = paramInt2;
    this.endPos = paramInt3;
    this.uuu = paramInt4;
  }
  
  public final int getSelectType()
  {
    AppMethodBeat.i(30551);
    if ((this.bPt < 0) || (this.lPo < 0) || (this.endPos < 0) || (this.uuu < 0) || (this.bPt > this.endPos) || ((this.bPt == this.endPos) && (this.lPo > this.uuu)))
    {
      AppMethodBeat.o(30551);
      return 0;
    }
    com.tencent.mm.plugin.wenote.model.a.c localc1 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().aph(this.bPt);
    com.tencent.mm.plugin.wenote.model.a.c localc2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().aph(this.endPos);
    if ((localc1 == null) || (localc2 == null))
    {
      AppMethodBeat.o(30551);
      return 0;
    }
    if ((this.bPt == this.endPos) && (this.lPo == this.uuu))
    {
      AppMethodBeat.o(30551);
      return 1;
    }
    if ((this.bPt == this.endPos) && (localc1.getType() == 1))
    {
      AppMethodBeat.o(30551);
      return 2;
    }
    AppMethodBeat.o(30551);
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.d
 * JD-Core Version:    0.7.0.1
 */