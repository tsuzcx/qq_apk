package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class cay
  extends com.tencent.mm.bw.a
{
  public b KOi;
  public b KOk;
  public b Mgr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32321);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KOk != null) {
        paramVarArgs.c(1, this.KOk);
      }
      if (this.KOi != null) {
        paramVarArgs.c(2, this.KOi);
      }
      if (this.Mgr != null) {
        paramVarArgs.c(3, this.Mgr);
      }
      AppMethodBeat.o(32321);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KOk == null) {
        break label343;
      }
    }
    label343:
    for (int i = g.a.a.b.b.a.b(1, this.KOk) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KOi != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.KOi);
      }
      i = paramInt;
      if (this.Mgr != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.Mgr);
      }
      AppMethodBeat.o(32321);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32321);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cay localcay = (cay)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32321);
          return -1;
        case 1: 
          localcay.KOk = locala.UbS.hPo();
          AppMethodBeat.o(32321);
          return 0;
        case 2: 
          localcay.KOi = locala.UbS.hPo();
          AppMethodBeat.o(32321);
          return 0;
        }
        localcay.Mgr = locala.UbS.hPo();
        AppMethodBeat.o(32321);
        return 0;
      }
      AppMethodBeat.o(32321);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cay
 * JD-Core Version:    0.7.0.1
 */