package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class atv
  extends blm
{
  public String evE;
  public float sGJ;
  public float sGK;
  public int sUn;
  public String sUo;
  public String sUp;
  public int sUq;
  public int ssq;
  public int tpx;
  public int tpy;
  
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
      paramVarArgs.m(3, this.sGJ);
      paramVarArgs.m(4, this.sGK);
      paramVarArgs.gB(5, this.sUn);
      if (this.sUo != null) {
        paramVarArgs.d(6, this.sUo);
      }
      if (this.sUp != null) {
        paramVarArgs.d(7, this.sUp);
      }
      paramVarArgs.gB(8, this.sUq);
      if (this.evE != null) {
        paramVarArgs.d(9, this.evE);
      }
      paramVarArgs.gB(10, this.tpx);
      paramVarArgs.gB(11, this.tpy);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label707;
      }
    }
    label707:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ssq) + (d.a.a.b.b.a.dQ(3) + 4) + (d.a.a.b.b.a.dQ(4) + 4) + d.a.a.a.gy(5, this.sUn);
      paramInt = i;
      if (this.sUo != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sUo);
      }
      i = paramInt;
      if (this.sUp != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.sUp);
      }
      i += d.a.a.a.gy(8, this.sUq);
      paramInt = i;
      if (this.evE != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.evE);
      }
      return paramInt + d.a.a.a.gy(10, this.tpx) + d.a.a.a.gy(11, this.tpy);
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
        atv localatv = (atv)paramVarArgs[1];
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
            localatv.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localatv.ssq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localatv.sGJ = ((d.a.a.a.a)localObject1).xpH.readFloat();
          return 0;
        case 4: 
          localatv.sGK = ((d.a.a.a.a)localObject1).xpH.readFloat();
          return 0;
        case 5: 
          localatv.sUn = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localatv.sUo = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localatv.sUp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localatv.sUq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localatv.evE = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localatv.tpx = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localatv.tpy = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.atv
 * JD-Core Version:    0.7.0.1
 */