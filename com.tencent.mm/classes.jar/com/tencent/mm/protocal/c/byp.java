package com.tencent.mm.protocal.c;

public final class byp
  extends com.tencent.mm.bv.a
{
  public String sGU;
  public String sRu;
  public int tOO;
  public int tOP;
  public long tOQ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tOO);
      if (this.sGU != null) {
        paramVarArgs.d(2, this.sGU);
      }
      if (this.sRu != null) {
        paramVarArgs.d(3, this.sRu);
      }
      paramVarArgs.gB(4, this.tOP);
      paramVarArgs.Y(5, this.tOQ);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.tOO) + 0;
      paramInt = i;
      if (this.sGU != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sGU);
      }
      i = paramInt;
      if (this.sRu != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sRu);
      }
      return i + d.a.a.a.gy(4, this.tOP) + d.a.a.a.X(5, this.tOQ);
    }
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
      byp localbyp = (byp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbyp.tOO = locala.xpH.oD();
        return 0;
      case 2: 
        localbyp.sGU = locala.xpH.readString();
        return 0;
      case 3: 
        localbyp.sRu = locala.xpH.readString();
        return 0;
      case 4: 
        localbyp.tOP = locala.xpH.oD();
        return 0;
      }
      localbyp.tOQ = locala.xpH.oE();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.byp
 * JD-Core Version:    0.7.0.1
 */