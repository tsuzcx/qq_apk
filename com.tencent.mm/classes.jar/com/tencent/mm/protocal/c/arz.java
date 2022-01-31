package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class arz
  extends bly
{
  public String sEk;
  public aqz tnb;
  public String tnn;
  
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
      if (this.tnb != null)
      {
        paramVarArgs.gD(2, this.tnb.btq());
        this.tnb.a(paramVarArgs);
      }
      if (this.tnn != null) {
        paramVarArgs.d(3, this.tnn);
      }
      if (this.sEk != null) {
        paramVarArgs.d(4, this.sEk);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label564;
      }
    }
    label564:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tnb != null) {
        paramInt = i + d.a.a.a.gA(2, this.tnb.btq());
      }
      i = paramInt;
      if (this.tnn != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tnn);
      }
      paramInt = i;
      if (this.sEk != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sEk);
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
        arz localarz = (arz)paramVarArgs[1];
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
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localarz.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aqz();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aqz)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localarz.tnb = ((aqz)localObject1);
            paramInt += 1;
          }
        case 3: 
          localarz.tnn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localarz.sEk = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.arz
 * JD-Core Version:    0.7.0.1
 */