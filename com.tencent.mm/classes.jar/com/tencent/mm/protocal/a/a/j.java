package com.tencent.mm.protocal.a.a;

import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bv.a
{
  public int ret;
  public int sqA;
  public int sqB;
  public int sqK;
  public o sqL;
  public int sqP;
  public int sqw;
  public int sqx;
  public o sqy;
  public o sqz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.ret);
      paramVarArgs.gB(2, this.sqw);
      paramVarArgs.gB(3, this.sqx);
      paramVarArgs.gB(4, this.sqK);
      if (this.sqy != null)
      {
        paramVarArgs.gD(5, this.sqy.btq());
        this.sqy.a(paramVarArgs);
      }
      if (this.sqz != null)
      {
        paramVarArgs.gD(6, this.sqz.btq());
        this.sqz.a(paramVarArgs);
      }
      if (this.sqL != null)
      {
        paramVarArgs.gD(7, this.sqL.btq());
        this.sqL.a(paramVarArgs);
      }
      paramVarArgs.gB(8, this.sqA);
      paramVarArgs.gB(9, this.sqP);
      paramVarArgs.gB(10, this.sqB);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.ret) + 0 + d.a.a.a.gy(2, this.sqw) + d.a.a.a.gy(3, this.sqx) + d.a.a.a.gy(4, this.sqK);
      paramInt = i;
      if (this.sqy != null) {
        paramInt = i + d.a.a.a.gA(5, this.sqy.btq());
      }
      i = paramInt;
      if (this.sqz != null) {
        i = paramInt + d.a.a.a.gA(6, this.sqz.btq());
      }
      paramInt = i;
      if (this.sqL != null) {
        paramInt = i + d.a.a.a.gA(7, this.sqL.btq());
      }
      return paramInt + d.a.a.a.gy(8, this.sqA) + d.a.a.a.gy(9, this.sqP) + d.a.a.a.gy(10, this.sqB);
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
      j localj = (j)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localj.ret = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localj.sqw = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        localj.sqx = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        localj.sqK = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 5: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localj.sqy = ((o)localObject1);
          paramInt += 1;
        }
        return 0;
      case 6: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localj.sqz = ((o)localObject1);
          paramInt += 1;
        }
        return 0;
      case 7: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localj.sqL = ((o)localObject1);
          paramInt += 1;
        }
        return 0;
      case 8: 
        localj.sqA = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 9: 
        localj.sqP = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      localj.sqB = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.j
 * JD-Core Version:    0.7.0.1
 */