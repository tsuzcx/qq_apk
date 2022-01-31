package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class agj
  extends com.tencent.mm.bv.a
{
  public aop sAL;
  public int tea;
  public int teb;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sAL == null) {
        throw new b("Not all required fields were included: Device");
      }
      paramVarArgs.gB(1, this.tea);
      paramVarArgs.gB(2, this.teb);
      if (this.sAL != null)
      {
        paramVarArgs.gD(3, this.sAL.btq());
        this.sAL.a(paramVarArgs);
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
      i = d.a.a.a.gy(1, this.tea) + 0 + d.a.a.a.gy(2, this.teb);
      paramInt = i;
    } while (this.sAL == null);
    return i + d.a.a.a.gA(3, this.sAL.btq());
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.sAL == null) {
        throw new b("Not all required fields were included: Device");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      agj localagj = (agj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localagj.tea = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localagj.teb = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aop();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((aop)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localagj.sAL = ((aop)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.agj
 * JD-Core Version:    0.7.0.1
 */