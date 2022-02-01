package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ez
  extends com.tencent.mm.bx.a
{
  public String signature;
  public String xlr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152489);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.signature != null) {
        paramVarArgs.g(1, this.signature);
      }
      if (this.xlr != null) {
        paramVarArgs.g(2, this.xlr);
      }
      AppMethodBeat.o(152489);
      return 0;
    }
    if (paramInt == 1) {
      if (this.signature == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.signature) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xlr != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.xlr);
      }
      AppMethodBeat.o(152489);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152489);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ez localez = (ez)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152489);
          return -1;
        case 1: 
          localez.signature = locala.ajGk.readString();
          AppMethodBeat.o(152489);
          return 0;
        }
        localez.xlr = locala.ajGk.readString();
        AppMethodBeat.o(152489);
        return 0;
      }
      AppMethodBeat.o(152489);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ez
 * JD-Core Version:    0.7.0.1
 */