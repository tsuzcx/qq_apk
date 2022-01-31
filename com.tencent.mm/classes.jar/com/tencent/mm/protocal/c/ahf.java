package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ahf
  extends blm
{
  public int Height;
  public int Width;
  public String jxi;
  public float sGJ;
  public float sGK;
  public int teV;
  public int teW;
  
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
      paramVarArgs.m(2, this.sGJ);
      paramVarArgs.m(3, this.sGK);
      paramVarArgs.gB(4, this.Width);
      paramVarArgs.gB(5, this.Height);
      if (this.jxi != null) {
        paramVarArgs.d(6, this.jxi);
      }
      paramVarArgs.gB(7, this.teV);
      paramVarArgs.gB(8, this.teW);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + (d.a.a.b.b.a.dQ(2) + 4) + (d.a.a.b.b.a.dQ(3) + 4) + d.a.a.a.gy(4, this.Width) + d.a.a.a.gy(5, this.Height);
      paramInt = i;
      if (this.jxi != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.jxi);
      }
      return paramInt + d.a.a.a.gy(7, this.teV) + d.a.a.a.gy(8, this.teW);
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
        ahf localahf = (ahf)paramVarArgs[1];
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
            localahf.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localahf.sGJ = ((d.a.a.a.a)localObject1).xpH.readFloat();
          return 0;
        case 3: 
          localahf.sGK = ((d.a.a.a.a)localObject1).xpH.readFloat();
          return 0;
        case 4: 
          localahf.Width = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localahf.Height = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localahf.jxi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localahf.teV = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localahf.teW = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ahf
 * JD-Core Version:    0.7.0.1
 */