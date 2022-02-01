package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class ebf
  extends com.tencent.mm.bx.a
{
  public b HNQ;
  public b HNR;
  public b HNS;
  public b HNT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91729);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HNQ != null) {
        paramVarArgs.c(1, this.HNQ);
      }
      if (this.HNR != null) {
        paramVarArgs.c(2, this.HNR);
      }
      if (this.HNS != null) {
        paramVarArgs.c(3, this.HNS);
      }
      if (this.HNT != null) {
        paramVarArgs.c(4, this.HNT);
      }
      AppMethodBeat.o(91729);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HNQ == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.b(1, this.HNQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HNR != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.HNR);
      }
      i = paramInt;
      if (this.HNS != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.HNS);
      }
      paramInt = i;
      if (this.HNT != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.HNT);
      }
      AppMethodBeat.o(91729);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91729);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ebf localebf = (ebf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91729);
          return -1;
        case 1: 
          localebf.HNQ = locala.NPN.gxI();
          AppMethodBeat.o(91729);
          return 0;
        case 2: 
          localebf.HNR = locala.NPN.gxI();
          AppMethodBeat.o(91729);
          return 0;
        case 3: 
          localebf.HNS = locala.NPN.gxI();
          AppMethodBeat.o(91729);
          return 0;
        }
        localebf.HNT = locala.NPN.gxI();
        AppMethodBeat.o(91729);
        return 0;
      }
      AppMethodBeat.o(91729);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebf
 * JD-Core Version:    0.7.0.1
 */