package com.tencent.mm.protocal.c;

import d.a.a.b;

public class cnn
  extends com.tencent.mm.bv.a
{
  public String euK;
  public String hPY;
  public String kSy;
  public String kTg;
  public String kVn;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.euK == null) {
        throw new b("Not all required fields were included: AppId");
      }
      if (this.kVn == null) {
        throw new b("Not all required fields were included: AppName");
      }
      if (this.hPY == null) {
        throw new b("Not all required fields were included: UserName");
      }
      if (this.kSy == null) {
        throw new b("Not all required fields were included: IconUrl");
      }
      if (this.euK != null) {
        paramVarArgs.d(1, this.euK);
      }
      if (this.kVn != null) {
        paramVarArgs.d(2, this.kVn);
      }
      if (this.hPY != null) {
        paramVarArgs.d(3, this.hPY);
      }
      if (this.kSy != null) {
        paramVarArgs.d(4, this.kSy);
      }
      if (this.kTg != null) {
        paramVarArgs.d(5, this.kTg);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.euK == null) {
        break label535;
      }
    }
    label535:
    for (int i = d.a.a.b.b.a.e(1, this.euK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kVn != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kVn);
      }
      i = paramInt;
      if (this.hPY != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.hPY);
      }
      paramInt = i;
      if (this.kSy != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kSy);
      }
      i = paramInt;
      if (this.kTg != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.kTg);
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
        if (this.euK == null) {
          throw new b("Not all required fields were included: AppId");
        }
        if (this.kVn == null) {
          throw new b("Not all required fields were included: AppName");
        }
        if (this.hPY == null) {
          throw new b("Not all required fields were included: UserName");
        }
        if (this.kSy != null) {
          break;
        }
        throw new b("Not all required fields were included: IconUrl");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        cnn localcnn = (cnn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcnn.euK = locala.xpH.readString();
          return 0;
        case 2: 
          localcnn.kVn = locala.xpH.readString();
          return 0;
        case 3: 
          localcnn.hPY = locala.xpH.readString();
          return 0;
        case 4: 
          localcnn.kSy = locala.xpH.readString();
          return 0;
        }
        localcnn.kTg = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cnn
 * JD-Core Version:    0.7.0.1
 */