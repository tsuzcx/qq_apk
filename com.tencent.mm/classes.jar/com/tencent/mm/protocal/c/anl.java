package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class anl
  extends blm
{
  public int aQw;
  public int condition;
  public int tjB;
  public int tjC;
  public int tjD;
  
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
      paramVarArgs.gB(2, this.aQw);
      paramVarArgs.gB(3, this.condition);
      paramVarArgs.gB(4, this.tjB);
      paramVarArgs.gB(5, this.tjC);
      paramVarArgs.gB(6, this.tjD);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label460;
      }
    }
    label460:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.aQw) + d.a.a.a.gy(3, this.condition) + d.a.a.a.gy(4, this.tjB) + d.a.a.a.gy(5, this.tjC) + d.a.a.a.gy(6, this.tjD);
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
        anl localanl = (anl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          int i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localanl.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localanl.aQw = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localanl.condition = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localanl.tjB = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localanl.tjC = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localanl.tjD = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.anl
 * JD-Core Version:    0.7.0.1
 */