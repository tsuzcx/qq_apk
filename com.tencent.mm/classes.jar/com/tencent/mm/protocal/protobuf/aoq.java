package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aoq
  extends com.tencent.mm.cd.a
{
  public int JCD;
  public int SAQ;
  public int SAR;
  public int SAS;
  public int SAT;
  public int SAU;
  public int SAV;
  public int SAW;
  public int SAX;
  public int SAY;
  public int SAZ;
  public int SBa;
  public int SBb;
  public int fileCount;
  public int xzT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127492);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SAQ);
      paramVarArgs.aY(2, this.JCD);
      paramVarArgs.aY(3, this.SAR);
      paramVarArgs.aY(4, this.xzT);
      paramVarArgs.aY(5, this.SAS);
      paramVarArgs.aY(6, this.SAT);
      paramVarArgs.aY(7, this.SAU);
      paramVarArgs.aY(8, this.fileCount);
      paramVarArgs.aY(9, this.SAV);
      paramVarArgs.aY(10, this.SAW);
      paramVarArgs.aY(11, this.SAX);
      paramVarArgs.aY(12, this.SAY);
      paramVarArgs.aY(13, this.SAZ);
      paramVarArgs.aY(14, this.SBa);
      paramVarArgs.aY(15, this.SBb);
      AppMethodBeat.o(127492);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.SAQ);
      int i = g.a.a.b.b.a.bM(2, this.JCD);
      int j = g.a.a.b.b.a.bM(3, this.SAR);
      int k = g.a.a.b.b.a.bM(4, this.xzT);
      int m = g.a.a.b.b.a.bM(5, this.SAS);
      int n = g.a.a.b.b.a.bM(6, this.SAT);
      int i1 = g.a.a.b.b.a.bM(7, this.SAU);
      int i2 = g.a.a.b.b.a.bM(8, this.fileCount);
      int i3 = g.a.a.b.b.a.bM(9, this.SAV);
      int i4 = g.a.a.b.b.a.bM(10, this.SAW);
      int i5 = g.a.a.b.b.a.bM(11, this.SAX);
      int i6 = g.a.a.b.b.a.bM(12, this.SAY);
      int i7 = g.a.a.b.b.a.bM(13, this.SAZ);
      int i8 = g.a.a.b.b.a.bM(14, this.SBa);
      int i9 = g.a.a.b.b.a.bM(15, this.SBb);
      AppMethodBeat.o(127492);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(127492);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      aoq localaoq = (aoq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127492);
        return -1;
      case 1: 
        localaoq.SAQ = locala.abFh.AK();
        AppMethodBeat.o(127492);
        return 0;
      case 2: 
        localaoq.JCD = locala.abFh.AK();
        AppMethodBeat.o(127492);
        return 0;
      case 3: 
        localaoq.SAR = locala.abFh.AK();
        AppMethodBeat.o(127492);
        return 0;
      case 4: 
        localaoq.xzT = locala.abFh.AK();
        AppMethodBeat.o(127492);
        return 0;
      case 5: 
        localaoq.SAS = locala.abFh.AK();
        AppMethodBeat.o(127492);
        return 0;
      case 6: 
        localaoq.SAT = locala.abFh.AK();
        AppMethodBeat.o(127492);
        return 0;
      case 7: 
        localaoq.SAU = locala.abFh.AK();
        AppMethodBeat.o(127492);
        return 0;
      case 8: 
        localaoq.fileCount = locala.abFh.AK();
        AppMethodBeat.o(127492);
        return 0;
      case 9: 
        localaoq.SAV = locala.abFh.AK();
        AppMethodBeat.o(127492);
        return 0;
      case 10: 
        localaoq.SAW = locala.abFh.AK();
        AppMethodBeat.o(127492);
        return 0;
      case 11: 
        localaoq.SAX = locala.abFh.AK();
        AppMethodBeat.o(127492);
        return 0;
      case 12: 
        localaoq.SAY = locala.abFh.AK();
        AppMethodBeat.o(127492);
        return 0;
      case 13: 
        localaoq.SAZ = locala.abFh.AK();
        AppMethodBeat.o(127492);
        return 0;
      case 14: 
        localaoq.SBa = locala.abFh.AK();
        AppMethodBeat.o(127492);
        return 0;
      }
      localaoq.SBb = locala.abFh.AK();
      AppMethodBeat.o(127492);
      return 0;
    }
    AppMethodBeat.o(127492);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoq
 * JD-Core Version:    0.7.0.1
 */