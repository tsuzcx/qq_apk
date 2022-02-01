package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class ahw
  extends com.tencent.mm.bx.a
{
  public b Dku;
  public int cmdId;
  public String jwH;
  public int retCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168939);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.cmdId);
      paramVarArgs.aR(2, this.retCode);
      if (this.jwH != null) {
        paramVarArgs.d(3, this.jwH);
      }
      if (this.Dku != null) {
        paramVarArgs.c(4, this.Dku);
      }
      AppMethodBeat.o(168939);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.cmdId) + 0 + f.a.a.b.b.a.bA(2, this.retCode);
      paramInt = i;
      if (this.jwH != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.jwH);
      }
      i = paramInt;
      if (this.Dku != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.Dku);
      }
      AppMethodBeat.o(168939);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(168939);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ahw localahw = (ahw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(168939);
        return -1;
      case 1: 
        localahw.cmdId = locala.KhF.xS();
        AppMethodBeat.o(168939);
        return 0;
      case 2: 
        localahw.retCode = locala.KhF.xS();
        AppMethodBeat.o(168939);
        return 0;
      case 3: 
        localahw.jwH = locala.KhF.readString();
        AppMethodBeat.o(168939);
        return 0;
      }
      localahw.Dku = locala.KhF.fMu();
      AppMethodBeat.o(168939);
      return 0;
    }
    AppMethodBeat.o(168939);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahw
 * JD-Core Version:    0.7.0.1
 */