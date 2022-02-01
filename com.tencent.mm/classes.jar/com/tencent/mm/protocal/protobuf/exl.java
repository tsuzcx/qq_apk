package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class exl
  extends com.tencent.mm.bw.a
{
  public b NuB;
  public b NuN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91735);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NuB != null) {
        paramVarArgs.c(1, this.NuB);
      }
      if (this.NuN != null) {
        paramVarArgs.c(2, this.NuN);
      }
      AppMethodBeat.o(91735);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NuB == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.b(1, this.NuB) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.NuN != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.NuN);
      }
      AppMethodBeat.o(91735);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91735);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        exl localexl = (exl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91735);
          return -1;
        case 1: 
          localexl.NuB = locala.UbS.hPo();
          AppMethodBeat.o(91735);
          return 0;
        }
        localexl.NuN = locala.UbS.hPo();
        AppMethodBeat.o(91735);
        return 0;
      }
      AppMethodBeat.o(91735);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exl
 * JD-Core Version:    0.7.0.1
 */