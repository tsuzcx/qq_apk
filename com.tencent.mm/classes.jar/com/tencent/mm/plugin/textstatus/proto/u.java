package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class u
  extends com.tencent.mm.bx.a
{
  public int Tps;
  public b Tpt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(290047);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Tps);
      if (this.Tpt != null) {
        paramVarArgs.d(2, this.Tpt);
      }
      AppMethodBeat.o(290047);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.Tps) + 0;
      paramInt = i;
      if (this.Tpt != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.Tpt);
      }
      AppMethodBeat.o(290047);
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
      AppMethodBeat.o(290047);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      u localu = (u)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(290047);
        return -1;
      case 1: 
        localu.Tps = locala.ajGk.aar();
        AppMethodBeat.o(290047);
        return 0;
      }
      localu.Tpt = locala.ajGk.kFX();
      AppMethodBeat.o(290047);
      return 0;
    }
    AppMethodBeat.o(290047);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.u
 * JD-Core Version:    0.7.0.1
 */