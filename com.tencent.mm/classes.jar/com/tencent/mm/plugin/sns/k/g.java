package com.tencent.mm.plugin.sns.k;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bx.a
{
  public int QCJ;
  public String postId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96158);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.postId != null) {
        paramVarArgs.g(1, this.postId);
      }
      paramVarArgs.bS(2, this.QCJ);
      AppMethodBeat.o(96158);
      return 0;
    }
    if (paramInt == 1) {
      if (this.postId == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.postId) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.QCJ);
      AppMethodBeat.o(96158);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(96158);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(96158);
          return -1;
        case 1: 
          localg.postId = locala.ajGk.readString();
          AppMethodBeat.o(96158);
          return 0;
        }
        localg.QCJ = locala.ajGk.aar();
        AppMethodBeat.o(96158);
        return 0;
      }
      AppMethodBeat.o(96158);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.g
 * JD-Core Version:    0.7.0.1
 */