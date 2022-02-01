package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class crp
  extends com.tencent.mm.bx.a
{
  public int Tps;
  public b ZQU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258723);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Tps);
      if (this.ZQU != null) {
        paramVarArgs.d(2, this.ZQU);
      }
      AppMethodBeat.o(258723);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.Tps) + 0;
      paramInt = i;
      if (this.ZQU != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.ZQU);
      }
      AppMethodBeat.o(258723);
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
      AppMethodBeat.o(258723);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      crp localcrp = (crp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258723);
        return -1;
      case 1: 
        localcrp.Tps = locala.ajGk.aar();
        AppMethodBeat.o(258723);
        return 0;
      }
      localcrp.ZQU = locala.ajGk.kFX();
      AppMethodBeat.o(258723);
      return 0;
    }
    AppMethodBeat.o(258723);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crp
 * JD-Core Version:    0.7.0.1
 */