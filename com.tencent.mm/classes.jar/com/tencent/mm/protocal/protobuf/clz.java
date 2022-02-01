package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class clz
  extends com.tencent.mm.bw.a
{
  public long boX;
  public String path;
  public long start;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201296);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.path == null)
      {
        paramVarArgs = new b("Not all required fields were included: path");
        AppMethodBeat.o(201296);
        throw paramVarArgs;
      }
      if (this.path != null) {
        paramVarArgs.e(1, this.path);
      }
      paramVarArgs.bb(2, this.start);
      paramVarArgs.bb(3, this.boX);
      AppMethodBeat.o(201296);
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
      int i = g.a.a.b.b.a.r(2, this.start);
      int j = g.a.a.b.b.a.r(3, this.boX);
      AppMethodBeat.o(201296);
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
          AppMethodBeat.o(201296);
          throw paramVarArgs;
        }
        AppMethodBeat.o(201296);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        clz localclz = (clz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(201296);
          return -1;
        case 1: 
          localclz.path = locala.UbS.readString();
          AppMethodBeat.o(201296);
          return 0;
        case 2: 
          localclz.start = locala.UbS.zl();
          AppMethodBeat.o(201296);
          return 0;
        }
        localclz.boX = locala.UbS.zl();
        AppMethodBeat.o(201296);
        return 0;
      }
      AppMethodBeat.o(201296);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clz
 * JD-Core Version:    0.7.0.1
 */