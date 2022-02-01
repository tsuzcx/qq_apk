package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class ceb
  extends com.tencent.mm.bx.a
{
  public int GYb;
  public b GYc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121105);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GYb);
      if (this.GYc != null) {
        paramVarArgs.c(2, this.GYc);
      }
      AppMethodBeat.o(121105);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GYb) + 0;
      paramInt = i;
      if (this.GYc != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.GYc);
      }
      AppMethodBeat.o(121105);
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
      AppMethodBeat.o(121105);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ceb localceb = (ceb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(121105);
        return -1;
      case 1: 
        localceb.GYb = locala.NPN.zc();
        AppMethodBeat.o(121105);
        return 0;
      }
      localceb.GYc = locala.NPN.gxI();
      AppMethodBeat.o(121105);
      return 0;
    }
    AppMethodBeat.o(121105);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ceb
 * JD-Core Version:    0.7.0.1
 */