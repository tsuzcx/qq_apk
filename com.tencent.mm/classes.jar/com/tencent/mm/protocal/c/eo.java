package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class eo
  extends bly
{
  public String kRX;
  public String sye;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.sye == null) {
        throw new b("Not all required fields were included: ReqKey");
      }
      if (this.kRX == null) {
        throw new b("Not all required fields were included: AppID");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.sye != null) {
        paramVarArgs.d(2, this.sye);
      }
      if (this.kRX != null) {
        paramVarArgs.d(3, this.kRX);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label483;
      }
    }
    label483:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sye != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sye);
      }
      i = paramInt;
      if (this.kRX != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kRX);
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
        if (this.tFx == null) {
          throw new b("Not all required fields were included: BaseResponse");
        }
        if (this.sye == null) {
          throw new b("Not all required fields were included: ReqKey");
        }
        if (this.kRX != null) {
          break;
        }
        throw new b("Not all required fields were included: AppID");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        eo localeo = (eo)paramVarArgs[1];
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
            localeo.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localeo.sye = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localeo.kRX = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.eo
 * JD-Core Version:    0.7.0.1
 */