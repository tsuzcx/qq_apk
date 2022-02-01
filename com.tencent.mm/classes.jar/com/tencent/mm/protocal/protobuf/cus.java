package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cus
  extends com.tencent.mm.bw.a
{
  public String KUC;
  public int MzQ;
  public int MzR;
  public String MzS;
  public int MzT;
  public int MzU;
  public long MzV;
  public int MzZ;
  public String iwv;
  public int pQJ;
  public int type;
  public int xHb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6416);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KUC != null) {
        paramVarArgs.e(1, this.KUC);
      }
      paramVarArgs.aM(2, this.MzQ);
      paramVarArgs.aM(3, this.xHb);
      paramVarArgs.aM(4, this.MzR);
      paramVarArgs.aM(5, this.pQJ);
      paramVarArgs.aM(6, this.type);
      if (this.iwv != null) {
        paramVarArgs.e(7, this.iwv);
      }
      if (this.MzS != null) {
        paramVarArgs.e(8, this.MzS);
      }
      paramVarArgs.aM(9, this.MzT);
      paramVarArgs.aM(10, this.MzU);
      paramVarArgs.aM(11, this.MzZ);
      paramVarArgs.bb(12, this.MzV);
      AppMethodBeat.o(6416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KUC == null) {
        break label760;
      }
    }
    label760:
    for (paramInt = g.a.a.b.b.a.f(1, this.KUC) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MzQ) + g.a.a.b.b.a.bu(3, this.xHb) + g.a.a.b.b.a.bu(4, this.MzR) + g.a.a.b.b.a.bu(5, this.pQJ) + g.a.a.b.b.a.bu(6, this.type);
      paramInt = i;
      if (this.iwv != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.iwv);
      }
      i = paramInt;
      if (this.MzS != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.MzS);
      }
      paramInt = g.a.a.b.b.a.bu(9, this.MzT);
      int j = g.a.a.b.b.a.bu(10, this.MzU);
      int k = g.a.a.b.b.a.bu(11, this.MzZ);
      int m = g.a.a.b.b.a.r(12, this.MzV);
      AppMethodBeat.o(6416);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(6416);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cus localcus = (cus)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6416);
          return -1;
        case 1: 
          localcus.KUC = locala.UbS.readString();
          AppMethodBeat.o(6416);
          return 0;
        case 2: 
          localcus.MzQ = locala.UbS.zi();
          AppMethodBeat.o(6416);
          return 0;
        case 3: 
          localcus.xHb = locala.UbS.zi();
          AppMethodBeat.o(6416);
          return 0;
        case 4: 
          localcus.MzR = locala.UbS.zi();
          AppMethodBeat.o(6416);
          return 0;
        case 5: 
          localcus.pQJ = locala.UbS.zi();
          AppMethodBeat.o(6416);
          return 0;
        case 6: 
          localcus.type = locala.UbS.zi();
          AppMethodBeat.o(6416);
          return 0;
        case 7: 
          localcus.iwv = locala.UbS.readString();
          AppMethodBeat.o(6416);
          return 0;
        case 8: 
          localcus.MzS = locala.UbS.readString();
          AppMethodBeat.o(6416);
          return 0;
        case 9: 
          localcus.MzT = locala.UbS.zi();
          AppMethodBeat.o(6416);
          return 0;
        case 10: 
          localcus.MzU = locala.UbS.zi();
          AppMethodBeat.o(6416);
          return 0;
        case 11: 
          localcus.MzZ = locala.UbS.zi();
          AppMethodBeat.o(6416);
          return 0;
        }
        localcus.MzV = locala.UbS.zl();
        AppMethodBeat.o(6416);
        return 0;
      }
      AppMethodBeat.o(6416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cus
 * JD-Core Version:    0.7.0.1
 */