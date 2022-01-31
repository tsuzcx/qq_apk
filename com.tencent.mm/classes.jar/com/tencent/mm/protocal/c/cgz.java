package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cgz
  extends com.tencent.mm.bv.a
{
  public cge tVS;
  public int tVT;
  public int tVU;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tVS == null) {
        throw new b("Not all required fields were included: base_response");
      }
      if (this.tVS != null)
      {
        paramVarArgs.gD(1, this.tVS.btq());
        this.tVS.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.tVT);
      paramVarArgs.gB(3, this.tVU);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tVS == null) {
        break label379;
      }
    }
    label379:
    for (paramInt = d.a.a.a.gA(1, this.tVS.btq()) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.tVT) + d.a.a.a.gy(3, this.tVU);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tVS != null) {
          break;
        }
        throw new b("Not all required fields were included: base_response");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cgz localcgz = (cgz)paramVarArgs[1];
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
            localObject1 = new cge();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cge)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcgz.tVS = ((cge)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcgz.tVT = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localcgz.tVU = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cgz
 * JD-Core Version:    0.7.0.1
 */