package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bga
  extends bly
{
  public int lpJ;
  public String lpK;
  public int lpO;
  public int lpU;
  public int lpV;
  public int lpW;
  public com.tencent.mm.bv.b lpX;
  public int lpZ;
  public int lqc;
  public int sST;
  public long sSU;
  public LinkedList<bfs> syZ = new LinkedList();
  public long tAE;
  public int tAN;
  public int tAO;
  public LinkedList<bfs> tAP = new LinkedList();
  public String tAQ;
  public com.tencent.mm.bv.b tAR;
  public int tAS;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new d.a.a.b("Not all required fields were included: BaseResponse");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.sST);
      paramVarArgs.Y(3, this.sSU);
      paramVarArgs.gB(4, this.tAN);
      paramVarArgs.d(5, 8, this.syZ);
      paramVarArgs.gB(6, this.tAO);
      paramVarArgs.gB(7, this.lpU);
      paramVarArgs.gB(8, this.lpV);
      paramVarArgs.Y(9, this.tAE);
      paramVarArgs.gB(10, this.lpW);
      if (this.lpX != null) {
        paramVarArgs.b(11, this.lpX);
      }
      paramVarArgs.gB(12, this.lpO);
      paramVarArgs.gB(13, this.lpJ);
      if (this.lpK != null) {
        paramVarArgs.d(14, this.lpK);
      }
      paramVarArgs.gB(15, this.lpZ);
      paramVarArgs.d(16, 8, this.tAP);
      paramVarArgs.gB(17, this.lqc);
      if (this.tAQ != null) {
        paramVarArgs.d(18, this.tAQ);
      }
      if (this.tAR != null) {
        paramVarArgs.b(19, this.tAR);
      }
      paramVarArgs.gB(20, this.tAS);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1300;
      }
    }
    label1300:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.sST) + d.a.a.a.X(3, this.sSU) + d.a.a.a.gy(4, this.tAN) + d.a.a.a.c(5, 8, this.syZ) + d.a.a.a.gy(6, this.tAO) + d.a.a.a.gy(7, this.lpU) + d.a.a.a.gy(8, this.lpV) + d.a.a.a.X(9, this.tAE) + d.a.a.a.gy(10, this.lpW);
      paramInt = i;
      if (this.lpX != null) {
        paramInt = i + d.a.a.a.a(11, this.lpX);
      }
      i = paramInt + d.a.a.a.gy(12, this.lpO) + d.a.a.a.gy(13, this.lpJ);
      paramInt = i;
      if (this.lpK != null) {
        paramInt = i + d.a.a.b.b.a.e(14, this.lpK);
      }
      i = paramInt + d.a.a.a.gy(15, this.lpZ) + d.a.a.a.c(16, 8, this.tAP) + d.a.a.a.gy(17, this.lqc);
      paramInt = i;
      if (this.tAQ != null) {
        paramInt = i + d.a.a.b.b.a.e(18, this.tAQ);
      }
      i = paramInt;
      if (this.tAR != null) {
        i = paramInt + d.a.a.a.a(19, this.tAR);
      }
      return i + d.a.a.a.gy(20, this.tAS);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.syZ.clear();
        this.tAP.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx != null) {
          break;
        }
        throw new d.a.a.b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bga localbga = (bga)paramVarArgs[1];
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
            localbga.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbga.sST = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbga.sSU = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 4: 
          localbga.tAN = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfs();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bfs)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbga.syZ.add(localObject1);
            paramInt += 1;
          }
        case 6: 
          localbga.tAO = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localbga.lpU = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localbga.lpV = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localbga.tAE = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 10: 
          localbga.lpW = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          localbga.lpX = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        case 12: 
          localbga.lpO = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 13: 
          localbga.lpJ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 14: 
          localbga.lpK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 15: 
          localbga.lpZ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 16: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfs();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bfs)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbga.tAP.add(localObject1);
            paramInt += 1;
          }
        case 17: 
          localbga.lqc = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 18: 
          localbga.tAQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 19: 
          localbga.tAR = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        }
        localbga.tAS = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bga
 * JD-Core Version:    0.7.0.1
 */