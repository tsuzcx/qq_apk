package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cbp
  extends blm
{
  public String kWm;
  public String kWn;
  public String sGQ;
  public int sGR;
  public int sGS;
  public int sGT;
  public int sRM;
  public int sRb;
  public String svK;
  public String swQ;
  public int swS;
  public int tHc;
  public int tIl;
  public int tQD;
  public int tQE;
  public bmk tQF;
  public int tQG;
  public String tQH;
  public int tQI;
  public String tQJ;
  public String tQK;
  public int tQL;
  public String tQM;
  public String tQN;
  public String tQO;
  public String tQP;
  public String tQQ;
  public String tQR;
  public String tQS;
  public String tQT;
  public int tQv;
  public int tQw;
  public int tQx;
  public String tlM;
  public String tlO;
  public int trA;
  public int trB;
  public bmk trC;
  public int trD;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.trC == null) {
        throw new b("Not all required fields were included: ThumbData");
      }
      if (this.tQF == null) {
        throw new b("Not all required fields were included: VideoData");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.swQ != null) {
        paramVarArgs.d(2, this.swQ);
      }
      if (this.kWn != null) {
        paramVarArgs.d(3, this.kWn);
      }
      if (this.kWm != null) {
        paramVarArgs.d(4, this.kWm);
      }
      paramVarArgs.gB(5, this.trA);
      paramVarArgs.gB(6, this.trB);
      if (this.trC != null)
      {
        paramVarArgs.gD(7, this.trC.btq());
        this.trC.a(paramVarArgs);
      }
      paramVarArgs.gB(8, this.tQD);
      paramVarArgs.gB(9, this.tQE);
      if (this.tQF != null)
      {
        paramVarArgs.gD(10, this.tQF.btq());
        this.tQF.a(paramVarArgs);
      }
      paramVarArgs.gB(11, this.tIl);
      paramVarArgs.gB(12, this.sRb);
      paramVarArgs.gB(13, this.trD);
      paramVarArgs.gB(14, this.tQG);
      if (this.svK != null) {
        paramVarArgs.d(15, this.svK);
      }
      if (this.tQH != null) {
        paramVarArgs.d(16, this.tQH);
      }
      if (this.sGQ != null) {
        paramVarArgs.d(17, this.sGQ);
      }
      paramVarArgs.gB(18, this.sGR);
      if (this.tlM != null) {
        paramVarArgs.d(19, this.tlM);
      }
      paramVarArgs.gB(20, this.tQv);
      paramVarArgs.gB(21, this.tQw);
      paramVarArgs.gB(22, this.tQx);
      if (this.tlO != null) {
        paramVarArgs.d(23, this.tlO);
      }
      paramVarArgs.gB(24, this.tQI);
      paramVarArgs.gB(25, this.sRM);
      if (this.tQJ != null) {
        paramVarArgs.d(26, this.tQJ);
      }
      if (this.tQK != null) {
        paramVarArgs.d(27, this.tQK);
      }
      paramVarArgs.gB(28, this.tQL);
      if (this.tQM != null) {
        paramVarArgs.d(29, this.tQM);
      }
      if (this.tQN != null) {
        paramVarArgs.d(30, this.tQN);
      }
      if (this.tQO != null) {
        paramVarArgs.d(31, this.tQO);
      }
      if (this.tQP != null) {
        paramVarArgs.d(32, this.tQP);
      }
      if (this.tQQ != null) {
        paramVarArgs.d(33, this.tQQ);
      }
      if (this.tQR != null) {
        paramVarArgs.d(34, this.tQR);
      }
      if (this.tQS != null) {
        paramVarArgs.d(35, this.tQS);
      }
      paramVarArgs.gB(36, this.tHc);
      if (this.tQT != null) {
        paramVarArgs.d(37, this.tQT);
      }
      paramVarArgs.gB(38, this.sGS);
      paramVarArgs.gB(39, this.sGT);
      paramVarArgs.gB(40, this.swS);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label2414;
      }
    }
    label2414:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.swQ != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.swQ);
      }
      i = paramInt;
      if (this.kWn != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kWn);
      }
      paramInt = i;
      if (this.kWm != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kWm);
      }
      i = paramInt + d.a.a.a.gy(5, this.trA) + d.a.a.a.gy(6, this.trB);
      paramInt = i;
      if (this.trC != null) {
        paramInt = i + d.a.a.a.gA(7, this.trC.btq());
      }
      i = paramInt + d.a.a.a.gy(8, this.tQD) + d.a.a.a.gy(9, this.tQE);
      paramInt = i;
      if (this.tQF != null) {
        paramInt = i + d.a.a.a.gA(10, this.tQF.btq());
      }
      i = paramInt + d.a.a.a.gy(11, this.tIl) + d.a.a.a.gy(12, this.sRb) + d.a.a.a.gy(13, this.trD) + d.a.a.a.gy(14, this.tQG);
      paramInt = i;
      if (this.svK != null) {
        paramInt = i + d.a.a.b.b.a.e(15, this.svK);
      }
      i = paramInt;
      if (this.tQH != null) {
        i = paramInt + d.a.a.b.b.a.e(16, this.tQH);
      }
      paramInt = i;
      if (this.sGQ != null) {
        paramInt = i + d.a.a.b.b.a.e(17, this.sGQ);
      }
      i = paramInt + d.a.a.a.gy(18, this.sGR);
      paramInt = i;
      if (this.tlM != null) {
        paramInt = i + d.a.a.b.b.a.e(19, this.tlM);
      }
      i = paramInt + d.a.a.a.gy(20, this.tQv) + d.a.a.a.gy(21, this.tQw) + d.a.a.a.gy(22, this.tQx);
      paramInt = i;
      if (this.tlO != null) {
        paramInt = i + d.a.a.b.b.a.e(23, this.tlO);
      }
      i = paramInt + d.a.a.a.gy(24, this.tQI) + d.a.a.a.gy(25, this.sRM);
      paramInt = i;
      if (this.tQJ != null) {
        paramInt = i + d.a.a.b.b.a.e(26, this.tQJ);
      }
      i = paramInt;
      if (this.tQK != null) {
        i = paramInt + d.a.a.b.b.a.e(27, this.tQK);
      }
      i += d.a.a.a.gy(28, this.tQL);
      paramInt = i;
      if (this.tQM != null) {
        paramInt = i + d.a.a.b.b.a.e(29, this.tQM);
      }
      i = paramInt;
      if (this.tQN != null) {
        i = paramInt + d.a.a.b.b.a.e(30, this.tQN);
      }
      paramInt = i;
      if (this.tQO != null) {
        paramInt = i + d.a.a.b.b.a.e(31, this.tQO);
      }
      i = paramInt;
      if (this.tQP != null) {
        i = paramInt + d.a.a.b.b.a.e(32, this.tQP);
      }
      paramInt = i;
      if (this.tQQ != null) {
        paramInt = i + d.a.a.b.b.a.e(33, this.tQQ);
      }
      i = paramInt;
      if (this.tQR != null) {
        i = paramInt + d.a.a.b.b.a.e(34, this.tQR);
      }
      paramInt = i;
      if (this.tQS != null) {
        paramInt = i + d.a.a.b.b.a.e(35, this.tQS);
      }
      i = paramInt + d.a.a.a.gy(36, this.tHc);
      paramInt = i;
      if (this.tQT != null) {
        paramInt = i + d.a.a.b.b.a.e(37, this.tQT);
      }
      return paramInt + d.a.a.a.gy(38, this.sGS) + d.a.a.a.gy(39, this.sGT) + d.a.a.a.gy(40, this.swS);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.trC == null) {
          throw new b("Not all required fields were included: ThumbData");
        }
        if (this.tQF != null) {
          break;
        }
        throw new b("Not all required fields were included: VideoData");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cbp localcbp = (cbp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcbp.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcbp.swQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localcbp.kWn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localcbp.kWm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localcbp.trA = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localcbp.trB = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcbp.trC = ((bmk)localObject1);
            paramInt += 1;
          }
        case 8: 
          localcbp.tQD = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localcbp.tQE = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcbp.tQF = ((bmk)localObject1);
            paramInt += 1;
          }
        case 11: 
          localcbp.tIl = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          localcbp.sRb = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 13: 
          localcbp.trD = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 14: 
          localcbp.tQG = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 15: 
          localcbp.svK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 16: 
          localcbp.tQH = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 17: 
          localcbp.sGQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 18: 
          localcbp.sGR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 19: 
          localcbp.tlM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 20: 
          localcbp.tQv = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 21: 
          localcbp.tQw = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 22: 
          localcbp.tQx = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 23: 
          localcbp.tlO = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 24: 
          localcbp.tQI = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 25: 
          localcbp.sRM = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 26: 
          localcbp.tQJ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 27: 
          localcbp.tQK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 28: 
          localcbp.tQL = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 29: 
          localcbp.tQM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 30: 
          localcbp.tQN = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 31: 
          localcbp.tQO = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 32: 
          localcbp.tQP = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 33: 
          localcbp.tQQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 34: 
          localcbp.tQR = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 35: 
          localcbp.tQS = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 36: 
          localcbp.tHc = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 37: 
          localcbp.tQT = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 38: 
          localcbp.sGS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 39: 
          localcbp.sGT = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localcbp.swS = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cbp
 * JD-Core Version:    0.7.0.1
 */