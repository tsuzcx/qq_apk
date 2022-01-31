package com.tencent.mm.e.a;

import java.util.LinkedList;

public final class ae
  extends com.tencent.mm.d.a
{
  public boolean Wa;
  public int Wq;
  public LinkedList<c> Wr = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.b(1, 8, this.Wr);
      paramVarArgs.aq(2, this.Wq);
      paramVarArgs.g(3, this.Wa);
      return 0;
    }
    if (paramInt == 1) {
      return a.a.a.a.a(1, 8, this.Wr) + 0 + a.a.a.a.ak(2, this.Wq) + (a.a.a.b.b.a.cp(3) + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Wr.clear();
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
      ae localae = (ae)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).ci(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new c();
          localObject2 = new a.a.a.a.a((byte[])localObject2, Vj);
          for (boolean bool = true; bool; bool = ((c)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.d.a)localObject1, ((a.a.a.a.a)localObject2).oy())) {}
          localae.Wr.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 2: 
        localae.Wq = ((a.a.a.a.a)localObject1).ot();
        return 0;
      }
      localae.Wa = ((a.a.a.a.a)localObject1).ov();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.ae
 * JD-Core Version:    0.7.0.1
 */