package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bul
  extends blm
{
  public int hPS;
  public LinkedList<bml> hPT = new LinkedList();
  public String kVl;
  public int pyo;
  public int ssq;
  public long tLb;
  
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
      paramVarArgs.gB(2, this.ssq);
      paramVarArgs.Y(3, this.tLb);
      if (this.kVl != null) {
        paramVarArgs.d(4, this.kVl);
      }
      paramVarArgs.gB(5, this.hPS);
      paramVarArgs.d(6, 8, this.hPT);
      paramVarArgs.gB(7, this.pyo);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label613;
      }
    }
    label613:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ssq) + d.a.a.a.X(3, this.tLb);
      paramInt = i;
      if (this.kVl != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kVl);
      }
      return paramInt + d.a.a.a.gy(5, this.hPS) + d.a.a.a.c(6, 8, this.hPT) + d.a.a.a.gy(7, this.pyo);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.hPT.clear();
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
        bul localbul = (bul)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
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
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbul.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbul.ssq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbul.tLb = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 4: 
          localbul.kVl = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbul.hPS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbul.hPT.add(localObject1);
            paramInt += 1;
          }
        }
        localbul.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bul
 * JD-Core Version:    0.7.0.1
 */