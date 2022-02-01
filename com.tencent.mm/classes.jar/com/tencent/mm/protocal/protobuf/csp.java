package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class csp
  extends com.tencent.mm.cd.a
{
  public int RYM;
  public int TnN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175246);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RYM);
      paramVarArgs.aY(2, this.TnN);
      AppMethodBeat.o(175246);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.RYM);
      int i = g.a.a.b.b.a.bM(2, this.TnN);
      AppMethodBeat.o(175246);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(175246);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      csp localcsp = (csp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(175246);
        return -1;
      case 1: 
        localcsp.RYM = locala.abFh.AK();
        AppMethodBeat.o(175246);
        return 0;
      }
      localcsp.TnN = locala.abFh.AK();
      AppMethodBeat.o(175246);
      return 0;
    }
    AppMethodBeat.o(175246);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csp
 * JD-Core Version:    0.7.0.1
 */