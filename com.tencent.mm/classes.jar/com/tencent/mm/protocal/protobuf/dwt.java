package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dwt
  extends com.tencent.mm.bx.a
{
  public int CHC;
  public int DGx;
  public int EKF;
  public int EKG;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123712);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DGx);
      paramVarArgs.aR(2, this.CHC);
      paramVarArgs.aR(3, this.EKF);
      paramVarArgs.aR(4, this.Scene);
      paramVarArgs.aR(10, this.EKG);
      AppMethodBeat.o(123712);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.DGx);
      int i = f.a.a.b.b.a.bA(2, this.CHC);
      int j = f.a.a.b.b.a.bA(3, this.EKF);
      int k = f.a.a.b.b.a.bA(4, this.Scene);
      int m = f.a.a.b.b.a.bA(10, this.EKG);
      AppMethodBeat.o(123712);
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
      AppMethodBeat.o(123712);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dwt localdwt = (dwt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      default: 
        AppMethodBeat.o(123712);
        return -1;
      case 1: 
        localdwt.DGx = locala.KhF.xS();
        AppMethodBeat.o(123712);
        return 0;
      case 2: 
        localdwt.CHC = locala.KhF.xS();
        AppMethodBeat.o(123712);
        return 0;
      case 3: 
        localdwt.EKF = locala.KhF.xS();
        AppMethodBeat.o(123712);
        return 0;
      case 4: 
        localdwt.Scene = locala.KhF.xS();
        AppMethodBeat.o(123712);
        return 0;
      }
      localdwt.EKG = locala.KhF.xS();
      AppMethodBeat.o(123712);
      return 0;
    }
    AppMethodBeat.o(123712);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwt
 * JD-Core Version:    0.7.0.1
 */