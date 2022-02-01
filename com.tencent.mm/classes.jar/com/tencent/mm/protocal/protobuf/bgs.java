package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bgs
  extends com.tencent.mm.bx.a
{
  public b ZQg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258000);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZQg != null) {
        paramVarArgs.d(1, this.ZQg);
      }
      AppMethodBeat.o(258000);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZQg == null) {
        break label209;
      }
    }
    label209:
    for (paramInt = i.a.a.b.b.a.c(1, this.ZQg) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(258000);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258000);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bgs localbgs = (bgs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258000);
          return -1;
        }
        localbgs.ZQg = locala.ajGk.kFX();
        AppMethodBeat.o(258000);
        return 0;
      }
      AppMethodBeat.o(258000);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgs
 * JD-Core Version:    0.7.0.1
 */