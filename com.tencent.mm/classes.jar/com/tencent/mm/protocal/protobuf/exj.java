package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class exj
  extends com.tencent.mm.bw.a
{
  public b NuM;
  public b NuN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91732);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NuM != null) {
        paramVarArgs.c(1, this.NuM);
      }
      if (this.NuN != null) {
        paramVarArgs.c(2, this.NuN);
      }
      AppMethodBeat.o(91732);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NuM == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.b(1, this.NuM) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.NuN != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.NuN);
      }
      AppMethodBeat.o(91732);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91732);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        exj localexj = (exj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91732);
          return -1;
        case 1: 
          localexj.NuM = locala.UbS.hPo();
          AppMethodBeat.o(91732);
          return 0;
        }
        localexj.NuN = locala.UbS.hPo();
        AppMethodBeat.o(91732);
        return 0;
      }
      AppMethodBeat.o(91732);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exj
 * JD-Core Version:    0.7.0.1
 */