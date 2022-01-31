package com.tencent.mm.e.a;

public final class an
  extends com.tencent.mm.d.a
{
  public String VN;
  public String Vp;
  public com.tencent.mm.d.b Vy;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.VN == null) {
        throw new a.a.a.b("Not all required fields were included: Talker");
      }
      if (this.Vp == null) {
        throw new a.a.a.b("Not all required fields were included: NickName");
      }
      if (this.VN != null) {
        paramVarArgs.d(1, this.VN);
      }
      if (this.Vp != null) {
        paramVarArgs.d(2, this.Vp);
      }
      if (this.Vy != null) {
        paramVarArgs.c(3, this.Vy);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.VN == null) {
        break label344;
      }
    }
    label344:
    for (int i = a.a.a.b.b.a.e(1, this.VN) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Vp != null) {
        paramInt = i + a.a.a.b.b.a.e(2, this.Vp);
      }
      i = paramInt;
      if (this.Vy != null) {
        i = paramInt + a.a.a.a.a(3, this.Vy);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Vj);
        for (paramInt = paramVarArgs.oy(); paramInt > 0; paramInt = paramVarArgs.oy()) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.oz();
          }
        }
        if (this.VN == null) {
          throw new a.a.a.b("Not all required fields were included: Talker");
        }
        if (this.Vp != null) {
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
          localan.VN = locala.ou();
          return 0;
        case 2: 
          localan.Vp = locala.ou();
          return 0;
        }
        localan.Vy = locala.ox();
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