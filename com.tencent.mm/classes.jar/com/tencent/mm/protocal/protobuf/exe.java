package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class exe
  extends com.tencent.mm.bw.a
{
  public b NuB;
  public b NuC;
  public b NuD;
  public b NuE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91729);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NuB != null) {
        paramVarArgs.c(1, this.NuB);
      }
      if (this.NuC != null) {
        paramVarArgs.c(2, this.NuC);
      }
      if (this.NuD != null) {
        paramVarArgs.c(3, this.NuD);
      }
      if (this.NuE != null) {
        paramVarArgs.c(4, this.NuE);
      }
      AppMethodBeat.o(91729);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NuB == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.b(1, this.NuB) + 0;; i = 0)
    {
      paramInt = i;
      if (this.NuC != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.NuC);
      }
      i = paramInt;
      if (this.NuD != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.NuD);
      }
      paramInt = i;
      if (this.NuE != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.NuE);
      }
      AppMethodBeat.o(91729);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91729);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        exe localexe = (exe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91729);
          return -1;
        case 1: 
          localexe.NuB = locala.UbS.hPo();
          AppMethodBeat.o(91729);
          return 0;
        case 2: 
          localexe.NuC = locala.UbS.hPo();
          AppMethodBeat.o(91729);
          return 0;
        case 3: 
          localexe.NuD = locala.UbS.hPo();
          AppMethodBeat.o(91729);
          return 0;
        }
        localexe.NuE = locala.UbS.hPo();
        AppMethodBeat.o(91729);
        return 0;
      }
      AppMethodBeat.o(91729);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exe
 * JD-Core Version:    0.7.0.1
 */