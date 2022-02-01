package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gu
  extends com.tencent.mm.bw.a
{
  public int BsF;
  public int BsG;
  public int BsH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32125);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.BsF);
      paramVarArgs.aM(2, this.BsG);
      paramVarArgs.aM(3, this.BsH);
      AppMethodBeat.o(32125);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.BsF);
      int i = g.a.a.b.b.a.bu(2, this.BsG);
      int j = g.a.a.b.b.a.bu(3, this.BsH);
      AppMethodBeat.o(32125);
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
      AppMethodBeat.o(32125);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      gu localgu = (gu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32125);
        return -1;
      case 1: 
        localgu.BsF = locala.UbS.zi();
        AppMethodBeat.o(32125);
        return 0;
      case 2: 
        localgu.BsG = locala.UbS.zi();
        AppMethodBeat.o(32125);
        return 0;
      }
      localgu.BsH = locala.UbS.zi();
      AppMethodBeat.o(32125);
      return 0;
    }
    AppMethodBeat.o(32125);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gu
 * JD-Core Version:    0.7.0.1
 */