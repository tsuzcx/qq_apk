package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class sy
  extends com.tencent.mm.bw.a
{
  public b LaS;
  public long LaT;
  public long LaU;
  public boolean LaV;
  public long id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218974);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LaS != null) {
        paramVarArgs.c(1, this.LaS);
      }
      paramVarArgs.bb(2, this.LaT);
      paramVarArgs.bb(3, this.LaU);
      paramVarArgs.cc(4, this.LaV);
      paramVarArgs.bb(5, this.id);
      AppMethodBeat.o(218974);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LaS == null) {
        break label394;
      }
    }
    label394:
    for (paramInt = g.a.a.b.b.a.b(1, this.LaS) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.r(2, this.LaT);
      int j = g.a.a.b.b.a.r(3, this.LaU);
      int k = g.a.a.b.b.a.fS(4);
      int m = g.a.a.b.b.a.r(5, this.id);
      AppMethodBeat.o(218974);
      return paramInt + i + j + (k + 1) + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(218974);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        sy localsy = (sy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(218974);
          return -1;
        case 1: 
          localsy.LaS = locala.UbS.hPo();
          AppMethodBeat.o(218974);
          return 0;
        case 2: 
          localsy.LaT = locala.UbS.zl();
          AppMethodBeat.o(218974);
          return 0;
        case 3: 
          localsy.LaU = locala.UbS.zl();
          AppMethodBeat.o(218974);
          return 0;
        case 4: 
          localsy.LaV = locala.UbS.yZ();
          AppMethodBeat.o(218974);
          return 0;
        }
        localsy.id = locala.UbS.zl();
        AppMethodBeat.o(218974);
        return 0;
      }
      AppMethodBeat.o(218974);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sy
 * JD-Core Version:    0.7.0.1
 */