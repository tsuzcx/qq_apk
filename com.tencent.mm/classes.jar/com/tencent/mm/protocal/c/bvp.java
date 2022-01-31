package com.tencent.mm.protocal.c;

public final class bvp
  extends com.tencent.mm.bv.a
{
  public int oAE;
  public String oKX;
  public int source;
  public String tMp;
  public String tMq;
  public int tMr;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.oAE);
      if (this.tMp != null) {
        paramVarArgs.d(2, this.tMp);
      }
      if (this.tMq != null) {
        paramVarArgs.d(3, this.tMq);
      }
      paramVarArgs.gB(4, this.source);
      if (this.oKX != null) {
        paramVarArgs.d(5, this.oKX);
      }
      paramVarArgs.gB(6, this.tMr);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.oAE) + 0;
      paramInt = i;
      if (this.tMp != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tMp);
      }
      i = paramInt;
      if (this.tMq != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tMq);
      }
      i += d.a.a.a.gy(4, this.source);
      paramInt = i;
      if (this.oKX != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.oKX);
      }
      return paramInt + d.a.a.a.gy(6, this.tMr);
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
      bvp localbvp = (bvp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbvp.oAE = locala.xpH.oD();
        return 0;
      case 2: 
        localbvp.tMp = locala.xpH.readString();
        return 0;
      case 3: 
        localbvp.tMq = locala.xpH.readString();
        return 0;
      case 4: 
        localbvp.source = locala.xpH.oD();
        return 0;
      case 5: 
        localbvp.oKX = locala.xpH.readString();
        return 0;
      }
      localbvp.tMr = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bvp
 * JD-Core Version:    0.7.0.1
 */