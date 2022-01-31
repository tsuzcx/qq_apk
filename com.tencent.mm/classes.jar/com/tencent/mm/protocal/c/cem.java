package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cem
  extends bly
{
  public int lpO;
  public int lpU;
  public int lpV;
  public int lpZ;
  public long sSU;
  public LinkedList<ceg> syZ = new LinkedList();
  public com.tencent.mm.bv.b tAR;
  public long tTo;
  public int tTt;
  public int tTu;
  public int tTv;
  public int tTw;
  public LinkedList<ceg> tTx = new LinkedList();
  
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
      paramVarArgs.Y(2, this.tTo);
      paramVarArgs.Y(3, this.sSU);
      paramVarArgs.d(4, 8, this.syZ);
      paramVarArgs.gB(5, this.tTt);
      paramVarArgs.gB(6, this.lpU);
      paramVarArgs.gB(7, this.lpV);
      paramVarArgs.gB(8, this.lpO);
      paramVarArgs.gB(9, this.lpZ);
      paramVarArgs.gB(10, this.tTu);
      paramVarArgs.gB(11, this.tTv);
      if (this.tAR != null) {
        paramVarArgs.b(12, this.tAR);
      }
      paramVarArgs.gB(13, this.tTw);
      paramVarArgs.d(14, 8, this.tTx);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1009;
      }
    }
    label1009:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.X(2, this.tTo) + d.a.a.a.X(3, this.sSU) + d.a.a.a.c(4, 8, this.syZ) + d.a.a.a.gy(5, this.tTt) + d.a.a.a.gy(6, this.lpU) + d.a.a.a.gy(7, this.lpV) + d.a.a.a.gy(8, this.lpO) + d.a.a.a.gy(9, this.lpZ) + d.a.a.a.gy(10, this.tTu) + d.a.a.a.gy(11, this.tTv);
      paramInt = i;
      if (this.tAR != null) {
        paramInt = i + d.a.a.a.a(12, this.tAR);
      }
      return paramInt + d.a.a.a.gy(13, this.tTw) + d.a.a.a.c(14, 8, this.tTx);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.syZ.clear();
        this.tTx.clear();
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
        cem localcem = (cem)paramVarArgs[1];
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
            localcem.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcem.tTo = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 3: 
          localcem.sSU = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ceg();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ceg)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localcem.syZ.add(localObject1);
            paramInt += 1;
          }
        case 5: 
          localcem.tTt = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localcem.lpU = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localcem.lpV = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localcem.lpO = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localcem.lpZ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          localcem.tTu = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          localcem.tTv = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          localcem.tAR = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        case 13: 
          localcem.tTw = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ceg();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ceg)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localcem.tTx.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cem
 * JD-Core Version:    0.7.0.1
 */