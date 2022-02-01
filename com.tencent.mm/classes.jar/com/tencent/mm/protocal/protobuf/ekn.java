package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ekn
  extends com.tencent.mm.bw.a
{
  public long duration;
  public String path;
  public long wKD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201303);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.path == null)
      {
        paramVarArgs = new b("Not all required fields were included: path");
        AppMethodBeat.o(201303);
        throw paramVarArgs;
      }
      if (this.path != null) {
        paramVarArgs.e(1, this.path);
      }
      paramVarArgs.bb(2, this.wKD);
      paramVarArgs.bb(3, this.duration);
      AppMethodBeat.o(201303);
      return 0;
    }
    if (paramInt == 1) {
      if (this.path == null) {
        break label354;
      }
    }
    label354:
    for (paramInt = g.a.a.b.b.a.f(1, this.path) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.r(2, this.wKD);
      int j = g.a.a.b.b.a.r(3, this.duration);
      AppMethodBeat.o(201303);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.path == null)
        {
          paramVarArgs = new b("Not all required fields were included: path");
          AppMethodBeat.o(201303);
          throw paramVarArgs;
        }
        AppMethodBeat.o(201303);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ekn localekn = (ekn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(201303);
          return -1;
        case 1: 
          localekn.path = locala.UbS.readString();
          AppMethodBeat.o(201303);
          return 0;
        case 2: 
          localekn.wKD = locala.UbS.zl();
          AppMethodBeat.o(201303);
          return 0;
        }
        localekn.duration = locala.UbS.zl();
        AppMethodBeat.o(201303);
        return 0;
      }
      AppMethodBeat.o(201303);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekn
 * JD-Core Version:    0.7.0.1
 */