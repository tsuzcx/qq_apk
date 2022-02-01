package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dmv
  extends com.tencent.mm.bw.a
{
  public String HUh;
  public int port;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32461);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HUh == null)
      {
        paramVarArgs = new b("Not all required fields were included: ip_str");
        AppMethodBeat.o(32461);
        throw paramVarArgs;
      }
      if (this.HUh != null) {
        paramVarArgs.d(1, this.HUh);
      }
      paramVarArgs.aS(2, this.port);
      AppMethodBeat.o(32461);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HUh == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.HUh) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.port);
      AppMethodBeat.o(32461);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HUh == null)
        {
          paramVarArgs = new b("Not all required fields were included: ip_str");
          AppMethodBeat.o(32461);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32461);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dmv localdmv = (dmv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32461);
          return -1;
        case 1: 
          localdmv.HUh = locala.OmT.readString();
          AppMethodBeat.o(32461);
          return 0;
        }
        localdmv.port = locala.OmT.zc();
        AppMethodBeat.o(32461);
        return 0;
      }
      AppMethodBeat.o(32461);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmv
 * JD-Core Version:    0.7.0.1
 */