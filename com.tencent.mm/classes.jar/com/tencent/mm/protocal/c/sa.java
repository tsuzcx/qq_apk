package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class sa
  extends blm
{
  public int ilo;
  public String lLm;
  public String sMC;
  public String sMy;
  public String sQc;
  public long sQd;
  
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
      if (this.sQc != null) {
        paramVarArgs.d(2, this.sQc);
      }
      paramVarArgs.Y(3, this.sQd);
      if (this.sMy != null) {
        paramVarArgs.d(4, this.sMy);
      }
      if (this.sMC != null) {
        paramVarArgs.d(5, this.sMC);
      }
      paramVarArgs.gB(6, this.ilo);
      if (this.lLm != null) {
        paramVarArgs.d(7, this.lLm);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label575;
      }
    }
    label575:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sQc != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.sQc);
      }
      i += d.a.a.a.X(3, this.sQd);
      paramInt = i;
      if (this.sMy != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sMy);
      }
      i = paramInt;
      if (this.sMC != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sMC);
      }
      i += d.a.a.a.gy(6, this.ilo);
      paramInt = i;
      if (this.lLm != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.lLm);
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
        sa localsa = (sa)paramVarArgs[1];
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
            localsa.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localsa.sQc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localsa.sQd = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 4: 
          localsa.sMy = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localsa.sMC = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localsa.ilo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localsa.lLm = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.sa
 * JD-Core Version:    0.7.0.1
 */