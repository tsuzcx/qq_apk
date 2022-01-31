package com.tencent.mm.protocal.c;

public final class cll
  extends com.tencent.mm.bv.a
{
  public int sCy;
  public String tYG;
  public String tYH;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sCy);
      if (this.tYG != null) {
        paramVarArgs.d(2, this.tYG);
      }
      if (this.tYH != null) {
        paramVarArgs.d(3, this.tYH);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.sCy) + 0;
      paramInt = i;
      if (this.tYG != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tYG);
      }
      i = paramInt;
    } while (this.tYH == null);
    return paramInt + d.a.a.b.b.a.e(3, this.tYH);
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
      cll localcll = (cll)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localcll.sCy = locala.xpH.oD();
        return 0;
      case 2: 
        localcll.tYG = locala.xpH.readString();
        return 0;
      }
      localcll.tYH = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cll
 * JD-Core Version:    0.7.0.1
 */