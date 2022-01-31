package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class xf
  extends blm
{
  public int iHi;
  public int lPR;
  public double latitude;
  public double longitude;
  public int mUh;
  public int sTR;
  
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
      paramVarArgs.gB(2, this.iHi);
      paramVarArgs.gB(3, this.mUh);
      paramVarArgs.gB(4, this.lPR);
      paramVarArgs.gB(5, this.sTR);
      paramVarArgs.b(6, this.latitude);
      paramVarArgs.b(7, this.longitude);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label495;
      }
    }
    label495:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.iHi) + d.a.a.a.gy(3, this.mUh) + d.a.a.a.gy(4, this.lPR) + d.a.a.a.gy(5, this.sTR) + (d.a.a.b.b.a.dQ(6) + 8) + (d.a.a.b.b.a.dQ(7) + 8);
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
        xf localxf = (xf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          int i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localxf.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localxf.iHi = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localxf.mUh = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localxf.lPR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localxf.sTR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localxf.latitude = ((d.a.a.a.a)localObject1).xpH.readDouble();
          return 0;
        }
        localxf.longitude = ((d.a.a.a.a)localObject1).xpH.readDouble();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.xf
 * JD-Core Version:    0.7.0.1
 */