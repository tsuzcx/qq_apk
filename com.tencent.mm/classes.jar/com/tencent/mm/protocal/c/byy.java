package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class byy
  extends bly
{
  public int bLB;
  public String bLC;
  public String tOX;
  public String tOY;
  public brx tOZ;
  public int version;
  
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
      paramVarArgs.gB(2, this.bLB);
      if (this.bLC != null) {
        paramVarArgs.d(3, this.bLC);
      }
      if (this.tOX != null) {
        paramVarArgs.d(4, this.tOX);
      }
      if (this.tOY != null) {
        paramVarArgs.d(5, this.tOY);
      }
      if (this.tOZ != null)
      {
        paramVarArgs.gD(6, this.tOZ.btq());
        this.tOZ.a(paramVarArgs);
      }
      paramVarArgs.gB(7, this.version);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label697;
      }
    }
    label697:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.bLB);
      paramInt = i;
      if (this.bLC != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.bLC);
      }
      i = paramInt;
      if (this.tOX != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.tOX);
      }
      paramInt = i;
      if (this.tOY != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tOY);
      }
      i = paramInt;
      if (this.tOZ != null) {
        i = paramInt + d.a.a.a.gA(6, this.tOZ.btq());
      }
      return i + d.a.a.a.gy(7, this.version);
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
        byy localbyy = (byy)paramVarArgs[1];
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
            localbyy.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbyy.bLB = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbyy.bLC = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbyy.tOX = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbyy.tOY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new brx();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((brx)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbyy.tOZ = ((brx)localObject1);
            paramInt += 1;
          }
        }
        localbyy.version = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.byy
 * JD-Core Version:    0.7.0.1
 */