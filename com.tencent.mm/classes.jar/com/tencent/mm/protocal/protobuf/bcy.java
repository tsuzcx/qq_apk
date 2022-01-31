package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bcy
  extends com.tencent.mm.bv.a
{
  public int gim;
  public int xsW;
  public int xsX;
  public int xsY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(2543);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xsW);
      paramVarArgs.aO(2, this.xsX);
      paramVarArgs.aO(3, this.xsY);
      paramVarArgs.aO(4, this.gim);
      AppMethodBeat.o(2543);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.xsW);
      int i = e.a.a.b.b.a.bl(2, this.xsX);
      int j = e.a.a.b.b.a.bl(3, this.xsY);
      int k = e.a.a.b.b.a.bl(4, this.gim);
      AppMethodBeat.o(2543);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(2543);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bcy localbcy = (bcy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(2543);
        return -1;
      case 1: 
        localbcy.xsW = locala.CLY.sl();
        AppMethodBeat.o(2543);
        return 0;
      case 2: 
        localbcy.xsX = locala.CLY.sl();
        AppMethodBeat.o(2543);
        return 0;
      case 3: 
        localbcy.xsY = locala.CLY.sl();
        AppMethodBeat.o(2543);
        return 0;
      }
      localbcy.gim = locala.CLY.sl();
      AppMethodBeat.o(2543);
      return 0;
    }
    AppMethodBeat.o(2543);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcy
 * JD-Core Version:    0.7.0.1
 */