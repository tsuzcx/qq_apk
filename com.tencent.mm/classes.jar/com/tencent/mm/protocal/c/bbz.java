package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bbz
  extends blm
{
  public String sAT;
  public String txt;
  
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
      if (this.sAT != null) {
        paramVarArgs.d(2, this.sAT);
      }
      if (this.txt != null) {
        paramVarArgs.d(3, this.txt);
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
      if (this.sAT != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sAT);
      }
      i = paramInt;
      if (this.txt != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.txt);
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
        bbz localbbz = (bbz)paramVarArgs[1];
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
            localbbz.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbbz.sAT = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbbz.txt = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bbz
 * JD-Core Version:    0.7.0.1
 */