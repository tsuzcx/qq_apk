package com.tencent.mm.e.a;

import a.a.a.b;

public final class p
  extends com.tencent.mm.d.a
{
  public String XI;
  public long XK;
  public String Xk;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.XI == null) {
        throw new b("Not all required fields were included: Talker");
      }
      if (this.Xk == null) {
        throw new b("Not all required fields were included: NickName");
      }
      if (this.XI != null) {
        paramVarArgs.d(1, this.XI);
      }
      if (this.Xk != null) {
        paramVarArgs.d(2, this.Xk);
      }
      paramVarArgs.g(3, this.XK);
      return 0;
    }
    if (paramInt == 1) {
      if (this.XI == null) {
        break label324;
      }
    }
    label324:
    for (paramInt = a.a.a.b.b.a.e(1, this.XI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Xk != null) {
        i = paramInt + a.a.a.b.b.a.e(2, this.Xk);
      }
      return i + a.a.a.b.b.a.f(3, this.XK);
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Xe);
        for (paramInt = paramVarArgs.pl(); paramInt > 0; paramInt = paramVarArgs.pl()) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.pm();
          }
        }
        if (this.XI == null) {
          throw new b("Not all required fields were included: Talker");
        }
        if (this.Xk != null) {
          break;
        }
        throw new b("Not all required fields were included: NickName");
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        p localp = (p)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localp.XI = locala.ph();
          return 0;
        case 2: 
          localp.Xk = locala.ph();
          return 0;
        }
        localp.XK = locala.pj();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.p
 * JD-Core Version:    0.7.0.1
 */