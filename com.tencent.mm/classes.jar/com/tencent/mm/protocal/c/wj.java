package com.tencent.mm.protocal.c;

public final class wj
  extends com.tencent.mm.bv.a
{
  public int sTi;
  public int sTj;
  public int sTk;
  public String sTl;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sTi);
      paramVarArgs.gB(2, this.sTj);
      paramVarArgs.gB(3, this.sTk);
      if (this.sTl != null) {
        paramVarArgs.d(4, this.sTl);
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
      i = d.a.a.a.gy(1, this.sTi) + 0 + d.a.a.a.gy(2, this.sTj) + d.a.a.a.gy(3, this.sTk);
      paramInt = i;
    } while (this.sTl == null);
    return i + d.a.a.b.b.a.e(4, this.sTl);
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
      wj localwj = (wj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localwj.sTi = locala.xpH.oD();
        return 0;
      case 2: 
        localwj.sTj = locala.xpH.oD();
        return 0;
      case 3: 
        localwj.sTk = locala.xpH.oD();
        return 0;
      }
      localwj.sTl = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.wj
 * JD-Core Version:    0.7.0.1
 */