package com.tencent.mm.protocal.c;

public final class lc
  extends com.tencent.mm.bv.a
{
  public int sGj;
  public int sGk;
  public int sGl;
  public int sGm;
  public int sGn;
  public int sGo;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sGj);
      paramVarArgs.gB(2, this.sGk);
      paramVarArgs.gB(3, this.sGl);
      paramVarArgs.gB(4, this.sGm);
      paramVarArgs.gB(5, this.sGn);
      paramVarArgs.gB(6, this.sGo);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.sGj) + 0 + d.a.a.a.gy(2, this.sGk) + d.a.a.a.gy(3, this.sGl) + d.a.a.a.gy(4, this.sGm) + d.a.a.a.gy(5, this.sGn) + d.a.a.a.gy(6, this.sGo);
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
      lc locallc = (lc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        locallc.sGj = locala.xpH.oD();
        return 0;
      case 2: 
        locallc.sGk = locala.xpH.oD();
        return 0;
      case 3: 
        locallc.sGl = locala.xpH.oD();
        return 0;
      case 4: 
        locallc.sGm = locala.xpH.oD();
        return 0;
      case 5: 
        locallc.sGn = locala.xpH.oD();
        return 0;
      }
      locallc.sGo = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.lc
 * JD-Core Version:    0.7.0.1
 */