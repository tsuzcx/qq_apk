package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxy
  extends com.tencent.mm.bx.a
{
  public int Hpm;
  public int Timestamp;
  public int gsV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117906);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Hpm);
      paramVarArgs.aS(2, this.Timestamp);
      paramVarArgs.aS(3, this.gsV);
      AppMethodBeat.o(117906);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Hpm);
      int i = f.a.a.b.b.a.bz(2, this.Timestamp);
      int j = f.a.a.b.b.a.bz(3, this.gsV);
      AppMethodBeat.o(117906);
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
      AppMethodBeat.o(117906);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cxy localcxy = (cxy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117906);
        return -1;
      case 1: 
        localcxy.Hpm = locala.NPN.zc();
        AppMethodBeat.o(117906);
        return 0;
      case 2: 
        localcxy.Timestamp = locala.NPN.zc();
        AppMethodBeat.o(117906);
        return 0;
      }
      localcxy.gsV = locala.NPN.zc();
      AppMethodBeat.o(117906);
      return 0;
    }
    AppMethodBeat.o(117906);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxy
 * JD-Core Version:    0.7.0.1
 */