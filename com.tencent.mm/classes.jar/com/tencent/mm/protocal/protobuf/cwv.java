package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cwv
  extends com.tencent.mm.bx.a
{
  public String ip;
  public int port;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133197);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ip == null)
      {
        paramVarArgs = new b("Not all required fields were included: ip");
        AppMethodBeat.o(133197);
        throw paramVarArgs;
      }
      if (this.ip != null) {
        paramVarArgs.d(1, this.ip);
      }
      paramVarArgs.aR(2, this.port);
      AppMethodBeat.o(133197);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ip == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.ip) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.port);
      AppMethodBeat.o(133197);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cwv localcwv = (cwv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(133197);
          return -1;
        case 1: 
          localcwv.ip = locala.KhF.readString();
          AppMethodBeat.o(133197);
          return 0;
        }
        localcwv.port = locala.KhF.xS();
        AppMethodBeat.o(133197);
        return 0;
      }
      AppMethodBeat.o(133197);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwv
 * JD-Core Version:    0.7.0.1
 */