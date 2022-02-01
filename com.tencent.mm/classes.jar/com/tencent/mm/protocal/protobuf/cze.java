package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class cze
  extends com.tencent.mm.bx.a
{
  public b YMq;
  public b YMs;
  public int muC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124514);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YMs != null) {
        paramVarArgs.d(1, this.YMs);
      }
      if (this.YMq != null) {
        paramVarArgs.d(2, this.YMq);
      }
      paramVarArgs.bS(3, this.muC);
      AppMethodBeat.o(124514);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YMs == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.c(1, this.YMs) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YMq != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.YMq);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.muC);
      AppMethodBeat.o(124514);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124514);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cze localcze = (cze)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124514);
          return -1;
        case 1: 
          localcze.YMs = locala.ajGk.kFX();
          AppMethodBeat.o(124514);
          return 0;
        case 2: 
          localcze.YMq = locala.ajGk.kFX();
          AppMethodBeat.o(124514);
          return 0;
        }
        localcze.muC = locala.ajGk.aar();
        AppMethodBeat.o(124514);
        return 0;
      }
      AppMethodBeat.o(124514);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cze
 * JD-Core Version:    0.7.0.1
 */