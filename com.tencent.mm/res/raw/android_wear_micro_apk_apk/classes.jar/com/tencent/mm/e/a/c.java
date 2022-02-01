package com.tencent.mm.e.a;

import a.a.a.b;

public final class c
  extends com.tencent.mm.d.a
{
  public String Xj;
  public String Xk;
  public int Xl;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.Xj == null) {
        throw new b("Not all required fields were included: UserName");
      }
      if (this.Xk == null) {
        throw new b("Not all required fields were included: NickName");
      }
      if (this.Xj != null) {
        paramVarArgs.d(1, this.Xj);
      }
      if (this.Xk != null) {
        paramVarArgs.d(2, this.Xk);
      }
      paramVarArgs.at(3, this.Xl);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Xj == null) {
        break label324;
      }
    }
    label324:
    for (paramInt = a.a.a.b.b.a.e(1, this.Xj) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Xk != null) {
        i = paramInt + a.a.a.b.b.a.e(2, this.Xk);
      }
      return i + a.a.a.a.an(3, this.Xl);
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Xe);
        for (paramInt = paramVarArgs.pl(); paramInt > 0; paramInt = paramVarArgs.pl()) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.pm();
          }
        }
        if (this.Xj == null) {
          throw new b("Not all required fields were included: UserName");
        }
        if (this.Xk != null) {
          break;
        }
        throw new b("Not all required fields were included: NickName");
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localc.Xj = locala.ph();
          return 0;
        case 2: 
          localc.Xk = locala.ph();
          return 0;
        }
        localc.Xl = locala.pg();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.c
 * JD-Core Version:    0.7.0.1
 */