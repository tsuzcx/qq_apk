package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cee
  extends bly
{
  public int sST;
  public long sSU;
  public int syY;
  public LinkedList<ceb> syZ = new LinkedList();
  public int tSL;
  public cfj tSM;
  public int tSN;
  public int tSO;
  public int tSP;
  public int tSQ;
  public bmk tSR;
  public int tSW;
  public LinkedList<cfl> tSX = new LinkedList();
  public int tSY;
  public int tSZ;
  public int tTa;
  public int tTb;
  public int tTc;
  public int tTd;
  public int tTe;
  public int tTf;
  public int tTg;
  public int tTh;
  public int tTi;
  public int tTj;
  public int tTk;
  public int tTl;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tSM == null) {
        throw new b("Not all required fields were included: RelayData");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.syY);
      paramVarArgs.d(3, 8, this.syZ);
      paramVarArgs.gB(4, this.sST);
      paramVarArgs.Y(5, this.sSU);
      paramVarArgs.gB(6, this.tSL);
      if (this.tSM != null)
      {
        paramVarArgs.gD(7, this.tSM.btq());
        this.tSM.a(paramVarArgs);
      }
      paramVarArgs.gB(8, this.tSW);
      paramVarArgs.d(9, 8, this.tSX);
      paramVarArgs.gB(10, this.tSY);
      paramVarArgs.gB(11, this.tSZ);
      paramVarArgs.gB(12, this.tTa);
      paramVarArgs.gB(13, this.tTb);
      paramVarArgs.gB(14, this.tTc);
      paramVarArgs.gB(15, this.tTd);
      paramVarArgs.gB(16, this.tSN);
      paramVarArgs.gB(17, this.tTe);
      paramVarArgs.gB(18, this.tTf);
      paramVarArgs.gB(19, this.tSO);
      paramVarArgs.gB(20, this.tTg);
      paramVarArgs.gB(21, this.tTh);
      paramVarArgs.gB(22, this.tTi);
      paramVarArgs.gB(23, this.tTj);
      paramVarArgs.gB(24, this.tSP);
      paramVarArgs.gB(25, this.tSQ);
      paramVarArgs.gB(26, this.tTk);
      paramVarArgs.gB(27, this.tTl);
      if (this.tSR != null)
      {
        paramVarArgs.gD(28, this.tSR.btq());
        this.tSR.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1798;
      }
    }
    label1798:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.syY) + d.a.a.a.c(3, 8, this.syZ) + d.a.a.a.gy(4, this.sST) + d.a.a.a.X(5, this.sSU) + d.a.a.a.gy(6, this.tSL);
      paramInt = i;
      if (this.tSM != null) {
        paramInt = i + d.a.a.a.gA(7, this.tSM.btq());
      }
      i = paramInt + d.a.a.a.gy(8, this.tSW) + d.a.a.a.c(9, 8, this.tSX) + d.a.a.a.gy(10, this.tSY) + d.a.a.a.gy(11, this.tSZ) + d.a.a.a.gy(12, this.tTa) + d.a.a.a.gy(13, this.tTb) + d.a.a.a.gy(14, this.tTc) + d.a.a.a.gy(15, this.tTd) + d.a.a.a.gy(16, this.tSN) + d.a.a.a.gy(17, this.tTe) + d.a.a.a.gy(18, this.tTf) + d.a.a.a.gy(19, this.tSO) + d.a.a.a.gy(20, this.tTg) + d.a.a.a.gy(21, this.tTh) + d.a.a.a.gy(22, this.tTi) + d.a.a.a.gy(23, this.tTj) + d.a.a.a.gy(24, this.tSP) + d.a.a.a.gy(25, this.tSQ) + d.a.a.a.gy(26, this.tTk) + d.a.a.a.gy(27, this.tTl);
      paramInt = i;
      if (this.tSR != null) {
        paramInt = i + d.a.a.a.gA(28, this.tSR.btq());
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.syZ.clear();
        this.tSX.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx == null) {
          throw new b("Not all required fields were included: BaseResponse");
        }
        if (this.tSM != null) {
          break;
        }
        throw new b("Not all required fields were included: RelayData");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cee localcee = (cee)paramVarArgs[1];
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
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localcee.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcee.syY = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ceb();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ceb)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localcee.syZ.add(localObject1);
            paramInt += 1;
          }
        case 4: 
          localcee.sST = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localcee.sSU = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 6: 
          localcee.tSL = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfj();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfj)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localcee.tSM = ((cfj)localObject1);
            paramInt += 1;
          }
        case 8: 
          localcee.tSW = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfl();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfl)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localcee.tSX.add(localObject1);
            paramInt += 1;
          }
        case 10: 
          localcee.tSY = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          localcee.tSZ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          localcee.tTa = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 13: 
          localcee.tTb = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 14: 
          localcee.tTc = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 15: 
          localcee.tTd = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 16: 
          localcee.tSN = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 17: 
          localcee.tTe = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 18: 
          localcee.tTf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 19: 
          localcee.tSO = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 20: 
          localcee.tTg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 21: 
          localcee.tTh = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 22: 
          localcee.tTi = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 23: 
          localcee.tTj = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 24: 
          localcee.tSP = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 25: 
          localcee.tSQ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 26: 
          localcee.tTk = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 27: 
          localcee.tTl = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localcee.tSR = ((bmk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cee
 * JD-Core Version:    0.7.0.1
 */