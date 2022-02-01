package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class czf
  extends com.tencent.mm.bx.a
{
  public int HpT;
  public int HpU;
  public b HpV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149128);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HpT);
      paramVarArgs.aS(2, this.HpU);
      if (this.HpV != null) {
        paramVarArgs.c(3, this.HpV);
      }
      AppMethodBeat.o(149128);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HpT) + 0 + f.a.a.b.b.a.bz(2, this.HpU);
      paramInt = i;
      if (this.HpV != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.HpV);
      }
      AppMethodBeat.o(149128);
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
      AppMethodBeat.o(149128);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      czf localczf = (czf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(149128);
        return -1;
      case 1: 
        localczf.HpT = locala.NPN.zc();
        AppMethodBeat.o(149128);
        return 0;
      case 2: 
        localczf.HpU = locala.NPN.zc();
        AppMethodBeat.o(149128);
        return 0;
      }
      localczf.HpV = locala.NPN.gxI();
      AppMethodBeat.o(149128);
      return 0;
    }
    AppMethodBeat.o(149128);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czf
 * JD-Core Version:    0.7.0.1
 */