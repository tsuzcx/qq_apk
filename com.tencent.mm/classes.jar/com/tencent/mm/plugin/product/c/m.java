package com.tencent.mm.plugin.product.c;

import java.util.LinkedList;

public final class m
  extends com.tencent.mm.bv.a
{
  public String mSZ;
  public String mTa;
  public LinkedList<h> mTb = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.mSZ != null) {
        paramVarArgs.d(1, this.mSZ);
      }
      if (this.mTa != null) {
        paramVarArgs.d(2, this.mTa);
      }
      paramVarArgs.d(3, 8, this.mTb);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mSZ == null) {
        break label367;
      }
    }
    label367:
    for (paramInt = d.a.a.b.b.a.e(1, this.mSZ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mTa != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.mTa);
      }
      return i + d.a.a.a.c(3, 8, this.mTb);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.mTb.clear();
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
        m localm = (m)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localm.mSZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localm.mTa = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new h();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((h)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localm.mTb.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.m
 * JD-Core Version:    0.7.0.1
 */