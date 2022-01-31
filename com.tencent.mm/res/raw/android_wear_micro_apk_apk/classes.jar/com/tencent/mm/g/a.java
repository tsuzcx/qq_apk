package com.tencent.mm.g;

import java.util.LinkedList;

public final class a
  extends com.tencent.mm.d.a
{
  public LinkedList<c> Yq = new LinkedList();
  public LinkedList<b> Yr = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.b(3, 8, this.Yq);
      paramVarArgs.b(4, 8, this.Yr);
      return 0;
    }
    if (paramInt == 1) {
      return a.a.a.a.a(3, 8, this.Yq) + 0 + a.a.a.a.a(4, 8, this.Yr);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Yq.clear();
      this.Yr.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, Vj);
      for (paramInt = paramVarArgs.oy(); paramInt > 0; paramInt = paramVarArgs.oy()) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.oz();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      a locala = (a)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).ci(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new c();
          localObject2 = new a.a.a.a.a((byte[])localObject2, Vj);
          for (bool = true; bool; bool = ((c)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.d.a)localObject1, ((a.a.a.a.a)localObject2).oy())) {}
          locala.Yq.add(localObject1);
          paramInt += 1;
        }
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).ci(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new b();
        localObject2 = new a.a.a.a.a((byte[])localObject2, Vj);
        for (bool = true; bool; bool = ((b)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.d.a)localObject1, ((a.a.a.a.a)localObject2).oy())) {}
        locala.Yr.add(localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.g.a
 * JD-Core Version:    0.7.0.1
 */