package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class agm
  extends com.tencent.mm.bv.a
{
  public aop sAL;
  public String sRr;
  public int sze;
  public int tea;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sze);
      if (this.sAL != null)
      {
        paramVarArgs.gD(2, this.sAL.btq());
        this.sAL.a(paramVarArgs);
      }
      if (this.sRr != null) {
        paramVarArgs.d(3, this.sRr);
      }
      paramVarArgs.gB(4, this.tea);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.sze) + 0;
      paramInt = i;
      if (this.sAL != null) {
        paramInt = i + d.a.a.a.gA(2, this.sAL.btq());
      }
      i = paramInt;
      if (this.sRr != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sRr);
      }
      return i + d.a.a.a.gy(4, this.tea);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      agm localagm = (agm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localagm.sze = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aop();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aop)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localagm.sAL = ((aop)localObject1);
          paramInt += 1;
        }
        return 0;
      case 3: 
        localagm.sRr = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      localagm.tea = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.agm
 * JD-Core Version:    0.7.0.1
 */