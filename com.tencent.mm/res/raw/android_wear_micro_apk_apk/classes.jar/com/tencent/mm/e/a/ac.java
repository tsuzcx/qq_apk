package com.tencent.mm.e.a;

public final class ac
  extends com.tencent.mm.d.a
{
  public long XJ;
  public com.tencent.mm.d.b Yj;
  public int Yk;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.Yj == null) {
        throw new a.a.a.b("Not all required fields were included: VoiceData");
      }
      paramVarArgs.g(1, this.XJ);
      if (this.Yj != null) {
        paramVarArgs.c(2, this.Yj);
      }
      paramVarArgs.at(3, this.Yk);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.b.b.a.f(1, this.XJ) + 0;
      paramInt = i;
      if (this.Yj != null) {
        paramInt = i + a.a.a.b.b.a.b(2, this.Yj);
      }
      return paramInt + a.a.a.a.an(3, this.Yk);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Xe);
      for (paramInt = paramVarArgs.pl(); paramInt > 0; paramInt = paramVarArgs.pl()) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.pm();
        }
      }
      if (this.Yj == null) {
        throw new a.a.a.b("Not all required fields were included: VoiceData");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      ac localac = (ac)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localac.XJ = locala.pj();
        return 0;
      case 2: 
        localac.Yj = locala.pk();
        return 0;
      }
      localac.Yk = locala.pg();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.ac
 * JD-Core Version:    0.7.0.1
 */