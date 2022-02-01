package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bek
  extends com.tencent.mm.bw.a
{
  public int LOf;
  public int percent;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184213);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.type);
      paramVarArgs.aM(2, this.percent);
      paramVarArgs.aM(3, this.LOf);
      AppMethodBeat.o(184213);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.type);
      int i = g.a.a.b.b.a.bu(2, this.percent);
      int j = g.a.a.b.b.a.bu(3, this.LOf);
      AppMethodBeat.o(184213);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(184213);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bek localbek = (bek)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184213);
        return -1;
      case 1: 
        localbek.type = locala.UbS.zi();
        AppMethodBeat.o(184213);
        return 0;
      case 2: 
        localbek.percent = locala.UbS.zi();
        AppMethodBeat.o(184213);
        return 0;
      }
      localbek.LOf = locala.UbS.zi();
      AppMethodBeat.o(184213);
      return 0;
    }
    AppMethodBeat.o(184213);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bek
 * JD-Core Version:    0.7.0.1
 */