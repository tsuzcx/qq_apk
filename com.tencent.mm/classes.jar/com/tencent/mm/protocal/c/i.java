package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class i
  extends bly
{
  public int iHq = 268513600;
  public String iHr = "请求不成功，请稍候再试";
  public String srq;
  public String srs;
  public y sry;
  
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
      paramVarArgs.gB(2, this.iHq);
      if (this.iHr != null) {
        paramVarArgs.d(3, this.iHr);
      }
      if (this.srq != null) {
        paramVarArgs.d(4, this.srq);
      }
      if (this.srs != null) {
        paramVarArgs.d(6, this.srs);
      }
      if (this.sry != null)
      {
        paramVarArgs.gD(7, this.sry.btq());
        this.sry.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label666;
      }
    }
    label666:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.iHq);
      paramInt = i;
      if (this.iHr != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.iHr);
      }
      i = paramInt;
      if (this.srq != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.srq);
      }
      paramInt = i;
      if (this.srs != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.srs);
      }
      i = paramInt;
      if (this.sry != null) {
        i = paramInt + d.a.a.a.gA(7, this.sry.btq());
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
        i locali = (i)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            locali.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          locali.iHq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          locali.iHr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          locali.srq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          locali.srs = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new y();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((y)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          locali.sry = ((y)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.i
 * JD-Core Version:    0.7.0.1
 */