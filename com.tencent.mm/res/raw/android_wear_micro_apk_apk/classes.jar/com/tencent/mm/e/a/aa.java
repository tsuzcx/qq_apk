package com.tencent.mm.e.a;

public final class aa
  extends com.tencent.mm.d.a
{
  public int Wi;
  public String Wj;
  public com.tencent.mm.d.b Wk;
  public com.tencent.mm.d.b Wl;
  public String Wm;
  public String Wn;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.Wj == null) {
        throw new a.a.a.b("Not all required fields were included: Msg");
      }
      paramVarArgs.aq(1, this.Wi);
      if (this.Wj != null) {
        paramVarArgs.d(2, this.Wj);
      }
      if (this.Wk != null) {
        paramVarArgs.c(3, this.Wk);
      }
      if (this.Wl != null) {
        paramVarArgs.c(4, this.Wl);
      }
      if (this.Wm != null) {
        paramVarArgs.d(5, this.Wm);
      }
      if (this.Wn != null) {
        paramVarArgs.d(6, this.Wn);
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
      i = a.a.a.a.ak(1, this.Wi) + 0;
      paramInt = i;
      if (this.Wj != null) {
        paramInt = i + a.a.a.b.b.a.e(2, this.Wj);
      }
      i = paramInt;
      if (this.Wk != null) {
        i = paramInt + a.a.a.a.a(3, this.Wk);
      }
      paramInt = i;
      if (this.Wl != null) {
        paramInt = i + a.a.a.a.a(4, this.Wl);
      }
      i = paramInt;
      if (this.Wm != null) {
        i = paramInt + a.a.a.b.b.a.e(5, this.Wm);
      }
      paramInt = i;
    } while (this.Wn == null);
    return i + a.a.a.b.b.a.e(6, this.Wn);
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Vj);
      for (paramInt = paramVarArgs.oy(); paramInt > 0; paramInt = paramVarArgs.oy()) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.oz();
        }
      }
      if (this.Wj == null) {
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
        localaa.Wi = locala.ot();
        return 0;
      case 2: 
        localaa.Wj = locala.ou();
        return 0;
      case 3: 
        localaa.Wk = locala.ox();
        return 0;
      case 4: 
        localaa.Wl = locala.ox();
        return 0;
      case 5: 
        localaa.Wm = locala.ou();
        return 0;
      }
      localaa.Wn = locala.ou();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.aa
 * JD-Core Version:    0.7.0.1
 */