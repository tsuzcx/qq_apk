package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class zv
  extends bly
{
  public String bGw;
  public LinkedList<String> sZb = new LinkedList();
  public String sZc;
  public LinkedList<String> sZd = new LinkedList();
  public LinkedList<String> sZe = new LinkedList();
  public LinkedList<zw> sZf = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.bGw == null) {
        throw new b("Not all required fields were included: Title");
      }
      if (this.sZc == null) {
        throw new b("Not all required fields were included: JsonData");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.bGw != null) {
        paramVarArgs.d(2, this.bGw);
      }
      paramVarArgs.d(3, 1, this.sZb);
      if (this.sZc != null) {
        paramVarArgs.d(4, this.sZc);
      }
      paramVarArgs.d(5, 1, this.sZd);
      paramVarArgs.d(6, 1, this.sZe);
      paramVarArgs.d(7, 8, this.sZf);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label773;
      }
    }
    label773:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.bGw != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.bGw);
      }
      i += d.a.a.a.c(3, 1, this.sZb);
      paramInt = i;
      if (this.sZc != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sZc);
      }
      return paramInt + d.a.a.a.c(5, 1, this.sZd) + d.a.a.a.c(6, 1, this.sZe) + d.a.a.a.c(7, 8, this.sZf);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sZb.clear();
        this.sZd.clear();
        this.sZe.clear();
        this.sZf.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx == null) {
          throw new b("Not all required fields were included: BaseResponse");
        }
        if (this.bGw == null) {
          throw new b("Not all required fields were included: Title");
        }
        if (this.sZc != null) {
          break;
        }
        throw new b("Not all required fields were included: JsonData");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        zv localzv = (zv)paramVarArgs[1];
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
            localzv.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localzv.bGw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localzv.sZb.add(((d.a.a.a.a)localObject1).xpH.readString());
          return 0;
        case 4: 
          localzv.sZc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localzv.sZd.add(((d.a.a.a.a)localObject1).xpH.readString());
          return 0;
        case 6: 
          localzv.sZe.add(((d.a.a.a.a)localObject1).xpH.readString());
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new zw();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((zw)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localzv.sZf.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.zv
 * JD-Core Version:    0.7.0.1
 */