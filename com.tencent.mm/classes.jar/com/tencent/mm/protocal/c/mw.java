package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class mw
  extends bly
{
  public int nzh;
  public String nzi;
  public String nzj;
  public String qsJ;
  public LinkedList<awl> sKs = new LinkedList();
  public awl sKt;
  public String sKu;
  public boolean sKv;
  public String sKw;
  public int sKx;
  public aws sKy;
  public String url;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.url == null) {
        throw new b("Not all required fields were included: url");
      }
      if (this.sKt == null) {
        throw new b("Not all required fields were included: bottom_item");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      paramVarArgs.d(3, 8, this.sKs);
      if (this.sKt != null)
      {
        paramVarArgs.gD(4, this.sKt.btq());
        this.sKt.a(paramVarArgs);
      }
      if (this.qsJ != null) {
        paramVarArgs.d(5, this.qsJ);
      }
      if (this.sKu != null) {
        paramVarArgs.d(6, this.sKu);
      }
      paramVarArgs.aA(7, this.sKv);
      paramVarArgs.gB(8, this.nzh);
      if (this.sKw != null) {
        paramVarArgs.d(9, this.sKw);
      }
      if (this.nzi != null) {
        paramVarArgs.d(10, this.nzi);
      }
      if (this.nzj != null) {
        paramVarArgs.d(11, this.nzj);
      }
      paramVarArgs.gB(12, this.sKx);
      if (this.sKy != null)
      {
        paramVarArgs.gD(13, this.sKy.btq());
        this.sKy.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1256;
      }
    }
    label1256:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.url);
      }
      i += d.a.a.a.c(3, 8, this.sKs);
      paramInt = i;
      if (this.sKt != null) {
        paramInt = i + d.a.a.a.gA(4, this.sKt.btq());
      }
      i = paramInt;
      if (this.qsJ != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.qsJ);
      }
      paramInt = i;
      if (this.sKu != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sKu);
      }
      i = paramInt + (d.a.a.b.b.a.dQ(7) + 1) + d.a.a.a.gy(8, this.nzh);
      paramInt = i;
      if (this.sKw != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.sKw);
      }
      i = paramInt;
      if (this.nzi != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.nzi);
      }
      paramInt = i;
      if (this.nzj != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.nzj);
      }
      i = paramInt + d.a.a.a.gy(12, this.sKx);
      paramInt = i;
      if (this.sKy != null) {
        paramInt = i + d.a.a.a.gA(13, this.sKy.btq());
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sKs.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx == null) {
          throw new b("Not all required fields were included: BaseResponse");
        }
        if (this.url == null) {
          throw new b("Not all required fields were included: url");
        }
        if (this.sKt != null) {
          break;
        }
        throw new b("Not all required fields were included: bottom_item");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        mw localmw = (mw)paramVarArgs[1];
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
            localmw.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localmw.url = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awl();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awl)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localmw.sKs.add(localObject1);
            paramInt += 1;
          }
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awl();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awl)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localmw.sKt = ((awl)localObject1);
            paramInt += 1;
          }
        case 5: 
          localmw.qsJ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localmw.sKu = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localmw.sKv = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 8: 
          localmw.nzh = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localmw.sKw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localmw.nzi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localmw.nzj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          localmw.sKx = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aws();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aws)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localmw.sKy = ((aws)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.mw
 * JD-Core Version:    0.7.0.1
 */