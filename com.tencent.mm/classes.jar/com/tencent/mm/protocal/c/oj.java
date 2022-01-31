package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class oj
  extends bly
{
  public String ffk;
  public int sLP;
  public String sLQ;
  public String sLR;
  
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
      if (this.ffk != null) {
        paramVarArgs.d(2, this.ffk);
      }
      paramVarArgs.gB(3, this.sLP);
      if (this.sLQ != null) {
        paramVarArgs.d(4, this.sLQ);
      }
      if (this.sLR != null) {
        paramVarArgs.d(5, this.sLR);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label509;
      }
    }
    label509:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ffk != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.ffk);
      }
      i += d.a.a.a.gy(3, this.sLP);
      paramInt = i;
      if (this.sLQ != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sLQ);
      }
      i = paramInt;
      if (this.sLR != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sLR);
      }
      return i;
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
        oj localoj = (oj)paramVarArgs[1];
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
            localoj.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localoj.ffk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localoj.sLP = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localoj.sLQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localoj.sLR = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.oj
 * JD-Core Version:    0.7.0.1
 */