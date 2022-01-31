package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class yp
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
  public String sXj;
  public boolean sXk = false;
  public String toUser;
  
  public final yp EQ(int paramInt)
  {
    this.bIl = paramInt;
    this.sWw = true;
    return this;
  }
  
  public final yp Yq(String paramString)
  {
    this.bRO = paramString;
    this.sWx = true;
    return this;
  }
  
  public final yp Yr(String paramString)
  {
    this.toUser = paramString;
    this.sWy = true;
    return this;
  }
  
  public final yp Ys(String paramString)
  {
    this.sXj = paramString;
    this.sXk = true;
    return this;
  }
  
  public final yp Yt(String paramString)
  {
    this.sWB = paramString;
    this.sWC = true;
    return this;
  }
  
  public final yp Yu(String paramString)
  {
    this.bVP = paramString;
    this.sWD = true;
    return this;
  }
  
  public final yp Yv(String paramString)
  {
    this.cbd = paramString;
    this.sWE = true;
    return this;
  }
  
  public final yp Yw(String paramString)
  {
    this.appId = paramString;
    this.sWF = true;
    return this;
  }
  
  public final yp Yx(String paramString)
  {
    this.eAl = paramString;
    this.sWG = true;
    return this;
  }
  
  public final yp Yy(String paramString)
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
      if (this.sXj != null) {
        paramVarArgs.d(4, this.sXj);
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
      if (this.sXj != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sXj);
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
        yp localyp = (yp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localyp.bIl = locala.xpH.oD();
          localyp.sWw = true;
          return 0;
        case 2: 
          localyp.bRO = locala.xpH.readString();
          localyp.sWx = true;
          return 0;
        case 3: 
          localyp.toUser = locala.xpH.readString();
          localyp.sWy = true;
          return 0;
        case 4: 
          localyp.sXj = locala.xpH.readString();
          localyp.sXk = true;
          return 0;
        case 5: 
          localyp.sWB = locala.xpH.readString();
          localyp.sWC = true;
          return 0;
        case 6: 
          localyp.createTime = locala.xpH.oE();
          localyp.enJ = true;
          return 0;
        case 7: 
          localyp.bVP = locala.xpH.readString();
          localyp.sWD = true;
          return 0;
        case 8: 
          localyp.cbd = locala.xpH.readString();
          localyp.sWE = true;
          return 0;
        case 9: 
          localyp.appId = locala.xpH.readString();
          localyp.sWF = true;
          return 0;
        case 10: 
          localyp.eAl = locala.xpH.readString();
          localyp.sWG = true;
          return 0;
        case 11: 
          localyp.sWH = locala.xpH.readString();
          localyp.sWI = true;
          return 0;
        }
        localyp.bFn = locala.xpH.readString();
        localyp.sWJ = true;
        return 0;
      }
      return -1;
    }
  }
  
  public final yp hl(long paramLong)
  {
    this.createTime = paramLong;
    this.enJ = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.yp
 * JD-Core Version:    0.7.0.1
 */