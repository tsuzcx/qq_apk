package com.tencent.mm.e.a;

public final class w
  extends com.tencent.mm.d.a
{
  public String VN;
  public int Vv;
  public String Vw;
  public String Vx;
  public com.tencent.mm.d.b Vy;
  public int We;
  public boolean Wf;
  public boolean Wg;
  public boolean Wh;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.VN == null) {
        throw new a.a.a.b("Not all required fields were included: Talker");
      }
      if (this.Vw == null) {
        throw new a.a.a.b("Not all required fields were included: Title");
      }
      if (this.Vx == null) {
        throw new a.a.a.b("Not all required fields were included: Content");
      }
      paramVarArgs.aq(1, this.Vv);
      if (this.VN != null) {
        paramVarArgs.d(2, this.VN);
      }
      if (this.Vw != null) {
        paramVarArgs.d(3, this.Vw);
      }
      if (this.Vx != null) {
        paramVarArgs.d(4, this.Vx);
      }
      paramVarArgs.aq(5, this.We);
      if (this.Vy != null) {
        paramVarArgs.c(6, this.Vy);
      }
      paramVarArgs.g(7, this.Wf);
      paramVarArgs.g(8, this.Wg);
      paramVarArgs.g(9, this.Wh);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.ak(1, this.Vv) + 0;
      paramInt = i;
      if (this.VN != null) {
        paramInt = i + a.a.a.b.b.a.e(2, this.VN);
      }
      i = paramInt;
      if (this.Vw != null) {
        i = paramInt + a.a.a.b.b.a.e(3, this.Vw);
      }
      paramInt = i;
      if (this.Vx != null) {
        paramInt = i + a.a.a.b.b.a.e(4, this.Vx);
      }
      i = paramInt + a.a.a.a.ak(5, this.We);
      paramInt = i;
      if (this.Vy != null) {
        paramInt = i + a.a.a.a.a(6, this.Vy);
      }
      return paramInt + (a.a.a.b.b.a.cp(7) + 1) + (a.a.a.b.b.a.cp(8) + 1) + (a.a.a.b.b.a.cp(9) + 1);
    }
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
      if (this.Vw == null) {
        throw new a.a.a.b("Not all required fields were included: Title");
      }
      if (this.Vx == null) {
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
        localw.Vv = locala.ot();
        return 0;
      case 2: 
        localw.VN = locala.ou();
        return 0;
      case 3: 
        localw.Vw = locala.ou();
        return 0;
      case 4: 
        localw.Vx = locala.ou();
        return 0;
      case 5: 
        localw.We = locala.ot();
        return 0;
      case 6: 
        localw.Vy = locala.ox();
        return 0;
      case 7: 
        localw.Wf = locala.ov();
        return 0;
      case 8: 
        localw.Wg = locala.ov();
        return 0;
      }
      localw.Wh = locala.ov();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.w
 * JD-Core Version:    0.7.0.1
 */