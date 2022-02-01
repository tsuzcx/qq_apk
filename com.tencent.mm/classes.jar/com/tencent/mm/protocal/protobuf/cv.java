package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cv
  extends com.tencent.mm.cd.a
{
  public int RIr;
  public int RIs;
  public int RIt;
  public int RIu;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127429);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RIr);
      paramVarArgs.aY(2, this.rWu);
      paramVarArgs.aY(3, this.RIs);
      paramVarArgs.aY(4, this.RIt);
      paramVarArgs.aY(5, this.RIu);
      AppMethodBeat.o(127429);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.RIr);
      int i = g.a.a.b.b.a.bM(2, this.rWu);
      int j = g.a.a.b.b.a.bM(3, this.RIs);
      int k = g.a.a.b.b.a.bM(4, this.RIt);
      int m = g.a.a.b.b.a.bM(5, this.RIu);
      AppMethodBeat.o(127429);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(127429);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cv localcv = (cv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127429);
        return -1;
      case 1: 
        localcv.RIr = locala.abFh.AK();
        AppMethodBeat.o(127429);
        return 0;
      case 2: 
        localcv.rWu = locala.abFh.AK();
        AppMethodBeat.o(127429);
        return 0;
      case 3: 
        localcv.RIs = locala.abFh.AK();
        AppMethodBeat.o(127429);
        return 0;
      case 4: 
        localcv.RIt = locala.abFh.AK();
        AppMethodBeat.o(127429);
        return 0;
      }
      localcv.RIu = locala.abFh.AK();
      AppMethodBeat.o(127429);
      return 0;
    }
    AppMethodBeat.o(127429);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cv
 * JD-Core Version:    0.7.0.1
 */