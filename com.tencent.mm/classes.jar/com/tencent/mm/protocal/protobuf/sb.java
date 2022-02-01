package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class sb
  extends com.tencent.mm.bx.a
{
  public b YWU;
  public b YWV;
  public int port;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133158);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      paramVarArgs.bS(2, this.port);
      if (this.YWU != null) {
        paramVarArgs.d(3, this.YWU);
      }
      if (this.YWV != null) {
        paramVarArgs.d(4, this.YWV);
      }
      AppMethodBeat.o(133158);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.type) + 0 + i.a.a.b.b.a.cJ(2, this.port);
      paramInt = i;
      if (this.YWU != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.YWU);
      }
      i = paramInt;
      if (this.YWV != null) {
        i = paramInt + i.a.a.b.b.a.c(4, this.YWV);
      }
      AppMethodBeat.o(133158);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(133158);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      sb localsb = (sb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(133158);
        return -1;
      case 1: 
        localsb.type = locala.ajGk.aar();
        AppMethodBeat.o(133158);
        return 0;
      case 2: 
        localsb.port = locala.ajGk.aar();
        AppMethodBeat.o(133158);
        return 0;
      case 3: 
        localsb.YWU = locala.ajGk.kFX();
        AppMethodBeat.o(133158);
        return 0;
      }
      localsb.YWV = locala.ajGk.kFX();
      AppMethodBeat.o(133158);
      return 0;
    }
    AppMethodBeat.o(133158);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sb
 * JD-Core Version:    0.7.0.1
 */