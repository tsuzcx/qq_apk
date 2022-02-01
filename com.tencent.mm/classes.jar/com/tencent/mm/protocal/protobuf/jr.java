package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class jr
  extends com.tencent.mm.bw.a
{
  public b KOh;
  public b KOi;
  public int KOj;
  public b KOk;
  public int Scene;
  public int rBx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133156);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KOh != null) {
        paramVarArgs.c(1, this.KOh);
      }
      paramVarArgs.aM(2, this.rBx);
      if (this.KOi != null) {
        paramVarArgs.c(3, this.KOi);
      }
      paramVarArgs.aM(4, this.KOj);
      if (this.KOk != null) {
        paramVarArgs.c(5, this.KOk);
      }
      paramVarArgs.aM(6, this.Scene);
      AppMethodBeat.o(133156);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KOh == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = g.a.a.b.b.a.b(1, this.KOh) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.rBx);
      paramInt = i;
      if (this.KOi != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.KOi);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.KOj);
      paramInt = i;
      if (this.KOk != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.KOk);
      }
      i = g.a.a.b.b.a.bu(6, this.Scene);
      AppMethodBeat.o(133156);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(133156);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        jr localjr = (jr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(133156);
          return -1;
        case 1: 
          localjr.KOh = locala.UbS.hPo();
          AppMethodBeat.o(133156);
          return 0;
        case 2: 
          localjr.rBx = locala.UbS.zi();
          AppMethodBeat.o(133156);
          return 0;
        case 3: 
          localjr.KOi = locala.UbS.hPo();
          AppMethodBeat.o(133156);
          return 0;
        case 4: 
          localjr.KOj = locala.UbS.zi();
          AppMethodBeat.o(133156);
          return 0;
        case 5: 
          localjr.KOk = locala.UbS.hPo();
          AppMethodBeat.o(133156);
          return 0;
        }
        localjr.Scene = locala.UbS.zi();
        AppMethodBeat.o(133156);
        return 0;
      }
      AppMethodBeat.o(133156);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jr
 * JD-Core Version:    0.7.0.1
 */