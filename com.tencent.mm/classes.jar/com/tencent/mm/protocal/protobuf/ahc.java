package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahc
  extends com.tencent.mm.bx.a
{
  public int DiS;
  public int DiT;
  public int DiU;
  public int DiV;
  public int DiW;
  public int DiX;
  public int DiY;
  public int DiZ;
  public int Dja;
  public int Djb;
  public int Djc;
  public int Djd;
  public int Dje;
  public int fileCount;
  public int rBj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127492);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DiS);
      paramVarArgs.aR(2, this.DiT);
      paramVarArgs.aR(3, this.DiU);
      paramVarArgs.aR(4, this.rBj);
      paramVarArgs.aR(5, this.DiV);
      paramVarArgs.aR(6, this.DiW);
      paramVarArgs.aR(7, this.DiX);
      paramVarArgs.aR(8, this.fileCount);
      paramVarArgs.aR(9, this.DiY);
      paramVarArgs.aR(10, this.DiZ);
      paramVarArgs.aR(11, this.Dja);
      paramVarArgs.aR(12, this.Djb);
      paramVarArgs.aR(13, this.Djc);
      paramVarArgs.aR(14, this.Djd);
      paramVarArgs.aR(15, this.Dje);
      AppMethodBeat.o(127492);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.DiS);
      int i = f.a.a.b.b.a.bA(2, this.DiT);
      int j = f.a.a.b.b.a.bA(3, this.DiU);
      int k = f.a.a.b.b.a.bA(4, this.rBj);
      int m = f.a.a.b.b.a.bA(5, this.DiV);
      int n = f.a.a.b.b.a.bA(6, this.DiW);
      int i1 = f.a.a.b.b.a.bA(7, this.DiX);
      int i2 = f.a.a.b.b.a.bA(8, this.fileCount);
      int i3 = f.a.a.b.b.a.bA(9, this.DiY);
      int i4 = f.a.a.b.b.a.bA(10, this.DiZ);
      int i5 = f.a.a.b.b.a.bA(11, this.Dja);
      int i6 = f.a.a.b.b.a.bA(12, this.Djb);
      int i7 = f.a.a.b.b.a.bA(13, this.Djc);
      int i8 = f.a.a.b.b.a.bA(14, this.Djd);
      int i9 = f.a.a.b.b.a.bA(15, this.Dje);
      AppMethodBeat.o(127492);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(127492);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ahc localahc = (ahc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127492);
        return -1;
      case 1: 
        localahc.DiS = locala.KhF.xS();
        AppMethodBeat.o(127492);
        return 0;
      case 2: 
        localahc.DiT = locala.KhF.xS();
        AppMethodBeat.o(127492);
        return 0;
      case 3: 
        localahc.DiU = locala.KhF.xS();
        AppMethodBeat.o(127492);
        return 0;
      case 4: 
        localahc.rBj = locala.KhF.xS();
        AppMethodBeat.o(127492);
        return 0;
      case 5: 
        localahc.DiV = locala.KhF.xS();
        AppMethodBeat.o(127492);
        return 0;
      case 6: 
        localahc.DiW = locala.KhF.xS();
        AppMethodBeat.o(127492);
        return 0;
      case 7: 
        localahc.DiX = locala.KhF.xS();
        AppMethodBeat.o(127492);
        return 0;
      case 8: 
        localahc.fileCount = locala.KhF.xS();
        AppMethodBeat.o(127492);
        return 0;
      case 9: 
        localahc.DiY = locala.KhF.xS();
        AppMethodBeat.o(127492);
        return 0;
      case 10: 
        localahc.DiZ = locala.KhF.xS();
        AppMethodBeat.o(127492);
        return 0;
      case 11: 
        localahc.Dja = locala.KhF.xS();
        AppMethodBeat.o(127492);
        return 0;
      case 12: 
        localahc.Djb = locala.KhF.xS();
        AppMethodBeat.o(127492);
        return 0;
      case 13: 
        localahc.Djc = locala.KhF.xS();
        AppMethodBeat.o(127492);
        return 0;
      case 14: 
        localahc.Djd = locala.KhF.xS();
        AppMethodBeat.o(127492);
        return 0;
      }
      localahc.Dje = locala.KhF.xS();
      AppMethodBeat.o(127492);
      return 0;
    }
    AppMethodBeat.o(127492);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahc
 * JD-Core Version:    0.7.0.1
 */