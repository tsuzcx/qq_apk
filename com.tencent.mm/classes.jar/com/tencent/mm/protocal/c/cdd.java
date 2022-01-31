package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class cdd
  extends blm
{
  public int syV;
  public int tRY;
  public LinkedList<cdb> tRZ = new LinkedList();
  public int tSa;
  public LinkedList<Integer> tSb = new LinkedList();
  public int tSc;
  public LinkedList<cdc> tSd = new LinkedList();
  public String tgV;
  public bmk tpt;
  
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
      paramVarArgs.gB(2, this.syV);
      paramVarArgs.gB(3, this.tRY);
      paramVarArgs.d(4, 8, this.tRZ);
      if (this.tgV != null) {
        paramVarArgs.d(5, this.tgV);
      }
      paramVarArgs.gB(6, this.tSa);
      paramVarArgs.d(7, this.tSb);
      paramVarArgs.gB(8, this.tSc);
      paramVarArgs.d(9, 8, this.tSd);
      if (this.tpt != null)
      {
        paramVarArgs.gD(10, this.tpt.btq());
        this.tpt.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label955;
      }
    }
    label955:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.syV) + d.a.a.a.gy(3, this.tRY) + d.a.a.a.c(4, 8, this.tRZ);
      paramInt = i;
      if (this.tgV != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tgV);
      }
      i = paramInt + d.a.a.a.gy(6, this.tSa) + d.a.a.a.c(7, this.tSb) + d.a.a.a.gy(8, this.tSc) + d.a.a.a.c(9, 8, this.tSd);
      paramInt = i;
      if (this.tpt != null) {
        paramInt = i + d.a.a.a.gA(10, this.tpt.btq());
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tRZ.clear();
        this.tSb.clear();
        this.tSd.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        cdd localcdd = (cdd)paramVarArgs[1];
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
            localcdd.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcdd.syV = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localcdd.tRY = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdb();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdb)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcdd.tRZ.add(localObject1);
            paramInt += 1;
          }
        case 5: 
          localcdd.tgV = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localcdd.tSa = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localcdd.tSb = new d.a.a.a.a(((d.a.a.a.a)localObject1).cUs().oY, unknownTagHandler).cUp();
          return 0;
        case 8: 
          localcdd.tSc = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcdd.tSd.add(localObject1);
            paramInt += 1;
          }
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
          localcdd.tpt = ((bmk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cdd
 * JD-Core Version:    0.7.0.1
 */