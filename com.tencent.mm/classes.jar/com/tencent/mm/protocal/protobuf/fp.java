package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class fp
  extends com.tencent.mm.bx.a
{
  public String appid;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122485);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid == null)
      {
        paramVarArgs = new b("Not all required fields were included: appid");
        AppMethodBeat.o(122485);
        throw paramVarArgs;
      }
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      paramVarArgs.bS(2, this.status);
      AppMethodBeat.o(122485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.appid) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.status);
      AppMethodBeat.o(122485);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.appid == null)
        {
          paramVarArgs = new b("Not all required fields were included: appid");
          AppMethodBeat.o(122485);
          throw paramVarArgs;
        }
        AppMethodBeat.o(122485);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fp localfp = (fp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122485);
          return -1;
        case 1: 
          localfp.appid = locala.ajGk.readString();
          AppMethodBeat.o(122485);
          return 0;
        }
        localfp.status = locala.ajGk.aar();
        AppMethodBeat.o(122485);
        return 0;
      }
      AppMethodBeat.o(122485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fp
 * JD-Core Version:    0.7.0.1
 */