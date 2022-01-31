package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class xx
  extends com.tencent.mm.bv.a
{
  public String appId;
  public String bFn;
  public int bIl;
  public String bRO;
  public String bVP;
  public String cbd;
  public long createTime;
  public String eAl;
  public boolean enJ = false;
  public boolean sWA = false;
  public String sWB;
  public boolean sWC = false;
  public boolean sWD = false;
  public boolean sWE = false;
  public boolean sWF = false;
  public boolean sWG = false;
  public String sWH;
  public boolean sWI = false;
  public boolean sWJ = false;
  public boolean sWw = false;
  public boolean sWx = false;
  public boolean sWy = false;
  public String sWz;
  public String toUser;
  
  public final xx EL(int paramInt)
  {
    this.bIl = paramInt;
    this.sWw = true;
    return this;
  }
  
  public final xx XZ(String paramString)
  {
    this.bRO = paramString;
    this.sWx = true;
    return this;
  }
  
  public final xx Ya(String paramString)
  {
    this.toUser = paramString;
    this.sWy = true;
    return this;
  }
  
  public final xx Yb(String paramString)
  {
    this.sWz = paramString;
    this.sWA = true;
    return this;
  }
  
  public final xx Yc(String paramString)
  {
    this.sWB = paramString;
    this.sWC = true;
    return this;
  }
  
  public final xx Yd(String paramString)
  {
    this.bVP = paramString;
    this.sWD = true;
    return this;
  }
  
  public final xx Ye(String paramString)
  {
    this.appId = paramString;
    this.sWF = true;
    return this;
  }
  
  public final xx Yf(String paramString)
  {
    this.eAl = paramString;
    this.sWG = true;
    return this;
  }
  
  public final xx Yg(String paramString)
  {
    this.bFn = paramString;
    this.sWJ = true;
    return this;
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (!this.sWw) {
        throw new b("Not all required fields were included: sourceType");
      }
      if (this.sWw == true) {
        paramVarArgs.gB(1, this.bIl);
      }
      if (this.bRO != null) {
        paramVarArgs.d(2, this.bRO);
      }
      if (this.toUser != null) {
        paramVarArgs.d(3, this.toUser);
      }
      if (this.sWz != null) {
        paramVarArgs.d(4, this.sWz);
      }
      if (this.sWB != null) {
        paramVarArgs.d(5, this.sWB);
      }
      if (this.enJ == true) {
        paramVarArgs.Y(6, this.createTime);
      }
      if (this.bVP != null) {
        paramVarArgs.d(7, this.bVP);
      }
      if (this.cbd != null) {
        paramVarArgs.d(8, this.cbd);
      }
      if (this.appId != null) {
        paramVarArgs.d(9, this.appId);
      }
      if (this.eAl != null) {
        paramVarArgs.d(10, this.eAl);
      }
      if (this.sWH != null) {
        paramVarArgs.d(11, this.sWH);
      }
      if (this.bFn != null) {
        paramVarArgs.d(12, this.bFn);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sWw != true) {
        break label908;
      }
    }
    label908:
    for (int i = d.a.a.a.gy(1, this.bIl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bRO != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bRO);
      }
      i = paramInt;
      if (this.toUser != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.toUser);
      }
      paramInt = i;
      if (this.sWz != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sWz);
      }
      i = paramInt;
      if (this.sWB != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sWB);
      }
      paramInt = i;
      if (this.enJ == true) {
        paramInt = i + d.a.a.a.X(6, this.createTime);
      }
      i = paramInt;
      if (this.bVP != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.bVP);
      }
      paramInt = i;
      if (this.cbd != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.cbd);
      }
      i = paramInt;
      if (this.appId != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.appId);
      }
      paramInt = i;
      if (this.eAl != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.eAl);
      }
      i = paramInt;
      if (this.sWH != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.sWH);
      }
      paramInt = i;
      if (this.bFn != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.bFn);
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
        if (this.sWw) {
          break;
        }
        throw new b("Not all required fields were included: sourceType");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        xx localxx = (xx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localxx.bIl = locala.xpH.oD();
          localxx.sWw = true;
          return 0;
        case 2: 
          localxx.bRO = locala.xpH.readString();
          localxx.sWx = true;
          return 0;
        case 3: 
          localxx.toUser = locala.xpH.readString();
          localxx.sWy = true;
          return 0;
        case 4: 
          localxx.sWz = locala.xpH.readString();
          localxx.sWA = true;
          return 0;
        case 5: 
          localxx.sWB = locala.xpH.readString();
          localxx.sWC = true;
          return 0;
        case 6: 
          localxx.createTime = locala.xpH.oE();
          localxx.enJ = true;
          return 0;
        case 7: 
          localxx.bVP = locala.xpH.readString();
          localxx.sWD = true;
          return 0;
        case 8: 
          localxx.cbd = locala.xpH.readString();
          localxx.sWE = true;
          return 0;
        case 9: 
          localxx.appId = locala.xpH.readString();
          localxx.sWF = true;
          return 0;
        case 10: 
          localxx.eAl = locala.xpH.readString();
          localxx.sWG = true;
          return 0;
        case 11: 
          localxx.sWH = locala.xpH.readString();
          localxx.sWI = true;
          return 0;
        }
        localxx.bFn = locala.xpH.readString();
        localxx.sWJ = true;
        return 0;
      }
      return -1;
    }
  }
  
  public final xx hi(long paramLong)
  {
    this.createTime = paramLong;
    this.enJ = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.xx
 * JD-Core Version:    0.7.0.1
 */