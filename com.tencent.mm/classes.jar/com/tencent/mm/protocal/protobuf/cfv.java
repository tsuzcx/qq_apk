package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cfv
  extends com.tencent.mm.bv.a
{
  public String ip;
  public int port;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(146150);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ip == null)
      {
        paramVarArgs = new b("Not all required fields were included: ip");
        AppMethodBeat.o(146150);
        throw paramVarArgs;
      }
      if (this.ip != null) {
        paramVarArgs.e(1, this.ip);
      }
      paramVarArgs.aO(2, this.port);
      AppMethodBeat.o(146150);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ip == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = e.a.a.b.b.a.f(1, this.ip) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.port);
      AppMethodBeat.o(146150);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.ip == null)
        {
          paramVarArgs = new b("Not all required fields were included: ip");
          AppMethodBeat.o(146150);
          throw paramVarArgs;
        }
        AppMethodBeat.o(146150);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cfv localcfv = (cfv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(146150);
          return -1;
        case 1: 
          localcfv.ip = locala.CLY.readString();
          AppMethodBeat.o(146150);
          return 0;
        }
        localcfv.port = locala.CLY.sl();
        AppMethodBeat.o(146150);
        return 0;
      }
      AppMethodBeat.o(146150);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfv
 * JD-Core Version:    0.7.0.1
 */