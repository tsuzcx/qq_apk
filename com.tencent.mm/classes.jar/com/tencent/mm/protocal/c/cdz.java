package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cdz
  extends blm
{
  public int sNU;
  public int sST;
  public long sSU;
  public String tAY;
  public int tSE;
  public cfp tSF;
  public cfp tSG;
  public String tSH;
  public int tSI;
  public long tSJ;
  public int tSK;
  
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
      if (this.tAY != null) {
        paramVarArgs.d(4, this.tAY);
      }
      paramVarArgs.gB(5, this.tSE);
      if (this.tSF != null)
      {
        paramVarArgs.gD(6, this.tSF.btq());
        this.tSF.a(paramVarArgs);
      }
      if (this.tSG != null)
      {
        paramVarArgs.gD(7, this.tSG.btq());
        this.tSG.a(paramVarArgs);
      }
      paramVarArgs.gB(8, this.sNU);
      if (this.tSH != null) {
        paramVarArgs.d(9, this.tSH);
      }
      paramVarArgs.gB(10, this.tSI);
      paramVarArgs.Y(11, this.tSJ);
      paramVarArgs.gB(12, this.tSK);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.sST) + d.a.a.a.X(3, this.sSU);
      paramInt = i;
      if (this.tAY != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tAY);
      }
      i = paramInt + d.a.a.a.gy(5, this.tSE);
      paramInt = i;
      if (this.tSF != null) {
        paramInt = i + d.a.a.a.gA(6, this.tSF.btq());
      }
      i = paramInt;
      if (this.tSG != null) {
        i = paramInt + d.a.a.a.gA(7, this.tSG.btq());
      }
      i += d.a.a.a.gy(8, this.sNU);
      paramInt = i;
      if (this.tSH != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.tSH);
      }
      return paramInt + d.a.a.a.gy(10, this.tSI) + d.a.a.a.X(11, this.tSJ) + d.a.a.a.gy(12, this.tSK);
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
        cdz localcdz = (cdz)paramVarArgs[1];
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
            localcdz.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcdz.sST = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localcdz.sSU = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 4: 
          localcdz.tAY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localcdz.tSE = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfp();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfp)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcdz.tSF = ((cfp)localObject1);
            paramInt += 1;
          }
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfp();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfp)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcdz.tSG = ((cfp)localObject1);
            paramInt += 1;
          }
        case 8: 
          localcdz.sNU = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localcdz.tSH = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localcdz.tSI = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          localcdz.tSJ = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        }
        localcdz.tSK = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cdz
 * JD-Core Version:    0.7.0.1
 */