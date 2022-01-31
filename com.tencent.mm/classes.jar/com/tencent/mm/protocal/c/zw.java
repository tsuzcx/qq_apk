package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class zw
  extends com.tencent.mm.bv.a
{
  public String kRX;
  public int sYX;
  public String sYY;
  public String sZg;
  public String sxZ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kRX == null) {
        throw new b("Not all required fields were included: AppID");
      }
      if (this.sZg == null) {
        throw new b("Not all required fields were included: RecommendKey");
      }
      if (this.kRX != null) {
        paramVarArgs.d(1, this.kRX);
      }
      if (this.sZg != null) {
        paramVarArgs.d(2, this.sZg);
      }
      if (this.sxZ != null) {
        paramVarArgs.d(3, this.sxZ);
      }
      paramVarArgs.gB(4, this.sYX);
      if (this.sYY != null) {
        paramVarArgs.d(5, this.sYY);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kRX == null) {
        break label451;
      }
    }
    label451:
    for (int i = d.a.a.b.b.a.e(1, this.kRX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sZg != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sZg);
      }
      i = paramInt;
      if (this.sxZ != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sxZ);
      }
      i += d.a.a.a.gy(4, this.sYX);
      paramInt = i;
      if (this.sYY != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sYY);
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
        if (this.kRX == null) {
          throw new b("Not all required fields were included: AppID");
        }
        if (this.sZg != null) {
          break;
        }
        throw new b("Not all required fields were included: RecommendKey");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        zw localzw = (zw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localzw.kRX = locala.xpH.readString();
          return 0;
        case 2: 
          localzw.sZg = locala.xpH.readString();
          return 0;
        case 3: 
          localzw.sxZ = locala.xpH.readString();
          return 0;
        case 4: 
          localzw.sYX = locala.xpH.oD();
          return 0;
        }
        localzw.sYY = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.zw
 * JD-Core Version:    0.7.0.1
 */