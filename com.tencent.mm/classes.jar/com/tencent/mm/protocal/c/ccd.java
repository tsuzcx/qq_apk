package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class ccd
  extends com.tencent.mm.bv.a
{
  public String ffm;
  public String hPY;
  public String hRf;
  public String sPt;
  public String sxZ;
  public String tRz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.hPY == null) {
        throw new b("Not all required fields were included: UserName");
      }
      if (this.tRz == null) {
        throw new b("Not all required fields were included: MatchWord");
      }
      if (this.hPY != null) {
        paramVarArgs.d(1, this.hPY);
      }
      if (this.tRz != null) {
        paramVarArgs.d(2, this.tRz);
      }
      if (this.hRf != null) {
        paramVarArgs.d(3, this.hRf);
      }
      if (this.sPt != null) {
        paramVarArgs.d(4, this.sPt);
      }
      if (this.ffm != null) {
        paramVarArgs.d(5, this.ffm);
      }
      if (this.sxZ != null) {
        paramVarArgs.d(6, this.sxZ);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.hPY == null) {
        break label522;
      }
    }
    label522:
    for (int i = d.a.a.b.b.a.e(1, this.hPY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tRz != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tRz);
      }
      i = paramInt;
      if (this.hRf != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.hRf);
      }
      paramInt = i;
      if (this.sPt != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sPt);
      }
      i = paramInt;
      if (this.ffm != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.ffm);
      }
      paramInt = i;
      if (this.sxZ != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sxZ);
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
        if (this.hPY == null) {
          throw new b("Not all required fields were included: UserName");
        }
        if (this.tRz != null) {
          break;
        }
        throw new b("Not all required fields were included: MatchWord");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        ccd localccd = (ccd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localccd.hPY = locala.xpH.readString();
          return 0;
        case 2: 
          localccd.tRz = locala.xpH.readString();
          return 0;
        case 3: 
          localccd.hRf = locala.xpH.readString();
          return 0;
        case 4: 
          localccd.sPt = locala.xpH.readString();
          return 0;
        case 5: 
          localccd.ffm = locala.xpH.readString();
          return 0;
        }
        localccd.sxZ = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ccd
 * JD-Core Version:    0.7.0.1
 */