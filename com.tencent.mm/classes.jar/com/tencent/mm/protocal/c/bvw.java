package com.tencent.mm.protocal.c;

public final class bvw
  extends com.tencent.mm.bv.a
{
  public int ghE;
  public int timestamp;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.timestamp);
      paramVarArgs.gB(2, this.ghE);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.timestamp) + 0 + d.a.a.a.gy(2, this.ghE);
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
      bvw localbvw = (bvw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbvw.timestamp = locala.xpH.oD();
        return 0;
      }
      localbvw.ghE = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bvw
 * JD-Core Version:    0.7.0.1
 */