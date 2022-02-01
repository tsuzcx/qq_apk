package com.tencent.mm.e.a;

import java.util.LinkedList;

public final class ae
  extends com.tencent.mm.d.a
{
  public boolean XV;
  public int Yl;
  public LinkedList<c> Ym = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.b(1, 8, this.Ym);
      paramVarArgs.at(2, this.Yl);
      paramVarArgs.h(3, this.XV);
      return 0;
    }
    if (paramInt == 1) {
      return a.a.a.a.a(1, 8, this.Ym) + 0 + a.a.a.a.an(2, this.Yl) + (a.a.a.b.b.a.cK(3) + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Ym.clear();
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
      ae localae = (ae)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).cE(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new c();
          localObject2 = new a.a.a.a.a((byte[])localObject2, Xe);
          for (boolean bool = true; bool; bool = ((c)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.d.a)localObject1, ((a.a.a.a.a)localObject2).pl())) {}
          localae.Ym.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 2: 
        localae.Yl = ((a.a.a.a.a)localObject1).pg();
        return 0;
      }
      localae.XV = ((a.a.a.a.a)localObject1).pi();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.ae
 * JD-Core Version:    0.7.0.1
 */