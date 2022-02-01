package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class eyr
  extends com.tencent.mm.cd.a
{
  public int Height;
  public b UyT;
  public int UyU;
  public long UyV;
  public int Width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117938);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UyT != null) {
        paramVarArgs.c(1, this.UyT);
      }
      paramVarArgs.aY(2, this.UyU);
      paramVarArgs.bm(3, this.UyV);
      paramVarArgs.aY(4, this.Width);
      paramVarArgs.aY(5, this.Height);
      AppMethodBeat.o(117938);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UyT == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = g.a.a.b.b.a.b(1, this.UyT) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.UyU);
      int j = g.a.a.b.b.a.p(3, this.UyV);
      int k = g.a.a.b.b.a.bM(4, this.Width);
      int m = g.a.a.b.b.a.bM(5, this.Height);
      AppMethodBeat.o(117938);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(117938);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eyr localeyr = (eyr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117938);
          return -1;
        case 1: 
          localeyr.UyT = locala.abFh.iUw();
          AppMethodBeat.o(117938);
          return 0;
        case 2: 
          localeyr.UyU = locala.abFh.AK();
          AppMethodBeat.o(117938);
          return 0;
        case 3: 
          localeyr.UyV = locala.abFh.AN();
          AppMethodBeat.o(117938);
          return 0;
        case 4: 
          localeyr.Width = locala.abFh.AK();
          AppMethodBeat.o(117938);
          return 0;
        }
        localeyr.Height = locala.abFh.AK();
        AppMethodBeat.o(117938);
        return 0;
      }
      AppMethodBeat.o(117938);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyr
 * JD-Core Version:    0.7.0.1
 */