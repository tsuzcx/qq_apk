package com.tencent.mm.protocal.c;

public final class bgk
  extends com.tencent.mm.bv.a
{
  public int jxl;
  public String jxm;
  public int lpJ;
  public String lpK;
  public int tBc;
  public int tBd;
  public int tzB;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tzB);
      paramVarArgs.gB(2, this.tBd);
      paramVarArgs.gB(3, this.tBc);
      paramVarArgs.gB(4, this.jxl);
      if (this.jxm != null) {
        paramVarArgs.d(5, this.jxm);
      }
      paramVarArgs.gB(6, this.lpJ);
      if (this.lpK != null) {
        paramVarArgs.d(7, this.lpK);
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
      i = d.a.a.a.gy(1, this.tzB) + 0 + d.a.a.a.gy(2, this.tBd) + d.a.a.a.gy(3, this.tBc) + d.a.a.a.gy(4, this.jxl);
      paramInt = i;
      if (this.jxm != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.jxm);
      }
      i = paramInt + d.a.a.a.gy(6, this.lpJ);
      paramInt = i;
    } while (this.lpK == null);
    return i + d.a.a.b.b.a.e(7, this.lpK);
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
      bgk localbgk = (bgk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbgk.tzB = locala.xpH.oD();
        return 0;
      case 2: 
        localbgk.tBd = locala.xpH.oD();
        return 0;
      case 3: 
        localbgk.tBc = locala.xpH.oD();
        return 0;
      case 4: 
        localbgk.jxl = locala.xpH.oD();
        return 0;
      case 5: 
        localbgk.jxm = locala.xpH.readString();
        return 0;
      case 6: 
        localbgk.lpJ = locala.xpH.oD();
        return 0;
      }
      localbgk.lpK = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bgk
 * JD-Core Version:    0.7.0.1
 */