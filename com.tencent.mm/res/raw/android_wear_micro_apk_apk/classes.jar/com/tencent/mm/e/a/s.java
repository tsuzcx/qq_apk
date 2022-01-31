package com.tencent.mm.e.a;

public final class s
  extends com.tencent.mm.d.a
{
  public String VN;
  public long VO;
  public String VT;
  public int VU;
  public long VV;
  public boolean VW;
  public com.tencent.mm.d.b VX;
  public String Vx;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.VT == null) {
        throw new a.a.a.b("Not all required fields were included: Nickname");
      }
      if (this.Vx == null) {
        throw new a.a.a.b("Not all required fields were included: Content");
      }
      if (this.VN == null) {
        throw new a.a.a.b("Not all required fields were included: Talker");
      }
      paramVarArgs.g(1, this.VO);
      if (this.VT != null) {
        paramVarArgs.d(2, this.VT);
      }
      if (this.Vx != null) {
        paramVarArgs.d(3, this.Vx);
      }
      paramVarArgs.aq(4, this.VU);
      if (this.VN != null) {
        paramVarArgs.d(5, this.VN);
      }
      paramVarArgs.g(6, this.VV);
      paramVarArgs.g(7, this.VW);
      if (this.VX != null) {
        paramVarArgs.c(8, this.VX);
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
      i = a.a.a.a.e(1, this.VO) + 0;
      paramInt = i;
      if (this.VT != null) {
        paramInt = i + a.a.a.b.b.a.e(2, this.VT);
      }
      i = paramInt;
      if (this.Vx != null) {
        i = paramInt + a.a.a.b.b.a.e(3, this.Vx);
      }
      i += a.a.a.a.ak(4, this.VU);
      paramInt = i;
      if (this.VN != null) {
        paramInt = i + a.a.a.b.b.a.e(5, this.VN);
      }
      i = paramInt + a.a.a.a.e(6, this.VV) + (a.a.a.b.b.a.cp(7) + 1);
      paramInt = i;
    } while (this.VX == null);
    return i + a.a.a.a.a(8, this.VX);
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Vj);
      for (paramInt = paramVarArgs.oy(); paramInt > 0; paramInt = paramVarArgs.oy()) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.oz();
        }
      }
      if (this.VT == null) {
        throw new a.a.a.b("Not all required fields were included: Nickname");
      }
      if (this.Vx == null) {
        throw new a.a.a.b("Not all required fields were included: Content");
      }
      if (this.VN == null) {
        throw new a.a.a.b("Not all required fields were included: Talker");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      s locals = (s)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        locals.VO = locala.ow();
        return 0;
      case 2: 
        locals.VT = locala.ou();
        return 0;
      case 3: 
        locals.Vx = locala.ou();
        return 0;
      case 4: 
        locals.VU = locala.ot();
        return 0;
      case 5: 
        locals.VN = locala.ou();
        return 0;
      case 6: 
        locals.VV = locala.ow();
        return 0;
      case 7: 
        locals.VW = locala.ov();
        return 0;
      }
      locals.VX = locala.ox();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.s
 * JD-Core Version:    0.7.0.1
 */