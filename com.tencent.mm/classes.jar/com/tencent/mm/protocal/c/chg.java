package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class chg
  extends com.tencent.mm.bv.a
{
  public cge tVS;
  public cgx tWc;
  
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
      if (this.tWc != null)
      {
        paramVarArgs.gD(2, this.tWc.btq());
        this.tWc.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tVS == null) {
        break label454;
      }
    }
    label454:
    for (paramInt = d.a.a.a.gA(1, this.tVS.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tWc != null) {
        i = paramInt + d.a.a.a.gA(2, this.tWc.btq());
      }
      return i;
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
        chg localchg = (chg)paramVarArgs[1];
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
            localObject1 = new cge();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cge)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localchg.tVS = ((cge)localObject1);
            paramInt += 1;
          }
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cgx();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cgx)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localchg.tWc = ((cgx)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.chg
 * JD-Core Version:    0.7.0.1
 */