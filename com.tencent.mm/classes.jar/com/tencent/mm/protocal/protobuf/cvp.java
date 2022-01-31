package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class cvp
  extends com.tencent.mm.bv.a
{
  public b ydO;
  public b ydY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(57003);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ydO != null) {
        paramVarArgs.c(1, this.ydO);
      }
      if (this.ydY != null) {
        paramVarArgs.c(2, this.ydY);
      }
      AppMethodBeat.o(57003);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ydO == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.b(1, this.ydO) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ydY != null) {
        i = paramInt + e.a.a.b.b.a.b(2, this.ydY);
      }
      AppMethodBeat.o(57003);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(57003);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cvp localcvp = (cvp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(57003);
          return -1;
        case 1: 
          localcvp.ydO = locala.CLY.eqS();
          AppMethodBeat.o(57003);
          return 0;
        }
        localcvp.ydY = locala.CLY.eqS();
        AppMethodBeat.o(57003);
        return 0;
      }
      AppMethodBeat.o(57003);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvp
 * JD-Core Version:    0.7.0.1
 */