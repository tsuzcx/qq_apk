package com.tencent.mm.plugin.product.c;

import java.util.LinkedList;

public final class f
  extends com.tencent.mm.bv.a
{
  public j mSS;
  public String mST;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.mSS != null)
      {
        paramVarArgs.gD(1, this.mSS.btq());
        this.mSS.a(paramVarArgs);
      }
      if (this.mST != null) {
        paramVarArgs.d(2, this.mST);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.mSS == null) {
        break label328;
      }
    }
    label328:
    for (paramInt = d.a.a.a.gA(1, this.mSS.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mST != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.mST);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
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
        f localf = (f)paramVarArgs[1];
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
            localObject1 = new j();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((j)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localf.mSS = ((j)localObject1);
            paramInt += 1;
          }
        }
        localf.mST = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.f
 * JD-Core Version:    0.7.0.1
 */