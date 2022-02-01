package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ey
  extends com.tencent.mm.bw.a
{
  public String dNI;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122485);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dNI == null)
      {
        paramVarArgs = new b("Not all required fields were included: appid");
        AppMethodBeat.o(122485);
        throw paramVarArgs;
      }
      if (this.dNI != null) {
        paramVarArgs.e(1, this.dNI);
      }
      paramVarArgs.aM(2, this.status);
      AppMethodBeat.o(122485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dNI == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.f(1, this.dNI) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.status);
      AppMethodBeat.o(122485);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.dNI == null)
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
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ey localey = (ey)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122485);
          return -1;
        case 1: 
          localey.dNI = locala.UbS.readString();
          AppMethodBeat.o(122485);
          return 0;
        }
        localey.status = locala.UbS.zi();
        AppMethodBeat.o(122485);
        return 0;
      }
      AppMethodBeat.o(122485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ey
 * JD-Core Version:    0.7.0.1
 */