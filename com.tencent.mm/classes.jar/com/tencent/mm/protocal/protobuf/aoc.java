package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aoc
  extends com.tencent.mm.bw.a
{
  public String LiU;
  public int Lja;
  public int oTW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127494);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LiU != null) {
        paramVarArgs.e(1, this.LiU);
      }
      paramVarArgs.aM(2, this.Lja);
      paramVarArgs.aM(3, this.oTW);
      AppMethodBeat.o(127494);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LiU == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.f(1, this.LiU) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.Lja);
      int j = g.a.a.b.b.a.bu(3, this.oTW);
      AppMethodBeat.o(127494);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(127494);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aoc localaoc = (aoc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127494);
          return -1;
        case 1: 
          localaoc.LiU = locala.UbS.readString();
          AppMethodBeat.o(127494);
          return 0;
        case 2: 
          localaoc.Lja = locala.UbS.zi();
          AppMethodBeat.o(127494);
          return 0;
        }
        localaoc.oTW = locala.UbS.zi();
        AppMethodBeat.o(127494);
        return 0;
      }
      AppMethodBeat.o(127494);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoc
 * JD-Core Version:    0.7.0.1
 */