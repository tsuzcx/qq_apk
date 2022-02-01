package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class efo
  extends com.tencent.mm.cd.a
{
  public int UiT;
  public int UiU;
  public int UiV;
  public int UiW;
  public int UiX;
  public int UiY;
  public int UiZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124550);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.UiT);
      paramVarArgs.aY(2, this.UiU);
      paramVarArgs.aY(3, this.UiV);
      paramVarArgs.aY(4, this.UiW);
      paramVarArgs.aY(5, this.UiX);
      paramVarArgs.aY(6, this.UiY);
      paramVarArgs.aY(7, this.UiZ);
      AppMethodBeat.o(124550);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.UiT);
      int i = g.a.a.b.b.a.bM(2, this.UiU);
      int j = g.a.a.b.b.a.bM(3, this.UiV);
      int k = g.a.a.b.b.a.bM(4, this.UiW);
      int m = g.a.a.b.b.a.bM(5, this.UiX);
      int n = g.a.a.b.b.a.bM(6, this.UiY);
      int i1 = g.a.a.b.b.a.bM(7, this.UiZ);
      AppMethodBeat.o(124550);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(124550);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      efo localefo = (efo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124550);
        return -1;
      case 1: 
        localefo.UiT = locala.abFh.AK();
        AppMethodBeat.o(124550);
        return 0;
      case 2: 
        localefo.UiU = locala.abFh.AK();
        AppMethodBeat.o(124550);
        return 0;
      case 3: 
        localefo.UiV = locala.abFh.AK();
        AppMethodBeat.o(124550);
        return 0;
      case 4: 
        localefo.UiW = locala.abFh.AK();
        AppMethodBeat.o(124550);
        return 0;
      case 5: 
        localefo.UiX = locala.abFh.AK();
        AppMethodBeat.o(124550);
        return 0;
      case 6: 
        localefo.UiY = locala.abFh.AK();
        AppMethodBeat.o(124550);
        return 0;
      }
      localefo.UiZ = locala.abFh.AK();
      AppMethodBeat.o(124550);
      return 0;
    }
    AppMethodBeat.o(124550);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efo
 * JD-Core Version:    0.7.0.1
 */