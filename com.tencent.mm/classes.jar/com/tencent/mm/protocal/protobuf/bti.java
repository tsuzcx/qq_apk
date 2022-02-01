package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bti
  extends com.tencent.mm.bx.a
{
  public int DIc;
  public int DQM;
  public int DQN;
  public int DQO;
  public int DQP;
  public int DQQ;
  public int DQR;
  public int mBH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143985);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DIc);
      paramVarArgs.aR(2, this.DQM);
      paramVarArgs.aR(3, this.DQN);
      paramVarArgs.aR(4, this.DQO);
      paramVarArgs.aR(5, this.DQP);
      paramVarArgs.aR(6, this.DQQ);
      paramVarArgs.aR(7, this.DQR);
      paramVarArgs.aR(8, this.mBH);
      AppMethodBeat.o(143985);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.DIc);
      int i = f.a.a.b.b.a.bA(2, this.DQM);
      int j = f.a.a.b.b.a.bA(3, this.DQN);
      int k = f.a.a.b.b.a.bA(4, this.DQO);
      int m = f.a.a.b.b.a.bA(5, this.DQP);
      int n = f.a.a.b.b.a.bA(6, this.DQQ);
      int i1 = f.a.a.b.b.a.bA(7, this.DQR);
      int i2 = f.a.a.b.b.a.bA(8, this.mBH);
      AppMethodBeat.o(143985);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(143985);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bti localbti = (bti)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143985);
        return -1;
      case 1: 
        localbti.DIc = locala.KhF.xS();
        AppMethodBeat.o(143985);
        return 0;
      case 2: 
        localbti.DQM = locala.KhF.xS();
        AppMethodBeat.o(143985);
        return 0;
      case 3: 
        localbti.DQN = locala.KhF.xS();
        AppMethodBeat.o(143985);
        return 0;
      case 4: 
        localbti.DQO = locala.KhF.xS();
        AppMethodBeat.o(143985);
        return 0;
      case 5: 
        localbti.DQP = locala.KhF.xS();
        AppMethodBeat.o(143985);
        return 0;
      case 6: 
        localbti.DQQ = locala.KhF.xS();
        AppMethodBeat.o(143985);
        return 0;
      case 7: 
        localbti.DQR = locala.KhF.xS();
        AppMethodBeat.o(143985);
        return 0;
      }
      localbti.mBH = locala.KhF.xS();
      AppMethodBeat.o(143985);
      return 0;
    }
    AppMethodBeat.o(143985);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bti
 * JD-Core Version:    0.7.0.1
 */