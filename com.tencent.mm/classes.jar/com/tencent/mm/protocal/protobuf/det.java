package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class det
  extends com.tencent.mm.bw.a
{
  public String appId;
  public String path;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209809);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.e(1, this.appId);
      }
      if (this.path != null) {
        paramVarArgs.e(2, this.path);
      }
      AppMethodBeat.o(209809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.appId) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.path != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.path);
      }
      AppMethodBeat.o(209809);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209809);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        det localdet = (det)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209809);
          return -1;
        case 1: 
          localdet.appId = locala.UbS.readString();
          AppMethodBeat.o(209809);
          return 0;
        }
        localdet.path = locala.UbS.readString();
        AppMethodBeat.o(209809);
        return 0;
      }
      AppMethodBeat.o(209809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.det
 * JD-Core Version:    0.7.0.1
 */