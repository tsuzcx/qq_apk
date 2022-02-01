package com.tencent.mm.e.a;

import a.a.a.b;

public final class k
  extends com.tencent.mm.d.a
{
  public int Xq;
  public String Xv;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.Xv == null) {
        throw new b("Not all required fields were included: Data");
      }
      paramVarArgs.at(1, this.Xq);
      if (this.Xv != null) {
        paramVarArgs.d(2, this.Xv);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = a.a.a.a.an(1, this.Xq) + 0;
      paramInt = i;
    } while (this.Xv == null);
    return i + a.a.a.b.b.a.e(2, this.Xv);
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Xe);
      for (paramInt = paramVarArgs.pl(); paramInt > 0; paramInt = paramVarArgs.pl()) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.pm();
        }
      }
      if (this.Xv == null) {
        throw new b("Not all required fields were included: Data");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      k localk = (k)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localk.Xq = locala.pg();
        return 0;
      }
      localk.Xv = locala.ph();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.k
 * JD-Core Version:    0.7.0.1
 */