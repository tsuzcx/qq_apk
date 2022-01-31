package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bgj
  extends bly
{
  public int jxl;
  public String jxm;
  public int lpJ;
  public String lpK;
  public int lpY;
  public int sST;
  public long sSU;
  public int tAZ;
  public int tBb;
  public int tBc;
  
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
      paramVarArgs.gB(3, this.sST);
      paramVarArgs.Y(4, this.sSU);
      paramVarArgs.gB(5, this.tBb);
      paramVarArgs.gB(6, this.tAZ);
      paramVarArgs.gB(7, this.lpY);
      paramVarArgs.gB(8, this.tBc);
      paramVarArgs.gB(9, this.jxl);
      if (this.jxm != null) {
        paramVarArgs.d(10, this.jxm);
      }
      paramVarArgs.gB(11, this.lpJ);
      if (this.lpK != null) {
        paramVarArgs.d(12, this.lpK);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label735;
      }
    }
    label735:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(3, this.sST) + d.a.a.a.X(4, this.sSU) + d.a.a.a.gy(5, this.tBb) + d.a.a.a.gy(6, this.tAZ) + d.a.a.a.gy(7, this.lpY) + d.a.a.a.gy(8, this.tBc) + d.a.a.a.gy(9, this.jxl);
      paramInt = i;
      if (this.jxm != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.jxm);
      }
      i = paramInt + d.a.a.a.gy(11, this.lpJ);
      paramInt = i;
      if (this.lpK != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.lpK);
      }
      return paramInt;
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
        bgj localbgj = (bgj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
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
            localbgj.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 3: 
          localbgj.sST = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localbgj.sSU = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 5: 
          localbgj.tBb = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localbgj.tAZ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localbgj.lpY = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localbgj.tBc = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localbgj.jxl = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          localbgj.jxm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localbgj.lpJ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localbgj.lpK = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bgj
 * JD-Core Version:    0.7.0.1
 */