package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class esm
  extends com.tencent.mm.bw.a
{
  public int NpA;
  public String NpE;
  public int jeU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32501);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.NpA);
      paramVarArgs.aM(2, this.jeU);
      if (this.NpE != null) {
        paramVarArgs.e(3, this.NpE);
      }
      AppMethodBeat.o(32501);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.NpA) + 0 + g.a.a.b.b.a.bu(2, this.jeU);
      paramInt = i;
      if (this.NpE != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.NpE);
      }
      AppMethodBeat.o(32501);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(32501);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      esm localesm = (esm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32501);
        return -1;
      case 1: 
        localesm.NpA = locala.UbS.zi();
        AppMethodBeat.o(32501);
        return 0;
      case 2: 
        localesm.jeU = locala.UbS.zi();
        AppMethodBeat.o(32501);
        return 0;
      }
      localesm.NpE = locala.UbS.readString();
      AppMethodBeat.o(32501);
      return 0;
    }
    AppMethodBeat.o(32501);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esm
 * JD-Core Version:    0.7.0.1
 */