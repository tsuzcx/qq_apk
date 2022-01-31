package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ciu
  extends com.tencent.mm.bv.a
{
  public String kRN;
  public LinkedList<ze> tXa = new LinkedList();
  public String tXb;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tXb == null) {
        throw new b("Not all required fields were included: Charset");
      }
      paramVarArgs.d(1, 8, this.tXa);
      if (this.tXb != null) {
        paramVarArgs.d(2, this.tXb);
      }
      if (this.kRN != null) {
        paramVarArgs.d(3, this.kRN);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.c(1, 8, this.tXa) + 0;
      paramInt = i;
      if (this.tXb != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tXb);
      }
      i = paramInt;
    } while (this.kRN == null);
    return paramInt + d.a.a.b.b.a.e(3, this.kRN);
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tXa.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.tXb == null) {
        throw new b("Not all required fields were included: Charset");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      ciu localciu = (ciu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ze();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ze)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localciu.tXa.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 2: 
        localciu.tXb = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      localciu.kRN = ((d.a.a.a.a)localObject1).xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ciu
 * JD-Core Version:    0.7.0.1
 */