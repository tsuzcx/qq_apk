package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class oi
  extends com.tencent.mm.bw.a
{
  public b GbW;
  public int GbX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124442);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GbW != null) {
        paramVarArgs.c(1, this.GbW);
      }
      paramVarArgs.aS(2, this.GbX);
      AppMethodBeat.o(124442);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GbW == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.b(1, this.GbW) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.GbX);
      AppMethodBeat.o(124442);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124442);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        oi localoi = (oi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124442);
          return -1;
        case 1: 
          localoi.GbW = locala.OmT.gCk();
          AppMethodBeat.o(124442);
          return 0;
        }
        localoi.GbX = locala.OmT.zc();
        AppMethodBeat.o(124442);
        return 0;
      }
      AppMethodBeat.o(124442);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oi
 * JD-Core Version:    0.7.0.1
 */