package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class lw
  extends com.tencent.mm.bw.a
{
  public b FWW;
  public b FWX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104358);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FWW != null) {
        paramVarArgs.c(1, this.FWW);
      }
      if (this.FWX != null) {
        paramVarArgs.c(2, this.FWX);
      }
      AppMethodBeat.o(104358);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FWW == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.b(1, this.FWW) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FWX != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.FWX);
      }
      AppMethodBeat.o(104358);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(104358);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        lw locallw = (lw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104358);
          return -1;
        case 1: 
          locallw.FWW = locala.OmT.gCk();
          AppMethodBeat.o(104358);
          return 0;
        }
        locallw.FWX = locala.OmT.gCk();
        AppMethodBeat.o(104358);
        return 0;
      }
      AppMethodBeat.o(104358);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lw
 * JD-Core Version:    0.7.0.1
 */