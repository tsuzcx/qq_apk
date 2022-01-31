package com.tencent.mm.plugin.order.model;

import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bv.a
{
  public String kVn;
  public String mPI;
  public double mPJ;
  public String mPK;
  public int mPL;
  public String mPM;
  public int mPN;
  public String mPO;
  public int mPP;
  public int mPQ;
  public String mPR;
  public String mPS;
  public String mPT;
  public String mPU;
  public String mPV;
  public int mPW;
  public LinkedList<k> mPX = new LinkedList();
  public String mPY;
  public String mPZ;
  public double mQa;
  public String mQb;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.mPI != null) {
        paramVarArgs.d(1, this.mPI);
      }
      paramVarArgs.b(2, this.mPJ);
      if (this.mPK != null) {
        paramVarArgs.d(3, this.mPK);
      }
      paramVarArgs.gB(4, this.mPL);
      if (this.mPM != null) {
        paramVarArgs.d(5, this.mPM);
      }
      paramVarArgs.gB(6, this.mPN);
      if (this.mPO != null) {
        paramVarArgs.d(7, this.mPO);
      }
      paramVarArgs.gB(8, this.mPP);
      paramVarArgs.gB(9, this.mPQ);
      if (this.mPR != null) {
        paramVarArgs.d(10, this.mPR);
      }
      if (this.kVn != null) {
        paramVarArgs.d(11, this.kVn);
      }
      if (this.mPS != null) {
        paramVarArgs.d(12, this.mPS);
      }
      if (this.mPT != null) {
        paramVarArgs.d(13, this.mPT);
      }
      if (this.mPU != null) {
        paramVarArgs.d(14, this.mPU);
      }
      if (this.mPV != null) {
        paramVarArgs.d(15, this.mPV);
      }
      paramVarArgs.gB(16, this.mPW);
      paramVarArgs.d(17, 8, this.mPX);
      if (this.mPY != null) {
        paramVarArgs.d(18, this.mPY);
      }
      if (this.mPZ != null) {
        paramVarArgs.d(19, this.mPZ);
      }
      paramVarArgs.b(20, this.mQa);
      if (this.mQb != null) {
        paramVarArgs.d(21, this.mQb);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.mPI == null) {
        break label1273;
      }
    }
    label1273:
    for (paramInt = d.a.a.b.b.a.e(1, this.mPI) + 0;; paramInt = 0)
    {
      int i = paramInt + (d.a.a.b.b.a.dQ(2) + 8);
      paramInt = i;
      if (this.mPK != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.mPK);
      }
      i = paramInt + d.a.a.a.gy(4, this.mPL);
      paramInt = i;
      if (this.mPM != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.mPM);
      }
      i = paramInt + d.a.a.a.gy(6, this.mPN);
      paramInt = i;
      if (this.mPO != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.mPO);
      }
      i = paramInt + d.a.a.a.gy(8, this.mPP) + d.a.a.a.gy(9, this.mPQ);
      paramInt = i;
      if (this.mPR != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.mPR);
      }
      i = paramInt;
      if (this.kVn != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.kVn);
      }
      paramInt = i;
      if (this.mPS != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.mPS);
      }
      i = paramInt;
      if (this.mPT != null) {
        i = paramInt + d.a.a.b.b.a.e(13, this.mPT);
      }
      paramInt = i;
      if (this.mPU != null) {
        paramInt = i + d.a.a.b.b.a.e(14, this.mPU);
      }
      i = paramInt;
      if (this.mPV != null) {
        i = paramInt + d.a.a.b.b.a.e(15, this.mPV);
      }
      i = i + d.a.a.a.gy(16, this.mPW) + d.a.a.a.c(17, 8, this.mPX);
      paramInt = i;
      if (this.mPY != null) {
        paramInt = i + d.a.a.b.b.a.e(18, this.mPY);
      }
      i = paramInt;
      if (this.mPZ != null) {
        i = paramInt + d.a.a.b.b.a.e(19, this.mPZ);
      }
      i += d.a.a.b.b.a.dQ(20) + 8;
      paramInt = i;
      if (this.mQb != null) {
        paramInt = i + d.a.a.b.b.a.e(21, this.mQb);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.mPX.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        i locali = (i)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          locali.mPI = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          locali.mPJ = ((d.a.a.a.a)localObject1).xpH.readDouble();
          return 0;
        case 3: 
          locali.mPK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          locali.mPL = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          locali.mPM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          locali.mPN = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          locali.mPO = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          locali.mPP = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          locali.mPQ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          locali.mPR = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          locali.kVn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          locali.mPS = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          locali.mPT = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          locali.mPU = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 15: 
          locali.mPV = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 16: 
          locali.mPW = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 17: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new k();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((k)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            locali.mPX.add(localObject1);
            paramInt += 1;
          }
        case 18: 
          locali.mPY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 19: 
          locali.mPZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 20: 
          locali.mQa = ((d.a.a.a.a)localObject1).xpH.readDouble();
          return 0;
        }
        locali.mQb = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.i
 * JD-Core Version:    0.7.0.1
 */