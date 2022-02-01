package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cvr
  extends com.tencent.mm.bw.a
{
  public int LGU;
  public String MBe;
  public String MBf;
  public int MBg;
  public String MBh;
  public String MBi;
  public String MBj;
  public int MBk;
  public int MBl;
  public long MBm;
  public String buA;
  public String dST;
  public String pWh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152632);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.buA != null) {
        paramVarArgs.e(1, this.buA);
      }
      if (this.MBe != null) {
        paramVarArgs.e(2, this.MBe);
      }
      if (this.MBf != null) {
        paramVarArgs.e(3, this.MBf);
      }
      paramVarArgs.aM(4, this.MBg);
      if (this.dST != null) {
        paramVarArgs.e(5, this.dST);
      }
      if (this.MBh != null) {
        paramVarArgs.e(6, this.MBh);
      }
      if (this.MBi != null) {
        paramVarArgs.e(7, this.MBi);
      }
      if (this.pWh != null) {
        paramVarArgs.e(8, this.pWh);
      }
      if (this.MBj != null) {
        paramVarArgs.e(9, this.MBj);
      }
      paramVarArgs.aM(10, this.MBk);
      paramVarArgs.aM(11, this.MBl);
      paramVarArgs.aM(12, this.LGU);
      paramVarArgs.bb(13, this.MBm);
      AppMethodBeat.o(152632);
      return 0;
    }
    if (paramInt == 1) {
      if (this.buA == null) {
        break label878;
      }
    }
    label878:
    for (int i = g.a.a.b.b.a.f(1, this.buA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MBe != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MBe);
      }
      i = paramInt;
      if (this.MBf != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MBf);
      }
      i += g.a.a.b.b.a.bu(4, this.MBg);
      paramInt = i;
      if (this.dST != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.dST);
      }
      i = paramInt;
      if (this.MBh != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.MBh);
      }
      paramInt = i;
      if (this.MBi != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.MBi);
      }
      i = paramInt;
      if (this.pWh != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.pWh);
      }
      paramInt = i;
      if (this.MBj != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.MBj);
      }
      i = g.a.a.b.b.a.bu(10, this.MBk);
      int j = g.a.a.b.b.a.bu(11, this.MBl);
      int k = g.a.a.b.b.a.bu(12, this.LGU);
      int m = g.a.a.b.b.a.r(13, this.MBm);
      AppMethodBeat.o(152632);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152632);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cvr localcvr = (cvr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152632);
          return -1;
        case 1: 
          localcvr.buA = locala.UbS.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 2: 
          localcvr.MBe = locala.UbS.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 3: 
          localcvr.MBf = locala.UbS.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 4: 
          localcvr.MBg = locala.UbS.zi();
          AppMethodBeat.o(152632);
          return 0;
        case 5: 
          localcvr.dST = locala.UbS.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 6: 
          localcvr.MBh = locala.UbS.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 7: 
          localcvr.MBi = locala.UbS.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 8: 
          localcvr.pWh = locala.UbS.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 9: 
          localcvr.MBj = locala.UbS.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 10: 
          localcvr.MBk = locala.UbS.zi();
          AppMethodBeat.o(152632);
          return 0;
        case 11: 
          localcvr.MBl = locala.UbS.zi();
          AppMethodBeat.o(152632);
          return 0;
        case 12: 
          localcvr.LGU = locala.UbS.zi();
          AppMethodBeat.o(152632);
          return 0;
        }
        localcvr.MBm = locala.UbS.zl();
        AppMethodBeat.o(152632);
        return 0;
      }
      AppMethodBeat.o(152632);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvr
 * JD-Core Version:    0.7.0.1
 */