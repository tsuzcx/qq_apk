package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class asq
  extends com.tencent.mm.bx.a
{
  public long endTime = 0L;
  public int feedCount = 0;
  public long startTime = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122489);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.startTime);
      paramVarArgs.bv(2, this.endTime);
      paramVarArgs.bS(3, this.feedCount);
      AppMethodBeat.o(122489);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.startTime);
      int i = i.a.a.b.b.a.q(2, this.endTime);
      int j = i.a.a.b.b.a.cJ(3, this.feedCount);
      AppMethodBeat.o(122489);
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
      AppMethodBeat.o(122489);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      asq localasq = (asq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122489);
        return -1;
      case 1: 
        localasq.startTime = locala.ajGk.aaw();
        AppMethodBeat.o(122489);
        return 0;
      case 2: 
        localasq.endTime = locala.ajGk.aaw();
        AppMethodBeat.o(122489);
        return 0;
      }
      localasq.feedCount = locala.ajGk.aar();
      AppMethodBeat.o(122489);
      return 0;
    }
    AppMethodBeat.o(122489);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asq
 * JD-Core Version:    0.7.0.1
 */