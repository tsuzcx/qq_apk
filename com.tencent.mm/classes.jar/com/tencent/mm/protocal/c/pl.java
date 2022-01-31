package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class pl
  extends bly
{
  public int jxl;
  public String jxm;
  public bds sNn;
  public String sog;
  public String token;
  
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
      paramVarArgs.gB(2, this.jxl);
      if (this.jxm != null) {
        paramVarArgs.d(3, this.jxm);
      }
      if (this.token != null) {
        paramVarArgs.d(4, this.token);
      }
      if (this.sNn != null)
      {
        paramVarArgs.gD(5, this.sNn.btq());
        this.sNn.a(paramVarArgs);
      }
      if (this.sog != null) {
        paramVarArgs.d(6, this.sog);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.jxl);
      paramInt = i;
      if (this.jxm != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.jxm);
      }
      i = paramInt;
      if (this.token != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.token);
      }
      paramInt = i;
      if (this.sNn != null) {
        paramInt = i + d.a.a.a.gA(5, this.sNn.btq());
      }
      i = paramInt;
      if (this.sog != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.sog);
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
        pl localpl = (pl)paramVarArgs[1];
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
            localpl.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localpl.jxl = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localpl.jxm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localpl.token = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bds();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bds)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localpl.sNn = ((bds)localObject1);
            paramInt += 1;
          }
        }
        localpl.sog = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.pl
 * JD-Core Version:    0.7.0.1
 */