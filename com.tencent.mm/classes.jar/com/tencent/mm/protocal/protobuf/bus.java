package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bus
  extends com.tencent.mm.bx.a
{
  public int DRT;
  public b DRU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121105);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DRT);
      if (this.DRU != null) {
        paramVarArgs.c(2, this.DRU);
      }
      AppMethodBeat.o(121105);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.DRT) + 0;
      paramInt = i;
      if (this.DRU != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.DRU);
      }
      AppMethodBeat.o(121105);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(121105);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bus localbus = (bus)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(121105);
        return -1;
      case 1: 
        localbus.DRT = locala.KhF.xS();
        AppMethodBeat.o(121105);
        return 0;
      }
      localbus.DRU = locala.KhF.fMu();
      AppMethodBeat.o(121105);
      return 0;
    }
    AppMethodBeat.o(121105);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bus
 * JD-Core Version:    0.7.0.1
 */