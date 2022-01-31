package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class aab
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public int create_time;
  public String euK;
  public String kRN;
  public String kVn;
  public String mQp;
  public String sYY;
  public int sZt;
  public int sZu;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bGw == null) {
        throw new b("Not all required fields were included: Title");
      }
      if (this.kRN == null) {
        throw new b("Not all required fields were included: Desc");
      }
      if (this.mQp == null) {
        throw new b("Not all required fields were included: ThumbUrl");
      }
      if (this.bGw != null) {
        paramVarArgs.d(1, this.bGw);
      }
      if (this.kRN != null) {
        paramVarArgs.d(2, this.kRN);
      }
      if (this.mQp != null) {
        paramVarArgs.d(3, this.mQp);
      }
      if (this.sYY != null) {
        paramVarArgs.d(4, this.sYY);
      }
      paramVarArgs.gB(5, this.sZt);
      paramVarArgs.gB(6, this.sZu);
      if (this.euK != null) {
        paramVarArgs.d(7, this.euK);
      }
      paramVarArgs.gB(8, this.create_time);
      if (this.kVn != null) {
        paramVarArgs.d(9, this.kVn);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.bGw == null) {
        break label679;
      }
    }
    label679:
    for (int i = d.a.a.b.b.a.e(1, this.bGw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kRN != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kRN);
      }
      i = paramInt;
      if (this.mQp != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.mQp);
      }
      paramInt = i;
      if (this.sYY != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sYY);
      }
      i = paramInt + d.a.a.a.gy(5, this.sZt) + d.a.a.a.gy(6, this.sZu);
      paramInt = i;
      if (this.euK != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.euK);
      }
      i = paramInt + d.a.a.a.gy(8, this.create_time);
      paramInt = i;
      if (this.kVn != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.kVn);
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
        if (this.bGw == null) {
          throw new b("Not all required fields were included: Title");
        }
        if (this.kRN == null) {
          throw new b("Not all required fields were included: Desc");
        }
        if (this.mQp != null) {
          break;
        }
        throw new b("Not all required fields were included: ThumbUrl");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        aab localaab = (aab)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localaab.bGw = locala.xpH.readString();
          return 0;
        case 2: 
          localaab.kRN = locala.xpH.readString();
          return 0;
        case 3: 
          localaab.mQp = locala.xpH.readString();
          return 0;
        case 4: 
          localaab.sYY = locala.xpH.readString();
          return 0;
        case 5: 
          localaab.sZt = locala.xpH.oD();
          return 0;
        case 6: 
          localaab.sZu = locala.xpH.oD();
          return 0;
        case 7: 
          localaab.euK = locala.xpH.readString();
          return 0;
        case 8: 
          localaab.create_time = locala.xpH.oD();
          return 0;
        }
        localaab.kVn = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aab
 * JD-Core Version:    0.7.0.1
 */