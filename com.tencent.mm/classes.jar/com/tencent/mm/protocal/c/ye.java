package com.tencent.mm.protocal.c;

public final class ye
  extends com.tencent.mm.bv.a
{
  public int hQq;
  public String svC;
  public int svw;
  public int svx;
  public int svy;
  public int svz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.svw);
      paramVarArgs.gB(2, this.hQq);
      if (this.svC != null) {
        paramVarArgs.d(3, this.svC);
      }
      paramVarArgs.gB(4, this.svx);
      paramVarArgs.gB(5, this.svy);
      paramVarArgs.gB(6, this.svz);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.svw) + 0 + d.a.a.a.gy(2, this.hQq);
      paramInt = i;
      if (this.svC != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.svC);
      }
      return paramInt + d.a.a.a.gy(4, this.svx) + d.a.a.a.gy(5, this.svy) + d.a.a.a.gy(6, this.svz);
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
      ye localye = (ye)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localye.svw = locala.xpH.oD();
        return 0;
      case 2: 
        localye.hQq = locala.xpH.oD();
        return 0;
      case 3: 
        localye.svC = locala.xpH.readString();
        return 0;
      case 4: 
        localye.svx = locala.xpH.oD();
        return 0;
      case 5: 
        localye.svy = locala.xpH.oD();
        return 0;
      }
      localye.svz = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ye
 * JD-Core Version:    0.7.0.1
 */