package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class aah
  extends bly
{
  public int jxl;
  public String jxm;
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
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label509;
      }
    }
    label509:
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
        aah localaah = (aah)paramVarArgs[1];
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
            localaah.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaah.sZx = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localaah.sZy = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localaah.jxl = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localaah.jxm = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aah
 * JD-Core Version:    0.7.0.1
 */