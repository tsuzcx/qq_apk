package com.tencent.mm.protocal.c;

public final class cch
  extends com.tencent.mm.bv.a
{
  public String hQc;
  public String kSy;
  public String kVn;
  public String sPn;
  public String syI;
  public long tRB;
  public String tks;
  public String tym;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sPn != null) {
        paramVarArgs.d(1, this.sPn);
      }
      if (this.syI != null) {
        paramVarArgs.d(2, this.syI);
      }
      if (this.tym != null) {
        paramVarArgs.d(3, this.tym);
      }
      if (this.kVn != null) {
        paramVarArgs.d(4, this.kVn);
      }
      if (this.hQc != null) {
        paramVarArgs.d(5, this.hQc);
      }
      if (this.kSy != null) {
        paramVarArgs.d(6, this.kSy);
      }
      if (this.tks != null) {
        paramVarArgs.d(7, this.tks);
      }
      paramVarArgs.Y(8, this.tRB);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sPn == null) {
        break label552;
      }
    }
    label552:
    for (int i = d.a.a.b.b.a.e(1, this.sPn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.syI != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.syI);
      }
      i = paramInt;
      if (this.tym != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tym);
      }
      paramInt = i;
      if (this.kVn != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kVn);
      }
      i = paramInt;
      if (this.hQc != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.hQc);
      }
      paramInt = i;
      if (this.kSy != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.kSy);
      }
      i = paramInt;
      if (this.tks != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.tks);
      }
      return i + d.a.a.a.X(8, this.tRB);
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
        cch localcch = (cch)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcch.sPn = locala.xpH.readString();
          return 0;
        case 2: 
          localcch.syI = locala.xpH.readString();
          return 0;
        case 3: 
          localcch.tym = locala.xpH.readString();
          return 0;
        case 4: 
          localcch.kVn = locala.xpH.readString();
          return 0;
        case 5: 
          localcch.hQc = locala.xpH.readString();
          return 0;
        case 6: 
          localcch.kSy = locala.xpH.readString();
          return 0;
        case 7: 
          localcch.tks = locala.xpH.readString();
          return 0;
        }
        localcch.tRB = locala.xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cch
 * JD-Core Version:    0.7.0.1
 */