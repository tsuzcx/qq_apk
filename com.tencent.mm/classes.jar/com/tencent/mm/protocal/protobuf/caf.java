package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class caf
  extends com.tencent.mm.bv.a
{
  public int xLI;
  public int xLJ;
  public int xLK;
  public int xLL;
  public int xLM;
  public int xLN;
  public int xLO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11805);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xLI);
      paramVarArgs.aO(2, this.xLJ);
      paramVarArgs.aO(3, this.xLK);
      paramVarArgs.aO(4, this.xLL);
      paramVarArgs.aO(5, this.xLM);
      paramVarArgs.aO(6, this.xLN);
      paramVarArgs.aO(7, this.xLO);
      AppMethodBeat.o(11805);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.xLI);
      int i = e.a.a.b.b.a.bl(2, this.xLJ);
      int j = e.a.a.b.b.a.bl(3, this.xLK);
      int k = e.a.a.b.b.a.bl(4, this.xLL);
      int m = e.a.a.b.b.a.bl(5, this.xLM);
      int n = e.a.a.b.b.a.bl(6, this.xLN);
      int i1 = e.a.a.b.b.a.bl(7, this.xLO);
      AppMethodBeat.o(11805);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(11805);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      caf localcaf = (caf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(11805);
        return -1;
      case 1: 
        localcaf.xLI = locala.CLY.sl();
        AppMethodBeat.o(11805);
        return 0;
      case 2: 
        localcaf.xLJ = locala.CLY.sl();
        AppMethodBeat.o(11805);
        return 0;
      case 3: 
        localcaf.xLK = locala.CLY.sl();
        AppMethodBeat.o(11805);
        return 0;
      case 4: 
        localcaf.xLL = locala.CLY.sl();
        AppMethodBeat.o(11805);
        return 0;
      case 5: 
        localcaf.xLM = locala.CLY.sl();
        AppMethodBeat.o(11805);
        return 0;
      case 6: 
        localcaf.xLN = locala.CLY.sl();
        AppMethodBeat.o(11805);
        return 0;
      }
      localcaf.xLO = locala.CLY.sl();
      AppMethodBeat.o(11805);
      return 0;
    }
    AppMethodBeat.o(11805);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.caf
 * JD-Core Version:    0.7.0.1
 */