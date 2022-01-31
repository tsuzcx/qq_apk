package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class he
  extends com.tencent.mm.bv.a
{
  public String hQc;
  public String sAE;
  public String sAJ;
  public axd sAK;
  public aop sAL;
  public int sze;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sze);
      if (this.sAJ != null) {
        paramVarArgs.d(2, this.sAJ);
      }
      if (this.sAK != null)
      {
        paramVarArgs.gD(3, this.sAK.btq());
        this.sAK.a(paramVarArgs);
      }
      if (this.sAE != null) {
        paramVarArgs.d(4, this.sAE);
      }
      if (this.hQc != null) {
        paramVarArgs.d(5, this.hQc);
      }
      if (this.sAL != null)
      {
        paramVarArgs.gD(6, this.sAL.btq());
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
      i = d.a.a.a.gy(1, this.sze) + 0;
      paramInt = i;
      if (this.sAJ != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sAJ);
      }
      i = paramInt;
      if (this.sAK != null) {
        i = paramInt + d.a.a.a.gA(3, this.sAK.btq());
      }
      paramInt = i;
      if (this.sAE != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sAE);
      }
      i = paramInt;
      if (this.hQc != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.hQc);
      }
      paramInt = i;
    } while (this.sAL == null);
    return i + d.a.a.a.gA(6, this.sAL.btq());
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
      he localhe = (he)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localhe.sze = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localhe.sAJ = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 3: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new axd();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((axd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localhe.sAK = ((axd)localObject1);
          paramInt += 1;
        }
        return 0;
      case 4: 
        localhe.sAE = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 5: 
        localhe.hQc = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aop();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((aop)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localhe.sAL = ((aop)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.he
 * JD-Core Version:    0.7.0.1
 */