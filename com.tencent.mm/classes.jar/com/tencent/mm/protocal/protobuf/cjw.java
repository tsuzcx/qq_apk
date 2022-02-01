package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cjw
  extends com.tencent.mm.bw.a
{
  public String Mpp;
  public int end;
  public int start;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(225974);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mpp != null) {
        paramVarArgs.e(1, this.Mpp);
      }
      paramVarArgs.aM(2, this.start);
      paramVarArgs.aM(3, this.end);
      AppMethodBeat.o(225974);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Mpp == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.f(1, this.Mpp) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.start);
      int j = g.a.a.b.b.a.bu(3, this.end);
      AppMethodBeat.o(225974);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(225974);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cjw localcjw = (cjw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(225974);
          return -1;
        case 1: 
          localcjw.Mpp = locala.UbS.readString();
          AppMethodBeat.o(225974);
          return 0;
        case 2: 
          localcjw.start = locala.UbS.zi();
          AppMethodBeat.o(225974);
          return 0;
        }
        localcjw.end = locala.UbS.zi();
        AppMethodBeat.o(225974);
        return 0;
      }
      AppMethodBeat.o(225974);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjw
 * JD-Core Version:    0.7.0.1
 */