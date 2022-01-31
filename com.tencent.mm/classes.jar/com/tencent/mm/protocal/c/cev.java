package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cev
  extends blm
{
  public String kWm;
  public int sST;
  public long sSU;
  public int tAC;
  public String tAY;
  public long tSJ;
  public cfx tTF;
  public int tTG;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tTF == null) {
        throw new b("Not all required fields were included: ReportData");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.tAY != null) {
        paramVarArgs.d(2, this.tAY);
      }
      paramVarArgs.gB(3, this.sST);
      paramVarArgs.Y(4, this.sSU);
      if (this.kWm != null) {
        paramVarArgs.d(6, this.kWm);
      }
      if (this.tTF != null)
      {
        paramVarArgs.gD(8, this.tTF.btq());
        this.tTF.a(paramVarArgs);
      }
      paramVarArgs.gB(9, this.tTG);
      paramVarArgs.Y(10, this.tSJ);
      paramVarArgs.gB(11, this.tAC);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label767;
      }
    }
    label767:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tAY != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.tAY);
      }
      i = i + d.a.a.a.gy(3, this.sST) + d.a.a.a.X(4, this.sSU);
      paramInt = i;
      if (this.kWm != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.kWm);
      }
      i = paramInt;
      if (this.tTF != null) {
        i = paramInt + d.a.a.a.gA(8, this.tTF.btq());
      }
      return i + d.a.a.a.gy(9, this.tTG) + d.a.a.a.X(10, this.tSJ) + d.a.a.a.gy(11, this.tAC);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tTF != null) {
          break;
        }
        throw new b("Not all required fields were included: ReportData");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cev localcev = (cev)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 7: 
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
            localcev.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcev.tAY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localcev.sST = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localcev.sSU = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 6: 
          localcev.kWm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfx();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfx)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcev.tTF = ((cfx)localObject1);
            paramInt += 1;
          }
        case 9: 
          localcev.tTG = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          localcev.tSJ = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        }
        localcev.tAC = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cev
 * JD-Core Version:    0.7.0.1
 */