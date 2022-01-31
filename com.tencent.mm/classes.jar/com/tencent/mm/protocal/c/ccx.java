package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ccx
  extends blm
{
  public int mPQ;
  public String syc;
  public String tAh;
  public String tAi;
  public int tAj;
  public String tAk;
  public bmk tRM;
  public int tRN;
  public int tRO;
  public String tRP;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tRM == null) {
        throw new b("Not all required fields were included: Receipt");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.tRM != null)
      {
        paramVarArgs.gD(2, this.tRM.btq());
        this.tRM.a(paramVarArgs);
      }
      if (this.syc != null) {
        paramVarArgs.d(3, this.syc);
      }
      paramVarArgs.gB(4, this.tRN);
      paramVarArgs.gB(5, this.mPQ);
      if (this.tAh != null) {
        paramVarArgs.d(6, this.tAh);
      }
      if (this.tAi != null) {
        paramVarArgs.d(7, this.tAi);
      }
      if (this.tAk != null) {
        paramVarArgs.d(8, this.tAk);
      }
      paramVarArgs.gB(9, this.tRO);
      if (this.tRP != null) {
        paramVarArgs.d(10, this.tRP);
      }
      paramVarArgs.gB(11, this.tAj);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label893;
      }
    }
    label893:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tRM != null) {
        paramInt = i + d.a.a.a.gA(2, this.tRM.btq());
      }
      i = paramInt;
      if (this.syc != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.syc);
      }
      i = i + d.a.a.a.gy(4, this.tRN) + d.a.a.a.gy(5, this.mPQ);
      paramInt = i;
      if (this.tAh != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.tAh);
      }
      i = paramInt;
      if (this.tAi != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.tAi);
      }
      paramInt = i;
      if (this.tAk != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.tAk);
      }
      i = paramInt + d.a.a.a.gy(9, this.tRO);
      paramInt = i;
      if (this.tRP != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.tRP);
      }
      return paramInt + d.a.a.a.gy(11, this.tAj);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tRM != null) {
          break;
        }
        throw new b("Not all required fields were included: Receipt");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ccx localccx = (ccx)paramVarArgs[1];
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
            localccx.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localccx.tRM = ((bmk)localObject1);
            paramInt += 1;
          }
        case 3: 
          localccx.syc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localccx.tRN = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localccx.mPQ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localccx.tAh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localccx.tAi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localccx.tAk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localccx.tRO = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          localccx.tRP = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localccx.tAj = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ccx
 * JD-Core Version:    0.7.0.1
 */