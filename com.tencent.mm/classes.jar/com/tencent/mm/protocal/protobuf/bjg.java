package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class bjg
  extends com.tencent.mm.bw.a
{
  public b DWI;
  public b DWK;
  public b EYs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32321);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DWK != null) {
        paramVarArgs.c(1, this.DWK);
      }
      if (this.DWI != null) {
        paramVarArgs.c(2, this.DWI);
      }
      if (this.EYs != null) {
        paramVarArgs.c(3, this.EYs);
      }
      AppMethodBeat.o(32321);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DWK == null) {
        break label343;
      }
    }
    label343:
    for (int i = f.a.a.b.b.a.b(1, this.DWK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DWI != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.DWI);
      }
      i = paramInt;
      if (this.EYs != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.EYs);
      }
      AppMethodBeat.o(32321);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32321);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bjg localbjg = (bjg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32321);
          return -1;
        case 1: 
          localbjg.DWK = locala.LVo.gfk();
          AppMethodBeat.o(32321);
          return 0;
        case 2: 
          localbjg.DWI = locala.LVo.gfk();
          AppMethodBeat.o(32321);
          return 0;
        }
        localbjg.EYs = locala.LVo.gfk();
        AppMethodBeat.o(32321);
        return 0;
      }
      AppMethodBeat.o(32321);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjg
 * JD-Core Version:    0.7.0.1
 */