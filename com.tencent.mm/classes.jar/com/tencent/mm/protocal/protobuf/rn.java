package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class rn
  extends com.tencent.mm.bx.a
{
  public int FNH;
  public b oAr;
  public int oBU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194977);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FNH);
      paramVarArgs.aS(2, this.oBU);
      if (this.oAr != null) {
        paramVarArgs.c(3, this.oAr);
      }
      AppMethodBeat.o(194977);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FNH) + 0 + f.a.a.b.b.a.bz(2, this.oBU);
      paramInt = i;
      if (this.oAr != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.oAr);
      }
      AppMethodBeat.o(194977);
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
      AppMethodBeat.o(194977);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      rn localrn = (rn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(194977);
        return -1;
      case 1: 
        localrn.FNH = locala.NPN.zc();
        AppMethodBeat.o(194977);
        return 0;
      case 2: 
        localrn.oBU = locala.NPN.zc();
        AppMethodBeat.o(194977);
        return 0;
      }
      localrn.oAr = locala.NPN.gxI();
      AppMethodBeat.o(194977);
      return 0;
    }
    AppMethodBeat.o(194977);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rn
 * JD-Core Version:    0.7.0.1
 */