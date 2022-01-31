package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class atn
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public int hQR;
  public String mDU;
  public float mDV;
  public int mDW;
  public LinkedList<Integer> mDX = new LinkedList();
  public int mDY;
  public LinkedList<bml> mDZ = new LinkedList();
  public float mEa;
  public String mEb;
  public bmk mEc;
  public String tpo;
  public bmk tpp;
  public int tpq;
  public int tpr;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.mDU != null) {
        paramVarArgs.d(1, this.mDU);
      }
      if (this.bGw != null) {
        paramVarArgs.d(2, this.bGw);
      }
      paramVarArgs.m(3, this.mDV);
      paramVarArgs.gB(4, this.mDW);
      paramVarArgs.d(5, this.mDX);
      paramVarArgs.gB(6, this.mDY);
      paramVarArgs.d(7, 8, this.mDZ);
      paramVarArgs.m(8, this.mEa);
      if (this.mEb != null) {
        paramVarArgs.d(9, this.mEb);
      }
      paramVarArgs.gB(10, this.hQR);
      if (this.mEc != null)
      {
        paramVarArgs.gD(11, this.mEc.btq());
        this.mEc.a(paramVarArgs);
      }
      if (this.tpo != null) {
        paramVarArgs.d(12, this.tpo);
      }
      if (this.tpp != null)
      {
        paramVarArgs.gD(13, this.tpp.btq());
        this.tpp.a(paramVarArgs);
      }
      paramVarArgs.gB(14, this.tpq);
      paramVarArgs.gB(15, this.tpr);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mDU == null) {
        break label1108;
      }
    }
    label1108:
    for (paramInt = d.a.a.b.b.a.e(1, this.mDU) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.bGw != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.bGw);
      }
      i = i + (d.a.a.b.b.a.dQ(3) + 4) + d.a.a.a.gy(4, this.mDW) + d.a.a.a.c(5, this.mDX) + d.a.a.a.gy(6, this.mDY) + d.a.a.a.c(7, 8, this.mDZ) + (d.a.a.b.b.a.dQ(8) + 4);
      paramInt = i;
      if (this.mEb != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.mEb);
      }
      i = paramInt + d.a.a.a.gy(10, this.hQR);
      paramInt = i;
      if (this.mEc != null) {
        paramInt = i + d.a.a.a.gA(11, this.mEc.btq());
      }
      i = paramInt;
      if (this.tpo != null) {
        i = paramInt + d.a.a.b.b.a.e(12, this.tpo);
      }
      paramInt = i;
      if (this.tpp != null) {
        paramInt = i + d.a.a.a.gA(13, this.tpp.btq());
      }
      return paramInt + d.a.a.a.gy(14, this.tpq) + d.a.a.a.gy(15, this.tpr);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.mDX.clear();
        this.mDZ.clear();
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
        atn localatn = (atn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localatn.mDU = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localatn.bGw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localatn.mDV = ((d.a.a.a.a)localObject1).xpH.readFloat();
          return 0;
        case 4: 
          localatn.mDW = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localatn.mDX = new d.a.a.a.a(((d.a.a.a.a)localObject1).cUs().oY, unknownTagHandler).cUp();
          return 0;
        case 6: 
          localatn.mDY = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localatn.mDZ.add(localObject1);
            paramInt += 1;
          }
        case 8: 
          localatn.mEa = ((d.a.a.a.a)localObject1).xpH.readFloat();
          return 0;
        case 9: 
          localatn.mEb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localatn.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localatn.mEc = ((bmk)localObject1);
            paramInt += 1;
          }
        case 12: 
          localatn.tpo = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localatn.tpp = ((bmk)localObject1);
            paramInt += 1;
          }
        case 14: 
          localatn.tpq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localatn.tpr = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.atn
 * JD-Core Version:    0.7.0.1
 */