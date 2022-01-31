package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bvg
  extends com.tencent.mm.bv.a
{
  public int tLA;
  public ceb tLB;
  public int tLW;
  public int tLX;
  public int tLY;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tLB == null) {
        throw new b("Not all required fields were included: Addr");
      }
      if (this.tLB != null)
      {
        paramVarArgs.gD(1, this.tLB.btq());
        this.tLB.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.tLA);
      paramVarArgs.gB(3, this.tLW);
      paramVarArgs.gB(4, this.tLX);
      paramVarArgs.gB(5, this.tLY);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tLB == null) {
        break label453;
      }
    }
    label453:
    for (paramInt = d.a.a.a.gA(1, this.tLB.btq()) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.tLA) + d.a.a.a.gy(3, this.tLW) + d.a.a.a.gy(4, this.tLX) + d.a.a.a.gy(5, this.tLY);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tLB != null) {
          break;
        }
        throw new b("Not all required fields were included: Addr");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bvg localbvg = (bvg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          int i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ceb();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ceb)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbvg.tLB = ((ceb)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbvg.tLA = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbvg.tLW = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localbvg.tLX = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localbvg.tLY = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bvg
 * JD-Core Version:    0.7.0.1
 */