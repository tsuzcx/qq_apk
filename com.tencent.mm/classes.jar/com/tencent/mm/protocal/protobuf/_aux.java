package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class aux
  extends com.tencent.mm.bx.a
{
  public b ZFo;
  public int cmdId;
  public int retCode;
  public String wZb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168939);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.cmdId);
      paramVarArgs.bS(2, this.retCode);
      if (this.wZb != null) {
        paramVarArgs.g(3, this.wZb);
      }
      if (this.ZFo != null) {
        paramVarArgs.d(4, this.ZFo);
      }
      AppMethodBeat.o(168939);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.cmdId) + 0 + i.a.a.b.b.a.cJ(2, this.retCode);
      paramInt = i;
      if (this.wZb != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wZb);
      }
      i = paramInt;
      if (this.ZFo != null) {
        i = paramInt + i.a.a.b.b.a.c(4, this.ZFo);
      }
      AppMethodBeat.o(168939);
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
      AppMethodBeat.o(168939);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      aux localaux = (aux)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(168939);
        return -1;
      case 1: 
        localaux.cmdId = locala.ajGk.aar();
        AppMethodBeat.o(168939);
        return 0;
      case 2: 
        localaux.retCode = locala.ajGk.aar();
        AppMethodBeat.o(168939);
        return 0;
      case 3: 
        localaux.wZb = locala.ajGk.readString();
        AppMethodBeat.o(168939);
        return 0;
      }
      localaux.ZFo = locala.ajGk.kFX();
      AppMethodBeat.o(168939);
      return 0;
    }
    AppMethodBeat.o(168939);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aux
 * JD-Core Version:    0.7.0.1
 */