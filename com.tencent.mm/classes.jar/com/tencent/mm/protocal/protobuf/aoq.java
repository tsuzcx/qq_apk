package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aoq
  extends com.tencent.mm.bx.a
{
  public int ZqW;
  public int priority;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153144);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZqW);
      paramVarArgs.bS(2, this.priority);
      AppMethodBeat.o(153144);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.ZqW);
      int i = i.a.a.b.b.a.cJ(2, this.priority);
      AppMethodBeat.o(153144);
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
      AppMethodBeat.o(153144);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      aoq localaoq = (aoq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153144);
        return -1;
      case 1: 
        localaoq.ZqW = locala.ajGk.aar();
        AppMethodBeat.o(153144);
        return 0;
      }
      localaoq.priority = locala.ajGk.aar();
      AppMethodBeat.o(153144);
      return 0;
    }
    AppMethodBeat.o(153144);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoq
 * JD-Core Version:    0.7.0.1
 */