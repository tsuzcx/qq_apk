package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bhq
  extends blm
{
  public String sFw;
  public boolean tCo;
  public int tCp;
  
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
      if (this.sFw != null) {
        paramVarArgs.d(2, this.sFw);
      }
      paramVarArgs.aA(3, this.tCo);
      paramVarArgs.gB(4, this.tCp);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label395;
      }
    }
    label395:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sFw != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.sFw);
      }
      return i + (d.a.a.b.b.a.dQ(3) + 1) + d.a.a.a.gy(4, this.tCp);
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
        bhq localbhq = (bhq)paramVarArgs[1];
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
            localbhq.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbhq.sFw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbhq.tCo = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        }
        localbhq.tCp = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bhq
 * JD-Core Version:    0.7.0.1
 */