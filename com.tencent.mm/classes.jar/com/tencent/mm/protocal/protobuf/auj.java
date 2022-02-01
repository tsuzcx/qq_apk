package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class auj
  extends com.tencent.mm.bx.a
{
  public String HIH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257863);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.HIH != null) {
        paramVarArgs.g(1, this.HIH);
      }
      AppMethodBeat.o(257863);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HIH == null) {
        break label209;
      }
    }
    label209:
    for (paramInt = i.a.a.b.b.a.h(1, this.HIH) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(257863);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257863);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        auj localauj = (auj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257863);
          return -1;
        }
        localauj.HIH = locala.ajGk.readString();
        AppMethodBeat.o(257863);
        return 0;
      }
      AppMethodBeat.o(257863);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auj
 * JD-Core Version:    0.7.0.1
 */