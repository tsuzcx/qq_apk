package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class aew
  extends com.tencent.mm.bw.a
{
  public b Lqh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152526);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lqh != null) {
        paramVarArgs.c(1, this.Lqh);
      }
      AppMethodBeat.o(152526);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lqh == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = g.a.a.b.b.a.b(1, this.Lqh) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(152526);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152526);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aew localaew = (aew)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152526);
          return -1;
        }
        localaew.Lqh = locala.UbS.hPo();
        AppMethodBeat.o(152526);
        return 0;
      }
      AppMethodBeat.o(152526);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aew
 * JD-Core Version:    0.7.0.1
 */