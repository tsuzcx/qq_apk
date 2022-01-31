package com.tencent.mm.protocal.c;

public final class cau
  extends com.tencent.mm.bv.a
{
  public String jnV;
  public int ndf;
  public int ndg;
  public String sRE;
  public int sze;
  public boolean tPW;
  public boolean tPX = false;
  
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
      paramVarArgs.aA(5, this.tPW);
      if (this.jnV != null) {
        paramVarArgs.d(6, this.jnV);
      }
      paramVarArgs.aA(7, this.tPX);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.sze) + 0 + d.a.a.a.gy(2, this.ndg) + d.a.a.a.gy(3, this.ndf);
      paramInt = i;
      if (this.sRE != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sRE);
      }
      i = paramInt + (d.a.a.b.b.a.dQ(5) + 1);
      paramInt = i;
      if (this.jnV != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.jnV);
      }
      return paramInt + (d.a.a.b.b.a.dQ(7) + 1);
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
      cau localcau = (cau)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localcau.sze = locala.xpH.oD();
        return 0;
      case 2: 
        localcau.ndg = locala.xpH.oD();
        return 0;
      case 3: 
        localcau.ndf = locala.xpH.oD();
        return 0;
      case 4: 
        localcau.sRE = locala.xpH.readString();
        return 0;
      case 5: 
        localcau.tPW = locala.cUr();
        return 0;
      case 6: 
        localcau.jnV = locala.xpH.readString();
        return 0;
      }
      localcau.tPX = locala.cUr();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cau
 * JD-Core Version:    0.7.0.1
 */