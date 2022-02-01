package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccy
  extends com.tencent.mm.bx.a
{
  public int GXf;
  public long GXg;
  public long GXh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117883);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GXf);
      paramVarArgs.aY(2, this.GXg);
      paramVarArgs.aY(3, this.GXh);
      AppMethodBeat.o(117883);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.GXf);
      int i = f.a.a.b.b.a.p(2, this.GXg);
      int j = f.a.a.b.b.a.p(3, this.GXh);
      AppMethodBeat.o(117883);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(117883);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ccy localccy = (ccy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117883);
        return -1;
      case 1: 
        localccy.GXf = locala.NPN.zc();
        AppMethodBeat.o(117883);
        return 0;
      case 2: 
        localccy.GXg = locala.NPN.zd();
        AppMethodBeat.o(117883);
        return 0;
      }
      localccy.GXh = locala.NPN.zd();
      AppMethodBeat.o(117883);
      return 0;
    }
    AppMethodBeat.o(117883);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccy
 * JD-Core Version:    0.7.0.1
 */