package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class wx
  extends blm
{
  public String lMg;
  public double latitude;
  public double longitude;
  
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
      if (this.lMg != null) {
        paramVarArgs.d(2, this.lMg);
      }
      paramVarArgs.b(3, this.latitude);
      paramVarArgs.b(4, this.longitude);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lMg != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.lMg);
      }
      return i + (d.a.a.b.b.a.dQ(3) + 8) + (d.a.a.b.b.a.dQ(4) + 8);
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
        wx localwx = (wx)paramVarArgs[1];
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
            localwx.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localwx.lMg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localwx.latitude = ((d.a.a.a.a)localObject1).xpH.readDouble();
          return 0;
        }
        localwx.longitude = ((d.a.a.a.a)localObject1).xpH.readDouble();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.wx
 * JD-Core Version:    0.7.0.1
 */