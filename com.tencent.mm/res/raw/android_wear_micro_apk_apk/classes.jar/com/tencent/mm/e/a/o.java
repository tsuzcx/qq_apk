package com.tencent.mm.e.a;

import a.a.a.b;
import java.util.LinkedList;

public final class o
  extends com.tencent.mm.d.a
{
  public long VO;
  public long VP;
  public String VQ;
  public LinkedList<p> VR = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.VQ == null) {
        throw new b("Not all required fields were included: TotalMsg");
      }
      paramVarArgs.g(1, this.VP);
      paramVarArgs.g(2, this.VO);
      if (this.VQ != null) {
        paramVarArgs.d(3, this.VQ);
      }
      paramVarArgs.b(4, 8, this.VR);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.e(1, this.VP) + 0 + a.a.a.a.e(2, this.VO);
      paramInt = i;
      if (this.VQ != null) {
        paramInt = i + a.a.a.b.b.a.e(3, this.VQ);
      }
      return paramInt + a.a.a.a.a(4, 8, this.VR);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.VR.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, Vj);
      for (paramInt = paramVarArgs.oy(); paramInt > 0; paramInt = paramVarArgs.oy()) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.oz();
        }
      }
      if (this.VQ == null) {
        throw new b("Not all required fields were included: TotalMsg");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      o localo = (o)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localo.VP = ((a.a.a.a.a)localObject1).ow();
        return 0;
      case 2: 
        localo.VO = ((a.a.a.a.a)localObject1).ow();
        return 0;
      case 3: 
        localo.VQ = ((a.a.a.a.a)localObject1).ou();
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).ci(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new p();
        localObject2 = new a.a.a.a.a((byte[])localObject2, Vj);
        for (boolean bool = true; bool; bool = ((p)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.d.a)localObject1, ((a.a.a.a.a)localObject2).oy())) {}
        localo.VR.add(localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.o
 * JD-Core Version:    0.7.0.1
 */