package com.tencent.mm.e.a;

public final class i
  extends com.tencent.mm.d.a
{
  public String Xj;
  public String Xk;
  public int Xq;
  public String Xs;
  public com.tencent.mm.d.b Xt;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.Xj == null) {
        throw new a.a.a.b("Not all required fields were included: UserName");
      }
      if (this.Xk == null) {
        throw new a.a.a.b("Not all required fields were included: NickName");
      }
      if (this.Xs == null) {
        throw new a.a.a.b("Not all required fields were included: Content");
      }
      paramVarArgs.at(1, this.Xq);
      if (this.Xj != null) {
        paramVarArgs.d(2, this.Xj);
      }
      if (this.Xk != null) {
        paramVarArgs.d(3, this.Xk);
      }
      if (this.Xs != null) {
        paramVarArgs.d(4, this.Xs);
      }
      if (this.Xt != null) {
        paramVarArgs.c(5, this.Xt);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = a.a.a.a.an(1, this.Xq) + 0;
      paramInt = i;
      if (this.Xj != null) {
        paramInt = i + a.a.a.b.b.a.e(2, this.Xj);
      }
      i = paramInt;
      if (this.Xk != null) {
        i = paramInt + a.a.a.b.b.a.e(3, this.Xk);
      }
      paramInt = i;
      if (this.Xs != null) {
        paramInt = i + a.a.a.b.b.a.e(4, this.Xs);
      }
      i = paramInt;
    } while (this.Xt == null);
    return paramInt + a.a.a.b.b.a.b(5, this.Xt);
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Xe);
      for (paramInt = paramVarArgs.pl(); paramInt > 0; paramInt = paramVarArgs.pl()) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.pm();
        }
      }
      if (this.Xj == null) {
        throw new a.a.a.b("Not all required fields were included: UserName");
      }
      if (this.Xk == null) {
        throw new a.a.a.b("Not all required fields were included: NickName");
      }
      if (this.Xs == null) {
        throw new a.a.a.b("Not all required fields were included: Content");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      i locali = (i)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        locali.Xq = locala.pg();
        return 0;
      case 2: 
        locali.Xj = locala.ph();
        return 0;
      case 3: 
        locali.Xk = locala.ph();
        return 0;
      case 4: 
        locali.Xs = locala.ph();
        return 0;
      }
      locali.Xt = locala.pk();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.i
 * JD-Core Version:    0.7.0.1
 */