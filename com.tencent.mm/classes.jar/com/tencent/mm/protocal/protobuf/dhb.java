package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dhb
  extends com.tencent.mm.cd.a
{
  public int AvX;
  public int TNK;
  public int TNL;
  public int TNM;
  public int TNN;
  public int TNO;
  public int TNP;
  public int TNQ;
  public int TNR;
  public int TNS;
  public int TNT;
  public int TNU;
  public int TNV;
  public int TNW;
  public int TNX;
  public int TNY;
  public int TNZ;
  public int TOa;
  public int TOb;
  public int TOc;
  public int zXh;
  public int zXm;
  public int zXn;
  public int zXo;
  public int zXr;
  public int zXs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169089);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TNK);
      paramVarArgs.aY(2, this.TNL);
      paramVarArgs.aY(3, this.TNM);
      paramVarArgs.aY(4, this.TNN);
      paramVarArgs.aY(5, this.TNO);
      paramVarArgs.aY(6, this.zXh);
      paramVarArgs.aY(7, this.TNP);
      paramVarArgs.aY(8, this.TNQ);
      paramVarArgs.aY(9, this.AvX);
      paramVarArgs.aY(10, this.TNR);
      paramVarArgs.aY(11, this.TNS);
      paramVarArgs.aY(12, this.TNT);
      paramVarArgs.aY(13, this.TNU);
      paramVarArgs.aY(14, this.TNV);
      paramVarArgs.aY(15, this.TNW);
      paramVarArgs.aY(16, this.TNX);
      paramVarArgs.aY(17, this.TNY);
      paramVarArgs.aY(18, this.TNZ);
      paramVarArgs.aY(19, this.TOa);
      paramVarArgs.aY(20, this.zXm);
      paramVarArgs.aY(21, this.zXn);
      paramVarArgs.aY(22, this.zXo);
      paramVarArgs.aY(23, this.zXr);
      paramVarArgs.aY(24, this.zXs);
      paramVarArgs.aY(25, this.TOb);
      paramVarArgs.aY(26, this.TOc);
      AppMethodBeat.o(169089);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.TNK);
      int i = g.a.a.b.b.a.bM(2, this.TNL);
      int j = g.a.a.b.b.a.bM(3, this.TNM);
      int k = g.a.a.b.b.a.bM(4, this.TNN);
      int m = g.a.a.b.b.a.bM(5, this.TNO);
      int n = g.a.a.b.b.a.bM(6, this.zXh);
      int i1 = g.a.a.b.b.a.bM(7, this.TNP);
      int i2 = g.a.a.b.b.a.bM(8, this.TNQ);
      int i3 = g.a.a.b.b.a.bM(9, this.AvX);
      int i4 = g.a.a.b.b.a.bM(10, this.TNR);
      int i5 = g.a.a.b.b.a.bM(11, this.TNS);
      int i6 = g.a.a.b.b.a.bM(12, this.TNT);
      int i7 = g.a.a.b.b.a.bM(13, this.TNU);
      int i8 = g.a.a.b.b.a.bM(14, this.TNV);
      int i9 = g.a.a.b.b.a.bM(15, this.TNW);
      int i10 = g.a.a.b.b.a.bM(16, this.TNX);
      int i11 = g.a.a.b.b.a.bM(17, this.TNY);
      int i12 = g.a.a.b.b.a.bM(18, this.TNZ);
      int i13 = g.a.a.b.b.a.bM(19, this.TOa);
      int i14 = g.a.a.b.b.a.bM(20, this.zXm);
      int i15 = g.a.a.b.b.a.bM(21, this.zXn);
      int i16 = g.a.a.b.b.a.bM(22, this.zXo);
      int i17 = g.a.a.b.b.a.bM(23, this.zXr);
      int i18 = g.a.a.b.b.a.bM(24, this.zXs);
      int i19 = g.a.a.b.b.a.bM(25, this.TOb);
      int i20 = g.a.a.b.b.a.bM(26, this.TOc);
      AppMethodBeat.o(169089);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 + i10 + i11 + i12 + i13 + i14 + i15 + i16 + i17 + i18 + i19 + i20;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(169089);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dhb localdhb = (dhb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169089);
        return -1;
      case 1: 
        localdhb.TNK = locala.abFh.AK();
        AppMethodBeat.o(169089);
        return 0;
      case 2: 
        localdhb.TNL = locala.abFh.AK();
        AppMethodBeat.o(169089);
        return 0;
      case 3: 
        localdhb.TNM = locala.abFh.AK();
        AppMethodBeat.o(169089);
        return 0;
      case 4: 
        localdhb.TNN = locala.abFh.AK();
        AppMethodBeat.o(169089);
        return 0;
      case 5: 
        localdhb.TNO = locala.abFh.AK();
        AppMethodBeat.o(169089);
        return 0;
      case 6: 
        localdhb.zXh = locala.abFh.AK();
        AppMethodBeat.o(169089);
        return 0;
      case 7: 
        localdhb.TNP = locala.abFh.AK();
        AppMethodBeat.o(169089);
        return 0;
      case 8: 
        localdhb.TNQ = locala.abFh.AK();
        AppMethodBeat.o(169089);
        return 0;
      case 9: 
        localdhb.AvX = locala.abFh.AK();
        AppMethodBeat.o(169089);
        return 0;
      case 10: 
        localdhb.TNR = locala.abFh.AK();
        AppMethodBeat.o(169089);
        return 0;
      case 11: 
        localdhb.TNS = locala.abFh.AK();
        AppMethodBeat.o(169089);
        return 0;
      case 12: 
        localdhb.TNT = locala.abFh.AK();
        AppMethodBeat.o(169089);
        return 0;
      case 13: 
        localdhb.TNU = locala.abFh.AK();
        AppMethodBeat.o(169089);
        return 0;
      case 14: 
        localdhb.TNV = locala.abFh.AK();
        AppMethodBeat.o(169089);
        return 0;
      case 15: 
        localdhb.TNW = locala.abFh.AK();
        AppMethodBeat.o(169089);
        return 0;
      case 16: 
        localdhb.TNX = locala.abFh.AK();
        AppMethodBeat.o(169089);
        return 0;
      case 17: 
        localdhb.TNY = locala.abFh.AK();
        AppMethodBeat.o(169089);
        return 0;
      case 18: 
        localdhb.TNZ = locala.abFh.AK();
        AppMethodBeat.o(169089);
        return 0;
      case 19: 
        localdhb.TOa = locala.abFh.AK();
        AppMethodBeat.o(169089);
        return 0;
      case 20: 
        localdhb.zXm = locala.abFh.AK();
        AppMethodBeat.o(169089);
        return 0;
      case 21: 
        localdhb.zXn = locala.abFh.AK();
        AppMethodBeat.o(169089);
        return 0;
      case 22: 
        localdhb.zXo = locala.abFh.AK();
        AppMethodBeat.o(169089);
        return 0;
      case 23: 
        localdhb.zXr = locala.abFh.AK();
        AppMethodBeat.o(169089);
        return 0;
      case 24: 
        localdhb.zXs = locala.abFh.AK();
        AppMethodBeat.o(169089);
        return 0;
      case 25: 
        localdhb.TOb = locala.abFh.AK();
        AppMethodBeat.o(169089);
        return 0;
      }
      localdhb.TOc = locala.abFh.AK();
      AppMethodBeat.o(169089);
      return 0;
    }
    AppMethodBeat.o(169089);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhb
 * JD-Core Version:    0.7.0.1
 */