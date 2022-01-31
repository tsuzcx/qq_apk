package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class uv
  extends com.tencent.mm.bv.a
{
  public int kKE;
  public int kKF;
  public int kKG;
  public int kKH;
  public int kKI;
  public int kKJ;
  public int kKK;
  public int kKL;
  public int kKM;
  public int wNa;
  public int wNb;
  public int wNc;
  public int wNd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(135598);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.kKE);
      paramVarArgs.aO(2, this.wNa);
      paramVarArgs.aO(3, this.kKF);
      paramVarArgs.aO(4, this.kKG);
      paramVarArgs.aO(5, this.kKH);
      paramVarArgs.aO(6, this.wNb);
      paramVarArgs.aO(7, this.kKI);
      paramVarArgs.aO(8, this.kKJ);
      paramVarArgs.aO(9, this.wNc);
      paramVarArgs.aO(10, this.wNd);
      paramVarArgs.aO(11, this.kKK);
      paramVarArgs.aO(12, this.kKL);
      paramVarArgs.aO(13, this.kKM);
      AppMethodBeat.o(135598);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.kKE);
      int i = e.a.a.b.b.a.bl(2, this.wNa);
      int j = e.a.a.b.b.a.bl(3, this.kKF);
      int k = e.a.a.b.b.a.bl(4, this.kKG);
      int m = e.a.a.b.b.a.bl(5, this.kKH);
      int n = e.a.a.b.b.a.bl(6, this.wNb);
      int i1 = e.a.a.b.b.a.bl(7, this.kKI);
      int i2 = e.a.a.b.b.a.bl(8, this.kKJ);
      int i3 = e.a.a.b.b.a.bl(9, this.wNc);
      int i4 = e.a.a.b.b.a.bl(10, this.wNd);
      int i5 = e.a.a.b.b.a.bl(11, this.kKK);
      int i6 = e.a.a.b.b.a.bl(12, this.kKL);
      int i7 = e.a.a.b.b.a.bl(13, this.kKM);
      AppMethodBeat.o(135598);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(135598);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      uv localuv = (uv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(135598);
        return -1;
      case 1: 
        localuv.kKE = locala.CLY.sl();
        AppMethodBeat.o(135598);
        return 0;
      case 2: 
        localuv.wNa = locala.CLY.sl();
        AppMethodBeat.o(135598);
        return 0;
      case 3: 
        localuv.kKF = locala.CLY.sl();
        AppMethodBeat.o(135598);
        return 0;
      case 4: 
        localuv.kKG = locala.CLY.sl();
        AppMethodBeat.o(135598);
        return 0;
      case 5: 
        localuv.kKH = locala.CLY.sl();
        AppMethodBeat.o(135598);
        return 0;
      case 6: 
        localuv.wNb = locala.CLY.sl();
        AppMethodBeat.o(135598);
        return 0;
      case 7: 
        localuv.kKI = locala.CLY.sl();
        AppMethodBeat.o(135598);
        return 0;
      case 8: 
        localuv.kKJ = locala.CLY.sl();
        AppMethodBeat.o(135598);
        return 0;
      case 9: 
        localuv.wNc = locala.CLY.sl();
        AppMethodBeat.o(135598);
        return 0;
      case 10: 
        localuv.wNd = locala.CLY.sl();
        AppMethodBeat.o(135598);
        return 0;
      case 11: 
        localuv.kKK = locala.CLY.sl();
        AppMethodBeat.o(135598);
        return 0;
      case 12: 
        localuv.kKL = locala.CLY.sl();
        AppMethodBeat.o(135598);
        return 0;
      }
      localuv.kKM = locala.CLY.sl();
      AppMethodBeat.o(135598);
      return 0;
    }
    AppMethodBeat.o(135598);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uv
 * JD-Core Version:    0.7.0.1
 */