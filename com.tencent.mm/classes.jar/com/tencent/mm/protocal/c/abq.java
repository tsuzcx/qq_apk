package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class abq
  extends blm
{
  public String appId;
  public String bIK;
  public String kpI;
  public String kpJ;
  public String kpK;
  public String sign;
  public String sst;
  public int ssu;
  public cy taU;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.appId != null) {
        paramVarArgs.d(2, this.appId);
      }
      if (this.kpI != null) {
        paramVarArgs.d(3, this.kpI);
      }
      if (this.kpJ != null) {
        paramVarArgs.d(4, this.kpJ);
      }
      if (this.kpK != null) {
        paramVarArgs.d(5, this.kpK);
      }
      if (this.bIK != null) {
        paramVarArgs.d(6, this.bIK);
      }
      if (this.sign != null) {
        paramVarArgs.d(7, this.sign);
      }
      if (this.taU != null)
      {
        paramVarArgs.gD(8, this.taU.btq());
        this.taU.a(paramVarArgs);
      }
      if (this.sst != null) {
        paramVarArgs.d(9, this.sst);
      }
      paramVarArgs.gB(10, this.ssu);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label850;
      }
    }
    label850:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.appId);
      }
      i = paramInt;
      if (this.kpI != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kpI);
      }
      paramInt = i;
      if (this.kpJ != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kpJ);
      }
      i = paramInt;
      if (this.kpK != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.kpK);
      }
      paramInt = i;
      if (this.bIK != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.bIK);
      }
      i = paramInt;
      if (this.sign != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.sign);
      }
      paramInt = i;
      if (this.taU != null) {
        paramInt = i + d.a.a.a.gA(8, this.taU.btq());
      }
      i = paramInt;
      if (this.sst != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.sst);
      }
      return i + d.a.a.a.gy(10, this.ssu);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        abq localabq = (abq)paramVarArgs[1];
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
            localabq.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localabq.appId = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localabq.kpI = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localabq.kpJ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localabq.kpK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localabq.bIK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localabq.sign = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cy();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cy)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localabq.taU = ((cy)localObject1);
            paramInt += 1;
          }
        case 9: 
          localabq.sst = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localabq.ssu = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.abq
 * JD-Core Version:    0.7.0.1
 */