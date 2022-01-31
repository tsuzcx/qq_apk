package com.tencent.mm.protocal.c;

public final class zs
  extends com.tencent.mm.bv.a
{
  public boolean sYT;
  public boolean sYU;
  public boolean sYV;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aA(1, this.sYT);
      paramVarArgs.aA(2, this.sYU);
      paramVarArgs.aA(3, this.sYV);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.b.b.a.dQ(1) + 1 + 0 + (d.a.a.b.b.a.dQ(2) + 1) + (d.a.a.b.b.a.dQ(3) + 1);
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
      zs localzs = (zs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localzs.sYT = locala.cUr();
        return 0;
      case 2: 
        localzs.sYU = locala.cUr();
        return 0;
      }
      localzs.sYV = locala.cUr();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.zs
 * JD-Core Version:    0.7.0.1
 */