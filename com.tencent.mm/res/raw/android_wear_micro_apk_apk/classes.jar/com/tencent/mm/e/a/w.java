package com.tencent.mm.e.a;

public final class w
  extends com.tencent.mm.d.a
{
  public String XI;
  public int XZ;
  public int Xq;
  public String Xr;
  public String Xs;
  public com.tencent.mm.d.b Xt;
  public boolean Ya;
  public boolean Yb;
  public boolean Yc;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.XI == null) {
        throw new a.a.a.b("Not all required fields were included: Talker");
      }
      if (this.Xr == null) {
        throw new a.a.a.b("Not all required fields were included: Title");
      }
      if (this.Xs == null) {
        throw new a.a.a.b("Not all required fields were included: Content");
      }
      paramVarArgs.at(1, this.Xq);
      if (this.XI != null) {
        paramVarArgs.d(2, this.XI);
      }
      if (this.Xr != null) {
        paramVarArgs.d(3, this.Xr);
      }
      if (this.Xs != null) {
        paramVarArgs.d(4, this.Xs);
      }
      paramVarArgs.at(5, this.XZ);
      if (this.Xt != null) {
        paramVarArgs.c(6, this.Xt);
      }
      paramVarArgs.h(7, this.Ya);
      paramVarArgs.h(8, this.Yb);
      paramVarArgs.h(9, this.Yc);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.an(1, this.Xq) + 0;
      paramInt = i;
      if (this.XI != null) {
        paramInt = i + a.a.a.b.b.a.e(2, this.XI);
      }
      i = paramInt;
      if (this.Xr != null) {
        i = paramInt + a.a.a.b.b.a.e(3, this.Xr);
      }
      paramInt = i;
      if (this.Xs != null) {
        paramInt = i + a.a.a.b.b.a.e(4, this.Xs);
      }
      i = paramInt + a.a.a.a.an(5, this.XZ);
      paramInt = i;
      if (this.Xt != null) {
        paramInt = i + a.a.a.b.b.a.b(6, this.Xt);
      }
      return paramInt + (a.a.a.b.b.a.cK(7) + 1) + (a.a.a.b.b.a.cK(8) + 1) + (a.a.a.b.b.a.cK(9) + 1);
    }
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
      if (this.Xr == null) {
        throw new a.a.a.b("Not all required fields were included: Title");
      }
      if (this.Xs == null) {
        throw new a.a.a.b("Not all required fields were included: Content");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      w localw = (w)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localw.Xq = locala.pg();
        return 0;
      case 2: 
        localw.XI = locala.ph();
        return 0;
      case 3: 
        localw.Xr = locala.ph();
        return 0;
      case 4: 
        localw.Xs = locala.ph();
        return 0;
      case 5: 
        localw.XZ = locala.pg();
        return 0;
      case 6: 
        localw.Xt = locala.pk();
        return 0;
      case 7: 
        localw.Ya = locala.pi();
        return 0;
      case 8: 
        localw.Yb = locala.pi();
        return 0;
      }
      localw.Yc = locala.pi();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.w
 * JD-Core Version:    0.7.0.1
 */