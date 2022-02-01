package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class adb
  extends com.tencent.mm.cd.a
{
  public int SoU;
  public int SoV;
  public int SoW;
  public int SoX;
  public int tRD;
  public int tRE;
  public int tRF;
  public int tRG;
  public int tRH;
  public int tRI;
  public int tRJ;
  public int tRK;
  public int tRL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90959);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.tRD);
      paramVarArgs.aY(2, this.SoU);
      paramVarArgs.aY(3, this.tRE);
      paramVarArgs.aY(4, this.tRF);
      paramVarArgs.aY(5, this.tRG);
      paramVarArgs.aY(6, this.SoV);
      paramVarArgs.aY(7, this.tRH);
      paramVarArgs.aY(8, this.tRI);
      paramVarArgs.aY(9, this.SoW);
      paramVarArgs.aY(10, this.SoX);
      paramVarArgs.aY(11, this.tRJ);
      paramVarArgs.aY(12, this.tRK);
      paramVarArgs.aY(13, this.tRL);
      AppMethodBeat.o(90959);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.tRD);
      int i = g.a.a.b.b.a.bM(2, this.SoU);
      int j = g.a.a.b.b.a.bM(3, this.tRE);
      int k = g.a.a.b.b.a.bM(4, this.tRF);
      int m = g.a.a.b.b.a.bM(5, this.tRG);
      int n = g.a.a.b.b.a.bM(6, this.SoV);
      int i1 = g.a.a.b.b.a.bM(7, this.tRH);
      int i2 = g.a.a.b.b.a.bM(8, this.tRI);
      int i3 = g.a.a.b.b.a.bM(9, this.SoW);
      int i4 = g.a.a.b.b.a.bM(10, this.SoX);
      int i5 = g.a.a.b.b.a.bM(11, this.tRJ);
      int i6 = g.a.a.b.b.a.bM(12, this.tRK);
      int i7 = g.a.a.b.b.a.bM(13, this.tRL);
      AppMethodBeat.o(90959);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(90959);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      adb localadb = (adb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(90959);
        return -1;
      case 1: 
        localadb.tRD = locala.abFh.AK();
        AppMethodBeat.o(90959);
        return 0;
      case 2: 
        localadb.SoU = locala.abFh.AK();
        AppMethodBeat.o(90959);
        return 0;
      case 3: 
        localadb.tRE = locala.abFh.AK();
        AppMethodBeat.o(90959);
        return 0;
      case 4: 
        localadb.tRF = locala.abFh.AK();
        AppMethodBeat.o(90959);
        return 0;
      case 5: 
        localadb.tRG = locala.abFh.AK();
        AppMethodBeat.o(90959);
        return 0;
      case 6: 
        localadb.SoV = locala.abFh.AK();
        AppMethodBeat.o(90959);
        return 0;
      case 7: 
        localadb.tRH = locala.abFh.AK();
        AppMethodBeat.o(90959);
        return 0;
      case 8: 
        localadb.tRI = locala.abFh.AK();
        AppMethodBeat.o(90959);
        return 0;
      case 9: 
        localadb.SoW = locala.abFh.AK();
        AppMethodBeat.o(90959);
        return 0;
      case 10: 
        localadb.SoX = locala.abFh.AK();
        AppMethodBeat.o(90959);
        return 0;
      case 11: 
        localadb.tRJ = locala.abFh.AK();
        AppMethodBeat.o(90959);
        return 0;
      case 12: 
        localadb.tRK = locala.abFh.AK();
        AppMethodBeat.o(90959);
        return 0;
      }
      localadb.tRL = locala.abFh.AK();
      AppMethodBeat.o(90959);
      return 0;
    }
    AppMethodBeat.o(90959);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adb
 * JD-Core Version:    0.7.0.1
 */