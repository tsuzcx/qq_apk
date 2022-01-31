package com.tencent.mm.protocal.c;

public final class ww
  extends com.tencent.mm.bv.a
{
  public String kRZ;
  public long nGh;
  public int sTI;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.Y(1, this.nGh);
      if (this.kRZ != null) {
        paramVarArgs.d(2, this.kRZ);
      }
      paramVarArgs.gB(3, this.sTI);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.X(1, this.nGh) + 0;
      paramInt = i;
      if (this.kRZ != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kRZ);
      }
      return paramInt + d.a.a.a.gy(3, this.sTI);
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
      ww localww = (ww)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localww.nGh = locala.xpH.oE();
        return 0;
      case 2: 
        localww.kRZ = locala.xpH.readString();
        return 0;
      }
      localww.sTI = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ww
 * JD-Core Version:    0.7.0.1
 */