package com.tencent.mm.protocal.c;

public final class cgx
  extends com.tencent.mm.bv.a
{
  public boolean tVK;
  public String tVL;
  public String tVM;
  public int tVN;
  public int tVO;
  public int tVP;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aA(1, this.tVK);
      if (this.tVL != null) {
        paramVarArgs.d(2, this.tVL);
      }
      if (this.tVM != null) {
        paramVarArgs.d(3, this.tVM);
      }
      paramVarArgs.gB(4, this.tVN);
      paramVarArgs.gB(5, this.tVO);
      paramVarArgs.gB(6, this.tVP);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.b.b.a.dQ(1) + 1 + 0;
      paramInt = i;
      if (this.tVL != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tVL);
      }
      i = paramInt;
      if (this.tVM != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tVM);
      }
      return i + d.a.a.a.gy(4, this.tVN) + d.a.a.a.gy(5, this.tVO) + d.a.a.a.gy(6, this.tVP);
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
      cgx localcgx = (cgx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localcgx.tVK = locala.cUr();
        return 0;
      case 2: 
        localcgx.tVL = locala.xpH.readString();
        return 0;
      case 3: 
        localcgx.tVM = locala.xpH.readString();
        return 0;
      case 4: 
        localcgx.tVN = locala.xpH.oD();
        return 0;
      case 5: 
        localcgx.tVO = locala.xpH.oD();
        return 0;
      }
      localcgx.tVP = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cgx
 * JD-Core Version:    0.7.0.1
 */