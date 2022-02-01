package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class co
  extends com.tencent.mm.bx.a
{
  public long IdF;
  public int YET;
  public b YEU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125702);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YET);
      if (this.YEU != null) {
        paramVarArgs.d(2, this.YEU);
      }
      paramVarArgs.bv(3, this.IdF);
      AppMethodBeat.o(125702);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.YET) + 0;
      paramInt = i;
      if (this.YEU != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.YEU);
      }
      i = i.a.a.b.b.a.q(3, this.IdF);
      AppMethodBeat.o(125702);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(125702);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      co localco = (co)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125702);
        return -1;
      case 1: 
        localco.YET = locala.ajGk.aar();
        AppMethodBeat.o(125702);
        return 0;
      case 2: 
        localco.YEU = locala.ajGk.kFX();
        AppMethodBeat.o(125702);
        return 0;
      }
      localco.IdF = locala.ajGk.aaw();
      AppMethodBeat.o(125702);
      return 0;
    }
    AppMethodBeat.o(125702);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.co
 * JD-Core Version:    0.7.0.1
 */