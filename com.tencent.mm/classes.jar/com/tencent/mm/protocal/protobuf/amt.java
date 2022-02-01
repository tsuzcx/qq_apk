package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class amt
  extends com.tencent.mm.bx.a
{
  public String YRE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104761);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YRE == null)
      {
        paramVarArgs = new b("Not all required fields were included: Text");
        AppMethodBeat.o(104761);
        throw paramVarArgs;
      }
      if (this.YRE != null) {
        paramVarArgs.g(1, this.YRE);
      }
      AppMethodBeat.o(104761);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YRE == null) {
        break label257;
      }
    }
    label257:
    for (paramInt = i.a.a.b.b.a.h(1, this.YRE) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(104761);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YRE == null)
        {
          paramVarArgs = new b("Not all required fields were included: Text");
          AppMethodBeat.o(104761);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104761);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        amt localamt = (amt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104761);
          return -1;
        }
        localamt.YRE = locala.ajGk.readString();
        AppMethodBeat.o(104761);
        return 0;
      }
      AppMethodBeat.o(104761);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amt
 * JD-Core Version:    0.7.0.1
 */