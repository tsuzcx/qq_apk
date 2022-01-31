package com.tencent.mm.protocal.c;

public final class bdf
  extends com.tencent.mm.bv.a
{
  public String bOL;
  public String ilp;
  public String sIn;
  public int tyx;
  public String tyy;
  public String tyz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bOL != null) {
        paramVarArgs.d(1, this.bOL);
      }
      paramVarArgs.gB(2, this.tyx);
      if (this.tyy != null) {
        paramVarArgs.d(3, this.tyy);
      }
      if (this.tyz != null) {
        paramVarArgs.d(4, this.tyz);
      }
      if (this.sIn != null) {
        paramVarArgs.d(5, this.sIn);
      }
      if (this.ilp != null) {
        paramVarArgs.d(6, this.ilp);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.bOL == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = d.a.a.b.b.a.e(1, this.bOL) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tyx);
      paramInt = i;
      if (this.tyy != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.tyy);
      }
      i = paramInt;
      if (this.tyz != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.tyz);
      }
      paramInt = i;
      if (this.sIn != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sIn);
      }
      i = paramInt;
      if (this.ilp != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.ilp);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        bdf localbdf = (bdf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbdf.bOL = locala.xpH.readString();
          return 0;
        case 2: 
          localbdf.tyx = locala.xpH.oD();
          return 0;
        case 3: 
          localbdf.tyy = locala.xpH.readString();
          return 0;
        case 4: 
          localbdf.tyz = locala.xpH.readString();
          return 0;
        case 5: 
          localbdf.sIn = locala.xpH.readString();
          return 0;
        }
        localbdf.ilp = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bdf
 * JD-Core Version:    0.7.0.1
 */