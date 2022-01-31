package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bft
  extends blm
{
  public String kWm;
  public int sST;
  public long sSU;
  public long tAB;
  public int tAC;
  public String tAD;
  public long tAE;
  
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
      paramVarArgs.gB(2, this.sST);
      paramVarArgs.Y(3, this.sSU);
      if (this.kWm != null) {
        paramVarArgs.d(4, this.kWm);
      }
      paramVarArgs.Y(5, this.tAB);
      paramVarArgs.gB(6, this.tAC);
      if (this.tAD != null) {
        paramVarArgs.d(7, this.tAD);
      }
      paramVarArgs.Y(8, this.tAE);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label578;
      }
    }
    label578:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.sST) + d.a.a.a.X(3, this.sSU);
      paramInt = i;
      if (this.kWm != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kWm);
      }
      i = paramInt + d.a.a.a.X(5, this.tAB) + d.a.a.a.gy(6, this.tAC);
      paramInt = i;
      if (this.tAD != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.tAD);
      }
      return paramInt + d.a.a.a.X(8, this.tAE);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
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
        bft localbft = (bft)paramVarArgs[1];
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
            localbft.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbft.sST = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbft.sSU = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 4: 
          localbft.kWm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbft.tAB = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 6: 
          localbft.tAC = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localbft.tAD = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbft.tAE = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bft
 * JD-Core Version:    0.7.0.1
 */