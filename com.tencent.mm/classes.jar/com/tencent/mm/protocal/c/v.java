package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class v
  extends bly
{
  public int iHq = 268513600;
  public String iHr = "请求不成功，请稍候再试";
  public int srB;
  public String srL;
  public String srP;
  public long srQ;
  public int srR;
  public long srS;
  public int srT;
  public int srU;
  public int srV;
  public int srW;
  public long srX;
  public long srY;
  public long srZ;
  public String srq;
  public LinkedList<t> srv = new LinkedList();
  public int ssa;
  public String ssb;
  public int ssc;
  public long ssd;
  public int state;
  public String title;
  public int type;
  
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
      paramVarArgs.gB(2, this.iHq);
      if (this.iHr != null) {
        paramVarArgs.d(3, this.iHr);
      }
      if (this.srq != null) {
        paramVarArgs.d(4, this.srq);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      paramVarArgs.gB(6, this.type);
      if (this.srP != null) {
        paramVarArgs.d(7, this.srP);
      }
      paramVarArgs.Y(8, this.srQ);
      paramVarArgs.gB(9, this.srR);
      paramVarArgs.Y(10, this.srS);
      paramVarArgs.gB(11, this.srT);
      paramVarArgs.gB(12, this.state);
      paramVarArgs.gB(13, this.srU);
      paramVarArgs.gB(14, this.srV);
      paramVarArgs.gB(15, this.srB);
      paramVarArgs.gB(16, this.srW);
      paramVarArgs.Y(17, this.srX);
      paramVarArgs.Y(18, this.srY);
      paramVarArgs.Y(19, this.srZ);
      paramVarArgs.gB(20, this.ssa);
      if (this.srL != null) {
        paramVarArgs.d(21, this.srL);
      }
      paramVarArgs.d(22, 8, this.srv);
      if (this.ssb != null) {
        paramVarArgs.d(23, this.ssb);
      }
      paramVarArgs.gB(24, this.ssc);
      paramVarArgs.Y(25, this.ssd);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1443;
      }
    }
    label1443:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.iHq);
      paramInt = i;
      if (this.iHr != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.iHr);
      }
      i = paramInt;
      if (this.srq != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.srq);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.title);
      }
      i = paramInt + d.a.a.a.gy(6, this.type);
      paramInt = i;
      if (this.srP != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.srP);
      }
      i = paramInt + d.a.a.a.X(8, this.srQ) + d.a.a.a.gy(9, this.srR) + d.a.a.a.X(10, this.srS) + d.a.a.a.gy(11, this.srT) + d.a.a.a.gy(12, this.state) + d.a.a.a.gy(13, this.srU) + d.a.a.a.gy(14, this.srV) + d.a.a.a.gy(15, this.srB) + d.a.a.a.gy(16, this.srW) + d.a.a.a.X(17, this.srX) + d.a.a.a.X(18, this.srY) + d.a.a.a.X(19, this.srZ) + d.a.a.a.gy(20, this.ssa);
      paramInt = i;
      if (this.srL != null) {
        paramInt = i + d.a.a.b.b.a.e(21, this.srL);
      }
      i = paramInt + d.a.a.a.c(22, 8, this.srv);
      paramInt = i;
      if (this.ssb != null) {
        paramInt = i + d.a.a.b.b.a.e(23, this.ssb);
      }
      return paramInt + d.a.a.a.gy(24, this.ssc) + d.a.a.a.X(25, this.ssd);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.srv.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        v localv = (v)paramVarArgs[1];
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
            localv.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localv.iHq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localv.iHr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localv.srq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localv.title = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localv.type = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localv.srP = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localv.srQ = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 9: 
          localv.srR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          localv.srS = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 11: 
          localv.srT = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          localv.state = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 13: 
          localv.srU = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 14: 
          localv.srV = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 15: 
          localv.srB = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 16: 
          localv.srW = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 17: 
          localv.srX = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 18: 
          localv.srY = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 19: 
          localv.srZ = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 20: 
          localv.ssa = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 21: 
          localv.srL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 22: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new t();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((t)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localv.srv.add(localObject1);
            paramInt += 1;
          }
        case 23: 
          localv.ssb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 24: 
          localv.ssc = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localv.ssd = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.v
 * JD-Core Version:    0.7.0.1
 */