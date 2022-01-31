package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class anf
  extends blm
{
  public double tiZ;
  public double tja;
  public String tjb;
  public boolean tjc;
  
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
      paramVarArgs.b(2, this.tiZ);
      paramVarArgs.b(3, this.tja);
      if (this.tjb != null) {
        paramVarArgs.d(4, this.tjb);
      }
      paramVarArgs.aA(5, this.tjc);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label434;
      }
    }
    label434:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + (d.a.a.b.b.a.dQ(2) + 8) + (d.a.a.b.b.a.dQ(3) + 8);
      paramInt = i;
      if (this.tjb != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tjb);
      }
      return paramInt + (d.a.a.b.b.a.dQ(5) + 1);
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
        anf localanf = (anf)paramVarArgs[1];
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
            localanf.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localanf.tiZ = ((d.a.a.a.a)localObject1).xpH.readDouble();
          return 0;
        case 3: 
          localanf.tja = ((d.a.a.a.a)localObject1).xpH.readDouble();
          return 0;
        case 4: 
          localanf.tjb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localanf.tjc = ((d.a.a.a.a)localObject1).cUr();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.anf
 * JD-Core Version:    0.7.0.1
 */