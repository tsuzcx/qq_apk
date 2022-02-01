package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.cd.a
{
  public int RCN;
  public int RCO;
  public int RCP;
  public int RCQ;
  public int RCR;
  public int RCS;
  public int RCT;
  public int action;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143955);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RCN);
      paramVarArgs.aY(2, this.action);
      paramVarArgs.aY(3, this.RCO);
      paramVarArgs.aY(4, this.RCP);
      paramVarArgs.aY(5, this.RCQ);
      paramVarArgs.aY(6, this.RCR);
      paramVarArgs.aY(7, this.RCS);
      paramVarArgs.aY(8, this.RCT);
      AppMethodBeat.o(143955);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.RCN);
      int i = g.a.a.b.b.a.bM(2, this.action);
      int j = g.a.a.b.b.a.bM(3, this.RCO);
      int k = g.a.a.b.b.a.bM(4, this.RCP);
      int m = g.a.a.b.b.a.bM(5, this.RCQ);
      int n = g.a.a.b.b.a.bM(6, this.RCR);
      int i1 = g.a.a.b.b.a.bM(7, this.RCS);
      int i2 = g.a.a.b.b.a.bM(8, this.RCT);
      AppMethodBeat.o(143955);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(143955);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143955);
        return -1;
      case 1: 
        locall.RCN = locala.abFh.AK();
        AppMethodBeat.o(143955);
        return 0;
      case 2: 
        locall.action = locala.abFh.AK();
        AppMethodBeat.o(143955);
        return 0;
      case 3: 
        locall.RCO = locala.abFh.AK();
        AppMethodBeat.o(143955);
        return 0;
      case 4: 
        locall.RCP = locala.abFh.AK();
        AppMethodBeat.o(143955);
        return 0;
      case 5: 
        locall.RCQ = locala.abFh.AK();
        AppMethodBeat.o(143955);
        return 0;
      case 6: 
        locall.RCR = locala.abFh.AK();
        AppMethodBeat.o(143955);
        return 0;
      case 7: 
        locall.RCS = locala.abFh.AK();
        AppMethodBeat.o(143955);
        return 0;
      }
      locall.RCT = locala.abFh.AK();
      AppMethodBeat.o(143955);
      return 0;
    }
    AppMethodBeat.o(143955);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.l
 * JD-Core Version:    0.7.0.1
 */