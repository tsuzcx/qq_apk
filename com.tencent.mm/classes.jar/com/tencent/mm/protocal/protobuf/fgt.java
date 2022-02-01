package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class fgt
  extends com.tencent.mm.bx.a
{
  public String ip;
  public int port;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133197);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ip == null)
      {
        paramVarArgs = new b("Not all required fields were included: ip");
        AppMethodBeat.o(133197);
        throw paramVarArgs;
      }
      if (this.ip != null) {
        paramVarArgs.g(1, this.ip);
      }
      paramVarArgs.bS(2, this.port);
      AppMethodBeat.o(133197);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ip == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.ip) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.port);
      AppMethodBeat.o(133197);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ip == null)
        {
          paramVarArgs = new b("Not all required fields were included: ip");
          AppMethodBeat.o(133197);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133197);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fgt localfgt = (fgt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(133197);
          return -1;
        case 1: 
          localfgt.ip = locala.ajGk.readString();
          AppMethodBeat.o(133197);
          return 0;
        }
        localfgt.port = locala.ajGk.aar();
        AppMethodBeat.o(133197);
        return 0;
      }
      AppMethodBeat.o(133197);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fgt
 * JD-Core Version:    0.7.0.1
 */