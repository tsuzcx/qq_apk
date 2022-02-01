package com.tencent.mm.e.a;

public final class b
  extends com.tencent.mm.d.a
{
  public long Xg;
  public com.tencent.mm.d.b Xi;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.g(1, this.Xg);
      if (this.Xi != null) {
        paramVarArgs.c(2, this.Xi);
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
      i = a.a.a.b.b.a.f(1, this.Xg) + 0;
      paramInt = i;
    } while (this.Xi == null);
    return i + a.a.a.b.b.a.b(2, this.Xi);
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Xe);
      for (paramInt = paramVarArgs.pl(); paramInt > 0; paramInt = paramVarArgs.pl()) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.pm();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localb.Xg = locala.pj();
        return 0;
      }
      localb.Xi = locala.pk();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.b
 * JD-Core Version:    0.7.0.1
 */