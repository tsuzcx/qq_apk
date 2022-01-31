package com.tencent.mm.e.a;

import a.a.a.b;

public final class p
  extends com.tencent.mm.d.a
{
  public String VN;
  public long VP;
  public String Vp;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.VN == null) {
        throw new b("Not all required fields were included: Talker");
      }
      if (this.Vp == null) {
        throw new b("Not all required fields were included: NickName");
      }
      if (this.VN != null) {
        paramVarArgs.d(1, this.VN);
      }
      if (this.Vp != null) {
        paramVarArgs.d(2, this.Vp);
      }
      paramVarArgs.g(3, this.VP);
      return 0;
    }
    if (paramInt == 1) {
      if (this.VN == null) {
        break label324;
      }
    }
    label324:
    for (paramInt = a.a.a.b.b.a.e(1, this.VN) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Vp != null) {
        i = paramInt + a.a.a.b.b.a.e(2, this.Vp);
      }
      return i + a.a.a.a.e(3, this.VP);
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Vj);
        for (paramInt = paramVarArgs.oy(); paramInt > 0; paramInt = paramVarArgs.oy()) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.oz();
          }
        }
        if (this.VN == null) {
          throw new b("Not all required fields were included: Talker");
        }
        if (this.Vp != null) {
          break;
        }
        throw new b("Not all required fields were included: NickName");
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        p localp = (p)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localp.VN = locala.ou();
          return 0;
        case 2: 
          localp.Vp = locala.ou();
          return 0;
        }
        localp.VP = locala.ow();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.p
 * JD-Core Version:    0.7.0.1
 */