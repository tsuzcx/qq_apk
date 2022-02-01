package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class cis
  extends com.tencent.mm.bw.a
{
  public b MnG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207497);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MnG != null) {
        paramVarArgs.c(1, this.MnG);
      }
      AppMethodBeat.o(207497);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MnG == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = g.a.a.b.b.a.b(1, this.MnG) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(207497);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(207497);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cis localcis = (cis)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(207497);
          return -1;
        }
        localcis.MnG = locala.UbS.hPo();
        AppMethodBeat.o(207497);
        return 0;
      }
      AppMethodBeat.o(207497);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cis
 * JD-Core Version:    0.7.0.1
 */