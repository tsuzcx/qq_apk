package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fud
  extends erp
{
  public String IMg;
  public String IMh;
  public int IcB;
  public String YCm;
  public String YCn;
  public String YCo;
  public String YFJ;
  public String YHk;
  public int YRD;
  public String ZaN;
  public int ZaO;
  public int ZaP;
  public int ZaQ;
  public String ZaR;
  public int Zsm;
  public int ZtS;
  public String aaGn;
  public String aaGp;
  public int aaSH;
  public int aaSI;
  public gol aaSJ;
  public int aaSK;
  public int abSf;
  public int abSg;
  public gol abSh;
  public String abSi;
  public int abSj;
  public String abSk;
  public int abSl;
  public String abSm;
  public String abSn;
  public String abSo;
  public String abSp;
  public String abSq;
  public String abSr;
  public String abSs;
  public long abSt;
  public String abSu;
  public String abSv;
  public String abSw;
  public int abSx;
  public int abzD;
  public int abzE;
  public int abzF;
  public int abzG;
  public String abzH;
  public String abzI;
  public int abzL;
  public String abzN;
  public int abzb;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127180);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaSJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbData");
        AppMethodBeat.o(127180);
        throw paramVarArgs;
      }
      if (this.abSh == null)
      {
        paramVarArgs = new b("Not all required fields were included: VideoData");
        AppMethodBeat.o(127180);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YHk != null) {
        paramVarArgs.g(2, this.YHk);
      }
      if (this.IMh != null) {
        paramVarArgs.g(3, this.IMh);
      }
      if (this.IMg != null) {
        paramVarArgs.g(4, this.IMg);
      }
      paramVarArgs.bS(5, this.aaSH);
      paramVarArgs.bS(6, this.aaSI);
      if (this.aaSJ != null)
      {
        paramVarArgs.qD(7, this.aaSJ.computeSize());
        this.aaSJ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.abSf);
      paramVarArgs.bS(9, this.abSg);
      if (this.abSh != null)
      {
        paramVarArgs.qD(10, this.abSh.computeSize());
        this.abSh.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(11, this.abzG);
      paramVarArgs.bS(12, this.Zsm);
      paramVarArgs.bS(13, this.aaSK);
      paramVarArgs.bS(14, this.YRD);
      if (this.YFJ != null) {
        paramVarArgs.g(15, this.YFJ);
      }
      if (this.abSi != null) {
        paramVarArgs.g(16, this.abSi);
      }
      if (this.ZaN != null) {
        paramVarArgs.g(17, this.ZaN);
      }
      paramVarArgs.bS(18, this.ZaO);
      if (this.aaGn != null) {
        paramVarArgs.g(19, this.aaGn);
      }
      paramVarArgs.bS(20, this.abzD);
      paramVarArgs.bS(21, this.abzE);
      paramVarArgs.bS(22, this.abzF);
      if (this.aaGp != null) {
        paramVarArgs.g(23, this.aaGp);
      }
      paramVarArgs.bS(24, this.abSj);
      paramVarArgs.bS(25, this.ZtS);
      if (this.abzH != null) {
        paramVarArgs.g(26, this.abzH);
      }
      if (this.abSk != null) {
        paramVarArgs.g(27, this.abSk);
      }
      paramVarArgs.bS(28, this.abSl);
      if (this.abSm != null) {
        paramVarArgs.g(29, this.abSm);
      }
      if (this.abSn != null) {
        paramVarArgs.g(30, this.abSn);
      }
      if (this.abSo != null) {
        paramVarArgs.g(31, this.abSo);
      }
      if (this.abSp != null) {
        paramVarArgs.g(32, this.abSp);
      }
      if (this.abSq != null) {
        paramVarArgs.g(33, this.abSq);
      }
      if (this.abSr != null) {
        paramVarArgs.g(34, this.abSr);
      }
      if (this.abSs != null) {
        paramVarArgs.g(35, this.abSs);
      }
      paramVarArgs.bS(36, this.abzb);
      if (this.abzI != null) {
        paramVarArgs.g(37, this.abzI);
      }
      paramVarArgs.bS(38, this.ZaP);
      paramVarArgs.bS(39, this.ZaQ);
      paramVarArgs.bS(40, this.IcB);
      if (this.ZaR != null) {
        paramVarArgs.g(41, this.ZaR);
      }
      if (this.oOI != null) {
        paramVarArgs.g(42, this.oOI);
      }
      if (this.YCo != null) {
        paramVarArgs.g(43, this.YCo);
      }
      if (this.YCn != null) {
        paramVarArgs.g(44, this.YCn);
      }
      if (this.YCm != null) {
        paramVarArgs.g(45, this.YCm);
      }
      if (this.abzN != null) {
        paramVarArgs.g(46, this.abzN);
      }
      paramVarArgs.bv(47, this.abSt);
      if (this.abSu != null) {
        paramVarArgs.g(48, this.abSu);
      }
      if (this.abSv != null) {
        paramVarArgs.g(49, this.abSv);
      }
      if (this.abSw != null) {
        paramVarArgs.g(50, this.abSw);
      }
      paramVarArgs.bS(51, this.abzL);
      paramVarArgs.bS(52, this.abSx);
      AppMethodBeat.o(127180);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label3308;
      }
    }
    label3308:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YHk != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YHk);
      }
      i = paramInt;
      if (this.IMh != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IMh);
      }
      paramInt = i;
      if (this.IMg != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IMg);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.aaSH) + i.a.a.b.b.a.cJ(6, this.aaSI);
      paramInt = i;
      if (this.aaSJ != null) {
        paramInt = i + i.a.a.a.qC(7, this.aaSJ.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.abSf) + i.a.a.b.b.a.cJ(9, this.abSg);
      paramInt = i;
      if (this.abSh != null) {
        paramInt = i + i.a.a.a.qC(10, this.abSh.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.abzG) + i.a.a.b.b.a.cJ(12, this.Zsm) + i.a.a.b.b.a.cJ(13, this.aaSK) + i.a.a.b.b.a.cJ(14, this.YRD);
      paramInt = i;
      if (this.YFJ != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.YFJ);
      }
      i = paramInt;
      if (this.abSi != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.abSi);
      }
      paramInt = i;
      if (this.ZaN != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.ZaN);
      }
      i = paramInt + i.a.a.b.b.a.cJ(18, this.ZaO);
      paramInt = i;
      if (this.aaGn != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.aaGn);
      }
      i = paramInt + i.a.a.b.b.a.cJ(20, this.abzD) + i.a.a.b.b.a.cJ(21, this.abzE) + i.a.a.b.b.a.cJ(22, this.abzF);
      paramInt = i;
      if (this.aaGp != null) {
        paramInt = i + i.a.a.b.b.a.h(23, this.aaGp);
      }
      i = paramInt + i.a.a.b.b.a.cJ(24, this.abSj) + i.a.a.b.b.a.cJ(25, this.ZtS);
      paramInt = i;
      if (this.abzH != null) {
        paramInt = i + i.a.a.b.b.a.h(26, this.abzH);
      }
      i = paramInt;
      if (this.abSk != null) {
        i = paramInt + i.a.a.b.b.a.h(27, this.abSk);
      }
      i += i.a.a.b.b.a.cJ(28, this.abSl);
      paramInt = i;
      if (this.abSm != null) {
        paramInt = i + i.a.a.b.b.a.h(29, this.abSm);
      }
      i = paramInt;
      if (this.abSn != null) {
        i = paramInt + i.a.a.b.b.a.h(30, this.abSn);
      }
      paramInt = i;
      if (this.abSo != null) {
        paramInt = i + i.a.a.b.b.a.h(31, this.abSo);
      }
      i = paramInt;
      if (this.abSp != null) {
        i = paramInt + i.a.a.b.b.a.h(32, this.abSp);
      }
      paramInt = i;
      if (this.abSq != null) {
        paramInt = i + i.a.a.b.b.a.h(33, this.abSq);
      }
      i = paramInt;
      if (this.abSr != null) {
        i = paramInt + i.a.a.b.b.a.h(34, this.abSr);
      }
      paramInt = i;
      if (this.abSs != null) {
        paramInt = i + i.a.a.b.b.a.h(35, this.abSs);
      }
      i = paramInt + i.a.a.b.b.a.cJ(36, this.abzb);
      paramInt = i;
      if (this.abzI != null) {
        paramInt = i + i.a.a.b.b.a.h(37, this.abzI);
      }
      i = paramInt + i.a.a.b.b.a.cJ(38, this.ZaP) + i.a.a.b.b.a.cJ(39, this.ZaQ) + i.a.a.b.b.a.cJ(40, this.IcB);
      paramInt = i;
      if (this.ZaR != null) {
        paramInt = i + i.a.a.b.b.a.h(41, this.ZaR);
      }
      i = paramInt;
      if (this.oOI != null) {
        i = paramInt + i.a.a.b.b.a.h(42, this.oOI);
      }
      paramInt = i;
      if (this.YCo != null) {
        paramInt = i + i.a.a.b.b.a.h(43, this.YCo);
      }
      i = paramInt;
      if (this.YCn != null) {
        i = paramInt + i.a.a.b.b.a.h(44, this.YCn);
      }
      paramInt = i;
      if (this.YCm != null) {
        paramInt = i + i.a.a.b.b.a.h(45, this.YCm);
      }
      i = paramInt;
      if (this.abzN != null) {
        i = paramInt + i.a.a.b.b.a.h(46, this.abzN);
      }
      i += i.a.a.b.b.a.q(47, this.abSt);
      paramInt = i;
      if (this.abSu != null) {
        paramInt = i + i.a.a.b.b.a.h(48, this.abSu);
      }
      i = paramInt;
      if (this.abSv != null) {
        i = paramInt + i.a.a.b.b.a.h(49, this.abSv);
      }
      paramInt = i;
      if (this.abSw != null) {
        paramInt = i + i.a.a.b.b.a.h(50, this.abSw);
      }
      i = i.a.a.b.b.a.cJ(51, this.abzL);
      int j = i.a.a.b.b.a.cJ(52, this.abSx);
      AppMethodBeat.o(127180);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.aaSJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbData");
          AppMethodBeat.o(127180);
          throw paramVarArgs;
        }
        if (this.abSh == null)
        {
          paramVarArgs = new b("Not all required fields were included: VideoData");
          AppMethodBeat.o(127180);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127180);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fud localfud = (fud)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127180);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localfud.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(127180);
          return 0;
        case 2: 
          localfud.YHk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 3: 
          localfud.IMh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 4: 
          localfud.IMg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 5: 
          localfud.aaSH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(127180);
          return 0;
        case 6: 
          localfud.aaSI = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(127180);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localfud.aaSJ = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(127180);
          return 0;
        case 8: 
          localfud.abSf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(127180);
          return 0;
        case 9: 
          localfud.abSg = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(127180);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localfud.abSh = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(127180);
          return 0;
        case 11: 
          localfud.abzG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(127180);
          return 0;
        case 12: 
          localfud.Zsm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(127180);
          return 0;
        case 13: 
          localfud.aaSK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(127180);
          return 0;
        case 14: 
          localfud.YRD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(127180);
          return 0;
        case 15: 
          localfud.YFJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 16: 
          localfud.abSi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 17: 
          localfud.ZaN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 18: 
          localfud.ZaO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(127180);
          return 0;
        case 19: 
          localfud.aaGn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 20: 
          localfud.abzD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(127180);
          return 0;
        case 21: 
          localfud.abzE = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(127180);
          return 0;
        case 22: 
          localfud.abzF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(127180);
          return 0;
        case 23: 
          localfud.aaGp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 24: 
          localfud.abSj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(127180);
          return 0;
        case 25: 
          localfud.ZtS = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(127180);
          return 0;
        case 26: 
          localfud.abzH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 27: 
          localfud.abSk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 28: 
          localfud.abSl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(127180);
          return 0;
        case 29: 
          localfud.abSm = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 30: 
          localfud.abSn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 31: 
          localfud.abSo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 32: 
          localfud.abSp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 33: 
          localfud.abSq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 34: 
          localfud.abSr = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 35: 
          localfud.abSs = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 36: 
          localfud.abzb = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(127180);
          return 0;
        case 37: 
          localfud.abzI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 38: 
          localfud.ZaP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(127180);
          return 0;
        case 39: 
          localfud.ZaQ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(127180);
          return 0;
        case 40: 
          localfud.IcB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(127180);
          return 0;
        case 41: 
          localfud.ZaR = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 42: 
          localfud.oOI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 43: 
          localfud.YCo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 44: 
          localfud.YCn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 45: 
          localfud.YCm = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 46: 
          localfud.abzN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 47: 
          localfud.abSt = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(127180);
          return 0;
        case 48: 
          localfud.abSu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 49: 
          localfud.abSv = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 50: 
          localfud.abSw = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 51: 
          localfud.abzL = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(127180);
          return 0;
        }
        localfud.abSx = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(127180);
        return 0;
      }
      AppMethodBeat.o(127180);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fud
 * JD-Core Version:    0.7.0.1
 */