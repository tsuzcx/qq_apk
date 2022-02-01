package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class br
  extends com.tencent.mm.bx.a
{
  public int YDl;
  public b YDm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259538);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YDl);
      if (this.YDm != null) {
        paramVarArgs.d(2, this.YDm);
      }
      AppMethodBeat.o(259538);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.YDl) + 0;
      paramInt = i;
      if (this.YDm != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.YDm);
      }
      AppMethodBeat.o(259538);
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
      AppMethodBeat.o(259538);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      br localbr = (br)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259538);
        return -1;
      case 1: 
        localbr.YDl = locala.ajGk.aar();
        AppMethodBeat.o(259538);
        return 0;
      }
      localbr.YDm = locala.ajGk.kFX();
      AppMethodBeat.o(259538);
      return 0;
    }
    AppMethodBeat.o(259538);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.br
 * JD-Core Version:    0.7.0.1
 */