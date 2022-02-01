package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gli
  extends com.tencent.mm.bx.a
{
  public int aaQX;
  public int acgK;
  public long acgR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50119);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaQX);
      paramVarArgs.bv(2, this.acgR);
      paramVarArgs.bS(3, this.acgK);
      AppMethodBeat.o(50119);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.aaQX);
      int i = i.a.a.b.b.a.q(2, this.acgR);
      int j = i.a.a.b.b.a.cJ(3, this.acgK);
      AppMethodBeat.o(50119);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(50119);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gli localgli = (gli)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50119);
        return -1;
      case 1: 
        localgli.aaQX = locala.ajGk.aar();
        AppMethodBeat.o(50119);
        return 0;
      case 2: 
        localgli.acgR = locala.ajGk.aaw();
        AppMethodBeat.o(50119);
        return 0;
      }
      localgli.acgK = locala.ajGk.aar();
      AppMethodBeat.o(50119);
      return 0;
    }
    AppMethodBeat.o(50119);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gli
 * JD-Core Version:    0.7.0.1
 */