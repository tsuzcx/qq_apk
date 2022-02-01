package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bw.a
{
  public int DRV;
  public String postId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96158);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.postId != null) {
        paramVarArgs.e(1, this.postId);
      }
      paramVarArgs.aM(2, this.DRV);
      AppMethodBeat.o(96158);
      return 0;
    }
    if (paramInt == 1) {
      if (this.postId == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = g.a.a.b.b.a.f(1, this.postId) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.DRV);
      AppMethodBeat.o(96158);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(96158);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(96158);
          return -1;
        case 1: 
          localg.postId = locala.UbS.readString();
          AppMethodBeat.o(96158);
          return 0;
        }
        localg.DRV = locala.UbS.zi();
        AppMethodBeat.o(96158);
        return 0;
      }
      AppMethodBeat.o(96158);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.g
 * JD-Core Version:    0.7.0.1
 */