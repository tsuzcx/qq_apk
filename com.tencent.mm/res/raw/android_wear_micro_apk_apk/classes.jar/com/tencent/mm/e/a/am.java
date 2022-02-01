package com.tencent.mm.e.a;

import a.a.a.b;

public final class am
  extends com.tencent.mm.d.a
{
  public String XI;
  public String Yo;
  public boolean Yy;
  public int Yz;
  
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
      if (this.XI != null) {
        paramVarArgs.d(1, this.XI);
      }
      if (this.Yo != null) {
        paramVarArgs.d(2, this.Yo);
      }
      paramVarArgs.h(3, this.Yy);
      paramVarArgs.at(4, this.Yz);
      return 0;
    }
    if (paramInt == 1) {
      if (this.XI == null) {
        break label356;
      }
    }
    label356:
    for (paramInt = a.a.a.b.b.a.e(1, this.XI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Yo != null) {
        i = paramInt + a.a.a.b.b.a.e(2, this.Yo);
      }
      return i + (a.a.a.b.b.a.cK(3) + 1) + a.a.a.a.an(4, this.Yz);
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
        if (this.Yo != null) {
          break;
        }
        throw new b("Not all required fields were included: Text");
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        am localam = (am)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localam.XI = locala.ph();
          return 0;
        case 2: 
          localam.Yo = locala.ph();
          return 0;
        case 3: 
          localam.Yy = locala.pi();
          return 0;
        }
        localam.Yz = locala.pg();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.am
 * JD-Core Version:    0.7.0.1
 */