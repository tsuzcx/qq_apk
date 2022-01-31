package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class alw
  extends blm
{
  public String dRj;
  public String jFa;
  public boolean thT;
  public String thU;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.jFa == null) {
        throw new b("Not all required fields were included: appusername");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      paramVarArgs.aA(2, this.thT);
      if (this.dRj != null) {
        paramVarArgs.d(3, this.dRj);
      }
      if (this.jFa != null) {
        paramVarArgs.d(4, this.jFa);
      }
      if (this.thU != null) {
        paramVarArgs.d(5, this.thU);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label506;
      }
    }
    label506:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + (d.a.a.b.b.a.dQ(2) + 1);
      paramInt = i;
      if (this.dRj != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.dRj);
      }
      i = paramInt;
      if (this.jFa != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.jFa);
      }
      paramInt = i;
      if (this.thU != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.thU);
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
        if (this.jFa != null) {
          break;
        }
        throw new b("Not all required fields were included: appusername");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        alw localalw = (alw)paramVarArgs[1];
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
            localalw.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localalw.thT = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 3: 
          localalw.dRj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localalw.jFa = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localalw.thU = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.alw
 * JD-Core Version:    0.7.0.1
 */