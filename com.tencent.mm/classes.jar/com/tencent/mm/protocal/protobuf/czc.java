package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class czc
  extends com.tencent.mm.bx.a
{
  public b YMq;
  public b YMs;
  public b aaEf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32321);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YMs != null) {
        paramVarArgs.d(1, this.YMs);
      }
      if (this.YMq != null) {
        paramVarArgs.d(2, this.YMq);
      }
      if (this.aaEf != null) {
        paramVarArgs.d(3, this.aaEf);
      }
      AppMethodBeat.o(32321);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YMs == null) {
        break label339;
      }
    }
    label339:
    for (int i = i.a.a.b.b.a.c(1, this.YMs) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YMq != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.YMq);
      }
      i = paramInt;
      if (this.aaEf != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.aaEf);
      }
      AppMethodBeat.o(32321);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32321);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        czc localczc = (czc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32321);
          return -1;
        case 1: 
          localczc.YMs = locala.ajGk.kFX();
          AppMethodBeat.o(32321);
          return 0;
        case 2: 
          localczc.YMq = locala.ajGk.kFX();
          AppMethodBeat.o(32321);
          return 0;
        }
        localczc.aaEf = locala.ajGk.kFX();
        AppMethodBeat.o(32321);
        return 0;
      }
      AppMethodBeat.o(32321);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czc
 * JD-Core Version:    0.7.0.1
 */