package com.tencent.mm.e.a;

import a.a.a.b;

public final class n
  extends com.tencent.mm.d.a
{
  public String VN;
  public long VO;
  public String Vw;
  public String Vx;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.VN == null) {
        throw new b("Not all required fields were included: Talker");
      }
      if (this.Vw == null) {
        throw new b("Not all required fields were included: Title");
      }
      if (this.Vx == null) {
        throw new b("Not all required fields were included: Content");
      }
      if (this.VN != null) {
        paramVarArgs.d(1, this.VN);
      }
      if (this.Vw != null) {
        paramVarArgs.d(2, this.Vw);
      }
      if (this.Vx != null) {
        paramVarArgs.d(3, this.Vx);
      }
      paramVarArgs.g(4, this.VO);
      return 0;
    }
    if (paramInt == 1) {
      if (this.VN == null) {
        break label412;
      }
    }
    label412:
    for (int i = a.a.a.b.b.a.e(1, this.VN) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Vw != null) {
        paramInt = i + a.a.a.b.b.a.e(2, this.Vw);
      }
      i = paramInt;
      if (this.Vx != null) {
        i = paramInt + a.a.a.b.b.a.e(3, this.Vx);
      }
      return i + a.a.a.a.e(4, this.VO);
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
        if (this.Vw == null) {
          throw new b("Not all required fields were included: Title");
        }
        if (this.Vx != null) {
          break;
        }
        throw new b("Not all required fields were included: Content");
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localn.VN = locala.ou();
          return 0;
        case 2: 
          localn.Vw = locala.ou();
          return 0;
        case 3: 
          localn.Vx = locala.ou();
          return 0;
        }
        localn.VO = locala.ow();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.n
 * JD-Core Version:    0.7.0.1
 */