package com.tencent.mm.e.a;

public final class ai
  extends com.tencent.mm.d.a
{
  public String XI;
  public com.tencent.mm.d.b Yj;
  public int Yn;
  public long Yp;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.XI == null) {
        throw new a.a.a.b("Not all required fields were included: Talker");
      }
      if (this.Yj == null) {
        throw new a.a.a.b("Not all required fields were included: VoiceData");
      }
      if (this.XI != null) {
        paramVarArgs.d(1, this.XI);
      }
      paramVarArgs.g(2, this.Yp);
      if (this.Yj != null) {
        paramVarArgs.c(3, this.Yj);
      }
      paramVarArgs.at(4, this.Yn);
      return 0;
    }
    if (paramInt == 1) {
      if (this.XI == null) {
        break label360;
      }
    }
    label360:
    for (paramInt = a.a.a.b.b.a.e(1, this.XI) + 0;; paramInt = 0)
    {
      int i = paramInt + a.a.a.b.b.a.f(2, this.Yp);
      paramInt = i;
      if (this.Yj != null) {
        paramInt = i + a.a.a.b.b.a.b(3, this.Yj);
      }
      return paramInt + a.a.a.a.an(4, this.Yn);
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Xe);
        for (paramInt = paramVarArgs.pl(); paramInt > 0; paramInt = paramVarArgs.pl()) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.pm();
          }
        }
        if (this.XI == null) {
          throw new a.a.a.b("Not all required fields were included: Talker");
        }
        if (this.Yj != null) {
          break;
        }
        throw new a.a.a.b("Not all required fields were included: VoiceData");
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        ai localai = (ai)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localai.XI = locala.ph();
          return 0;
        case 2: 
          localai.Yp = locala.pj();
          return 0;
        case 3: 
          localai.Yj = locala.pk();
          return 0;
        }
        localai.Yn = locala.pg();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.ai
 * JD-Core Version:    0.7.0.1
 */