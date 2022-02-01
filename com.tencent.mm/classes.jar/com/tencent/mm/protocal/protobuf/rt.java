package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class rt
  extends com.tencent.mm.bx.a
{
  public b FNQ;
  public long FNR;
  public long FNS;
  public boolean FNT;
  public long id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(219339);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FNQ != null) {
        paramVarArgs.c(1, this.FNQ);
      }
      paramVarArgs.aY(2, this.FNR);
      paramVarArgs.aY(3, this.FNS);
      paramVarArgs.bt(4, this.FNT);
      paramVarArgs.aY(5, this.id);
      AppMethodBeat.o(219339);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FNQ == null) {
        break label394;
      }
    }
    label394:
    for (paramInt = f.a.a.b.b.a.b(1, this.FNQ) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.FNR);
      int j = f.a.a.b.b.a.p(3, this.FNS);
      int k = f.a.a.b.b.a.alV(4);
      int m = f.a.a.b.b.a.p(5, this.id);
      AppMethodBeat.o(219339);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(219339);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        rt localrt = (rt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(219339);
          return -1;
        case 1: 
          localrt.FNQ = locala.NPN.gxI();
          AppMethodBeat.o(219339);
          return 0;
        case 2: 
          localrt.FNR = locala.NPN.zd();
          AppMethodBeat.o(219339);
          return 0;
        case 3: 
          localrt.FNS = locala.NPN.zd();
          AppMethodBeat.o(219339);
          return 0;
        case 4: 
          localrt.FNT = locala.NPN.grw();
          AppMethodBeat.o(219339);
          return 0;
        }
        localrt.id = locala.NPN.zd();
        AppMethodBeat.o(219339);
        return 0;
      }
      AppMethodBeat.o(219339);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rt
 * JD-Core Version:    0.7.0.1
 */