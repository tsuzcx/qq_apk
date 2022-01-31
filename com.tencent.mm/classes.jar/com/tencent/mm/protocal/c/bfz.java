package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bfz
  extends blm
{
  public String kWm;
  public String kWn;
  public int sNU;
  public long tAB;
  public int tAC;
  public String tAD;
  public int tAK;
  public int tAL;
  public int tAM;
  
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
      if (this.kWn != null) {
        paramVarArgs.d(2, this.kWn);
      }
      if (this.tAD != null) {
        paramVarArgs.d(3, this.tAD);
      }
      paramVarArgs.gB(4, this.sNU);
      paramVarArgs.Y(5, this.tAB);
      paramVarArgs.gB(6, this.tAC);
      if (this.kWm != null) {
        paramVarArgs.d(7, this.kWm);
      }
      paramVarArgs.gB(8, this.tAL);
      paramVarArgs.gB(9, this.tAK);
      paramVarArgs.gB(10, this.tAM);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label672;
      }
    }
    label672:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kWn != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kWn);
      }
      i = paramInt;
      if (this.tAD != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tAD);
      }
      i = i + d.a.a.a.gy(4, this.sNU) + d.a.a.a.X(5, this.tAB) + d.a.a.a.gy(6, this.tAC);
      paramInt = i;
      if (this.kWm != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.kWm);
      }
      return paramInt + d.a.a.a.gy(8, this.tAL) + d.a.a.a.gy(9, this.tAK) + d.a.a.a.gy(10, this.tAM);
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
        bfz localbfz = (bfz)paramVarArgs[1];
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
            localbfz.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbfz.kWn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbfz.tAD = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbfz.sNU = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localbfz.tAB = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 6: 
          localbfz.tAC = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localbfz.kWm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localbfz.tAL = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localbfz.tAK = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localbfz.tAM = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bfz
 * JD-Core Version:    0.7.0.1
 */