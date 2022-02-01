package com.tencent.mm.e.a;

import a.a.a.b;

public final class aj
  extends com.tencent.mm.d.a
{
  public String Yq;
  public String Yr;
  public String Ys;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.Yq == null) {
        throw new b("Not all required fields were included: Plugin");
      }
      if (this.Yr == null) {
        throw new b("Not all required fields were included: ActivityPath");
      }
      if (this.Yq != null) {
        paramVarArgs.d(1, this.Yq);
      }
      if (this.Yr != null) {
        paramVarArgs.d(2, this.Yr);
      }
      if (this.Ys != null) {
        paramVarArgs.d(3, this.Ys);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.Yq == null) {
        break label344;
      }
    }
    label344:
    for (int i = a.a.a.b.b.a.e(1, this.Yq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Yr != null) {
        paramInt = i + a.a.a.b.b.a.e(2, this.Yr);
      }
      i = paramInt;
      if (this.Ys != null) {
        i = paramInt + a.a.a.b.b.a.e(3, this.Ys);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Xe);
        for (paramInt = paramVarArgs.pl(); paramInt > 0; paramInt = paramVarArgs.pl()) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.pm();
          }
        }
        if (this.Yq == null) {
          throw new b("Not all required fields were included: Plugin");
        }
        if (this.Yr != null) {
          break;
        }
        throw new b("Not all required fields were included: ActivityPath");
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        aj localaj = (aj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localaj.Yq = locala.ph();
          return 0;
        case 2: 
          localaj.Yr = locala.ph();
          return 0;
        }
        localaj.Ys = locala.ph();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.aj
 * JD-Core Version:    0.7.0.1
 */