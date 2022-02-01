package com.tencent.mm.e.a;

public final class q
  extends com.tencent.mm.d.a
{
  public long XJ;
  public boolean XN;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.g(1, this.XJ);
      paramVarArgs.h(2, this.XN);
      return 0;
    }
    if (paramInt == 1) {
      return a.a.a.b.b.a.f(1, this.XJ) + 0 + (a.a.a.b.b.a.cK(2) + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Xe);
      for (paramInt = paramVarArgs.pl(); paramInt > 0; paramInt = paramVarArgs.pl()) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.pm();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      q localq = (q)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localq.XJ = locala.pj();
        return 0;
      }
      localq.XN = locala.pi();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.q
 * JD-Core Version:    0.7.0.1
 */