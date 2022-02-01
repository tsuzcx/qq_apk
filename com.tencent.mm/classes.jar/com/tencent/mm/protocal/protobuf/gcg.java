package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gcg
  extends com.tencent.mm.bx.a
{
  public int acau;
  public String rRQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147792);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.rRQ != null) {
        paramVarArgs.g(1, this.rRQ);
      }
      paramVarArgs.bS(2, this.acau);
      AppMethodBeat.o(147792);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rRQ == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.rRQ) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.acau);
      AppMethodBeat.o(147792);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(147792);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gcg localgcg = (gcg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147792);
          return -1;
        case 1: 
          localgcg.rRQ = locala.ajGk.readString();
          AppMethodBeat.o(147792);
          return 0;
        }
        localgcg.acau = locala.ajGk.aar();
        AppMethodBeat.o(147792);
        return 0;
      }
      AppMethodBeat.o(147792);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gcg
 * JD-Core Version:    0.7.0.1
 */