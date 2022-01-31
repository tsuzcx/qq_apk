package com.tencent.mm.plugin.report.service;

import d.a.a.b;

public final class c
  extends com.tencent.mm.bv.a
{
  public int hQR;
  public boolean nFk;
  public int nFr;
  public String nFs;
  public boolean nFt;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.nFs == null) {
        throw new b("Not all required fields were included: Value");
      }
      paramVarArgs.gB(1, this.nFr);
      if (this.nFs != null) {
        paramVarArgs.d(2, this.nFs);
      }
      paramVarArgs.aA(3, this.nFt);
      paramVarArgs.aA(4, this.nFk);
      paramVarArgs.gB(5, this.hQR);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.nFr) + 0;
      paramInt = i;
      if (this.nFs != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.nFs);
      }
      return paramInt + (d.a.a.b.b.a.dQ(3) + 1) + (d.a.a.b.b.a.dQ(4) + 1) + d.a.a.a.gy(5, this.hQR);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.nFs == null) {
        throw new b("Not all required fields were included: Value");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localc.nFr = locala.xpH.oD();
        return 0;
      case 2: 
        localc.nFs = locala.xpH.readString();
        return 0;
      case 3: 
        localc.nFt = locala.cUr();
        return 0;
      case 4: 
        localc.nFk = locala.cUr();
        return 0;
      }
      localc.hQR = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.c
 * JD-Core Version:    0.7.0.1
 */