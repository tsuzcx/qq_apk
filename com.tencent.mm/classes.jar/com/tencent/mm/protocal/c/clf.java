package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class clf
  extends com.tencent.mm.bv.a
{
  public String euK;
  public clc tYx;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.euK == null) {
        throw new b("Not all required fields were included: AppId");
      }
      if (this.tYx == null) {
        throw new b("Not all required fields were included: PkgConfig");
      }
      if (this.euK != null) {
        paramVarArgs.d(1, this.euK);
      }
      if (this.tYx != null)
      {
        paramVarArgs.gD(2, this.tYx.btq());
        this.tYx.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.euK == null) {
        break label396;
      }
    }
    label396:
    for (paramInt = d.a.a.b.b.a.e(1, this.euK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tYx != null) {
        i = paramInt + d.a.a.a.gA(2, this.tYx.btq());
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
        if (this.euK == null) {
          throw new b("Not all required fields were included: AppId");
        }
        if (this.tYx != null) {
          break;
        }
        throw new b("Not all required fields were included: PkgConfig");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        clf localclf = (clf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localclf.euK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new clc();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((clc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localclf.tYx = ((clc)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.clf
 * JD-Core Version:    0.7.0.1
 */