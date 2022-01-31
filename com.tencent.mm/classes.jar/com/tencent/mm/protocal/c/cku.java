package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cku
  extends com.tencent.mm.bv.a
{
  public String jxi;
  public int pyo;
  public long sFC;
  public String sZQ;
  public LinkedList<String> tYd = new LinkedList();
  public LinkedList<rb> tYe = new LinkedList();
  public int tqS;
  public atp tqT;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, 1, this.tYd);
      paramVarArgs.gB(2, this.tqS);
      if (this.jxi != null) {
        paramVarArgs.d(3, this.jxi);
      }
      paramVarArgs.gB(4, this.pyo);
      paramVarArgs.Y(5, this.sFC);
      if (this.sZQ != null) {
        paramVarArgs.d(6, this.sZQ);
      }
      if (this.tqT != null)
      {
        paramVarArgs.gD(7, this.tqT.btq());
        this.tqT.a(paramVarArgs);
      }
      paramVarArgs.d(8, 8, this.tYe);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.c(1, 1, this.tYd) + 0 + d.a.a.a.gy(2, this.tqS);
      paramInt = i;
      if (this.jxi != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.jxi);
      }
      i = paramInt + d.a.a.a.gy(4, this.pyo) + d.a.a.a.X(5, this.sFC);
      paramInt = i;
      if (this.sZQ != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sZQ);
      }
      i = paramInt;
      if (this.tqT != null) {
        i = paramInt + d.a.a.a.gA(7, this.tqT.btq());
      }
      return i + d.a.a.a.c(8, 8, this.tYe);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tYd.clear();
      this.tYe.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
      cku localcku = (cku)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localcku.tYd.add(((d.a.a.a.a)localObject1).xpH.readString());
        return 0;
      case 2: 
        localcku.tqS = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        localcku.jxi = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 4: 
        localcku.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 5: 
        localcku.sFC = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 6: 
        localcku.sZQ = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 7: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new atp();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((atp)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localcku.tqT = ((atp)localObject1);
          paramInt += 1;
        }
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new rb();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((rb)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localcku.tYe.add(localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cku
 * JD-Core Version:    0.7.0.1
 */