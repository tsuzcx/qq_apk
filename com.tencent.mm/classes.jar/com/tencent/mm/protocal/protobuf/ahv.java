package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class ahv
  extends com.tencent.mm.bx.a
{
  public b Dkt;
  public int cmdId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168938);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.cmdId);
      if (this.Dkt != null) {
        paramVarArgs.c(2, this.Dkt);
      }
      AppMethodBeat.o(168938);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.cmdId) + 0;
      paramInt = i;
      if (this.Dkt != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.Dkt);
      }
      AppMethodBeat.o(168938);
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
      AppMethodBeat.o(168938);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ahv localahv = (ahv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(168938);
        return -1;
      case 1: 
        localahv.cmdId = locala.KhF.xS();
        AppMethodBeat.o(168938);
        return 0;
      }
      localahv.Dkt = locala.KhF.fMu();
      AppMethodBeat.o(168938);
      return 0;
    }
    AppMethodBeat.o(168938);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahv
 * JD-Core Version:    0.7.0.1
 */