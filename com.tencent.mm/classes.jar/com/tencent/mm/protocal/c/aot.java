package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class aot
  extends com.tencent.mm.bv.a
{
  public int hQR;
  public int mPL;
  public bmk szp;
  public long tkJ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.szp == null) {
        throw new b("Not all required fields were included: Buffer");
      }
      paramVarArgs.Y(1, this.tkJ);
      paramVarArgs.gB(2, this.mPL);
      if (this.szp != null)
      {
        paramVarArgs.gD(3, this.szp.btq());
        this.szp.a(paramVarArgs);
      }
      paramVarArgs.gB(4, this.hQR);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.X(1, this.tkJ) + 0 + d.a.a.a.gy(2, this.mPL);
      paramInt = i;
      if (this.szp != null) {
        paramInt = i + d.a.a.a.gA(3, this.szp.btq());
      }
      return paramInt + d.a.a.a.gy(4, this.hQR);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.szp == null) {
        throw new b("Not all required fields were included: Buffer");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      aot localaot = (aot)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localaot.tkJ = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 2: 
        localaot.mPL = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localaot.szp = ((bmk)localObject1);
          paramInt += 1;
        }
        return 0;
      }
      localaot.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aot
 * JD-Core Version:    0.7.0.1
 */