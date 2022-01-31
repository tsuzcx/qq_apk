package com.tencent.mm.protocal.c;

public final class but
  extends com.tencent.mm.bv.a
{
  public int ffs;
  public String fft;
  public long ffu;
  public int tLp;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.ffs);
      if (this.fft != null) {
        paramVarArgs.d(2, this.fft);
      }
      paramVarArgs.Y(3, this.ffu);
      paramVarArgs.gB(4, this.tLp);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.ffs) + 0;
      paramInt = i;
      if (this.fft != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.fft);
      }
      return paramInt + d.a.a.a.X(3, this.ffu) + d.a.a.a.gy(4, this.tLp);
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
      but localbut = (but)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbut.ffs = locala.xpH.oD();
        return 0;
      case 2: 
        localbut.fft = locala.xpH.readString();
        return 0;
      case 3: 
        localbut.ffu = locala.xpH.oE();
        return 0;
      }
      localbut.tLp = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.but
 * JD-Core Version:    0.7.0.1
 */