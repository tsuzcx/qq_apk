package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class aaj
  extends bly
{
  public int jxl;
  public String jxm;
  public cia sZD;
  public String sZx;
  public String sZy;
  
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
      if (this.sZx != null) {
        paramVarArgs.d(2, this.sZx);
      }
      if (this.sZy != null) {
        paramVarArgs.d(3, this.sZy);
      }
      paramVarArgs.gB(4, this.jxl);
      if (this.jxm != null) {
        paramVarArgs.d(5, this.jxm);
      }
      if (this.sZD != null)
      {
        paramVarArgs.gD(6, this.sZD.btq());
        this.sZD.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label658;
      }
    }
    label658:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sZx != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sZx);
      }
      i = paramInt;
      if (this.sZy != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sZy);
      }
      i += d.a.a.a.gy(4, this.jxl);
      paramInt = i;
      if (this.jxm != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.jxm);
      }
      i = paramInt;
      if (this.sZD != null) {
        i = paramInt + d.a.a.a.gA(6, this.sZD.btq());
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
        aaj localaaj = (aaj)paramVarArgs[1];
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
            localaaj.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaaj.sZx = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localaaj.sZy = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localaaj.jxl = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localaaj.jxm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cia();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cia)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localaaj.sZD = ((cia)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aaj
 * JD-Core Version:    0.7.0.1
 */