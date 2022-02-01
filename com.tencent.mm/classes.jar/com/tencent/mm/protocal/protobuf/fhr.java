package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class fhr
  extends com.tencent.mm.cd.a
{
  public b UHC;
  public b UHD;
  public b UHE;
  public b UHF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91729);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UHC != null) {
        paramVarArgs.c(1, this.UHC);
      }
      if (this.UHD != null) {
        paramVarArgs.c(2, this.UHD);
      }
      if (this.UHE != null) {
        paramVarArgs.c(3, this.UHE);
      }
      if (this.UHF != null) {
        paramVarArgs.c(4, this.UHF);
      }
      AppMethodBeat.o(91729);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UHC == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.b(1, this.UHC) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UHD != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.UHD);
      }
      i = paramInt;
      if (this.UHE != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.UHE);
      }
      paramInt = i;
      if (this.UHF != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.UHF);
      }
      AppMethodBeat.o(91729);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91729);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fhr localfhr = (fhr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91729);
          return -1;
        case 1: 
          localfhr.UHC = locala.abFh.iUw();
          AppMethodBeat.o(91729);
          return 0;
        case 2: 
          localfhr.UHD = locala.abFh.iUw();
          AppMethodBeat.o(91729);
          return 0;
        case 3: 
          localfhr.UHE = locala.abFh.iUw();
          AppMethodBeat.o(91729);
          return 0;
        }
        localfhr.UHF = locala.abFh.iUw();
        AppMethodBeat.o(91729);
        return 0;
      }
      AppMethodBeat.o(91729);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhr
 * JD-Core Version:    0.7.0.1
 */