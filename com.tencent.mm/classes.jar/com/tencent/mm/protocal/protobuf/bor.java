package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bor
  extends com.tencent.mm.bx.a
{
  public String ZXi;
  public long ZXj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258286);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZXi != null) {
        paramVarArgs.g(1, this.ZXi);
      }
      paramVarArgs.bv(2, this.ZXj);
      AppMethodBeat.o(258286);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZXi == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZXi) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.ZXj);
      AppMethodBeat.o(258286);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258286);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bor localbor = (bor)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258286);
          return -1;
        case 1: 
          localbor.ZXi = locala.ajGk.readString();
          AppMethodBeat.o(258286);
          return 0;
        }
        localbor.ZXj = locala.ajGk.aaw();
        AppMethodBeat.o(258286);
        return 0;
      }
      AppMethodBeat.o(258286);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bor
 * JD-Core Version:    0.7.0.1
 */