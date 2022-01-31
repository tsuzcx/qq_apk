package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class aix
  extends bly
{
  public String kRN;
  public String kRZ;
  public String sAD;
  public LinkedList<ut> sAu = new LinkedList();
  public String sSy;
  public bmk swr;
  public LinkedList<vn> tda = new LinkedList();
  public String tfJ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tfJ == null) {
        throw new b("Not all required fields were included: BannerUrl");
      }
      if (this.kRZ == null) {
        throw new b("Not all required fields were included: Name");
      }
      if (this.kRN == null) {
        throw new b("Not all required fields were included: Desc");
      }
      if (this.sSy == null) {
        throw new b("Not all required fields were included: HeadUrl");
      }
      if (this.sAD == null) {
        throw new b("Not all required fields were included: BizName");
      }
      if (this.swr == null) {
        throw new b("Not all required fields were included: ReqBuf");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.tfJ != null) {
        paramVarArgs.d(2, this.tfJ);
      }
      if (this.kRZ != null) {
        paramVarArgs.d(3, this.kRZ);
      }
      if (this.kRN != null) {
        paramVarArgs.d(4, this.kRN);
      }
      if (this.sSy != null) {
        paramVarArgs.d(5, this.sSy);
      }
      if (this.sAD != null) {
        paramVarArgs.d(6, this.sAD);
      }
      paramVarArgs.d(7, 8, this.tda);
      if (this.swr != null)
      {
        paramVarArgs.gD(8, this.swr.btq());
        this.swr.a(paramVarArgs);
      }
      paramVarArgs.d(9, 8, this.sAu);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1203;
      }
    }
    label1203:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tfJ != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tfJ);
      }
      i = paramInt;
      if (this.kRZ != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kRZ);
      }
      paramInt = i;
      if (this.kRN != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kRN);
      }
      i = paramInt;
      if (this.sSy != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sSy);
      }
      paramInt = i;
      if (this.sAD != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sAD);
      }
      i = paramInt + d.a.a.a.c(7, 8, this.tda);
      paramInt = i;
      if (this.swr != null) {
        paramInt = i + d.a.a.a.gA(8, this.swr.btq());
      }
      return paramInt + d.a.a.a.c(9, 8, this.sAu);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tda.clear();
        this.sAu.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx == null) {
          throw new b("Not all required fields were included: BaseResponse");
        }
        if (this.tfJ == null) {
          throw new b("Not all required fields were included: BannerUrl");
        }
        if (this.kRZ == null) {
          throw new b("Not all required fields were included: Name");
        }
        if (this.kRN == null) {
          throw new b("Not all required fields were included: Desc");
        }
        if (this.sSy == null) {
          throw new b("Not all required fields were included: HeadUrl");
        }
        if (this.sAD == null) {
          throw new b("Not all required fields were included: BizName");
        }
        if (this.swr != null) {
          break;
        }
        throw new b("Not all required fields were included: ReqBuf");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        aix localaix = (aix)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaix.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaix.tfJ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localaix.kRZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localaix.kRN = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localaix.sSy = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localaix.sAD = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new vn();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((vn)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaix.tda.add(localObject1);
            paramInt += 1;
          }
        case 8: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaix.swr = ((bmk)localObject1);
            paramInt += 1;
          }
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ut();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ut)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localaix.sAu.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aix
 * JD-Core Version:    0.7.0.1
 */