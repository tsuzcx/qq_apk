package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cp
  extends com.tencent.mm.bx.a
{
  public int FuW;
  public int FuX;
  public int FuY;
  public int FuZ;
  public int nEf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127429);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FuW);
      paramVarArgs.aS(2, this.nEf);
      paramVarArgs.aS(3, this.FuX);
      paramVarArgs.aS(4, this.FuY);
      paramVarArgs.aS(5, this.FuZ);
      AppMethodBeat.o(127429);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.FuW);
      int i = f.a.a.b.b.a.bz(2, this.nEf);
      int j = f.a.a.b.b.a.bz(3, this.FuX);
      int k = f.a.a.b.b.a.bz(4, this.FuY);
      int m = f.a.a.b.b.a.bz(5, this.FuZ);
      AppMethodBeat.o(127429);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(127429);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cp localcp = (cp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127429);
        return -1;
      case 1: 
        localcp.FuW = locala.NPN.zc();
        AppMethodBeat.o(127429);
        return 0;
      case 2: 
        localcp.nEf = locala.NPN.zc();
        AppMethodBeat.o(127429);
        return 0;
      case 3: 
        localcp.FuX = locala.NPN.zc();
        AppMethodBeat.o(127429);
        return 0;
      case 4: 
        localcp.FuY = locala.NPN.zc();
        AppMethodBeat.o(127429);
        return 0;
      }
      localcp.FuZ = locala.NPN.zc();
      AppMethodBeat.o(127429);
      return 0;
    }
    AppMethodBeat.o(127429);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cp
 * JD-Core Version:    0.7.0.1
 */