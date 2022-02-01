package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bza
  extends com.tencent.mm.bx.a
{
  public int aaic;
  public int percent;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184213);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      paramVarArgs.bS(2, this.percent);
      paramVarArgs.bS(3, this.aaic);
      AppMethodBeat.o(184213);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.type);
      int i = i.a.a.b.b.a.cJ(2, this.percent);
      int j = i.a.a.b.b.a.cJ(3, this.aaic);
      AppMethodBeat.o(184213);
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
      AppMethodBeat.o(184213);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bza localbza = (bza)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184213);
        return -1;
      case 1: 
        localbza.type = locala.ajGk.aar();
        AppMethodBeat.o(184213);
        return 0;
      case 2: 
        localbza.percent = locala.ajGk.aar();
        AppMethodBeat.o(184213);
        return 0;
      }
      localbza.aaic = locala.ajGk.aar();
      AppMethodBeat.o(184213);
      return 0;
    }
    AppMethodBeat.o(184213);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bza
 * JD-Core Version:    0.7.0.1
 */