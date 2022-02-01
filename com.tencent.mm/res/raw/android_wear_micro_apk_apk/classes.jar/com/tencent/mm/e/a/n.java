package com.tencent.mm.e.a;

import a.a.a.b;

public final class n
  extends com.tencent.mm.d.a
{
  public String XI;
  public long XJ;
  public String Xr;
  public String Xs;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.XI == null) {
        throw new b("Not all required fields were included: Talker");
      }
      if (this.Xr == null) {
        throw new b("Not all required fields were included: Title");
      }
      if (this.Xs == null) {
        throw new b("Not all required fields were included: Content");
      }
      if (this.XI != null) {
        paramVarArgs.d(1, this.XI);
      }
      if (this.Xr != null) {
        paramVarArgs.d(2, this.Xr);
      }
      if (this.Xs != null) {
        paramVarArgs.d(3, this.Xs);
      }
      paramVarArgs.g(4, this.XJ);
      return 0;
    }
    if (paramInt == 1) {
      if (this.XI == null) {
        break label412;
      }
    }
    label412:
    for (int i = a.a.a.b.b.a.e(1, this.XI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Xr != null) {
        paramInt = i + a.a.a.b.b.a.e(2, this.Xr);
      }
      i = paramInt;
      if (this.Xs != null) {
        i = paramInt + a.a.a.b.b.a.e(3, this.Xs);
      }
      return i + a.a.a.b.b.a.f(4, this.XJ);
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
        if (this.Xr == null) {
          throw new b("Not all required fields were included: Title");
        }
        if (this.Xs != null) {
          break;
        }
        throw new b("Not all required fields were included: Content");
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localn.XI = locala.ph();
          return 0;
        case 2: 
          localn.Xr = locala.ph();
          return 0;
        case 3: 
          localn.Xs = locala.ph();
          return 0;
        }
        localn.XJ = locala.pj();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.n
 * JD-Core Version:    0.7.0.1
 */