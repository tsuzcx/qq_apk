package com.tencent.mm.e.a;

public final class ak
  extends com.tencent.mm.d.a
{
  public int Yt;
  public long Yu;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.at(1, this.Yt);
      paramVarArgs.g(2, this.Yu);
      return 0;
    }
    if (paramInt == 1) {
      return a.a.a.a.an(1, this.Yt) + 0 + a.a.a.b.b.a.f(2, this.Yu);
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
      ak localak = (ak)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localak.Yt = locala.pg();
        return 0;
      }
      localak.Yu = locala.pj();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.ak
 * JD-Core Version:    0.7.0.1
 */