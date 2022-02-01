package com.tencent.mm.plugin.sns.k;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends com.tencent.mm.bx.a
{
  public String PzX;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96159);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.PzX != null) {
        paramVarArgs.g(1, this.PzX);
      }
      paramVarArgs.bS(2, this.state);
      AppMethodBeat.o(96159);
      return 0;
    }
    if (paramInt == 1) {
      if (this.PzX == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.PzX) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.state);
      AppMethodBeat.o(96159);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(96159);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(96159);
          return -1;
        case 1: 
          localh.PzX = locala.ajGk.readString();
          AppMethodBeat.o(96159);
          return 0;
        }
        localh.state = locala.ajGk.aar();
        AppMethodBeat.o(96159);
        return 0;
      }
      AppMethodBeat.o(96159);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.h
 * JD-Core Version:    0.7.0.1
 */