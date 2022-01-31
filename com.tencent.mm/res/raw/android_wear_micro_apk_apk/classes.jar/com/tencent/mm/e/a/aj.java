package com.tencent.mm.e.a;

import a.a.a.b;

public final class aj
  extends com.tencent.mm.d.a
{
  public String Wv;
  public String Ww;
  public String Wx;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.Wv == null) {
        throw new b("Not all required fields were included: Plugin");
      }
      if (this.Ww == null) {
        throw new b("Not all required fields were included: ActivityPath");
      }
      if (this.Wv != null) {
        paramVarArgs.d(1, this.Wv);
      }
      if (this.Ww != null) {
        paramVarArgs.d(2, this.Ww);
      }
      if (this.Wx != null) {
        paramVarArgs.d(3, this.Wx);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.Wv == null) {
        break label344;
      }
    }
    label344:
    for (int i = a.a.a.b.b.a.e(1, this.Wv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ww != null) {
        paramInt = i + a.a.a.b.b.a.e(2, this.Ww);
      }
      i = paramInt;
      if (this.Wx != null) {
        i = paramInt + a.a.a.b.b.a.e(3, this.Wx);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Vj);
        for (paramInt = paramVarArgs.oy(); paramInt > 0; paramInt = paramVarArgs.oy()) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.oz();
          }
        }
        if (this.Wv == null) {
          throw new b("Not all required fields were included: Plugin");
        }
        if (this.Ww != null) {
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
          localaj.Wv = locala.ou();
          return 0;
        case 2: 
          localaj.Ww = locala.ou();
          return 0;
        }
        localaj.Wx = locala.ou();
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