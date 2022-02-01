package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bsu
  extends com.tencent.mm.bx.a
{
  public String DPR;
  public String DPS;
  public int DPT;
  public int DPU;
  public int DPV;
  public int DPW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133179);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DPR != null) {
        paramVarArgs.d(1, this.DPR);
      }
      if (this.DPS != null) {
        paramVarArgs.d(2, this.DPS);
      }
      paramVarArgs.aR(3, this.DPT);
      paramVarArgs.aR(4, this.DPU);
      paramVarArgs.aR(5, this.DPV);
      paramVarArgs.aR(7, this.DPW);
      AppMethodBeat.o(133179);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DPR == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = f.a.a.b.b.a.e(1, this.DPR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DPS != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DPS);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.DPT);
      int j = f.a.a.b.b.a.bA(4, this.DPU);
      int k = f.a.a.b.b.a.bA(5, this.DPV);
      int m = f.a.a.b.b.a.bA(7, this.DPW);
      AppMethodBeat.o(133179);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(133179);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bsu localbsu = (bsu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 6: 
        default: 
          AppMethodBeat.o(133179);
          return -1;
        case 1: 
          localbsu.DPR = locala.KhF.readString();
          AppMethodBeat.o(133179);
          return 0;
        case 2: 
          localbsu.DPS = locala.KhF.readString();
          AppMethodBeat.o(133179);
          return 0;
        case 3: 
          localbsu.DPT = locala.KhF.xS();
          AppMethodBeat.o(133179);
          return 0;
        case 4: 
          localbsu.DPU = locala.KhF.xS();
          AppMethodBeat.o(133179);
          return 0;
        case 5: 
          localbsu.DPV = locala.KhF.xS();
          AppMethodBeat.o(133179);
          return 0;
        }
        localbsu.DPW = locala.KhF.xS();
        AppMethodBeat.o(133179);
        return 0;
      }
      AppMethodBeat.o(133179);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsu
 * JD-Core Version:    0.7.0.1
 */