package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class cba
  extends com.tencent.mm.bw.a
{
  public b KOi;
  public b KOk;
  public int him;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124514);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KOk != null) {
        paramVarArgs.c(1, this.KOk);
      }
      if (this.KOi != null) {
        paramVarArgs.c(2, this.KOi);
      }
      paramVarArgs.aM(3, this.him);
      AppMethodBeat.o(124514);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KOk == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.b(1, this.KOk) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KOi != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.KOi);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.him);
      AppMethodBeat.o(124514);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124514);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cba localcba = (cba)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124514);
          return -1;
        case 1: 
          localcba.KOk = locala.UbS.hPo();
          AppMethodBeat.o(124514);
          return 0;
        case 2: 
          localcba.KOi = locala.UbS.hPo();
          AppMethodBeat.o(124514);
          return 0;
        }
        localcba.him = locala.UbS.zi();
        AppMethodBeat.o(124514);
        return 0;
      }
      AppMethodBeat.o(124514);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cba
 * JD-Core Version:    0.7.0.1
 */