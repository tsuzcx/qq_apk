package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class axn
  extends com.tencent.mm.bv.a
{
  public bml sQs;
  public int ttD;
  public int ttT;
  public int ttU;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sQs == null) {
        throw new b("Not all required fields were included: UserName");
      }
      if (this.sQs != null)
      {
        paramVarArgs.gD(1, this.sQs.btq());
        this.sQs.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.ttT);
      paramVarArgs.gB(3, this.ttU);
      paramVarArgs.gB(4, this.ttD);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sQs == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = d.a.a.a.gA(1, this.sQs.btq()) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.ttT) + d.a.a.a.gy(3, this.ttU) + d.a.a.a.gy(4, this.ttD);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sQs != null) {
          break;
        }
        throw new b("Not all required fields were included: UserName");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        axn localaxn = (axn)paramVarArgs[1];
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
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localaxn.sQs = ((bml)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaxn.ttT = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localaxn.ttU = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localaxn.ttD = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.axn
 * JD-Core Version:    0.7.0.1
 */