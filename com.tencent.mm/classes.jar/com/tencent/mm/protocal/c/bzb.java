package com.tencent.mm.protocal.c;

public final class bzb
  extends com.tencent.mm.bv.a
{
  public int Height;
  public int Width;
  public int X;
  public int Y;
  public int sTj;
  public String tPg;
  public int tPh;
  public int tPi;
  public String tvE;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.X);
      paramVarArgs.gB(2, this.Y);
      paramVarArgs.gB(3, this.Width);
      paramVarArgs.gB(4, this.Height);
      if (this.tPg != null) {
        paramVarArgs.d(5, this.tPg);
      }
      if (this.tvE != null) {
        paramVarArgs.d(6, this.tvE);
      }
      paramVarArgs.gB(7, this.tPh);
      paramVarArgs.gB(8, this.sTj);
      paramVarArgs.gB(9, this.tPi);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.X) + 0 + d.a.a.a.gy(2, this.Y) + d.a.a.a.gy(3, this.Width) + d.a.a.a.gy(4, this.Height);
      paramInt = i;
      if (this.tPg != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tPg);
      }
      i = paramInt;
      if (this.tvE != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.tvE);
      }
      return i + d.a.a.a.gy(7, this.tPh) + d.a.a.a.gy(8, this.sTj) + d.a.a.a.gy(9, this.tPi);
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
      bzb localbzb = (bzb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbzb.X = locala.xpH.oD();
        return 0;
      case 2: 
        localbzb.Y = locala.xpH.oD();
        return 0;
      case 3: 
        localbzb.Width = locala.xpH.oD();
        return 0;
      case 4: 
        localbzb.Height = locala.xpH.oD();
        return 0;
      case 5: 
        localbzb.tPg = locala.xpH.readString();
        return 0;
      case 6: 
        localbzb.tvE = locala.xpH.readString();
        return 0;
      case 7: 
        localbzb.tPh = locala.xpH.oD();
        return 0;
      case 8: 
        localbzb.sTj = locala.xpH.oD();
        return 0;
      }
      localbzb.tPi = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bzb
 * JD-Core Version:    0.7.0.1
 */