package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class xy
  extends com.tencent.mm.bx.a
{
  public String CZE;
  public String CZF;
  public String CZG;
  public int CZH;
  public int CZI;
  public int CZJ;
  public int CZK;
  public int CZL;
  public int CZM;
  public int CZN;
  public int CZO;
  public int CZP;
  public int CZQ;
  public int CZR;
  public int CZS;
  public int CZT;
  public String CZU;
  public String CZV;
  public String CZW;
  public String CZX;
  public String CZY;
  public b CZZ;
  public String Daa;
  public String app_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90960);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.app_id != null) {
        paramVarArgs.d(1, this.app_id);
      }
      if (this.CZE != null) {
        paramVarArgs.d(2, this.CZE);
      }
      if (this.CZF != null) {
        paramVarArgs.d(3, this.CZF);
      }
      if (this.CZG != null) {
        paramVarArgs.d(4, this.CZG);
      }
      paramVarArgs.aR(5, this.CZH);
      paramVarArgs.aR(6, this.CZI);
      paramVarArgs.aR(7, this.CZJ);
      paramVarArgs.aR(8, this.CZK);
      paramVarArgs.aR(9, this.CZL);
      paramVarArgs.aR(10, this.CZM);
      paramVarArgs.aR(11, this.CZN);
      paramVarArgs.aR(12, this.CZO);
      paramVarArgs.aR(13, this.CZP);
      paramVarArgs.aR(14, this.CZQ);
      paramVarArgs.aR(20, this.CZR);
      paramVarArgs.aR(21, this.CZS);
      paramVarArgs.aR(22, this.CZT);
      if (this.CZU != null) {
        paramVarArgs.d(25, this.CZU);
      }
      if (this.CZV != null) {
        paramVarArgs.d(26, this.CZV);
      }
      if (this.CZW != null) {
        paramVarArgs.d(27, this.CZW);
      }
      if (this.CZX != null) {
        paramVarArgs.d(28, this.CZX);
      }
      if (this.CZY != null) {
        paramVarArgs.d(29, this.CZY);
      }
      if (this.CZZ != null) {
        paramVarArgs.c(30, this.CZZ);
      }
      if (this.Daa != null) {
        paramVarArgs.d(31, this.Daa);
      }
      AppMethodBeat.o(90960);
      return 0;
    }
    if (paramInt == 1) {
      if (this.app_id == null) {
        break label1430;
      }
    }
    label1430:
    for (int i = f.a.a.b.b.a.e(1, this.app_id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CZE != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CZE);
      }
      i = paramInt;
      if (this.CZF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CZF);
      }
      paramInt = i;
      if (this.CZG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CZG);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.CZH) + f.a.a.b.b.a.bA(6, this.CZI) + f.a.a.b.b.a.bA(7, this.CZJ) + f.a.a.b.b.a.bA(8, this.CZK) + f.a.a.b.b.a.bA(9, this.CZL) + f.a.a.b.b.a.bA(10, this.CZM) + f.a.a.b.b.a.bA(11, this.CZN) + f.a.a.b.b.a.bA(12, this.CZO) + f.a.a.b.b.a.bA(13, this.CZP) + f.a.a.b.b.a.bA(14, this.CZQ) + f.a.a.b.b.a.bA(20, this.CZR) + f.a.a.b.b.a.bA(21, this.CZS) + f.a.a.b.b.a.bA(22, this.CZT);
      paramInt = i;
      if (this.CZU != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.CZU);
      }
      i = paramInt;
      if (this.CZV != null) {
        i = paramInt + f.a.a.b.b.a.e(26, this.CZV);
      }
      paramInt = i;
      if (this.CZW != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.CZW);
      }
      i = paramInt;
      if (this.CZX != null) {
        i = paramInt + f.a.a.b.b.a.e(28, this.CZX);
      }
      paramInt = i;
      if (this.CZY != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.CZY);
      }
      i = paramInt;
      if (this.CZZ != null) {
        i = paramInt + f.a.a.b.b.a.b(30, this.CZZ);
      }
      paramInt = i;
      if (this.Daa != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.Daa);
      }
      AppMethodBeat.o(90960);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(90960);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        xy localxy = (xy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 19: 
        case 23: 
        case 24: 
        default: 
          AppMethodBeat.o(90960);
          return -1;
        case 1: 
          localxy.app_id = locala.KhF.readString();
          AppMethodBeat.o(90960);
          return 0;
        case 2: 
          localxy.CZE = locala.KhF.readString();
          AppMethodBeat.o(90960);
          return 0;
        case 3: 
          localxy.CZF = locala.KhF.readString();
          AppMethodBeat.o(90960);
          return 0;
        case 4: 
          localxy.CZG = locala.KhF.readString();
          AppMethodBeat.o(90960);
          return 0;
        case 5: 
          localxy.CZH = locala.KhF.xS();
          AppMethodBeat.o(90960);
          return 0;
        case 6: 
          localxy.CZI = locala.KhF.xS();
          AppMethodBeat.o(90960);
          return 0;
        case 7: 
          localxy.CZJ = locala.KhF.xS();
          AppMethodBeat.o(90960);
          return 0;
        case 8: 
          localxy.CZK = locala.KhF.xS();
          AppMethodBeat.o(90960);
          return 0;
        case 9: 
          localxy.CZL = locala.KhF.xS();
          AppMethodBeat.o(90960);
          return 0;
        case 10: 
          localxy.CZM = locala.KhF.xS();
          AppMethodBeat.o(90960);
          return 0;
        case 11: 
          localxy.CZN = locala.KhF.xS();
          AppMethodBeat.o(90960);
          return 0;
        case 12: 
          localxy.CZO = locala.KhF.xS();
          AppMethodBeat.o(90960);
          return 0;
        case 13: 
          localxy.CZP = locala.KhF.xS();
          AppMethodBeat.o(90960);
          return 0;
        case 14: 
          localxy.CZQ = locala.KhF.xS();
          AppMethodBeat.o(90960);
          return 0;
        case 20: 
          localxy.CZR = locala.KhF.xS();
          AppMethodBeat.o(90960);
          return 0;
        case 21: 
          localxy.CZS = locala.KhF.xS();
          AppMethodBeat.o(90960);
          return 0;
        case 22: 
          localxy.CZT = locala.KhF.xS();
          AppMethodBeat.o(90960);
          return 0;
        case 25: 
          localxy.CZU = locala.KhF.readString();
          AppMethodBeat.o(90960);
          return 0;
        case 26: 
          localxy.CZV = locala.KhF.readString();
          AppMethodBeat.o(90960);
          return 0;
        case 27: 
          localxy.CZW = locala.KhF.readString();
          AppMethodBeat.o(90960);
          return 0;
        case 28: 
          localxy.CZX = locala.KhF.readString();
          AppMethodBeat.o(90960);
          return 0;
        case 29: 
          localxy.CZY = locala.KhF.readString();
          AppMethodBeat.o(90960);
          return 0;
        case 30: 
          localxy.CZZ = locala.KhF.fMu();
          AppMethodBeat.o(90960);
          return 0;
        }
        localxy.Daa = locala.KhF.readString();
        AppMethodBeat.o(90960);
        return 0;
      }
      AppMethodBeat.o(90960);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xy
 * JD-Core Version:    0.7.0.1
 */