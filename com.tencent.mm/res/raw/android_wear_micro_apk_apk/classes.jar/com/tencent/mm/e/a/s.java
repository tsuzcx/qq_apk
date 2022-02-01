package com.tencent.mm.e.a;

public final class s
  extends com.tencent.mm.d.a
{
  public String XI;
  public long XJ;
  public String XO;
  public int XP;
  public long XQ;
  public boolean XR;
  public com.tencent.mm.d.b XS;
  public String Xs;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.XO == null) {
        throw new a.a.a.b("Not all required fields were included: Nickname");
      }
      if (this.Xs == null) {
        throw new a.a.a.b("Not all required fields were included: Content");
      }
      if (this.XI == null) {
        throw new a.a.a.b("Not all required fields were included: Talker");
      }
      paramVarArgs.g(1, this.XJ);
      if (this.XO != null) {
        paramVarArgs.d(2, this.XO);
      }
      if (this.Xs != null) {
        paramVarArgs.d(3, this.Xs);
      }
      paramVarArgs.at(4, this.XP);
      if (this.XI != null) {
        paramVarArgs.d(5, this.XI);
      }
      paramVarArgs.g(6, this.XQ);
      paramVarArgs.h(7, this.XR);
      if (this.XS != null) {
        paramVarArgs.c(8, this.XS);
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
      i = a.a.a.b.b.a.f(1, this.XJ) + 0;
      paramInt = i;
      if (this.XO != null) {
        paramInt = i + a.a.a.b.b.a.e(2, this.XO);
      }
      i = paramInt;
      if (this.Xs != null) {
        i = paramInt + a.a.a.b.b.a.e(3, this.Xs);
      }
      i += a.a.a.a.an(4, this.XP);
      paramInt = i;
      if (this.XI != null) {
        paramInt = i + a.a.a.b.b.a.e(5, this.XI);
      }
      i = paramInt + a.a.a.b.b.a.f(6, this.XQ) + (a.a.a.b.b.a.cK(7) + 1);
      paramInt = i;
    } while (this.XS == null);
    return i + a.a.a.b.b.a.b(8, this.XS);
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Xe);
      for (paramInt = paramVarArgs.pl(); paramInt > 0; paramInt = paramVarArgs.pl()) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.pm();
        }
      }
      if (this.XO == null) {
        throw new a.a.a.b("Not all required fields were included: Nickname");
      }
      if (this.Xs == null) {
        throw new a.a.a.b("Not all required fields were included: Content");
      }
      if (this.XI == null) {
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
        locals.XJ = locala.pj();
        return 0;
      case 2: 
        locals.XO = locala.ph();
        return 0;
      case 3: 
        locals.Xs = locala.ph();
        return 0;
      case 4: 
        locals.XP = locala.pg();
        return 0;
      case 5: 
        locals.XI = locala.ph();
        return 0;
      case 6: 
        locals.XQ = locala.pj();
        return 0;
      case 7: 
        locals.XR = locala.pi();
        return 0;
      }
      locals.XS = locala.pk();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.s
 * JD-Core Version:    0.7.0.1
 */