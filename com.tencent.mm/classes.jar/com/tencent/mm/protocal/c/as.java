package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class as
  extends com.tencent.mm.bv.a
{
  public String stX;
  public LinkedList<bby> stY = new LinkedList();
  public LinkedList<bbx> stZ = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.stX != null) {
        paramVarArgs.d(1, this.stX);
      }
      paramVarArgs.d(2, 8, this.stY);
      paramVarArgs.d(3, 8, this.stZ);
      return 0;
    }
    if (paramInt == 1) {
      if (this.stX == null) {
        break label441;
      }
    }
    label441:
    for (paramInt = d.a.a.b.b.a.e(1, this.stX) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.c(2, 8, this.stY) + d.a.a.a.c(3, 8, this.stZ);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.stY.clear();
        this.stZ.clear();
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
        as localas = (as)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localas.stX = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bby();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bby)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localas.stY.add(localObject1);
            paramInt += 1;
          }
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bbx();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bbx)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localas.stZ.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.as
 * JD-Core Version:    0.7.0.1
 */