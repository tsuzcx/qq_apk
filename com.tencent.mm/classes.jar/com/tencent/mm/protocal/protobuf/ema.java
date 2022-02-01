package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ema
  extends com.tencent.mm.cd.a
{
  public String ip;
  public int port;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133197);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ip == null)
      {
        paramVarArgs = new b("Not all required fields were included: ip");
        AppMethodBeat.o(133197);
        throw paramVarArgs;
      }
      if (this.ip != null) {
        paramVarArgs.f(1, this.ip);
      }
      paramVarArgs.aY(2, this.port);
      AppMethodBeat.o(133197);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ip == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.g(1, this.ip) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.port);
      AppMethodBeat.o(133197);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
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
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ema localema = (ema)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(133197);
          return -1;
        case 1: 
          localema.ip = locala.abFh.readString();
          AppMethodBeat.o(133197);
          return 0;
        }
        localema.port = locala.abFh.AK();
        AppMethodBeat.o(133197);
        return 0;
      }
      AppMethodBeat.o(133197);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ema
 * JD-Core Version:    0.7.0.1
 */