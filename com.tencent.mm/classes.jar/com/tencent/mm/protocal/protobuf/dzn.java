package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzn
  extends com.tencent.mm.bx.a
{
  public int LxV;
  public int LxW;
  public int LxX;
  public int LxY;
  public int LxZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203874);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.LxV);
      paramVarArgs.aR(2, this.LxW);
      paramVarArgs.aR(3, this.LxX);
      paramVarArgs.aR(4, this.LxY);
      paramVarArgs.aR(5, this.LxZ);
      AppMethodBeat.o(203874);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.LxV);
      int i = f.a.a.b.b.a.bA(2, this.LxW);
      int j = f.a.a.b.b.a.bA(3, this.LxX);
      int k = f.a.a.b.b.a.bA(4, this.LxY);
      int m = f.a.a.b.b.a.bA(5, this.LxZ);
      AppMethodBeat.o(203874);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(203874);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dzn localdzn = (dzn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(203874);
        return -1;
      case 1: 
        localdzn.LxV = locala.KhF.xS();
        AppMethodBeat.o(203874);
        return 0;
      case 2: 
        localdzn.LxW = locala.KhF.xS();
        AppMethodBeat.o(203874);
        return 0;
      case 3: 
        localdzn.LxX = locala.KhF.xS();
        AppMethodBeat.o(203874);
        return 0;
      case 4: 
        localdzn.LxY = locala.KhF.xS();
        AppMethodBeat.o(203874);
        return 0;
      }
      localdzn.LxZ = locala.KhF.xS();
      AppMethodBeat.o(203874);
      return 0;
    }
    AppMethodBeat.o(203874);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzn
 * JD-Core Version:    0.7.0.1
 */