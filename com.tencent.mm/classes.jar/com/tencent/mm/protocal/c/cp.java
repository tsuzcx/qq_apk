package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cp
  extends com.tencent.mm.bv.a
{
  public String swi;
  public LinkedList<bvu> swj = new LinkedList();
  public String title;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.swi != null) {
        paramVarArgs.d(1, this.swi);
      }
      paramVarArgs.d(2, 8, this.swj);
      if (this.title != null) {
        paramVarArgs.d(3, this.title);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.swi == null) {
        break label367;
      }
    }
    label367:
    for (paramInt = d.a.a.b.b.a.e(1, this.swi) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.c(2, 8, this.swj);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.title);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.swj.clear();
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
        cp localcp = (cp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localcp.swi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvu();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bvu)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcp.swj.add(localObject1);
            paramInt += 1;
          }
        }
        localcp.title = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cp
 * JD-Core Version:    0.7.0.1
 */