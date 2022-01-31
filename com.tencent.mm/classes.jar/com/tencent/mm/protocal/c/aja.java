package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class aja
  extends blm
{
  public int hQQ;
  public String tfK;
  public String tfL;
  
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
      if (this.tfK != null) {
        paramVarArgs.d(2, this.tfK);
      }
      paramVarArgs.gB(3, this.hQQ);
      if (this.tfL != null) {
        paramVarArgs.d(4, this.tfL);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tfK != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.tfK);
      }
      i += d.a.a.a.gy(3, this.hQQ);
      paramInt = i;
      if (this.tfL != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tfL);
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
        aja localaja = (aja)paramVarArgs[1];
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
            localaja.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaja.tfK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localaja.hQQ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localaja.tfL = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aja
 * JD-Core Version:    0.7.0.1
 */