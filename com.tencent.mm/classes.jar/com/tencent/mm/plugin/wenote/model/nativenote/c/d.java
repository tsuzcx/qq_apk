package com.tencent.mm.plugin.wenote.model.nativenote.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public int dIY;
  public int endPos;
  public int oHY;
  public int xAR;
  
  public d()
  {
    AppMethodBeat.i(30549);
    this.dIY = -1;
    this.oHY = -1;
    this.endPos = -1;
    this.xAR = -1;
    K(-1, -1, -1, -1);
    AppMethodBeat.o(30549);
  }
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(30550);
    this.dIY = -1;
    this.oHY = -1;
    this.endPos = -1;
    this.xAR = -1;
    K(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(30550);
  }
  
  public final void K(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.dIY = paramInt1;
    this.oHY = paramInt2;
    this.endPos = paramInt3;
    this.xAR = paramInt4;
  }
  
  public final int getSelectType()
  {
    AppMethodBeat.i(30551);
    if ((this.dIY < 0) || (this.oHY < 0) || (this.endPos < 0) || (this.xAR < 0) || (this.dIY > this.endPos) || ((this.dIY == this.endPos) && (this.oHY > this.xAR)))
    {
      AppMethodBeat.o(30551);
      return 0;
    }
    com.tencent.mm.plugin.wenote.model.a.c localc1 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().avf(this.dIY);
    com.tencent.mm.plugin.wenote.model.a.c localc2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().avf(this.endPos);
    if ((localc1 == null) || (localc2 == null))
    {
      AppMethodBeat.o(30551);
      return 0;
    }
    if ((this.dIY == this.endPos) && (this.oHY == this.xAR))
    {
      AppMethodBeat.o(30551);
      return 1;
    }
    if ((this.dIY == this.endPos) && (localc1.getType() == 1))
    {
      AppMethodBeat.o(30551);
      return 2;
    }
    AppMethodBeat.o(30551);
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.d
 * JD-Core Version:    0.7.0.1
 */