package com.tencent.mm.protocal.c;

public final class baj
  extends com.tencent.mm.bv.a
{
  public int sEE;
  public int sNU;
  public int twn;
  public String two;
  public String twq;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sEE);
      if (this.twq != null) {
        paramVarArgs.d(3, this.twq);
      }
      paramVarArgs.gB(4, this.twn);
      paramVarArgs.gB(5, this.sNU);
      if (this.two != null) {
        paramVarArgs.d(6, this.two);
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
      i = d.a.a.a.gy(1, this.sEE) + 0;
      paramInt = i;
      if (this.twq != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.twq);
      }
      i = paramInt + d.a.a.a.gy(4, this.twn) + d.a.a.a.gy(5, this.sNU);
      paramInt = i;
    } while (this.two == null);
    return i + d.a.a.b.b.a.e(6, this.two);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      baj localbaj = (baj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 2: 
      default: 
        return -1;
      case 1: 
        localbaj.sEE = locala.xpH.oD();
        return 0;
      case 3: 
        localbaj.twq = locala.xpH.readString();
        return 0;
      case 4: 
        localbaj.twn = locala.xpH.oD();
        return 0;
      case 5: 
        localbaj.sNU = locala.xpH.oD();
        return 0;
      }
      localbaj.two = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.baj
 * JD-Core Version:    0.7.0.1
 */