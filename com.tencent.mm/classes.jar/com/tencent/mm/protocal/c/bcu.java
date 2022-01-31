package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bcu
  extends com.tencent.mm.bv.a
{
  public bmk tyd;
  public int tye;
  public bmk tyf;
  public int uin;
  public int version;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.uin);
      paramVarArgs.gB(2, this.version);
      if (this.tyd != null)
      {
        paramVarArgs.gD(3, this.tyd.btq());
        this.tyd.a(paramVarArgs);
      }
      paramVarArgs.gB(4, this.tye);
      if (this.tyf != null)
      {
        paramVarArgs.gD(5, this.tyf.btq());
        this.tyf.a(paramVarArgs);
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
      i = d.a.a.a.gy(1, this.uin) + 0 + d.a.a.a.gy(2, this.version);
      paramInt = i;
      if (this.tyd != null) {
        paramInt = i + d.a.a.a.gA(3, this.tyd.btq());
      }
      i = paramInt + d.a.a.a.gy(4, this.tye);
      paramInt = i;
    } while (this.tyf == null);
    return i + d.a.a.a.gA(5, this.tyf.btq());
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
      bcu localbcu = (bcu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localbcu.uin = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localbcu.version = ((d.a.a.a.a)localObject1).xpH.oD();
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
          localbcu.tyd = ((bmk)localObject1);
          paramInt += 1;
        }
        return 0;
      case 4: 
        localbcu.tye = ((d.a.a.a.a)localObject1).xpH.oD();
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
        localbcu.tyf = ((bmk)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bcu
 * JD-Core Version:    0.7.0.1
 */