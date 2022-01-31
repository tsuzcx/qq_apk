package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ix
  extends blm
{
  public int pyo;
  public LinkedList<String> sDk = new LinkedList();
  public String sDl;
  public double sDm;
  public double sDn;
  public String syc;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.syc != null) {
        paramVarArgs.d(2, this.syc);
      }
      paramVarArgs.d(3, 1, this.sDk);
      paramVarArgs.gB(4, this.pyo);
      if (this.sDl != null) {
        paramVarArgs.d(5, this.sDl);
      }
      paramVarArgs.b(6, this.sDm);
      paramVarArgs.b(7, this.sDn);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label547;
      }
    }
    label547:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.syc != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.syc);
      }
      i = i + d.a.a.a.c(3, 1, this.sDk) + d.a.a.a.gy(4, this.pyo);
      paramInt = i;
      if (this.sDl != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sDl);
      }
      return paramInt + (d.a.a.b.b.a.dQ(6) + 8) + (d.a.a.b.b.a.dQ(7) + 8);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sDk.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ix localix = (ix)paramVarArgs[1];
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
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localix.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localix.syc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localix.sDk.add(((d.a.a.a.a)localObject1).xpH.readString());
          return 0;
        case 4: 
          localix.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localix.sDl = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localix.sDm = ((d.a.a.a.a)localObject1).xpH.readDouble();
          return 0;
        }
        localix.sDn = ((d.a.a.a.a)localObject1).xpH.readDouble();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ix
 * JD-Core Version:    0.7.0.1
 */