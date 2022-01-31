package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cfb
  extends blm
{
  public int sST;
  public long sSU;
  public bmk szp;
  public int tAN;
  public int tTI;
  public int tTJ;
  public int tTK;
  public int tTL;
  public int tTM;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.szp == null) {
        throw new b("Not all required fields were included: Buffer");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.sST);
      paramVarArgs.Y(3, this.sSU);
      paramVarArgs.gB(4, this.tAN);
      paramVarArgs.gB(5, this.tTI);
      paramVarArgs.gB(6, this.tTJ);
      paramVarArgs.gB(7, this.tTK);
      paramVarArgs.gB(8, this.tTL);
      paramVarArgs.gB(9, this.tTM);
      if (this.szp != null)
      {
        paramVarArgs.gD(10, this.szp.btq());
        this.szp.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label762;
      }
    }
    label762:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.sST) + d.a.a.a.X(3, this.sSU) + d.a.a.a.gy(4, this.tAN) + d.a.a.a.gy(5, this.tTI) + d.a.a.a.gy(6, this.tTJ) + d.a.a.a.gy(7, this.tTK) + d.a.a.a.gy(8, this.tTL) + d.a.a.a.gy(9, this.tTM);
      paramInt = i;
      if (this.szp != null) {
        paramInt = i + d.a.a.a.gA(10, this.szp.btq());
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
        if (this.szp != null) {
          break;
        }
        throw new b("Not all required fields were included: Buffer");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cfb localcfb = (cfb)paramVarArgs[1];
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
            localcfb.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcfb.sST = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localcfb.sSU = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 4: 
          localcfb.tAN = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localcfb.tTI = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localcfb.tTJ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localcfb.tTK = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localcfb.tTL = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localcfb.tTM = ((d.a.a.a.a)localObject1).xpH.oD();
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
          localcfb.szp = ((bmk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cfb
 * JD-Core Version:    0.7.0.1
 */