package com.tencent.mm.e.a;

import a.a.a.b;

public final class f
  extends com.tencent.mm.d.a
{
  public String Xo;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.Xo == null) {
        throw new b("Not all required fields were included: ProductId");
      }
      if (this.Xo != null) {
        paramVarArgs.d(1, this.Xo);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.Xo == null) {
        break label203;
      }
    }
    label203:
    for (paramInt = a.a.a.b.b.a.e(1, this.Xo) + 0;; paramInt = 0)
    {
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Xe);
        for (paramInt = paramVarArgs.pl(); paramInt > 0; paramInt = paramVarArgs.pl()) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.pm();
          }
        }
        if (this.Xo != null) {
          break;
        }
        throw new b("Not all required fields were included: ProductId");
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        }
        localf.Xo = locala.ph();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.f
 * JD-Core Version:    0.7.0.1
 */