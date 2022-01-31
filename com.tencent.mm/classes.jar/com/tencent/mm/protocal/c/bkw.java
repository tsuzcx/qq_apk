package com.tencent.mm.protocal.c;

public final class bkw
  extends com.tencent.mm.bv.a
{
  public String hQD;
  public int oiJ;
  public String sEc;
  public String sEd;
  public String sEe;
  public String sEf;
  public int tEw;
  public int tEx;
  public String tEy;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.hQD != null) {
        paramVarArgs.d(1, this.hQD);
      }
      paramVarArgs.gB(2, this.tEw);
      if (this.sEc != null) {
        paramVarArgs.d(3, this.sEc);
      }
      if (this.sEd != null) {
        paramVarArgs.d(4, this.sEd);
      }
      paramVarArgs.gB(5, this.oiJ);
      paramVarArgs.gB(6, this.tEx);
      if (this.sEe != null) {
        paramVarArgs.d(7, this.sEe);
      }
      if (this.sEf != null) {
        paramVarArgs.d(8, this.sEf);
      }
      if (this.tEy != null) {
        paramVarArgs.d(9, this.tEy);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.hQD == null) {
        break label575;
      }
    }
    label575:
    for (paramInt = d.a.a.b.b.a.e(1, this.hQD) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tEw);
      paramInt = i;
      if (this.sEc != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.sEc);
      }
      i = paramInt;
      if (this.sEd != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.sEd);
      }
      i = i + d.a.a.a.gy(5, this.oiJ) + d.a.a.a.gy(6, this.tEx);
      paramInt = i;
      if (this.sEe != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.sEe);
      }
      i = paramInt;
      if (this.sEf != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.sEf);
      }
      paramInt = i;
      if (this.tEy != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.tEy);
      }
      return paramInt;
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
        bkw localbkw = (bkw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbkw.hQD = locala.xpH.readString();
          return 0;
        case 2: 
          localbkw.tEw = locala.xpH.oD();
          return 0;
        case 3: 
          localbkw.sEc = locala.xpH.readString();
          return 0;
        case 4: 
          localbkw.sEd = locala.xpH.readString();
          return 0;
        case 5: 
          localbkw.oiJ = locala.xpH.oD();
          return 0;
        case 6: 
          localbkw.tEx = locala.xpH.oD();
          return 0;
        case 7: 
          localbkw.sEe = locala.xpH.readString();
          return 0;
        case 8: 
          localbkw.sEf = locala.xpH.readString();
          return 0;
        }
        localbkw.tEy = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bkw
 * JD-Core Version:    0.7.0.1
 */