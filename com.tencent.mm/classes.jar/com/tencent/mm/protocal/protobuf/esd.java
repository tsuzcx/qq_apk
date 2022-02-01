package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class esd
  extends com.tencent.mm.bx.a
{
  public int ret;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127173);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(127173);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      paramVarArgs.bS(2, this.ret);
      AppMethodBeat.o(127173);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.username) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.ret);
      AppMethodBeat.o(127173);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(127173);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127173);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        esd localesd = (esd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127173);
          return -1;
        case 1: 
          localesd.username = locala.ajGk.readString();
          AppMethodBeat.o(127173);
          return 0;
        }
        localesd.ret = locala.ajGk.aar();
        AppMethodBeat.o(127173);
        return 0;
      }
      AppMethodBeat.o(127173);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esd
 * JD-Core Version:    0.7.0.1
 */