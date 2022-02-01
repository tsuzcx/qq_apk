package com.tencent.mm.e.a;

import a.a.a.b;
import java.util.LinkedList;

public final class o
  extends com.tencent.mm.d.a
{
  public long XJ;
  public long XK;
  public String XL;
  public LinkedList<p> XM = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.XL == null) {
        throw new b("Not all required fields were included: TotalMsg");
      }
      paramVarArgs.g(1, this.XK);
      paramVarArgs.g(2, this.XJ);
      if (this.XL != null) {
        paramVarArgs.d(3, this.XL);
      }
      paramVarArgs.b(4, 8, this.XM);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.b.b.a.f(1, this.XK) + 0 + a.a.a.b.b.a.f(2, this.XJ);
      paramInt = i;
      if (this.XL != null) {
        paramInt = i + a.a.a.b.b.a.e(3, this.XL);
      }
      return paramInt + a.a.a.a.a(4, 8, this.XM);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.XM.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, Xe);
      for (paramInt = paramVarArgs.pl(); paramInt > 0; paramInt = paramVarArgs.pl()) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.pm();
        }
      }
      if (this.XL == null) {
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
        localo.XK = ((a.a.a.a.a)localObject1).pj();
        return 0;
      case 2: 
        localo.XJ = ((a.a.a.a.a)localObject1).pj();
        return 0;
      case 3: 
        localo.XL = ((a.a.a.a.a)localObject1).ph();
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).cE(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new p();
        localObject2 = new a.a.a.a.a((byte[])localObject2, Xe);
        for (boolean bool = true; bool; bool = ((p)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.d.a)localObject1, ((a.a.a.a.a)localObject2).pl())) {}
        localo.XM.add(localObject1);
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