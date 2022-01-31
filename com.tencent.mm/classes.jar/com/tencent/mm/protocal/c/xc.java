package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class xc
  extends bly
{
  public int amount;
  public int bIC;
  public int cec;
  public int ced;
  public int iHq;
  public String iHr;
  public String lMg;
  public int lNp;
  public String lNq;
  public String lNr;
  public String lNs;
  public int lNt;
  public String lQp;
  public bjg sTP;
  
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
      paramVarArgs.gB(4, this.bIC);
      if (this.lMg != null) {
        paramVarArgs.d(5, this.lMg);
      }
      paramVarArgs.gB(6, this.cec);
      paramVarArgs.gB(7, this.ced);
      if (this.lQp != null) {
        paramVarArgs.d(8, this.lQp);
      }
      paramVarArgs.gB(9, this.amount);
      if (this.sTP != null)
      {
        paramVarArgs.gD(10, this.sTP.btq());
        this.sTP.a(paramVarArgs);
      }
      paramVarArgs.gB(11, this.lNp);
      if (this.lNq != null) {
        paramVarArgs.d(12, this.lNq);
      }
      if (this.lNr != null) {
        paramVarArgs.d(13, this.lNr);
      }
      if (this.lNs != null) {
        paramVarArgs.d(14, this.lNs);
      }
      paramVarArgs.gB(15, this.lNt);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1073;
      }
    }
    label1073:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.iHq);
      paramInt = i;
      if (this.iHr != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.iHr);
      }
      i = paramInt + d.a.a.a.gy(4, this.bIC);
      paramInt = i;
      if (this.lMg != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.lMg);
      }
      i = paramInt + d.a.a.a.gy(6, this.cec) + d.a.a.a.gy(7, this.ced);
      paramInt = i;
      if (this.lQp != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.lQp);
      }
      i = paramInt + d.a.a.a.gy(9, this.amount);
      paramInt = i;
      if (this.sTP != null) {
        paramInt = i + d.a.a.a.gA(10, this.sTP.btq());
      }
      i = paramInt + d.a.a.a.gy(11, this.lNp);
      paramInt = i;
      if (this.lNq != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.lNq);
      }
      i = paramInt;
      if (this.lNr != null) {
        i = paramInt + d.a.a.b.b.a.e(13, this.lNr);
      }
      paramInt = i;
      if (this.lNs != null) {
        paramInt = i + d.a.a.b.b.a.e(14, this.lNs);
      }
      return paramInt + d.a.a.a.gy(15, this.lNt);
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
        xc localxc = (xc)paramVarArgs[1];
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
            localxc.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localxc.iHq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localxc.iHr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localxc.bIC = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localxc.lMg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localxc.cec = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localxc.ced = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localxc.lQp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localxc.amount = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjg();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bjg)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localxc.sTP = ((bjg)localObject1);
            paramInt += 1;
          }
        case 11: 
          localxc.lNp = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          localxc.lNq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          localxc.lNr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          localxc.lNs = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localxc.lNt = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.xc
 * JD-Core Version:    0.7.0.1
 */