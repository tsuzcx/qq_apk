package com.tencent.mm.protocal.c;

public final class azi
  extends com.tencent.mm.bv.a
{
  public long tvA;
  public int tvy;
  public long tvz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tvy);
      paramVarArgs.Y(2, this.tvz);
      paramVarArgs.Y(3, this.tvA);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.tvy) + 0 + d.a.a.a.X(2, this.tvz) + d.a.a.a.X(3, this.tvA);
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
      azi localazi = (azi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localazi.tvy = locala.xpH.oD();
        return 0;
      case 2: 
        localazi.tvz = locala.xpH.oE();
        return 0;
      }
      localazi.tvA = locala.xpH.oE();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.azi
 * JD-Core Version:    0.7.0.1
 */