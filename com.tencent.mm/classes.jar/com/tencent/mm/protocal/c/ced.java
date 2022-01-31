package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ced
  extends blm
{
  public int sNU;
  public int sST;
  public long sSU;
  public String tAY;
  public cfp tSF;
  public cfp tSG;
  public long tSJ;
  public int tSK;
  public int tSU;
  public int tSV;
  
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
      if (this.tAY != null) {
        paramVarArgs.d(2, this.tAY);
      }
      paramVarArgs.gB(3, this.sST);
      paramVarArgs.gB(4, this.tSU);
      if (this.tSF != null)
      {
        paramVarArgs.gD(5, this.tSF.btq());
        this.tSF.a(paramVarArgs);
      }
      if (this.tSG != null)
      {
        paramVarArgs.gD(6, this.tSG.btq());
        this.tSG.a(paramVarArgs);
      }
      paramVarArgs.Y(7, this.sSU);
      paramVarArgs.gB(8, this.sNU);
      paramVarArgs.Y(9, this.tSJ);
      paramVarArgs.gB(10, this.tSV);
      paramVarArgs.gB(11, this.tSK);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label895;
      }
    }
    label895:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tAY != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.tAY);
      }
      i = i + d.a.a.a.gy(3, this.sST) + d.a.a.a.gy(4, this.tSU);
      paramInt = i;
      if (this.tSF != null) {
        paramInt = i + d.a.a.a.gA(5, this.tSF.btq());
      }
      i = paramInt;
      if (this.tSG != null) {
        i = paramInt + d.a.a.a.gA(6, this.tSG.btq());
      }
      return i + d.a.a.a.X(7, this.sSU) + d.a.a.a.gy(8, this.sNU) + d.a.a.a.X(9, this.tSJ) + d.a.a.a.gy(10, this.tSV) + d.a.a.a.gy(11, this.tSK);
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
        ced localced = (ced)paramVarArgs[1];
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
            localced.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localced.tAY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localced.sST = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localced.tSU = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfp();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfp)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localced.tSF = ((cfp)localObject1);
            paramInt += 1;
          }
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
            localced.tSG = ((cfp)localObject1);
            paramInt += 1;
          }
        case 7: 
          localced.sSU = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 8: 
          localced.sNU = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localced.tSJ = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 10: 
          localced.tSV = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localced.tSK = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ced
 * JD-Core Version:    0.7.0.1
 */