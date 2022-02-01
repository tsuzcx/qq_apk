package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ffd
  extends com.tencent.mm.bw.a
{
  public int MCa;
  public String NAt;
  public boolean NAy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50127);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NAt != null) {
        paramVarArgs.e(1, this.NAt);
      }
      paramVarArgs.cc(2, this.NAy);
      paramVarArgs.aM(3, this.MCa);
      AppMethodBeat.o(50127);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NAt == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = g.a.a.b.b.a.f(1, this.NAt) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.fS(2);
      int j = g.a.a.b.b.a.bu(3, this.MCa);
      AppMethodBeat.o(50127);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(50127);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ffd localffd = (ffd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50127);
          return -1;
        case 1: 
          localffd.NAt = locala.UbS.readString();
          AppMethodBeat.o(50127);
          return 0;
        case 2: 
          localffd.NAy = locala.UbS.yZ();
          AppMethodBeat.o(50127);
          return 0;
        }
        localffd.MCa = locala.UbS.zi();
        AppMethodBeat.o(50127);
        return 0;
      }
      AppMethodBeat.o(50127);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffd
 * JD-Core Version:    0.7.0.1
 */