package com.tencent.mm.e.a;

public final class b
  extends com.tencent.mm.d.a
{
  public long Vl;
  public com.tencent.mm.d.b Vn;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.g(1, this.Vl);
      if (this.Vn != null) {
        paramVarArgs.c(2, this.Vn);
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
      i = a.a.a.a.e(1, this.Vl) + 0;
      paramInt = i;
    } while (this.Vn == null);
    return i + a.a.a.a.a(2, this.Vn);
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Vj);
      for (paramInt = paramVarArgs.oy(); paramInt > 0; paramInt = paramVarArgs.oy()) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.oz();
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
        localb.Vl = locala.ow();
        return 0;
      }
      localb.Vn = locala.ox();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.b
 * JD-Core Version:    0.7.0.1
 */