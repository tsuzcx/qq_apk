package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cjo
  extends com.tencent.mm.bv.a
{
  public long tXq;
  public long tXr;
  public String tXs;
  public LinkedList<cjp> tXt = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: TotalMsg");
      }
      paramVarArgs.Y(1, this.tXr);
      paramVarArgs.Y(2, this.tXq);
      if (this.tXs != null) {
        paramVarArgs.d(3, this.tXs);
      }
      paramVarArgs.d(4, 8, this.tXt);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.X(1, this.tXr) + 0 + d.a.a.a.X(2, this.tXq);
      paramInt = i;
      if (this.tXs != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.tXs);
      }
      return paramInt + d.a.a.a.c(4, 8, this.tXt);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tXt.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.tXs == null) {
        throw new b("Not all required fields were included: TotalMsg");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      cjo localcjo = (cjo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localcjo.tXr = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 2: 
        localcjo.tXq = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 3: 
        localcjo.tXs = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cjp();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cjp)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localcjo.tXt.add(localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cjo
 * JD-Core Version:    0.7.0.1
 */