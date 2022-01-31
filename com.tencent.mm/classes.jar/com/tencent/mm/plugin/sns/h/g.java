package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bv.a
{
  public String postId;
  public int rlW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(36830);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.postId != null) {
        paramVarArgs.e(1, this.postId);
      }
      paramVarArgs.aO(2, this.rlW);
      AppMethodBeat.o(36830);
      return 0;
    }
    if (paramInt == 1) {
      if (this.postId == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = e.a.a.b.b.a.f(1, this.postId) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.rlW);
      AppMethodBeat.o(36830);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(36830);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(36830);
          return -1;
        case 1: 
          localg.postId = locala.CLY.readString();
          AppMethodBeat.o(36830);
          return 0;
        }
        localg.rlW = locala.CLY.sl();
        AppMethodBeat.o(36830);
        return 0;
      }
      AppMethodBeat.o(36830);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.g
 * JD-Core Version:    0.7.0.1
 */