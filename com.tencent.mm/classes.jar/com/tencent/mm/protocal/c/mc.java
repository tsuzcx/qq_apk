package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class mc
  extends blm
{
  public float bRt;
  public float bTc;
  public String bZc;
  public String iln;
  
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
      if (this.iln != null) {
        paramVarArgs.d(2, this.iln);
      }
      paramVarArgs.m(3, this.bTc);
      paramVarArgs.m(4, this.bRt);
      if (this.bZc != null) {
        paramVarArgs.d(5, this.bZc);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label453;
      }
    }
    label453:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.iln != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.iln);
      }
      i = i + (d.a.a.b.b.a.dQ(3) + 4) + (d.a.a.b.b.a.dQ(4) + 4);
      paramInt = i;
      if (this.bZc != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.bZc);
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
        mc localmc = (mc)paramVarArgs[1];
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
            localmc.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localmc.iln = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localmc.bTc = ((d.a.a.a.a)localObject1).xpH.readFloat();
          return 0;
        case 4: 
          localmc.bRt = ((d.a.a.a.a)localObject1).xpH.readFloat();
          return 0;
        }
        localmc.bZc = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.mc
 * JD-Core Version:    0.7.0.1
 */