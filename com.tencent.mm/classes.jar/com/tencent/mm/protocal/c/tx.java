package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class tx
  extends com.tencent.mm.bv.a
{
  public String ilq;
  public int sQK;
  public LinkedList<ra> sQL = new LinkedList();
  public String title;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.ilq != null) {
        paramVarArgs.d(2, this.ilq);
      }
      paramVarArgs.gB(3, this.sQK);
      paramVarArgs.d(4, 8, this.sQL);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = d.a.a.b.b.a.e(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ilq != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.ilq);
      }
      return i + d.a.a.a.gy(3, this.sQK) + d.a.a.a.c(4, 8, this.sQL);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sQL.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        tx localtx = (tx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localtx.title = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localtx.ilq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localtx.sQK = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ra();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ra)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localtx.sQL.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.tx
 * JD-Core Version:    0.7.0.1
 */