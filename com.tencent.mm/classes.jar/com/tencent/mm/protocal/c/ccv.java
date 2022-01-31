package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ccv
  extends blm
{
  public bmk sAc;
  public String sBO;
  public bml sBS;
  public bmk sBT;
  public int ssq;
  public int tHN;
  public String tRK;
  public bml tRL;
  public bml tii;
  
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
      paramVarArgs.gB(2, this.ssq);
      if (this.tRK != null) {
        paramVarArgs.d(3, this.tRK);
      }
      if (this.sBO != null) {
        paramVarArgs.d(4, this.sBO);
      }
      if (this.tii != null)
      {
        paramVarArgs.gD(5, this.tii.btq());
        this.tii.a(paramVarArgs);
      }
      if (this.tRL != null)
      {
        paramVarArgs.gD(6, this.tRL.btq());
        this.tRL.a(paramVarArgs);
      }
      if (this.sBS != null)
      {
        paramVarArgs.gD(7, this.sBS.btq());
        this.sBS.a(paramVarArgs);
      }
      if (this.sBT != null)
      {
        paramVarArgs.gD(8, this.sBT.btq());
        this.sBT.a(paramVarArgs);
      }
      paramVarArgs.gB(9, this.tHN);
      if (this.sAc != null)
      {
        paramVarArgs.gD(10, this.sAc.btq());
        this.sAc.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label1206;
      }
    }
    label1206:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ssq);
      paramInt = i;
      if (this.tRK != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.tRK);
      }
      i = paramInt;
      if (this.sBO != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.sBO);
      }
      paramInt = i;
      if (this.tii != null) {
        paramInt = i + d.a.a.a.gA(5, this.tii.btq());
      }
      i = paramInt;
      if (this.tRL != null) {
        i = paramInt + d.a.a.a.gA(6, this.tRL.btq());
      }
      paramInt = i;
      if (this.sBS != null) {
        paramInt = i + d.a.a.a.gA(7, this.sBS.btq());
      }
      i = paramInt;
      if (this.sBT != null) {
        i = paramInt + d.a.a.a.gA(8, this.sBT.btq());
      }
      i += d.a.a.a.gy(9, this.tHN);
      paramInt = i;
      if (this.sAc != null) {
        paramInt = i + d.a.a.a.gA(10, this.sAc.btq());
      }
      return paramInt;
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
        ccv localccv = (ccv)paramVarArgs[1];
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
            localccv.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localccv.ssq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localccv.tRK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localccv.sBO = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localccv.tii = ((bml)localObject1);
            paramInt += 1;
          }
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localccv.tRL = ((bml)localObject1);
            paramInt += 1;
          }
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localccv.sBS = ((bml)localObject1);
            paramInt += 1;
          }
        case 8: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localccv.sBT = ((bmk)localObject1);
            paramInt += 1;
          }
        case 9: 
          localccv.tHN = ((d.a.a.a.a)localObject1).xpH.oD();
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
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
          localccv.sAc = ((bmk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ccv
 * JD-Core Version:    0.7.0.1
 */