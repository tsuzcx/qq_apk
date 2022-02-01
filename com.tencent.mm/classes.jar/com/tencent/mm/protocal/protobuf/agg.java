package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class agg
  extends com.tencent.mm.bw.a
{
  public String ClZ;
  public int code;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72468);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ClZ != null) {
        paramVarArgs.e(1, this.ClZ);
      }
      paramVarArgs.aM(2, this.code);
      AppMethodBeat.o(72468);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ClZ == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = g.a.a.b.b.a.f(1, this.ClZ) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.code);
      AppMethodBeat.o(72468);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72468);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        agg localagg = (agg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72468);
          return -1;
        case 1: 
          localagg.ClZ = locala.UbS.readString();
          AppMethodBeat.o(72468);
          return 0;
        }
        localagg.code = locala.UbS.zi();
        AppMethodBeat.o(72468);
        return 0;
      }
      AppMethodBeat.o(72468);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agg
 * JD-Core Version:    0.7.0.1
 */