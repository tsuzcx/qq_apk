package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class afi
  extends bly
{
  public bmk swr;
  public int tcZ;
  public LinkedList<vn> tda = new LinkedList();
  public vc tdb;
  public int tdc;
  public LinkedList<vc> tdd = new LinkedList();
  public int tde;
  public LinkedList<vg> tdf = new LinkedList();
  public int tdg;
  public LinkedList<ve> tdh = new LinkedList();
  public int tdi;
  public int tdj;
  public int tdk;
  public LinkedList<ve> tdl = new LinkedList();
  public String tdm;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.swr == null) {
        throw new b("Not all required fields were included: ReqBuf");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.swr != null)
      {
        paramVarArgs.gD(2, this.swr.btq());
        this.swr.a(paramVarArgs);
      }
      paramVarArgs.gB(3, this.tcZ);
      paramVarArgs.d(4, 8, this.tda);
      if (this.tdb != null)
      {
        paramVarArgs.gD(5, this.tdb.btq());
        this.tdb.a(paramVarArgs);
      }
      paramVarArgs.gB(6, this.tdc);
      paramVarArgs.d(7, 8, this.tdd);
      paramVarArgs.gB(8, this.tde);
      paramVarArgs.d(9, 8, this.tdf);
      paramVarArgs.gB(10, this.tdg);
      paramVarArgs.d(11, 8, this.tdh);
      paramVarArgs.gB(12, this.tdi);
      paramVarArgs.gB(13, this.tdj);
      paramVarArgs.gB(14, this.tdk);
      paramVarArgs.d(15, 8, this.tdl);
      if (this.tdm != null) {
        paramVarArgs.d(16, this.tdm);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1624;
      }
    }
    label1624:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.swr != null) {
        i = paramInt + d.a.a.a.gA(2, this.swr.btq());
      }
      i = i + d.a.a.a.gy(3, this.tcZ) + d.a.a.a.c(4, 8, this.tda);
      paramInt = i;
      if (this.tdb != null) {
        paramInt = i + d.a.a.a.gA(5, this.tdb.btq());
      }
      i = paramInt + d.a.a.a.gy(6, this.tdc) + d.a.a.a.c(7, 8, this.tdd) + d.a.a.a.gy(8, this.tde) + d.a.a.a.c(9, 8, this.tdf) + d.a.a.a.gy(10, this.tdg) + d.a.a.a.c(11, 8, this.tdh) + d.a.a.a.gy(12, this.tdi) + d.a.a.a.gy(13, this.tdj) + d.a.a.a.gy(14, this.tdk) + d.a.a.a.c(15, 8, this.tdl);
      paramInt = i;
      if (this.tdm != null) {
        paramInt = i + d.a.a.b.b.a.e(16, this.tdm);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tda.clear();
        this.tdd.clear();
        this.tdf.clear();
        this.tdh.clear();
        this.tdl.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx == null) {
          throw new b("Not all required fields were included: BaseResponse");
        }
        if (this.swr != null) {
          break;
        }
        throw new b("Not all required fields were included: ReqBuf");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        afi localafi = (afi)paramVarArgs[1];
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
            localafi.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localafi.swr = ((bmk)localObject1);
            paramInt += 1;
          }
        case 3: 
          localafi.tcZ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new vn();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((vn)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localafi.tda.add(localObject1);
            paramInt += 1;
          }
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new vc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((vc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localafi.tdb = ((vc)localObject1);
            paramInt += 1;
          }
        case 6: 
          localafi.tdc = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new vc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((vc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localafi.tdd.add(localObject1);
            paramInt += 1;
          }
        case 8: 
          localafi.tde = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new vg();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((vg)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localafi.tdf.add(localObject1);
            paramInt += 1;
          }
        case 10: 
          localafi.tdg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ve();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ve)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localafi.tdh.add(localObject1);
            paramInt += 1;
          }
        case 12: 
          localafi.tdi = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 13: 
          localafi.tdj = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 14: 
          localafi.tdk = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 15: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ve();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ve)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localafi.tdl.add(localObject1);
            paramInt += 1;
          }
        }
        localafi.tdm = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.afi
 * JD-Core Version:    0.7.0.1
 */