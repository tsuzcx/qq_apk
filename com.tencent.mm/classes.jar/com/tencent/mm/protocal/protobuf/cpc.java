package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cpc
  extends com.tencent.mm.bw.a
{
  public String CXO;
  public int CXP;
  public int Mvc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147773);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CXO != null) {
        paramVarArgs.e(1, this.CXO);
      }
      paramVarArgs.aM(2, this.CXP);
      paramVarArgs.aM(3, this.Mvc);
      AppMethodBeat.o(147773);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CXO == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.f(1, this.CXO) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.CXP);
      int j = g.a.a.b.b.a.bu(3, this.Mvc);
      AppMethodBeat.o(147773);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(147773);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cpc localcpc = (cpc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147773);
          return -1;
        case 1: 
          localcpc.CXO = locala.UbS.readString();
          AppMethodBeat.o(147773);
          return 0;
        case 2: 
          localcpc.CXP = locala.UbS.zi();
          AppMethodBeat.o(147773);
          return 0;
        }
        localcpc.Mvc = locala.UbS.zi();
        AppMethodBeat.o(147773);
        return 0;
      }
      AppMethodBeat.o(147773);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpc
 * JD-Core Version:    0.7.0.1
 */