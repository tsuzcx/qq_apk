package com.tencent.mm.e.a;

import a.a.a.b;

public final class h
  extends com.tencent.mm.d.a
{
  public int Xq;
  public String Xr;
  public String Xs;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.Xr == null) {
        throw new b("Not all required fields were included: Title");
      }
      if (this.Xs == null) {
        throw new b("Not all required fields were included: Content");
      }
      paramVarArgs.at(1, this.Xq);
      if (this.Xr != null) {
        paramVarArgs.d(2, this.Xr);
      }
      if (this.Xs != null) {
        paramVarArgs.d(3, this.Xs);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = a.a.a.a.an(1, this.Xq) + 0;
      paramInt = i;
      if (this.Xr != null) {
        paramInt = i + a.a.a.b.b.a.e(2, this.Xr);
      }
      i = paramInt;
    } while (this.Xs == null);
    return paramInt + a.a.a.b.b.a.e(3, this.Xs);
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Xe);
      for (paramInt = paramVarArgs.pl(); paramInt > 0; paramInt = paramVarArgs.pl()) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.pm();
        }
      }
      if (this.Xr == null) {
        throw new b("Not all required fields were included: Title");
      }
      if (this.Xs == null) {
        throw new b("Not all required fields were included: Content");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      h localh = (h)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localh.Xq = locala.pg();
        return 0;
      case 2: 
        localh.Xr = locala.ph();
        return 0;
      }
      localh.Xs = locala.ph();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.h
 * JD-Core Version:    0.7.0.1
 */