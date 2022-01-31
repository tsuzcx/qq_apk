package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class of
  extends bly
{
  public int iHq;
  public String iHr;
  public String nvA;
  public String nvy;
  public String nvz;
  public String sxV;
  
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
      if (this.nvy != null) {
        paramVarArgs.d(4, this.nvy);
      }
      if (this.nvz != null) {
        paramVarArgs.d(5, this.nvz);
      }
      if (this.nvA != null) {
        paramVarArgs.d(6, this.nvA);
      }
      if (this.sxV != null) {
        paramVarArgs.d(7, this.sxV);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label623;
      }
    }
    label623:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.iHq);
      paramInt = i;
      if (this.iHr != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.iHr);
      }
      i = paramInt;
      if (this.nvy != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.nvy);
      }
      paramInt = i;
      if (this.nvz != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.nvz);
      }
      i = paramInt;
      if (this.nvA != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.nvA);
      }
      paramInt = i;
      if (this.sxV != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.sxV);
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
        of localof = (of)paramVarArgs[1];
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
            localof.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localof.iHq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localof.iHr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localof.nvy = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localof.nvz = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localof.nvA = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localof.sxV = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.of
 * JD-Core Version:    0.7.0.1
 */