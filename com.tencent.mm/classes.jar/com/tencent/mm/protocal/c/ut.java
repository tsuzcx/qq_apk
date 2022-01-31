package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class ut
  extends com.tencent.mm.bv.a
{
  public String jnN;
  public String jnU;
  public String kSC;
  public String mQp;
  public String sRs;
  public String sRt;
  public String sRu;
  public String sRv;
  public String sRw;
  public String sRx;
  public String syc;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.jnU == null) {
        throw new b("Not all required fields were included: Md5");
      }
      if (this.jnU != null) {
        paramVarArgs.d(1, this.jnU);
      }
      if (this.kSC != null) {
        paramVarArgs.d(2, this.kSC);
      }
      if (this.mQp != null) {
        paramVarArgs.d(3, this.mQp);
      }
      if (this.sRs != null) {
        paramVarArgs.d(4, this.sRs);
      }
      if (this.sRt != null) {
        paramVarArgs.d(5, this.sRt);
      }
      if (this.sRu != null) {
        paramVarArgs.d(6, this.sRu);
      }
      if (this.syc != null) {
        paramVarArgs.d(7, this.syc);
      }
      if (this.sRv != null) {
        paramVarArgs.d(8, this.sRv);
      }
      if (this.sRw != null) {
        paramVarArgs.d(9, this.sRw);
      }
      if (this.sRx != null) {
        paramVarArgs.d(10, this.sRx);
      }
      if (this.jnN != null) {
        paramVarArgs.d(11, this.jnN);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.jnU == null) {
        break label773;
      }
    }
    label773:
    for (int i = d.a.a.b.b.a.e(1, this.jnU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kSC != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kSC);
      }
      i = paramInt;
      if (this.mQp != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.mQp);
      }
      paramInt = i;
      if (this.sRs != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sRs);
      }
      i = paramInt;
      if (this.sRt != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sRt);
      }
      paramInt = i;
      if (this.sRu != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sRu);
      }
      i = paramInt;
      if (this.syc != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.syc);
      }
      paramInt = i;
      if (this.sRv != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sRv);
      }
      i = paramInt;
      if (this.sRw != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.sRw);
      }
      paramInt = i;
      if (this.sRx != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.sRx);
      }
      i = paramInt;
      if (this.jnN != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.jnN);
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
        if (this.jnU != null) {
          break;
        }
        throw new b("Not all required fields were included: Md5");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        ut localut = (ut)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localut.jnU = locala.xpH.readString();
          return 0;
        case 2: 
          localut.kSC = locala.xpH.readString();
          return 0;
        case 3: 
          localut.mQp = locala.xpH.readString();
          return 0;
        case 4: 
          localut.sRs = locala.xpH.readString();
          return 0;
        case 5: 
          localut.sRt = locala.xpH.readString();
          return 0;
        case 6: 
          localut.sRu = locala.xpH.readString();
          return 0;
        case 7: 
          localut.syc = locala.xpH.readString();
          return 0;
        case 8: 
          localut.sRv = locala.xpH.readString();
          return 0;
        case 9: 
          localut.sRw = locala.xpH.readString();
          return 0;
        case 10: 
          localut.sRx = locala.xpH.readString();
          return 0;
        }
        localut.jnN = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ut
 * JD-Core Version:    0.7.0.1
 */