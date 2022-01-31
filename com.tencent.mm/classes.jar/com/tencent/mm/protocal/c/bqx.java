package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bqx
  extends bly
{
  public String bZd;
  public String color;
  public int end_time;
  public String iln;
  public String ilp;
  public String ilq;
  public String ilr;
  public String imA;
  public int imX;
  public int nZo;
  public int nZr;
  public String nZs;
  public String nZt;
  public String nZu;
  public String nZv;
  public String nZw;
  public boolean nZx;
  public String title;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.imX);
      if (this.iln != null) {
        paramVarArgs.d(3, this.iln);
      }
      if (this.bZd != null) {
        paramVarArgs.d(4, this.bZd);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      if (this.ilq != null) {
        paramVarArgs.d(6, this.ilq);
      }
      if (this.ilr != null) {
        paramVarArgs.d(7, this.ilr);
      }
      if (this.imA != null) {
        paramVarArgs.d(8, this.imA);
      }
      if (this.ilp != null) {
        paramVarArgs.d(9, this.ilp);
      }
      if (this.color != null) {
        paramVarArgs.d(10, this.color);
      }
      paramVarArgs.gB(11, this.nZo);
      paramVarArgs.gB(12, this.nZr);
      if (this.nZs != null) {
        paramVarArgs.d(13, this.nZs);
      }
      if (this.nZt != null) {
        paramVarArgs.d(14, this.nZt);
      }
      if (this.nZu != null) {
        paramVarArgs.d(19, this.nZu);
      }
      if (this.nZv != null) {
        paramVarArgs.d(21, this.nZv);
      }
      paramVarArgs.gB(22, this.end_time);
      if (this.nZw != null) {
        paramVarArgs.d(23, this.nZw);
      }
      paramVarArgs.aA(24, this.nZx);
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
      int i = paramInt + d.a.a.a.gy(2, this.imX);
      paramInt = i;
      if (this.iln != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.iln);
      }
      i = paramInt;
      if (this.bZd != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.bZd);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.title);
      }
      i = paramInt;
      if (this.ilq != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.ilq);
      }
      paramInt = i;
      if (this.ilr != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.ilr);
      }
      i = paramInt;
      if (this.imA != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.imA);
      }
      paramInt = i;
      if (this.ilp != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.ilp);
      }
      i = paramInt;
      if (this.color != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.color);
      }
      i = i + d.a.a.a.gy(11, this.nZo) + d.a.a.a.gy(12, this.nZr);
      paramInt = i;
      if (this.nZs != null) {
        paramInt = i + d.a.a.b.b.a.e(13, this.nZs);
      }
      i = paramInt;
      if (this.nZt != null) {
        i = paramInt + d.a.a.b.b.a.e(14, this.nZt);
      }
      paramInt = i;
      if (this.nZu != null) {
        paramInt = i + d.a.a.b.b.a.e(19, this.nZu);
      }
      i = paramInt;
      if (this.nZv != null) {
        i = paramInt + d.a.a.b.b.a.e(21, this.nZv);
      }
      i += d.a.a.a.gy(22, this.end_time);
      paramInt = i;
      if (this.nZw != null) {
        paramInt = i + d.a.a.b.b.a.e(23, this.nZw);
      }
      return paramInt + (d.a.a.b.b.a.dQ(24) + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx != null) {
          break;
        }
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bqx localbqx = (bqx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 20: 
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbqx.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbqx.imX = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbqx.iln = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbqx.bZd = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbqx.title = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localbqx.ilq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localbqx.ilr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localbqx.imA = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localbqx.ilp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localbqx.color = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localbqx.nZo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          localbqx.nZr = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 13: 
          localbqx.nZs = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          localbqx.nZt = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 19: 
          localbqx.nZu = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 21: 
          localbqx.nZv = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 22: 
          localbqx.end_time = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 23: 
          localbqx.nZw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbqx.nZx = ((d.a.a.a.a)localObject1).cUr();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bqx
 * JD-Core Version:    0.7.0.1
 */