package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cpm
  extends com.tencent.mm.bw.a
{
  public int MvC;
  public int MvD;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(225975);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.e(1, this.UserName);
      }
      paramVarArgs.aM(2, this.MvC);
      paramVarArgs.aM(3, this.MvD);
      AppMethodBeat.o(225975);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.f(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.MvC);
      int j = g.a.a.b.b.a.bu(3, this.MvD);
      AppMethodBeat.o(225975);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(225975);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cpm localcpm = (cpm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(225975);
          return -1;
        case 1: 
          localcpm.UserName = locala.UbS.readString();
          AppMethodBeat.o(225975);
          return 0;
        case 2: 
          localcpm.MvC = locala.UbS.zi();
          AppMethodBeat.o(225975);
          return 0;
        }
        localcpm.MvD = locala.UbS.zi();
        AppMethodBeat.o(225975);
        return 0;
      }
      AppMethodBeat.o(225975);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpm
 * JD-Core Version:    0.7.0.1
 */