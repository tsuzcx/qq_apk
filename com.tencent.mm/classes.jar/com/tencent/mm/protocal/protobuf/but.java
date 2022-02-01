package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class but
  extends com.tencent.mm.bx.a
{
  public int CLY;
  public String CVK;
  public int CYi;
  public int DRV;
  public int DRW;
  public String DRX;
  public int DRY;
  public String DRZ;
  public int FileSize;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32360);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CVK != null) {
        paramVarArgs.d(1, this.CVK);
      }
      paramVarArgs.aR(2, this.DRV);
      paramVarArgs.aR(3, this.DRW);
      paramVarArgs.aR(4, this.CLY);
      if (this.DRX != null) {
        paramVarArgs.d(5, this.DRX);
      }
      paramVarArgs.aR(6, this.FileSize);
      paramVarArgs.aR(7, this.DRY);
      paramVarArgs.aR(8, this.CYi);
      if (this.DRZ != null) {
        paramVarArgs.d(9, this.DRZ);
      }
      AppMethodBeat.o(32360);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CVK == null) {
        break label613;
      }
    }
    label613:
    for (paramInt = f.a.a.b.b.a.e(1, this.CVK) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DRV) + f.a.a.b.b.a.bA(3, this.DRW) + f.a.a.b.b.a.bA(4, this.CLY);
      paramInt = i;
      if (this.DRX != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DRX);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.FileSize) + f.a.a.b.b.a.bA(7, this.DRY) + f.a.a.b.b.a.bA(8, this.CYi);
      paramInt = i;
      if (this.DRZ != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DRZ);
      }
      AppMethodBeat.o(32360);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32360);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        but localbut = (but)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32360);
          return -1;
        case 1: 
          localbut.CVK = locala.KhF.readString();
          AppMethodBeat.o(32360);
          return 0;
        case 2: 
          localbut.DRV = locala.KhF.xS();
          AppMethodBeat.o(32360);
          return 0;
        case 3: 
          localbut.DRW = locala.KhF.xS();
          AppMethodBeat.o(32360);
          return 0;
        case 4: 
          localbut.CLY = locala.KhF.xS();
          AppMethodBeat.o(32360);
          return 0;
        case 5: 
          localbut.DRX = locala.KhF.readString();
          AppMethodBeat.o(32360);
          return 0;
        case 6: 
          localbut.FileSize = locala.KhF.xS();
          AppMethodBeat.o(32360);
          return 0;
        case 7: 
          localbut.DRY = locala.KhF.xS();
          AppMethodBeat.o(32360);
          return 0;
        case 8: 
          localbut.CYi = locala.KhF.xS();
          AppMethodBeat.o(32360);
          return 0;
        }
        localbut.DRZ = locala.KhF.readString();
        AppMethodBeat.o(32360);
        return 0;
      }
      AppMethodBeat.o(32360);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.but
 * JD-Core Version:    0.7.0.1
 */