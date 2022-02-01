package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpo
  extends com.tencent.mm.bx.a
{
  public int DNW;
  public int DNX;
  public int DNY;
  public int hQv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116472);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DNW);
      paramVarArgs.aR(2, this.DNX);
      paramVarArgs.aR(3, this.DNY);
      paramVarArgs.aR(4, this.hQv);
      AppMethodBeat.o(116472);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.DNW);
      int i = f.a.a.b.b.a.bA(2, this.DNX);
      int j = f.a.a.b.b.a.bA(3, this.DNY);
      int k = f.a.a.b.b.a.bA(4, this.hQv);
      AppMethodBeat.o(116472);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(116472);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bpo localbpo = (bpo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116472);
        return -1;
      case 1: 
        localbpo.DNW = locala.KhF.xS();
        AppMethodBeat.o(116472);
        return 0;
      case 2: 
        localbpo.DNX = locala.KhF.xS();
        AppMethodBeat.o(116472);
        return 0;
      case 3: 
        localbpo.DNY = locala.KhF.xS();
        AppMethodBeat.o(116472);
        return 0;
      }
      localbpo.hQv = locala.KhF.xS();
      AppMethodBeat.o(116472);
      return 0;
    }
    AppMethodBeat.o(116472);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpo
 * JD-Core Version:    0.7.0.1
 */