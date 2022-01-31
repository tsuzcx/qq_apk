package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cbi
  extends bly
{
  public int mPL;
  public int ndf;
  public int ndg;
  public int ndh;
  public int ndm;
  public long ndp;
  public String sGQ;
  public String sGU;
  public bml svF;
  public bml svG;
  public bml tQp;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tQp == null) {
        throw new b("Not all required fields were included: ClientImgId");
      }
      if (this.svF == null) {
        throw new b("Not all required fields were included: FromUserName");
      }
      if (this.svG == null) {
        throw new b("Not all required fields were included: ToUserName");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.ndm);
      if (this.tQp != null)
      {
        paramVarArgs.gD(3, this.tQp.btq());
        this.tQp.a(paramVarArgs);
      }
      if (this.svF != null)
      {
        paramVarArgs.gD(4, this.svF.btq());
        this.svF.a(paramVarArgs);
      }
      if (this.svG != null)
      {
        paramVarArgs.gD(5, this.svG.btq());
        this.svG.a(paramVarArgs);
      }
      paramVarArgs.gB(6, this.ndf);
      paramVarArgs.gB(7, this.ndg);
      paramVarArgs.gB(8, this.ndh);
      paramVarArgs.gB(9, this.mPL);
      paramVarArgs.Y(10, this.ndp);
      if (this.sGQ != null) {
        paramVarArgs.d(11, this.sGQ);
      }
      if (this.sGU != null) {
        paramVarArgs.d(12, this.sGU);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1200;
      }
    }
    label1200:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ndm);
      paramInt = i;
      if (this.tQp != null) {
        paramInt = i + d.a.a.a.gA(3, this.tQp.btq());
      }
      i = paramInt;
      if (this.svF != null) {
        i = paramInt + d.a.a.a.gA(4, this.svF.btq());
      }
      paramInt = i;
      if (this.svG != null) {
        paramInt = i + d.a.a.a.gA(5, this.svG.btq());
      }
      i = paramInt + d.a.a.a.gy(6, this.ndf) + d.a.a.a.gy(7, this.ndg) + d.a.a.a.gy(8, this.ndh) + d.a.a.a.gy(9, this.mPL) + d.a.a.a.X(10, this.ndp);
      paramInt = i;
      if (this.sGQ != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.sGQ);
      }
      i = paramInt;
      if (this.sGU != null) {
        i = paramInt + d.a.a.b.b.a.e(12, this.sGU);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx == null) {
          throw new b("Not all required fields were included: BaseResponse");
        }
        if (this.tQp == null) {
          throw new b("Not all required fields were included: ClientImgId");
        }
        if (this.svF == null) {
          throw new b("Not all required fields were included: FromUserName");
        }
        if (this.svG != null) {
          break;
        }
        throw new b("Not all required fields were included: ToUserName");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cbi localcbi = (cbi)paramVarArgs[1];
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
            localcbi.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcbi.ndm = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localcbi.tQp = ((bml)localObject1);
            paramInt += 1;
          }
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localcbi.svF = ((bml)localObject1);
            paramInt += 1;
          }
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localcbi.svG = ((bml)localObject1);
            paramInt += 1;
          }
        case 6: 
          localcbi.ndf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localcbi.ndg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localcbi.ndh = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localcbi.mPL = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          localcbi.ndp = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 11: 
          localcbi.sGQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localcbi.sGU = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cbi
 * JD-Core Version:    0.7.0.1
 */