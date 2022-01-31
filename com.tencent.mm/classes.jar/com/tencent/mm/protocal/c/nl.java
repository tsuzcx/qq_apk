package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class nl
  extends bly
{
  public int amount;
  public String bOT;
  public int iHq;
  public String iHr;
  public String sKU;
  public String sKV;
  public String sKX;
  public String sLh;
  public String swd;
  
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
      if (this.bOT != null) {
        paramVarArgs.d(4, this.bOT);
      }
      if (this.sKX != null) {
        paramVarArgs.d(5, this.sKX);
      }
      if (this.swd != null) {
        paramVarArgs.d(6, this.swd);
      }
      paramVarArgs.gB(7, this.amount);
      if (this.sLh != null) {
        paramVarArgs.d(8, this.sLh);
      }
      if (this.sKV != null) {
        paramVarArgs.d(9, this.sKV);
      }
      if (this.sKU != null) {
        paramVarArgs.d(10, this.sKU);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label780;
      }
    }
    label780:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.iHq);
      paramInt = i;
      if (this.iHr != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.iHr);
      }
      i = paramInt;
      if (this.bOT != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.bOT);
      }
      paramInt = i;
      if (this.sKX != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sKX);
      }
      i = paramInt;
      if (this.swd != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.swd);
      }
      i += d.a.a.a.gy(7, this.amount);
      paramInt = i;
      if (this.sLh != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sLh);
      }
      i = paramInt;
      if (this.sKV != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.sKV);
      }
      paramInt = i;
      if (this.sKU != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.sKU);
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
        nl localnl = (nl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
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
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localnl.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localnl.iHq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localnl.iHr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localnl.bOT = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localnl.sKX = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localnl.swd = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localnl.amount = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localnl.sLh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localnl.sKV = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localnl.sKU = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.nl
 * JD-Core Version:    0.7.0.1
 */