package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ck
  extends com.tencent.mm.bx.a
{
  public long adlo;
  public int adlp;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(248433);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.userName != null) {
        paramVarArgs.g(1, this.userName);
      }
      paramVarArgs.bv(2, this.adlo);
      paramVarArgs.bS(3, this.adlp);
      AppMethodBeat.o(248433);
      return 0;
    }
    if (paramInt == 1) {
      if (this.userName == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.userName) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.adlo);
      int j = i.a.a.b.b.a.cJ(3, this.adlp);
      AppMethodBeat.o(248433);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(248433);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ck localck = (ck)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(248433);
          return -1;
        case 1: 
          localck.userName = locala.ajGk.readString();
          AppMethodBeat.o(248433);
          return 0;
        case 2: 
          localck.adlo = locala.ajGk.aaw();
          AppMethodBeat.o(248433);
          return 0;
        }
        localck.adlp = locala.ajGk.aar();
        AppMethodBeat.o(248433);
        return 0;
      }
      AppMethodBeat.o(248433);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.ck
 * JD-Core Version:    0.7.0.1
 */