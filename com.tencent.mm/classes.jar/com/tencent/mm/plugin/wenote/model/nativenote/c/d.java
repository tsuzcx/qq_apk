package com.tencent.mm.plugin.wenote.model.nativenote.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public int chT;
  public int endPos;
  public int startOffset;
  public int vAi;
  
  public d()
  {
    AppMethodBeat.i(26855);
    this.chT = -1;
    this.startOffset = -1;
    this.endPos = -1;
    this.vAi = -1;
    set(-1, -1, -1, -1);
    AppMethodBeat.o(26855);
  }
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(26856);
    this.chT = -1;
    this.startOffset = -1;
    this.endPos = -1;
    this.vAi = -1;
    set(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(26856);
  }
  
  public final int djb()
  {
    AppMethodBeat.i(26857);
    if ((this.chT < 0) || (this.startOffset < 0) || (this.endPos < 0) || (this.vAi < 0) || (this.chT > this.endPos) || ((this.chT == this.endPos) && (this.startOffset > this.vAi)))
    {
      AppMethodBeat.o(26857);
      return 0;
    }
    com.tencent.mm.plugin.wenote.model.a.c localc1 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().Lj(this.chT);
    com.tencent.mm.plugin.wenote.model.a.c localc2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().Lj(this.endPos);
    if ((localc1 == null) || (localc2 == null))
    {
      AppMethodBeat.o(26857);
      return 0;
    }
    if ((this.chT == this.endPos) && (this.startOffset == this.vAi))
    {
      AppMethodBeat.o(26857);
      return 1;
    }
    if ((this.chT == this.endPos) && (localc1.getType() == 1))
    {
      AppMethodBeat.o(26857);
      return 2;
    }
    AppMethodBeat.o(26857);
    return 3;
  }
  
  public final void set(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.chT = paramInt1;
    this.startOffset = paramInt2;
    this.endPos = paramInt3;
    this.vAi = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.d
 * JD-Core Version:    0.7.0.1
 */