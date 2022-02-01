package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class akv
  extends com.tencent.mm.bw.a
{
  public String LtA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32201);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LtA == null)
      {
        paramVarArgs = new b("Not all required fields were included: LoginUrl");
        AppMethodBeat.o(32201);
        throw paramVarArgs;
      }
      if (this.LtA != null) {
        paramVarArgs.e(1, this.LtA);
      }
      AppMethodBeat.o(32201);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LtA == null) {
        break label268;
      }
    }
    label268:
    for (paramInt = g.a.a.b.b.a.f(1, this.LtA) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(32201);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.LtA == null)
        {
          paramVarArgs = new b("Not all required fields were included: LoginUrl");
          AppMethodBeat.o(32201);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32201);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        akv localakv = (akv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32201);
          return -1;
        }
        localakv.LtA = locala.UbS.readString();
        AppMethodBeat.o(32201);
        return 0;
      }
      AppMethodBeat.o(32201);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akv
 * JD-Core Version:    0.7.0.1
 */