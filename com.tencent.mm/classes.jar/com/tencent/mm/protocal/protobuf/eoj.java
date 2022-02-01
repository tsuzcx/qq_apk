package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class eoj
  extends com.tencent.mm.bw.a
{
  public int Height;
  public b Nmh;
  public int Nmi;
  public long Nmj;
  public int Width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117938);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nmh != null) {
        paramVarArgs.c(1, this.Nmh);
      }
      paramVarArgs.aM(2, this.Nmi);
      paramVarArgs.bb(3, this.Nmj);
      paramVarArgs.aM(4, this.Width);
      paramVarArgs.aM(5, this.Height);
      AppMethodBeat.o(117938);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Nmh == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = g.a.a.b.b.a.b(1, this.Nmh) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.Nmi);
      int j = g.a.a.b.b.a.r(3, this.Nmj);
      int k = g.a.a.b.b.a.bu(4, this.Width);
      int m = g.a.a.b.b.a.bu(5, this.Height);
      AppMethodBeat.o(117938);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117938);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eoj localeoj = (eoj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117938);
          return -1;
        case 1: 
          localeoj.Nmh = locala.UbS.hPo();
          AppMethodBeat.o(117938);
          return 0;
        case 2: 
          localeoj.Nmi = locala.UbS.zi();
          AppMethodBeat.o(117938);
          return 0;
        case 3: 
          localeoj.Nmj = locala.UbS.zl();
          AppMethodBeat.o(117938);
          return 0;
        case 4: 
          localeoj.Width = locala.UbS.zi();
          AppMethodBeat.o(117938);
          return 0;
        }
        localeoj.Height = locala.UbS.zi();
        AppMethodBeat.o(117938);
        return 0;
      }
      AppMethodBeat.o(117938);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eoj
 * JD-Core Version:    0.7.0.1
 */