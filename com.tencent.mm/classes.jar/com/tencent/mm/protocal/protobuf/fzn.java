package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fzn
  extends com.tencent.mm.bx.a
{
  public int abMm;
  public String abMn;
  public int abmN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115860);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abMm);
      paramVarArgs.bS(2, this.abmN);
      if (this.abMn != null) {
        paramVarArgs.g(3, this.abMn);
      }
      AppMethodBeat.o(115860);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.abMm) + 0 + i.a.a.b.b.a.cJ(2, this.abmN);
      paramInt = i;
      if (this.abMn != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.abMn);
      }
      AppMethodBeat.o(115860);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(115860);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fzn localfzn = (fzn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115860);
        return -1;
      case 1: 
        localfzn.abMm = locala.ajGk.aar();
        AppMethodBeat.o(115860);
        return 0;
      case 2: 
        localfzn.abmN = locala.ajGk.aar();
        AppMethodBeat.o(115860);
        return 0;
      }
      localfzn.abMn = locala.ajGk.readString();
      AppMethodBeat.o(115860);
      return 0;
    }
    AppMethodBeat.o(115860);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fzn
 * JD-Core Version:    0.7.0.1
 */