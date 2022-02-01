package com.tencent.mm.e.a;

public final class aa
  extends com.tencent.mm.d.a
{
  public int Yd;
  public String Ye;
  public com.tencent.mm.d.b Yf;
  public com.tencent.mm.d.b Yg;
  public String Yh;
  public String Yi;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.Ye == null) {
        throw new a.a.a.b("Not all required fields were included: Msg");
      }
      paramVarArgs.at(1, this.Yd);
      if (this.Ye != null) {
        paramVarArgs.d(2, this.Ye);
      }
      if (this.Yf != null) {
        paramVarArgs.c(3, this.Yf);
      }
      if (this.Yg != null) {
        paramVarArgs.c(4, this.Yg);
      }
      if (this.Yh != null) {
        paramVarArgs.d(5, this.Yh);
      }
      if (this.Yi != null) {
        paramVarArgs.d(6, this.Yi);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = a.a.a.a.an(1, this.Yd) + 0;
      paramInt = i;
      if (this.Ye != null) {
        paramInt = i + a.a.a.b.b.a.e(2, this.Ye);
      }
      i = paramInt;
      if (this.Yf != null) {
        i = paramInt + a.a.a.b.b.a.b(3, this.Yf);
      }
      paramInt = i;
      if (this.Yg != null) {
        paramInt = i + a.a.a.b.b.a.b(4, this.Yg);
      }
      i = paramInt;
      if (this.Yh != null) {
        i = paramInt + a.a.a.b.b.a.e(5, this.Yh);
      }
      paramInt = i;
    } while (this.Yi == null);
    return i + a.a.a.b.b.a.e(6, this.Yi);
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Xe);
      for (paramInt = paramVarArgs.pl(); paramInt > 0; paramInt = paramVarArgs.pl()) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.pm();
        }
      }
      if (this.Ye == null) {
        throw new a.a.a.b("Not all required fields were included: Msg");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      aa localaa = (aa)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localaa.Yd = locala.pg();
        return 0;
      case 2: 
        localaa.Ye = locala.ph();
        return 0;
      case 3: 
        localaa.Yf = locala.pk();
        return 0;
      case 4: 
        localaa.Yg = locala.pk();
        return 0;
      case 5: 
        localaa.Yh = locala.ph();
        return 0;
      }
      localaa.Yi = locala.ph();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.aa
 * JD-Core Version:    0.7.0.1
 */