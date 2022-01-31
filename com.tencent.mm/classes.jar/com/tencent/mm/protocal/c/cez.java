package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cez
  extends com.tencent.mm.bv.a
{
  public int jwX;
  public int nFi;
  public int sOA;
  public bmk szp;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.szp == null) {
        throw new b("Not all required fields were included: Buffer");
      }
      paramVarArgs.gB(1, this.sOA);
      paramVarArgs.gB(2, this.jwX);
      paramVarArgs.gB(3, this.nFi);
      if (this.szp != null)
      {
        paramVarArgs.gD(4, this.szp.btq());
        this.szp.a(paramVarArgs);
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
      i = d.a.a.a.gy(1, this.sOA) + 0 + d.a.a.a.gy(2, this.jwX) + d.a.a.a.gy(3, this.nFi);
      paramInt = i;
    } while (this.szp == null);
    return i + d.a.a.a.gA(4, this.szp.btq());
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
      cez localcez = (cez)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localcez.sOA = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localcez.jwX = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        localcez.nFi = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bmk();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localcez.szp = ((bmk)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cez
 * JD-Core Version:    0.7.0.1
 */