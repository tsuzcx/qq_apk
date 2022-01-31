package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class brf
  extends blm
{
  public int euw;
  public bmk ndi;
  public float sGK;
  public int sNU;
  public int swP;
  public int tHO;
  public float tHP;
  public float tHQ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ndi == null) {
        throw new b("Not all required fields were included: Data");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.ndi != null)
      {
        paramVarArgs.gD(2, this.ndi.btq());
        this.ndi.a(paramVarArgs);
      }
      paramVarArgs.gB(3, this.tHO);
      paramVarArgs.gB(4, this.euw);
      paramVarArgs.m(5, this.tHP);
      paramVarArgs.gB(6, this.sNU);
      paramVarArgs.gB(7, this.swP);
      paramVarArgs.m(8, this.tHQ);
      paramVarArgs.m(9, this.sGK);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label715;
      }
    }
    label715:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ndi != null) {
        i = paramInt + d.a.a.a.gA(2, this.ndi.btq());
      }
      return i + d.a.a.a.gy(3, this.tHO) + d.a.a.a.gy(4, this.euw) + (d.a.a.b.b.a.dQ(5) + 4) + d.a.a.a.gy(6, this.sNU) + d.a.a.a.gy(7, this.swP) + (d.a.a.b.b.a.dQ(8) + 4) + (d.a.a.b.b.a.dQ(9) + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.ndi != null) {
          break;
        }
        throw new b("Not all required fields were included: Data");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        brf localbrf = (brf)paramVarArgs[1];
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
            localbrf.tEX = ((gc)localObject1);
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
            localbrf.ndi = ((bmk)localObject1);
            paramInt += 1;
          }
        case 3: 
          localbrf.tHO = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localbrf.euw = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localbrf.tHP = ((d.a.a.a.a)localObject1).xpH.readFloat();
          return 0;
        case 6: 
          localbrf.sNU = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localbrf.swP = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localbrf.tHQ = ((d.a.a.a.a)localObject1).xpH.readFloat();
          return 0;
        }
        localbrf.sGK = ((d.a.a.a.a)localObject1).xpH.readFloat();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.brf
 * JD-Core Version:    0.7.0.1
 */