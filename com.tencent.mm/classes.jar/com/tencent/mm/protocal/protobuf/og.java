package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class og
  extends com.tencent.mm.bx.a
{
  public b FJx;
  public int FJy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124442);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FJx != null) {
        paramVarArgs.c(1, this.FJx);
      }
      paramVarArgs.aS(2, this.FJy);
      AppMethodBeat.o(124442);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FJx == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.b(1, this.FJx) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.FJy);
      AppMethodBeat.o(124442);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124442);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        og localog = (og)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124442);
          return -1;
        case 1: 
          localog.FJx = locala.NPN.gxI();
          AppMethodBeat.o(124442);
          return 0;
        }
        localog.FJy = locala.NPN.zc();
        AppMethodBeat.o(124442);
        return 0;
      }
      AppMethodBeat.o(124442);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.og
 * JD-Core Version:    0.7.0.1
 */