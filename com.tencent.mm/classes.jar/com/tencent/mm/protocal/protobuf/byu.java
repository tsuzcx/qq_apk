package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class byu
  extends com.tencent.mm.bx.a
{
  public int GTV;
  public int GTW;
  public int GTX;
  public int wJZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116472);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GTV);
      paramVarArgs.aS(2, this.GTW);
      paramVarArgs.aS(3, this.GTX);
      paramVarArgs.aS(4, this.wJZ);
      AppMethodBeat.o(116472);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.GTV);
      int i = f.a.a.b.b.a.bz(2, this.GTW);
      int j = f.a.a.b.b.a.bz(3, this.GTX);
      int k = f.a.a.b.b.a.bz(4, this.wJZ);
      AppMethodBeat.o(116472);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(116472);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      byu localbyu = (byu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116472);
        return -1;
      case 1: 
        localbyu.GTV = locala.NPN.zc();
        AppMethodBeat.o(116472);
        return 0;
      case 2: 
        localbyu.GTW = locala.NPN.zc();
        AppMethodBeat.o(116472);
        return 0;
      case 3: 
        localbyu.GTX = locala.NPN.zc();
        AppMethodBeat.o(116472);
        return 0;
      }
      localbyu.wJZ = locala.NPN.zc();
      AppMethodBeat.o(116472);
      return 0;
    }
    AppMethodBeat.o(116472);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byu
 * JD-Core Version:    0.7.0.1
 */