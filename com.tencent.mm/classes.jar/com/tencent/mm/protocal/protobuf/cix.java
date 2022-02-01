package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class cix
  extends com.tencent.mm.bx.a
{
  public String ZuK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104778);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZuK == null)
      {
        paramVarArgs = new b("Not all required fields were included: HeadUrl");
        AppMethodBeat.o(104778);
        throw paramVarArgs;
      }
      if (this.ZuK != null) {
        paramVarArgs.g(1, this.ZuK);
      }
      AppMethodBeat.o(104778);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZuK == null) {
        break label257;
      }
    }
    label257:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZuK) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(104778);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ZuK == null)
        {
          paramVarArgs = new b("Not all required fields were included: HeadUrl");
          AppMethodBeat.o(104778);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104778);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cix localcix = (cix)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104778);
          return -1;
        }
        localcix.ZuK = locala.ajGk.readString();
        AppMethodBeat.o(104778);
        return 0;
      }
      AppMethodBeat.o(104778);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cix
 * JD-Core Version:    0.7.0.1
 */