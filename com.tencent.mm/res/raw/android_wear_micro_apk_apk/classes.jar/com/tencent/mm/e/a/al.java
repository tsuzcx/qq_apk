package com.tencent.mm.e.a;

public final class al
  extends com.tencent.mm.d.a
{
  public String XI;
  public com.tencent.mm.d.b Yj;
  public int Yv;
  public boolean Yw;
  public boolean Yx;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.XI == null) {
        throw new a.a.a.b("Not all required fields were included: Talker");
      }
      if (this.XI != null) {
        paramVarArgs.d(1, this.XI);
      }
      paramVarArgs.at(2, this.Yv);
      if (this.Yj != null) {
        paramVarArgs.c(3, this.Yj);
      }
      paramVarArgs.h(4, this.Yw);
      paramVarArgs.h(5, this.Yx);
      return 0;
    }
    if (paramInt == 1) {
      if (this.XI == null) {
        break label356;
      }
    }
    label356:
    for (paramInt = a.a.a.b.b.a.e(1, this.XI) + 0;; paramInt = 0)
    {
      int i = paramInt + a.a.a.a.an(2, this.Yv);
      paramInt = i;
      if (this.Yj != null) {
        paramInt = i + a.a.a.b.b.a.b(3, this.Yj);
      }
      return paramInt + (a.a.a.b.b.a.cK(4) + 1) + (a.a.a.b.b.a.cK(5) + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Xe);
        for (paramInt = paramVarArgs.pl(); paramInt > 0; paramInt = paramVarArgs.pl()) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.pm();
          }
        }
        if (this.XI != null) {
          break;
        }
        throw new a.a.a.b("Not all required fields were included: Talker");
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        al localal = (al)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localal.XI = locala.ph();
          return 0;
        case 2: 
          localal.Yv = locala.pg();
          return 0;
        case 3: 
          localal.Yj = locala.pk();
          return 0;
        case 4: 
          localal.Yw = locala.pi();
          return 0;
        }
        localal.Yx = locala.pi();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.al
 * JD-Core Version:    0.7.0.1
 */