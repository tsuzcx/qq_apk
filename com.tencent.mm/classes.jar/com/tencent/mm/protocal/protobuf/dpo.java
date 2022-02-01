package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dpo
  extends com.tencent.mm.bx.a
{
  public int aaWn;
  public int aaWo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127497);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaWn);
      paramVarArgs.bS(2, this.aaWo);
      AppMethodBeat.o(127497);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.aaWn);
      int i = i.a.a.b.b.a.cJ(2, this.aaWo);
      AppMethodBeat.o(127497);
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
      AppMethodBeat.o(127497);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dpo localdpo = (dpo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127497);
        return -1;
      case 1: 
        localdpo.aaWn = locala.ajGk.aar();
        AppMethodBeat.o(127497);
        return 0;
      }
      localdpo.aaWo = locala.ajGk.aar();
      AppMethodBeat.o(127497);
      return 0;
    }
    AppMethodBeat.o(127497);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpo
 * JD-Core Version:    0.7.0.1
 */