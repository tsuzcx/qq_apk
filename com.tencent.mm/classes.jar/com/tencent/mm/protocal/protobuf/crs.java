package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class crs
  extends com.tencent.mm.bx.a
{
  public int Tps;
  public b ZQV;
  public int ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258608);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Tps);
      paramVarArgs.bS(2, this.ret);
      if (this.ZQV != null) {
        paramVarArgs.d(3, this.ZQV);
      }
      AppMethodBeat.o(258608);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.Tps) + 0 + i.a.a.b.b.a.cJ(2, this.ret);
      paramInt = i;
      if (this.ZQV != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.ZQV);
      }
      AppMethodBeat.o(258608);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258608);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      crs localcrs = (crs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258608);
        return -1;
      case 1: 
        localcrs.Tps = locala.ajGk.aar();
        AppMethodBeat.o(258608);
        return 0;
      case 2: 
        localcrs.ret = locala.ajGk.aar();
        AppMethodBeat.o(258608);
        return 0;
      }
      localcrs.ZQV = locala.ajGk.kFX();
      AppMethodBeat.o(258608);
      return 0;
    }
    AppMethodBeat.o(258608);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crs
 * JD-Core Version:    0.7.0.1
 */