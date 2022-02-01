package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bkw
  extends com.tencent.mm.bx.a
{
  public int ZTW;
  public b ZTX;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259442);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      paramVarArgs.bS(2, this.ZTW);
      if (this.ZTX != null) {
        paramVarArgs.d(3, this.ZTX);
      }
      AppMethodBeat.o(259442);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.type) + 0 + i.a.a.b.b.a.cJ(2, this.ZTW);
      paramInt = i;
      if (this.ZTX != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.ZTX);
      }
      AppMethodBeat.o(259442);
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
      AppMethodBeat.o(259442);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bkw localbkw = (bkw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259442);
        return -1;
      case 1: 
        localbkw.type = locala.ajGk.aar();
        AppMethodBeat.o(259442);
        return 0;
      case 2: 
        localbkw.ZTW = locala.ajGk.aar();
        AppMethodBeat.o(259442);
        return 0;
      }
      localbkw.ZTX = locala.ajGk.kFX();
      AppMethodBeat.o(259442);
      return 0;
    }
    AppMethodBeat.o(259442);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkw
 * JD-Core Version:    0.7.0.1
 */