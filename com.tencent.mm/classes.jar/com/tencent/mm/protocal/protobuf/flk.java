package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class flk
  extends com.tencent.mm.bx.a
{
  public int abLQ;
  public int tab_type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259067);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.tab_type);
      paramVarArgs.bS(2, this.abLQ);
      AppMethodBeat.o(259067);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.tab_type);
      int i = i.a.a.b.b.a.cJ(2, this.abLQ);
      AppMethodBeat.o(259067);
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
      AppMethodBeat.o(259067);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      flk localflk = (flk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259067);
        return -1;
      case 1: 
        localflk.tab_type = locala.ajGk.aar();
        AppMethodBeat.o(259067);
        return 0;
      }
      localflk.abLQ = locala.ajGk.aar();
      AppMethodBeat.o(259067);
      return 0;
    }
    AppMethodBeat.o(259067);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.flk
 * JD-Core Version:    0.7.0.1
 */