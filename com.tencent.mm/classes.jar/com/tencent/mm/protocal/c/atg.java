package com.tencent.mm.protocal.c;

public final class atg
  extends com.tencent.mm.bv.a
{
  public int ssy;
  public String tiz;
  public String toL;
  public boolean toM;
  public String toN;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.ssy);
      if (this.toL != null) {
        paramVarArgs.d(2, this.toL);
      }
      paramVarArgs.aA(3, this.toM);
      if (this.toN != null) {
        paramVarArgs.d(4, this.toN);
      }
      if (this.tiz != null) {
        paramVarArgs.d(5, this.tiz);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.ssy) + 0;
      paramInt = i;
      if (this.toL != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.toL);
      }
      i = paramInt + (d.a.a.b.b.a.dQ(3) + 1);
      paramInt = i;
      if (this.toN != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.toN);
      }
      i = paramInt;
    } while (this.tiz == null);
    return paramInt + d.a.a.b.b.a.e(5, this.tiz);
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
      atg localatg = (atg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localatg.ssy = locala.xpH.oD();
        return 0;
      case 2: 
        localatg.toL = locala.xpH.readString();
        return 0;
      case 3: 
        localatg.toM = locala.cUr();
        return 0;
      case 4: 
        localatg.toN = locala.xpH.readString();
        return 0;
      }
      localatg.tiz = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.atg
 * JD-Core Version:    0.7.0.1
 */