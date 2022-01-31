package com.tencent.mm.protocal.c;

public final class up
  extends com.tencent.mm.bv.a
{
  public boolean sRk;
  public boolean sRl;
  public String sRm;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aA(1, this.sRk);
      paramVarArgs.aA(2, this.sRl);
      if (this.sRm != null) {
        paramVarArgs.d(3, this.sRm);
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
      i = d.a.a.b.b.a.dQ(1) + 1 + 0 + (d.a.a.b.b.a.dQ(2) + 1);
      paramInt = i;
    } while (this.sRm == null);
    return i + d.a.a.b.b.a.e(3, this.sRm);
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
      up localup = (up)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localup.sRk = locala.cUr();
        return 0;
      case 2: 
        localup.sRl = locala.cUr();
        return 0;
      }
      localup.sRm = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.up
 * JD-Core Version:    0.7.0.1
 */