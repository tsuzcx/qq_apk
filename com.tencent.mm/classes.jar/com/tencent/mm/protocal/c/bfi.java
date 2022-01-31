package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bfi
  extends blm
{
  public int sOy;
  public fu tAa;
  public int tAb;
  public int tzY;
  public int tzZ;
  
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
      paramVarArgs.gB(2, this.tzY);
      paramVarArgs.gB(3, this.tzZ);
      if (this.tAa != null)
      {
        paramVarArgs.gD(4, this.tAa.btq());
        this.tAa.a(paramVarArgs);
      }
      paramVarArgs.gB(5, this.sOy);
      paramVarArgs.gB(6, this.tAb);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tzY) + d.a.a.a.gy(3, this.tzZ);
      paramInt = i;
      if (this.tAa != null) {
        paramInt = i + d.a.a.a.gA(4, this.tAa.btq());
      }
      return paramInt + d.a.a.a.gy(5, this.sOy) + d.a.a.a.gy(6, this.tAb);
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
        bfi localbfi = (bfi)paramVarArgs[1];
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
            localbfi.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbfi.tzY = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbfi.tzZ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fu();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fu)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbfi.tAa = ((fu)localObject1);
            paramInt += 1;
          }
        case 5: 
          localbfi.sOy = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localbfi.tAb = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bfi
 * JD-Core Version:    0.7.0.1
 */