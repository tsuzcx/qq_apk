package com.tencent.mm.e.a;

import a.a.a.b;

public final class af
  extends com.tencent.mm.d.a
{
  public String XI;
  public String Xm;
  public String Xo;
  public int Yn;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.XI == null) {
        throw new b("Not all required fields were included: Talker");
      }
      if (this.Xm == null) {
        throw new b("Not all required fields were included: MD5");
      }
      if (this.Xo == null) {
        throw new b("Not all required fields were included: ProductId");
      }
      if (this.XI != null) {
        paramVarArgs.d(1, this.XI);
      }
      if (this.Xm != null) {
        paramVarArgs.d(2, this.Xm);
      }
      if (this.Xo != null) {
        paramVarArgs.d(3, this.Xo);
      }
      paramVarArgs.at(4, this.Yn);
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
      if (this.Xm != null) {
        paramInt = i + a.a.a.b.b.a.e(2, this.Xm);
      }
      i = paramInt;
      if (this.Xo != null) {
        i = paramInt + a.a.a.b.b.a.e(3, this.Xo);
      }
      return i + a.a.a.a.an(4, this.Yn);
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
        if (this.Xm == null) {
          throw new b("Not all required fields were included: MD5");
        }
        if (this.Xo != null) {
          break;
        }
        throw new b("Not all required fields were included: ProductId");
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        af localaf = (af)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localaf.XI = locala.ph();
          return 0;
        case 2: 
          localaf.Xm = locala.ph();
          return 0;
        case 3: 
          localaf.Xo = locala.ph();
          return 0;
        }
        localaf.Yn = locala.pg();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.af
 * JD-Core Version:    0.7.0.1
 */