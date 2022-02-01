package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class apt
  extends com.tencent.mm.bx.a
{
  public b ZwY;
  public int ZwZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259345);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZwY != null) {
        paramVarArgs.d(1, this.ZwY);
      }
      paramVarArgs.bS(2, this.ZwZ);
      AppMethodBeat.o(259345);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZwY == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.c(1, this.ZwY) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.ZwZ);
      AppMethodBeat.o(259345);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259345);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        apt localapt = (apt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259345);
          return -1;
        case 1: 
          localapt.ZwY = locala.ajGk.kFX();
          AppMethodBeat.o(259345);
          return 0;
        }
        localapt.ZwZ = locala.ajGk.aar();
        AppMethodBeat.o(259345);
        return 0;
      }
      AppMethodBeat.o(259345);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apt
 * JD-Core Version:    0.7.0.1
 */