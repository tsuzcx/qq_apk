package com.tencent.mm.protocal.c;

public final class by
  extends com.tencent.mm.bv.a
{
  public int hQR;
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
      paramVarArgs.gB(2, this.hQR);
      paramVarArgs.gB(3, this.svx);
      paramVarArgs.gB(4, this.svy);
      paramVarArgs.gB(5, this.svz);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.svw) + 0 + d.a.a.a.gy(2, this.hQR) + d.a.a.a.gy(3, this.svx) + d.a.a.a.gy(4, this.svy) + d.a.a.a.gy(5, this.svz);
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
      by localby = (by)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localby.svw = locala.xpH.oD();
        return 0;
      case 2: 
        localby.hQR = locala.xpH.oD();
        return 0;
      case 3: 
        localby.svx = locala.xpH.oD();
        return 0;
      case 4: 
        localby.svy = locala.xpH.oD();
        return 0;
      }
      localby.svz = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.by
 * JD-Core Version:    0.7.0.1
 */