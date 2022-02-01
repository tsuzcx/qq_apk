package com.tencent.mm.e.a;

public final class an
  extends com.tencent.mm.d.a
{
  public String XI;
  public String Xk;
  public com.tencent.mm.d.b Xt;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.XI == null) {
        throw new a.a.a.b("Not all required fields were included: Talker");
      }
      if (this.Xk == null) {
        throw new a.a.a.b("Not all required fields were included: NickName");
      }
      if (this.XI != null) {
        paramVarArgs.d(1, this.XI);
      }
      if (this.Xk != null) {
        paramVarArgs.d(2, this.Xk);
      }
      if (this.Xt != null) {
        paramVarArgs.c(3, this.Xt);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.XI == null) {
        break label344;
      }
    }
    label344:
    for (int i = a.a.a.b.b.a.e(1, this.XI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Xk != null) {
        paramInt = i + a.a.a.b.b.a.e(2, this.Xk);
      }
      i = paramInt;
      if (this.Xt != null) {
        i = paramInt + a.a.a.b.b.a.b(3, this.Xt);
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
        if (this.XI == null) {
          throw new a.a.a.b("Not all required fields were included: Talker");
        }
        if (this.Xk != null) {
          break;
        }
        throw new a.a.a.b("Not all required fields were included: NickName");
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        an localan = (an)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localan.XI = locala.ph();
          return 0;
        case 2: 
          localan.Xk = locala.ph();
          return 0;
        }
        localan.Xt = locala.pk();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.an
 * JD-Core Version:    0.7.0.1
 */