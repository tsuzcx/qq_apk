package com.tencent.mm.e.a;

public final class i
  extends com.tencent.mm.d.a
{
  public String Vo;
  public String Vp;
  public int Vv;
  public String Vx;
  public com.tencent.mm.d.b Vy;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.Vo == null) {
        throw new a.a.a.b("Not all required fields were included: UserName");
      }
      if (this.Vp == null) {
        throw new a.a.a.b("Not all required fields were included: NickName");
      }
      if (this.Vx == null) {
        throw new a.a.a.b("Not all required fields were included: Content");
      }
      paramVarArgs.aq(1, this.Vv);
      if (this.Vo != null) {
        paramVarArgs.d(2, this.Vo);
      }
      if (this.Vp != null) {
        paramVarArgs.d(3, this.Vp);
      }
      if (this.Vx != null) {
        paramVarArgs.d(4, this.Vx);
      }
      if (this.Vy != null) {
        paramVarArgs.c(5, this.Vy);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = a.a.a.a.ak(1, this.Vv) + 0;
      paramInt = i;
      if (this.Vo != null) {
        paramInt = i + a.a.a.b.b.a.e(2, this.Vo);
      }
      i = paramInt;
      if (this.Vp != null) {
        i = paramInt + a.a.a.b.b.a.e(3, this.Vp);
      }
      paramInt = i;
      if (this.Vx != null) {
        paramInt = i + a.a.a.b.b.a.e(4, this.Vx);
      }
      i = paramInt;
    } while (this.Vy == null);
    return paramInt + a.a.a.a.a(5, this.Vy);
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Vj);
      for (paramInt = paramVarArgs.oy(); paramInt > 0; paramInt = paramVarArgs.oy()) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.oz();
        }
      }
      if (this.Vo == null) {
        throw new a.a.a.b("Not all required fields were included: UserName");
      }
      if (this.Vp == null) {
        throw new a.a.a.b("Not all required fields were included: NickName");
      }
      if (this.Vx == null) {
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
        locali.Vv = locala.ot();
        return 0;
      case 2: 
        locali.Vo = locala.ou();
        return 0;
      case 3: 
        locali.Vp = locala.ou();
        return 0;
      case 4: 
        locali.Vx = locala.ou();
        return 0;
      }
      locali.Vy = locala.ox();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.i
 * JD-Core Version:    0.7.0.1
 */