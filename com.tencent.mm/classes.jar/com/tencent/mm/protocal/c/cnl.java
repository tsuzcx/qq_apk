package com.tencent.mm.protocal.c;

public final class cnl
  extends com.tencent.mm.bv.a
{
  public int pyo;
  public int sCy;
  public int tmZ;
  public int uae;
  public int uaf;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tmZ);
      paramVarArgs.gB(2, this.sCy);
      paramVarArgs.gB(3, this.uae);
      paramVarArgs.gB(4, this.pyo);
      paramVarArgs.gB(10, this.uaf);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.tmZ) + 0 + d.a.a.a.gy(2, this.sCy) + d.a.a.a.gy(3, this.uae) + d.a.a.a.gy(4, this.pyo) + d.a.a.a.gy(10, this.uaf);
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
      cnl localcnl = (cnl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      default: 
        return -1;
      case 1: 
        localcnl.tmZ = locala.xpH.oD();
        return 0;
      case 2: 
        localcnl.sCy = locala.xpH.oD();
        return 0;
      case 3: 
        localcnl.uae = locala.xpH.oD();
        return 0;
      case 4: 
        localcnl.pyo = locala.xpH.oD();
        return 0;
      }
      localcnl.uaf = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cnl
 * JD-Core Version:    0.7.0.1
 */