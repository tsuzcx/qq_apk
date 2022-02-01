package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class qc
  extends com.tencent.mm.bw.a
{
  public b EgK;
  public long EgL;
  public long EgM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207950);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EgK != null) {
        paramVarArgs.c(1, this.EgK);
      }
      paramVarArgs.aO(2, this.EgL);
      paramVarArgs.aO(3, this.EgM);
      AppMethodBeat.o(207950);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EgK == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.b(1, this.EgK) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.EgL);
      int j = f.a.a.b.b.a.p(3, this.EgM);
      AppMethodBeat.o(207950);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(207950);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        qc localqc = (qc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(207950);
          return -1;
        case 1: 
          localqc.EgK = locala.LVo.gfk();
          AppMethodBeat.o(207950);
          return 0;
        case 2: 
          localqc.EgL = locala.LVo.xG();
          AppMethodBeat.o(207950);
          return 0;
        }
        localqc.EgM = locala.LVo.xG();
        AppMethodBeat.o(207950);
        return 0;
      }
      AppMethodBeat.o(207950);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qc
 * JD-Core Version:    0.7.0.1
 */