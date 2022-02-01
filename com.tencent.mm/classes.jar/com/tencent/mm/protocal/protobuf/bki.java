package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bki
  extends dpc
{
  public String KDA;
  public boolean KDB = false;
  public int KDC;
  public int KDD;
  public int KDE;
  public String KDF;
  public String KDG;
  public String KDI;
  public String KDJ;
  public String KDK;
  public String KDL;
  public String KDM;
  public String KDN;
  public String KDO;
  public String KDP;
  public String KDp;
  public String KDq;
  public String KDr;
  public String KDs;
  public String KDt;
  public String KDu;
  public String KDv;
  public String KDw;
  public String KDx;
  public String KDy;
  public String KDz;
  public int LTy;
  public String content;
  public String ixw;
  public String pRX;
  public int pSR;
  public String pSS;
  public String pST;
  public String pSU;
  public String pSV;
  public String pSW;
  public String pSX;
  public int pSY;
  public String pSZ;
  public String pTa;
  public String pTb;
  public String pTc;
  public String pTd;
  public String pTe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114009);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.KDp != null) {
        paramVarArgs.e(2, this.KDp);
      }
      if (this.KDq != null) {
        paramVarArgs.e(3, this.KDq);
      }
      if (this.KDr != null) {
        paramVarArgs.e(4, this.KDr);
      }
      if (this.content != null) {
        paramVarArgs.e(5, this.content);
      }
      if (this.KDs != null) {
        paramVarArgs.e(6, this.KDs);
      }
      if (this.KDt != null) {
        paramVarArgs.e(7, this.KDt);
      }
      if (this.KDu != null) {
        paramVarArgs.e(8, this.KDu);
      }
      if (this.KDv != null) {
        paramVarArgs.e(9, this.KDv);
      }
      if (this.KDw != null) {
        paramVarArgs.e(10, this.KDw);
      }
      if (this.KDx != null) {
        paramVarArgs.e(11, this.KDx);
      }
      if (this.KDy != null) {
        paramVarArgs.e(12, this.KDy);
      }
      if (this.KDz != null) {
        paramVarArgs.e(13, this.KDz);
      }
      if (this.pTd != null) {
        paramVarArgs.e(14, this.pTd);
      }
      if (this.pTe != null) {
        paramVarArgs.e(15, this.pTe);
      }
      if (this.KDA != null) {
        paramVarArgs.e(16, this.KDA);
      }
      paramVarArgs.cc(17, this.KDB);
      paramVarArgs.aM(18, this.KDC);
      paramVarArgs.aM(19, this.KDD);
      paramVarArgs.aM(20, this.KDE);
      if (this.ixw != null) {
        paramVarArgs.e(21, this.ixw);
      }
      if (this.KDF != null) {
        paramVarArgs.e(22, this.KDF);
      }
      if (this.KDG != null) {
        paramVarArgs.e(23, this.KDG);
      }
      paramVarArgs.aM(24, this.LTy);
      if (this.KDI != null) {
        paramVarArgs.e(25, this.KDI);
      }
      if (this.KDJ != null) {
        paramVarArgs.e(26, this.KDJ);
      }
      if (this.KDK != null) {
        paramVarArgs.e(27, this.KDK);
      }
      if (this.KDL != null) {
        paramVarArgs.e(28, this.KDL);
      }
      if (this.KDM != null) {
        paramVarArgs.e(29, this.KDM);
      }
      if (this.KDN != null) {
        paramVarArgs.e(30, this.KDN);
      }
      if (this.KDO != null) {
        paramVarArgs.e(31, this.KDO);
      }
      if (this.pRX != null) {
        paramVarArgs.e(32, this.pRX);
      }
      if (this.KDP != null) {
        paramVarArgs.e(33, this.KDP);
      }
      paramVarArgs.aM(37, this.pSR);
      if (this.pSS != null) {
        paramVarArgs.e(38, this.pSS);
      }
      if (this.pST != null) {
        paramVarArgs.e(39, this.pST);
      }
      if (this.pSU != null) {
        paramVarArgs.e(40, this.pSU);
      }
      if (this.pSV != null) {
        paramVarArgs.e(41, this.pSV);
      }
      if (this.pSW != null) {
        paramVarArgs.e(42, this.pSW);
      }
      if (this.pSX != null) {
        paramVarArgs.e(43, this.pSX);
      }
      paramVarArgs.aM(44, this.pSY);
      if (this.pSZ != null) {
        paramVarArgs.e(45, this.pSZ);
      }
      if (this.pTa != null) {
        paramVarArgs.e(46, this.pTa);
      }
      if (this.pTb != null) {
        paramVarArgs.e(47, this.pTb);
      }
      if (this.pTc != null) {
        paramVarArgs.e(48, this.pTc);
      }
      AppMethodBeat.o(114009);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2922;
      }
    }
    label2922:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KDp != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KDp);
      }
      i = paramInt;
      if (this.KDq != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KDq);
      }
      paramInt = i;
      if (this.KDr != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KDr);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.content);
      }
      paramInt = i;
      if (this.KDs != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KDs);
      }
      i = paramInt;
      if (this.KDt != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.KDt);
      }
      paramInt = i;
      if (this.KDu != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.KDu);
      }
      i = paramInt;
      if (this.KDv != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.KDv);
      }
      paramInt = i;
      if (this.KDw != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.KDw);
      }
      i = paramInt;
      if (this.KDx != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.KDx);
      }
      paramInt = i;
      if (this.KDy != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.KDy);
      }
      i = paramInt;
      if (this.KDz != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.KDz);
      }
      paramInt = i;
      if (this.pTd != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.pTd);
      }
      i = paramInt;
      if (this.pTe != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.pTe);
      }
      paramInt = i;
      if (this.KDA != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.KDA);
      }
      i = paramInt + (g.a.a.b.b.a.fS(17) + 1) + g.a.a.b.b.a.bu(18, this.KDC) + g.a.a.b.b.a.bu(19, this.KDD) + g.a.a.b.b.a.bu(20, this.KDE);
      paramInt = i;
      if (this.ixw != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.ixw);
      }
      i = paramInt;
      if (this.KDF != null) {
        i = paramInt + g.a.a.b.b.a.f(22, this.KDF);
      }
      paramInt = i;
      if (this.KDG != null) {
        paramInt = i + g.a.a.b.b.a.f(23, this.KDG);
      }
      i = paramInt + g.a.a.b.b.a.bu(24, this.LTy);
      paramInt = i;
      if (this.KDI != null) {
        paramInt = i + g.a.a.b.b.a.f(25, this.KDI);
      }
      i = paramInt;
      if (this.KDJ != null) {
        i = paramInt + g.a.a.b.b.a.f(26, this.KDJ);
      }
      paramInt = i;
      if (this.KDK != null) {
        paramInt = i + g.a.a.b.b.a.f(27, this.KDK);
      }
      i = paramInt;
      if (this.KDL != null) {
        i = paramInt + g.a.a.b.b.a.f(28, this.KDL);
      }
      paramInt = i;
      if (this.KDM != null) {
        paramInt = i + g.a.a.b.b.a.f(29, this.KDM);
      }
      i = paramInt;
      if (this.KDN != null) {
        i = paramInt + g.a.a.b.b.a.f(30, this.KDN);
      }
      paramInt = i;
      if (this.KDO != null) {
        paramInt = i + g.a.a.b.b.a.f(31, this.KDO);
      }
      i = paramInt;
      if (this.pRX != null) {
        i = paramInt + g.a.a.b.b.a.f(32, this.pRX);
      }
      paramInt = i;
      if (this.KDP != null) {
        paramInt = i + g.a.a.b.b.a.f(33, this.KDP);
      }
      i = paramInt + g.a.a.b.b.a.bu(37, this.pSR);
      paramInt = i;
      if (this.pSS != null) {
        paramInt = i + g.a.a.b.b.a.f(38, this.pSS);
      }
      i = paramInt;
      if (this.pST != null) {
        i = paramInt + g.a.a.b.b.a.f(39, this.pST);
      }
      paramInt = i;
      if (this.pSU != null) {
        paramInt = i + g.a.a.b.b.a.f(40, this.pSU);
      }
      i = paramInt;
      if (this.pSV != null) {
        i = paramInt + g.a.a.b.b.a.f(41, this.pSV);
      }
      paramInt = i;
      if (this.pSW != null) {
        paramInt = i + g.a.a.b.b.a.f(42, this.pSW);
      }
      i = paramInt;
      if (this.pSX != null) {
        i = paramInt + g.a.a.b.b.a.f(43, this.pSX);
      }
      i += g.a.a.b.b.a.bu(44, this.pSY);
      paramInt = i;
      if (this.pSZ != null) {
        paramInt = i + g.a.a.b.b.a.f(45, this.pSZ);
      }
      i = paramInt;
      if (this.pTa != null) {
        i = paramInt + g.a.a.b.b.a.f(46, this.pTa);
      }
      paramInt = i;
      if (this.pTb != null) {
        paramInt = i + g.a.a.b.b.a.f(47, this.pTb);
      }
      i = paramInt;
      if (this.pTc != null) {
        i = paramInt + g.a.a.b.b.a.f(48, this.pTc);
      }
      AppMethodBeat.o(114009);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(114009);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bki localbki = (bki)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 34: 
        case 35: 
        case 36: 
        default: 
          AppMethodBeat.o(114009);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbki.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114009);
          return 0;
        case 2: 
          localbki.KDp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 3: 
          localbki.KDq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 4: 
          localbki.KDr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 5: 
          localbki.content = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 6: 
          localbki.KDs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 7: 
          localbki.KDt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 8: 
          localbki.KDu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 9: 
          localbki.KDv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 10: 
          localbki.KDw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 11: 
          localbki.KDx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 12: 
          localbki.KDy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 13: 
          localbki.KDz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 14: 
          localbki.pTd = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 15: 
          localbki.pTe = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 16: 
          localbki.KDA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 17: 
          localbki.KDB = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(114009);
          return 0;
        case 18: 
          localbki.KDC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114009);
          return 0;
        case 19: 
          localbki.KDD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114009);
          return 0;
        case 20: 
          localbki.KDE = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114009);
          return 0;
        case 21: 
          localbki.ixw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 22: 
          localbki.KDF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 23: 
          localbki.KDG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 24: 
          localbki.LTy = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114009);
          return 0;
        case 25: 
          localbki.KDI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 26: 
          localbki.KDJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 27: 
          localbki.KDK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 28: 
          localbki.KDL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 29: 
          localbki.KDM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 30: 
          localbki.KDN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 31: 
          localbki.KDO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 32: 
          localbki.pRX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 33: 
          localbki.KDP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 37: 
          localbki.pSR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114009);
          return 0;
        case 38: 
          localbki.pSS = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 39: 
          localbki.pST = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 40: 
          localbki.pSU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 41: 
          localbki.pSV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 42: 
          localbki.pSW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 43: 
          localbki.pSX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 44: 
          localbki.pSY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114009);
          return 0;
        case 45: 
          localbki.pSZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 46: 
          localbki.pTa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 47: 
          localbki.pTb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114009);
          return 0;
        }
        localbki.pTc = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(114009);
        return 0;
      }
      AppMethodBeat.o(114009);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bki
 * JD-Core Version:    0.7.0.1
 */