package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cgu
  extends com.tencent.mm.bw.a
{
  public String Mmb;
  public int Mmc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32335);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mmb != null) {
        paramVarArgs.e(1, this.Mmb);
      }
      paramVarArgs.aM(2, this.Mmc);
      AppMethodBeat.o(32335);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Mmb == null) {
        break label266;
      }
    }
    label266:
    for (paramInt = g.a.a.b.b.a.f(1, this.Mmb) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.Mmc);
      AppMethodBeat.o(32335);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32335);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cgu localcgu = (cgu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32335);
          return -1;
        case 1: 
          localcgu.Mmb = locala.UbS.readString();
          AppMethodBeat.o(32335);
          return 0;
        }
        localcgu.Mmc = locala.UbS.zi();
        AppMethodBeat.o(32335);
        return 0;
      }
      AppMethodBeat.o(32335);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgu
 * JD-Core Version:    0.7.0.1
 */