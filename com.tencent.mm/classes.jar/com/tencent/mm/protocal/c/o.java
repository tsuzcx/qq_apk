package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class o
  extends bly
{
  public String bWt;
  public int iHq = 268513600;
  public String iHr = "请求不成功，请稍候再试";
  public String lRA;
  public String nyK;
  public a srK;
  public String srL;
  public String srs;
  
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
      if (this.lRA != null) {
        paramVarArgs.d(4, this.lRA);
      }
      if (this.bWt != null) {
        paramVarArgs.d(5, this.bWt);
      }
      if (this.nyK != null) {
        paramVarArgs.d(7, this.nyK);
      }
      if (this.srs != null) {
        paramVarArgs.d(8, this.srs);
      }
      if (this.srK != null)
      {
        paramVarArgs.gD(9, this.srK.btq());
        this.srK.a(paramVarArgs);
      }
      if (this.srL != null) {
        paramVarArgs.d(10, this.srL);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label835;
      }
    }
    label835:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.iHq);
      paramInt = i;
      if (this.iHr != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.iHr);
      }
      i = paramInt;
      if (this.lRA != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.lRA);
      }
      paramInt = i;
      if (this.bWt != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.bWt);
      }
      i = paramInt;
      if (this.nyK != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.nyK);
      }
      paramInt = i;
      if (this.srs != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.srs);
      }
      i = paramInt;
      if (this.srK != null) {
        i = paramInt + d.a.a.a.gA(9, this.srK.btq());
      }
      paramInt = i;
      if (this.srL != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.srL);
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
        o localo = (o)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 6: 
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
            localo.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localo.iHq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localo.iHr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localo.lRA = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localo.bWt = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localo.nyK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localo.srs = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new a();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((a)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localo.srK = ((a)localObject1);
            paramInt += 1;
          }
        }
        localo.srL = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.o
 * JD-Core Version:    0.7.0.1
 */