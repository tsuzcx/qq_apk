package com.tencent.mm.e.a;

import a.a.a.b;

public final class t
  extends com.tencent.mm.d.a
{
  public long XT;
  public boolean XU;
  public String Xh;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.Xh == null) {
        throw new b("Not all required fields were included: Username");
      }
      if (this.Xh != null) {
        paramVarArgs.d(1, this.Xh);
      }
      paramVarArgs.g(2, this.XT);
      paramVarArgs.h(3, this.XU);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Xh == null) {
        break label269;
      }
    }
    label269:
    for (paramInt = a.a.a.b.b.a.e(1, this.Xh) + 0;; paramInt = 0)
    {
      return paramInt + a.a.a.b.b.a.f(2, this.XT) + (a.a.a.b.b.a.cK(3) + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Xe);
        for (paramInt = paramVarArgs.pl(); paramInt > 0; paramInt = paramVarArgs.pl()) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.pm();
          }
        }
        if (this.Xh != null) {
          break;
        }
        throw new b("Not all required fields were included: Username");
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        t localt = (t)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localt.Xh = locala.ph();
          return 0;
        case 2: 
          localt.XT = locala.pj();
          return 0;
        }
        localt.XU = locala.pi();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.t
 * JD-Core Version:    0.7.0.1
 */