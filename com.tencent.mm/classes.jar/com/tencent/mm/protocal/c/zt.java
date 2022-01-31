package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class zt
  extends com.tencent.mm.bv.a
{
  public String euK;
  public String kRZ;
  public String kSa;
  public String kSy;
  public String sPt;
  public aac sYW;
  public int sYX;
  public String sYY;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.euK == null) {
        throw new b("Not all required fields were included: AppId");
      }
      if (this.kRZ == null) {
        throw new b("Not all required fields were included: Name");
      }
      if (this.sPt == null) {
        throw new b("Not all required fields were included: Remark");
      }
      if (this.kSy == null) {
        throw new b("Not all required fields were included: IconUrl");
      }
      if (this.sYW == null) {
        throw new b("Not all required fields were included: DownloadInfo");
      }
      if (this.euK != null) {
        paramVarArgs.d(1, this.euK);
      }
      if (this.kRZ != null) {
        paramVarArgs.d(2, this.kRZ);
      }
      if (this.sPt != null) {
        paramVarArgs.d(3, this.sPt);
      }
      if (this.kSy != null) {
        paramVarArgs.d(4, this.kSy);
      }
      if (this.kSa != null) {
        paramVarArgs.d(5, this.kSa);
      }
      if (this.sYW != null)
      {
        paramVarArgs.gD(6, this.sYW.btq());
        this.sYW.a(paramVarArgs);
      }
      paramVarArgs.gB(7, this.sYX);
      if (this.sYY != null) {
        paramVarArgs.d(8, this.sYY);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.euK == null) {
        break label818;
      }
    }
    label818:
    for (int i = d.a.a.b.b.a.e(1, this.euK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kRZ != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kRZ);
      }
      i = paramInt;
      if (this.sPt != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sPt);
      }
      paramInt = i;
      if (this.kSy != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kSy);
      }
      i = paramInt;
      if (this.kSa != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.kSa);
      }
      paramInt = i;
      if (this.sYW != null) {
        paramInt = i + d.a.a.a.gA(6, this.sYW.btq());
      }
      i = paramInt + d.a.a.a.gy(7, this.sYX);
      paramInt = i;
      if (this.sYY != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sYY);
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
        if (this.euK == null) {
          throw new b("Not all required fields were included: AppId");
        }
        if (this.kRZ == null) {
          throw new b("Not all required fields were included: Name");
        }
        if (this.sPt == null) {
          throw new b("Not all required fields were included: Remark");
        }
        if (this.kSy == null) {
          throw new b("Not all required fields were included: IconUrl");
        }
        if (this.sYW != null) {
          break;
        }
        throw new b("Not all required fields were included: DownloadInfo");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        zt localzt = (zt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localzt.euK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localzt.kRZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localzt.sPt = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localzt.kSy = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localzt.kSa = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aac();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((aac)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localzt.sYW = ((aac)localObject1);
            paramInt += 1;
          }
        case 7: 
          localzt.sYX = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localzt.sYY = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.zt
 * JD-Core Version:    0.7.0.1
 */