package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class afw
  extends bly
{
  public long hQp;
  public long svD;
  public int tdI;
  public int tdJ;
  public int tdK;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.Y(2, this.svD);
      paramVarArgs.Y(3, this.hQp);
      paramVarArgs.gB(4, this.tdI);
      paramVarArgs.gB(5, this.tdJ);
      paramVarArgs.gB(6, this.tdK);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label492;
      }
    }
    label492:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.X(2, this.svD) + d.a.a.a.X(3, this.hQp) + d.a.a.a.gy(4, this.tdI) + d.a.a.a.gy(5, this.tdJ) + d.a.a.a.gy(6, this.tdK);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx != null) {
          break;
        }
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        afw localafw = (afw)paramVarArgs[1];
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
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localafw.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localafw.svD = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 3: 
          localafw.hQp = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 4: 
          localafw.tdI = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localafw.tdJ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localafw.tdK = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.afw
 * JD-Core Version:    0.7.0.1
 */