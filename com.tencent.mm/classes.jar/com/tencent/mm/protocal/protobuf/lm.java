package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class lm
  extends com.tencent.mm.bw.a
{
  public b DZf;
  public b DZg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104358);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DZf != null) {
        paramVarArgs.c(1, this.DZf);
      }
      if (this.DZg != null) {
        paramVarArgs.c(2, this.DZg);
      }
      AppMethodBeat.o(104358);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DZf == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.b(1, this.DZf) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DZg != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.DZg);
      }
      AppMethodBeat.o(104358);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(104358);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        lm locallm = (lm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104358);
          return -1;
        case 1: 
          locallm.DZf = locala.LVo.gfk();
          AppMethodBeat.o(104358);
          return 0;
        }
        locallm.DZg = locala.LVo.gfk();
        AppMethodBeat.o(104358);
        return 0;
      }
      AppMethodBeat.o(104358);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lm
 * JD-Core Version:    0.7.0.1
 */