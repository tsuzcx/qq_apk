package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dyn
  extends com.tencent.mm.bx.a
{
  public int HLW;
  public int HLX;
  public int HLY;
  public int HLZ;
  public int HMa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115910);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HLW);
      paramVarArgs.aS(2, this.HLX);
      paramVarArgs.aS(3, this.HLY);
      paramVarArgs.aS(4, this.HLZ);
      paramVarArgs.aS(5, this.HMa);
      AppMethodBeat.o(115910);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.HLW);
      int i = f.a.a.b.b.a.bz(2, this.HLX);
      int j = f.a.a.b.b.a.bz(3, this.HLY);
      int k = f.a.a.b.b.a.bz(4, this.HLZ);
      int m = f.a.a.b.b.a.bz(5, this.HMa);
      AppMethodBeat.o(115910);
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
      AppMethodBeat.o(115910);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dyn localdyn = (dyn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115910);
        return -1;
      case 1: 
        localdyn.HLW = locala.NPN.zc();
        AppMethodBeat.o(115910);
        return 0;
      case 2: 
        localdyn.HLX = locala.NPN.zc();
        AppMethodBeat.o(115910);
        return 0;
      case 3: 
        localdyn.HLY = locala.NPN.zc();
        AppMethodBeat.o(115910);
        return 0;
      case 4: 
        localdyn.HLZ = locala.NPN.zc();
        AppMethodBeat.o(115910);
        return 0;
      }
      localdyn.HMa = locala.NPN.zc();
      AppMethodBeat.o(115910);
      return 0;
    }
    AppMethodBeat.o(115910);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyn
 * JD-Core Version:    0.7.0.1
 */