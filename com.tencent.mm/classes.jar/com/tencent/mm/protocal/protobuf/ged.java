package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class ged
  extends com.tencent.mm.bx.a
{
  public b acbL;
  public b acbM;
  public b acbN;
  public b acbO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91729);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acbL != null) {
        paramVarArgs.d(1, this.acbL);
      }
      if (this.acbM != null) {
        paramVarArgs.d(2, this.acbM);
      }
      if (this.acbN != null) {
        paramVarArgs.d(3, this.acbN);
      }
      if (this.acbO != null) {
        paramVarArgs.d(4, this.acbO);
      }
      AppMethodBeat.o(91729);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acbL == null) {
        break label390;
      }
    }
    label390:
    for (int i = i.a.a.b.b.a.c(1, this.acbL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.acbM != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.acbM);
      }
      i = paramInt;
      if (this.acbN != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.acbN);
      }
      paramInt = i;
      if (this.acbO != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.acbO);
      }
      AppMethodBeat.o(91729);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91729);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ged localged = (ged)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91729);
          return -1;
        case 1: 
          localged.acbL = locala.ajGk.kFX();
          AppMethodBeat.o(91729);
          return 0;
        case 2: 
          localged.acbM = locala.ajGk.kFX();
          AppMethodBeat.o(91729);
          return 0;
        case 3: 
          localged.acbN = locala.ajGk.kFX();
          AppMethodBeat.o(91729);
          return 0;
        }
        localged.acbO = locala.ajGk.kFX();
        AppMethodBeat.o(91729);
        return 0;
      }
      AppMethodBeat.o(91729);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ged
 * JD-Core Version:    0.7.0.1
 */