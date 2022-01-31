package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bjr
  extends com.tencent.mm.bv.a
{
  public bml tDu;
  public int tDv;
  public LinkedList<boe> tDw = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tDu == null) {
        throw new b("Not all required fields were included: GroupName");
      }
      if (this.tDu != null)
      {
        paramVarArgs.gD(1, this.tDu.btq());
        this.tDu.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.tDv);
      paramVarArgs.d(3, 8, this.tDw);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tDu == null) {
        break label473;
      }
    }
    label473:
    for (paramInt = d.a.a.a.gA(1, this.tDu.btq()) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.tDv) + d.a.a.a.c(3, 8, this.tDw);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tDw.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tDu != null) {
          break;
        }
        throw new b("Not all required fields were included: GroupName");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bjr localbjr = (bjr)paramVarArgs[1];
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
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbjr.tDu = ((bml)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbjr.tDv = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new boe();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((boe)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbjr.tDw.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bjr
 * JD-Core Version:    0.7.0.1
 */