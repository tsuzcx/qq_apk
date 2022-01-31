package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class hq
  extends blm
{
  public int bUx;
  public String qyu;
  public String sAT;
  public String sAU;
  public String sAV;
  
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
      if (this.sAT != null) {
        paramVarArgs.d(2, this.sAT);
      }
      if (this.sAU != null) {
        paramVarArgs.d(3, this.sAU);
      }
      if (this.qyu != null) {
        paramVarArgs.d(4, this.qyu);
      }
      if (this.sAV != null) {
        paramVarArgs.d(5, this.sAV);
      }
      paramVarArgs.gB(7, this.bUx);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label536;
      }
    }
    label536:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sAT != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sAT);
      }
      i = paramInt;
      if (this.sAU != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sAU);
      }
      paramInt = i;
      if (this.qyu != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.qyu);
      }
      i = paramInt;
      if (this.sAV != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sAV);
      }
      return i + d.a.a.a.gy(7, this.bUx);
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
        hq localhq = (hq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 6: 
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localhq.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localhq.sAT = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localhq.sAU = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localhq.qyu = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localhq.sAV = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localhq.bUx = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.hq
 * JD-Core Version:    0.7.0.1
 */