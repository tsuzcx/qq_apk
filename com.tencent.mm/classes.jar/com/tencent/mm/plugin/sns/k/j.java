package com.tencent.mm.plugin.sns.k;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class j
  extends com.tencent.mm.bx.a
{
  public int icg;
  public String sessionId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(306333);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.sessionId != null) {
        paramVarArgs.g(1, this.sessionId);
      }
      paramVarArgs.bS(2, this.icg);
      AppMethodBeat.o(306333);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.sessionId) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.icg);
      AppMethodBeat.o(306333);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(306333);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(306333);
          return -1;
        case 1: 
          localj.sessionId = locala.ajGk.readString();
          AppMethodBeat.o(306333);
          return 0;
        }
        localj.icg = locala.ajGk.aar();
        AppMethodBeat.o(306333);
        return 0;
      }
      AppMethodBeat.o(306333);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.j
 * JD-Core Version:    0.7.0.1
 */