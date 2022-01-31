package com.tencent.mm.protocal.c;

public final class uy
  extends com.tencent.mm.bv.a
{
  public int ndf;
  public int ndg;
  public long ndp;
  public String sRE;
  public int sRK;
  public int sze;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sze);
      paramVarArgs.gB(2, this.ndg);
      paramVarArgs.gB(3, this.ndf);
      if (this.sRE != null) {
        paramVarArgs.d(4, this.sRE);
      }
      paramVarArgs.gB(5, this.sRK);
      paramVarArgs.Y(6, this.ndp);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.sze) + 0 + d.a.a.a.gy(2, this.ndg) + d.a.a.a.gy(3, this.ndf);
      paramInt = i;
      if (this.sRE != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sRE);
      }
      return paramInt + d.a.a.a.gy(5, this.sRK) + d.a.a.a.X(6, this.ndp);
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
      uy localuy = (uy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localuy.sze = locala.xpH.oD();
        return 0;
      case 2: 
        localuy.ndg = locala.xpH.oD();
        return 0;
      case 3: 
        localuy.ndf = locala.xpH.oD();
        return 0;
      case 4: 
        localuy.sRE = locala.xpH.readString();
        return 0;
      case 5: 
        localuy.sRK = locala.xpH.oD();
        return 0;
      }
      localuy.ndp = locala.xpH.oE();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.uy
 * JD-Core Version:    0.7.0.1
 */