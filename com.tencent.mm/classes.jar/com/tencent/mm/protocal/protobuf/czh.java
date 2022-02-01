package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class czh
  extends com.tencent.mm.bx.a
{
  public b aaEo;
  public long ihV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116328);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.ihV);
      if (this.aaEo != null) {
        paramVarArgs.d(2, this.aaEo);
      }
      AppMethodBeat.o(116328);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.ihV) + 0;
      paramInt = i;
      if (this.aaEo != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.aaEo);
      }
      AppMethodBeat.o(116328);
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
      AppMethodBeat.o(116328);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      czh localczh = (czh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116328);
        return -1;
      case 1: 
        localczh.ihV = locala.ajGk.aaw();
        AppMethodBeat.o(116328);
        return 0;
      }
      localczh.aaEo = locala.ajGk.kFX();
      AppMethodBeat.o(116328);
      return 0;
    }
    AppMethodBeat.o(116328);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czh
 * JD-Core Version:    0.7.0.1
 */