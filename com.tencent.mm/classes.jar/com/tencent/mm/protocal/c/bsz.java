package com.tencent.mm.protocal.c;

public final class bsz
  extends com.tencent.mm.bv.a
{
  public String hPY;
  public String tJD;
  public int tJE;
  public String tJF;
  public int tJG;
  public int tpq;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tJD != null) {
        paramVarArgs.d(1, this.tJD);
      }
      paramVarArgs.gB(2, this.tJE);
      if (this.hPY != null) {
        paramVarArgs.d(3, this.hPY);
      }
      if (this.tJF != null) {
        paramVarArgs.d(4, this.tJF);
      }
      paramVarArgs.gB(5, this.tpq);
      paramVarArgs.gB(6, this.tJG);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tJD == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = d.a.a.b.b.a.e(1, this.tJD) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tJE);
      paramInt = i;
      if (this.hPY != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.hPY);
      }
      i = paramInt;
      if (this.tJF != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.tJF);
      }
      return i + d.a.a.a.gy(5, this.tpq) + d.a.a.a.gy(6, this.tJG);
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
        bsz localbsz = (bsz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbsz.tJD = locala.xpH.readString();
          return 0;
        case 2: 
          localbsz.tJE = locala.xpH.oD();
          return 0;
        case 3: 
          localbsz.hPY = locala.xpH.readString();
          return 0;
        case 4: 
          localbsz.tJF = locala.xpH.readString();
          return 0;
        case 5: 
          localbsz.tpq = locala.xpH.oD();
          return 0;
        }
        localbsz.tJG = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bsz
 * JD-Core Version:    0.7.0.1
 */