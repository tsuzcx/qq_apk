package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bnp
  extends com.tencent.mm.bv.a
{
  public int sAs;
  public bmk tcI;
  public String tcJ;
  public long tcL;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tcJ == null) {
        throw new b("Not all required fields were included: KeyWord");
      }
      paramVarArgs.gB(1, this.sAs);
      if (this.tcJ != null) {
        paramVarArgs.d(2, this.tcJ);
      }
      if (this.tcI != null)
      {
        paramVarArgs.gD(3, this.tcI.btq());
        this.tcI.a(paramVarArgs);
      }
      paramVarArgs.Y(4, this.tcL);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.sAs) + 0;
      paramInt = i;
      if (this.tcJ != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tcJ);
      }
      i = paramInt;
      if (this.tcI != null) {
        i = paramInt + d.a.a.a.gA(3, this.tcI.btq());
      }
      return i + d.a.a.a.X(4, this.tcL);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.tcJ == null) {
        throw new b("Not all required fields were included: KeyWord");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      bnp localbnp = (bnp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localbnp.sAs = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localbnp.tcJ = ((d.a.a.a.a)localObject1).xpH.readString();
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
          localbnp.tcI = ((bmk)localObject1);
          paramInt += 1;
        }
        return 0;
      }
      localbnp.tcL = ((d.a.a.a.a)localObject1).xpH.oE();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bnp
 * JD-Core Version:    0.7.0.1
 */