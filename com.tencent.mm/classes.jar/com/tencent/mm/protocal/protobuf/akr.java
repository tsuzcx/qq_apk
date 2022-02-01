package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class akr
  extends com.tencent.mm.bx.a
{
  public int GjK;
  public int GjL;
  public int GjM;
  public int GjN;
  public int GjO;
  public int GjP;
  public int GjQ;
  public int GjR;
  public int GjS;
  public int GjT;
  public int GjU;
  public int GjV;
  public int GjW;
  public int fileCount;
  public int tGM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127492);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GjK);
      paramVarArgs.aS(2, this.GjL);
      paramVarArgs.aS(3, this.GjM);
      paramVarArgs.aS(4, this.tGM);
      paramVarArgs.aS(5, this.GjN);
      paramVarArgs.aS(6, this.GjO);
      paramVarArgs.aS(7, this.GjP);
      paramVarArgs.aS(8, this.fileCount);
      paramVarArgs.aS(9, this.GjQ);
      paramVarArgs.aS(10, this.GjR);
      paramVarArgs.aS(11, this.GjS);
      paramVarArgs.aS(12, this.GjT);
      paramVarArgs.aS(13, this.GjU);
      paramVarArgs.aS(14, this.GjV);
      paramVarArgs.aS(15, this.GjW);
      AppMethodBeat.o(127492);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.GjK);
      int i = f.a.a.b.b.a.bz(2, this.GjL);
      int j = f.a.a.b.b.a.bz(3, this.GjM);
      int k = f.a.a.b.b.a.bz(4, this.tGM);
      int m = f.a.a.b.b.a.bz(5, this.GjN);
      int n = f.a.a.b.b.a.bz(6, this.GjO);
      int i1 = f.a.a.b.b.a.bz(7, this.GjP);
      int i2 = f.a.a.b.b.a.bz(8, this.fileCount);
      int i3 = f.a.a.b.b.a.bz(9, this.GjQ);
      int i4 = f.a.a.b.b.a.bz(10, this.GjR);
      int i5 = f.a.a.b.b.a.bz(11, this.GjS);
      int i6 = f.a.a.b.b.a.bz(12, this.GjT);
      int i7 = f.a.a.b.b.a.bz(13, this.GjU);
      int i8 = f.a.a.b.b.a.bz(14, this.GjV);
      int i9 = f.a.a.b.b.a.bz(15, this.GjW);
      AppMethodBeat.o(127492);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(127492);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      akr localakr = (akr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127492);
        return -1;
      case 1: 
        localakr.GjK = locala.NPN.zc();
        AppMethodBeat.o(127492);
        return 0;
      case 2: 
        localakr.GjL = locala.NPN.zc();
        AppMethodBeat.o(127492);
        return 0;
      case 3: 
        localakr.GjM = locala.NPN.zc();
        AppMethodBeat.o(127492);
        return 0;
      case 4: 
        localakr.tGM = locala.NPN.zc();
        AppMethodBeat.o(127492);
        return 0;
      case 5: 
        localakr.GjN = locala.NPN.zc();
        AppMethodBeat.o(127492);
        return 0;
      case 6: 
        localakr.GjO = locala.NPN.zc();
        AppMethodBeat.o(127492);
        return 0;
      case 7: 
        localakr.GjP = locala.NPN.zc();
        AppMethodBeat.o(127492);
        return 0;
      case 8: 
        localakr.fileCount = locala.NPN.zc();
        AppMethodBeat.o(127492);
        return 0;
      case 9: 
        localakr.GjQ = locala.NPN.zc();
        AppMethodBeat.o(127492);
        return 0;
      case 10: 
        localakr.GjR = locala.NPN.zc();
        AppMethodBeat.o(127492);
        return 0;
      case 11: 
        localakr.GjS = locala.NPN.zc();
        AppMethodBeat.o(127492);
        return 0;
      case 12: 
        localakr.GjT = locala.NPN.zc();
        AppMethodBeat.o(127492);
        return 0;
      case 13: 
        localakr.GjU = locala.NPN.zc();
        AppMethodBeat.o(127492);
        return 0;
      case 14: 
        localakr.GjV = locala.NPN.zc();
        AppMethodBeat.o(127492);
        return 0;
      }
      localakr.GjW = locala.NPN.zc();
      AppMethodBeat.o(127492);
      return 0;
    }
    AppMethodBeat.o(127492);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akr
 * JD-Core Version:    0.7.0.1
 */