package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class djr
  extends com.tencent.mm.bx.a
{
  public int YWM;
  public int aaBU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175246);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YWM);
      paramVarArgs.bS(2, this.aaBU);
      AppMethodBeat.o(175246);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.YWM);
      int i = i.a.a.b.b.a.cJ(2, this.aaBU);
      AppMethodBeat.o(175246);
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
      AppMethodBeat.o(175246);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      djr localdjr = (djr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(175246);
        return -1;
      case 1: 
        localdjr.YWM = locala.ajGk.aar();
        AppMethodBeat.o(175246);
        return 0;
      }
      localdjr.aaBU = locala.ajGk.aar();
      AppMethodBeat.o(175246);
      return 0;
    }
    AppMethodBeat.o(175246);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djr
 * JD-Core Version:    0.7.0.1
 */