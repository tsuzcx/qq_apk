package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bnu
  extends bly
{
  public String sAJ;
  public axd sAK;
  public aop sBc;
  public aoq sBd;
  public int tGC;
  public cp tGD;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.sAK == null) {
        throw new b("Not all required fields were included: Contact");
      }
      if (this.sBc == null) {
        throw new b("Not all required fields were included: HardDevice");
      }
      if (this.sBd == null) {
        throw new b("Not all required fields were included: HardDeviceAttr");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.sAK != null)
      {
        paramVarArgs.gD(2, this.sAK.btq());
        this.sAK.a(paramVarArgs);
      }
      if (this.sBc != null)
      {
        paramVarArgs.gD(3, this.sBc.btq());
        this.sBc.a(paramVarArgs);
      }
      if (this.sBd != null)
      {
        paramVarArgs.gD(4, this.sBd.btq());
        this.sBd.a(paramVarArgs);
      }
      if (this.sAJ != null) {
        paramVarArgs.d(5, this.sAJ);
      }
      paramVarArgs.gB(6, this.tGC);
      if (this.tGD != null)
      {
        paramVarArgs.gD(7, this.tGD.btq());
        this.tGD.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1095;
      }
    }
    label1095:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sAK != null) {
        paramInt = i + d.a.a.a.gA(2, this.sAK.btq());
      }
      i = paramInt;
      if (this.sBc != null) {
        i = paramInt + d.a.a.a.gA(3, this.sBc.btq());
      }
      paramInt = i;
      if (this.sBd != null) {
        paramInt = i + d.a.a.a.gA(4, this.sBd.btq());
      }
      i = paramInt;
      if (this.sAJ != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sAJ);
      }
      i += d.a.a.a.gy(6, this.tGC);
      paramInt = i;
      if (this.tGD != null) {
        paramInt = i + d.a.a.a.gA(7, this.tGD.btq());
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
        if (this.tFx == null) {
          throw new b("Not all required fields were included: BaseResponse");
        }
        if (this.sAK == null) {
          throw new b("Not all required fields were included: Contact");
        }
        if (this.sBc == null) {
          throw new b("Not all required fields were included: HardDevice");
        }
        if (this.sBd != null) {
          break;
        }
        throw new b("Not all required fields were included: HardDeviceAttr");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bnu localbnu = (bnu)paramVarArgs[1];
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
            localbnu.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new axd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((axd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbnu.sAK = ((axd)localObject1);
            paramInt += 1;
          }
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aop();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aop)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbnu.sBc = ((aop)localObject1);
            paramInt += 1;
          }
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aoq();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aoq)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbnu.sBd = ((aoq)localObject1);
            paramInt += 1;
          }
        case 5: 
          localbnu.sAJ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localbnu.tGC = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cp();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cp)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localbnu.tGD = ((cp)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bnu
 * JD-Core Version:    0.7.0.1
 */