package com.tencent.mm.e.a;

import java.util.LinkedList;

public final class z
  extends com.tencent.mm.d.a
{
  public boolean XV;
  public LinkedList<s> XW = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.h(1, this.XV);
      paramVarArgs.b(2, 8, this.XW);
      return 0;
    }
    if (paramInt == 1) {
      return a.a.a.b.b.a.cK(1) + 1 + 0 + a.a.a.a.a(2, 8, this.XW);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.XW.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, Xe);
      for (paramInt = paramVarArgs.pl(); paramInt > 0; paramInt = paramVarArgs.pl()) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.pm();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      z localz = (z)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localz.XV = ((a.a.a.a.a)localObject1).pi();
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).cE(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new s();
        localObject2 = new a.a.a.a.a((byte[])localObject2, Xe);
        for (boolean bool = true; bool; bool = ((s)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.d.a)localObject1, ((a.a.a.a.a)localObject2).pl())) {}
        localz.XW.add(localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.z
 * JD-Core Version:    0.7.0.1
 */