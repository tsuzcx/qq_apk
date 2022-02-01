package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class qu
  extends com.tencent.mm.bx.a
{
  public long FMx;
  public b FMy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43084);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.FMx);
      if (this.FMy != null) {
        paramVarArgs.c(2, this.FMy);
      }
      AppMethodBeat.o(43084);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.FMx) + 0;
      paramInt = i;
      if (this.FMy != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.FMy);
      }
      AppMethodBeat.o(43084);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(43084);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      qu localqu = (qu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43084);
        return -1;
      case 1: 
        localqu.FMx = locala.NPN.zd();
        AppMethodBeat.o(43084);
        return 0;
      }
      localqu.FMy = locala.NPN.gxI();
      AppMethodBeat.o(43084);
      return 0;
    }
    AppMethodBeat.o(43084);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qu
 * JD-Core Version:    0.7.0.1
 */