package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class ewq
  extends com.tencent.mm.bx.a
{
  public b ZoS;
  public int abyR;
  public int abyS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149128);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abyR);
      paramVarArgs.bS(2, this.abyS);
      if (this.ZoS != null) {
        paramVarArgs.d(3, this.ZoS);
      }
      AppMethodBeat.o(149128);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.abyR) + 0 + i.a.a.b.b.a.cJ(2, this.abyS);
      paramInt = i;
      if (this.ZoS != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.ZoS);
      }
      AppMethodBeat.o(149128);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(149128);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ewq localewq = (ewq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(149128);
        return -1;
      case 1: 
        localewq.abyR = locala.ajGk.aar();
        AppMethodBeat.o(149128);
        return 0;
      case 2: 
        localewq.abyS = locala.ajGk.aar();
        AppMethodBeat.o(149128);
        return 0;
      }
      localewq.ZoS = locala.ajGk.kFX();
      AppMethodBeat.o(149128);
      return 0;
    }
    AppMethodBeat.o(149128);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewq
 * JD-Core Version:    0.7.0.1
 */