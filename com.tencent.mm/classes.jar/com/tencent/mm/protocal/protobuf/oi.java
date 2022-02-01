package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class oi
  extends com.tencent.mm.bx.a
{
  public b CLU;
  public b CLV;
  public int port;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133158);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      paramVarArgs.aR(2, this.port);
      if (this.CLU != null) {
        paramVarArgs.c(3, this.CLU);
      }
      if (this.CLV != null) {
        paramVarArgs.c(4, this.CLV);
      }
      AppMethodBeat.o(133158);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.type) + 0 + f.a.a.b.b.a.bA(2, this.port);
      paramInt = i;
      if (this.CLU != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.CLU);
      }
      i = paramInt;
      if (this.CLV != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.CLV);
      }
      AppMethodBeat.o(133158);
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
      AppMethodBeat.o(133158);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      oi localoi = (oi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(133158);
        return -1;
      case 1: 
        localoi.type = locala.KhF.xS();
        AppMethodBeat.o(133158);
        return 0;
      case 2: 
        localoi.port = locala.KhF.xS();
        AppMethodBeat.o(133158);
        return 0;
      case 3: 
        localoi.CLU = locala.KhF.fMu();
        AppMethodBeat.o(133158);
        return 0;
      }
      localoi.CLV = locala.KhF.fMu();
      AppMethodBeat.o(133158);
      return 0;
    }
    AppMethodBeat.o(133158);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oi
 * JD-Core Version:    0.7.0.1
 */