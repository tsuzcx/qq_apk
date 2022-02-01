package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class bdl
  extends com.tencent.mm.bw.a
{
  public String Gbg;
  public int LNk;
  public b ybi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209699);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Gbg != null) {
        paramVarArgs.e(1, this.Gbg);
      }
      paramVarArgs.aM(2, this.LNk);
      if (this.ybi != null) {
        paramVarArgs.c(3, this.ybi);
      }
      AppMethodBeat.o(209699);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gbg == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.Gbg) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LNk);
      paramInt = i;
      if (this.ybi != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.ybi);
      }
      AppMethodBeat.o(209699);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209699);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bdl localbdl = (bdl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209699);
          return -1;
        case 1: 
          localbdl.Gbg = locala.UbS.readString();
          AppMethodBeat.o(209699);
          return 0;
        case 2: 
          localbdl.LNk = locala.UbS.zi();
          AppMethodBeat.o(209699);
          return 0;
        }
        localbdl.ybi = locala.UbS.hPo();
        AppMethodBeat.o(209699);
        return 0;
      }
      AppMethodBeat.o(209699);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdl
 * JD-Core Version:    0.7.0.1
 */