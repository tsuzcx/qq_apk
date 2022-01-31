package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cnb
  extends com.tencent.mm.bv.a
{
  public String jnU;
  public int sCy;
  public int tFl;
  public int tFn;
  public cmy tZH;
  public int tZS;
  public boolean tZT;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tZH != null)
      {
        paramVarArgs.gD(1, this.tZH.btq());
        this.tZH.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.tZS);
      paramVarArgs.gB(3, this.tFl);
      paramVarArgs.gB(4, this.tFn);
      paramVarArgs.aA(5, this.tZT);
      paramVarArgs.gB(6, this.sCy);
      if (this.jnU != null) {
        paramVarArgs.d(7, this.jnU);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tZH == null) {
        break label512;
      }
    }
    label512:
    for (paramInt = d.a.a.a.gA(1, this.tZH.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tZS) + d.a.a.a.gy(3, this.tFl) + d.a.a.a.gy(4, this.tFn) + (d.a.a.b.b.a.dQ(5) + 1) + d.a.a.a.gy(6, this.sCy);
      paramInt = i;
      if (this.jnU != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.jnU);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
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
        cnb localcnb = (cnb)paramVarArgs[1];
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
            localObject1 = new cmy();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cmy)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcnb.tZH = ((cmy)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcnb.tZS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localcnb.tFl = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localcnb.tFn = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localcnb.tZT = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 6: 
          localcnb.sCy = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localcnb.jnU = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cnb
 * JD-Core Version:    0.7.0.1
 */