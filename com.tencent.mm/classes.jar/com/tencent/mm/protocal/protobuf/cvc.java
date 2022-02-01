package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class cvc
  extends com.tencent.mm.bw.a
{
  public b MAz;
  public int dMO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121105);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.dMO);
      if (this.MAz != null) {
        paramVarArgs.c(2, this.MAz);
      }
      AppMethodBeat.o(121105);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.dMO) + 0;
      paramInt = i;
      if (this.MAz != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.MAz);
      }
      AppMethodBeat.o(121105);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(121105);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cvc localcvc = (cvc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(121105);
        return -1;
      case 1: 
        localcvc.dMO = locala.UbS.zi();
        AppMethodBeat.o(121105);
        return 0;
      }
      localcvc.MAz = locala.UbS.hPo();
      AppMethodBeat.o(121105);
      return 0;
    }
    AppMethodBeat.o(121105);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvc
 * JD-Core Version:    0.7.0.1
 */