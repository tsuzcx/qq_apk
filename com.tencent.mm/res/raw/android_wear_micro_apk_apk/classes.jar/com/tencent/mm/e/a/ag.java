package com.tencent.mm.e.a;

import a.a.a.b;

public final class ag
  extends com.tencent.mm.d.a
{
  public String XI;
  public String Xm;
  public String Xo;
  public int Yn;
  public String Yo;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.XI == null) {
        throw new b("Not all required fields were included: Talker");
      }
      if (this.Yo == null) {
        throw new b("Not all required fields were included: Text");
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
      if (this.Yo != null) {
        paramVarArgs.d(2, this.Yo);
      }
      if (this.Xm != null) {
        paramVarArgs.d(3, this.Xm);
      }
      if (this.Xo != null) {
        paramVarArgs.d(4, this.Xo);
      }
      paramVarArgs.at(5, this.Yn);
      return 0;
    }
    if (paramInt == 1) {
      if (this.XI == null) {
        break label496;
      }
    }
    label496:
    for (int i = a.a.a.b.b.a.e(1, this.XI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Yo != null) {
        paramInt = i + a.a.a.b.b.a.e(2, this.Yo);
      }
      i = paramInt;
      if (this.Xm != null) {
        i = paramInt + a.a.a.b.b.a.e(3, this.Xm);
      }
      paramInt = i;
      if (this.Xo != null) {
        paramInt = i + a.a.a.b.b.a.e(4, this.Xo);
      }
      return paramInt + a.a.a.a.an(5, this.Yn);
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
        if (this.Yo == null) {
          throw new b("Not all required fields were included: Text");
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
        ag localag = (ag)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localag.XI = locala.ph();
          return 0;
        case 2: 
          localag.Yo = locala.ph();
          return 0;
        case 3: 
          localag.Xm = locala.ph();
          return 0;
        case 4: 
          localag.Xo = locala.ph();
          return 0;
        }
        localag.Yn = locala.pg();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.ag
 * JD-Core Version:    0.7.0.1
 */