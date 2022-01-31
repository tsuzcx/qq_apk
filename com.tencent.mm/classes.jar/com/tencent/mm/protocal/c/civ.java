package com.tencent.mm.protocal.c;

public final class civ
  extends com.tencent.mm.bv.a
{
  public String hQc;
  public String sEc;
  public String sEd;
  public String sEe;
  public String sEf;
  public String syI;
  public String tXc;
  public String tXd;
  public String tXe;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.syI != null) {
        paramVarArgs.d(1, this.syI);
      }
      if (this.sEd != null) {
        paramVarArgs.d(2, this.sEd);
      }
      if (this.sEc != null) {
        paramVarArgs.d(3, this.sEc);
      }
      if (this.hQc != null) {
        paramVarArgs.d(4, this.hQc);
      }
      if (this.tXc != null) {
        paramVarArgs.d(5, this.tXc);
      }
      if (this.sEe != null) {
        paramVarArgs.d(6, this.sEe);
      }
      if (this.sEf != null) {
        paramVarArgs.d(7, this.sEf);
      }
      if (this.tXd != null) {
        paramVarArgs.d(8, this.tXd);
      }
      if (this.tXe != null) {
        paramVarArgs.d(9, this.tXe);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.syI == null) {
        break label627;
      }
    }
    label627:
    for (int i = d.a.a.b.b.a.e(1, this.syI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sEd != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sEd);
      }
      i = paramInt;
      if (this.sEc != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sEc);
      }
      paramInt = i;
      if (this.hQc != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.hQc);
      }
      i = paramInt;
      if (this.tXc != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tXc);
      }
      paramInt = i;
      if (this.sEe != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sEe);
      }
      i = paramInt;
      if (this.sEf != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.sEf);
      }
      paramInt = i;
      if (this.tXd != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.tXd);
      }
      i = paramInt;
      if (this.tXe != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.tXe);
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
        civ localciv = (civ)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localciv.syI = locala.xpH.readString();
          return 0;
        case 2: 
          localciv.sEd = locala.xpH.readString();
          return 0;
        case 3: 
          localciv.sEc = locala.xpH.readString();
          return 0;
        case 4: 
          localciv.hQc = locala.xpH.readString();
          return 0;
        case 5: 
          localciv.tXc = locala.xpH.readString();
          return 0;
        case 6: 
          localciv.sEe = locala.xpH.readString();
          return 0;
        case 7: 
          localciv.sEf = locala.xpH.readString();
          return 0;
        case 8: 
          localciv.tXd = locala.xpH.readString();
          return 0;
        }
        localciv.tXe = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.civ
 * JD-Core Version:    0.7.0.1
 */