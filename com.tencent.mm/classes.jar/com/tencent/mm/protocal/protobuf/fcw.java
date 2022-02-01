package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class fcw
  extends com.tencent.mm.bw.a
{
  public b KSW;
  public String Mmv;
  public String dNI;
  public String qwo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123700);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mmv != null) {
        paramVarArgs.e(1, this.Mmv);
      }
      if (this.KSW != null) {
        paramVarArgs.c(2, this.KSW);
      }
      if (this.dNI != null) {
        paramVarArgs.e(3, this.dNI);
      }
      if (this.qwo != null) {
        paramVarArgs.e(4, this.qwo);
      }
      AppMethodBeat.o(123700);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Mmv == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.f(1, this.Mmv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KSW != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.KSW);
      }
      i = paramInt;
      if (this.dNI != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.dNI);
      }
      paramInt = i;
      if (this.qwo != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.qwo);
      }
      AppMethodBeat.o(123700);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123700);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fcw localfcw = (fcw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123700);
          return -1;
        case 1: 
          localfcw.Mmv = locala.UbS.readString();
          AppMethodBeat.o(123700);
          return 0;
        case 2: 
          localfcw.KSW = locala.UbS.hPo();
          AppMethodBeat.o(123700);
          return 0;
        case 3: 
          localfcw.dNI = locala.UbS.readString();
          AppMethodBeat.o(123700);
          return 0;
        }
        localfcw.qwo = locala.UbS.readString();
        AppMethodBeat.o(123700);
        return 0;
      }
      AppMethodBeat.o(123700);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcw
 * JD-Core Version:    0.7.0.1
 */