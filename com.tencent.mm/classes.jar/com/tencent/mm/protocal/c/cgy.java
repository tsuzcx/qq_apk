package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cgy
  extends com.tencent.mm.bv.a
{
  public LinkedList<cgl> tVF = new LinkedList();
  public cgd tVQ;
  public int tVR;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tVQ == null) {
        throw new b("Not all required fields were included: base_request");
      }
      if (this.tVQ != null)
      {
        paramVarArgs.gD(1, this.tVQ.btq());
        this.tVQ.a(paramVarArgs);
      }
      paramVarArgs.d(2, 8, this.tVF);
      paramVarArgs.gB(3, this.tVR);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tVQ == null) {
        break label473;
      }
    }
    label473:
    for (paramInt = d.a.a.a.gA(1, this.tVQ.btq()) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.c(2, 8, this.tVF) + d.a.a.a.gy(3, this.tVR);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tVF.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tVQ != null) {
          break;
        }
        throw new b("Not all required fields were included: base_request");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cgy localcgy = (cgy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        int i;
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
            localObject1 = new cgd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcgy.tVQ = ((cgd)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgl();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgl)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcgy.tVF.add(localObject1);
            paramInt += 1;
          }
        }
        localcgy.tVR = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cgy
 * JD-Core Version:    0.7.0.1
 */