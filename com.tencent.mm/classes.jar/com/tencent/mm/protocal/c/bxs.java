package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class bxs
  extends com.tencent.mm.bv.a
{
  public String bHk;
  public String bvC;
  public int gZD;
  public String lfK;
  public String lnA;
  public String lnw;
  public String lny;
  public String lnz;
  public String tNK;
  public String tNL;
  public String title;
  public int versionCode;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.lny == null) {
        throw new b("Not all required fields were included: patchId");
      }
      if (this.lnz == null) {
        throw new b("Not all required fields were included: newApkMd5");
      }
      if (this.lnA == null) {
        throw new b("Not all required fields were included: oldApkMd5");
      }
      if (this.title == null) {
        throw new b("Not all required fields were included: title");
      }
      if (this.tNL == null) {
        throw new b("Not all required fields were included: okBtn");
      }
      if (this.lfK == null) {
        throw new b("Not all required fields were included: cancelBtn");
      }
      if (this.bvC == null) {
        throw new b("Not all required fields were included: patchMd5");
      }
      if (this.lny != null) {
        paramVarArgs.d(1, this.lny);
      }
      if (this.tNK != null) {
        paramVarArgs.d(2, this.tNK);
      }
      paramVarArgs.gB(3, this.gZD);
      if (this.lnz != null) {
        paramVarArgs.d(4, this.lnz);
      }
      if (this.lnA != null) {
        paramVarArgs.d(5, this.lnA);
      }
      if (this.title != null) {
        paramVarArgs.d(6, this.title);
      }
      if (this.bHk != null) {
        paramVarArgs.d(7, this.bHk);
      }
      if (this.tNL != null) {
        paramVarArgs.d(8, this.tNL);
      }
      if (this.lfK != null) {
        paramVarArgs.d(9, this.lfK);
      }
      if (this.lnw != null) {
        paramVarArgs.d(10, this.lnw);
      }
      if (this.bvC != null) {
        paramVarArgs.d(11, this.bvC);
      }
      paramVarArgs.gB(12, this.versionCode);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lny == null) {
        break label1000;
      }
    }
    label1000:
    for (paramInt = d.a.a.b.b.a.e(1, this.lny) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tNK != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.tNK);
      }
      i += d.a.a.a.gy(3, this.gZD);
      paramInt = i;
      if (this.lnz != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.lnz);
      }
      i = paramInt;
      if (this.lnA != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.lnA);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.title);
      }
      i = paramInt;
      if (this.bHk != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.bHk);
      }
      paramInt = i;
      if (this.tNL != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.tNL);
      }
      i = paramInt;
      if (this.lfK != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.lfK);
      }
      paramInt = i;
      if (this.lnw != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.lnw);
      }
      i = paramInt;
      if (this.bvC != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.bvC);
      }
      return i + d.a.a.a.gy(12, this.versionCode);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.lny == null) {
          throw new b("Not all required fields were included: patchId");
        }
        if (this.lnz == null) {
          throw new b("Not all required fields were included: newApkMd5");
        }
        if (this.lnA == null) {
          throw new b("Not all required fields were included: oldApkMd5");
        }
        if (this.title == null) {
          throw new b("Not all required fields were included: title");
        }
        if (this.tNL == null) {
          throw new b("Not all required fields were included: okBtn");
        }
        if (this.lfK == null) {
          throw new b("Not all required fields were included: cancelBtn");
        }
        if (this.bvC != null) {
          break;
        }
        throw new b("Not all required fields were included: patchMd5");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        bxs localbxs = (bxs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbxs.lny = locala.xpH.readString();
          return 0;
        case 2: 
          localbxs.tNK = locala.xpH.readString();
          return 0;
        case 3: 
          localbxs.gZD = locala.xpH.oD();
          return 0;
        case 4: 
          localbxs.lnz = locala.xpH.readString();
          return 0;
        case 5: 
          localbxs.lnA = locala.xpH.readString();
          return 0;
        case 6: 
          localbxs.title = locala.xpH.readString();
          return 0;
        case 7: 
          localbxs.bHk = locala.xpH.readString();
          return 0;
        case 8: 
          localbxs.tNL = locala.xpH.readString();
          return 0;
        case 9: 
          localbxs.lfK = locala.xpH.readString();
          return 0;
        case 10: 
          localbxs.lnw = locala.xpH.readString();
          return 0;
        case 11: 
          localbxs.bvC = locala.xpH.readString();
          return 0;
        }
        localbxs.versionCode = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bxs
 * JD-Core Version:    0.7.0.1
 */