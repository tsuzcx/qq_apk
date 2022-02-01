package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class cqh
  extends com.tencent.mm.bw.a
{
  public int MvC;
  public String MvG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43111);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MvG == null)
      {
        paramVarArgs = new b("Not all required fields were included: ContactUsername");
        AppMethodBeat.o(43111);
        throw paramVarArgs;
      }
      if (this.MvG != null) {
        paramVarArgs.e(1, this.MvG);
      }
      paramVarArgs.aM(2, this.MvC);
      AppMethodBeat.o(43111);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MvG == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.f(1, this.MvG) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.MvC);
      AppMethodBeat.o(43111);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MvG == null)
        {
          paramVarArgs = new b("Not all required fields were included: ContactUsername");
          AppMethodBeat.o(43111);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43111);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cqh localcqh = (cqh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43111);
          return -1;
        case 1: 
          localcqh.MvG = locala.UbS.readString();
          AppMethodBeat.o(43111);
          return 0;
        }
        localcqh.MvC = locala.UbS.zi();
        AppMethodBeat.o(43111);
        return 0;
      }
      AppMethodBeat.o(43111);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqh
 * JD-Core Version:    0.7.0.1
 */