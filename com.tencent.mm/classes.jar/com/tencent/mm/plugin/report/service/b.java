package com.tencent.mm.plugin.report.service;

public final class b
  extends com.tencent.mm.bv.a
{
  public int bxH;
  public int nFi;
  public int nFj;
  public boolean nFk;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.bxH);
      paramVarArgs.gB(2, this.nFi);
      paramVarArgs.gB(3, this.nFj);
      paramVarArgs.aA(4, this.nFk);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.bxH) + 0 + d.a.a.a.gy(2, this.nFi) + d.a.a.a.gy(3, this.nFj) + (d.a.a.b.b.a.dQ(4) + 1);
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
      b localb = (b)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localb.bxH = locala.xpH.oD();
        return 0;
      case 2: 
        localb.nFi = locala.xpH.oD();
        return 0;
      case 3: 
        localb.nFj = locala.xpH.oD();
        return 0;
      }
      localb.nFk = locala.cUr();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.b
 * JD-Core Version:    0.7.0.1
 */