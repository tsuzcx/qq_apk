package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fol
  extends com.tencent.mm.cd.a
{
  public boolean UMB;
  public int UMC;
  public double UMD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50121);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.co(1, this.UMB);
      paramVarArgs.aY(2, this.UMC);
      paramVarArgs.e(3, this.UMD);
      AppMethodBeat.o(50121);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.gL(1);
      int i = g.a.a.b.b.a.bM(2, this.UMC);
      int j = g.a.a.b.b.a.gL(3);
      AppMethodBeat.o(50121);
      return paramInt + 1 + 0 + i + (j + 8);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(50121);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fol localfol = (fol)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50121);
        return -1;
      case 1: 
        localfol.UMB = locala.abFh.AB();
        AppMethodBeat.o(50121);
        return 0;
      case 2: 
        localfol.UMC = locala.abFh.AK();
        AppMethodBeat.o(50121);
        return 0;
      }
      localfol.UMD = Double.longBitsToDouble(locala.abFh.AP());
      AppMethodBeat.o(50121);
      return 0;
    }
    AppMethodBeat.o(50121);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fol
 * JD-Core Version:    0.7.0.1
 */