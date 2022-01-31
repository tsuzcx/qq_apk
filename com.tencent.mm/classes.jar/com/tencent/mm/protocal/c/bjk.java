package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bjk
  extends com.tencent.mm.bv.a
{
  public buc tDk;
  public bml tDl;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tDk == null) {
        throw new b("Not all required fields were included: SnsRecommendObject");
      }
      if (this.tDk != null)
      {
        paramVarArgs.gD(1, this.tDk.btq());
        this.tDk.a(paramVarArgs);
      }
      if (this.tDl != null)
      {
        paramVarArgs.gD(2, this.tDl.btq());
        this.tDl.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tDk == null) {
        break label454;
      }
    }
    label454:
    for (paramInt = d.a.a.a.gA(1, this.tDk.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tDl != null) {
        i = paramInt + d.a.a.a.gA(2, this.tDl.btq());
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
        if (this.tDk != null) {
          break;
        }
        throw new b("Not all required fields were included: SnsRecommendObject");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bjk localbjk = (bjk)paramVarArgs[1];
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
            localObject1 = new buc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((buc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbjk.tDk = ((buc)localObject1);
            paramInt += 1;
          }
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bml();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbjk.tDl = ((bml)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bjk
 * JD-Core Version:    0.7.0.1
 */