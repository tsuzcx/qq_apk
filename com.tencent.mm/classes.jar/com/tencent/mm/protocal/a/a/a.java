package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.bx.a
{
  public int YyQ;
  public int count;
  public int value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143939);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YyQ);
      paramVarArgs.bS(2, this.value);
      paramVarArgs.bS(3, this.count);
      AppMethodBeat.o(143939);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.YyQ);
      int i = i.a.a.b.b.a.cJ(2, this.value);
      int j = i.a.a.b.b.a.cJ(3, this.count);
      AppMethodBeat.o(143939);
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
      AppMethodBeat.o(143939);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143939);
        return -1;
      case 1: 
        locala1.YyQ = locala.ajGk.aar();
        AppMethodBeat.o(143939);
        return 0;
      case 2: 
        locala1.value = locala.ajGk.aar();
        AppMethodBeat.o(143939);
        return 0;
      }
      locala1.count = locala.ajGk.aar();
      AppMethodBeat.o(143939);
      return 0;
    }
    AppMethodBeat.o(143939);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.a
 * JD-Core Version:    0.7.0.1
 */