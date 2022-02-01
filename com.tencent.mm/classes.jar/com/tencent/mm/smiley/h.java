package com.tencent.mm.smiley;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends com.tencent.mm.bx.a
{
  public int max;
  public int min;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104919);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.min);
      paramVarArgs.bS(2, this.max);
      AppMethodBeat.o(104919);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.min);
      int i = i.a.a.b.b.a.cJ(2, this.max);
      AppMethodBeat.o(104919);
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
      AppMethodBeat.o(104919);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      h localh = (h)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104919);
        return -1;
      case 1: 
        localh.min = locala.ajGk.aar();
        AppMethodBeat.o(104919);
        return 0;
      }
      localh.max = locala.ajGk.aar();
      AppMethodBeat.o(104919);
      return 0;
    }
    AppMethodBeat.o(104919);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.smiley.h
 * JD-Core Version:    0.7.0.1
 */