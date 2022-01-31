package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class amp
  extends blm
{
  public String tiu;
  public String tiv;
  
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
      if (this.tiu != null) {
        paramVarArgs.d(2, this.tiu);
      }
      if (this.tiv != null) {
        paramVarArgs.d(3, this.tiv);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label383;
      }
    }
    label383:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tiu != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tiu);
      }
      i = paramInt;
      if (this.tiv != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tiv);
      }
      return i;
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
        amp localamp = (amp)paramVarArgs[1];
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
            localamp.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localamp.tiu = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localamp.tiv = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.amp
 * JD-Core Version:    0.7.0.1
 */