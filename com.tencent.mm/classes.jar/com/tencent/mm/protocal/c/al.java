package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class al
  extends blm
{
  public int bZe;
  public String stb;
  public String stc;
  public int std;
  public LinkedList<lw> stg = new LinkedList();
  
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
      paramVarArgs.d(2, 8, this.stg);
      paramVarArgs.gB(3, this.bZe);
      if (this.stb != null) {
        paramVarArgs.d(4, this.stb);
      }
      if (this.stc != null) {
        paramVarArgs.d(5, this.stc);
      }
      paramVarArgs.gB(6, this.std);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.c(2, 8, this.stg) + d.a.a.a.gy(3, this.bZe);
      paramInt = i;
      if (this.stb != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.stb);
      }
      i = paramInt;
      if (this.stc != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.stc);
      }
      return i + d.a.a.a.gy(6, this.std);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.stg.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        al localal = (al)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
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
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localal.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new lw();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((lw)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localal.stg.add(localObject1);
            paramInt += 1;
          }
        case 3: 
          localal.bZe = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localal.stb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localal.stc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localal.std = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.al
 * JD-Core Version:    0.7.0.1
 */