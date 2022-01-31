package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ccj
  extends com.tencent.mm.bv.a
{
  public int bxH;
  public String kRN;
  public bmk tRE;
  public bmk tRF;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tRE == null) {
        throw new b("Not all required fields were included: Icon");
      }
      if (this.tRF == null) {
        throw new b("Not all required fields were included: HDIcon");
      }
      paramVarArgs.gB(1, this.bxH);
      if (this.kRN != null) {
        paramVarArgs.d(2, this.kRN);
      }
      if (this.tRE != null)
      {
        paramVarArgs.gD(3, this.tRE.btq());
        this.tRE.a(paramVarArgs);
      }
      if (this.tRF != null)
      {
        paramVarArgs.gD(4, this.tRF.btq());
        this.tRF.a(paramVarArgs);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.bxH) + 0;
      paramInt = i;
      if (this.kRN != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kRN);
      }
      i = paramInt;
      if (this.tRE != null) {
        i = paramInt + d.a.a.a.gA(3, this.tRE.btq());
      }
      paramInt = i;
    } while (this.tRF == null);
    return i + d.a.a.a.gA(4, this.tRF.btq());
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.tRE == null) {
        throw new b("Not all required fields were included: Icon");
      }
      if (this.tRF == null) {
        throw new b("Not all required fields were included: HDIcon");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      ccj localccj = (ccj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localccj.bxH = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localccj.kRN = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 3: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localccj.tRE = ((bmk)localObject1);
          paramInt += 1;
        }
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bmk();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localccj.tRF = ((bmk)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ccj
 * JD-Core Version:    0.7.0.1
 */