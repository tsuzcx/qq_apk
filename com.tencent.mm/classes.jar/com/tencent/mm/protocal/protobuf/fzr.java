package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fzr
  extends com.tencent.mm.bx.a
{
  public int abXA;
  public int abXz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115867);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abXz);
      paramVarArgs.bS(2, this.abXA);
      AppMethodBeat.o(115867);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.abXz);
      int i = i.a.a.b.b.a.cJ(2, this.abXA);
      AppMethodBeat.o(115867);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(115867);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fzr localfzr = (fzr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115867);
        return -1;
      case 1: 
        localfzr.abXz = locala.ajGk.aar();
        AppMethodBeat.o(115867);
        return 0;
      }
      localfzr.abXA = locala.ajGk.aar();
      AppMethodBeat.o(115867);
      return 0;
    }
    AppMethodBeat.o(115867);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fzr
 * JD-Core Version:    0.7.0.1
 */