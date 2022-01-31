package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class nq
  extends blm
{
  public String desc;
  public LinkedList<Integer> sKI = new LinkedList();
  public boolean sLj;
  public boolean sLk;
  
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
      paramVarArgs.d(2, 2, this.sKI);
      if (this.desc != null) {
        paramVarArgs.d(3, this.desc);
      }
      paramVarArgs.aA(4, this.sLj);
      paramVarArgs.aA(5, this.sLk);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label446;
      }
    }
    label446:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.c(2, 2, this.sKI);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.desc);
      }
      return paramInt + (d.a.a.b.b.a.dQ(4) + 1) + (d.a.a.b.b.a.dQ(5) + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sKI.clear();
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
        nq localnq = (nq)paramVarArgs[1];
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
            localnq.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localnq.sKI.add(Integer.valueOf(((d.a.a.a.a)localObject1).xpH.oD()));
          return 0;
        case 3: 
          localnq.desc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localnq.sLj = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        }
        localnq.sLk = ((d.a.a.a.a)localObject1).cUr();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.nq
 * JD-Core Version:    0.7.0.1
 */