package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gr
  extends com.tencent.mm.bx.a
{
  public String muA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152495);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.muA != null) {
        paramVarArgs.g(1, this.muA);
      }
      AppMethodBeat.o(152495);
      return 0;
    }
    if (paramInt == 1) {
      if (this.muA == null) {
        break label209;
      }
    }
    label209:
    for (paramInt = i.a.a.b.b.a.h(1, this.muA) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(152495);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152495);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gr localgr = (gr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152495);
          return -1;
        }
        localgr.muA = locala.ajGk.readString();
        AppMethodBeat.o(152495);
        return 0;
      }
      AppMethodBeat.o(152495);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gr
 * JD-Core Version:    0.7.0.1
 */