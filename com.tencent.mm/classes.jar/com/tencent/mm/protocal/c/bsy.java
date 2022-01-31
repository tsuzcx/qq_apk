package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bsy
  extends com.tencent.mm.bv.a
{
  public String nde;
  public long sGd;
  public long tJA;
  public bsx tJB;
  public bsx tJC;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tJB == null) {
        throw new b("Not all required fields were included: CurrentAction");
      }
      paramVarArgs.Y(1, this.sGd);
      paramVarArgs.Y(2, this.tJA);
      if (this.tJB != null)
      {
        paramVarArgs.gD(3, this.tJB.btq());
        this.tJB.a(paramVarArgs);
      }
      if (this.tJC != null)
      {
        paramVarArgs.gD(4, this.tJC.btq());
        this.tJC.a(paramVarArgs);
      }
      if (this.nde != null) {
        paramVarArgs.d(5, this.nde);
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
      i = d.a.a.a.X(1, this.sGd) + 0 + d.a.a.a.X(2, this.tJA);
      paramInt = i;
      if (this.tJB != null) {
        paramInt = i + d.a.a.a.gA(3, this.tJB.btq());
      }
      i = paramInt;
      if (this.tJC != null) {
        i = paramInt + d.a.a.a.gA(4, this.tJC.btq());
      }
      paramInt = i;
    } while (this.nde == null);
    return i + d.a.a.b.b.a.e(5, this.nde);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.tJB == null) {
        throw new b("Not all required fields were included: CurrentAction");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      bsy localbsy = (bsy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localbsy.sGd = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 2: 
        localbsy.tJA = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 3: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bsx();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bsx)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbsy.tJB = ((bsx)localObject1);
          paramInt += 1;
        }
        return 0;
      case 4: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bsx();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bsx)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbsy.tJC = ((bsx)localObject1);
          paramInt += 1;
        }
        return 0;
      }
      localbsy.nde = ((d.a.a.a.a)localObject1).xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bsy
 * JD-Core Version:    0.7.0.1
 */