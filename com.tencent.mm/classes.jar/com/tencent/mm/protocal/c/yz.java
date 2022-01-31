package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class yz
  extends com.tencent.mm.bv.a
{
  public String nxN;
  public LinkedList<za> sEJ = new LinkedList();
  public String sKU;
  public String sXL;
  public long sXM;
  public long sXN;
  public String sXO;
  public long sXP;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sXL != null) {
        paramVarArgs.d(1, this.sXL);
      }
      paramVarArgs.d(2, 8, this.sEJ);
      paramVarArgs.Y(3, this.sXM);
      paramVarArgs.Y(4, this.sXN);
      if (this.sXO != null) {
        paramVarArgs.d(5, this.sXO);
      }
      if (this.nxN != null) {
        paramVarArgs.d(6, this.nxN);
      }
      paramVarArgs.Y(7, this.sXP);
      if (this.sKU != null) {
        paramVarArgs.d(8, this.sKU);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sXL == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = d.a.a.b.b.a.e(1, this.sXL) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.c(2, 8, this.sEJ) + d.a.a.a.X(3, this.sXM) + d.a.a.a.X(4, this.sXN);
      paramInt = i;
      if (this.sXO != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sXO);
      }
      i = paramInt;
      if (this.nxN != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.nxN);
      }
      i += d.a.a.a.X(7, this.sXP);
      paramInt = i;
      if (this.sKU != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sKU);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sEJ.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        yz localyz = (yz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localyz.sXL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new za();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((za)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localyz.sEJ.add(localObject1);
            paramInt += 1;
          }
        case 3: 
          localyz.sXM = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 4: 
          localyz.sXN = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 5: 
          localyz.sXO = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localyz.nxN = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localyz.sXP = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        }
        localyz.sKU = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.yz
 * JD-Core Version:    0.7.0.1
 */