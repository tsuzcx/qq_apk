package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class xm
  extends bly
{
  public String sUj;
  public boolean sUk = true;
  
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
      if (this.sUj != null) {
        paramVarArgs.d(2, this.sUj);
      }
      paramVarArgs.aA(3, this.sUk);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label392;
      }
    }
    label392:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sUj != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.sUj);
      }
      return i + (d.a.a.b.b.a.dQ(3) + 1);
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
        xm localxm = (xm)paramVarArgs[1];
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
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localxm.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localxm.sUj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localxm.sUk = ((d.a.a.a.a)localObject1).cUr();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.xm
 * JD-Core Version:    0.7.0.1
 */