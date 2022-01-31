package com.tencent.mm.e.a;

import a.a.a.b;

public final class f
  extends com.tencent.mm.d.a
{
  public String Vt;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.Vt == null) {
        throw new b("Not all required fields were included: ProductId");
      }
      if (this.Vt != null) {
        paramVarArgs.d(1, this.Vt);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.Vt == null) {
        break label203;
      }
    }
    label203:
    for (paramInt = a.a.a.b.b.a.e(1, this.Vt) + 0;; paramInt = 0)
    {
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Vj);
        for (paramInt = paramVarArgs.oy(); paramInt > 0; paramInt = paramVarArgs.oy()) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.oz();
          }
        }
        if (this.Vt != null) {
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
        localf.Vt = locala.ou();
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