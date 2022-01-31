package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class avy
  extends blm
{
  public int kSW;
  public String kTZ;
  public String mQp;
  public int sGG;
  public int sGH;
  public int tfc;
  public int trA;
  public int trB;
  public bmk trC;
  public int trD;
  public int trE;
  public int trF;
  public int trG;
  public int trH;
  public String trI;
  public String trJ;
  public String trt;
  public String tru;
  public String trv;
  public int trw;
  public bmk trx;
  public int jdField_try;
  public int trz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.trx == null) {
        throw new b("Not all required fields were included: DataBuffer");
      }
      if (this.trC == null) {
        throw new b("Not all required fields were included: ThumbData");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.trt != null) {
        paramVarArgs.d(2, this.trt);
      }
      if (this.tru != null) {
        paramVarArgs.d(3, this.tru);
      }
      if (this.trv != null) {
        paramVarArgs.d(4, this.trv);
      }
      paramVarArgs.gB(5, this.kSW);
      paramVarArgs.gB(6, this.trw);
      if (this.trx != null)
      {
        paramVarArgs.gD(7, this.trx.btq());
        this.trx.a(paramVarArgs);
      }
      paramVarArgs.gB(8, this.jdField_try);
      paramVarArgs.gB(9, this.trz);
      paramVarArgs.gB(10, this.trA);
      paramVarArgs.gB(11, this.trB);
      if (this.trC != null)
      {
        paramVarArgs.gD(12, this.trC.btq());
        this.trC.a(paramVarArgs);
      }
      paramVarArgs.gB(13, this.trD);
      paramVarArgs.gB(14, this.trE);
      paramVarArgs.gB(15, this.trF);
      paramVarArgs.gB(16, this.trG);
      paramVarArgs.gB(17, this.tfc);
      paramVarArgs.gB(18, this.trH);
      if (this.kTZ != null) {
        paramVarArgs.d(19, this.kTZ);
      }
      if (this.mQp != null) {
        paramVarArgs.d(20, this.mQp);
      }
      paramVarArgs.gB(21, this.sGH);
      paramVarArgs.gB(22, this.sGG);
      if (this.trI != null) {
        paramVarArgs.d(23, this.trI);
      }
      if (this.trJ != null) {
        paramVarArgs.d(24, this.trJ);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label1582;
      }
    }
    label1582:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.trt != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.trt);
      }
      i = paramInt;
      if (this.tru != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tru);
      }
      paramInt = i;
      if (this.trv != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.trv);
      }
      i = paramInt + d.a.a.a.gy(5, this.kSW) + d.a.a.a.gy(6, this.trw);
      paramInt = i;
      if (this.trx != null) {
        paramInt = i + d.a.a.a.gA(7, this.trx.btq());
      }
      i = paramInt + d.a.a.a.gy(8, this.jdField_try) + d.a.a.a.gy(9, this.trz) + d.a.a.a.gy(10, this.trA) + d.a.a.a.gy(11, this.trB);
      paramInt = i;
      if (this.trC != null) {
        paramInt = i + d.a.a.a.gA(12, this.trC.btq());
      }
      i = paramInt + d.a.a.a.gy(13, this.trD) + d.a.a.a.gy(14, this.trE) + d.a.a.a.gy(15, this.trF) + d.a.a.a.gy(16, this.trG) + d.a.a.a.gy(17, this.tfc) + d.a.a.a.gy(18, this.trH);
      paramInt = i;
      if (this.kTZ != null) {
        paramInt = i + d.a.a.b.b.a.e(19, this.kTZ);
      }
      i = paramInt;
      if (this.mQp != null) {
        i = paramInt + d.a.a.b.b.a.e(20, this.mQp);
      }
      i = i + d.a.a.a.gy(21, this.sGH) + d.a.a.a.gy(22, this.sGG);
      paramInt = i;
      if (this.trI != null) {
        paramInt = i + d.a.a.b.b.a.e(23, this.trI);
      }
      i = paramInt;
      if (this.trJ != null) {
        i = paramInt + d.a.a.b.b.a.e(24, this.trJ);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.trx == null) {
          throw new b("Not all required fields were included: DataBuffer");
        }
        if (this.trC != null) {
          break;
        }
        throw new b("Not all required fields were included: ThumbData");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        avy localavy = (avy)paramVarArgs[1];
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
            localavy.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localavy.trt = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localavy.tru = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localavy.trv = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localavy.kSW = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localavy.trw = ((d.a.a.a.a)localObject1).xpH.oD();
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
            localavy.trx = ((bmk)localObject1);
            paramInt += 1;
          }
        case 8: 
          localavy.jdField_try = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localavy.trz = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          localavy.trA = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          localavy.trB = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localavy.trC = ((bmk)localObject1);
            paramInt += 1;
          }
        case 13: 
          localavy.trD = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 14: 
          localavy.trE = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 15: 
          localavy.trF = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 16: 
          localavy.trG = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 17: 
          localavy.tfc = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 18: 
          localavy.trH = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 19: 
          localavy.kTZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 20: 
          localavy.mQp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 21: 
          localavy.sGH = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 22: 
          localavy.sGG = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 23: 
          localavy.trI = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localavy.trJ = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.avy
 * JD-Core Version:    0.7.0.1
 */