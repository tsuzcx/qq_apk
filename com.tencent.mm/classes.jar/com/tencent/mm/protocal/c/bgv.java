package com.tencent.mm.protocal.c;

public final class bgv
  extends com.tencent.mm.bv.a
{
  public String sRE;
  public int sSW;
  public String sYM;
  public int tBy;
  public int tfR;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tfR);
      if (this.sYM != null) {
        paramVarArgs.d(2, this.sYM);
      }
      if (this.sRE != null) {
        paramVarArgs.d(3, this.sRE);
      }
      paramVarArgs.gB(4, this.sSW);
      paramVarArgs.gB(5, this.tBy);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.tfR) + 0;
      paramInt = i;
      if (this.sYM != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sYM);
      }
      i = paramInt;
      if (this.sRE != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sRE);
      }
      return i + d.a.a.a.gy(4, this.sSW) + d.a.a.a.gy(5, this.tBy);
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
      bgv localbgv = (bgv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbgv.tfR = locala.xpH.oD();
        return 0;
      case 2: 
        localbgv.sYM = locala.xpH.readString();
        return 0;
      case 3: 
        localbgv.sRE = locala.xpH.readString();
        return 0;
      case 4: 
        localbgv.sSW = locala.xpH.oD();
        return 0;
      }
      localbgv.tBy = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bgv
 * JD-Core Version:    0.7.0.1
 */