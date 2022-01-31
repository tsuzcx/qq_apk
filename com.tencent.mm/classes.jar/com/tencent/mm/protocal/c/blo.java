package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class blo
  extends bly
{
  public int iHq;
  public String iHr;
  public String lRA;
  public String lnT;
  public String nvA;
  public String nvz;
  public String sFw;
  public cr tFc;
  
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
      if (this.lRA != null) {
        paramVarArgs.d(4, this.lRA);
      }
      if (this.sFw != null) {
        paramVarArgs.d(5, this.sFw);
      }
      if (this.nvz != null) {
        paramVarArgs.d(6, this.nvz);
      }
      if (this.nvA != null) {
        paramVarArgs.d(7, this.nvA);
      }
      if (this.lnT != null) {
        paramVarArgs.d(8, this.lnT);
      }
      if (this.tFc != null)
      {
        paramVarArgs.gD(9, this.tFc.btq());
        this.tFc.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label831;
      }
    }
    label831:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.iHq);
      paramInt = i;
      if (this.iHr != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.iHr);
      }
      i = paramInt;
      if (this.lRA != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.lRA);
      }
      paramInt = i;
      if (this.sFw != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sFw);
      }
      i = paramInt;
      if (this.nvz != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.nvz);
      }
      paramInt = i;
      if (this.nvA != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.nvA);
      }
      i = paramInt;
      if (this.lnT != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.lnT);
      }
      paramInt = i;
      if (this.tFc != null) {
        paramInt = i + d.a.a.a.gA(9, this.tFc.btq());
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
        blo localblo = (blo)paramVarArgs[1];
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
            localblo.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localblo.iHq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localblo.iHr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localblo.lRA = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localblo.sFw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localblo.nvz = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localblo.nvA = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localblo.lnT = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cr();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cr)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localblo.tFc = ((cr)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.blo
 * JD-Core Version:    0.7.0.1
 */