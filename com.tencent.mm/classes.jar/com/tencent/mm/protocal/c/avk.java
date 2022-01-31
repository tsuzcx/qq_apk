package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class avk
  extends com.tencent.mm.bv.a
{
  public String jxi;
  public int pyo;
  public int tqS;
  public atp tqT;
  public int tqU;
  public long tqV;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.pyo);
      paramVarArgs.gB(2, this.tqS);
      if (this.tqT != null)
      {
        paramVarArgs.gD(3, this.tqT.btq());
        this.tqT.a(paramVarArgs);
      }
      paramVarArgs.gB(4, this.tqU);
      if (this.jxi != null) {
        paramVarArgs.d(5, this.jxi);
      }
      paramVarArgs.Y(6, this.tqV);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.pyo) + 0 + d.a.a.a.gy(2, this.tqS);
      paramInt = i;
      if (this.tqT != null) {
        paramInt = i + d.a.a.a.gA(3, this.tqT.btq());
      }
      i = paramInt + d.a.a.a.gy(4, this.tqU);
      paramInt = i;
      if (this.jxi != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.jxi);
      }
      return paramInt + d.a.a.a.X(6, this.tqV);
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
      avk localavk = (avk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localavk.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localavk.tqS = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new atp();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((atp)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localavk.tqT = ((atp)localObject1);
          paramInt += 1;
        }
        return 0;
      case 4: 
        localavk.tqU = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 5: 
        localavk.jxi = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      localavk.tqV = ((d.a.a.a.a)localObject1).xpH.oE();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.avk
 * JD-Core Version:    0.7.0.1
 */