package com.tencent.mm.protocal.c;

public final class bww
  extends com.tencent.mm.bv.a
{
  public int tNc;
  public String tNd;
  public String tNe;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tNc);
      if (this.tNd != null) {
        paramVarArgs.d(2, this.tNd);
      }
      if (this.tNe != null) {
        paramVarArgs.d(3, this.tNe);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.tNc) + 0;
      paramInt = i;
      if (this.tNd != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tNd);
      }
      i = paramInt;
    } while (this.tNe == null);
    return paramInt + d.a.a.b.b.a.e(3, this.tNe);
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
      bww localbww = (bww)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbww.tNc = locala.xpH.oD();
        return 0;
      case 2: 
        localbww.tNd = locala.xpH.readString();
        return 0;
      }
      localbww.tNe = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bww
 * JD-Core Version:    0.7.0.1
 */