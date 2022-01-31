package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class xp
  extends blm
{
  public float sGJ;
  public float sGK;
  public String sRr;
  public String sUm;
  public int sUn;
  public String sUo;
  public String sUp;
  public int sUq;
  public int ssq;
  
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
      if (this.sUm != null) {
        paramVarArgs.d(3, this.sUm);
      }
      paramVarArgs.m(4, this.sGJ);
      paramVarArgs.m(5, this.sGK);
      paramVarArgs.gB(6, this.sUn);
      if (this.sUo != null) {
        paramVarArgs.d(7, this.sUo);
      }
      if (this.sUp != null) {
        paramVarArgs.d(8, this.sUp);
      }
      paramVarArgs.gB(9, this.sUq);
      if (this.sRr != null) {
        paramVarArgs.d(10, this.sRr);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label688;
      }
    }
    label688:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ssq);
      paramInt = i;
      if (this.sUm != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.sUm);
      }
      i = paramInt + (d.a.a.b.b.a.dQ(4) + 4) + (d.a.a.b.b.a.dQ(5) + 4) + d.a.a.a.gy(6, this.sUn);
      paramInt = i;
      if (this.sUo != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.sUo);
      }
      i = paramInt;
      if (this.sUp != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.sUp);
      }
      i += d.a.a.a.gy(9, this.sUq);
      paramInt = i;
      if (this.sRr != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.sRr);
      }
      return paramInt;
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
        xp localxp = (xp)paramVarArgs[1];
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
            localxp.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localxp.ssq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localxp.sUm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localxp.sGJ = ((d.a.a.a.a)localObject1).xpH.readFloat();
          return 0;
        case 5: 
          localxp.sGK = ((d.a.a.a.a)localObject1).xpH.readFloat();
          return 0;
        case 6: 
          localxp.sUn = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localxp.sUo = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localxp.sUp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localxp.sUq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localxp.sRr = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.xp
 * JD-Core Version:    0.7.0.1
 */