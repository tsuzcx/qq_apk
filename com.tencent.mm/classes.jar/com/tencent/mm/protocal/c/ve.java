package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ve
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public int bxH;
  public String kRN;
  public String kSy;
  public vd sRR;
  public String sRT;
  public String sRU;
  public int sRV;
  public String sRW;
  public String syc;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sRR == null) {
        throw new b("Not all required fields were included: BannerImg");
      }
      if (this.sRR != null)
      {
        paramVarArgs.gD(1, this.sRR.btq());
        this.sRR.a(paramVarArgs);
      }
      if (this.bGw != null) {
        paramVarArgs.d(2, this.bGw);
      }
      if (this.sRT != null) {
        paramVarArgs.d(3, this.sRT);
      }
      paramVarArgs.gB(4, this.bxH);
      if (this.sRU != null) {
        paramVarArgs.d(5, this.sRU);
      }
      paramVarArgs.gB(6, this.sRV);
      if (this.kSy != null) {
        paramVarArgs.d(7, this.kSy);
      }
      if (this.kRN != null) {
        paramVarArgs.d(8, this.kRN);
      }
      if (this.syc != null) {
        paramVarArgs.d(9, this.syc);
      }
      if (this.sRW != null) {
        paramVarArgs.d(10, this.sRW);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sRR == null) {
        break label780;
      }
    }
    label780:
    for (int i = d.a.a.a.gA(1, this.sRR.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bGw != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bGw);
      }
      i = paramInt;
      if (this.sRT != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sRT);
      }
      i += d.a.a.a.gy(4, this.bxH);
      paramInt = i;
      if (this.sRU != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sRU);
      }
      i = paramInt + d.a.a.a.gy(6, this.sRV);
      paramInt = i;
      if (this.kSy != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.kSy);
      }
      i = paramInt;
      if (this.kRN != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.kRN);
      }
      paramInt = i;
      if (this.syc != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.syc);
      }
      i = paramInt;
      if (this.sRW != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.sRW);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sRR != null) {
          break;
        }
        throw new b("Not all required fields were included: BannerImg");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ve localve = (ve)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
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
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new vd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((vd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localve.sRR = ((vd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localve.bGw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localve.sRT = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localve.bxH = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localve.sRU = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localve.sRV = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localve.kSy = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localve.kRN = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localve.syc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localve.sRW = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ve
 * JD-Core Version:    0.7.0.1
 */