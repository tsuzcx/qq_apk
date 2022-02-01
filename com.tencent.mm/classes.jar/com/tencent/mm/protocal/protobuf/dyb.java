package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dyb
  extends com.tencent.mm.bx.a
{
  public int HKA;
  public int HKB;
  public int HKC;
  public int HKD;
  public int HKE;
  public int HKF;
  public int HKG;
  public LinkedList<Integer> HKH;
  public int HKI;
  public LinkedList<Integer> HKJ;
  public int HKK;
  public LinkedList<Integer> HKL;
  public String HKM;
  public String HKN;
  public int HKx;
  public int HKy;
  public int HKz;
  
  public dyb()
  {
    AppMethodBeat.i(115892);
    this.HKH = new LinkedList();
    this.HKJ = new LinkedList();
    this.HKL = new LinkedList();
    AppMethodBeat.o(115892);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115893);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HKx);
      paramVarArgs.aS(2, this.HKy);
      paramVarArgs.aS(3, this.HKz);
      paramVarArgs.aS(4, this.HKA);
      paramVarArgs.aS(5, this.HKB);
      paramVarArgs.aS(6, this.HKC);
      paramVarArgs.aS(7, this.HKD);
      paramVarArgs.aS(8, this.HKE);
      paramVarArgs.aS(9, this.HKF);
      paramVarArgs.aS(10, this.HKG);
      paramVarArgs.e(11, 2, this.HKH);
      paramVarArgs.aS(12, this.HKI);
      paramVarArgs.e(13, 2, this.HKJ);
      paramVarArgs.aS(14, this.HKK);
      paramVarArgs.e(15, 2, this.HKL);
      if (this.HKM != null) {
        paramVarArgs.d(16, this.HKM);
      }
      if (this.HKN != null) {
        paramVarArgs.d(17, this.HKN);
      }
      AppMethodBeat.o(115893);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HKx) + 0 + f.a.a.b.b.a.bz(2, this.HKy) + f.a.a.b.b.a.bz(3, this.HKz) + f.a.a.b.b.a.bz(4, this.HKA) + f.a.a.b.b.a.bz(5, this.HKB) + f.a.a.b.b.a.bz(6, this.HKC) + f.a.a.b.b.a.bz(7, this.HKD) + f.a.a.b.b.a.bz(8, this.HKE) + f.a.a.b.b.a.bz(9, this.HKF) + f.a.a.b.b.a.bz(10, this.HKG) + f.a.a.a.c(11, 2, this.HKH) + f.a.a.b.b.a.bz(12, this.HKI) + f.a.a.a.c(13, 2, this.HKJ) + f.a.a.b.b.a.bz(14, this.HKK) + f.a.a.a.c(15, 2, this.HKL);
      paramInt = i;
      if (this.HKM != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.HKM);
      }
      i = paramInt;
      if (this.HKN != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.HKN);
      }
      AppMethodBeat.o(115893);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HKH.clear();
      this.HKJ.clear();
      this.HKL.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(115893);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dyb localdyb = (dyb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115893);
        return -1;
      case 1: 
        localdyb.HKx = locala.NPN.zc();
        AppMethodBeat.o(115893);
        return 0;
      case 2: 
        localdyb.HKy = locala.NPN.zc();
        AppMethodBeat.o(115893);
        return 0;
      case 3: 
        localdyb.HKz = locala.NPN.zc();
        AppMethodBeat.o(115893);
        return 0;
      case 4: 
        localdyb.HKA = locala.NPN.zc();
        AppMethodBeat.o(115893);
        return 0;
      case 5: 
        localdyb.HKB = locala.NPN.zc();
        AppMethodBeat.o(115893);
        return 0;
      case 6: 
        localdyb.HKC = locala.NPN.zc();
        AppMethodBeat.o(115893);
        return 0;
      case 7: 
        localdyb.HKD = locala.NPN.zc();
        AppMethodBeat.o(115893);
        return 0;
      case 8: 
        localdyb.HKE = locala.NPN.zc();
        AppMethodBeat.o(115893);
        return 0;
      case 9: 
        localdyb.HKF = locala.NPN.zc();
        AppMethodBeat.o(115893);
        return 0;
      case 10: 
        localdyb.HKG = locala.NPN.zc();
        AppMethodBeat.o(115893);
        return 0;
      case 11: 
        localdyb.HKH.add(Integer.valueOf(locala.NPN.zc()));
        AppMethodBeat.o(115893);
        return 0;
      case 12: 
        localdyb.HKI = locala.NPN.zc();
        AppMethodBeat.o(115893);
        return 0;
      case 13: 
        localdyb.HKJ.add(Integer.valueOf(locala.NPN.zc()));
        AppMethodBeat.o(115893);
        return 0;
      case 14: 
        localdyb.HKK = locala.NPN.zc();
        AppMethodBeat.o(115893);
        return 0;
      case 15: 
        localdyb.HKL.add(Integer.valueOf(locala.NPN.zc()));
        AppMethodBeat.o(115893);
        return 0;
      case 16: 
        localdyb.HKM = locala.NPN.readString();
        AppMethodBeat.o(115893);
        return 0;
      }
      localdyb.HKN = locala.NPN.readString();
      AppMethodBeat.o(115893);
      return 0;
    }
    AppMethodBeat.o(115893);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyb
 * JD-Core Version:    0.7.0.1
 */