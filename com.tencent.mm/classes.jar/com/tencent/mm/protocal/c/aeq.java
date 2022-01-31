package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class aeq
  extends bly
{
  public String ffi;
  public String ffj;
  public String ffq;
  
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
      if (this.ffq != null) {
        paramVarArgs.d(2, this.ffq);
      }
      if (this.ffi != null) {
        paramVarArgs.d(3, this.ffi);
      }
      if (this.ffj != null) {
        paramVarArgs.d(4, this.ffj);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label470;
      }
    }
    label470:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ffq != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.ffq);
      }
      i = paramInt;
      if (this.ffi != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.ffi);
      }
      paramInt = i;
      if (this.ffj != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.ffj);
      }
      return paramInt;
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
        aeq localaeq = (aeq)paramVarArgs[1];
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
            localaeq.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaeq.ffq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localaeq.ffi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localaeq.ffj = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aeq
 * JD-Core Version:    0.7.0.1
 */