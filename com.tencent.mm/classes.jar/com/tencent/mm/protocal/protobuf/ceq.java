package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ceq
  extends com.tencent.mm.bx.a
{
  public String GYF;
  public String GYG;
  public int GYH;
  public String GYI;
  public String GYJ;
  public String GYK;
  public int GYL;
  public int GYM;
  public int GYN;
  public long GYO;
  public String buG;
  public String dzZ;
  public String oBR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152632);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.buG != null) {
        paramVarArgs.d(1, this.buG);
      }
      if (this.GYF != null) {
        paramVarArgs.d(2, this.GYF);
      }
      if (this.GYG != null) {
        paramVarArgs.d(3, this.GYG);
      }
      paramVarArgs.aS(4, this.GYH);
      if (this.dzZ != null) {
        paramVarArgs.d(5, this.dzZ);
      }
      if (this.GYI != null) {
        paramVarArgs.d(6, this.GYI);
      }
      if (this.GYJ != null) {
        paramVarArgs.d(7, this.GYJ);
      }
      if (this.oBR != null) {
        paramVarArgs.d(8, this.oBR);
      }
      if (this.GYK != null) {
        paramVarArgs.d(9, this.GYK);
      }
      paramVarArgs.aS(10, this.GYL);
      paramVarArgs.aS(11, this.GYM);
      paramVarArgs.aS(12, this.GYN);
      paramVarArgs.aY(13, this.GYO);
      AppMethodBeat.o(152632);
      return 0;
    }
    if (paramInt == 1) {
      if (this.buG == null) {
        break label878;
      }
    }
    label878:
    for (int i = f.a.a.b.b.a.e(1, this.buG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GYF != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GYF);
      }
      i = paramInt;
      if (this.GYG != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GYG);
      }
      i += f.a.a.b.b.a.bz(4, this.GYH);
      paramInt = i;
      if (this.dzZ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dzZ);
      }
      i = paramInt;
      if (this.GYI != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GYI);
      }
      paramInt = i;
      if (this.GYJ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GYJ);
      }
      i = paramInt;
      if (this.oBR != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.oBR);
      }
      paramInt = i;
      if (this.GYK != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GYK);
      }
      i = f.a.a.b.b.a.bz(10, this.GYL);
      int j = f.a.a.b.b.a.bz(11, this.GYM);
      int k = f.a.a.b.b.a.bz(12, this.GYN);
      int m = f.a.a.b.b.a.p(13, this.GYO);
      AppMethodBeat.o(152632);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152632);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ceq localceq = (ceq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152632);
          return -1;
        case 1: 
          localceq.buG = locala.NPN.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 2: 
          localceq.GYF = locala.NPN.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 3: 
          localceq.GYG = locala.NPN.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 4: 
          localceq.GYH = locala.NPN.zc();
          AppMethodBeat.o(152632);
          return 0;
        case 5: 
          localceq.dzZ = locala.NPN.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 6: 
          localceq.GYI = locala.NPN.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 7: 
          localceq.GYJ = locala.NPN.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 8: 
          localceq.oBR = locala.NPN.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 9: 
          localceq.GYK = locala.NPN.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 10: 
          localceq.GYL = locala.NPN.zc();
          AppMethodBeat.o(152632);
          return 0;
        case 11: 
          localceq.GYM = locala.NPN.zc();
          AppMethodBeat.o(152632);
          return 0;
        case 12: 
          localceq.GYN = locala.NPN.zc();
          AppMethodBeat.o(152632);
          return 0;
        }
        localceq.GYO = locala.NPN.zd();
        AppMethodBeat.o(152632);
        return 0;
      }
      AppMethodBeat.o(152632);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ceq
 * JD-Core Version:    0.7.0.1
 */