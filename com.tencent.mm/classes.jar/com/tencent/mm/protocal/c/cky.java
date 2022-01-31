package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cky
  extends bly
{
  public int sDT;
  public String sEb;
  public int tHX;
  public int tpP;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sEb == null) {
        throw new b("Not all required fields were included: Json");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.tpP);
      paramVarArgs.gB(3, this.sDT);
      if (this.sEb != null) {
        paramVarArgs.d(4, this.sEb);
      }
      paramVarArgs.gB(5, this.tHX);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label473;
      }
    }
    label473:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tpP) + d.a.a.a.gy(3, this.sDT);
      paramInt = i;
      if (this.sEb != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sEb);
      }
      return paramInt + d.a.a.a.gy(5, this.tHX);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sEb != null) {
          break;
        }
        throw new b("Not all required fields were included: Json");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cky localcky = (cky)paramVarArgs[1];
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
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localcky.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcky.tpP = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localcky.sDT = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localcky.sEb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localcky.tHX = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cky
 * JD-Core Version:    0.7.0.1
 */