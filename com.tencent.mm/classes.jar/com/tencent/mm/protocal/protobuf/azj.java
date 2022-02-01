package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class azj
  extends com.tencent.mm.bw.a
{
  public int LJe;
  public int LJf;
  public b LJg;
  public String dkV;
  public String sessionId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196090);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dkV != null) {
        paramVarArgs.e(1, this.dkV);
      }
      if (this.sessionId != null) {
        paramVarArgs.e(2, this.sessionId);
      }
      paramVarArgs.aM(3, this.LJe);
      paramVarArgs.aM(4, this.LJf);
      if (this.LJg != null) {
        paramVarArgs.c(5, this.LJg);
      }
      AppMethodBeat.o(196090);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dkV == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.b.b.a.f(1, this.dkV) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sessionId != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.sessionId);
      }
      i = i + g.a.a.b.b.a.bu(3, this.LJe) + g.a.a.b.b.a.bu(4, this.LJf);
      paramInt = i;
      if (this.LJg != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.LJg);
      }
      AppMethodBeat.o(196090);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(196090);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        azj localazj = (azj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(196090);
          return -1;
        case 1: 
          localazj.dkV = locala.UbS.readString();
          AppMethodBeat.o(196090);
          return 0;
        case 2: 
          localazj.sessionId = locala.UbS.readString();
          AppMethodBeat.o(196090);
          return 0;
        case 3: 
          localazj.LJe = locala.UbS.zi();
          AppMethodBeat.o(196090);
          return 0;
        case 4: 
          localazj.LJf = locala.UbS.zi();
          AppMethodBeat.o(196090);
          return 0;
        }
        localazj.LJg = locala.UbS.hPo();
        AppMethodBeat.o(196090);
        return 0;
      }
      AppMethodBeat.o(196090);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azj
 * JD-Core Version:    0.7.0.1
 */