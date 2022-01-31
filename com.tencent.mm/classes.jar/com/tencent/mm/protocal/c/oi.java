package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class oi
  extends blm
{
  public String ewD;
  public String kWm;
  public String kWn;
  public String sGQ;
  public long sLM;
  public String sLN;
  public String sLO;
  public int sxP;
  
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
      if (this.kWm != null) {
        paramVarArgs.d(3, this.kWm);
      }
      paramVarArgs.Y(4, this.sLM);
      if (this.sGQ != null) {
        paramVarArgs.d(5, this.sGQ);
      }
      if (this.sLN != null) {
        paramVarArgs.d(6, this.sLN);
      }
      paramVarArgs.gB(7, this.sxP);
      if (this.sLO != null) {
        paramVarArgs.d(8, this.sLO);
      }
      if (this.ewD != null) {
        paramVarArgs.d(9, this.ewD);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label689;
      }
    }
    label689:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kWn != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kWn);
      }
      i = paramInt;
      if (this.kWm != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kWm);
      }
      i += d.a.a.a.X(4, this.sLM);
      paramInt = i;
      if (this.sGQ != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sGQ);
      }
      i = paramInt;
      if (this.sLN != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.sLN);
      }
      i += d.a.a.a.gy(7, this.sxP);
      paramInt = i;
      if (this.sLO != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sLO);
      }
      i = paramInt;
      if (this.ewD != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.ewD);
      }
      return i;
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
        oi localoi = (oi)paramVarArgs[1];
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
            localoi.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localoi.kWn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localoi.kWm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localoi.sLM = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 5: 
          localoi.sGQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localoi.sLN = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localoi.sxP = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localoi.sLO = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localoi.ewD = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.oi
 * JD-Core Version:    0.7.0.1
 */