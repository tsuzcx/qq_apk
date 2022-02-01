package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class qu
  extends com.tencent.mm.cd.a
{
  public int RZd;
  public int RZe;
  public int RZf;
  public int cUP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91367);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.cUP);
      paramVarArgs.aY(2, this.RZd);
      paramVarArgs.aY(3, this.RZe);
      paramVarArgs.aY(4, this.RZf);
      AppMethodBeat.o(91367);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.cUP);
      int i = g.a.a.b.b.a.bM(2, this.RZd);
      int j = g.a.a.b.b.a.bM(3, this.RZe);
      int k = g.a.a.b.b.a.bM(4, this.RZf);
      AppMethodBeat.o(91367);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91367);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      qu localqu = (qu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91367);
        return -1;
      case 1: 
        localqu.cUP = locala.abFh.AK();
        AppMethodBeat.o(91367);
        return 0;
      case 2: 
        localqu.RZd = locala.abFh.AK();
        AppMethodBeat.o(91367);
        return 0;
      case 3: 
        localqu.RZe = locala.abFh.AK();
        AppMethodBeat.o(91367);
        return 0;
      }
      localqu.RZf = locala.abFh.AK();
      AppMethodBeat.o(91367);
      return 0;
    }
    AppMethodBeat.o(91367);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qu
 * JD-Core Version:    0.7.0.1
 */